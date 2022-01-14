package com.kwad.sdk.reward.presenter;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KsToastView;
/* loaded from: classes3.dex */
public class h extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public KsToastView f57487b;

    /* renamed from: e  reason: collision with root package name */
    public float f57490e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f57491f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57488c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57489d = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57492g = false;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f57493h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.h.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            h.this.f57487b.setVisibility(8);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f57494i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.h.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            if (j2 < 10000 || !h.this.f57488c || ((float) j3) < ((float) j2) * h.this.f57490e) {
                return;
            }
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f57489d) {
            return;
        }
        this.f57489d = true;
        this.f57487b.setVisibility(0);
        this.f57487b.a(3);
        i();
        ax.a(this.f57491f, null, 3000L);
    }

    private void i() {
        this.f57491f = new Runnable() { // from class: com.kwad.sdk.reward.presenter.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f57492g) {
                    return;
                }
                if (h.this.f57487b != null) {
                    h.this.f57487b.setVisibility(8);
                }
                com.kwad.sdk.reward.c.a().b();
            }
        };
    }

    private void r() {
        ax.b(this.f57491f);
        this.f57491f = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f57493h);
        ((com.kwad.sdk.reward.g) this).a.k.a(this.f57494i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        r();
        ((com.kwad.sdk.reward.g) this).a.b(this.f57493h);
        ((com.kwad.sdk.reward.g) this).a.k.b(this.f57494i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsToastView ksToastView = (KsToastView) a(R.id.ksad_toast_view);
        this.f57487b = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.presenter.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.f57492g = true;
                h.this.f57487b.setVisibility(8);
                com.kwad.sdk.reward.c.a().b();
            }
        });
        float aw = com.kwad.sdk.core.config.b.aw();
        this.f57490e = aw;
        this.f57488c = (aw == 0.0f || aw == 1.0f) ? false : true;
    }
}
