package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f31662b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31663c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f31662b.getVisibility() != 0) {
            return;
        }
        this.f31662b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.ksad.download.d.b.a(this.f31662b.getContext())) {
            this.f31662b.setVisibility(8);
            return;
        }
        this.f31662b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.a(this.f31663c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31662b = a(R.id.ksad_video_network_unavailable);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.b(this.f31663c);
    }
}
