package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes6.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f33509e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33510f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33511g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f33512h;

    /* renamed from: i  reason: collision with root package name */
    public int f33513i;

    public d(int i2, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f33510f = false;
        this.f33511g = false;
        this.f33513i = -1;
        this.f33509e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f33511g = true;
            this.f33512h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f33513i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f33511g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f33512h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f33509e.a(bArr, i3, i4);
            if (this.f33510f) {
                System.arraycopy(bArr, i3, a().f33470d, this.f33404b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f33511g || !a().f33469c.equals("fdAT") || this.f33513i < 0 || (c2 = n.c(this.f33512h, 0)) == this.f33513i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f33513i));
    }
}
