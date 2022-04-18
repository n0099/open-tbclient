package com.kwad.sdk.reward.presenter;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KsToastView;
/* loaded from: classes5.dex */
public class h extends com.kwad.sdk.reward.g {
    public KsToastView b;
    public float e;
    public Runnable f;
    public boolean c = false;
    public boolean d = false;
    public boolean g = false;
    public com.kwad.sdk.reward.a.f h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.h.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            h.this.b.setVisibility(8);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.h.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            if (j < 10000 || !h.this.c || ((float) j2) < ((float) j) * h.this.e) {
                return;
            }
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.b.setVisibility(0);
        this.b.a(3);
        i();
        ax.a(this.f, null, 3000L);
    }

    private void i() {
        this.f = new Runnable() { // from class: com.kwad.sdk.reward.presenter.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.g) {
                    return;
                }
                if (h.this.b != null) {
                    h.this.b.setVisibility(8);
                }
                com.kwad.sdk.reward.c.a().b();
            }
        };
    }

    private void r() {
        ax.b(this.f);
        this.f = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.h);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        r();
        ((com.kwad.sdk.reward.g) this).a.b(this.h);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsToastView ksToastView = (KsToastView) a(R.id.obfuscated_res_0x7f09114d);
        this.b = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.presenter.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                h.this.g = true;
                h.this.b.setVisibility(8);
                com.kwad.sdk.reward.c.a().b();
            }
        });
        float aw = com.kwad.sdk.core.config.b.aw();
        this.e = aw;
        this.c = (aw == 0.0f || aw == 1.0f) ? false : true;
    }
}
