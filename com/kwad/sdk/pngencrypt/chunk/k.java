package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f36447h;
    public int i;
    public byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.i = com.kwad.sdk.pngencrypt.n.c(dVar.f36432d, 0);
        this.f36447h = dVar.f36429a - 4;
        this.j = dVar.f36432d;
    }
}
