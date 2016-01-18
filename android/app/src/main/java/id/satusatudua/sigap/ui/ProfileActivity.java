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

package id.satusatudua.sigap.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import id.satusatudua.sigap.R;
import id.satusatudua.sigap.ui.adapter.ProfilePagerAdapter;
import id.satusatudua.sigap.ui.fragment.HistoriesFragment;
import id.satusatudua.sigap.ui.fragment.ImportantContactFragment;
import id.zelory.benih.ui.BenihActivity;
import id.zelory.benih.ui.fragment.BenihFragment;

/**
 * Created on : January 18, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class ProfileActivity extends BenihActivity {

    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.view_pager) ViewPager viewPager;
    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.gender) TextView gender;
    @Bind(R.id.phone) TextView phoneNumber;
    @Bind(R.id.email) TextView emailAddress;

    private ProfilePagerAdapter profilePagerAdapter;

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_profile;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

        profilePagerAdapter = new ProfilePagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager.setAdapter(profilePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        collapsingToolbarLayout.setTitle("Rya Meyvriska");
        gender.setText("Laki - laki");
        phoneNumber.setText("081377668034");
        emailAddress.setText("rya.meyvriska@mail.ugm.ac.id");
    }

    private List<BenihFragment> getFragments() {
        return Arrays.asList(new HistoriesFragment(), new ImportantContactFragment());
    }
}
