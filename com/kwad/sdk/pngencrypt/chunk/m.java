package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class m extends aa {
    public int[] h;

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
        int i = 0;
        while (true) {
            int[] iArr = this.h;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = com.kwad.sdk.pngencrypt.n.b(dVar.d, i * 2);
            i++;
        }
    }
}
