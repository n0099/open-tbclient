package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes3.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57105h;

    /* renamed from: i  reason: collision with root package name */
    public int f57106i;

    /* renamed from: j  reason: collision with root package name */
    public int f57107j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f57047e.f57135f ? 1 : 3;
        return this.f57047e.f57134e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a;
        if (dVar.a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f57047e.f57135f) {
            this.f57105h = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 0);
            if (!this.f57047e.f57134e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 1);
        } else {
            this.f57107j = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 2);
            if (!this.f57047e.f57134e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f57067d, 3);
        }
        this.f57106i = a;
    }
}
