package com.kwad.sdk.contentalliance.tube.profile.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.detail.TubeDetailParam;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.model.TubeProfile;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.view.EpisodePhotoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f33856b;

    /* renamed from: c  reason: collision with root package name */
    public TubeInfo f33857c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView.Adapter f33858d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33859e = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            b.this.f33857c = tubeProfileResultData.tubeProfile.tubeInfo;
            b bVar = b.this;
            bVar.f33858d = new a(bVar.o(), tubeProfileResultData.tubeProfile);
            b bVar2 = b.this;
            bVar2.f33856b.setAdapter(bVar2.f33858d);
            b.this.f33856b.setVisibility(0);
        }
    };

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.Adapter<C0373b> {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f33862b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f33863c;

        public a(Context context, TubeProfile tubeProfile) {
            this.f33862b = LayoutInflater.from(context);
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = tubeProfile.adTemplateList;
            this.f33863c = bVar == null ? new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList()) : bVar.size() > 6 ? new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList.subList(0, 6))) : new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList));
        }

        private AdTemplate a(int i2) {
            return this.f33863c.get(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            TubeDetailParam tubeDetailParam = new TubeDetailParam();
            tubeDetailParam.mTubeInfo = tubeInfo;
            tubeDetailParam.mAdTemplate = adTemplate;
            if (((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33844a.f33850f != null) {
                tubeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33844a.f33850f.entryScene;
            }
            com.kwad.sdk.contentalliance.tube.detail.b.a(b.this.o(), tubeDetailParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i2) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            if (((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33844a.f33847c != null) {
                tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33844a.f33847c.mEntryScene;
            }
            tubeEpisodeDetailParam.mTubeId = b.this.f33857c.tubeId;
            tubeEpisodeDetailParam.mTotalEpisodeCount = b.this.f33857c.totalEpisodeCount;
            tubeEpisodeDetailParam.mSelectedPosition = i2;
            com.kwad.sdk.contentalliance.tube.episode.a.a(b.this.o(), tubeEpisodeDetailParam);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public C0373b onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C0373b((EpisodePhotoView) this.f33862b.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0373b c0373b, final int i2) {
            EpisodePhotoView episodePhotoView;
            View.OnClickListener onClickListener;
            com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "position =" + i2);
            final AdTemplate a2 = a(i2);
            c0373b.f33869a.setRatio(1.29f);
            c0373b.f33869a.a(i2, b.this.f33857c.tubeId);
            c0373b.f33869a.setTemplateData(a2);
            if (i2 != 5 || b.this.f33857c.totalEpisodeCount <= 6) {
                c0373b.f33869a.setLookMoreVisibility(false);
                episodePhotoView = c0373b.f33869a;
                onClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.core.report.e.a(a2, 1, "current_tube_list", (String) null);
                        a aVar = a.this;
                        aVar.a(aVar.f33863c, i2);
                    }
                };
            } else {
                c0373b.f33869a.setLookMoreVisibility(true);
                episodePhotoView = c0373b.f33869a;
                onClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.core.report.e.a(a2, "current_tube_list", (String) null);
                        a aVar = a.this;
                        aVar.a(b.this.f33857c, a2);
                    }
                };
            }
            episodePhotoView.setOnClickListener(onClickListener);
            c0373b.f33869a.setId(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33863c.size();
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.tube.profile.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0373b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f33869a;

        public C0373b(View view) {
            super(view);
            this.f33869a = (EpisodePhotoView) view;
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onBind");
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a.f33849e.add(this.f33859e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a.f33849e.remove(this.f33859e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onCreate");
        RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_grid);
        this.f33856b = recyclerView;
        recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        this.f33856b.setLayoutManager(new GridLayoutManager(o(), 3));
    }
}
