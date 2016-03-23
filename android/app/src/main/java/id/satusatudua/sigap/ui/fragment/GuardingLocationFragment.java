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

package id.satusatudua.sigap.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import id.satusatudua.sigap.R;
import id.zelory.benih.ui.fragment.BenihFragment;

/**
 * Created on : March 23, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class GuardingLocationFragment extends BenihFragment {

    public static GuardingLocationFragment newInstance() {
        GuardingLocationFragment fragment = new GuardingLocationFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_guarding_location;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState) {

    }
}
