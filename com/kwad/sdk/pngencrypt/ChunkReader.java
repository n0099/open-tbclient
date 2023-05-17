package com.kwad.sdk.pngencrypt;
/* loaded from: classes9.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode ajs;
    public final com.kwad.sdk.pngencrypt.chunk.d ajt;
    public boolean ajw;
    public int aju = 0;
    public int ajv = 0;
    public ErrorBehaviour ajx = ErrorBehaviour.STRICT;

    /* loaded from: classes9.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.ajs = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.ajt = dVar;
        dVar.R(j);
        this.ajw = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    public final void aW(boolean z) {
        this.ajw = false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aju == 0 && this.ajv == 0 && this.ajw) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.ajt;
            dVar.f(dVar.alA, 0, 4);
        }
        int i4 = this.ajt.len - this.aju;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.ajv == 0) {
            if (this.ajw && this.ajs != ChunkReaderMode.BUFFER && i4 > 0) {
                this.ajt.f(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.ajs;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.ajt.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.aju, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aju, bArr, i, i4);
            }
            this.aju += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.aju == this.ajt.len) {
            int i5 = 4 - this.ajv;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                byte[] bArr3 = this.ajt.alD;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, this.ajv, i2);
                }
                int i6 = this.ajv + i2;
                this.ajv = i6;
                if (i6 == 4) {
                    if (this.ajw) {
                        if (this.ajs == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.ajt;
                            dVar2.f(dVar2.data, 0, dVar2.len);
                        }
                        this.ajt.aY(this.ajx == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.e.b.d("PNG_ENCRYPT", "Chunk done");
                    xU();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.ajt;
            com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).ajt;
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
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.ajt;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.ajv == 4;
    }

    public String toString() {
        return this.ajt.toString();
    }

    public final com.kwad.sdk.pngencrypt.chunk.d xT() {
        return this.ajt;
    }

    public abstract void xU();
}
