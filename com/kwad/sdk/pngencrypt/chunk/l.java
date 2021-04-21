package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class l extends aa {

    /* renamed from: h  reason: collision with root package name */
    public double f36543h;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("gAMA", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f36524a == 4) {
            this.f36543h = com.kwad.sdk.pngencrypt.n.c(dVar.f36527d, 0) / 100000.0d;
            return;
        }
        throw new PngjException("bad chunk " + dVar);
    }
}
