package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f59311h;

    /* renamed from: i  reason: collision with root package name */
    public int f59312i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f59311h = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 0);
        this.f59312i = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 4);
    }
}
