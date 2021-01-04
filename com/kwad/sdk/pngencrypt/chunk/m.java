package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class m extends aa {
    private int[] h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.e.g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.h = new int[dVar.d.length / 2];
        for (int i = 0; i < this.h.length; i++) {
            this.h[i] = com.kwad.sdk.pngencrypt.n.b(dVar.d, i * 2);
        }
    }
}
