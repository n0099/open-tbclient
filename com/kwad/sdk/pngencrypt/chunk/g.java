package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33481h;

    /* renamed from: i  reason: collision with root package name */
    public int f33482i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f33481h = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 0);
        this.f33482i = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 4);
    }
}
