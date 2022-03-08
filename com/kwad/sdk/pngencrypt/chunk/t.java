package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes8.dex */
public class t extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f55659h;

    /* renamed from: i  reason: collision with root package name */
    public long f55660i;

    /* renamed from: j  reason: collision with root package name */
    public int f55661j;

    public t(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 0);
        this.f55659h = c2;
        if (c2 < 0) {
            this.f55659h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f55629d, 4);
        this.f55660i = c3;
        if (c3 < 0) {
            this.f55660i = c3 + 4294967296L;
        }
        this.f55661j = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 8);
    }
}
