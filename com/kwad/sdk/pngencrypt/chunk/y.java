package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class y extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f59353h;

    public y(com.kwad.sdk.pngencrypt.k kVar) {
        super("sRGB", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a == 1) {
            this.f59353h = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 0);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
