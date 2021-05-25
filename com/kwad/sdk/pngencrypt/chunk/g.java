package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes6.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33410h;

    /* renamed from: i  reason: collision with root package name */
    public int f33411i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f33410h = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 0);
        this.f33411i = com.kwad.sdk.pngencrypt.n.c(dVar.f33399d, 4);
    }
}
