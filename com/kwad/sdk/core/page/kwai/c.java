package com.kwad.sdk.core.page.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class c extends g {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f54512b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f54513c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f54514d = new e() { // from class: com.kwad.sdk.core.page.kwai.c.1
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
        this.f54512b = aVar.f55764b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.f54513c = aVar2;
        aVar2.a(this.f54514d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f54513c.b(this.f54514d);
    }
}
