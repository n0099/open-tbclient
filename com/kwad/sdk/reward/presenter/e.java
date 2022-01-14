package com.kwad.sdk.reward.presenter;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.reward.g {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f57474b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f57475c;

    /* renamed from: d  reason: collision with root package name */
    public long f57476d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f57477e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            e.this.f57474b.a(i2, i3);
            e.this.h();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (((com.kwad.sdk.reward.g) e.this).a.u) {
                return;
            }
            e.this.f57476d = j3;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            e.this.f57474b.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (((com.kwad.sdk.reward.g) e.this).a.r && ((com.kwad.sdk.reward.g) e.this).a.u) {
                e.this.f57474b.a(e.this.f57476d);
            } else {
                e.this.f57474b.d();
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f57474b = aVar.f57202b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.f57475c = aVar2;
        aVar2.a(this.f57477e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57475c.b(this.f57477e);
    }
}
