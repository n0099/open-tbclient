package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes3.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean d;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f6915a;
    protected boolean b;
    protected boolean c;
    private final byte[] e;
    private final int f;
    private byte[] g;
    private int h;
    private int i;
    private long j;
    private DeflatedChunksSet k;
    private ChunkReader l;
    private long m;
    private ErrorBehaviour n;

    static {
        d = !b.class.desiredAssertionStatus();
    }

    public b() {
        this(n.a());
    }

    public b(byte[] bArr) {
        this.g = new byte[8];
        this.h = 0;
        this.f6915a = false;
        this.b = false;
        this.c = false;
        this.i = 0;
        this.j = 0L;
        this.n = ErrorBehaviour.STRICT;
        this.e = bArr;
        this.f = this.e == null ? 0 : this.e.length;
        this.f6915a = this.f <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        if (this.c) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (!this.f6915a) {
            int i3 = this.f - this.h;
            if (i3 <= i2) {
                i2 = i3;
            }
            System.arraycopy(bArr, i, this.g, this.h, i2);
            this.h += i2;
            if (this.h == this.f) {
                a(this.g);
                this.h = 0;
                this.f6915a = true;
            }
            int i4 = 0 + i2;
            this.j += i2;
            return i4;
        } else if (this.l != null && !this.l.b()) {
            int a2 = this.l.a(bArr, i, i2);
            if (a2 >= 0) {
                int i5 = 0 + a2;
                this.j = a2 + this.j;
                return i5;
            }
            return -1;
        } else {
            int i6 = 8 - this.h;
            if (i6 <= i2) {
                i2 = i6;
            }
            System.arraycopy(bArr, i, this.g, this.h, i2);
            this.h += i2;
            int i7 = 0 + i2;
            this.j += i2;
            if (this.h == 8) {
                this.i++;
                a(n.c(this.g, 0), com.kwad.sdk.pngencrypt.chunk.b.a(this.g, 4), this.j - 8);
                this.h = 0;
                return i7;
            }
            return i7;
        }
    }

    public long a() {
        return this.j;
    }

    protected ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected void a(int i2, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.d.a.a(new PngjException("should never happen"));
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected void c() {
                b.this.a(this);
            }
        };
    }

    protected abstract DeflatedChunksSet a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
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
        boolean a2 = a(i, str);
        boolean b2 = b(str);
        boolean z = false;
        if (this.k != null && !this.k.e()) {
            z = this.k.a(str);
        }
        if (!b2 || a2) {
            this.l = a(str, i, j, a2);
        } else {
            if (!z) {
                if (this.k != null && !this.k.d()) {
                    com.kwad.sdk.core.d.a.a(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.k = a(str);
            }
            this.l = new d(i, str, b, j, this.k) { // from class: com.kwad.sdk.pngencrypt.b.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public void c() {
                    super.c();
                    b.this.a(this);
                }
            };
        }
        if (this.l == null || b) {
            return;
        }
        this.l.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    protected void a(byte[] bArr) {
        if (Arrays.equals(bArr, n.a())) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public boolean b() {
        return this.b;
    }

    protected boolean b(int i, String str) {
        return true;
    }

    protected boolean b(String str) {
        return false;
    }

    public DeflatedChunksSet c() {
        return this.k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k != null) {
            this.k.f();
        }
        this.c = true;
    }

    protected String d() {
        return "IHDR";
    }

    protected String e() {
        return "IEND";
    }
}
