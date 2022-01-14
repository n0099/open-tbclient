package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class k extends s {

    /* renamed from: h  reason: collision with root package name */
    public int f57086h;

    /* renamed from: i  reason: collision with root package name */
    public int f57087i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f57088j;

    public k(com.kwad.sdk.pngencrypt.k kVar) {
        super("fdAT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        this.f57087i = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 0);
        this.f57086h = dVar.a - 4;
        this.f57088j = dVar.f57067d;
    }
}
