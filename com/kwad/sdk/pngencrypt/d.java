package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes7.dex */
public abstract class d extends ChunkReader {

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f40667e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40668f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40669g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f40670h;
    public int i;

    public d(int i, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.f40668f = false;
        this.f40669g = false;
        this.i = -1;
        this.f40667e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f40669g = true;
            this.f40670h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i, byte[] bArr, int i2, int i3) {
        if (this.f40669g && i < 4) {
            while (i < 4 && i3 > 0) {
                this.f40670h[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.f40667e.a(bArr, i2, i3);
            if (this.f40668f) {
                System.arraycopy(bArr, i2, a().f40643d, this.f40592b, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        if (!this.f40669g || !a().f40642c.equals("fdAT") || this.i < 0 || (c2 = n.c(this.f40670h, 0)) == this.i) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.i));
    }
}
