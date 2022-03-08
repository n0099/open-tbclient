package com.kwad.sdk.f.a;

import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class k extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f55398b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55399c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.k.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            k.this.b(j2 != 0 ? (int) ((((float) j3) * 100.0f) / ((float) j2)) : 0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            k.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f55398b.setProgress(i2);
        if (this.f55398b.getVisibility() == 0) {
            return;
        }
        this.f55398b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f55398b.getVisibility() != 0) {
            return;
        }
        this.f55398b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55398b.setProgress(0);
        this.f55398b.setVisibility(8);
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.a(this.f55399c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55399c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55398b = (ProgressBar) a(R.id.ksad_video_progress);
    }
}
