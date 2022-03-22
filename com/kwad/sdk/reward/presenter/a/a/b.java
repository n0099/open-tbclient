package com.kwad.sdk.reward.presenter.a.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.j;
/* loaded from: classes7.dex */
public class b extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f40887b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40889d;

    /* renamed from: e  reason: collision with root package name */
    public long f40890e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f40891f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f40892g;

    /* renamed from: c  reason: collision with root package name */
    public Handler f40888c = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public volatile long f40893h = 0;
    public volatile boolean i = false;
    public d j = new e() { // from class: com.kwad.sdk.reward.presenter.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            b.this.f40893h = j2;
            b.this.i = j - j2 < 800;
        }
    };
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.b.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) b.this).a.x) {
                return;
            }
            long j = b.this.f40890e;
            if (j == 0 || !b.this.f40889d) {
                b.this.e();
            } else {
                b.this.f40888c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.presenter.a.a.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.o() == null || b.this.o().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f40887b.setAlpha(0.0f);
                        b.this.f40887b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, j);
            }
        }
    };

    public b(long j) {
        this.f40890e = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f40887b.setVisibility(0);
        this.f40887b.setOnClickListener(this);
    }

    private void i() {
        AdTemplate adTemplate = this.f40891f;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        j.a(((g) this).a.f40748h, this.f40891f, j.a(adTemplate, (String) null, aVar.y, aVar.z), new j.c() { // from class: com.kwad.sdk.reward.presenter.a.a.b.3
            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void a() {
                com.kwad.sdk.core.report.a.c(b.this.f40891f, 149, null);
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void b() {
                com.kwad.sdk.core.report.a.a(((g) b.this).a.f40747g, (int) (b.this.f40890e / 1000), (int) (b.this.f40893h / 1000));
                com.kwad.sdk.core.report.a.f(b.this.f40891f, (int) Cea708Decoder.COMMAND_SWA);
                b.this.r();
                b.this.h();
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void c() {
                com.kwad.sdk.core.report.a.f(b.this.f40891f, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((g) this).a.f40742b.a(false);
    }

    private void s() {
        ((g) this).a.f40742b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40893h = 0L;
        this.i = false;
        AdTemplate adTemplate = ((g) this).a.f40747g;
        this.f40891f = adTemplate;
        this.f40892g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((g) this).a.a(this.k);
        ((g) this).a.k.a(this.j);
    }

    public b b(boolean z) {
        this.f40889d = z;
        return this;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.k);
        this.f40888c.removeCallbacksAndMessages(null);
        ((g) this).a.k.b(this.j);
        this.f40887b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40887b = a(R.id.obfuscated_res_0x7f09107b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.f40888c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40887b) {
            boolean z = false;
            boolean z2 = true;
            if (f() || g()) {
                com.kwad.sdk.core.report.a.a(this.f40891f, 69, (int) (this.f40890e / 1000), (int) (this.f40893h / 1000));
                if (!((g) this).a.v && com.kwad.sdk.core.config.b.R() && !((g) this).a.u) {
                    z = true;
                }
                if (z) {
                    i();
                    return;
                }
            } else {
                long p = com.kwad.sdk.core.response.a.a.p(this.f40892g);
                if (p >= 0) {
                    z2 = (this.i || this.f40893h >= p) ? true : true;
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
