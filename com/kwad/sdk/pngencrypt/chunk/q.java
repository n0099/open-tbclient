package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes5.dex */
public class q extends aa {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            a(kVar);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        if (dVar.f10800a != 13) {
            throw new PngjException("Bad IDHR len " + dVar.f10800a);
        }
        ByteArrayInputStream b2 = dVar.b();
        this.h = com.kwad.sdk.pngencrypt.n.b(b2);
        this.i = com.kwad.sdk.pngencrypt.n.b(b2);
        this.j = com.kwad.sdk.pngencrypt.n.a(b2);
        this.k = com.kwad.sdk.pngencrypt.n.a(b2);
        this.l = com.kwad.sdk.pngencrypt.n.a(b2);
        this.m = com.kwad.sdk.pngencrypt.n.a(b2);
        this.n = com.kwad.sdk.pngencrypt.n.a(b2);
    }

    public void a(com.kwad.sdk.pngencrypt.k kVar) {
        b(this.e.f10810a);
        c(this.e.f10811b);
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

    public void b(int i) {
        this.h = i;
    }

    public int c() {
        return this.h;
    }

    public void c(int i) {
        this.i = i;
    }

    public int d() {
        return this.i;
    }

    public void d(int i) {
        this.j = i;
    }

    public int e() {
        return this.j;
    }

    public void e(int i) {
        this.k = i;
    }

    public int f() {
        return this.k;
    }

    public void f(int i) {
        this.l = i;
    }

    public int g() {
        return this.n;
    }

    public void g(int i) {
        this.m = i;
    }

    public void h(int i) {
        this.n = i;
    }

    public boolean h() {
        return g() == 1;
    }

    public com.kwad.sdk.pngencrypt.k i() {
        j();
        return new com.kwad.sdk.pngencrypt.k(c(), d(), e(), (f() & 4) != 0, f() == 0 || f() == 4, (f() & 1) != 0);
    }

    public void j() {
        if (this.h < 1 || this.i < 1 || this.l != 0 || this.m != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        if (this.j != 1 && this.j != 2 && this.j != 4 && this.j != 8 && this.j != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        if (this.n < 0 || this.n > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        switch (this.k) {
            case 0:
                return;
            case 1:
            case 5:
            default:
                throw new PngjException("bad IHDR: invalid colormodel");
            case 2:
            case 4:
            case 6:
                if (this.j != 8 && this.j != 16) {
                    throw new PngjException("bad IHDR: bitdepth invalid");
                }
                return;
            case 3:
                if (this.j == 16) {
                    throw new PngjException("bad IHDR: bitdepth invalid");
                }
                return;
        }
    }
}
