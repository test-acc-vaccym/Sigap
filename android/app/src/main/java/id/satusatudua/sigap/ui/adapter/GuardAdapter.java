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

package id.satusatudua.sigap.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import id.satusatudua.sigap.R;
import id.satusatudua.sigap.data.model.GuardCandidate;
import id.satusatudua.sigap.ui.adapter.viewholder.GuardViewHolder;
import id.zelory.benih.ui.adapter.BenihRecyclerAdapter;

/**
 * Created on : January 09, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class GuardAdapter extends BenihRecyclerAdapter<GuardCandidate, GuardViewHolder> {
    public GuardAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.item_helper_badge;
    }

    @Override
    public GuardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GuardViewHolder(getView(parent, viewType), itemClickListener, longItemClickListener);
    }

    @Override
    public void onBindViewHolder(GuardViewHolder holder, int position) {
        if (position == 0) {
            holder.setReporter(true);
        } else {
            holder.setReporter(false);
        }
        super.onBindViewHolder(holder, position);
    }
}
