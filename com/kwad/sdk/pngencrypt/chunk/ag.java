package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class ag extends ae {
    public ag(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.f36859d;
            if (i2 >= bArr.length) {
                i2 = -1;
                break;
            } else if (bArr[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 > dVar.f36859d.length - 2) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: no separator found"));
        }
        ((ae) this).f36846h = b.a(dVar.f36859d, 0, i2);
        if (dVar.f36859d[i2 + 1] != 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = dVar.f36859d;
        this.f36847i = b.a(b.a(bArr2, i2 + 2, (bArr2.length - i2) - 2, false));
    }
}
