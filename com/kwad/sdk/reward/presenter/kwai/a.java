package com.kwad.sdk.reward.presenter.kwai;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.contentalliance.detail.kwai.kwai.a;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56066b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56067c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f56068d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.kwai.kwai.a f56069e = new com.kwad.sdk.contentalliance.detail.kwai.kwai.a();

    /* renamed from: f  reason: collision with root package name */
    public long f56070f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56071g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f56072h = true;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f56073i = false;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f56074j = new Runnable() { // from class: com.kwad.sdk.reward.presenter.kwai.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f56069e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f56069e.e();
                int a = a.this.f56069e.d().a();
                ((g) a.this).a.a(elapsedRealtime, a.this.f56069e.d().b(), a);
            } else if (a.this.f56072h) {
                ((g) a.this).a.a(5000L, 5000L, 1);
            }
            d.c(a.this.f56066b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            a.this.a(j3);
            a.this.f56070f = j3;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.f56073i = false;
            com.kwad.sdk.core.report.a.a(a.this.f56066b, ((g) a.this).a.f55767e);
            com.kwad.sdk.core.report.a.g(a.this.f56066b, ((g) a.this).a.f55767e);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f56069e.b();
            a.this.f56072h = false;
            if (a.this.f56073i) {
                return;
            }
            a.this.f56073i = true;
            d.a(a.this.f56066b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f56069e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (!((g) a.this).a.r || !((g) a.this).a.u) {
                com.kwad.sdk.core.report.a.h(a.this.f56066b, ((g) a.this).a.f55767e);
            }
            a.this.f56069e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f56069e.a();
            a.this.f56071g.removeCallbacks(a.this.f56074j);
            a.this.f56071g.postDelayed(a.this.f56074j, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f56069e.a();
            a.this.f56071g.removeCallbacks(a.this.f56074j);
            a.this.f56071g.postDelayed(a.this.f56074j, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f56068d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f56068d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f56066b, ceil, ((g) this).a.f55767e);
                this.f56068d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f55769g;
        this.f56066b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56067c = j2;
        this.f56068d = com.kwad.sdk.core.response.a.a.S(j2);
        ((g) this).a.k.a(this.k);
        this.f56071g.postDelayed(this.f56074j, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56071g.removeCallbacksAndMessages(null);
        ((g) this).a.k.b(this.k);
        a.C2090a d2 = this.f56069e.d();
        d.a(((g) this).a.f55769g, this.f56070f, d2.b(), d2.a());
    }
}
