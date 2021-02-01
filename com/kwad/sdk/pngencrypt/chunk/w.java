package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class w extends aa {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i = this.e.f ? 1 : 3;
        return this.e.e ? i + 1 : i;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f10503a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.e.f) {
            this.h = com.kwad.sdk.pngencrypt.n.a(dVar.d, 0);
            if (this.e.e) {
                this.i = com.kwad.sdk.pngencrypt.n.a(dVar.d, 1);
                return;
            }
            return;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.d, 0);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.d, 1);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.d, 2);
        if (this.e.e) {
            this.i = com.kwad.sdk.pngencrypt.n.a(dVar.d, 3);
        }
    }
}
