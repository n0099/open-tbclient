package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f57135h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f57135h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f57092e.f57181g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f57135h = new int[dVar.f57112d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f57135h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f57112d, i2 * 2);
            i2++;
        }
    }
}
