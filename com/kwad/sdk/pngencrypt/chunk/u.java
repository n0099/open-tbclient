package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class u extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f57100h;

    /* renamed from: i  reason: collision with root package name */
    public long f57101i;

    /* renamed from: j  reason: collision with root package name */
    public int f57102j;

    public u(com.kwad.sdk.pngencrypt.k kVar) {
        super("pHYs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 0);
        this.f57100h = c2;
        if (c2 < 0) {
            this.f57100h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f57067d, 4);
        this.f57101i = c3;
        if (c3 < 0) {
            this.f57101i = c3 + 4294967296L;
        }
        this.f57102j = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 8);
    }
}
