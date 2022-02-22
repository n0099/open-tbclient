package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes4.dex */
public class q extends aa {

    /* renamed from: h  reason: collision with root package name */
    public int f57305h;

    /* renamed from: i  reason: collision with root package name */
    public int f57306i;

    /* renamed from: j  reason: collision with root package name */
    public int f57307j;
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
        if (dVar.a != 13) {
            throw new PngjException("Bad IDHR len " + dVar.a);
        }
        ByteArrayInputStream b2 = dVar.b();
        this.f57305h = com.kwad.sdk.pngencrypt.n.b(b2);
        this.f57306i = com.kwad.sdk.pngencrypt.n.b(b2);
        this.f57307j = com.kwad.sdk.pngencrypt.n.a(b2);
        this.k = com.kwad.sdk.pngencrypt.n.a(b2);
        this.l = com.kwad.sdk.pngencrypt.n.a(b2);
        this.m = com.kwad.sdk.pngencrypt.n.a(b2);
        this.n = com.kwad.sdk.pngencrypt.n.a(b2);
    }

    public void a(com.kwad.sdk.pngencrypt.k kVar) {
        b(this.f57259e.a);
        c(this.f57259e.f57343b);
        d(this.f57259e.f57344c);
        int i2 = this.f57259e.f57346e ? 4 : 0;
        if (this.f57259e.f57348g) {
            i2++;
        }
        if (!this.f57259e.f57347f) {
            i2 += 2;
        }
        e(i2);
        f(0);
        g(0);
        h(0);
    }

    public void b(int i2) {
        this.f57305h = i2;
    }

    public int c() {
        return this.f57305h;
    }

    public void c(int i2) {
        this.f57306i = i2;
    }

    public int d() {
        return this.f57306i;
    }

    public void d(int i2) {
        this.f57307j = i2;
    }

    public int e() {
        return this.f57307j;
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
        if (this.f57305h < 1 || this.f57306i < 1 || this.l != 0 || this.m != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i2 = this.f57307j;
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
                    if (this.f57307j == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i4 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            int i5 = this.f57307j;
            if (i5 != 8 && i5 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }
}
