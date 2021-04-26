package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f34258h;

    /* renamed from: i  reason: collision with root package name */
    public int f34259i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f34203e.f34287f ? 1 : 3;
        return this.f34203e.f34286e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a2;
        if (dVar.f34222a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f34203e.f34287f) {
            this.f34258h = com.kwad.sdk.pngencrypt.n.a(dVar.f34225d, 0);
            if (!this.f34203e.f34286e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f34225d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f34225d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f34225d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f34225d, 2);
            if (!this.f34203e.f34286e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f34225d, 3);
        }
        this.f34259i = a2;
    }
}
