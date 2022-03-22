package com.kwad.sdk.reward.presenter;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KsToastView;
/* loaded from: classes7.dex */
public class h extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public KsToastView f41000b;

    /* renamed from: e  reason: collision with root package name */
    public float f41003e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f41004f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41001c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41002d = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41005g = false;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f41006h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.h.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            h.this.f41000b.setVisibility(8);
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.d i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.h.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            super.a(j, j2);
            if (j < 10000 || !h.this.f41001c || ((float) j2) < ((float) j) * h.this.f41003e) {
                return;
            }
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f41002d) {
            return;
        }
        this.f41002d = true;
        this.f41000b.setVisibility(0);
        this.f41000b.a(3);
        i();
        ax.a(this.f41004f, null, 3000L);
    }

    private void i() {
        this.f41004f = new Runnable() { // from class: com.kwad.sdk.reward.presenter.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f41005g) {
                    return;
                }
                if (h.this.f41000b != null) {
                    h.this.f41000b.setVisibility(8);
                }
                com.kwad.sdk.reward.c.a().b();
            }
        };
    }

    private void r() {
        ax.b(this.f41004f);
        this.f41004f = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f41006h);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        r();
        ((com.kwad.sdk.reward.g) this).a.b(this.f41006h);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsToastView ksToastView = (KsToastView) a(R.id.obfuscated_res_0x7f091153);
        this.f41000b = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.presenter.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.f41005g = true;
                h.this.f41000b.setVisibility(8);
                com.kwad.sdk.reward.c.a().b();
            }
        });
        float aw = com.kwad.sdk.core.config.b.aw();
        this.f41003e = aw;
        this.f41001c = (aw == 0.0f || aw == 1.0f) ? false : true;
    }
}
