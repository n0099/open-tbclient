package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class o implements Closeable {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f59388b;

    /* renamed from: c  reason: collision with root package name */
    public final c f59389c;

    /* renamed from: d  reason: collision with root package name */
    public final a f59390d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f59391e;

    /* renamed from: f  reason: collision with root package name */
    public int f59392f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f59393g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f59394h;

    public o(InputStream inputStream, boolean z) {
        this.f59392f = -1;
        a aVar = new a(inputStream);
        this.f59390d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f59389c = f2;
        try {
            if (this.f59390d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f59389c.j();
            this.f59388b = this.f59389c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f59389c.c("fdAT");
            this.f59389c.c("fcTL");
            this.f59391e = new ah(this.f59389c.f59275i);
            a(m.a());
            this.f59392f = -1;
        } catch (RuntimeException e2) {
            this.f59390d.close();
            this.f59389c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f59389c;
            if (cVar.f59274h >= 4) {
                return;
            }
            if (this.f59390d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j2) {
        this.f59389c.a(j2);
    }

    public void a(i<? extends Object> iVar) {
        this.f59394h = iVar;
    }

    public ah b() {
        if (this.f59389c.g()) {
            a();
        }
        return this.f59391e;
    }

    public void b(long j2) {
        this.f59389c.c(j2);
    }

    public void c() {
        e();
        this.f59389c.c("IDAT");
        this.f59389c.c("fdAT");
        if (this.f59389c.g()) {
            a();
        }
        d();
    }

    public void c(long j2) {
        this.f59389c.b(j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f59389c != null) {
                this.f59389c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f59390d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f59389c.g()) {
                a();
            }
            if (this.f59389c.h() != null && !this.f59389c.h().d()) {
                this.f59389c.h().g();
            }
            while (!this.f59389c.b() && this.f59390d.a(this.f59389c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f59389c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.a.toString() + " interlaced=" + this.f59388b;
    }
}
