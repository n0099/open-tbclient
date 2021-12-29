package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.e;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.reward.g implements e.a {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59729b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f59730c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.utils.e f59731d;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f59455g);
        this.f59729b = j2;
        com.kwad.sdk.utils.e eVar = this.f59731d;
        if (eVar == null) {
            this.f59731d = new com.kwad.sdk.utils.e(com.kwad.sdk.core.response.a.a.v(j2));
        } else {
            eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f59730c = aVar.f59459k;
        this.f59731d.a(aVar.f59457i, this);
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.g) this).a.f59450b;
        if (bVar != null) {
            bVar.e();
        }
        this.f59730c.e();
        ((com.kwad.sdk.reward.g) this).a.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f59731d.a(((com.kwad.sdk.reward.g) this).a.f59457i);
    }
}
