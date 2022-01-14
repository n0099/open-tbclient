package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57075h;

    /* renamed from: i  reason: collision with root package name */
    public int f57076i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f57075h = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 0);
        this.f57076i = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 4);
    }
}
