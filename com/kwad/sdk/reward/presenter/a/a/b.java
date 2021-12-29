package com.kwad.sdk.reward.presenter.a.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.j;
/* loaded from: classes3.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f59613b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59615d;

    /* renamed from: e  reason: collision with root package name */
    public long f59616e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59617f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59618g;

    /* renamed from: c  reason: collision with root package name */
    public Handler f59614c = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public volatile long f59619h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f59620i = false;

    /* renamed from: j  reason: collision with root package name */
    public d f59621j = new e() { // from class: com.kwad.sdk.reward.presenter.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            b.this.f59619h = j3;
            b.this.f59620i = j2 - j3 < 800;
        }
    };

    /* renamed from: k  reason: collision with root package name */
    public f f59622k = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.b.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) b.this).a.x) {
                return;
            }
            long j2 = b.this.f59616e;
            if (j2 == 0 || !b.this.f59615d) {
                b.this.e();
            } else {
                b.this.f59614c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.presenter.a.a.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.o() == null || b.this.o().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f59613b.setAlpha(0.0f);
                        b.this.f59613b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, j2);
            }
        }
    };

    public b(long j2) {
        this.f59616e = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f59613b.setVisibility(0);
        this.f59613b.setOnClickListener(this);
    }

    private void i() {
        AdTemplate adTemplate = this.f59617f;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        j.a(((g) this).a.f59456h, this.f59617f, j.a(adTemplate, (String) null, aVar.y, aVar.z), new j.c() { // from class: com.kwad.sdk.reward.presenter.a.a.b.3
            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void a() {
                com.kwad.sdk.core.report.a.c(b.this.f59617f, Opcodes.FCMPL, null);
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void b() {
                com.kwad.sdk.core.report.a.a(((g) b.this).a.f59455g, (int) (b.this.f59616e / 1000), (int) (b.this.f59619h / 1000));
                com.kwad.sdk.core.report.a.f(b.this.f59617f, (int) Opcodes.DCMPL);
                b.this.r();
                b.this.h();
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void c() {
                com.kwad.sdk.core.report.a.f(b.this.f59617f, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((g) this).a.f59450b.a(false);
    }

    private void s() {
        ((g) this).a.f59450b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f59619h = 0L;
        this.f59620i = false;
        AdTemplate adTemplate = ((g) this).a.f59455g;
        this.f59617f = adTemplate;
        this.f59618g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((g) this).a.a(this.f59622k);
        ((g) this).a.f59459k.a(this.f59621j);
    }

    public b b(boolean z) {
        this.f59615d = z;
        return this;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f59622k);
        this.f59614c.removeCallbacksAndMessages(null);
        ((g) this).a.f59459k.b(this.f59621j);
        this.f59613b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59613b = a(R.id.ksad_end_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.f59614c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59613b) {
            boolean z = false;
            boolean z2 = true;
            if (f() || g()) {
                com.kwad.sdk.core.report.a.a(this.f59617f, 69, (int) (this.f59616e / 1000), (int) (this.f59619h / 1000));
                if (!((g) this).a.v && com.kwad.sdk.core.config.b.R() && !((g) this).a.u) {
                    z = true;
                }
                if (z) {
                    i();
                    return;
                }
            } else {
                long p = com.kwad.sdk.core.response.a.a.p(this.f59618g);
                if (p >= 0) {
                    z2 = (this.f59620i || this.f59619h >= p) ? true : true;
                }
                if (z2) {
                    s();
                }
            }
            r();
            h();
        }
    }
}
