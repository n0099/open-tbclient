package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes7.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f36898e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36899f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36900g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f36901h;

    /* renamed from: i  reason: collision with root package name */
    public int f36902i;

    public d(int i2, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f36899f = false;
        this.f36900g = false;
        this.f36902i = -1;
        this.f36898e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f36900g = true;
            this.f36901h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f36902i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f36900g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f36901h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f36898e.a(bArr, i3, i4);
            if (this.f36899f) {
                System.arraycopy(bArr, i3, a().f36859d, this.f36793b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f36900g || !a().f36858c.equals("fdAT") || this.f36902i < 0 || (c2 = n.c(this.f36901h, 0)) == this.f36902i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f36902i));
    }
}
