package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class j extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f32017b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32018c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.j.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            j.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f32017b.getVisibility() == 0) {
            return;
        }
        this.f32017b.setVisibility(0);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32017b.setVisibility(8);
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.a(this.f32018c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.f32018c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32017b = b(R.id.ksad_video_error_container);
    }
}
