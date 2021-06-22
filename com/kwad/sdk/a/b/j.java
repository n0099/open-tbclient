package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class j extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f32369b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32370c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.j.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            j.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f32369b.getVisibility() == 0) {
            return;
        }
        this.f32369b.setVisibility(0);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32369b.setVisibility(8);
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.a(this.f32370c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.b(this.f32370c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32369b = b(R.id.ksad_video_error_container);
    }
}
