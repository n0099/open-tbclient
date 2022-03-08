package com.kwad.sdk.reward.presenter;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class e extends com.kwad.sdk.reward.g {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f56036b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f56037c;

    /* renamed from: d  reason: collision with root package name */
    public long f56038d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f56039e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            e.this.f56036b.a(i2, i3);
            e.this.h();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j2, long j3) {
            if (((com.kwad.sdk.reward.g) e.this).a.u) {
                return;
            }
            e.this.f56038d = j3;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            e.this.f56036b.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (((com.kwad.sdk.reward.g) e.this).a.r && ((com.kwad.sdk.reward.g) e.this).a.u) {
                e.this.f56036b.a(e.this.f56038d);
            } else {
                e.this.f56036b.d();
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f56036b = aVar.f55764b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.f56037c = aVar2;
        aVar2.a(this.f56039e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56037c.b(this.f56039e);
    }
}
