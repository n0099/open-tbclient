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
    public AdTemplate f33577b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f33578c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f33579d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f33580e = new com.kwad.sdk.contentalliance.detail.a.a.a();

    /* renamed from: f  reason: collision with root package name */
    public long f33581f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f33582g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f33583h = true;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f33584i = new Runnable() { // from class: com.kwad.sdk.reward.b.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f33580e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f33580e.e();
                int a2 = a.this.f33580e.d().a();
                ((d) a.this).f33839a.a(elapsedRealtime, a.this.f33580e.d().b(), a2);
            } else if (a.this.f33583h) {
                ((d) a.this).f33839a.a(5000L, 5000L, 1);
            }
            e.c(a.this.f33577b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d j = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f33581f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            b.a(a.this.f33577b, ((d) a.this).f33839a.f33564d);
            b.g(a.this.f33577b, ((d) a.this).f33839a.f33564d);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f33580e.b();
            a.this.f33583h = false;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f33580e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            b.h(a.this.f33577b, ((d) a.this).f33839a.f33564d);
            a.this.f33580e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f33580e.a();
            a.this.f33582g.removeCallbacks(a.this.f33584i);
            a.this.f33582g.postDelayed(a.this.f33584i, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f33580e.a();
            a.this.f33582g.removeCallbacks(a.this.f33584i);
            a.this.f33582g.postDelayed(a.this.f33584i, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f33579d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f33579d) {
            if (ceil >= num.intValue()) {
                b.b(this.f33577b, ceil, ((d) this).f33839a.f33564d);
                this.f33579d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f33839a.f33566f;
        this.f33577b = adTemplate;
        AdInfo g2 = c.g(adTemplate);
        this.f33578c = g2;
        this.f33579d = com.kwad.sdk.core.response.b.a.I(g2);
        ((d) this).f33839a.f33569i.a(this.j);
        this.f33582g.postDelayed(this.f33584i, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33582g.removeCallbacksAndMessages(null);
        ((d) this).f33839a.f33569i.b(this.j);
        a.C0357a d2 = this.f33580e.d();
        e.a(((d) this).f33839a.f33566f, this.f33581f, d2.b(), d2.a());
    }
}
