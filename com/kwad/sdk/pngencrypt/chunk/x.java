package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class x extends s {
    private String h;
    private int i;
    private int[] j;

    public x(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int b2;
        int b3;
        int b4;
        int b5;
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= dVar.d.length) {
                i2 = -1;
                break;
            } else if (dVar.d[i2] == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 <= 0 || i2 > dVar.d.length - 2) {
            throw new PngjException("bad sPLT chunk: no separator found");
        }
        this.h = b.a(dVar.d, 0, i2);
        this.i = com.kwad.sdk.pngencrypt.n.a(dVar.d, i2 + 1);
        int i3 = i2 + 2;
        int length = (dVar.d.length - i3) / (this.i == 8 ? 6 : 10);
        this.j = new int[length * 5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            if (this.i == 8) {
                int i6 = i3 + 1;
                b2 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i3);
                int i7 = i6 + 1;
                b3 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i6);
                int i8 = i7 + 1;
                b4 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i7);
                i = i8 + 1;
                b5 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i8);
            } else {
                b2 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i3);
                int i9 = i3 + 2;
                b3 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i9);
                int i10 = i9 + 2;
                b4 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i10);
                int i11 = i10 + 2;
                b5 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i11);
                i = i11 + 2;
            }
            int b6 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i);
            int i12 = i5 + 1;
            this.j[i5] = b2;
            int i13 = i12 + 1;
            this.j[i12] = b3;
            int i14 = i13 + 1;
            this.j[i13] = b4;
            int i15 = i14 + 1;
            this.j[i14] = b5;
            this.j[i15] = b6;
            i4++;
            i5 = i15 + 1;
            i3 = i + 2;
        }
    }

    public String c() {
        return this.h;
    }
}
