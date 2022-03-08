package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes8.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f55652h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f55652h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f55609e.f55698g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f55652h = new int[dVar.f55629d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f55652h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f55629d, i2 * 2);
            i2++;
        }
    }
}
