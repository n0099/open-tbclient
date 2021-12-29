package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f59325h;

    /* renamed from: i  reason: collision with root package name */
    public int f59326i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f59327j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f59326i = com.kwad.sdk.pngencrypt.n.c(dVar.f59303d, 0);
        this.f59325h = dVar.a - 4;
        this.f59327j = dVar.f59303d;
    }
}
