package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f59346h;

    /* renamed from: i  reason: collision with root package name */
    public int f59347i;

    /* renamed from: j  reason: collision with root package name */
    public int f59348j;

    /* renamed from: k  reason: collision with root package name */
    public int f59349k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f59281e.f59379f ? 1 : 3;
        return this.f59281e.f59378e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a;
        if (dVar.a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f59281e.f59379f) {
            this.f59346h = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 0);
            if (!this.f59281e.f59378e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 1);
        } else {
            this.f59348j = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 0);
            this.f59349k = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 2);
            if (!this.f59281e.f59378e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f59303d, 3);
        }
        this.f59347i = a;
    }
}
