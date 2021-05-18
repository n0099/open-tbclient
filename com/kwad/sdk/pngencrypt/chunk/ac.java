package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class ac extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33453h;

    /* renamed from: i  reason: collision with root package name */
    public int f33454i;
    public int j;
    public int k;
    public int l;
    public int m;

    public ac(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f33467a != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.f33453h = com.kwad.sdk.pngencrypt.n.b(dVar.f33470d, 0);
        this.f33454i = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 2);
        this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 3);
        this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 6);
    }
}
