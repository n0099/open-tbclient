package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes6.dex */
public class q extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f33495h;

    /* renamed from: i  reason: collision with root package name */
    public int f33496i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            a(kVar);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f33467a != 13) {
            throw new PngjException("Bad IDHR len " + dVar.f33467a);
        }
        ByteArrayInputStream b2 = dVar.b();
        this.f33495h = com.kwad.sdk.pngencrypt.n.b(b2);
        this.f33496i = com.kwad.sdk.pngencrypt.n.b(b2);
        this.j = com.kwad.sdk.pngencrypt.n.a(b2);
        this.k = com.kwad.sdk.pngencrypt.n.a(b2);
        this.l = com.kwad.sdk.pngencrypt.n.a(b2);
        this.m = com.kwad.sdk.pngencrypt.n.a(b2);
        this.n = com.kwad.sdk.pngencrypt.n.a(b2);
    }

    public void a(com.kwad.sdk.pngencrypt.k kVar) {
        b(this.f33448e.f33527a);
        c(this.f33448e.f33528b);
        d(this.f33448e.f33529c);
        int i2 = this.f33448e.f33531e ? 4 : 0;
        if (this.f33448e.f33533g) {
            i2++;
        }
        if (!this.f33448e.f33532f) {
            i2 += 2;
        }
        e(i2);
        f(0);
        g(0);
        h(0);
    }

    public void b(int i2) {
        this.f33495h = i2;
    }

    public int c() {
        return this.f33495h;
    }

    public void c(int i2) {
        this.f33496i = i2;
    }

    public int d() {
        return this.f33496i;
    }

    public void d(int i2) {
        this.j = i2;
    }

    public int e() {
        return this.j;
    }

    public void e(int i2) {
        this.k = i2;
    }

    public int f() {
        return this.k;
    }

    public void f(int i2) {
        this.l = i2;
    }

    public int g() {
        return this.n;
    }

    public void g(int i2) {
        this.m = i2;
    }

    public void h(int i2) {
        this.n = i2;
    }

    public boolean h() {
        return g() == 1;
    }

    public com.kwad.sdk.pngencrypt.k i() {
        j();
        return new com.kwad.sdk.pngencrypt.k(c(), d(), e(), (f() & 4) != 0, f() == 0 || f() == 4, (f() & 1) != 0);
    }

    public void j() {
        if (this.f33495h < 1 || this.f33496i < 1 || this.l != 0 || this.m != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i2 = this.j;
        if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 8 && i2 != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i3 = this.n;
        if (i3 < 0 || i3 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i4 = this.k;
        if (i4 != 0) {
            if (i4 != 6 && i4 != 2) {
                if (i4 == 3) {
                    if (this.j == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i4 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            int i5 = this.j;
            if (i5 != 8 && i5 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }
}
