package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f34247h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f34247h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f34203e.f34288g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f34247h = new int[dVar.f34225d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f34247h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f34225d, i2 * 2);
            i2++;
        }
    }
}
