package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class u extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f36986h;

    /* renamed from: i  reason: collision with root package name */
    public long f36987i;
    public int j;

    public u(com.kwad.sdk.pngencrypt.k kVar) {
        super("pHYs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f36954a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f36957d, 0);
        this.f36986h = c2;
        if (c2 < 0) {
            this.f36986h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f36957d, 4);
        this.f36987i = c3;
        if (c3 < 0) {
            this.f36987i = c3 + 4294967296L;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 8);
    }
}
