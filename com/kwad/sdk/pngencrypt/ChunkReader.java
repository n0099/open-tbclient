package com.kwad.sdk.pngencrypt;
/* loaded from: classes10.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aIi;
    public final com.kwad.sdk.pngencrypt.chunk.d aIj;
    public boolean aIm;
    public int aIk = 0;
    public int aIl = 0;
    public ErrorBehaviour aIn = ErrorBehaviour.STRICT;

    /* loaded from: classes10.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public abstract void HX();

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        boolean z;
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aIi = chunkReaderMode;
        if (chunkReaderMode == ChunkReaderMode.BUFFER) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, z);
        this.aIj = dVar;
        dVar.av(j);
        this.aIm = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d HW() {
        return this.aIj;
    }

    public int hashCode() {
        int hashCode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aIj;
        if (dVar == null) {
            hashCode = 0;
        } else {
            hashCode = dVar.hashCode();
        }
        return hashCode + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        if (this.aIl == 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.aIj.toString();
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aIk == 0 && this.aIl == 0 && this.aIm) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aIj;
            dVar.f(dVar.aKq, 0, 4);
        }
        int i4 = this.aIj.len - this.aIk;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.aIl == 0) {
            if (this.aIm && this.aIi != ChunkReaderMode.BUFFER && i4 > 0) {
                this.aIj.f(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.aIi;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aIj.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.aIk, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aIk, bArr, i, i4);
            }
            this.aIk += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.aIk == this.aIj.len) {
            int i5 = 4 - this.aIl;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                byte[] bArr3 = this.aIj.aKs;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, this.aIl, i2);
                }
                int i6 = this.aIl + i2;
                this.aIl = i6;
                if (i6 == 4) {
                    if (this.aIm) {
                        if (this.aIi == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aIj;
                            dVar2.f(dVar2.data, 0, dVar2.len);
                        }
                        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aIj;
                        if (this.aIn == ErrorBehaviour.STRICT) {
                            z = true;
                        }
                        dVar3.bF(z);
                    }
                    com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", "Chunk done");
                    HX();
                }
            }
            i3 = i2;
        }
        if (i4 <= 0 && i3 <= 0) {
            return -1;
        }
        return i4 + i3;
    }

    public final void bD(boolean z) {
        this.aIm = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aIj;
        if (dVar == null) {
            if (chunkReader.aIj != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aIj)) {
            return false;
        }
        return true;
    }
}
