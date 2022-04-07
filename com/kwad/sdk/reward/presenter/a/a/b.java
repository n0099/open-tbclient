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
/* loaded from: classes5.dex */
public class b extends g implements View.OnClickListener {
    public View b;
    public boolean d;
    public long e;
    public AdTemplate f;
    public AdInfo g;
    public Handler c = new Handler(Looper.getMainLooper());
    public volatile long h = 0;
    public volatile boolean i = false;
    public d j = new e() { // from class: com.kwad.sdk.reward.presenter.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            b.this.h = j2;
            b.this.i = j - j2 < 800;
        }
    };
    public f k = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.b.2
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) b.this).a.x) {
                return;
            }
            long j = b.this.e;
            if (j == 0 || !b.this.d) {
                b.this.e();
            } else {
                b.this.c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.presenter.a.a.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.o() == null || b.this.o().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.b.setAlpha(0.0f);
                        b.this.b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, j);
            }
        }
    };

    public b(long j) {
        this.e = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.setVisibility(0);
        this.b.setOnClickListener(this);
    }

    private void i() {
        AdTemplate adTemplate = this.f;
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        j.a(((g) this).a.h, this.f, j.a(adTemplate, (String) null, aVar.y, aVar.z), new j.c() { // from class: com.kwad.sdk.reward.presenter.a.a.b.3
            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void a() {
                com.kwad.sdk.core.report.a.c(b.this.f, 149, null);
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void b() {
                com.kwad.sdk.core.report.a.a(((g) b.this).a.g, (int) (b.this.e / 1000), (int) (b.this.h / 1000));
                com.kwad.sdk.core.report.a.f(b.this.f, (int) Cea708Decoder.COMMAND_SWA);
                b.this.r();
                b.this.h();
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void c() {
                com.kwad.sdk.core.report.a.f(b.this.f, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ((g) this).a.b.a(false);
    }

    private void s() {
        ((g) this).a.b.e();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.h = 0L;
        this.i = false;
        AdTemplate adTemplate = ((g) this).a.g;
        this.f = adTemplate;
        this.g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((g) this).a.a(this.k);
        ((g) this).a.k.a(this.j);
    }

    public b b(boolean z) {
        this.d = z;
        return this;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.k);
        this.c.removeCallbacksAndMessages(null);
        ((g) this).a.k.b(this.j);
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = a(R.id.obfuscated_res_0x7f091074);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.b) {
            boolean z = false;
            boolean z2 = true;
            if (f() || g()) {
                com.kwad.sdk.core.report.a.a(this.f, 69, (int) (this.e / 1000), (int) (this.h / 1000));
                if (!((g) this).a.v && com.kwad.sdk.core.config.b.R() && !((g) this).a.u) {
                    z = true;
                }
                if (z) {
                    i();
                    return;
                }
            } else {
                long p = com.kwad.sdk.core.response.a.a.p(this.g);
                if (p >= 0) {
                    z2 = (this.i || this.h >= p) ? true : true;
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
