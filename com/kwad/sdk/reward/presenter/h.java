package com.kwad.sdk.reward.presenter;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KsToastView;
/* loaded from: classes4.dex */
public class h extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public KsToastView f57699b;

    /* renamed from: e  reason: collision with root package name */
    public float f57702e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f57703f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57700c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57701d = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57704g = false;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f57705h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.h.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            h.this.f57699b.setVisibility(8);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57706i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.h.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            if (j2 < 10000 || !h.this.f57700c || ((float) j3) < ((float) j2) * h.this.f57702e) {
                return;
            }
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f57701d) {
            return;
        }
        this.f57701d = true;
        this.f57699b.setVisibility(0);
        this.f57699b.a(3);
        i();
        ax.a(this.f57703f, null, 3000L);
    }

    private void i() {
        this.f57703f = new Runnable() { // from class: com.kwad.sdk.reward.presenter.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f57704g) {
                    return;
                }
                if (h.this.f57699b != null) {
                    h.this.f57699b.setVisibility(8);
                }
                com.kwad.sdk.reward.c.a().b();
            }
        };
    }

    private void r() {
        ax.b(this.f57703f);
        this.f57703f = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f57705h);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.f57706i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        r();
        ((com.kwad.sdk.reward.g) this).a.b(this.f57705h);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.f57706i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsToastView ksToastView = (KsToastView) a(R.id.ksad_toast_view);
        this.f57699b = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.presenter.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.f57704g = true;
                h.this.f57699b.setVisibility(8);
                com.kwad.sdk.reward.c.a().b();
            }
        });
        float aw = com.kwad.sdk.core.config.b.aw();
        this.f57702e = aw;
        this.f57700c = (aw == 0.0f || aw == 1.0f) ? false : true;
    }
}
