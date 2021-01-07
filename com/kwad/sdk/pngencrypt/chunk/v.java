package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public class v extends aa {
    private int h;
    private int[] i;

    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.h = 0;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i = 0;
        b(dVar.f10801a / 3);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 >= this.h) {
                return;
            }
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            i2 = i5 + 1;
            a(i3, dVar.d[i2] & 255, dVar.d[i4] & 255, dVar.d[i5] & 255);
            i = i3 + 1;
        }
    }

    public void b(int i) {
        this.h = i;
        if (this.h < 1 || this.h > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.h);
        }
        if (this.i == null || this.i.length != this.h) {
            this.i = new int[this.h];
        }
    }
}
