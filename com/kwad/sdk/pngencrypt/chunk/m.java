package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class m extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int[] f40657h;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
        this.f40657h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (!this.f40628e.f40685g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f40657h = new int[dVar.f40643d.length / 2];
        int i = 0;
        while (true) {
            int[] iArr = this.f40657h;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = com.kwad.sdk.pngencrypt.n.b(dVar.f40643d, i * 2);
            i++;
        }
    }
}
