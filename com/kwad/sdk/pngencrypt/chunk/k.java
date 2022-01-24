package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f57131h;

    /* renamed from: i  reason: collision with root package name */
    public int f57132i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f57133j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f57132i = com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 0);
        this.f57131h = dVar.a - 4;
        this.f57133j = dVar.f57112d;
    }
}
