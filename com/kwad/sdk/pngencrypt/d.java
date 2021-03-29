package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes6.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f36170e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36171f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36172g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f36173h;
    public int i;

    public d(int i, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f36171f = false;
        this.f36172g = false;
        this.i = -1;
        this.f36170e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f36172g = true;
            this.f36173h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i, byte[] bArr, int i2, int i3) {
        if (this.f36172g && i < 4) {
            while (i < 4 && i3 > 0) {
                this.f36173h[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.f36170e.a(bArr, i2, i3);
            if (this.f36171f) {
                System.arraycopy(bArr, i2, a().f36143d, this.f36083b, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f36172g || !a().f36142c.equals("fdAT") || this.i < 0 || (c2 = n.c(this.f36173h, 0)) == this.i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.i));
    }
}
