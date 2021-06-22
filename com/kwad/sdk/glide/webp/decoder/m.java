package com.kwad.sdk.glide.webp.decoder;
/* loaded from: classes7.dex */
public class m extends com.kwad.sdk.glide.load.resource.b.b<k> implements com.kwad.sdk.glide.load.engine.o {
    public m(k kVar) {
        super(kVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public Class<k> a() {
        return k.class;
    }

    @Override // com.kwad.sdk.glide.load.resource.b.b, com.kwad.sdk.glide.load.engine.o
    public void b() {
        ((k) this.f36425a).b().prepareToDraw();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return ((k) this.f36425a).a();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        ((k) this.f36425a).stop();
        ((k) this.f36425a).g();
    }
}
