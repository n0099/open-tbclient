package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes9.dex */
public final class m extends p {
    public int amb;
    public int[] amc;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.amb = 0;
    }

    private void a(int i, int i2, int i3, int i4) {
        this.amc[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    private void bz(int i) {
        this.amb = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.amb);
        }
        int[] iArr = this.amc;
        if (iArr == null || iArr.length != i) {
            this.amc = new int[this.amb];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        bz(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.amb) {
            byte[] bArr = dVar.data;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            a(i, bArr[i2] & 255, bArr[i3] & 255, bArr[i4] & 255);
            i++;
            i2 = i4 + 1;
        }
    }
}
