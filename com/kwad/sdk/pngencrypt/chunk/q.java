package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes8.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        int i = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i >= bArr.length || bArr[i] == 0) {
                break;
            }
            i++;
        }
        this.key = b.d(dVar.data, 0, i);
        int i2 = i + 1;
        byte[] bArr2 = dVar.data;
        this.amp = i2 < bArr2.length ? b.d(bArr2, i2, bArr2.length - i2) : "";
    }
}
