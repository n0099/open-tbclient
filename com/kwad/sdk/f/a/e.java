package com.kwad.sdk.f.a;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.f.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f56856b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56857c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            if (e.this.f56856b != null) {
                e.this.f56856b.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (e.this.f56856b != null) {
                e.this.f56856b.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (e.this.f56856b != null) {
                e.this.f56856b.onVideoPlayComplete();
            }
        }
    };

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f56856b = bVar.f56902b;
        bVar.f56906f.a(this.f56857c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.b(this.f56857c);
    }
}
