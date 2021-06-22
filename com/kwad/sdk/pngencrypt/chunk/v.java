package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class v extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36988h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f36989i;

    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.f36988h = 0;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f36989i[i2] = (i3 << 16) | (i4 << 8) | i5;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        b(dVar.f36954a / 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f36988h) {
            byte[] bArr = dVar.f36957d;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            a(i2, bArr[i3] & 255, bArr[i4] & 255, bArr[i5] & 255);
            i2++;
            i3 = i5 + 1;
        }
    }

    public void b(int i2) {
        this.f36988h = i2;
        if (i2 < 1 || i2 > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.f36988h);
        }
        int[] iArr = this.f36989i;
        if (iArr == null || iArr.length != i2) {
            this.f36989i = new int[this.f36988h];
        }
    }
}
