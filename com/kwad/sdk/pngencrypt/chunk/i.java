package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class i extends aa {

    /* renamed from: h  reason: collision with root package name */
    public double f57125h;

    /* renamed from: i  reason: collision with root package name */
    public double f57126i;

    /* renamed from: j  reason: collision with root package name */
    public double f57127j;
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
        if (dVar.a != 32) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.f57125h = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 0));
        this.f57126i = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 4));
        this.f57127j = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 8));
        this.k = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 12));
        this.l = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 16));
        this.m = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 20));
        this.n = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 24));
        this.o = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f57112d, 28));
    }
}
