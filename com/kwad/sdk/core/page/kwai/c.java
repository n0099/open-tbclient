package com.kwad.sdk.core.page.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class c extends g {
    @NonNull
    public com.kwad.sdk.reward.a.b b;
    public com.kwad.sdk.reward.c.a c;
    public com.kwad.sdk.contentalliance.detail.video.d d = new e() { // from class: com.kwad.sdk.core.page.kwai.c.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(int i, int i2) {
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
        this.b = aVar.b;
        com.kwad.sdk.reward.c.a aVar2 = aVar.k;
        this.c = aVar2;
        aVar2.a(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c.b(this.d);
    }
}
