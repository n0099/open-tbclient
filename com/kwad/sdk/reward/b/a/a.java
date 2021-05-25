package com.kwad.sdk.reward.b.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.contentalliance.detail.a.a.a;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f33506b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f33507c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f33508d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f33509e = new com.kwad.sdk.contentalliance.detail.a.a.a();

    /* renamed from: f  reason: collision with root package name */
    public long f33510f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f33511g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f33512h = true;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f33513i = new Runnable() { // from class: com.kwad.sdk.reward.b.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f33509e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f33509e.e();
                int a2 = a.this.f33509e.d().a();
                ((d) a.this).f33768a.a(elapsedRealtime, a.this.f33509e.d().b(), a2);
            } else if (a.this.f33512h) {
                ((d) a.this).f33768a.a(5000L, 5000L, 1);
            }
            e.c(a.this.f33506b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d j = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f33510f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            b.a(a.this.f33506b, ((d) a.this).f33768a.f33493d);
            b.g(a.this.f33506b, ((d) a.this).f33768a.f33493d);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f33509e.b();
            a.this.f33512h = false;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f33509e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            b.h(a.this.f33506b, ((d) a.this).f33768a.f33493d);
            a.this.f33509e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f33509e.a();
            a.this.f33511g.removeCallbacks(a.this.f33513i);
            a.this.f33511g.postDelayed(a.this.f33513i, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f33509e.a();
            a.this.f33511g.removeCallbacks(a.this.f33513i);
            a.this.f33511g.postDelayed(a.this.f33513i, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f33508d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f33508d) {
            if (ceil >= num.intValue()) {
                b.b(this.f33506b, ceil, ((d) this).f33768a.f33493d);
                this.f33508d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f33768a.f33495f;
        this.f33506b = adTemplate;
        AdInfo g2 = c.g(adTemplate);
        this.f33507c = g2;
        this.f33508d = com.kwad.sdk.core.response.b.a.I(g2);
        ((d) this).f33768a.f33498i.a(this.j);
        this.f33511g.postDelayed(this.f33513i, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33511g.removeCallbacksAndMessages(null);
        ((d) this).f33768a.f33498i.b(this.j);
        a.C0358a d2 = this.f33509e.d();
        e.a(((d) this).f33768a.f33495f, this.f33510f, d2.b(), d2.a());
    }
}
