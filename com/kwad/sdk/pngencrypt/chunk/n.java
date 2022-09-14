package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes8.dex */
public final class n extends k {
    public String amd;
    public int ame;
    public int[] amf;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
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
            byte[] bArr = dVar.data;
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
            byte[] bArr2 = dVar.data;
            if (i7 <= bArr2.length - 2) {
                this.amd = b.d(bArr2, 0, i7);
                int e = com.kwad.sdk.pngencrypt.n.e(dVar.data, i7 + 1);
                this.ame = e;
                int i8 = i7 + 2;
                int length = (dVar.data.length - i8) / (e == 8 ? 6 : 10);
                this.amf = new int[length * 5];
                int i9 = i8;
                int i10 = 0;
                while (i6 < length) {
                    if (this.ame == 8) {
                        int i11 = i9 + 1;
                        i2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9);
                        int i12 = i11 + 1;
                        i3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i11);
                        int i13 = i12 + 1;
                        i4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i12);
                        i = i13 + 1;
                        i5 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i13);
                    } else {
                        int f = com.kwad.sdk.pngencrypt.n.f(dVar.data, i9);
                        int i14 = i9 + 2;
                        int f2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i14);
                        int i15 = i14 + 2;
                        int f3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i15);
                        int i16 = i15 + 2;
                        int f4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i16);
                        i = i16 + 2;
                        i2 = f;
                        i3 = f2;
                        i4 = f3;
                        i5 = f4;
                    }
                    int f5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i);
                    int[] iArr = this.amf;
                    int i17 = i10 + 1;
                    iArr[i10] = i2;
                    int i18 = i17 + 1;
                    iArr[i17] = i3;
                    int i19 = i18 + 1;
                    iArr[i18] = i4;
                    int i20 = i19 + 1;
                    iArr[i19] = i5;
                    iArr[i20] = f5;
                    i6++;
                    i10 = i20 + 1;
                    i9 = i + 2;
                }
                return;
            }
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }

    public final String yQ() {
        return this.amd;
    }
}
