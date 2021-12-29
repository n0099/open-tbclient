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
/* loaded from: classes3.dex */
public class a extends g {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f59763b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f59764c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f59765d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.kwai.kwai.a f59766e = new com.kwad.sdk.contentalliance.detail.kwai.kwai.a();

    /* renamed from: f  reason: collision with root package name */
    public long f59767f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f59768g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f59769h = true;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f59770i = false;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f59771j = new Runnable() { // from class: com.kwad.sdk.reward.presenter.kwai.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f59766e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f59766e.e();
                int a = a.this.f59766e.d().a();
                ((g) a.this).a.a(elapsedRealtime, a.this.f59766e.d().b(), a);
            } else if (a.this.f59769h) {
                ((g) a.this).a.a(5000L, 5000L, 1);
            }
            d.c(a.this.f59763b);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59772k = new e() { // from class: com.kwad.sdk.reward.presenter.kwai.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            a.this.a(j3);
            a.this.f59767f = j3;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            a.this.f59770i = false;
            com.kwad.sdk.core.report.a.a(a.this.f59763b, ((g) a.this).a.f59453e);
            com.kwad.sdk.core.report.a.g(a.this.f59763b, ((g) a.this).a.f59453e);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f59766e.b();
            a.this.f59769h = false;
            if (a.this.f59770i) {
                return;
            }
            a.this.f59770i = true;
            d.a(a.this.f59763b, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f59766e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (!((g) a.this).a.r || !((g) a.this).a.u) {
                com.kwad.sdk.core.report.a.h(a.this.f59763b, ((g) a.this).a.f59453e);
            }
            a.this.f59766e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f59766e.a();
            a.this.f59768g.removeCallbacks(a.this.f59771j);
            a.this.f59768g.postDelayed(a.this.f59771j, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f59766e.a();
            a.this.f59768g.removeCallbacks(a.this.f59771j);
            a.this.f59768g.postDelayed(a.this.f59771j, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
        List<Integer> list = this.f59765d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f59765d) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.f59763b, ceil, ((g) this).a.f59453e);
                this.f59765d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.f59455g;
        this.f59763b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59764c = j2;
        this.f59765d = com.kwad.sdk.core.response.a.a.S(j2);
        ((g) this).a.f59459k.a(this.f59772k);
        this.f59768g.postDelayed(this.f59771j, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f59768g.removeCallbacksAndMessages(null);
        ((g) this).a.f59459k.b(this.f59772k);
        a.C2078a d2 = this.f59766e.d();
        d.a(((g) this).a.f59455g, this.f59767f, d2.b(), d2.a());
    }
}
