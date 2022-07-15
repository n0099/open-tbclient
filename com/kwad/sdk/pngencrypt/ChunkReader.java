package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode a;
    public final com.kwad.sdk.pngencrypt.chunk.d d;
    public boolean f;
    public int b = 0;
    public int e = 0;
    public ErrorBehaviour c = ErrorBehaviour.STRICT;

    /* loaded from: classes5.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.d.b.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.a = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.d = dVar;
        dVar.a(j);
        this.f = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.b.a(new PngjException("negative length??"));
        }
        if (this.b == 0 && this.e == 0 && this.f) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.d;
            dVar.a(dVar.b, 0, 4);
        }
        int i4 = this.d.a - this.b;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.e == 0) {
            if (this.f && this.a != ChunkReaderMode.BUFFER && i4 > 0) {
                this.d.a(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.a;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.d.d;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.b, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.b, bArr, i, i4);
            }
            this.b += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.b == this.d.a) {
            int i5 = 4 - this.e;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                byte[] bArr3 = this.d.e;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, this.e, i2);
                }
                int i6 = this.e + i2;
                this.e = i6;
                if (i6 == 4) {
                    if (this.f) {
                        if (this.a == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.d;
                            dVar2.a(dVar2.d, 0, dVar2.a);
                        }
                        this.d.a(this.c == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.d.b.a("PNG_ENCRYPT", "Chunk done");
                    c();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d a() {
        return this.d;
    }

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    public final void a(boolean z) {
        this.f = false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        return this.e == 4;
    }

    public abstract void c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.d;
            com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).d;
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
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.d;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    public String toString() {
        return this.d.toString();
    }
}
