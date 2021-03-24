package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36153h;
    public int i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f36153h = com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 0);
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 4);
    }
}
