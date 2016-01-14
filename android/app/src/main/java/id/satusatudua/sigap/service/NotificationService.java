/*
 * Copyright (c) 2015 SatuSatuDua.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package id.satusatudua.sigap.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

import com.firebase.client.DataSnapshot;

import id.satusatudua.sigap.R;
import id.satusatudua.sigap.SigapApp;
import id.satusatudua.sigap.data.api.FirebaseApi;
import id.satusatudua.sigap.data.local.CacheManager;
import id.satusatudua.sigap.ui.ConfirmTrustedOfActivity;
import id.satusatudua.sigap.util.RxFirebase;
import id.zelory.benih.util.BenihScheduler;
import id.zelory.benih.util.BenihUtils;
import timber.log.Timber;

/**
 * Created on : January 13, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class NotificationService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.tag(getClass().getSimpleName());
        Timber.d(getClass().getSimpleName() + " is creating");

        listenTrustedOf();
    }

    private void listenTrustedOf() {
        RxFirebase.observeChildAdded(FirebaseApi.pluck().trustedOf(CacheManager.pluck().getCurrentUser().getUserId()))
                .compose(BenihScheduler.pluck().applySchedulers(BenihScheduler.Type.IO))
                .map(firebaseChildEvent -> firebaseChildEvent.snapshot)
                .filter(dataSnapshot -> dataSnapshot.child("status").getValue().equals("MENUNGGU"))
                .map(DataSnapshot::getKey)
                .subscribe(this::showNotification, throwable -> Timber.e(throwable.getMessage()));
    }

    private void showNotification(String userId) {
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                                                                ConfirmTrustedOfActivity.generateIntent(this, userId),
                                                                PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Sigap")
                .setContentText("Seseorang menambahkanmu kedalam kontak terpercayanya!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setVibrate(new long[]{100, 300, 500, 1000})
                .setAutoCancel(true)
                .setStyle(new android.support
                        .v4.app.NotificationCompat
                        .BigTextStyle()
                                  .bigText("Seseorang menambahkanmu kedalam kontak terpercayanya!, klik untuk mengkonfirmasi."))
                .setContentIntent(pendingIntent)
                .build();

        NotificationManagerCompat
                .from(SigapApp.pluck().getApplicationContext())
                .notify(BenihUtils.randInt(1, Integer.MAX_VALUE), notification);
    }
}