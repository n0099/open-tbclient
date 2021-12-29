package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class j extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f59321h;

    /* renamed from: i  reason: collision with root package name */
    public int f59322i;

    /* renamed from: j  reason: collision with root package name */
    public int f59323j;

    /* renamed from: k  reason: collision with root package name */
    public int f59324k;
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
        this.f59321h = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 0);
        this.f59322i = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 4);
        this.f59323j = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 8);
        this.f59324k = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 12);
        this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 16);
        this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 20);
        this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 22);
        byte[] bArr = dVar.f59303d;
        this.o = bArr[24];
        this.p = bArr[25];
    }
}
