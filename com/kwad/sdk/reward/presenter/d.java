package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.e;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.reward.g implements e.a {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f40984b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f40985c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.utils.e f40986d;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f40747g);
        this.f40984b = j;
        com.kwad.sdk.utils.e eVar = this.f40986d;
        if (eVar == null) {
            this.f40986d = new com.kwad.sdk.utils.e(com.kwad.sdk.core.response.a.a.v(j));
        } else {
            eVar.a(com.kwad.sdk.core.response.a.a.v(j));
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f40985c = aVar.k;
        this.f40986d.a(aVar.i, this);
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.g) this).a.f40742b;
        if (bVar != null) {
            bVar.e();
        }
        this.f40985c.e();
        ((com.kwad.sdk.reward.g) this).a.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f40986d.a(((com.kwad.sdk.reward.g) this).a.i);
    }
}
