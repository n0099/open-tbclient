package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes4.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57287h;

    /* renamed from: i  reason: collision with root package name */
    public int f57288i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f57287h = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 0);
        this.f57288i = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 4);
    }
}
