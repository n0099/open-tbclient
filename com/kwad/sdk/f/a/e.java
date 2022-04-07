package com.kwad.sdk.f.a;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.f.kwai.a {
    public KsNativeAd.VideoPlayListener b;
    public com.kwad.sdk.contentalliance.detail.video.d c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            if (e.this.b != null) {
                e.this.b.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (e.this.b != null) {
                e.this.b.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (e.this.b != null) {
                e.this.b.onVideoPlayComplete();
            }
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.b = bVar.b;
        bVar.f.a(this.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f.b(this.c);
    }
}
