package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class o implements Closeable {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57188b;

    /* renamed from: c  reason: collision with root package name */
    public final c f57189c;

    /* renamed from: d  reason: collision with root package name */
    public final a f57190d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f57191e;

    /* renamed from: f  reason: collision with root package name */
    public int f57192f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f57193g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f57194h;

    public o(InputStream inputStream, boolean z) {
        this.f57192f = -1;
        a aVar = new a(inputStream);
        this.f57190d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f57189c = f2;
        try {
            if (this.f57190d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f57189c.j();
            this.f57188b = this.f57189c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f57189c.c("fdAT");
            this.f57189c.c("fcTL");
            this.f57191e = new ah(this.f57189c.f57087i);
            a(m.a());
            this.f57192f = -1;
        } catch (RuntimeException e2) {
            this.f57190d.close();
            this.f57189c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f57189c;
            if (cVar.f57086h >= 4) {
                return;
            }
            if (this.f57190d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j2) {
        this.f57189c.a(j2);
    }

    public void a(i<? extends Object> iVar) {
        this.f57194h = iVar;
    }

    public ah b() {
        if (this.f57189c.g()) {
            a();
        }
        return this.f57191e;
    }

    public void b(long j2) {
        this.f57189c.c(j2);
    }

    public void c() {
        e();
        this.f57189c.c("IDAT");
        this.f57189c.c("fdAT");
        if (this.f57189c.g()) {
            a();
        }
        d();
    }

    public void c(long j2) {
        this.f57189c.b(j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f57189c != null) {
                this.f57189c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f57190d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f57189c.g()) {
                a();
            }
            if (this.f57189c.h() != null && !this.f57189c.h().d()) {
                this.f57189c.h().g();
            }
            while (!this.f57189c.b() && this.f57190d.a(this.f57189c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f57189c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.a.toString() + " interlaced=" + this.f57188b;
    }
}
