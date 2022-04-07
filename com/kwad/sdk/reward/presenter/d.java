package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.e;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.reward.g implements e.a {
    public AdInfo b;
    public com.kwad.sdk.reward.c.a c;
    public com.kwad.sdk.utils.e d;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.g);
        this.b = j;
        com.kwad.sdk.utils.e eVar = this.d;
        if (eVar == null) {
            this.d = new com.kwad.sdk.utils.e(com.kwad.sdk.core.response.a.a.v(j));
        } else {
            eVar.a(com.kwad.sdk.core.response.a.a.v(j));
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.c = aVar.k;
        this.d.a(aVar.i, this);
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.g) this).a.b;
        if (bVar != null) {
            bVar.e();
        }
        this.c.e();
        ((com.kwad.sdk.reward.g) this).a.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d.a(((com.kwad.sdk.reward.g) this).a.i);
    }
}
