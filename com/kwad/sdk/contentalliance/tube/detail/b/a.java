package com.kwad.sdk.contentalliance.tube.detail.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.view.EpisodePhotoView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TubeInfo f33167b;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f33169d;

    /* renamed from: e  reason: collision with root package name */
    public b f33170e;

    /* renamed from: f  reason: collision with root package name */
    public View f33171f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33172g;

    /* renamed from: h  reason: collision with root package name */
    public LottieAnimationView f33173h;
    public StaggeredGridLayoutManager i;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f33168c = new AtomicBoolean(false);
    public C0371a j = new C0371a();
    public b.a k = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
            if (z) {
                a.this.e();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
            if (z) {
                a.this.f33168c.set(false);
                if (com.kwad.sdk.core.network.f.f33868a.k == i) {
                    p.a(a.this.o());
                } else if (com.kwad.sdk.core.network.f.f33874g.k != i) {
                    p.b(a.this.o());
                }
                a.this.f();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onSuccess  tubeFeedData item size=" + adResultData.adTemplateList.size());
            a.this.f33170e.a(adResultData.adTemplateList);
            if (a.this.f33170e.a() < a.this.f33167b.totalEpisodeCount || !com.kwad.sdk.core.config.c.X()) {
                a.this.f33172g.setVisibility(4);
                return;
            }
            a.this.f33172g.setVisibility(0);
            a.this.f33172g.setText(q.a(a.this.o()));
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            if (z) {
                a.this.f33168c.set(false);
                a.this.f();
            }
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.tube.detail.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0371a extends RecyclerView.OnScrollListener {
        public C0371a() {
        }

        private int a(int[] iArr) {
            int length = iArr.length;
            int i = Integer.MIN_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] > i) {
                    i = iArr[i2];
                }
            }
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onScrolled dx=" + i + " dy=" + i2);
            boolean z = i2 > 0;
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", " manager.getSpanCount()=" + staggeredGridLayoutManager.getSpanCount());
            int a2 = a(staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]));
            int itemCount = staggeredGridLayoutManager.getItemCount();
            if (!z || a2 != itemCount - 1 || a.this.f33170e.a() >= a.this.f33167b.totalEpisodeCount || a.this.f33168c.getAndSet(true)) {
                return;
            }
            recyclerView.stopScroll();
            a aVar = a.this;
            aVar.a(aVar.f33170e.b());
        }
    }

    /* loaded from: classes6.dex */
    public class b extends RecyclerView.Adapter<c> {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f33176a;

        /* renamed from: c  reason: collision with root package name */
        public LayoutInflater f33178c;

        public b(a aVar, Context context) {
            this(context, null);
        }

        public b(Context context, List<AdTemplate> list) {
            this.f33176a = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList());
            this.f33178c = LayoutInflater.from(context);
            a(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(this.f33176a);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33157a.f33159b.mEntryScene;
            tubeEpisodeDetailParam.mTubeId = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33157a.f33159b.getTubeId();
            if (((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33157a.f33159b.mTubeInfo != null) {
                tubeEpisodeDetailParam.mTotalEpisodeCount = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33157a.f33159b.mTubeInfo.totalEpisodeCount;
            }
            tubeEpisodeDetailParam.mSelectedPosition = i;
            com.kwad.sdk.contentalliance.tube.episode.a.a(a.this.o(), tubeEpisodeDetailParam);
        }

        public int a() {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f33176a;
            if (bVar != null) {
                return bVar.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c((EpisodePhotoView) this.f33178c.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, final int i) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "position =" + i);
            final AdTemplate adTemplate = this.f33176a.get(i);
            cVar.f33182a.setRatio(1.29f);
            cVar.f33182a.a(i, a.this.f33167b.tubeId);
            cVar.f33182a.setTemplateData(adTemplate);
            cVar.f33182a.setLookMoreVisibility(false);
            cVar.f33182a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.e.b(adTemplate, 1);
                    b.this.a(i);
                }
            });
            cVar.f33182a.setId(i);
        }

        public void a(List<AdTemplate> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            int size = this.f33176a.size();
            this.f33176a.addAll(list);
            notifyItemRangeChanged(size + 1, list.size());
        }

        public long b() {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f33176a;
            if (bVar == null || bVar.isEmpty()) {
                return 0L;
            }
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = this.f33176a;
            return com.kwad.sdk.core.response.b.d.k(bVar2.get(bVar2.size() - 1).photoInfo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33176a.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f33182a;

        public c(View view) {
            super(view);
            this.f33182a = (EpisodePhotoView) view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        for (com.kwad.sdk.contentalliance.tube.detail.a aVar : ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33162e) {
            aVar.a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f33173h.c()) {
            this.f33173h.b();
        }
        this.f33173h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!this.f33173h.c()) {
            this.f33173h.d();
        }
        this.f33173h.setVisibility(4);
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33167b = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33159b.mTubeInfo;
        this.f33169d.addOnScrollListener(this.j);
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33161d.add(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33161d.remove(this.k);
        this.f33169d.removeOnScrollListener(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "EpisodeGridPresenter onCreate");
        RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_recycler_view);
        this.f33169d = recyclerView;
        recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        this.i = staggeredGridLayoutManager;
        this.f33169d.setLayoutManager(staggeredGridLayoutManager);
        b bVar = new b(this, o());
        this.f33170e = bVar;
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
        if (this.f33171f == null) {
            View a2 = ao.a((ViewGroup) this.f33169d, R.layout.ksad_tube_detail_grid_footer, false);
            this.f33171f = a2;
            TextView textView = (TextView) a2.findViewById(R.id.ksad_tube_detail_grid_no_more_tip);
            this.f33172g = textView;
            textView.setVisibility(4);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f33171f.findViewById(R.id.ksad_tube_detail_grid_loading);
            this.f33173h = lottieAnimationView;
            lottieAnimationView.setVisibility(4);
            int i = R.raw.ksad_detail_loading_amin_new;
            this.f33173h.setRepeatMode(1);
            this.f33173h.setRepeatCount(-1);
            this.f33173h.setAnimation(i);
        }
        if (!dVar.d(this.f33171f)) {
            dVar.c(this.f33171f);
        }
        this.f33171f.setVisibility(0);
        this.f33169d.setAdapter(dVar);
        this.f33169d.setVisibility(0);
        dVar.a(this.f33169d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
    }
}
