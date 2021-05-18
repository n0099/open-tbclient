package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f33492h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f33492h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f33448e.f33533g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f33492h = new int[dVar.f33470d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f33492h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, i2 * 2);
            i2++;
        }
    }
}
