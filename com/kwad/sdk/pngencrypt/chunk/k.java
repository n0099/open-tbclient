package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f34244h;

    /* renamed from: i  reason: collision with root package name */
    public int f34245i;
    public byte[] j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f34245i = com.kwad.sdk.pngencrypt.n.c(dVar.f34225d, 0);
        this.f34244h = dVar.f34222a - 4;
        this.j = dVar.f34225d;
    }
}
