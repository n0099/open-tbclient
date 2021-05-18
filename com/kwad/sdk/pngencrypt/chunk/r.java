package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class r extends ae {
    public boolean j;
    public String k;
    public String l;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.j = false;
        this.k = "";
        this.l = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int[] iArr = new int[3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = dVar.f33470d;
            if (i2 >= bArr.length) {
                break;
            }
            if (bArr[i2] == 0) {
                iArr[i3] = i2;
                i3++;
                if (i3 == 1) {
                    i2 += 2;
                }
                if (i3 == 3) {
                    break;
                }
            }
            i2++;
        }
        if (i3 != 3) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        ((ae) this).f33457h = b.a(dVar.f33470d, 0, iArr[0]);
        int i4 = iArr[0] + 1;
        boolean z = dVar.f33470d[i4] != 0;
        this.j = z;
        int i5 = i4 + 1;
        if (z && dVar.f33470d[i5] != 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.k = b.a(dVar.f33470d, i5, iArr[1] - i5);
        this.l = b.b(dVar.f33470d, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
        int i6 = iArr[2] + 1;
        boolean z2 = this.j;
        byte[] bArr2 = dVar.f33470d;
        this.f33458i = z2 ? b.b(b.a(bArr2, i6, bArr2.length - i6, false)) : b.b(bArr2, i6, bArr2.length - i6);
    }
}
