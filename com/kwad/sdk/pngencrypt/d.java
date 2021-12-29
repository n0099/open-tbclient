package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes3.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f59355e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59356f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59357g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f59358h;

    /* renamed from: i  reason: collision with root package name */
    public int f59359i;

    public d(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.f59356f = false;
        this.f59357g = false;
        this.f59359i = -1;
        this.f59355e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f59357g = true;
            this.f59358h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f59359i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f59357g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f59358h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f59355e.a(bArr, i3, i4);
            if (this.f59356f) {
                System.arraycopy(bArr, i3, a().f59303d, this.f59236b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f59357g || !a().f59302c.equals("fdAT") || this.f59359i < 0 || (c2 = n.c(this.f59358h, 0)) == this.f59359i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f59359i));
    }
}
