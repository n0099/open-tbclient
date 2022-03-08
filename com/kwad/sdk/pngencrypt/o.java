package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class o implements Closeable {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f55705b;

    /* renamed from: c  reason: collision with root package name */
    public final c f55706c;

    /* renamed from: d  reason: collision with root package name */
    public final a f55707d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f55708e;

    /* renamed from: f  reason: collision with root package name */
    public int f55709f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f55710g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f55711h;

    public o(InputStream inputStream, boolean z) {
        this.f55709f = -1;
        a aVar = new a(inputStream);
        this.f55707d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f55706c = f2;
        try {
            if (this.f55707d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f55706c.j();
            this.f55705b = this.f55706c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f55706c.c("fdAT");
            this.f55706c.c("fcTL");
            this.f55708e = new ah(this.f55706c.f55604i);
            a(m.a());
            this.f55709f = -1;
        } catch (RuntimeException e2) {
            this.f55707d.close();
            this.f55706c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f55706c;
            if (cVar.f55603h >= 4) {
                return;
            }
            if (this.f55707d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j2) {
        this.f55706c.a(j2);
    }

    public void a(i<? extends Object> iVar) {
        this.f55711h = iVar;
    }

    public ah b() {
        if (this.f55706c.g()) {
            a();
        }
        return this.f55708e;
    }

    public void b(long j2) {
        this.f55706c.c(j2);
    }

    public void c() {
        e();
        this.f55706c.c("IDAT");
        this.f55706c.c("fdAT");
        if (this.f55706c.g()) {
            a();
        }
        d();
    }

    public void c(long j2) {
        this.f55706c.b(j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f55706c != null) {
                this.f55706c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f55707d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f55706c.g()) {
                a();
            }
            if (this.f55706c.h() != null && !this.f55706c.h().d()) {
                this.f55706c.h().g();
            }
            while (!this.f55706c.b() && this.f55707d.a(this.f55706c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f55706c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.a.toString() + " interlaced=" + this.f55705b;
    }
}
