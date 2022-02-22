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
/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57716b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f57717c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f57718d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.kwai.kwai.a f57719e = new com.kwad.sdk.contentalliance.detail.kwai.kwai.a();

    /* renamed from: f  reason: collision with root package name */
    public long f57720f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f57721g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f57722h = true;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f57723i = false;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f57724j = new Runnable() { // from class: com.kwad.sdk.reward.presenter.kwai.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f57719e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f57719e.e();
                int a = a.this.f57719e.d().a();
                ((g) a.this).a.a(elapsedRealtime, a.this.f57719e.d().b(), a);
            } else if (a.this.f57722h) {
                ((g) a.this).a.a(5000L, 5000L, 1);
            }
            d.c(a.this.f57716b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            a.this.a(j3);
            a.this.f57720f = j3;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.f57723i = false;
            com.kwad.sdk.core.report.a.a(a.this.f57716b, ((g) a.this).a.f57417e);
            com.kwad.sdk.core.report.a.g(a.this.f57716b, ((g) a.this).a.f57417e);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f57719e.b();
            a.this.f57722h = false;
            if (a.this.f57723i) {
                return;
            }
            a.this.f57723i = true;
            d.a(a.this.f57716b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f57719e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (!((g) a.this).a.r || !((g) a.this).a.u) {
                com.kwad.sdk.core.report.a.h(a.this.f57716b, ((g) a.this).a.f57417e);
            }
            a.this.f57719e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f57719e.a();
            a.this.f57721g.removeCallbacks(a.this.f57724j);
            a.this.f57721g.postDelayed(a.this.f57724j, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f57719e.a();
            a.this.f57721g.removeCallbacks(a.this.f57724j);
            a.this.f57721g.postDelayed(a.this.f57724j, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f57718d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f57718d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f57716b, ceil, ((g) this).a.f57417e);
                this.f57718d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f57419g;
        this.f57716b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57717c = j2;
        this.f57718d = com.kwad.sdk.core.response.a.a.S(j2);
        ((g) this).a.k.a(this.k);
        this.f57721g.postDelayed(this.f57724j, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57721g.removeCallbacksAndMessages(null);
        ((g) this).a.k.b(this.k);
        a.C2111a d2 = this.f57719e.d();
        d.a(((g) this).a.f57419g, this.f57720f, d2.b(), d2.a());
    }
}
