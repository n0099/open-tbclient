package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36165h;
    public int i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i = this.f36123e.f36189f ? 1 : 3;
        return this.f36123e.f36188e ? i + 1 : i;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a2;
        if (dVar.f36139a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f36123e.f36189f) {
            this.f36165h = com.kwad.sdk.pngencrypt.n.a(dVar.f36142d, 0);
            if (!this.f36123e.f36188e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36142d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f36142d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f36142d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f36142d, 2);
            if (!this.f36123e.f36188e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36142d, 3);
        }
        this.i = a2;
    }
}
