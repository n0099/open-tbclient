package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes4.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet e;
    protected boolean f;
    protected boolean g;
    protected byte[] h;
    protected int i;

    public d(int i, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f = false;
        this.g = false;
        this.i = -1;
        this.e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.g = true;
            this.h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected void a(int i, byte[] bArr, int i2, int i3) {
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
                System.arraycopy(bArr, i2, a().d, this.f10486b, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c;
        if (!this.g || !a().c.equals("fdAT") || this.i < 0 || (c = n.c(this.h, 0)) == this.i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c + " expected " + this.i));
    }
}
