package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36892h;

    /* renamed from: i  reason: collision with root package name */
    public int f36893i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f36837e.f36921f ? 1 : 3;
        return this.f36837e.f36920e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a2;
        if (dVar.f36856a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f36837e.f36921f) {
            this.f36892h = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 0);
            if (!this.f36837e.f36920e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 2);
            if (!this.f36837e.f36920e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36859d, 3);
        }
        this.f36893i = a2;
    }
}
