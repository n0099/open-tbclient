package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes8.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f55637h;

    /* renamed from: i  reason: collision with root package name */
    public int f55638i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f55637h = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 0);
        this.f55638i = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 4);
    }
}
