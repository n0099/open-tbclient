package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f36583a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36584b;

    /* renamed from: c  reason: collision with root package name */
    public final c f36585c;

    /* renamed from: d  reason: collision with root package name */
    public final a f36586d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f36587e;

    /* renamed from: f  reason: collision with root package name */
    public int f36588f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f36589g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f36590h;

    public o(InputStream inputStream, boolean z) {
        this.f36588f = -1;
        a aVar = new a(inputStream);
        this.f36586d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f36585c = f2;
        try {
            if (this.f36586d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f36583a = this.f36585c.j();
            this.f36584b = this.f36585c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f36585c.c("fdAT");
            this.f36585c.c("fcTL");
            this.f36587e = new ah(this.f36585c.i);
            a(m.a());
            this.f36588f = -1;
        } catch (RuntimeException e2) {
            this.f36586d.close();
            this.f36585c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f36585c;
            if (cVar.f36502h >= 4) {
                return;
            }
            if (this.f36586d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f36585c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f36590h = iVar;
    }

    public ah b() {
        if (this.f36585c.g()) {
            a();
        }
        return this.f36587e;
    }

    public void b(long j) {
        this.f36585c.c(j);
    }

    public void c() {
        e();
        this.f36585c.c("IDAT");
        this.f36585c.c("fdAT");
        if (this.f36585c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f36585c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f36585c != null) {
                this.f36585c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.d("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f36586d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f36585c.g()) {
                a();
            }
            if (this.f36585c.h() != null && !this.f36585c.h().d()) {
                this.f36585c.h().g();
            }
            while (!this.f36585c.b() && this.f36586d.a(this.f36585c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f36585c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f36583a.toString() + " interlaced=" + this.f36584b;
    }
}
