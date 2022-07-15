package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class c extends b {
    public k e;
    public k f;
    public e g;
    public int h = -1;
    public com.kwad.sdk.pngencrypt.chunk.e i = null;
    public long k = 0;
    public boolean l = true;
    public boolean m = false;
    public Set<String> n = new HashSet();
    public long o = 0;
    public long p = 0;
    public long q = 0;
    public ChunkLoadBehaviour s = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    public final boolean j = false;
    public g r = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            a = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    private void c(String str) {
        if (str.equals("IHDR")) {
            if (this.h < 0) {
                this.h = 0;
                return;
            }
            com.kwad.sdk.core.d.b.a(new PngjException("unexpected chunk " + str));
        } else if (str.equals("PLTE")) {
            int i = this.h;
            if (i == 0 || i == 1) {
                this.h = 2;
                return;
            }
            com.kwad.sdk.core.d.b.a(new PngjException("unexpected chunk here " + str));
        } else if (str.equals("IDAT")) {
            int i2 = this.h;
            if (i2 >= 0 && i2 <= 4) {
                this.h = 4;
                return;
            }
            com.kwad.sdk.core.d.b.a(new PngjException("unexpected chunk " + str));
        } else if (str.equals("IEND")) {
            if (this.h >= 4) {
                this.h = 6;
                return;
            }
            com.kwad.sdk.core.d.b.a(new PngjException("unexpected chunk " + str));
        } else {
            int i3 = this.h;
            if (i3 <= 1) {
                this.h = 1;
            } else if (i3 <= 3) {
                this.h = 3;
            } else {
                this.h = 5;
            }
        }
    }

    public static boolean d(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.b(str);
    }

    private int i() {
        return this.h;
    }

    private k j() {
        return this.f;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet a(String str) {
        return new j(str, this.j, j(), this.g);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(int i, String str, long j) {
        c(str);
        super.a(i, str, j);
    }

    public final void a(long j) {
        this.o = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.a().c.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.a());
            k b = iVar.b();
            this.e = b;
            this.f = b;
            if (iVar.a()) {
                this.g = new e(this.f);
            }
            this.i = new com.kwad.sdk.pngencrypt.chunk.e(this.e);
        }
        if (chunkReader.a == ChunkReader.ChunkReaderMode.BUFFER && d(chunkReader.a().c)) {
            this.k += chunkReader.a().a;
        }
        if (chunkReader.a == ChunkReader.ChunkReaderMode.BUFFER || this.m) {
            try {
                this.i.a(this.r.a(chunkReader.a(), g()), this.h);
            } catch (PngjException e) {
                throw e;
            }
        }
    }

    public final void a(boolean z) {
        this.l = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean a() {
        return this.l;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean a(int i, String str) {
        if (super.a(i, str)) {
            return true;
        }
        if (this.o > 0 && i + c() > this.o) {
            com.kwad.sdk.core.d.b.a(new PngjException("Maximum total bytes to read exceeeded: " + this.o + " offset:" + c() + " len=" + i));
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
                int i2 = AnonymousClass1.a[this.s.ordinal()];
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

    public final void b(long j) {
        this.p = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean b(String str) {
        return str.equals("IDAT");
    }

    public final void c(long j) {
        this.q = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.h != 6) {
            this.h = 6;
        }
        super.close();
    }

    public final boolean e() {
        return i() < 4;
    }

    public final j f() {
        DeflatedChunksSet d = d();
        if (d instanceof j) {
            return (j) d;
        }
        return null;
    }

    public final k g() {
        return this.e;
    }

    public final e h() {
        return this.g;
    }
}
