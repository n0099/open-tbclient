package com.kwad.sdk.core.page.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class c extends g {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f55950b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f55951c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55952d = new e() { // from class: com.kwad.sdk.core.page.kwai.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i2, int i3) {
            c.this.h();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f55950b = aVar.f57202b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.f55951c = aVar2;
        aVar2.a(this.f55952d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f55951c.b(this.f55952d);
    }
}
