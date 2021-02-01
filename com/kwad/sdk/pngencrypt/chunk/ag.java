package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class ag extends ae {
    public ag(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i = 0;
        while (true) {
            if (i >= dVar.d.length) {
                i = -1;
                break;
            } else if (dVar.d[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > dVar.d.length - 2) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.h = b.a(dVar.d, 0, i);
        if (dVar.d[i + 1] != 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        this.i = b.a(b.a(dVar.d, i + 2, (dVar.d.length - i) - 2, false));
    }
}
