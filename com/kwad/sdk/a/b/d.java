package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f32238b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32239c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.d.1
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
        if (this.f32238b.getVisibility() != 0) {
            return;
        }
        this.f32238b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.ksad.download.d.b.a(this.f32238b.getContext())) {
            this.f32238b.setVisibility(8);
            return;
        }
        this.f32238b.setVisibility(0);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.a(this.f32239c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32239c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32238b = b(R.id.ksad_video_network_unavailable);
    }
}
