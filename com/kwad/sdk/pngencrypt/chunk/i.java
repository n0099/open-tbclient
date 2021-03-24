package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class i extends aa {

    /* renamed from: h  reason: collision with root package name */
    public double f36155h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("cHRM", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f36139a != 32) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.f36155h = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 0));
        this.i = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 4));
        this.j = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 8));
        this.k = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 12));
        this.l = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 16));
        this.m = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 20));
        this.n = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 24));
        this.o = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f36142d, 28));
    }
}
