package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public final class j extends t {
    public boolean aKK;
    public String aKL;
    public String aKM;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.aKK = false;
        this.aKL = "";
        this.aKM = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        boolean z;
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i >= bArr.length) {
                break;
            }
            if (bArr[i] == 0) {
                iArr[i2] = i;
                i2++;
                if (i2 == 1) {
                    i += 2;
                }
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        if (i2 != 3) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i3 = iArr[0] + 1;
        if (dVar.data[i3] == 0) {
            z = false;
        } else {
            z = true;
        }
        this.aKK = z;
        int i4 = i3 + 1;
        if (z && dVar.data[i4] != 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.aKL = b.d(dVar.data, i4, iArr[1] - i4);
        this.aKM = b.e(dVar.data, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i5 = iArr[2] + 1;
        if (this.aKK) {
            byte[] bArr2 = dVar.data;
            this.aLe = b.j(b.b(bArr2, i5, bArr2.length - i5, false));
            return;
        }
        byte[] bArr3 = dVar.data;
        this.aLe = b.e(bArr3, i5, bArr3.length - i5);
    }
}
