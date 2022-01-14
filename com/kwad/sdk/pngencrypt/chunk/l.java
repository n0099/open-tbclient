package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class l extends aa {

    /* renamed from: h  reason: collision with root package name */
    public double f57089h;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("gAMA", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a == 4) {
            this.f57089h = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 0) / 100000.0d;
            return;
        }
        throw new PngjException("bad chunk " + dVar);
    }
}
