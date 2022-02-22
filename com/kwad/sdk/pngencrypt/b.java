package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes4.dex */
public abstract class b implements f, Closeable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f57239d = !b.class.desiredAssertionStatus();
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57240b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57241c;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f57242e;

    /* renamed from: f  reason: collision with root package name */
    public final int f57243f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f57244g;

    /* renamed from: h  reason: collision with root package name */
    public int f57245h;

    /* renamed from: i  reason: collision with root package name */
    public int f57246i;

    /* renamed from: j  reason: collision with root package name */
    public long f57247j;
    public DeflatedChunksSet k;
    public ChunkReader l;
    public long m;
    public ErrorBehaviour n;

    public b() {
        this(n.a());
    }

    public b(byte[] bArr) {
        this.f57244g = new byte[8];
        this.f57245h = 0;
        this.a = false;
        this.f57240b = false;
        this.f57241c = false;
        this.f57246i = 0;
        this.f57247j = 0L;
        this.n = ErrorBehaviour.STRICT;
        this.f57242e = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.f57243f = length;
        this.a = length <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i2, int i3) {
        int i4;
        long j2;
        long j3;
        if (this.f57241c) {
            return -1;
        }
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("This should not happen. Bad length: " + i3));
        }
        if (this.a) {
            ChunkReader chunkReader = this.l;
            if (chunkReader == null || chunkReader.b()) {
                int i5 = 8 - this.f57245h;
                if (i5 <= i3) {
                    i3 = i5;
                }
                System.arraycopy(bArr, i2, this.f57244g, this.f57245h, i3);
                int i6 = this.f57245h + i3;
                this.f57245h = i6;
                i4 = 0 + i3;
                this.f57247j += i3;
                if (i6 == 8) {
                    this.f57246i++;
                    a(n.c(this.f57244g, 0), com.kwad.sdk.pngencrypt.chunk.b.a(this.f57244g, 4), this.f57247j - 8);
                    this.f57245h = 0;
                }
                return i4;
            }
            int a = this.l.a(bArr, i2, i3);
            if (a < 0) {
                return -1;
            }
            i4 = a + 0;
            j2 = this.f57247j;
            j3 = a;
        } else {
            int i7 = this.f57243f - this.f57245h;
            if (i7 <= i3) {
                i3 = i7;
            }
            System.arraycopy(bArr, i2, this.f57244g, this.f57245h, i3);
            int i8 = this.f57245h + i3;
            this.f57245h = i8;
            if (i8 == this.f57243f) {
                a(this.f57244g);
                this.f57245h = 0;
                this.a = true;
            }
            i4 = 0 + i3;
            j2 = this.f57247j;
            j3 = i3;
        }
        this.f57247j = j2 + j3;
        return i4;
    }

    public long a() {
        return this.f57247j;
    }

    public ChunkReader a(String str, int i2, long j2, boolean z) {
        return new ChunkReader(i2, str, j2, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public void a(int i3, byte[] bArr, int i4, int i5) {
                com.kwad.sdk.core.d.a.a(new PngjException("should never happen"));
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public void c() {
                b.this.a(this);
            }
        };
    }

    public abstract DeflatedChunksSet a(String str);

    public void a(int i2, String str, long j2) {
        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "New chunk: " + str + " " + i2 + " off:" + j2);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.f57275e.matcher(str).matches()) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk id: " + str));
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk len: " + i2));
        }
        if (str.equals("IDAT")) {
            this.m += i2;
        }
        boolean b2 = b(i2, str);
        boolean a = a(i2, str);
        boolean b3 = b(str);
        DeflatedChunksSet deflatedChunksSet = this.k;
        boolean a2 = (deflatedChunksSet == null || deflatedChunksSet.e()) ? false : this.k.a(str);
        if (!b3 || a) {
            this.l = a(str, i2, j2, a);
        } else {
            if (!a2) {
                DeflatedChunksSet deflatedChunksSet2 = this.k;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.d()) {
                    com.kwad.sdk.core.d.a.a(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.k = a(str);
            }
            this.l = new d(i2, str, b2, j2, this.k) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public void c() {
                    super.c();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.l;
        if (chunkReader == null || b2) {
            return;
        }
        chunkReader.a(false);
    }

    public void a(ChunkReader chunkReader) {
        String d2;
        if (this.f57246i == 1 && (d2 = d()) != null && !d2.equals(chunkReader.a().f57278c)) {
            String str = "Bad first chunk: " + chunkReader.a().f57278c + " expected: " + d();
            if (this.n.f57231c < ErrorBehaviour.SUPER_LENIENT.f57231c) {
                com.kwad.sdk.core.d.a.a(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", str);
            }
        }
        if (e() == null || !chunkReader.a().f57278c.equals(e())) {
            return;
        }
        this.f57240b = true;
        close();
    }

    public void a(byte[] bArr) {
        if (Arrays.equals(bArr, n.a())) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    public boolean a(int i2, String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public boolean b() {
        return this.f57240b;
    }

    public boolean b(int i2, String str) {
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
        this.f57241c = true;
    }

    public String d() {
        return "IHDR";
    }

    public String e() {
        return "IEND";
    }
}
