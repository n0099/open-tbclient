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
    public TubeInfo f33778b;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f33780d;

    /* renamed from: e  reason: collision with root package name */
    public b f33781e;

    /* renamed from: f  reason: collision with root package name */
    public View f33782f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33783g;

    /* renamed from: h  reason: collision with root package name */
    public LottieAnimationView f33784h;

    /* renamed from: i  reason: collision with root package name */
    public StaggeredGridLayoutManager f33785i;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f33779c = new AtomicBoolean(false);
    public C0372a j = new C0372a();
    public b.a k = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
            if (z) {
                a.this.e();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i2, String str) {
            if (z) {
                a.this.f33779c.set(false);
                if (com.kwad.sdk.core.network.f.f34497a.k == i2) {
                    p.a(a.this.o());
                } else if (com.kwad.sdk.core.network.f.f34503g.k != i2) {
                    p.b(a.this.o());
                }
                a.this.f();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onSuccess  tubeFeedData item size=" + adResultData.adTemplateList.size());
            a.this.f33781e.a(adResultData.adTemplateList);
            if (a.this.f33781e.a() < a.this.f33778b.totalEpisodeCount || !com.kwad.sdk.core.config.c.X()) {
                a.this.f33783g.setVisibility(4);
                return;
            }
            a.this.f33783g.setVisibility(0);
            a.this.f33783g.setText(q.a(a.this.o()));
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            if (z) {
                a.this.f33779c.set(false);
                a.this.f();
            }
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.tube.detail.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0372a extends RecyclerView.OnScrollListener {
        public C0372a() {
        }

        private int a(int[] iArr) {
            int length = iArr.length;
            int i2 = Integer.MIN_VALUE;
            for (int i3 = 0; i3 < length; i3++) {
                if (iArr[i3] > i2) {
                    i2 = iArr[i3];
                }
            }
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onScrolled dx=" + i2 + " dy=" + i3);
            boolean z = i3 > 0;
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", " manager.getSpanCount()=" + staggeredGridLayoutManager.getSpanCount());
            int a2 = a(staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]));
            int itemCount = staggeredGridLayoutManager.getItemCount();
            if (!z || a2 != itemCount - 1 || a.this.f33781e.a() >= a.this.f33778b.totalEpisodeCount || a.this.f33779c.getAndSet(true)) {
                return;
            }
            recyclerView.stopScroll();
            a aVar = a.this;
            aVar.a(aVar.f33781e.b());
        }
    }

    /* loaded from: classes6.dex */
    public class b extends RecyclerView.Adapter<c> {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f33788a;

        /* renamed from: c  reason: collision with root package name */
        public LayoutInflater f33790c;

        public b(a aVar, Context context) {
            this(context, null);
        }

        public b(Context context, List<AdTemplate> list) {
            this.f33788a = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList());
            this.f33790c = LayoutInflater.from(context);
            a(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(this.f33788a);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33768a.f33770b.mEntryScene;
            tubeEpisodeDetailParam.mTubeId = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33768a.f33770b.getTubeId();
            if (((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33768a.f33770b.mTubeInfo != null) {
                tubeEpisodeDetailParam.mTotalEpisodeCount = ((com.kwad.sdk.contentalliance.tube.detail.a.a) a.this).f33768a.f33770b.mTubeInfo.totalEpisodeCount;
            }
            tubeEpisodeDetailParam.mSelectedPosition = i2;
            com.kwad.sdk.contentalliance.tube.episode.a.a(a.this.o(), tubeEpisodeDetailParam);
        }

        public int a() {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f33788a;
            if (bVar != null) {
                return bVar.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new c((EpisodePhotoView) this.f33790c.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, final int i2) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "position =" + i2);
            final AdTemplate adTemplate = this.f33788a.get(i2);
            cVar.f33794a.setRatio(1.29f);
            cVar.f33794a.a(i2, a.this.f33778b.tubeId);
            cVar.f33794a.setTemplateData(adTemplate);
            cVar.f33794a.setLookMoreVisibility(false);
            cVar.f33794a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.e.b(adTemplate, 1);
                    b.this.a(i2);
                }
            });
            cVar.f33794a.setId(i2);
        }

        public void a(List<AdTemplate> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            int size = this.f33788a.size();
            this.f33788a.addAll(list);
            notifyItemRangeChanged(size + 1, list.size());
        }

        public long b() {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f33788a;
            if (bVar == null || bVar.isEmpty()) {
                return 0L;
            }
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = this.f33788a;
            return com.kwad.sdk.core.response.b.d.k(bVar2.get(bVar2.size() - 1).photoInfo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f33788a.size();
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f33794a;

        public c(View view) {
            super(view);
            this.f33794a = (EpisodePhotoView) view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        for (com.kwad.sdk.contentalliance.tube.detail.a aVar : ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33773e) {
            aVar.a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f33784h.c()) {
            this.f33784h.b();
        }
        this.f33784h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!this.f33784h.c()) {
            this.f33784h.d();
        }
        this.f33784h.setVisibility(4);
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33778b = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33770b.mTubeInfo;
        this.f33780d.addOnScrollListener(this.j);
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33772d.add(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33772d.remove(this.k);
        this.f33780d.removeOnScrollListener(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "EpisodeGridPresenter onCreate");
        RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_recycler_view);
        this.f33780d = recyclerView;
        recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        this.f33785i = staggeredGridLayoutManager;
        this.f33780d.setLayoutManager(staggeredGridLayoutManager);
        b bVar = new b(this, o());
        this.f33781e = bVar;
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
        if (this.f33782f == null) {
            View a2 = ao.a((ViewGroup) this.f33780d, R.layout.ksad_tube_detail_grid_footer, false);
            this.f33782f = a2;
            TextView textView = (TextView) a2.findViewById(R.id.ksad_tube_detail_grid_no_more_tip);
            this.f33783g = textView;
            textView.setVisibility(4);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f33782f.findViewById(R.id.ksad_tube_detail_grid_loading);
            this.f33784h = lottieAnimationView;
            lottieAnimationView.setVisibility(4);
            int i2 = R.raw.ksad_detail_loading_amin_new;
            this.f33784h.setRepeatMode(1);
            this.f33784h.setRepeatCount(-1);
            this.f33784h.setAnimation(i2);
        }
        if (!dVar.d(this.f33782f)) {
            dVar.c(this.f33782f);
        }
        this.f33782f.setVisibility(0);
        this.f33780d.setAdapter(dVar);
        this.f33780d.setVisibility(0);
        dVar.a(this.f33780d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
    }
}
