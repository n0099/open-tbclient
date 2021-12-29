package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class z extends aa {

    /* renamed from: h  reason: collision with root package name */
    public byte f59354h;

    public z(com.kwad.sdk.pngencrypt.k kVar) {
        super("sTER", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a == 1) {
            this.f59354h = dVar.f59303d[0];
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
