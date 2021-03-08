package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import com.kwad.sdk.pngencrypt.chunk.q;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class c extends b {
    protected k e;
    protected k f;
    protected e g;
    protected final boolean j;
    protected int h = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e i = null;
    private long k = 0;
    private boolean l = true;
    private boolean m = false;
    private Set<String> n = new HashSet();
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private ChunkLoadBehaviour s = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    private g r = new com.kwad.sdk.pngencrypt.chunk.a();

    public c(boolean z) {
        this.j = z;
    }

    private void e(String str) {
        if (str.equals("IHDR")) {
            if (this.h < 0) {
                this.h = 0;
            } else {
                com.kwad.sdk.core.d.a.a(new PngjException("unexpected chunk " + str));
            }
        } else if (str.equals("PLTE")) {
            if (this.h == 0 || this.h == 1) {
                this.h = 2;
            } else {
                com.kwad.sdk.core.d.a.a(new PngjException("unexpected chunk here " + str));
            }
        } else if (str.equals("IDAT")) {
            if (this.h < 0 || this.h > 4) {
                com.kwad.sdk.core.d.a.a(new PngjException("unexpected chunk " + str));
            } else {
                this.h = 4;
            }
        } else if (str.equals("IEND")) {
            if (this.h >= 4) {
                this.h = 6;
            } else {
                com.kwad.sdk.core.d.a.a(new PngjException("unexpected chunk " + str));
            }
        } else if (this.h <= 1) {
            this.h = 1;
        } else if (this.h <= 3) {
            this.h = 3;
        } else {
            this.h = 5;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected DeflatedChunksSet a(String str) {
        return new j(str, this.j, l(), this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.b
    public void a(int i, String str, long j) {
        e(str);
        super.a(i, str, j);
    }

    public void a(long j) {
        this.o = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.b
    public void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.a().c.equals("IHDR")) {
            q qVar = new q(null);
            qVar.a(chunkReader.a());
            this.e = qVar.i();
            this.f = this.e;
            if (qVar.h()) {
                this.g = new e(this.f);
            }
            this.i = new com.kwad.sdk.pngencrypt.chunk.e(this.e);
        }
        if (chunkReader.f6912a == ChunkReader.ChunkReaderMode.BUFFER && d(chunkReader.a().c)) {
            this.k += chunkReader.a().f6921a;
        }
        if (chunkReader.f6912a == ChunkReader.ChunkReaderMode.BUFFER || this.m) {
            try {
                this.i.a(this.r.a(chunkReader.a(), j()), this.h);
            } catch (PngjException e) {
                throw e;
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
        if (this.p <= 0 || i <= this.p) {
            if (this.q <= 0 || i <= this.q - this.k) {
                switch (this.s) {
                    case LOAD_CHUNK_NEVER:
                        return true;
                    case LOAD_CHUNK_IF_SAFE:
                        if (!com.kwad.sdk.pngencrypt.chunk.b.d(str)) {
                            return true;
                        }
                        break;
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
    protected boolean b(int i, String str) {
        return this.l;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected boolean b(String str) {
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
        if (this.h != 6) {
            this.h = 6;
        }
        super.close();
    }

    protected boolean d(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.b(str);
    }

    public int f() {
        return this.h;
    }

    public boolean g() {
        return f() < 4;
    }

    public j h() {
        DeflatedChunksSet c = c();
        if (c instanceof j) {
            return (j) c;
        }
        return null;
    }

    protected void i() {
    }

    public k j() {
        return this.e;
    }

    public e k() {
        return this.g;
    }

    public k l() {
        return this.f;
    }
}
