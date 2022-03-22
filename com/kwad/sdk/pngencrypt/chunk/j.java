package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class j extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f40654h;
    public int i;
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
        this.f40654h = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 0);
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 4);
        this.j = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 8);
        this.k = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 12);
        this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f40643d, 16);
        this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 20);
        this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, 22);
        byte[] bArr = dVar.f40643d;
        this.o = bArr[24];
        this.p = bArr[25];
    }
}
