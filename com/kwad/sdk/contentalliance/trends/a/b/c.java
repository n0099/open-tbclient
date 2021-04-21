package com.kwad.sdk.contentalliance.trends.a.b;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.comment.g;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.b.f;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer;
import com.kwad.sdk.core.g.o;
import com.kwad.sdk.core.i.d;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class c extends e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33427b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f33428c;

    /* renamed from: d  reason: collision with root package name */
    public TrendsRollingTextContainer f33429d;
    public i i;
    public boolean j;
    public List<a> n;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f33430e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public List<TrendInfo> f33431f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public long f33432g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f33433h = "";
    public com.kwad.sdk.core.i.c k = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (c.this.f33430e.getAndSet(true)) {
                return;
            }
            com.kwad.sdk.core.report.e.a(((e) c.this).f33153a.f33158e, c.this.f33432g, c.this.f33433h);
        }
    };
    public f.a l = new f.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.2
        @Override // com.kwad.sdk.contentalliance.home.b.f.a
        public void a() {
            if (c.this.f33431f.isEmpty()) {
                o.a(true, new o.d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.2.1
                    @Override // com.kwad.sdk.core.g.o.d
                    public void a(int i, String str) {
                    }

                    @Override // com.kwad.sdk.core.g.o.d
                    public void a(@NonNull List<TrendInfo> list) {
                        Collections.sort(list, TrendInfo.mTrendsComparator);
                        c.this.f33431f.addAll(list);
                        ((e) c.this).f33153a.f33161h = c.this.f33431f;
                        c.this.g();
                    }
                });
            } else {
                c.this.i.a(0);
            }
        }
    };
    public g m = new g() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.3
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void a() {
            c.this.f33429d.b();
            c.this.f33428c.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void b() {
            c.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.trends.view.c o = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.4
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            c.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a(View view, TrendInfo trendInfo, int i) {
            c.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            if (c.this.j) {
                return;
            }
            c.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d p = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.5
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            c.this.e();
            c.this.j = false;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            c.this.e();
            c.this.j = false;
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            c.this.j = true;
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(@NonNull List<TrendInfo> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f33431f.isEmpty()) {
            return;
        }
        this.f33429d.c();
        this.f33428c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f33431f.isEmpty()) {
            return;
        }
        this.f33429d.b();
        this.f33428c.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        List<TrendInfo> list = this.f33431f;
        if (list == null || list.isEmpty()) {
            f();
            return;
        }
        this.f33429d.a(this.f33431f);
        this.f33428c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.f33428c.setVisibility(8);
                com.kwad.sdk.core.report.e.b(((e) c.this).f33153a.f33158e, c.this.f33432g, c.this.f33433h);
                c.this.h();
            }
        });
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<a> list = this.n;
        if (list != null) {
            for (a aVar : list) {
                aVar.a(this.f33431f);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        i iVar = ((e) this).f33153a.f33155b;
        this.i = iVar;
        iVar.a(this.p);
        com.kwad.sdk.core.i.a aVar = ((e) this).f33153a.f33159f.f33173a;
        this.f33427b = aVar;
        aVar.a(this.k);
        TrendInfo trendInfo = ((e) this).f33153a.i;
        if (trendInfo != null) {
            this.f33432g = trendInfo.trendId;
            this.f33433h = trendInfo.name;
        }
        com.kwad.sdk.contentalliance.home.f fVar = ((e) this).f33153a;
        this.f33431f = fVar.f33161h;
        this.n = fVar.n;
        g();
        ((e) this).f33153a.o.add(this.o);
        ((e) this).f33153a.f33159f.f33178f.add(this.m);
        ((e) this).f33153a.p.add(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((e) this).f33153a.f33159f.f33178f.remove(this.m);
        ((e) this).f33153a.o.remove(this.o);
        this.f33427b.b(this.k);
        this.f33429d.a();
        this.i.b(this.p);
        ((e) this).f33153a.p.remove(this.l);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33428c = (RelativeLayout) b(R.id.ksad_trends_rolling_container);
        this.f33429d = (TrendsRollingTextContainer) b(R.id.ksad_trends_rolling_trend_name_layout);
    }
}
