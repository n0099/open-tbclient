package com.kwad.sdk.a.b;

import android.widget.ProgressBar;
import com.kwad.sdk.R;
/* loaded from: classes6.dex */
public class k extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f31769b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31770c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.k.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            k.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            k.this.b(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            k.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f31769b.setProgress(i2);
        if (this.f31769b.getVisibility() == 0) {
            return;
        }
        this.f31769b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f31769b.getVisibility() != 0) {
            return;
        }
        this.f31769b.setVisibility(8);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f31769b.setProgress(0);
        this.f31769b.setVisibility(8);
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.a(this.f31770c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31769b = (ProgressBar) a(R.id.ksad_video_progress);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31770c);
    }
}
