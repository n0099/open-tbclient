package com.kwad.sdk.a.b;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.a.a.a {
    private KsNativeAd.VideoPlayListener b;
    private com.kwad.sdk.contentalliance.detail.video.e c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (e.this.b != null) {
                e.this.b.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            if (e.this.b != null) {
                e.this.b.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (e.this.b != null) {
                e.this.b.onVideoPlayStart();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b = this.f5425a.b;
        this.f5425a.f.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f5425a.f.b(this.c);
    }
}
