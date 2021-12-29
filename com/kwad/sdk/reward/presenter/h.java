package com.kwad.sdk.reward.presenter;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KsToastView;
/* loaded from: classes3.dex */
public class h extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public KsToastView f59745b;

    /* renamed from: e  reason: collision with root package name */
    public float f59748e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f59749f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59746c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59747d = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59750g = false;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f59751h = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.h.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            h.this.f59745b.setVisibility(8);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59752i = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.h.2
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            super.a(j2, j3);
            if (j2 < 10000 || !h.this.f59746c || ((float) j3) < ((float) j2) * h.this.f59748e) {
                return;
            }
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f59747d) {
            return;
        }
        this.f59747d = true;
        this.f59745b.setVisibility(0);
        this.f59745b.a(3);
        i();
        ax.a(this.f59749f, null, 3000L);
    }

    private void i() {
        this.f59749f = new Runnable() { // from class: com.kwad.sdk.reward.presenter.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f59750g) {
                    return;
                }
                if (h.this.f59745b != null) {
                    h.this.f59745b.setVisibility(8);
                }
                com.kwad.sdk.reward.c.a().b();
            }
        };
    }

    private void r() {
        ax.b(this.f59749f);
        this.f59749f = null;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f59751h);
        ((com.kwad.sdk.reward.g) this).a.f59459k.a(this.f59752i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        r();
        ((com.kwad.sdk.reward.g) this).a.b(this.f59751h);
        ((com.kwad.sdk.reward.g) this).a.f59459k.b(this.f59752i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsToastView ksToastView = (KsToastView) a(R.id.ksad_toast_view);
        this.f59745b = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.presenter.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.f59750g = true;
                h.this.f59745b.setVisibility(8);
                com.kwad.sdk.reward.c.a().b();
            }
        });
        float aw = com.kwad.sdk.core.config.b.aw();
        this.f59748e = aw;
        this.f59746c = (aw == 0.0f || aw == 1.0f) ? false : true;
    }
}
