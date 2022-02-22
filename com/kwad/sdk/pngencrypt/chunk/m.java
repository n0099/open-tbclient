package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes4.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f57302h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f57302h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f57259e.f57348g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f57302h = new int[dVar.f57279d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f57302h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f57279d, i2 * 2);
            i2++;
        }
    }
}
