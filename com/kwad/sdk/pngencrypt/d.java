package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes3.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f57158e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57159f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57160g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f57161h;

    /* renamed from: i  reason: collision with root package name */
    public int f57162i;

    public d(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.f57159f = false;
        this.f57160g = false;
        this.f57162i = -1;
        this.f57158e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f57160g = true;
            this.f57161h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f57162i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f57160g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f57161h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f57158e.a(bArr, i3, i4);
            if (this.f57159f) {
                System.arraycopy(bArr, i3, a().f57112d, this.f57050b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f57160g || !a().f57111c.equals("fdAT") || this.f57162i < 0 || (c2 = n.c(this.f57161h, 0)) == this.f57162i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f57162i));
    }
}
