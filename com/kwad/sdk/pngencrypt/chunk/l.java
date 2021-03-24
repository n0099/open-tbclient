package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class l extends aa {

    /* renamed from: h  reason: collision with root package name */
    public double f36158h;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("gAMA", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f36139a == 4) {
            double c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 0);
            Double.isNaN(c2);
            this.f36158h = c2 / 100000.0d;
            return;
        }
        throw new PngjException("bad chunk " + dVar);
    }
}
