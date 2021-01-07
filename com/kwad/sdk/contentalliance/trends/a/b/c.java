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
/* loaded from: classes5.dex */
public class c extends e {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f9165b;
    private RelativeLayout c;
    private TrendsRollingTextContainer d;
    private i i;
    private boolean j;
    private List<a> n;
    private AtomicBoolean e = new AtomicBoolean(false);
    private List<TrendInfo> f = new ArrayList();
    private long g = 0;
    private String h = "";
    private com.kwad.sdk.core.i.c k = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (c.this.e.getAndSet(true)) {
                return;
            }
            com.kwad.sdk.core.report.e.a(c.this.f9034a.e, c.this.g, c.this.h);
        }
    };
    private f.a l = new f.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.2
        @Override // com.kwad.sdk.contentalliance.home.b.f.a
        public void a() {
            if (c.this.f.isEmpty()) {
                o.a(true, new o.d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.2.1
                    @Override // com.kwad.sdk.core.g.o.d
                    public void a(int i, String str) {
                    }

                    @Override // com.kwad.sdk.core.g.o.d
                    public void a(@NonNull List<TrendInfo> list) {
                        Collections.sort(list, TrendInfo.mTrendsComparator);
                        c.this.f.addAll(list);
                        c.this.f9034a.h = c.this.f;
                        c.this.g();
                    }
                });
            } else {
                c.this.i.a(0);
            }
        }
    };
    private g m = new g() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.3
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void a() {
            c.this.d.b();
            c.this.c.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
        public void b() {
            c.this.e();
        }
    };
    private com.kwad.sdk.contentalliance.trends.view.c o = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.4
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
    private com.kwad.sdk.contentalliance.home.a.d p = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.5
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

    /* loaded from: classes5.dex */
    public interface a {
        void a(@NonNull List<TrendInfo> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f.isEmpty()) {
            return;
        }
        this.d.c();
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f.isEmpty()) {
            return;
        }
        this.d.b();
        this.c.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f == null || this.f.isEmpty()) {
            f();
            return;
        }
        this.d.a(this.f);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.c.setVisibility(8);
                com.kwad.sdk.core.report.e.b(c.this.f9034a.e, c.this.g, c.this.h);
                c.this.h();
            }
        });
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.n != null) {
            for (a aVar : this.n) {
                aVar.a(this.f);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    protected void a() {
        super.a();
        this.i = this.f9034a.f9036b;
        this.i.a(this.p);
        this.f9165b = this.f9034a.f.f9042a;
        this.f9165b.a(this.k);
        if (this.f9034a.i != null) {
            this.g = this.f9034a.i.trendId;
            this.h = this.f9034a.i.name;
        }
        this.f = this.f9034a.h;
        this.n = this.f9034a.n;
        g();
        this.f9034a.o.add(this.o);
        this.f9034a.f.f.add(this.m);
        this.f9034a.p.add(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9034a.f.f.remove(this.m);
        this.f9034a.o.remove(this.o);
        this.f9165b.b(this.k);
        this.d.a();
        this.i.b(this.p);
        this.f9034a.p.remove(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (RelativeLayout) b(R.id.ksad_trends_rolling_container);
        this.d = (TrendsRollingTextContainer) b(R.id.ksad_trends_rolling_trend_name_layout);
    }
}
