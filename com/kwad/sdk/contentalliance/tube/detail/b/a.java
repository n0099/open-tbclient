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
    public TubeInfo f33457b;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f33459d;

    /* renamed from: e  reason: collision with root package name */
    public b f33460e;

    /* renamed from: f  reason: collision with root package name */
    public View f33461f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33462g;

    /* renamed from: h  reason: collision with root package name */
    public LottieAnimationView f33463h;
    public StaggeredGridLayoutManager i;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f33458c = new AtomicBoolean(false);
    public C0386a j = new C0386a();
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
                a.this.f33458c.set(false);
                if (com.kwad.sdk.core.network.f.f34158a.k == i) {
                    p.a(a.this.o());
                } else if (com.kwad.sdk.core.network.f.f34164g.k != i) {
                    p.b(a.this.o());
                }
                a.this.f();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onSuccess  tubeFeedData item size=" + adResultData.adTemplateList.size());
            a.this.f33460e.a(adResultData.adTemplateList);
            if (a.this.f33460e.a() < a.this.f33457b.totalEpisodeCount || !com.kwad.sdk.core.config.c.X()) {
                a.this.f33462g.setVisibility(4);
                return;
            }
            a.this.f33462g.setVisibility(0);
            a.this.f33462g.setText(q.a(a.this.o()));
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            if (z) {
                a.this.f33458c.set(false);
                a.this.f();
            }
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.tube.detail.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0386a extends RecyclerView.OnScrollListener {
        public C0386a() {
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
            if (!z || a2 != itemCount - 1 || a.this.f33460e.a() >= a.this.f33457b.totalEpisodeCount || a.this.f33458c.getAndSet(true)) {
                return;
            }
            recyclerView.stopScroll();
            a aVar = a.this;
            aVar.a(aVar.f33460e.b());
        }
    }

    /* loaded from: classes6.dex */
    public class b extends RecyclerView.Adapter<c> {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f33466a;

        /* renamed from: c  reason: collision with root package name */
        public LayoutInflater f33468c;

        public b(a aVar, Context context) {
            this(context, null);
        }

        public b(Context context, List<AdTemplate> list) {
            this.f33466a = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList());
            this.f33468c = LayoutInflater.from(context);
            a(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(this.f33466a);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33447a.f33449b.mEntryScene;
            tubeEpisodeDetailParam.mTubeId = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33447a.f33449b.getTubeId();
            if (((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33447a.f33449b.mTubeInfo != null) {
                tubeEpisodeDetailParam.mTotalEpisodeCount = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33447a.f33449b.mTubeInfo.totalEpisodeCount;
            }
            tubeEpisodeDetailParam.mSelectedPosition = i;
            com.kwad.sdk.contentalliance.tube.episode.a.a(a.this.o(), tubeEpisodeDetailParam);
        }

        public int a() {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f33466a;
            if (bVar != null) {
                return bVar.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c((EpisodePhotoView) this.f33468c.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, final int i) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "position =" + i);
            final AdTemplate adTemplate = this.f33466a.get(i);
            cVar.f33472a.setRatio(1.29f);
            cVar.f33472a.a(i, a.this.f33457b.tubeId);
            cVar.f33472a.setTemplateData(adTemplate);
            cVar.f33472a.setLookMoreVisibility(false);
            cVar.f33472a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.e.b(adTemplate, 1);
                    b.this.a(i);
                }
            });
            cVar.f33472a.setId(i);
        }

        public void a(List<AdTemplate> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            int size = this.f33466a.size();
            this.f33466a.addAll(list);
            notifyItemRangeChanged(size + 1, list.size());
        }

        public long b() {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f33466a;
            if (bVar == null || bVar.isEmpty()) {
                return 0L;
            }
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = this.f33466a;
            return com.kwad.sdk.core.response.b.d.k(bVar2.get(bVar2.size() - 1).photoInfo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33466a.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f33472a;

        public c(View view) {
            super(view);
            this.f33472a = (EpisodePhotoView) view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        for (com.kwad.sdk.contentalliance.tube.detail.a aVar : ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33452e) {
            aVar.a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f33463h.c()) {
            this.f33463h.b();
        }
        this.f33463h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!this.f33463h.c()) {
            this.f33463h.d();
        }
        this.f33463h.setVisibility(4);
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33457b = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33449b.mTubeInfo;
        this.f33459d.addOnScrollListener(this.j);
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33451d.add(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33451d.remove(this.k);
        this.f33459d.removeOnScrollListener(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "EpisodeGridPresenter onCreate");
        RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_recycler_view);
        this.f33459d = recyclerView;
        recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        this.i = staggeredGridLayoutManager;
        this.f33459d.setLayoutManager(staggeredGridLayoutManager);
        b bVar = new b(this, o());
        this.f33460e = bVar;
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
        if (this.f33461f == null) {
            View a2 = ao.a((ViewGroup) this.f33459d, R.layout.ksad_tube_detail_grid_footer, false);
            this.f33461f = a2;
            TextView textView = (TextView) a2.findViewById(R.id.ksad_tube_detail_grid_no_more_tip);
            this.f33462g = textView;
            textView.setVisibility(4);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f33461f.findViewById(R.id.ksad_tube_detail_grid_loading);
            this.f33463h = lottieAnimationView;
            lottieAnimationView.setVisibility(4);
            int i = R.raw.ksad_detail_loading_amin_new;
            this.f33463h.setRepeatMode(1);
            this.f33463h.setRepeatCount(-1);
            this.f33463h.setAnimation(i);
        }
        if (!dVar.d(this.f33461f)) {
            dVar.c(this.f33461f);
        }
        this.f33461f.setVisibility(0);
        this.f33459d.setAdapter(dVar);
        this.f33459d.setVisibility(0);
        dVar.a(this.f33459d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
    }
}
