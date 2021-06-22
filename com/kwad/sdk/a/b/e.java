package com.kwad.sdk.a.b;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f32339b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32340c = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (e.this.f32339b != null) {
                e.this.f32339b.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i2, int i3) {
            if (e.this.f32339b != null) {
                e.this.f32339b.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            if (e.this.f32339b != null) {
                e.this.f32339b.onVideoPlayStart();
            }
        }
    };

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32304a;
        this.f32339b = bVar.f32306b;
        bVar.f32310f.a(this.f32340c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.b(this.f32340c);
    }
}
