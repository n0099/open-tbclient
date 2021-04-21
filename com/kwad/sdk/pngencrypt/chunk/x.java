package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class x extends s {

    /* renamed from: h  reason: collision with root package name */
    public String f36551h;
    public int i;
    public int[] j;

    public x(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            byte[] bArr = dVar.f36527d;
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
            byte[] bArr2 = dVar.f36527d;
            if (i7 <= bArr2.length - 2) {
                this.f36551h = b.a(bArr2, 0, i7);
                int a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36527d, i7 + 1);
                this.i = a2;
                int i8 = i7 + 2;
                int length = (dVar.f36527d.length - i8) / (a2 == 8 ? 6 : 10);
                this.j = new int[length * 5];
                int i9 = i8;
                int i10 = 0;
                while (i6 < length) {
                    if (this.i == 8) {
                        int i11 = i9 + 1;
                        i2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36527d, i9);
                        int i12 = i11 + 1;
                        i3 = com.kwad.sdk.pngencrypt.n.a(dVar.f36527d, i11);
                        int i13 = i12 + 1;
                        i4 = com.kwad.sdk.pngencrypt.n.a(dVar.f36527d, i12);
                        i = i13 + 1;
                        i5 = com.kwad.sdk.pngencrypt.n.a(dVar.f36527d, i13);
                    } else {
                        int b2 = com.kwad.sdk.pngencrypt.n.b(dVar.f36527d, i9);
                        int i14 = i9 + 2;
                        int b3 = com.kwad.sdk.pngencrypt.n.b(dVar.f36527d, i14);
                        int i15 = i14 + 2;
                        int b4 = com.kwad.sdk.pngencrypt.n.b(dVar.f36527d, i15);
                        int i16 = i15 + 2;
                        int b5 = com.kwad.sdk.pngencrypt.n.b(dVar.f36527d, i16);
                        i = i16 + 2;
                        i2 = b2;
                        i3 = b3;
                        i4 = b4;
                        i5 = b5;
                    }
                    int b6 = com.kwad.sdk.pngencrypt.n.b(dVar.f36527d, i);
                    int[] iArr = this.j;
                    int i17 = i10 + 1;
                    iArr[i10] = i2;
                    int i18 = i17 + 1;
                    iArr[i17] = i3;
                    int i19 = i18 + 1;
                    iArr[i18] = i4;
                    int i20 = i19 + 1;
                    iArr[i19] = i5;
                    iArr[i20] = b6;
                    i6++;
                    i10 = i20 + 1;
                    i9 = i + 2;
                }
                return;
            }
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }

    public String c() {
        return this.f36551h;
    }
}
