package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public final class j extends t {
    public boolean j;
    public String k;
    public String l;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.j = false;
        this.k = "";
        this.l = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.d;
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
            com.kwad.sdk.core.d.b.a(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        ((t) this).h = b.a(dVar.d, 0, iArr[0]);
        int i3 = iArr[0] + 1;
        boolean z = dVar.d[i3] != 0;
        this.j = z;
        int i4 = i3 + 1;
        if (z && dVar.d[i4] != 0) {
            com.kwad.sdk.core.d.b.a(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.k = b.a(dVar.d, i4, iArr[1] - i4);
        this.l = b.b(dVar.d, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i5 = iArr[2] + 1;
        boolean z2 = this.j;
        byte[] bArr2 = dVar.d;
        this.i = z2 ? b.b(b.a(bArr2, i5, bArr2.length - i5, false)) : b.b(bArr2, i5, bArr2.length - i5);
    }
}
