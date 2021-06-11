package com.kwad.sdk.a.b;

import android.widget.ProgressBar;
import com.kwad.sdk.R;
/* loaded from: classes5.dex */
public class k extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f32274b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32275c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.k.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            k.this.a(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        this.f32274b.setProgress(i2);
        if (this.f32274b.getVisibility() == 0) {
            return;
        }
        this.f32274b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f32274b.getVisibility() != 0) {
            return;
        }
        this.f32274b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32274b.setProgress(0);
        this.f32274b.setVisibility(8);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.a(this.f32275c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32275c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32274b = (ProgressBar) b(R.id.ksad_video_progress);
    }
}
