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
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f9260b;
    private TubeInfo c;
    private RecyclerView.Adapter d;
    private com.kwad.sdk.contentalliance.tube.profile.e e = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            b.this.c = tubeProfileResultData.tubeProfile.tubeInfo;
            b.this.d = new a(b.this.o(), tubeProfileResultData.tubeProfile);
            b.this.f9260b.setAdapter(b.this.d);
            b.this.f9260b.setVisibility(0);
        }
    };

    /* loaded from: classes5.dex */
    private class a extends RecyclerView.Adapter<C1099b> {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater f9263b;
        private com.kwad.sdk.lib.widget.b<AdTemplate> c;

        public a(Context context, TubeProfile tubeProfile) {
            this.f9263b = LayoutInflater.from(context);
            if (tubeProfile.adTemplateList == null) {
                this.c = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList());
            } else if (tubeProfile.adTemplateList.size() > 6) {
                this.c = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList.subList(0, 6)));
            } else {
                this.c = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList));
            }
        }

        private AdTemplate a(int i) {
            return this.c.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            TubeDetailParam tubeDetailParam = new TubeDetailParam();
            tubeDetailParam.mTubeInfo = tubeInfo;
            tubeDetailParam.mAdTemplate = adTemplate;
            if (b.this.f9253a.f != null) {
                tubeDetailParam.mEntryScene = b.this.f9253a.f.entryScene;
            }
            com.kwad.sdk.contentalliance.tube.detail.b.a(b.this.o(), tubeDetailParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            if (b.this.f9253a.c != null) {
                tubeEpisodeDetailParam.mEntryScene = b.this.f9253a.c.mEntryScene;
            }
            tubeEpisodeDetailParam.mTubeId = b.this.c.tubeId;
            tubeEpisodeDetailParam.mTotalEpisodeCount = b.this.c.totalEpisodeCount;
            tubeEpisodeDetailParam.mSelectedPosition = i;
            com.kwad.sdk.contentalliance.tube.episode.a.a(b.this.o(), tubeEpisodeDetailParam);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public C1099b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C1099b((EpisodePhotoView) this.f9263b.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C1099b c1099b, final int i) {
            com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "position =" + i);
            final AdTemplate a2 = a(i);
            c1099b.f9268a.setRatio(1.29f);
            c1099b.f9268a.a(i, b.this.c.tubeId);
            c1099b.f9268a.setTemplateData(a2);
            if (i != 5 || b.this.c.totalEpisodeCount <= 6) {
                c1099b.f9268a.setLookMoreVisibility(false);
                c1099b.f9268a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.core.report.e.a(a2, 1, "current_tube_list", (String) null);
                        a.this.a(a.this.c, i);
                    }
                });
            } else {
                c1099b.f9268a.setLookMoreVisibility(true);
                c1099b.f9268a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.core.report.e.a(a2, "current_tube_list", (String) null);
                        a.this.a(b.this.c, a2);
                    }
                });
            }
            c1099b.f9268a.setId(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.tube.profile.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1099b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f9268a;

        public C1099b(View view) {
            super(view);
            this.f9268a = (EpisodePhotoView) view;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onBind");
        this.f9253a.e.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9253a.e.remove(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onCreate");
        this.f9260b = (RecyclerView) b(R.id.ksad_tube_grid);
        this.f9260b.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        this.f9260b.setLayoutManager(new GridLayoutManager(o(), 3));
    }
}
