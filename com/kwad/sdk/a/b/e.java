package com.kwad.sdk.a.b;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32241b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32242c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (e.this.f32241b != null) {
                e.this.f32241b.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            if (e.this.f32241b != null) {
                e.this.f32241b.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (e.this.f32241b != null) {
                e.this.f32241b.onVideoPlayStart();
            }
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32206a;
        this.f32241b = bVar.f32208b;
        bVar.f32212f.a(this.f32242c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32242c);
    }
}
