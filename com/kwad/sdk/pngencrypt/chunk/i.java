package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes5.dex */
public final class i extends p {
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            h();
        }
    }

    private void b(int i) {
        this.h = i;
    }

    private int c() {
        return this.h;
    }

    private void c(int i) {
        this.i = i;
    }

    private int d() {
        return this.i;
    }

    private void d(int i) {
        this.j = i;
    }

    private int e() {
        return this.j;
    }

    private void e(int i) {
        this.k = i;
    }

    private int f() {
        return this.k;
    }

    private void f(int i) {
        this.l = 0;
    }

    private int g() {
        return this.n;
    }

    private void g(int i) {
        this.m = 0;
    }

    private void h() {
        b(this.e.a);
        c(this.e.b);
        d(this.e.c);
        int i = this.e.e ? 4 : 0;
        if (this.e.g) {
            i++;
        }
        if (!this.e.f) {
            i += 2;
        }
        e(i);
        f(0);
        g(0);
        h(0);
    }

    private void h(int i) {
        this.n = 0;
    }

    private void i() {
        if (this.h <= 0 || this.i <= 0 || this.l != 0 || this.m != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.j;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.k;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (this.j == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            int i4 = this.j;
            if (i4 != 8 && i4 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.a != 13) {
            throw new PngjException("Bad IDHR len " + dVar.a);
        }
        ByteArrayInputStream a = dVar.a();
        this.h = com.kwad.sdk.pngencrypt.n.b(a);
        this.i = com.kwad.sdk.pngencrypt.n.b(a);
        this.j = com.kwad.sdk.pngencrypt.n.a(a);
        this.k = com.kwad.sdk.pngencrypt.n.a(a);
        this.l = com.kwad.sdk.pngencrypt.n.a(a);
        this.m = com.kwad.sdk.pngencrypt.n.a(a);
        this.n = com.kwad.sdk.pngencrypt.n.a(a);
    }

    public final boolean a() {
        return g() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k b() {
        i();
        return new com.kwad.sdk.pngencrypt.k(c(), d(), e(), (f() & 4) != 0, f() == 0 || f() == 4, (f() & 1) != 0);
    }
}
