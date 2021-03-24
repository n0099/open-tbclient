package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class v extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36164h;
    public int[] i;

    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.f36164h = 0;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.i[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        b(dVar.f36139a / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.f36164h) {
            byte[] bArr = dVar.f36142d;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            a(i, bArr[i2] & 255, bArr[i3] & 255, bArr[i4] & 255);
            i++;
            i2 = i4 + 1;
        }
    }

    public void b(int i) {
        this.f36164h = i;
        if (i < 1 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.f36164h);
        }
        int[] iArr = this.i;
        if (iArr == null || iArr.length != i) {
            this.i = new int[this.f36164h];
        }
    }
}
