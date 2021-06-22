package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f36976h;

    /* renamed from: i  reason: collision with root package name */
    public int f36977i;
    public byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f36977i = com.kwad.sdk.pngencrypt.n.c(dVar.f36957d, 0);
        this.f36976h = dVar.f36954a - 4;
        this.j = dVar.f36957d;
    }
}
