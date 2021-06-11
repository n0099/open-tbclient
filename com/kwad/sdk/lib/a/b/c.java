package com.kwad.sdk.lib.a.b;

import com.kwad.sdk.lib.a.a.b;
/* loaded from: classes7.dex */
public class c<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f36624a;

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = (com.kwad.sdk.lib.b.c<?, MODEL>) ((com.kwad.sdk.lib.a.a.a) this).f36604b.f36608g;
        this.f36624a = cVar;
        cVar.k();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f36624a.h();
    }
}
