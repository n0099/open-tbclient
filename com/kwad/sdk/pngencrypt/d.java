package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes7.dex */
public abstract class d extends ChunkReader {
    public final DeflatedChunksSet akb;
    public boolean akc;
    public boolean akd;
    public byte[] ake;
    public int akf;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.akc = false;
        this.akd = false;
        this.akf = -1;
        this.akb = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.akd && i < 4) {
            while (i < 4 && i3 > 0) {
                this.ake[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.akb.c(bArr, i2, i3);
            if (this.akc) {
                System.arraycopy(bArr, i2, xT().data, this.aju, i3);
            }
        }
    }

    public final void bg(int i) {
        this.akf = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void xU() {
        int g;
        if (!this.akd || this.akf < 0 || (g = n.g(this.ake, 0)) == this.akf) {
            return;
        }
        com.kwad.sdk.core.e.b.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g + " expected " + this.akf));
    }
}
