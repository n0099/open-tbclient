package com.kwad.sdk.reward.presenter;

import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.reward.g {
    @NonNull
    public com.kwad.sdk.reward.a.b b;
    public com.kwad.sdk.reward.c.a c;
    public long d;
    public final com.kwad.sdk.contentalliance.detail.video.d e = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.reward.presenter.e.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
            e.this.b.a(i, i2);
            e.this.h();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (((com.kwad.sdk.reward.g) e.this).a.u) {
                return;
            }
            e.this.d = j2;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            e.this.b.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            if (((com.kwad.sdk.reward.g) e.this).a.r && ((com.kwad.sdk.reward.g) e.this).a.u) {
                e.this.b.a(e.this.d);
            } else {
                e.this.b.d();
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.b = aVar.b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.c = aVar2;
        aVar2.a(this.e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c.b(this.e);
    }
}
