package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes6.dex */
public class c<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f35920a;

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = (com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f35901b.f35905g;
        this.f35920a = cVar;
        cVar.k();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35920a.h();
    }
}
