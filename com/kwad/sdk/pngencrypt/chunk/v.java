package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public final class v extends t {
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i >= bArr.length) {
                i = -1;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0 || i > dVar.data.length - 2) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("bad zTXt chunk: no separator found"));
        }
        this.key = b.d(dVar.data, 0, i);
        if (dVar.data[i + 1] != 0) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("bad zTXt chunk: unknown compression method"));
        }
        byte[] bArr2 = dVar.data;
        this.amp = b.i(b.b(bArr2, i + 2, (bArr2.length - i) - 2, false));
    }
}
