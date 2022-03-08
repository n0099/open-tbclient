package com.kwad.sdk.f.a;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes8.dex */
public class e extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f55373b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55374c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            if (e.this.f55373b != null) {
                e.this.f55373b.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (e.this.f55373b != null) {
                e.this.f55373b.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (e.this.f55373b != null) {
                e.this.f55373b.onVideoPlayComplete();
            }
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f55373b = bVar.f55419b;
        bVar.f55423f.a(this.f55374c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55374c);
    }
}
