package com.kwad.sdk.reward.presenter;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.reward.g {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f59732b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f59733c;

    /* renamed from: d  reason: collision with root package name */
    public long f59734d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f59735e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            e.this.f59732b.a(i2, i3);
            e.this.h();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (((com.kwad.sdk.reward.g) e.this).a.u) {
                return;
            }
            e.this.f59734d = j3;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            e.this.f59732b.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (((com.kwad.sdk.reward.g) e.this).a.r && ((com.kwad.sdk.reward.g) e.this).a.u) {
                e.this.f59732b.a(e.this.f59734d);
            } else {
                e.this.f59732b.d();
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f59732b = aVar.f59450b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.f59459k;
        this.f59733c = aVar2;
        aVar2.a(this.f59735e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f59733c.b(this.f59735e);
    }
}
