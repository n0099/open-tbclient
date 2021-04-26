package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class ag extends ae {
    public ag(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.f34225d;
            if (i2 >= bArr.length) {
                i2 = -1;
                break;
            } else if (bArr[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 > dVar.f34225d.length - 2) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: no separator found"));
        }
        ((ae) this).f34212h = b.a(dVar.f34225d, 0, i2);
        if (dVar.f34225d[i2 + 1] != 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = dVar.f34225d;
        this.f34213i = b.a(b.a(bArr2, i2 + 2, (bArr2.length - i2) - 2, false));
    }
}
