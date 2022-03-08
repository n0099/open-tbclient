package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes8.dex */
public class ac extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f55613h;

    /* renamed from: i  reason: collision with root package name */
    public int f55614i;

    /* renamed from: j  reason: collision with root package name */
    public int f55615j;
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
        this.f55613h = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, 0);
        this.f55614i = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 2);
        this.f55615j = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 3);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 6);
    }
}
