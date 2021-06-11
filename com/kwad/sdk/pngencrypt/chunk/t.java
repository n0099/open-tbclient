package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class t extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f36886h;

    /* renamed from: i  reason: collision with root package name */
    public long f36887i;
    public int j;

    public t(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f36856a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f36859d, 0);
        this.f36886h = c2;
        if (c2 < 0) {
            this.f36886h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f36859d, 4);
        this.f36887i = c3;
        if (c3 < 0) {
            this.f36887i = c3 + 4294967296L;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 8);
    }
}
