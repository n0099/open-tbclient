package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.e;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.reward.g implements e.a {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f57471b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f57472c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.utils.e f57473d;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f57207g);
        this.f57471b = j2;
        com.kwad.sdk.utils.e eVar = this.f57473d;
        if (eVar == null) {
            this.f57473d = new com.kwad.sdk.utils.e(com.kwad.sdk.core.response.a.a.v(j2));
        } else {
            eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f57472c = aVar.k;
        this.f57473d.a(aVar.f57209i, this);
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.g) this).a.f57202b;
        if (bVar != null) {
            bVar.e();
        }
        this.f57472c.e();
        ((com.kwad.sdk.reward.g) this).a.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57473d.a(((com.kwad.sdk.reward.g) this).a.f57209i);
    }
}
