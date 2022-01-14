package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public class ab extends ae {
    public ab(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.f57067d;
            if (i2 >= bArr.length || bArr[i2] == 0) {
                break;
            }
            i2++;
        }
        ((ae) this).f57057h = b.a(dVar.f57067d, 0, i2);
        int i3 = i2 + 1;
        byte[] bArr2 = dVar.f57067d;
        this.f57058i = i3 < bArr2.length ? b.a(bArr2, i3, bArr2.length - i3) : "";
    }
}
