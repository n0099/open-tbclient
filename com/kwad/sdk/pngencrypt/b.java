package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes7.dex */
public abstract class b implements f, Closeable {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f36816d = !b.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public boolean f36817a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36818b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36819c;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f36820e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36821f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f36822g;

    /* renamed from: h  reason: collision with root package name */
    public int f36823h;

    /* renamed from: i  reason: collision with root package name */
    public int f36824i;
    public long j;
    public DeflatedChunksSet k;
    public ChunkReader l;
    public long m;
    public ErrorBehaviour n;

    public b() {
        this(n.a());
    }

    public b(byte[] bArr) {
        this.f36822g = new byte[8];
        this.f36823h = 0;
        this.f36817a = false;
        this.f36818b = false;
        this.f36819c = false;
        this.f36824i = 0;
        this.j = 0L;
        this.n = ErrorBehaviour.STRICT;
        this.f36820e = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.f36821f = length;
        this.f36817a = length <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        long j2;
        if (this.f36819c) {
            return -1;
        }
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("This should not happen. Bad length: " + i3));
        }
        if (this.f36817a) {
            ChunkReader chunkReader = this.l;
            if (chunkReader == null || chunkReader.b()) {
                int i5 = 8 - this.f36823h;
                if (i5 <= i3) {
                    i3 = i5;
                }
                System.arraycopy(bArr, i2, this.f36822g, this.f36823h, i3);
                int i6 = this.f36823h + i3;
                this.f36823h = i6;
                i4 = 0 + i3;
                this.j += i3;
                if (i6 == 8) {
                    this.f36824i++;
                    a(n.c(this.f36822g, 0), com.kwad.sdk.pngencrypt.chunk.b.a(this.f36822g, 4), this.j - 8);
                    this.f36823h = 0;
                }
                return i4;
            }
            int a2 = this.l.a(bArr, i2, i3);
            if (a2 < 0) {
                return -1;
            }
            i4 = a2 + 0;
            j = this.j;
            j2 = a2;
        } else {
            int i7 = this.f36821f - this.f36823h;
            if (i7 <= i3) {
                i3 = i7;
            }
            System.arraycopy(bArr, i2, this.f36822g, this.f36823h, i3);
            int i8 = this.f36823h + i3;
            this.f36823h = i8;
            if (i8 == this.f36821f) {
                a(this.f36822g);
                this.f36823h = 0;
                this.f36817a = true;
            }
            i4 = 0 + i3;
            j = this.j;
            j2 = i3;
        }
        this.j = j + j2;
        return i4;
    }

    public long a() {
        return this.j;
    }

    public ChunkReader a(String str, int i2, long j, boolean z) {
        return new ChunkReader(i2, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
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

    public void a(int i2, String str, long j) {
        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "New chunk: " + str + " " + i2 + " off:" + j);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.f36854e.matcher(str).matches()) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk id: " + str));
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk len: " + i2));
        }
        if (str.equals("IDAT")) {
            this.m += i2;
        }
        boolean b2 = b(i2, str);
        boolean a2 = a(i2, str);
        boolean b3 = b(str);
        DeflatedChunksSet deflatedChunksSet = this.k;
        boolean a3 = (deflatedChunksSet == null || deflatedChunksSet.e()) ? false : this.k.a(str);
        if (!b3 || a2) {
            this.l = a(str, i2, j, a2);
        } else {
            if (!a3) {
                DeflatedChunksSet deflatedChunksSet2 = this.k;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.d()) {
                    com.kwad.sdk.core.d.a.a(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.k = a(str);
            }
            this.l = new d(i2, str, b2, j, this.k) { // from class: com.kwad.sdk.pngencrypt.b.1
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
        if (this.f36824i == 1 && (d2 = d()) != null && !d2.equals(chunkReader.a().f36858c)) {
            String str = "Bad first chunk: " + chunkReader.a().f36858c + " expected: " + d();
            if (this.n.f36807c < ErrorBehaviour.SUPER_LENIENT.f36807c) {
                com.kwad.sdk.core.d.a.a(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", str);
            }
        }
        if (e() == null || !chunkReader.a().f36858c.equals(e())) {
            return;
        }
        this.f36818b = true;
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
        return this.f36818b;
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
        this.f36819c = true;
    }

    public String d() {
        return "IHDR";
    }

    public String e() {
        return "IEND";
    }
}
