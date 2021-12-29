package com.kwad.sdk.f.a;

import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public View f59032b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59033c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.d.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            d.this.e();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void d() {
            super.d();
            d.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f59032b.getVisibility() != 0) {
            return;
        }
        this.f59032b.setVisibility(8);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        if (com.ksad.download.c.b.a(this.f59032b.getContext())) {
            this.f59032b.setVisibility(8);
            return;
        }
        this.f59032b.setVisibility(0);
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.a(this.f59033c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f59086f.b(this.f59033c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59032b = a(R.id.ksad_video_network_unavailable);
    }
}
