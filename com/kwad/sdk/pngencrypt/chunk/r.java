package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class r extends ae {
    private boolean j;
    private String k;
    private String l;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.j = false;
        this.k = "";
        this.l = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (i < dVar.d.length) {
            if (dVar.d[i] == 0) {
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
            com.kwad.sdk.core.d.a.a(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.h = b.a(dVar.d, 0, iArr[0]);
        int i3 = iArr[0] + 1;
        this.j = dVar.d[i3] != 0;
        int i4 = i3 + 1;
        if (this.j && dVar.d[i4] != 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.k = b.a(dVar.d, i4, iArr[1] - i4);
        this.l = b.b(dVar.d, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i5 = iArr[2] + 1;
        if (this.j) {
            this.i = b.b(b.a(dVar.d, i5, dVar.d.length - i5, false));
        } else {
            this.i = b.b(dVar.d, i5, dVar.d.length - i5);
        }
    }
}
