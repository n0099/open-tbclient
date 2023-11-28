package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes10.dex */
public abstract class d extends ChunkReader {
    public final DeflatedChunksSet aIR;
    public boolean aIS;
    public boolean aIT;
    public byte[] aIU;
    public int aIV;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.aIS = false;
        this.aIT = false;
        this.aIV = -1;
        this.aIR = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.aIT && i < 4) {
            while (i < 4 && i3 > 0) {
                this.aIU[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.aIR.c(bArr, i2, i3);
            if (this.aIS) {
                System.arraycopy(bArr, i2, HW().data, this.aIk, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void HX() {
        int g;
        if (this.aIT && this.aIV >= 0 && (g = n.g(this.aIU, 0)) != this.aIV) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g + " expected " + this.aIV));
        }
    }

    public final void df(int i) {
        this.aIV = i;
    }
}
