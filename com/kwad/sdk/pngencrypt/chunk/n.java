package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public final class n extends k {
    public String aKS;
    public int aKT;
    public int[] aKU;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String IT() {
        return this.aKS;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i8 < bArr.length) {
                if (bArr[i8] == 0) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 > 0) {
            byte[] bArr2 = dVar.data;
            if (i8 <= bArr2.length - 2) {
                this.aKS = b.d(bArr2, 0, i8);
                int e = com.kwad.sdk.pngencrypt.n.e(dVar.data, i8 + 1);
                this.aKT = e;
                int i9 = i8 + 2;
                int length = dVar.data.length - i9;
                if (e == 8) {
                    i = 6;
                } else {
                    i = 10;
                }
                int i10 = length / i;
                this.aKU = new int[i10 * 5];
                int i11 = i9;
                int i12 = 0;
                while (i7 < i10) {
                    if (this.aKT == 8) {
                        int i13 = i11 + 1;
                        i3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i11);
                        int i14 = i13 + 1;
                        i4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i13);
                        int i15 = i14 + 1;
                        i5 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i14);
                        i2 = i15 + 1;
                        i6 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i15);
                    } else {
                        int f = com.kwad.sdk.pngencrypt.n.f(dVar.data, i11);
                        int i16 = i11 + 2;
                        int f2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i16);
                        int i17 = i16 + 2;
                        int f3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i17);
                        int i18 = i17 + 2;
                        int f4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i18);
                        i2 = i18 + 2;
                        i3 = f;
                        i4 = f2;
                        i5 = f3;
                        i6 = f4;
                    }
                    int f5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i2);
                    int[] iArr = this.aKU;
                    int i19 = i12 + 1;
                    iArr[i12] = i3;
                    int i20 = i19 + 1;
                    iArr[i19] = i4;
                    int i21 = i20 + 1;
                    iArr[i20] = i5;
                    int i22 = i21 + 1;
                    iArr[i21] = i6;
                    iArr[i22] = f5;
                    i7++;
                    i12 = i22 + 1;
                    i11 = i2 + 2;
                }
                return;
            }
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }
}
