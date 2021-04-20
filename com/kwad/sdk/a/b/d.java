package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f31985b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31986c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f31985b.getVisibility() != 0) {
            return;
        }
        this.f31985b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.ksad.download.d.b.a(this.f31985b.getContext())) {
            this.f31985b.setVisibility(8);
            return;
        }
        this.f31985b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.a(this.f31986c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.f31986c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31985b = b(R.id.ksad_video_network_unavailable);
    }
}
