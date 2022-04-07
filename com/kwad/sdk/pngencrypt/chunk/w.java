package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class w extends aa {
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i = this.e.f ? 1 : 3;
        return this.e.e ? i + 1 : i;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a;
        if (dVar.a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.e.f) {
            this.h = com.kwad.sdk.pngencrypt.n.a(dVar.d, 0);
            if (!this.e.e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.d, 2);
            if (!this.e.e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.d, 3);
        }
        this.i = a;
    }
}
