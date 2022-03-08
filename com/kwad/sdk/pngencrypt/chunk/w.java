package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes8.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f55667h;

    /* renamed from: i  reason: collision with root package name */
    public int f55668i;

    /* renamed from: j  reason: collision with root package name */
    public int f55669j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f55609e.f55697f ? 1 : 3;
        return this.f55609e.f55696e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a;
        if (dVar.a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f55609e.f55697f) {
            this.f55667h = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 0);
            if (!this.f55609e.f55696e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 1);
        } else {
            this.f55669j = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 2);
            if (!this.f55609e.f55696e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f55629d, 3);
        }
        this.f55668i = a;
    }
}
