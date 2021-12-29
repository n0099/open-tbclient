package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class ac extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f59285h;

    /* renamed from: i  reason: collision with root package name */
    public int f59286i;

    /* renamed from: j  reason: collision with root package name */
    public int f59287j;

    /* renamed from: k  reason: collision with root package name */
    public int f59288k;
    public int l;
    public int m;

    public ac(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.a != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.f59285h = com.kwad.sdk.pngencrypt.n.b(dVar.f59303d, 0);
        this.f59286i = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 2);
        this.f59287j = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 3);
        this.f59288k = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 4);
        this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 5);
        this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 6);
    }
}
