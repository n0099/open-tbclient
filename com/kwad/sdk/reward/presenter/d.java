package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.e;
/* loaded from: classes8.dex */
public class d extends com.kwad.sdk.reward.g implements e.a {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f56033b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f56034c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.utils.e f56035d;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f55769g);
        this.f56033b = j2;
        com.kwad.sdk.utils.e eVar = this.f56035d;
        if (eVar == null) {
            this.f56035d = new com.kwad.sdk.utils.e(com.kwad.sdk.core.response.a.a.v(j2));
        } else {
            eVar.a(com.kwad.sdk.core.response.a.a.v(j2));
        }
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        this.f56034c = aVar.k;
        this.f56035d.a(aVar.f55771i, this);
    }

    @Override // com.kwad.sdk.utils.e.a
    public void a(String str) {
        com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.g) this).a.f55764b;
        if (bVar != null) {
            bVar.e();
        }
        this.f56034c.e();
        ((com.kwad.sdk.reward.g) this).a.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56035d.a(((com.kwad.sdk.reward.g) this).a.f55771i);
    }
}
