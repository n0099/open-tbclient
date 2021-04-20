package com.kwad.sdk.a.b;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f31988b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31989c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (e.this.f31988b != null) {
                e.this.f31988b.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            if (e.this.f31988b != null) {
                e.this.f31988b.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (e.this.f31988b != null) {
                e.this.f31988b.onVideoPlayStart();
            }
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31954a;
        this.f31988b = bVar.f31956b;
        bVar.f31960f.a(this.f31989c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.f31989c);
    }
}
