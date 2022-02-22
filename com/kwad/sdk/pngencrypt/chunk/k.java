package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes4.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f57298h;

    /* renamed from: i  reason: collision with root package name */
    public int f57299i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f57300j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f57299i = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 0);
        this.f57298h = dVar.a - 4;
        this.f57300j = dVar.f57279d;
    }
}
