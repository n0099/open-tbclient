package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes4.dex */
public class ac extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57263h;

    /* renamed from: i  reason: collision with root package name */
    public int f57264i;

    /* renamed from: j  reason: collision with root package name */
    public int f57265j;
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
        this.f57263h = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, 0);
        this.f57264i = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 2);
        this.f57265j = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 3);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 6);
    }
}
