package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes3.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f57113e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57114f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57115g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f57116h;

    /* renamed from: i  reason: collision with root package name */
    public int f57117i;

    public d(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.f57114f = false;
        this.f57115g = false;
        this.f57117i = -1;
        this.f57113e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f57115g = true;
            this.f57116h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        this.f57117i = i2;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.f57115g && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.f57116h[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.f57113e.a(bArr, i3, i4);
            if (this.f57114f) {
                System.arraycopy(bArr, i3, a().f57067d, this.f57005b, i4);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f57115g || !a().f57066c.equals("fdAT") || this.f57117i < 0 || (c2 = n.c(this.f57116h, 0)) == this.f57117i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f57117i));
    }
}
