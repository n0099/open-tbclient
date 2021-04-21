package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public abstract class ChunkReader implements f {

    /* renamed from: a  reason: collision with root package name */
    public final ChunkReaderMode f36466a;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.chunk.d f36469d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36471f;

    /* renamed from: b  reason: collision with root package name */
    public int f36467b = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f36470e = 0;

    /* renamed from: c  reason: collision with root package name */
    public ErrorBehaviour f36468c = ErrorBehaviour.STRICT;

    /* loaded from: classes6.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.f36466a = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.f36469d = dVar;
        dVar.a(j);
        this.f36471f = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("negative length??"));
        }
        if (this.f36467b == 0 && this.f36470e == 0 && this.f36471f) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f36469d;
            dVar.a(dVar.f36525b, 0, 4);
        }
        int i4 = this.f36469d.f36524a - this.f36467b;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.f36470e == 0) {
            if (this.f36471f && this.f36466a != ChunkReaderMode.BUFFER && i4 > 0) {
                this.f36469d.a(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.f36466a;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.f36469d.f36527d;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.f36467b, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.f36467b, bArr, i, i4);
            }
            this.f36467b += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.f36467b == this.f36469d.f36524a) {
            int i5 = 4 - this.f36470e;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                byte[] bArr3 = this.f36469d.f36528e;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, this.f36470e, i2);
                }
                int i6 = this.f36470e + i2;
                this.f36470e = i6;
                if (i6 == 4) {
                    if (this.f36471f) {
                        if (this.f36466a == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.f36469d;
                            dVar2.a(dVar2.f36527d, 0, dVar2.f36524a);
                        }
                        this.f36469d.a(this.f36468c == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Chunk done");
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

    public com.kwad.sdk.pngencrypt.chunk.d a() {
        return this.f36469d;
    }

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    public void a(boolean z) {
        if (this.f36467b != 0 && z && !this.f36471f) {
            com.kwad.sdk.core.d.a.a(new PngjException("too late!"));
        }
        this.f36471f = z;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        return this.f36470e == 4;
    }

    public abstract void c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f36469d;
            com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).f36469d;
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
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.f36469d;
        return 31 + (dVar == null ? 0 : dVar.hashCode());
    }

    public String toString() {
        return this.f36469d.toString();
    }
}
