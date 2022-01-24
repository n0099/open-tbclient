package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class g extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57120h;

    /* renamed from: i  reason: collision with root package name */
    public int f57121i;

    public g(com.kwad.sdk.pngencrypt.k kVar) {
        super("acTL", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f57120h = com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 0);
        this.f57121i = com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 4);
    }
}
