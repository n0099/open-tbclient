package com.kwad.sdk.a.b;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f31665b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31666c = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            if (e.this.f31665b != null) {
                e.this.f31665b.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            if (e.this.f31665b != null) {
                e.this.f31665b.onVideoPlayStart();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (e.this.f31665b != null) {
                e.this.f31665b.onVideoPlayComplete();
            }
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31630a;
        this.f31665b = bVar.f31632b;
        bVar.f31636f.a(this.f31666c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.b(this.f31666c);
    }
}
