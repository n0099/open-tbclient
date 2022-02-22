package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes4.dex */
public class y extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57323h;

    public y(com.kwad.sdk.pngencrypt.k kVar) {
        super("sRGB", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a == 1) {
            this.f57323h = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 0);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
