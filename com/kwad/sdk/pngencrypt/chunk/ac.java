package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class ac extends aa {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public ac(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f10503a != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.h = com.kwad.sdk.pngencrypt.n.b(dVar.d, 0);
        this.i = com.kwad.sdk.pngencrypt.n.a(dVar.d, 2);
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.d, 3);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.d, 6);
    }
}
