package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes8.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f55648h;

    /* renamed from: i  reason: collision with root package name */
    public int f55649i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f55650j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f55649i = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 0);
        this.f55648h = dVar.a - 4;
        this.f55650j = dVar.f55629d;
    }
}
