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
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    private TubeInfo f8927b;
    private RecyclerView d;
    private b e;
    private View f;
    private TextView g;
    private LottieAnimationView h;
    private StaggeredGridLayoutManager i;
    private AtomicBoolean c = new AtomicBoolean(false);
    private C1081a j = new C1081a();
    private b.a k = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
            if (z) {
                a.this.e();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
            if (z) {
                a.this.c.set(false);
                if (com.kwad.sdk.core.network.f.f9321a.k == i) {
                    p.a(a.this.o());
                } else if (com.kwad.sdk.core.network.f.g.k != i) {
                    p.b(a.this.o());
                }
                a.this.f();
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onSuccess  tubeFeedData item size=" + adResultData.adTemplateList.size());
            a.this.e.a(adResultData.adTemplateList);
            if (a.this.e.a() < a.this.f8927b.totalEpisodeCount || !com.kwad.sdk.core.config.c.X()) {
                a.this.g.setVisibility(4);
                return;
            }
            a.this.g.setVisibility(0);
            a.this.g.setText(q.a(a.this.o()));
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            if (z) {
                a.this.c.set(false);
                a.this.f();
            }
        }
    };

    /* renamed from: com.kwad.sdk.contentalliance.tube.detail.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1081a extends RecyclerView.OnScrollListener {
        public C1081a() {
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
            if (!z || a2 != itemCount - 1 || a.this.e.a() >= a.this.f8927b.totalEpisodeCount || a.this.c.getAndSet(true)) {
                return;
            }
            recyclerView.stopScroll();
            a.this.a(a.this.e.b());
        }
    }

    /* loaded from: classes4.dex */
    private class b extends RecyclerView.Adapter<c> {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f8930a;
        private LayoutInflater c;

        public b(a aVar, Context context) {
            this(context, null);
        }

        public b(Context context, List<AdTemplate> list) {
            this.f8930a = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList());
            this.c = LayoutInflater.from(context);
            a(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            com.kwad.sdk.contentalliance.tube.episode.b.a().a(this.f8930a);
            TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
            tubeEpisodeDetailParam.mEntryScene = a.this.f8922a.f8924b.mEntryScene;
            tubeEpisodeDetailParam.mTubeId = a.this.f8922a.f8924b.getTubeId();
            if (a.this.f8922a.f8924b.mTubeInfo != null) {
                tubeEpisodeDetailParam.mTotalEpisodeCount = a.this.f8922a.f8924b.mTubeInfo.totalEpisodeCount;
            }
            tubeEpisodeDetailParam.mSelectedPosition = i;
            com.kwad.sdk.contentalliance.tube.episode.a.a(a.this.o(), tubeEpisodeDetailParam);
        }

        public int a() {
            if (this.f8930a != null) {
                return this.f8930a.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new c((EpisodePhotoView) this.c.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, final int i) {
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "position =" + i);
            final AdTemplate adTemplate = this.f8930a.get(i);
            cVar.f8934a.setRatio(1.29f);
            cVar.f8934a.a(i, a.this.f8927b.tubeId);
            cVar.f8934a.setTemplateData(adTemplate);
            cVar.f8934a.setLookMoreVisibility(false);
            cVar.f8934a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.e.b(adTemplate, 1);
                    b.this.a(i);
                }
            });
            cVar.f8934a.setId(i);
        }

        public void a(List<AdTemplate> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            int size = this.f8930a.size();
            this.f8930a.addAll(list);
            notifyItemRangeChanged(size + 1, list.size());
        }

        public long b() {
            if (this.f8930a == null || this.f8930a.isEmpty()) {
                return 0L;
            }
            return com.kwad.sdk.core.response.b.d.k(this.f8930a.get(this.f8930a.size() - 1).photoInfo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f8930a.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f8934a;

        public c(View view) {
            super(view);
            this.f8934a = (EpisodePhotoView) view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        for (com.kwad.sdk.contentalliance.tube.detail.a aVar : this.f8922a.e) {
            aVar.a(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.h.c()) {
            this.h.b();
        }
        this.h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!this.h.c()) {
            this.h.d();
        }
        this.h.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8927b = this.f8922a.f8924b.mTubeInfo;
        this.d.addOnScrollListener(this.j);
        this.f8922a.d.add(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8922a.d.remove(this.k);
        this.d.removeOnScrollListener(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "EpisodeGridPresenter onCreate");
        this.d = (RecyclerView) b(R.id.ksad_tube_recycler_view);
        this.d.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
        this.i = new StaggeredGridLayoutManager(3, 1);
        this.d.setLayoutManager(this.i);
        this.e = new b(this, o());
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(this.e);
        if (this.f == null) {
            this.f = ao.a((ViewGroup) this.d, R.layout.ksad_tube_detail_grid_footer, false);
            this.g = (TextView) this.f.findViewById(R.id.ksad_tube_detail_grid_no_more_tip);
            this.g.setVisibility(4);
            this.h = (LottieAnimationView) this.f.findViewById(R.id.ksad_tube_detail_grid_loading);
            this.h.setVisibility(4);
            int i = R.raw.ksad_detail_loading_amin_new;
            this.h.setRepeatMode(1);
            this.h.setRepeatCount(-1);
            this.h.setAnimation(i);
        }
        if (!dVar.d(this.f)) {
            dVar.c(this.f);
        }
        this.f.setVisibility(0);
        this.d.setAdapter(dVar);
        this.d.setVisibility(0);
        dVar.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        f();
    }
}
