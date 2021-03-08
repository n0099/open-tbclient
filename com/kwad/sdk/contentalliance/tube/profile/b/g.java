package com.kwad.sdk.contentalliance.tube.profile.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.detail.TubeDetailParam;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.model.TubeProfile;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    private RecyclerView b;
    private TextView c;
    private TubeInfo d;
    private com.kwad.sdk.lib.widget.recycler.d e;
    private View f;
    private com.kwad.sdk.contentalliance.tube.profile.e g = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            g.this.d = tubeProfileResultData.tubeProfile.tubeInfo;
            if (tubeProfileResultData.trendList == null || tubeProfileResultData.trendList.isEmpty()) {
                g.this.b.setVisibility(8);
                g.this.c.setVisibility(8);
                return;
            }
            a aVar = new a(g.this.o(), tubeProfileResultData.trendList);
            g.this.e = new com.kwad.sdk.lib.widget.recycler.d(aVar);
            g.this.e();
            g.this.b.setAdapter(g.this.e);
            g.this.e.a(g.this.b);
            g.this.b.setVisibility(0);
            g.this.c.setVisibility(0);
        }
    };

    /* loaded from: classes3.dex */
    private class a extends RecyclerView.Adapter<b> {
        private LayoutInflater b;
        private List<TubeProfile> c = new CopyOnWriteArrayList();

        public a(Context context, List<TubeProfile> list) {
            this.b = LayoutInflater.from(context);
            for (TubeProfile tubeProfile : list) {
                if (tubeProfile != null && tubeProfile.adTemplateList != null && !tubeProfile.adTemplateList.isEmpty()) {
                    this.c.add(tubeProfile);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            TubeDetailParam tubeDetailParam = new TubeDetailParam();
            tubeDetailParam.mTubeInfo = tubeInfo;
            tubeDetailParam.mAdTemplate = adTemplate;
            if (g.this.f5963a.f != null) {
                tubeDetailParam.mEntryScene = g.this.f5963a.f.entryScene;
            }
            com.kwad.sdk.contentalliance.tube.detail.b.a(g.this.o(), tubeDetailParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i, int i2, TubeProfile tubeProfile) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            if (g.this.f5963a.c != null) {
                tubeEpisodeDetailParam.mEntryScene = g.this.f5963a.c.mEntryScene;
            }
            tubeEpisodeDetailParam.mTubeId = tubeProfile.tubeInfo.tubeId;
            tubeEpisodeDetailParam.mTotalEpisodeCount = tubeProfile.tubeInfo.totalEpisodeCount;
            tubeEpisodeDetailParam.mSelectedPosition = i2;
            com.kwad.sdk.contentalliance.tube.episode.a.a(g.this.o(), tubeEpisodeDetailParam);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(this.b.inflate(R.layout.ksad_tube_trend_item_container, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(b bVar, final int i) {
            final TubeProfile tubeProfile = this.c.get(i);
            final TubeInfo tubeInfo = tubeProfile.tubeInfo;
            final com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = tubeProfile.adTemplateList;
            if (tubeInfo.tagList == null || tubeInfo.tagList.isEmpty()) {
                bVar.d.setVisibility(8);
            } else {
                bVar.d.setText(tubeInfo.tagList.get(0));
                bVar.d.setVisibility(0);
            }
            String string = g.this.o().getString(R.string.ksad_text_placeholder);
            if (TextUtils.isEmpty(tubeInfo.name)) {
                bVar.c.setText(string);
                bVar.g.setVisibility(8);
            } else {
                bVar.c.setText(tubeInfo.name);
                bVar.g.setVisibility(0);
            }
            String valueOf = tubeInfo.totalEpisodeCount < 0 ? "" : String.valueOf(tubeInfo.totalEpisodeCount);
            bVar.e.setText(ag.a(tubeInfo.authorName, string));
            if (tubeInfo.isFinished) {
                bVar.f.setText(String.format(g.this.o().getString(R.string.ksad_tube_update_finished_format_text), ag.a(valueOf, string)));
            } else {
                bVar.f.setText(String.format(g.this.o().getString(R.string.ksad_tube_update_unfinished_format_text), ag.a(valueOf, string)));
            }
            bVar.b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdTemplate adTemplate;
                    if (g.this.o() == null || tubeProfile.adTemplateList == null || tubeProfile.adTemplateList.isEmpty() || (adTemplate = tubeProfile.adTemplateList.get(0)) == null) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.b(adTemplate, "tube_trends_list", String.valueOf(i + 1));
                    a.this.a(tubeInfo, adTemplate);
                }
            });
            bVar.f5981a.a(tubeProfile);
            bVar.f5981a.setEpisodeItemClickListener(new TrendTubeScrollView.a() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.a.2
                @Override // com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.a
                public void a(AdTemplate adTemplate, int i2, View view) {
                    if (i2 != bVar2.size() - 1) {
                        com.kwad.sdk.core.report.e.a(adTemplate, 1, "tube_trends_list", String.valueOf(i + 1));
                        a.this.a(bVar2, i, i2, tubeProfile);
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(adTemplate, "tube_trends_list", String.valueOf(i + 1));
                    a.this.a(tubeInfo, tubeProfile.adTemplateList.get(0));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TrendTubeScrollView f5981a;
        public LinearLayout b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public ImageView g;

        public b(View view) {
            super(view);
            this.c = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_name);
            this.g = (ImageView) view.findViewById(R.id.ksad_tube_hot_tube_item_name_arrow);
            this.b = (LinearLayout) view.findViewById(R.id.ksad_tube_hot_tube_item_title_area);
            this.d = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_tag);
            this.e = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_author_name);
            this.f = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_update_info);
            this.f5981a = (TrendTubeScrollView) view.findViewById(R.id.ksad_tube_hot_tube_item_scroll_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f == null) {
            this.f = ao.a((ViewGroup) this.b, R.layout.ksad_tube_profile_no_more_layout, false);
        }
        TextView textView = (TextView) this.f.findViewById(R.id.ksad_tube_profile_no_more_tip_tv);
        if (!com.kwad.sdk.core.config.c.X()) {
            this.f.setVisibility(8);
            return;
        }
        if (!this.e.d(this.f)) {
            this.e.c(this.f);
        }
        this.f.setVisibility(0);
        textView.setText(q.a(o()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeTrendListPresenter", "TubeTrendListPresenter onBind");
        this.f5963a.e.add(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5963a.e.remove(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeTrendListPresenter", "TubeTrendListPresenter onCreate");
        this.c = (TextView) b(R.id.ksad_tube_hot_list_label);
        this.b = (RecyclerView) b(R.id.ksad_tube_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(o());
        linearLayoutManager.setOrientation(1);
        this.b.setLayoutManager(linearLayoutManager);
    }
}
