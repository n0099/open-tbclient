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
/* loaded from: classes7.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f41014b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f41015c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f41016d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.kwai.kwai.a f41017e = new com.kwad.sdk.contentalliance.detail.kwai.kwai.a();

    /* renamed from: f  reason: collision with root package name */
    public long f41018f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f41019g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f41020h = true;
    public volatile boolean i = false;
    public Runnable j = new Runnable() { // from class: com.kwad.sdk.reward.presenter.kwai.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41017e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f41017e.e();
                int a = a.this.f41017e.d().a();
                ((g) a.this).a.a(elapsedRealtime, a.this.f41017e.d().b(), a);
            } else if (a.this.f41020h) {
                ((g) a.this).a.a(5000L, 5000L, 1);
            }
            d.c(a.this.f41014b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f41018f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.i = false;
            com.kwad.sdk.core.report.a.a(a.this.f41014b, ((g) a.this).a.f40745e);
            com.kwad.sdk.core.report.a.g(a.this.f41014b, ((g) a.this).a.f40745e);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f41017e.b();
            a.this.f41020h = false;
            if (a.this.i) {
                return;
            }
            a.this.i = true;
            d.a(a.this.f41014b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f41017e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (!((g) a.this).a.r || !((g) a.this).a.u) {
                com.kwad.sdk.core.report.a.h(a.this.f41014b, ((g) a.this).a.f40745e);
            }
            a.this.f41017e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f41017e.a();
            a.this.f41019g.removeCallbacks(a.this.j);
            a.this.f41019g.postDelayed(a.this.j, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f41017e.a();
            a.this.f41019g.removeCallbacks(a.this.j);
            a.this.f41019g.postDelayed(a.this.j, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f41016d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f41016d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f41014b, ceil, ((g) this).a.f40745e);
                this.f41016d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f40747g;
        this.f41014b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41015c = j;
        this.f41016d = com.kwad.sdk.core.response.a.a.S(j);
        ((g) this).a.k.a(this.k);
        this.f41019g.postDelayed(this.j, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f41019g.removeCallbacksAndMessages(null);
        ((g) this).a.k.b(this.k);
        a.C1951a d2 = this.f41017e.d();
        d.a(((g) this).a.f40747g, this.f41018f, d2.b(), d2.a());
    }
}
