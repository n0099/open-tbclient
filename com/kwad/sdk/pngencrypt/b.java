package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes5.dex */
public abstract class b implements f, Closeable {
    public static final /* synthetic */ boolean d = !b.class.desiredAssertionStatus();
    public boolean a;
    public boolean b;
    public boolean c;
    public final byte[] e;
    public final int f;
    public byte[] g;
    public int h;
    public int i;
    public long j;
    public DeflatedChunksSet k;
    public ChunkReader l;
    public long m;
    public ErrorBehaviour n;

    public b() {
        this(n.a());
    }

    public b(byte[] bArr) {
        this.g = new byte[8];
        this.h = 0;
        this.a = false;
        this.b = false;
        this.c = false;
        this.i = 0;
        this.j = 0L;
        this.n = ErrorBehaviour.STRICT;
        this.e = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.f = length;
        this.a = length <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        int i3;
        long j;
        long j2;
        if (this.c) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (this.a) {
            ChunkReader chunkReader = this.l;
            if (chunkReader == null || chunkReader.b()) {
                int i4 = 8 - this.h;
                if (i4 <= i2) {
                    i2 = i4;
                }
                System.arraycopy(bArr, i, this.g, this.h, i2);
                int i5 = this.h + i2;
                this.h = i5;
                i3 = 0 + i2;
                this.j += i2;
                if (i5 == 8) {
                    this.i++;
                    a(n.c(this.g, 0), com.kwad.sdk.pngencrypt.chunk.b.a(this.g, 4), this.j - 8);
                    this.h = 0;
                }
                return i3;
            }
            int a = this.l.a(bArr, i, i2);
            if (a < 0) {
                return -1;
            }
            i3 = a + 0;
            j = this.j;
            j2 = a;
        } else {
            int i6 = this.f - this.h;
            if (i6 <= i2) {
                i2 = i6;
            }
            System.arraycopy(bArr, i, this.g, this.h, i2);
            int i7 = this.h + i2;
            this.h = i7;
            if (i7 == this.f) {
                a(this.g);
                this.h = 0;
                this.a = true;
            }
            i3 = 0 + i2;
            j = this.j;
            j2 = i2;
        }
        this.j = j + j2;
        return i3;
    }

    public long a() {
        return this.j;
    }

    public ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public void a(int i2, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.d.a.a(new PngjException("should never happen"));
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public void c() {
                b.this.a(this);
            }
        };
    }

    public abstract DeflatedChunksSet a(String str);

    public void a(int i, String str, long j) {
        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "New chunk: " + str + " " + i + " off:" + j);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.e.matcher(str).matches()) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk id: " + str));
        }
        if (i < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk len: " + i));
        }
        if (str.equals("IDAT")) {
            this.m += i;
        }
        boolean b = b(i, str);
        boolean a = a(i, str);
        boolean b2 = b(str);
        DeflatedChunksSet deflatedChunksSet = this.k;
        boolean a2 = (deflatedChunksSet == null || deflatedChunksSet.e()) ? false : this.k.a(str);
        if (!b2 || a) {
            this.l = a(str, i, j, a);
        } else {
            if (!a2) {
                DeflatedChunksSet deflatedChunksSet2 = this.k;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.d()) {
                    com.kwad.sdk.core.d.a.a(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.k = a(str);
            }
            this.l = new d(i, str, b, j, this.k) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public void c() {
                    super.c();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.l;
        if (chunkReader == null || b) {
            return;
        }
        chunkReader.a(false);
    }

    public void a(ChunkReader chunkReader) {
        String d2;
        if (this.i == 1 && (d2 = d()) != null && !d2.equals(chunkReader.a().c)) {
            String str = "Bad first chunk: " + chunkReader.a().c + " expected: " + d();
            if (this.n.c < ErrorBehaviour.SUPER_LENIENT.c) {
                com.kwad.sdk.core.d.a.a(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", str);
            }
        }
        if (e() == null || !chunkReader.a().c.equals(e())) {
            return;
        }
        this.b = true;
        close();
    }

    public void a(byte[] bArr) {
        if (Arrays.equals(bArr, n.a())) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    public boolean a(int i, String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public boolean b() {
        return this.b;
    }

    public boolean b(int i, String str) {
        return true;
    }

    public boolean b(String str) {
        return false;
    }

    public DeflatedChunksSet c() {
        return this.k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.k;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.f();
        }
        this.c = true;
    }

    public String d() {
        return "IHDR";
    }

    public String e() {
        return "IEND";
    }
}
