package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f33418h;

    /* renamed from: i  reason: collision with root package name */
    public int f33419i;
    public byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f33419i = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 0);
        this.f33418h = dVar.f33396a - 4;
        this.j = dVar.f33399d;
    }
}
