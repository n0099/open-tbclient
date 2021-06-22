package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36968h;

    /* renamed from: i  reason: collision with root package name */
    public int f36969i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f36968h = com.kwad.sdk.pngencrypt.n.c(dVar.f36957d, 0);
        this.f36969i = com.kwad.sdk.pngencrypt.n.c(dVar.f36957d, 4);
    }
}
