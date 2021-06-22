package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36990h;

    /* renamed from: i  reason: collision with root package name */
    public int f36991i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f36935e.f37019f ? 1 : 3;
        return this.f36935e.f37018e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a2;
        if (dVar.f36954a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f36935e.f37019f) {
            this.f36990h = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 0);
            if (!this.f36935e.f37018e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 2);
            if (!this.f36935e.f37018e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f36957d, 3);
        }
        this.f36991i = a2;
    }
}
