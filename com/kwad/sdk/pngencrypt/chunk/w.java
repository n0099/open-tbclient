package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33503h;

    /* renamed from: i  reason: collision with root package name */
    public int f33504i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i2 = this.f33448e.f33532f ? 1 : 3;
        return this.f33448e.f33531e ? i2 + 1 : i2;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a2;
        if (dVar.f33467a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f33448e.f33532f) {
            this.f33503h = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 0);
            if (!this.f33448e.f33531e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 2);
            if (!this.f33448e.f33531e) {
                return;
            }
            a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f33470d, 3);
        }
        this.f33504i = a2;
    }
}
