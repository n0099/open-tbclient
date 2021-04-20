package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes6.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f36459e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36460f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36461g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f36462h;
    public int i;

    public d(int i, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f36460f = false;
        this.f36461g = false;
        this.i = -1;
        this.f36459e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f36461g = true;
            this.f36462h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i, byte[] bArr, int i2, int i3) {
        if (this.f36461g && i < 4) {
            while (i < 4 && i3 > 0) {
                this.f36462h[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.f36459e.a(bArr, i2, i3);
            if (this.f36460f) {
                System.arraycopy(bArr, i2, a().f36432d, this.f36372b, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f36461g || !a().f36431c.equals("fdAT") || this.i < 0 || (c2 = n.c(this.f36462h, 0)) == this.i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.i));
    }
}
