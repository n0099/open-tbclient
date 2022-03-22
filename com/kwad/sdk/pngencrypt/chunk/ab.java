package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class ab extends ae {
    public ab(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i = 0;
        while (true) {
            byte[] bArr = dVar.f40643d;
            if (i >= bArr.length || bArr[i] == 0) {
                break;
            }
            i++;
        }
        ((ae) this).f40634h = b.a(dVar.f40643d, 0, i);
        int i2 = i + 1;
        byte[] bArr2 = dVar.f40643d;
        this.i = i2 < bArr2.length ? b.a(bArr2, i2, bArr2.length - i2) : "";
    }
}
