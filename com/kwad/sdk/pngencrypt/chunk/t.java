package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class t extends aa {

    /* renamed from: h  reason: collision with root package name */
    public long f33497h;

    /* renamed from: i  reason: collision with root package name */
    public long f33498i;
    public int j;

    public t(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f33467a != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 0);
        this.f33497h = c2;
        if (c2 < 0) {
            this.f33497h = c2 + 4294967296L;
        }
        long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f33470d, 4);
        this.f33498i = c3;
        if (c3 < 0) {
            this.f33498i = c3 + 4294967296L;
        }
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 8);
    }
}
