package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class v extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f34256h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f34257i;

    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.f34256h = 0;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f34257i[i2] = (i3 << 16) | (i4 << 8) | i5;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        b(dVar.f34222a / 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f34256h) {
            byte[] bArr = dVar.f34225d;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            a(i2, bArr[i3] & 255, bArr[i4] & 255, bArr[i5] & 255);
            i2++;
            i3 = i5 + 1;
        }
    }

    public void b(int i2) {
        this.f34256h = i2;
        if (i2 < 1 || i2 > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.f34256h);
        }
        int[] iArr = this.f34257i;
        if (iArr == null || iArr.length != i2) {
            this.f34257i = new int[this.f34256h];
        }
    }
}
