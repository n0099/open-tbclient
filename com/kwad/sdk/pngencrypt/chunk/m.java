package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public final class m extends p {
    public int h;
    public int[] i;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.h = 0;
    }

    private void a(int i, int i2, int i3, int i4) {
        this.i[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    private void b(int i) {
        this.h = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.h);
        }
        int[] iArr = this.i;
        if (iArr == null || iArr.length != i) {
            this.i = new int[this.h];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        b(dVar.a / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.h) {
            byte[] bArr = dVar.d;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            a(i, bArr[i2] & 255, bArr[i3] & 255, bArr[i4] & 255);
            i++;
            i2 = i4 + 1;
        }
    }
}
