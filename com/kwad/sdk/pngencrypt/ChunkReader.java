package com.kwad.sdk.pngencrypt;
/* loaded from: classes5.dex */
public abstract class ChunkReader implements f {

    /* renamed from: a  reason: collision with root package name */
    public final ChunkReaderMode f10784a;
    private final com.kwad.sdk.pngencrypt.chunk.d d;
    private boolean f;

    /* renamed from: b  reason: collision with root package name */
    protected int f10785b = 0;
    private int e = 0;
    protected ErrorBehaviour c = ErrorBehaviour.STRICT;

    /* loaded from: classes5.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.f10784a = chunkReaderMode;
        this.d = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.d.a(j);
        this.f = chunkReaderMode != ChunkReaderMode.SKIP;
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
        if (this.f10785b == 0 && this.e == 0 && this.f) {
            this.d.a(this.d.f10801b, 0, 4);
        }
        int i4 = this.d.f10800a - this.f10785b;
        int i5 = i4 > i2 ? i2 : i4;
        if (i5 > 0 || this.e == 0) {
            if (this.f && this.f10784a != ChunkReaderMode.BUFFER && i5 > 0) {
                this.d.a(bArr, i, i5);
            }
            if (this.f10784a == ChunkReaderMode.BUFFER) {
                if (this.d.d != bArr && i5 > 0) {
                    System.arraycopy(bArr, i, this.d.d, this.f10785b, i5);
                }
            } else if (this.f10784a == ChunkReaderMode.PROCESS) {
                a(this.f10785b, bArr, i, i5);
            }
            this.f10785b += i5;
            i += i5;
            i2 -= i5;
        }
        if (this.f10785b == this.d.f10800a) {
            int i6 = 4 - this.e;
            if (i6 > i2) {
                i6 = i2;
            }
            if (i6 > 0) {
                if (bArr != this.d.e) {
                    System.arraycopy(bArr, i, this.d.e, this.e, i6);
                }
                this.e += i6;
                if (this.e == 4) {
                    if (this.f) {
                        if (this.f10784a == ChunkReaderMode.BUFFER) {
                            this.d.a(this.d.d, 0, this.d.f10800a);
                        }
                        this.d.a(this.c == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Chunk done");
                    c();
                }
            }
            i3 = i6;
        }
        if (i5 > 0 || i3 > 0) {
            return i3 + i5;
        }
        return -1;
    }

    public com.kwad.sdk.pngencrypt.chunk.d a() {
        return this.d;
    }

    protected abstract void a(int i, byte[] bArr, int i2, int i3);

    public void a(boolean z) {
        if (this.f10785b != 0 && z && !this.f) {
            com.kwad.sdk.core.d.a.a(new PngjException("too late!"));
        }
        this.f = z;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        return this.e == 4;
    }

    protected abstract void c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChunkReader chunkReader = (ChunkReader) obj;
            return this.d == null ? chunkReader.d == null : this.d.equals(chunkReader.d);
        }
        return false;
    }

    public int hashCode() {
        return (this.d == null ? 0 : this.d.hashCode()) + 31;
    }

    public String toString() {
        return this.d.toString();
    }
}
