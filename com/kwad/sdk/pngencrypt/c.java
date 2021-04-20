package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import com.kwad.sdk.pngencrypt.chunk.q;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class c extends b {

    /* renamed from: e  reason: collision with root package name */
    public k f36404e;

    /* renamed from: f  reason: collision with root package name */
    public k f36405f;

    /* renamed from: g  reason: collision with root package name */
    public e f36406g;
    public final boolean j;

    /* renamed from: h  reason: collision with root package name */
    public int f36407h = -1;
    public com.kwad.sdk.pngencrypt.chunk.e i = null;
    public long k = 0;
    public boolean l = true;
    public boolean m = false;
    public Set<String> n = new HashSet();
    public long o = 0;
    public long p = 0;
    public long q = 0;
    public ChunkLoadBehaviour s = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    public g r = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36408a;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            f36408a = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36408a[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
        this.j = z;
    }

    private void e(String str) {
        int i;
        PngjException pngjException;
        if (str.equals("IHDR")) {
            if (this.f36407h < 0) {
                i = 0;
                this.f36407h = i;
                return;
            }
            pngjException = new PngjException("unexpected chunk " + str);
            com.kwad.sdk.core.d.a.a(pngjException);
        } else if (str.equals("PLTE")) {
            int i2 = this.f36407h;
            if (i2 == 0 || i2 == 1) {
                i = 2;
                this.f36407h = i;
                return;
            }
            pngjException = new PngjException("unexpected chunk here " + str);
            com.kwad.sdk.core.d.a.a(pngjException);
        } else {
            if (!str.equals("IDAT")) {
                if (!str.equals("IEND")) {
                    int i3 = this.f36407h;
                    if (i3 <= 1) {
                        this.f36407h = 1;
                        return;
                    } else if (i3 <= 3) {
                        this.f36407h = 3;
                        return;
                    } else {
                        i = 5;
                    }
                } else if (this.f36407h >= 4) {
                    i = 6;
                } else {
                    pngjException = new PngjException("unexpected chunk " + str);
                }
                this.f36407h = i;
                return;
            }
            int i4 = this.f36407h;
            if (i4 >= 0 && i4 <= 4) {
                this.f36407h = 4;
                return;
            }
            pngjException = new PngjException("unexpected chunk " + str);
            com.kwad.sdk.core.d.a.a(pngjException);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public DeflatedChunksSet a(String str) {
        return new j(str, this.j, l(), this.f36406g);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public void a(int i, String str, long j) {
        e(str);
        super.a(i, str, j);
    }

    public void a(long j) {
        this.o = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.a().f36431c.equals("IHDR")) {
            q qVar = new q(null);
            qVar.a(chunkReader.a());
            k i = qVar.i();
            this.f36404e = i;
            this.f36405f = i;
            if (qVar.h()) {
                this.f36406g = new e(this.f36405f);
            }
            this.i = new com.kwad.sdk.pngencrypt.chunk.e(this.f36404e);
        }
        if (chunkReader.f36371a == ChunkReader.ChunkReaderMode.BUFFER && d(chunkReader.a().f36431c)) {
            this.k += chunkReader.a().f36429a;
        }
        if (chunkReader.f36371a == ChunkReader.ChunkReaderMode.BUFFER || this.m) {
            try {
                this.i.a(this.r.a(chunkReader.a(), j()), this.f36407h);
            } catch (PngjException e2) {
                throw e2;
            }
        }
        if (b()) {
            i();
        }
    }

    public void a(boolean z) {
        this.l = z;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public boolean a(int i, String str) {
        if (super.a(i, str)) {
            return true;
        }
        if (this.o > 0 && i + a() > this.o) {
            com.kwad.sdk.core.d.a.a(new PngjException("Maximum total bytes to read exceeeded: " + this.o + " offset:" + a() + " len=" + i));
        }
        if (this.n.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.b(str)) {
            return false;
        }
        long j = this.p;
        if (j <= 0 || i <= j) {
            long j2 = this.q;
            if (j2 <= 0 || i <= j2 - this.k) {
                int i2 = AnonymousClass1.f36408a[this.s.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return true;
                    }
                } else if (!com.kwad.sdk.pngencrypt.chunk.b.d(str)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void b(long j) {
        this.p = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public boolean b(int i, String str) {
        return this.l;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public boolean b(String str) {
        return str.equals("IDAT");
    }

    public void c(long j) {
        this.q = j;
    }

    public void c(String str) {
        this.n.add(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f36407h != 6) {
            this.f36407h = 6;
        }
        super.close();
    }

    public boolean d(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.b(str);
    }

    public int f() {
        return this.f36407h;
    }

    public boolean g() {
        return f() < 4;
    }

    public j h() {
        DeflatedChunksSet c2 = c();
        if (c2 instanceof j) {
            return (j) c2;
        }
        return null;
    }

    public void i() {
    }

    public k j() {
        return this.f36404e;
    }

    public e k() {
        return this.f36406g;
    }

    public k l() {
        return this.f36405f;
    }
}
