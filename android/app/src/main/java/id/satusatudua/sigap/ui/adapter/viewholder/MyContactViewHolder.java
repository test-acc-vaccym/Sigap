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

package id.satusatudua.sigap.ui.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import id.satusatudua.sigap.R;
import id.satusatudua.sigap.data.model.ImportantContact;
import id.satusatudua.sigap.presenter.BookmarkPresenter;
import id.zelory.benih.ui.adapter.viewholder.BenihItemViewHolder;

import static id.zelory.benih.ui.adapter.BenihRecyclerAdapter.OnItemClickListener;
import static id.zelory.benih.ui.adapter.BenihRecyclerAdapter.OnLongItemClickListener;

/**
 * Created on : January 18, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class MyContactViewHolder extends BenihItemViewHolder<ImportantContact> implements
        BookmarkPresenter.View {

    @Bind(R.id.name) TextView name;
    @Bind(R.id.rate) TextView rate;
    @Bind(R.id.date) TextView date;
    @Bind(R.id.icon_bookmarked) ImageView bookmarkedIcon;

    private BookmarkPresenter bookmarkPresenter;

    public MyContactViewHolder(View itemView, OnItemClickListener itemClickListener, OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        bookmarkPresenter = new BookmarkPresenter(this);
    }

    @Override
    public void bind(ImportantContact importantContact) {
        name.setText(importantContact.getName());
        rate.setText(String.format("%.1f", importantContact.getAvgRate()));
        date.setText(new SimpleDateFormat("dd/MM/yyyy").format(importantContact.getCreatedAt()));
        bookmarkedIcon.setImageResource(importantContact.isBookmarked() ? R.drawable.ic_star : R.drawable.ic_star_line);
        bookmarkedIcon.setOnClickListener(v -> {
            if (importantContact.isBookmarked()) {
                bookmarkPresenter.unBookmark(importantContact);
            } else {
                bookmarkPresenter.bookmark(importantContact);
            }
        });
    }

    @Override
    public void onBookmarked(ImportantContact contact) {
        bookmarkedIcon.setImageResource(R.drawable.ic_star);
    }

    @Override
    public void onUnBookmark(ImportantContact contact) {
        bookmarkedIcon.setImageResource(R.drawable.ic_star_line);
    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
