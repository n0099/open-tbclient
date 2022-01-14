package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class ac extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57051h;

    /* renamed from: i  reason: collision with root package name */
    public int f57052i;

    /* renamed from: j  reason: collision with root package name */
    public int f57053j;
    public int k;
    public int l;
    public int m;

    public ac(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.f57051h = com.kwad.sdk.pngencrypt.n.b(dVar.f57067d, 0);
        this.f57052i = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 2);
        this.f57053j = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 3);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 6);
    }
}
