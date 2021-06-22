package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes7.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f36996e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36997f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36998g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f36999h;

    /* renamed from: i  reason: collision with root package name */
    public int f37000i;

    public d(int i2, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f36997f = false;
        this.f36998g = false;
        this.f37000i = -1;
        this.f36996e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f36998g = true;
            this.f36999h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f37000i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f36998g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f36999h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f36996e.a(bArr, i3, i4);
            if (this.f36997f) {
                System.arraycopy(bArr, i3, a().f36957d, this.f36891b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f36998g || !a().f36956c.equals("fdAT") || this.f37000i < 0 || (c2 = n.c(this.f36999h, 0)) == this.f37000i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f37000i));
    }
}
