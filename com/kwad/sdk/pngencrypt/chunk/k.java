package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f33489h;

    /* renamed from: i  reason: collision with root package name */
    public int f33490i;
    public byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f33490i = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 0);
        this.f33489h = dVar.f33467a - 4;
        this.j = dVar.f33470d;
    }
}
