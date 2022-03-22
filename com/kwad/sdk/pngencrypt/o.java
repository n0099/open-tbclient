package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class o implements Closeable {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f40690b;

    /* renamed from: c  reason: collision with root package name */
    public final c f40691c;

    /* renamed from: d  reason: collision with root package name */
    public final a f40692d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f40693e;

    /* renamed from: f  reason: collision with root package name */
    public int f40694f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f40695g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f40696h;

    public o(InputStream inputStream, boolean z) {
        this.f40694f = -1;
        a aVar = new a(inputStream);
        this.f40692d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f40691c = f2;
        try {
            if (this.f40692d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f40691c.j();
            this.f40690b = this.f40691c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f40691c.c("fdAT");
            this.f40691c.c("fcTL");
            this.f40693e = new ah(this.f40691c.i);
            a(m.a());
            this.f40694f = -1;
        } catch (RuntimeException e2) {
            this.f40692d.close();
            this.f40691c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f40691c;
            if (cVar.f40624h >= 4) {
                return;
            }
            if (this.f40692d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f40691c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f40696h = iVar;
    }

    public ah b() {
        if (this.f40691c.g()) {
            a();
        }
        return this.f40693e;
    }

    public void b(long j) {
        this.f40691c.c(j);
    }

    public void c() {
        e();
        this.f40691c.c("IDAT");
        this.f40691c.c("fdAT");
        if (this.f40691c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f40691c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f40691c != null) {
                this.f40691c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f40692d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f40691c.g()) {
                a();
            }
            if (this.f40691c.h() != null && !this.f40691c.h().d()) {
                this.f40691c.h().g();
            }
            while (!this.f40691c.b() && this.f40692d.a(this.f40691c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f40691c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.a.toString() + " interlaced=" + this.f40690b;
    }
}
