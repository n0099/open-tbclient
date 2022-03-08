package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes8.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f55675e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55676f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55677g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f55678h;

    /* renamed from: i  reason: collision with root package name */
    public int f55679i;

    public d(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.f55676f = false;
        this.f55677g = false;
        this.f55679i = -1;
        this.f55675e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f55677g = true;
            this.f55678h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f55679i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f55677g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f55678h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f55675e.a(bArr, i3, i4);
            if (this.f55676f) {
                System.arraycopy(bArr, i3, a().f55629d, this.f55567b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f55677g || !a().f55628c.equals("fdAT") || this.f55679i < 0 || (c2 = n.c(this.f55678h, 0)) == this.f55679i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f55679i));
    }
}
