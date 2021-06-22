package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f36979h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f36979h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f36935e.f37020g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f36979h = new int[dVar.f36957d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f36979h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, i2 * 2);
            i2++;
        }
    }
}
