package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public final class m extends p {
    public int aKQ;
    public int[] aKR;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aKQ = 0;
    }

    private void dy(int i) {
        this.aKQ = i;
        if (i > 0 && i <= 256) {
            int[] iArr = this.aKR;
            if (iArr == null || iArr.length != i) {
                this.aKR = new int[this.aKQ];
                return;
            }
            return;
        }
        throw new PngjException("invalid pallette - nentries=" + this.aKQ);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        dy(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.aKQ) {
            byte[] bArr = dVar.data;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            a(i, bArr[i2] & 255, bArr[i3] & 255, bArr[i4] & 255);
            i++;
            i2 = i4 + 1;
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        this.aKR[i] = (i2 << 16) | (i3 << 8) | i4;
    }
}
