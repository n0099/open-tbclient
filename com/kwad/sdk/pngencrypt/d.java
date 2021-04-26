package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes6.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f34264e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34265f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34266g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f34267h;

    /* renamed from: i  reason: collision with root package name */
    public int f34268i;

    public d(int i2, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f34265f = false;
        this.f34266g = false;
        this.f34268i = -1;
        this.f34264e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f34266g = true;
            this.f34267h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f34268i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f34266g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f34267h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f34264e.a(bArr, i3, i4);
            if (this.f34265f) {
                System.arraycopy(bArr, i3, a().f34225d, this.f34159b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f34266g || !a().f34224c.equals("fdAT") || this.f34268i < 0 || (c2 = n.c(this.f34267h, 0)) == this.f34268i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f34268i));
    }
}
