package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes6.dex */
public class q extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f36161h;
    public int i;
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
        if (dVar.f36139a != 13) {
            throw new PngjException("Bad IDHR len " + dVar.f36139a);
        }
        ByteArrayInputStream b2 = dVar.b();
        this.f36161h = com.kwad.sdk.pngencrypt.n.b(b2);
        this.i = com.kwad.sdk.pngencrypt.n.b(b2);
        this.j = com.kwad.sdk.pngencrypt.n.a(b2);
        this.k = com.kwad.sdk.pngencrypt.n.a(b2);
        this.l = com.kwad.sdk.pngencrypt.n.a(b2);
        this.m = com.kwad.sdk.pngencrypt.n.a(b2);
        this.n = com.kwad.sdk.pngencrypt.n.a(b2);
    }

    public void a(com.kwad.sdk.pngencrypt.k kVar) {
        b(this.f36123e.f36184a);
        c(this.f36123e.f36185b);
        d(this.f36123e.f36186c);
        int i = this.f36123e.f36188e ? 4 : 0;
        if (this.f36123e.f36190g) {
            i++;
        }
        if (!this.f36123e.f36189f) {
            i += 2;
        }
        e(i);
        f(0);
        g(0);
        h(0);
    }

    public void b(int i) {
        this.f36161h = i;
    }

    public int c() {
        return this.f36161h;
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
        if (this.f36161h < 1 || this.i < 1 || this.l != 0 || this.m != 0) {
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
}
