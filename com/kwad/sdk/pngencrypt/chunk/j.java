package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes4.dex */
public class j extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f57295h;

    /* renamed from: i  reason: collision with root package name */
    public int f57296i;

    /* renamed from: j  reason: collision with root package name */
    public int f57297j;
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
        this.f57295h = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 0);
        this.f57296i = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 4);
        this.f57297j = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 8);
        this.k = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 12);
        this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 16);
        this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 20);
        this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 22);
        byte[] bArr = dVar.f57279d;
        this.o = bArr[24];
        this.p = bArr[25];
    }
}
