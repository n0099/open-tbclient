package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes4.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f57325e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57326f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57327g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f57328h;

    /* renamed from: i  reason: collision with root package name */
    public int f57329i;

    public d(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.f57326f = false;
        this.f57327g = false;
        this.f57329i = -1;
        this.f57325e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f57327g = true;
            this.f57328h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f57329i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f57327g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f57328h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f57325e.a(bArr, i3, i4);
            if (this.f57326f) {
                System.arraycopy(bArr, i3, a().f57279d, this.f57217b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f57327g || !a().f57278c.equals("fdAT") || this.f57329i < 0 || (c2 = n.c(this.f57328h, 0)) == this.f57329i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f57329i));
    }
}
