package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public abstract class ChunkReader implements f {

    /* renamed from: a  reason: collision with root package name */
    public final ChunkReaderMode f36890a;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.chunk.d f36893d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36895f;

    /* renamed from: b  reason: collision with root package name */
    public int f36891b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f36894e = 0;

    /* renamed from: c  reason: collision with root package name */
    public ErrorBehaviour f36892c = ErrorBehaviour.STRICT;

    /* loaded from: classes7.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i2, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.f36890a = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i2, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.f36893d = dVar;
        dVar.a(j);
        this.f36895f = chunkReaderMode != ChunkReaderMode.SKIP;
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
        if (this.f36891b == 0 && this.f36894e == 0 && this.f36895f) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f36893d;
            dVar.a(dVar.f36955b, 0, 4);
        }
        int i5 = this.f36893d.f36954a - this.f36891b;
        if (i5 > i3) {
            i5 = i3;
        }
        if (i5 > 0 || this.f36894e == 0) {
            if (this.f36895f && this.f36890a != ChunkReaderMode.BUFFER && i5 > 0) {
                this.f36893d.a(bArr, i2, i5);
            }
            ChunkReaderMode chunkReaderMode = this.f36890a;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.f36893d.f36957d;
                if (bArr2 != bArr && i5 > 0) {
                    System.arraycopy(bArr, i2, bArr2, this.f36891b, i5);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.f36891b, bArr, i2, i5);
            }
            this.f36891b += i5;
            i2 += i5;
            i3 -= i5;
        }
        if (this.f36891b == this.f36893d.f36954a) {
            int i6 = 4 - this.f36894e;
            if (i6 <= i3) {
                i3 = i6;
            }
            if (i3 > 0) {
                byte[] bArr3 = this.f36893d.f36958e;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i2, bArr3, this.f36894e, i3);
                }
                int i7 = this.f36894e + i3;
                this.f36894e = i7;
                if (i7 == 4) {
                    if (this.f36895f) {
                        if (this.f36890a == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.f36893d;
                            dVar2.a(dVar2.f36957d, 0, dVar2.f36954a);
                        }
                        this.f36893d.a(this.f36892c == ErrorBehaviour.STRICT);
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
        return this.f36893d;
    }

    public abstract void a(int i2, byte[] bArr, int i3, int i4);

    public void a(boolean z) {
        if (this.f36891b != 0 && z && !this.f36895f) {
            com.kwad.sdk.core.d.a.a(new PngjException("too late!"));
        }
        this.f36895f = z;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        return this.f36894e == 4;
    }

    public abstract void c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f36893d;
            com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).f36893d;
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
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.f36893d;
        return 31 + (dVar == null ? 0 : dVar.hashCode());
    }

    public String toString() {
        return this.f36893d.toString();
    }
}
