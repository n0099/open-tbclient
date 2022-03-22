package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f40651h;
    public int i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f40651h = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 0);
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 4);
    }
}
