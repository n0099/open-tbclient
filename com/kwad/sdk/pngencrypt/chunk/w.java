package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes7.dex */
public class w extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f40663h;
    public int i;
    public int j;
    public int k;
    public int l;

    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
    }

    private int c() {
        int i = this.f40628e.f40684f ? 1 : 3;
        return this.f40628e.f40683e ? i + 1 : i;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a;
        if (dVar.a != c()) {
            throw new PngjException("bad chunk length " + dVar);
        }
        if (this.f40628e.f40684f) {
            this.f40663h = com.kwad.sdk.pngencrypt.n.a(dVar.f40643d, 0);
            if (!this.f40628e.f40683e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f40643d, 1);
        } else {
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f40643d, 0);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f40643d, 1);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f40643d, 2);
            if (!this.f40628e.f40683e) {
                return;
            }
            a = com.kwad.sdk.pngencrypt.n.a(dVar.f40643d, 3);
        }
        this.i = a;
    }
}
