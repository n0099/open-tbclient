package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class ag extends ae {
    public ag(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i = 0;
        while (true) {
            byte[] bArr = dVar.f36527d;
            if (i >= bArr.length) {
                i = -1;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > dVar.f36527d.length - 2) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: no separator found"));
        }
        ((ae) this).f36515h = b.a(dVar.f36527d, 0, i);
        if (dVar.f36527d[i + 1] != 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = dVar.f36527d;
        this.i = b.a(b.a(bArr2, i + 2, (bArr2.length - i) - 2, false));
    }
}
