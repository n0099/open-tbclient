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
/* loaded from: classes5.dex */
public class a extends g {
    public AdTemplate b;
    public AdInfo c;
    public List<Integer> d;
    public final com.kwad.sdk.contentalliance.detail.kwai.kwai.a e = new com.kwad.sdk.contentalliance.detail.kwai.kwai.a();
    public long f = 0;
    public Handler g = new Handler(Looper.getMainLooper());
    public boolean h = true;
    public volatile boolean i = false;
    public Runnable j = new Runnable() { // from class: com.kwad.sdk.reward.presenter.kwai.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.e.e();
                int a = a.this.e.d().a();
                ((g) a.this).a.a(elapsedRealtime, a.this.e.d().b(), a);
            } else if (a.this.h) {
                ((g) a.this).a.a(5000L, 5000L, 1);
            }
            d.c(a.this.b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d k = new e() { // from class: com.kwad.sdk.reward.presenter.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.i = false;
            com.kwad.sdk.core.report.a.a(a.this.b, ((g) a.this).a.e);
            com.kwad.sdk.core.report.a.g(a.this.b, ((g) a.this).a.e);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.e.b();
            a.this.h = false;
            if (a.this.i) {
                return;
            }
            a.this.i = true;
            d.a(a.this.b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (!((g) a.this).a.r || !((g) a.this).a.u) {
                com.kwad.sdk.core.report.a.h(a.this.b, ((g) a.this).a.e);
            }
            a.this.e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.e.a();
            a.this.g.removeCallbacks(a.this.j);
            a.this.g.postDelayed(a.this.j, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.e.a();
            a.this.g.removeCallbacks(a.this.j);
            a.this.g.postDelayed(a.this.j, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.b, ceil, ((g) this).a.e);
                this.d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.g;
        this.b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.c = j;
        this.d = com.kwad.sdk.core.response.a.a.S(j);
        ((g) this).a.k.a(this.k);
        this.g.postDelayed(this.j, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.g.removeCallbacksAndMessages(null);
        ((g) this).a.k.b(this.k);
        a.C0299a d = this.e.d();
        d.a(((g) this).a.g, this.f, d.b(), d.a());
    }
}
