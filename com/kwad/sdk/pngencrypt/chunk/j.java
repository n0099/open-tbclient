package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class j extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f57083h;

    /* renamed from: i  reason: collision with root package name */
    public int f57084i;

    /* renamed from: j  reason: collision with root package name */
    public int f57085j;
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
        this.f57083h = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 0);
        this.f57084i = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 4);
        this.f57085j = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 8);
        this.k = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 12);
        this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 16);
        this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 20);
        this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 22);
        byte[] bArr = dVar.f57067d;
        this.o = bArr[24];
        this.p = bArr[25];
    }
}
