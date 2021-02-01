package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class ab extends ae {
    public ab(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i = 0;
        while (i < dVar.d.length && dVar.d[i] != 0) {
            i++;
        }
        this.h = b.a(dVar.d, 0, i);
        int i2 = i + 1;
        this.i = i2 < dVar.d.length ? b.a(dVar.d, i2, dVar.d.length - i2) : "";
    }
}
