package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class z extends aa {

    /* renamed from: h  reason: collision with root package name */
    public byte f33437h;

    public z(com.kwad.sdk.pngencrypt.k kVar) {
        super("sTER", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f33396a == 1) {
            this.f33437h = dVar.f33399d[0];
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
