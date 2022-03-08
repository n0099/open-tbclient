package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes8.dex */
public class j extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f55645h;

    /* renamed from: i  reason: collision with root package name */
    public int f55646i;

    /* renamed from: j  reason: collision with root package name */
    public int f55647j;
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
        this.f55645h = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 0);
        this.f55646i = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 4);
        this.f55647j = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 8);
        this.k = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 12);
        this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 16);
        this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 20);
        this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 22);
        byte[] bArr = dVar.f55629d;
        this.o = bArr[24];
        this.p = bArr[25];
    }
}
