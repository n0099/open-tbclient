package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes4.dex */
public class u extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f57312h;

    /* renamed from: i  reason: collision with root package name */
    public long f57313i;

    /* renamed from: j  reason: collision with root package name */
    public int f57314j;

    public u(com.kwad.sdk.pngencrypt.k kVar) {
        super("pHYs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 0);
        this.f57312h = c2;
        if (c2 < 0) {
            this.f57312h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f57279d, 4);
        this.f57313i = c3;
        if (c3 < 0) {
            this.f57313i = c3 + 4294967296L;
        }
        this.f57314j = com.kwad.sdk.pngencrypt.n.a(dVar.f57279d, 8);
    }
}
