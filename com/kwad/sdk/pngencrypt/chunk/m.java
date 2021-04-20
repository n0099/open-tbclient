package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f36449h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f36449h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f36413e.f36480g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f36449h = new int[dVar.f36432d.length / 2];
        int i = 0;
        while (true) {
            int[] iArr = this.f36449h;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = com.kwad.sdk.pngencrypt.n.b(dVar.f36432d, i * 2);
            i++;
        }
    }
}
