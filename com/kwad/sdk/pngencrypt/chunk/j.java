package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class j extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f33416h;

    /* renamed from: i  reason: collision with root package name */
    public int f33417i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte o;
    public byte p;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("fcTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f33416h = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 0);
        this.f33417i = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 4);
        this.j = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 8);
        this.k = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 12);
        this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 16);
        this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 20);
        this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f33399d, 22);
        byte[] bArr = dVar.f33399d;
        this.o = bArr[24];
        this.p = bArr[25];
    }
}
