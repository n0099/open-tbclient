package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class u extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f33499h;

    /* renamed from: i  reason: collision with root package name */
    public long f33500i;
    public int j;

    public u(com.kwad.sdk.pngencrypt.k kVar) {
        super("pHYs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f33467a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 0);
        this.f33499h = c2;
        if (c2 < 0) {
            this.f33499h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 4);
        this.f33500i = c3;
        if (c3 < 0) {
            this.f33500i = c3 + 4294967296L;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 8);
    }
}
