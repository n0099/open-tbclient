package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class ac extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36940h;

    /* renamed from: i  reason: collision with root package name */
    public int f36941i;
    public int j;
    public int k;
    public int l;
    public int m;

    public ac(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f36954a != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.f36940h = com.kwad.sdk.pngencrypt.n.b(dVar.f36957d, 0);
        this.f36941i = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 2);
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 3);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 6);
    }
}
