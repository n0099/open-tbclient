package com.kwad.sdk.pngencrypt;
/* loaded from: classes8.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode a;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.chunk.d f55569d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55571f;

    /* renamed from: b  reason: collision with root package name */
    public int f55567b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f55570e = 0;

    /* renamed from: c  reason: collision with root package name */
    public ErrorBehaviour f55568c = ErrorBehaviour.STRICT;

    /* loaded from: classes8.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i2, String str, long j2, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.a = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i2, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.f55569d = dVar;
        dVar.a(j2);
        this.f55571f = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("negative length??"));
        }
        if (this.f55567b == 0 && this.f55570e == 0 && this.f55571f) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f55569d;
            dVar.a(dVar.f55627b, 0, 4);
        }
        int i5 = this.f55569d.a - this.f55567b;
        if (i5 > i3) {
            i5 = i3;
        }
        if (i5 > 0 || this.f55570e == 0) {
            if (this.f55571f && this.a != ChunkReaderMode.BUFFER && i5 > 0) {
                this.f55569d.a(bArr, i2, i5);
            }
            ChunkReaderMode chunkReaderMode = this.a;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.f55569d.f55629d;
                if (bArr2 != bArr && i5 > 0) {
                    System.arraycopy(bArr, i2, bArr2, this.f55567b, i5);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.f55567b, bArr, i2, i5);
            }
            this.f55567b += i5;
            i2 += i5;
            i3 -= i5;
        }
        if (this.f55567b == this.f55569d.a) {
            int i6 = 4 - this.f55570e;
            if (i6 <= i3) {
                i3 = i6;
            }
            if (i3 > 0) {
                byte[] bArr3 = this.f55569d.f55630e;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i2, bArr3, this.f55570e, i3);
                }
                int i7 = this.f55570e + i3;
                this.f55570e = i7;
                if (i7 == 4) {
                    if (this.f55571f) {
                        if (this.a == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.f55569d;
                            dVar2.a(dVar2.f55629d, 0, dVar2.a);
                        }
                        this.f55569d.a(this.f55568c == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Chunk done");
                    c();
                }
            }
            i4 = i3;
        }
        if (i5 > 0 || i4 > 0) {
            return i5 + i4;
        }
        return -1;
    }

    public com.kwad.sdk.pngencrypt.chunk.d a() {
        return this.f55569d;
    }

    public abstract void a(int i2, byte[] bArr, int i3, int i4);

    public void a(boolean z) {
        if (this.f55567b != 0 && z && !this.f55571f) {
            com.kwad.sdk.core.d.a.a(new PngjException("too late!"));
        }
        this.f55571f = z;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        return this.f55570e == 4;
    }

    public abstract void c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f55569d;
            com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).f55569d;
            if (dVar == null) {
                if (dVar2 != null) {
                    return false;
                }
            } else if (!dVar.equals(dVar2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.f55569d;
        return 31 + (dVar == null ? 0 : dVar.hashCode());
    }

    public String toString() {
        return this.f55569d.toString();
    }
}
