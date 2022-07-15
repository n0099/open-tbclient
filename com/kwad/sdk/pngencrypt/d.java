package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes5.dex */
public abstract class d extends ChunkReader {
    public final DeflatedChunksSet e;
    public boolean f;
    public boolean g;
    public byte[] h;
    public int i;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f = false;
        this.g = false;
        this.i = -1;
        this.e = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    public final void a(int i) {
        this.i = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.g && i < 4) {
            while (i < 4 && i3 > 0) {
                this.h[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.e.a(bArr, i2, i3);
            if (this.f) {
                System.arraycopy(bArr, i2, a().d, this.b, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c;
        if (!this.g || this.i < 0 || (c = n.c(this.h, 0)) == this.i) {
            return;
        }
        com.kwad.sdk.core.d.b.a(new PngjException("bad chunk sequence for fDAT chunk " + c + " expected " + this.i));
    }
}
