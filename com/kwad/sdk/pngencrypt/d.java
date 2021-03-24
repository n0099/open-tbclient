package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes6.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f36169e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36170f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36171g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f36172h;
    public int i;

    public d(int i, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f36170f = false;
        this.f36171g = false;
        this.i = -1;
        this.f36169e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f36171g = true;
            this.f36172h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i, byte[] bArr, int i2, int i3) {
        if (this.f36171g && i < 4) {
            while (i < 4 && i3 > 0) {
                this.f36172h[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.f36169e.a(bArr, i2, i3);
            if (this.f36170f) {
                System.arraycopy(bArr, i2, a().f36142d, this.f36082b, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f36171g || !a().f36141c.equals("fdAT") || this.i < 0 || (c2 = n.c(this.f36172h, 0)) == this.i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.i));
    }
}
