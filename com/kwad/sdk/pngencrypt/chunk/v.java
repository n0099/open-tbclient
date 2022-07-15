package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i = 0;
        while (true) {
            byte[] bArr = dVar.d;
            if (i >= bArr.length) {
                i = -1;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > dVar.d.length - 2) {
            com.kwad.sdk.core.d.b.a(new PngjException("bad zTXt chunk: no separator found"));
        }
        ((t) this).h = b.a(dVar.d, 0, i);
        if (dVar.d[i + 1] != 0) {
            com.kwad.sdk.core.d.b.a(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = dVar.d;
        this.i = b.a(b.a(bArr2, i + 2, (bArr2.length - i) - 2, false));
    }
}
