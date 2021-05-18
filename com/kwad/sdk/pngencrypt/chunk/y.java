package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class y extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33507h;

    public y(com.kwad.sdk.pngencrypt.k kVar) {
        super("sRGB", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f33467a == 1) {
            this.f33507h = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 0);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
