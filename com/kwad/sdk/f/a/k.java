package com.kwad.sdk.f.a;

import android.widget.ProgressBar;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class k extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f59059b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59060c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.k.1
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
        this.f59059b.setProgress(i2);
        if (this.f59059b.getVisibility() == 0) {
            return;
        }
        this.f59059b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f59059b.getVisibility() != 0) {
            return;
        }
        this.f59059b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f59059b.setProgress(0);
        this.f59059b.setVisibility(8);
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.a(this.f59060c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.b(this.f59060c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59059b = (ProgressBar) a(R.id.ksad_video_progress);
    }
}
