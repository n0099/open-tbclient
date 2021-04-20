package com.kwad.sdk.a.b;

import android.widget.ProgressBar;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class k extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f32020b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32021c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.k.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            k.this.a(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f32020b.setProgress(i);
        if (this.f32020b.getVisibility() == 0) {
            return;
        }
        this.f32020b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f32020b.getVisibility() != 0) {
            return;
        }
        this.f32020b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32020b.setProgress(0);
        this.f32020b.setVisibility(8);
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.a(this.f32021c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.f32021c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32020b = (ProgressBar) b(R.id.ksad_video_progress);
    }
}
