package com.kwad.sdk.a.b;

import android.widget.ProgressBar;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class k extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f31730b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31731c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.k.1
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
        this.f31730b.setProgress(i);
        if (this.f31730b.getVisibility() == 0) {
            return;
        }
        this.f31730b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f31730b.getVisibility() != 0) {
            return;
        }
        this.f31730b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f31730b.setProgress(0);
        this.f31730b.setVisibility(8);
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.a(this.f31731c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.b(this.f31731c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31730b = (ProgressBar) b(R.id.ksad_video_progress);
    }
}
