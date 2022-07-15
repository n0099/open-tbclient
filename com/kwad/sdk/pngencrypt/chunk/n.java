package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes5.dex */
public final class n extends k {
    public String h;
    public int i;
    public int[] j;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String a() {
        return this.h;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            byte[] bArr = dVar.d;
            if (i7 >= bArr.length) {
                i7 = -1;
                break;
            } else if (bArr[i7] == 0) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 > 0) {
            byte[] bArr2 = dVar.d;
            if (i7 <= bArr2.length - 2) {
                this.h = b.a(bArr2, 0, i7);
                int a = com.kwad.sdk.pngencrypt.n.a(dVar.d, i7 + 1);
                this.i = a;
                int i8 = i7 + 2;
                int length = (dVar.d.length - i8) / (a == 8 ? 6 : 10);
                this.j = new int[length * 5];
                int i9 = i8;
                int i10 = 0;
                while (i6 < length) {
                    if (this.i == 8) {
                        int i11 = i9 + 1;
                        i2 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i9);
                        int i12 = i11 + 1;
                        i3 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i11);
                        int i13 = i12 + 1;
                        i4 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i12);
                        i = i13 + 1;
                        i5 = com.kwad.sdk.pngencrypt.n.a(dVar.d, i13);
                    } else {
                        int b = com.kwad.sdk.pngencrypt.n.b(dVar.d, i9);
                        int i14 = i9 + 2;
                        int b2 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i14);
                        int i15 = i14 + 2;
                        int b3 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i15);
                        int i16 = i15 + 2;
                        int b4 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i16);
                        i = i16 + 2;
                        i2 = b;
                        i3 = b2;
                        i4 = b3;
                        i5 = b4;
                    }
                    int b5 = com.kwad.sdk.pngencrypt.n.b(dVar.d, i);
                    int[] iArr = this.j;
                    int i17 = i10 + 1;
                    iArr[i10] = i2;
                    int i18 = i17 + 1;
                    iArr[i17] = i3;
                    int i19 = i18 + 1;
                    iArr[i18] = i4;
                    int i20 = i19 + 1;
                    iArr[i19] = i5;
                    iArr[i20] = b5;
                    i6++;
                    i10 = i20 + 1;
                    i9 = i + 2;
                }
                return;
            }
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }
}
