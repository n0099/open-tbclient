package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes7.dex */
public class ab extends ae {
    public ab(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.f36859d;
            if (i2 >= bArr.length || bArr[i2] == 0) {
                break;
            }
            i2++;
        }
        ((ae) this).f36846h = b.a(dVar.f36859d, 0, i2);
        int i3 = i2 + 1;
        byte[] bArr2 = dVar.f36859d;
        this.f36847i = i3 < bArr2.length ? b.a(bArr2, i3, bArr2.length - i3) : "";
    }
}
