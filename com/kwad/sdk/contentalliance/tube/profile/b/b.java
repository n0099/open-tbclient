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
    public RecyclerView f33242b;

    /* renamed from: c  reason: collision with root package name */
    public TubeInfo f33243c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView.Adapter f33244d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33245e = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            b.this.f33243c = tubeProfileResultData.tubeProfile.tubeInfo;
            b bVar = b.this;
            bVar.f33244d = new a(bVar.o(), tubeProfileResultData.tubeProfile);
            b bVar2 = b.this;
            bVar2.f33242b.setAdapter(bVar2.f33244d);
            b.this.f33242b.setVisibility(0);
        }
    };

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.Adapter<C0372b> {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f33248b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f33249c;

        public a(Context context, TubeProfile tubeProfile) {
            this.f33248b = LayoutInflater.from(context);
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = tubeProfile.adTemplateList;
            this.f33249c = bVar == null ? new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList()) : bVar.size() > 6 ? new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList.subList(0, 6))) : new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList));
        }

        private AdTemplate a(int i) {
            return this.f33249c.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            TubeDetailParam tubeDetailParam = new TubeDetailParam();
            tubeDetailParam.mTubeInfo = tubeInfo;
            tubeDetailParam.mAdTemplate = adTemplate;
            if (((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33230a.f33236f != null) {
                tubeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33230a.f33236f.entryScene;
            }
            com.kwad.sdk.contentalliance.tube.detail.b.a(b.this.o(), tubeDetailParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            if (((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33230a.f33233c != null) {
                tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) b.this).f33230a.f33233c.mEntryScene;
            }
            tubeEpisodeDetailParam.mTubeId = b.this.f33243c.tubeId;
            tubeEpisodeDetailParam.mTotalEpisodeCount = b.this.f33243c.totalEpisodeCount;
            tubeEpisodeDetailParam.mSelectedPosition = i;
            com.kwad.sdk.contentalliance.tube.episode.a.a(b.this.o(), tubeEpisodeDetailParam);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public C0372b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0372b((EpisodePhotoView) this.f33248b.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0372b c0372b, final int i) {
            EpisodePhotoView episodePhotoView;
            View.OnClickListener onClickListener;
            com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "position =" + i);
            final AdTemplate a2 = a(i);
            c0372b.f33255a.setRatio(1.29f);
            c0372b.f33255a.a(i, b.this.f33243c.tubeId);
            c0372b.f33255a.setTemplateData(a2);
            if (i != 5 || b.this.f33243c.totalEpisodeCount <= 6) {
                c0372b.f33255a.setLookMoreVisibility(false);
                episodePhotoView = c0372b.f33255a;
                onClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.core.report.e.a(a2, 1, "current_tube_list", (String) null);
                        a aVar = a.this;
                        aVar.a(aVar.f33249c, i);
                    }
                };
            } else {
                c0372b.f33255a.setLookMoreVisibility(true);
                episodePhotoView = c0372b.f33255a;
                onClickListener = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.core.report.e.a(a2, "current_tube_list", (String) null);
                        a aVar = a.this;
                        aVar.a(b.this.f33243c, a2);
                    }
                };
            }
            episodePhotoView.setOnClickListener(onClickListener);
            c0372b.f33255a.setId(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33249c.size();
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.tube.profile.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0372b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f33255a;

        public C0372b(View view) {
            super(view);
            this.f33255a = (EpisodePhotoView) view;
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onBind");
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33230a.f33235e.add(this.f33245e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33230a.f33235e.remove(this.f33245e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onCreate");
        RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_grid);
        this.f33242b = recyclerView;
        recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        this.f33242b.setLayoutManager(new GridLayoutManager(o(), 3));
    }
}
