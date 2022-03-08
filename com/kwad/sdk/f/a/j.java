package com.kwad.sdk.f.a;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class j extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public View f55396b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55397c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.j.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            j.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f55396b.getVisibility() == 0) {
            return;
        }
        this.f55396b.setVisibility(0);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55396b.setVisibility(8);
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.a(this.f55397c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55397c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55396b = a(R.id.ksad_video_error_container);
    }
}
