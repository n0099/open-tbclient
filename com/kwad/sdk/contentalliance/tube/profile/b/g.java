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
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f33286b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33287c;

    /* renamed from: d  reason: collision with root package name */
    public TubeInfo f33288d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f33289e;

    /* renamed from: f  reason: collision with root package name */
    public View f33290f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33291g = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            RecyclerView recyclerView;
            int i;
            g.this.f33288d = tubeProfileResultData.tubeProfile.tubeInfo;
            List<TubeProfile> list = tubeProfileResultData.trendList;
            if (list == null || list.isEmpty()) {
                recyclerView = g.this.f33286b;
                i = 8;
            } else {
                g gVar = g.this;
                a aVar = new a(gVar.o(), tubeProfileResultData.trendList);
                g.this.f33289e = new com.kwad.sdk.lib.widget.recycler.d(aVar);
                g.this.e();
                g.this.f33286b.setAdapter(g.this.f33289e);
                g.this.f33289e.a(g.this.f33286b);
                recyclerView = g.this.f33286b;
                i = 0;
            }
            recyclerView.setVisibility(i);
            g.this.f33287c.setVisibility(i);
        }
    };

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.Adapter<b> {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f33294b;

        /* renamed from: c  reason: collision with root package name */
        public List<TubeProfile> f33295c = new CopyOnWriteArrayList();

        public a(Context context, List<TubeProfile> list) {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar;
            this.f33294b = LayoutInflater.from(context);
            for (TubeProfile tubeProfile : list) {
                if (tubeProfile != null && (bVar = tubeProfile.adTemplateList) != null && !bVar.isEmpty()) {
                    this.f33295c.add(tubeProfile);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            TubeDetailParam tubeDetailParam = new TubeDetailParam();
            tubeDetailParam.mTubeInfo = tubeInfo;
            tubeDetailParam.mAdTemplate = adTemplate;
            if (((com.kwad.sdk.contentalliance.tube.profile.a.a) g.this).f33231a.f33237f != null) {
                tubeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) g.this).f33231a.f33237f.entryScene;
            }
            com.kwad.sdk.contentalliance.tube.detail.b.a(g.this.o(), tubeDetailParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i, int i2, TubeProfile tubeProfile) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            if (((com.kwad.sdk.contentalliance.tube.profile.a.a) g.this).f33231a.f33234c != null) {
                tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) g.this).f33231a.f33234c.mEntryScene;
            }
            TubeInfo tubeInfo = tubeProfile.tubeInfo;
            tubeEpisodeDetailParam.mTubeId = tubeInfo.tubeId;
            tubeEpisodeDetailParam.mTotalEpisodeCount = tubeInfo.totalEpisodeCount;
            tubeEpisodeDetailParam.mSelectedPosition = i2;
            com.kwad.sdk.contentalliance.tube.episode.a.a(g.this.o(), tubeEpisodeDetailParam);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(this.f33294b.inflate(R.layout.ksad_tube_trend_item_container, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(b bVar, final int i) {
            TextView textView;
            String format;
            final TubeProfile tubeProfile = this.f33295c.get(i);
            final TubeInfo tubeInfo = tubeProfile.tubeInfo;
            final com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = tubeProfile.adTemplateList;
            List<String> list = tubeInfo.tagList;
            if (list == null || list.isEmpty()) {
                bVar.f33308d.setVisibility(8);
            } else {
                bVar.f33308d.setText(tubeInfo.tagList.get(0));
                bVar.f33308d.setVisibility(0);
            }
            String string = g.this.o().getString(R.string.ksad_text_placeholder);
            if (TextUtils.isEmpty(tubeInfo.name)) {
                bVar.f33307c.setText(string);
                bVar.f33311g.setVisibility(8);
            } else {
                bVar.f33307c.setText(tubeInfo.name);
                bVar.f33311g.setVisibility(0);
            }
            int i2 = tubeInfo.totalEpisodeCount;
            String valueOf = i2 < 0 ? "" : String.valueOf(i2);
            bVar.f33309e.setText(ag.a(tubeInfo.authorName, string));
            if (tubeInfo.isFinished) {
                String string2 = g.this.o().getString(R.string.ksad_tube_update_finished_format_text);
                textView = bVar.f33310f;
                format = String.format(string2, ag.a(valueOf, string));
            } else {
                String string3 = g.this.o().getString(R.string.ksad_tube_update_unfinished_format_text);
                textView = bVar.f33310f;
                format = String.format(string3, ag.a(valueOf, string));
            }
            textView.setText(format);
            bVar.f33306b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.lib.widget.b<AdTemplate> bVar3;
                    AdTemplate adTemplate;
                    if (g.this.o() == null || (bVar3 = tubeProfile.adTemplateList) == null || bVar3.isEmpty() || (adTemplate = tubeProfile.adTemplateList.get(0)) == null) {
                        return;
                    }
                    com.kwad.sdk.core.report.e.b(adTemplate, "tube_trends_list", String.valueOf(i + 1));
                    a.this.a(tubeInfo, adTemplate);
                }
            });
            bVar.f33305a.a(tubeProfile);
            bVar.f33305a.setEpisodeItemClickListener(new TrendTubeScrollView.a() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.a.2
                @Override // com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.a
                public void a(AdTemplate adTemplate, int i3, View view) {
                    if (i3 != bVar2.size() - 1) {
                        com.kwad.sdk.core.report.e.a(adTemplate, 1, "tube_trends_list", String.valueOf(i + 1));
                        a.this.a(bVar2, i, i3, tubeProfile);
                        return;
                    }
                    com.kwad.sdk.core.report.e.a(adTemplate, "tube_trends_list", String.valueOf(i + 1));
                    a.this.a(tubeInfo, tubeProfile.adTemplateList.get(0));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33295c.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TrendTubeScrollView f33305a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f33306b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f33307c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f33308d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f33309e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f33310f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f33311g;

        public b(View view) {
            super(view);
            this.f33307c = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_name);
            this.f33311g = (ImageView) view.findViewById(R.id.ksad_tube_hot_tube_item_name_arrow);
            this.f33306b = (LinearLayout) view.findViewById(R.id.ksad_tube_hot_tube_item_title_area);
            this.f33308d = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_tag);
            this.f33309e = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_author_name);
            this.f33310f = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_update_info);
            this.f33305a = (TrendTubeScrollView) view.findViewById(R.id.ksad_tube_hot_tube_item_scroll_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33290f == null) {
            this.f33290f = ao.a((ViewGroup) this.f33286b, R.layout.ksad_tube_profile_no_more_layout, false);
        }
        TextView textView = (TextView) this.f33290f.findViewById(R.id.ksad_tube_profile_no_more_tip_tv);
        if (!com.kwad.sdk.core.config.c.X()) {
            this.f33290f.setVisibility(8);
            return;
        }
        if (!this.f33289e.d(this.f33290f)) {
            this.f33289e.c(this.f33290f);
        }
        this.f33290f.setVisibility(0);
        textView.setText(q.a(o()));
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeTrendListPresenter", "TubeTrendListPresenter onBind");
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a.f33236e.add(this.f33291g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a.f33236e.remove(this.f33291g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeTrendListPresenter", "TubeTrendListPresenter onCreate");
        this.f33287c = (TextView) b(R.id.ksad_tube_hot_list_label);
        this.f33286b = (RecyclerView) b(R.id.ksad_tube_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(o());
        linearLayoutManager.setOrientation(1);
        this.f33286b.setLayoutManager(linearLayoutManager);
    }
}
