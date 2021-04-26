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
    public AdTemplate f34332b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f34333c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f34334d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f34335e = new com.kwad.sdk.contentalliance.detail.a.a.a();

    /* renamed from: f  reason: collision with root package name */
    public long f34336f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f34337g = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f34338h = true;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f34339i = new Runnable() { // from class: com.kwad.sdk.reward.b.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f34335e.c()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f34335e.e();
                int a2 = a.this.f34335e.d().a();
                ((d) a.this).f34594a.a(elapsedRealtime, a.this.f34335e.d().b(), a2);
            } else if (a.this.f34338h) {
                ((d) a.this).f34594a.a(5000L, 5000L, 1);
            }
            e.c(a.this.f34332b);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d j = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.b.a.a.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            a.this.a(j2);
            a.this.f34336f = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            b.a(a.this.f34332b, ((d) a.this).f34594a.f34319d);
            b.g(a.this.f34332b, ((d) a.this).f34594a.f34319d);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            a.this.f34335e.b();
            a.this.f34338h = false;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void e() {
            super.e();
            a.this.f34335e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            b.h(a.this.f34332b, ((d) a.this).f34594a.f34319d);
            a.this.f34335e.b();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void g() {
            super.g();
            a.this.f34335e.a();
            a.this.f34337g.removeCallbacks(a.this.f34339i);
            a.this.f34337g.postDelayed(a.this.f34339i, 5000L);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void h() {
            super.h();
            a.this.f34335e.a();
            a.this.f34337g.removeCallbacks(a.this.f34339i);
            a.this.f34337g.postDelayed(a.this.f34339i, 5000L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f34334d;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f34334d) {
            if (ceil >= num.intValue()) {
                b.b(this.f34332b, ceil, ((d) this).f34594a.f34319d);
                this.f34334d.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((d) this).f34594a.f34321f;
        this.f34332b = adTemplate;
        AdInfo g2 = c.g(adTemplate);
        this.f34333c = g2;
        this.f34334d = com.kwad.sdk.core.response.b.a.I(g2);
        ((d) this).f34594a.f34324i.a(this.j);
        this.f34337g.postDelayed(this.f34339i, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34337g.removeCallbacksAndMessages(null);
        ((d) this).f34594a.f34324i.b(this.j);
        a.C0370a d2 = this.f34335e.d();
        e.a(((d) this).f34594a.f34321f, this.f34336f, d2.b(), d2.a());
    }
}
