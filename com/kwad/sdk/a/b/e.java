package com.kwad.sdk.a.b;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32491b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f32492c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            if (e.this.f32491b != null) {
                e.this.f32491b.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (e.this.f32491b != null) {
                e.this.f32491b.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (e.this.f32491b != null) {
                e.this.f32491b.onVideoPlayComplete();
            }
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32456a;
        this.f32491b = bVar.f32458b;
        bVar.f32462f.a(this.f32492c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.b(this.f32492c);
    }
}
