package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes8.dex */
public class x extends s {

    /* renamed from: h  reason: collision with root package name */
    public String f55670h;

    /* renamed from: i  reason: collision with root package name */
    public int f55671i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f55672j;

    public x(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            byte[] bArr = dVar.f55629d;
            if (i8 >= bArr.length) {
                i8 = -1;
                break;
            } else if (bArr[i8] == 0) {
                break;
            } else {
                i8++;
            }
        }
        if (i8 > 0) {
            byte[] bArr2 = dVar.f55629d;
            if (i8 <= bArr2.length - 2) {
                this.f55670h = b.a(bArr2, 0, i8);
                int a = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, i8 + 1);
                this.f55671i = a;
                int i9 = i8 + 2;
                int length = (dVar.f55629d.length - i9) / (a == 8 ? 6 : 10);
                this.f55672j = new int[length * 5];
                int i10 = i9;
                int i11 = 0;
                while (i7 < length) {
                    if (this.f55671i == 8) {
                        int i12 = i10 + 1;
                        i3 = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, i10);
                        int i13 = i12 + 1;
                        i4 = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, i12);
                        int i14 = i13 + 1;
                        i5 = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, i13);
                        i2 = i14 + 1;
                        i6 = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, i14);
                    } else {
                        int b2 = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, i10);
                        int i15 = i10 + 2;
                        int b3 = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, i15);
                        int i16 = i15 + 2;
                        int b4 = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, i16);
                        int i17 = i16 + 2;
                        int b5 = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, i17);
                        i2 = i17 + 2;
                        i3 = b2;
                        i4 = b3;
                        i5 = b4;
                        i6 = b5;
                    }
                    int b6 = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, i2);
                    int[] iArr = this.f55672j;
                    int i18 = i11 + 1;
                    iArr[i11] = i3;
                    int i19 = i18 + 1;
                    iArr[i18] = i4;
                    int i20 = i19 + 1;
                    iArr[i19] = i5;
                    int i21 = i20 + 1;
                    iArr[i20] = i6;
                    iArr[i21] = b6;
                    i7++;
                    i11 = i21 + 1;
                    i10 = i2 + 2;
                }
                return;
            }
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }

    public String c() {
        return this.f55670h;
    }
}
