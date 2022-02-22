package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class o implements Closeable {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57355b;

    /* renamed from: c  reason: collision with root package name */
    public final c f57356c;

    /* renamed from: d  reason: collision with root package name */
    public final a f57357d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f57358e;

    /* renamed from: f  reason: collision with root package name */
    public int f57359f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f57360g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f57361h;

    public o(InputStream inputStream, boolean z) {
        this.f57359f = -1;
        a aVar = new a(inputStream);
        this.f57357d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f57356c = f2;
        try {
            if (this.f57357d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f57356c.j();
            this.f57355b = this.f57356c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f57356c.c("fdAT");
            this.f57356c.c("fcTL");
            this.f57358e = new ah(this.f57356c.f57254i);
            a(m.a());
            this.f57359f = -1;
        } catch (RuntimeException e2) {
            this.f57357d.close();
            this.f57356c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f57356c;
            if (cVar.f57253h >= 4) {
                return;
            }
            if (this.f57357d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j2) {
        this.f57356c.a(j2);
    }

    public void a(i<? extends Object> iVar) {
        this.f57361h = iVar;
    }

    public ah b() {
        if (this.f57356c.g()) {
            a();
        }
        return this.f57358e;
    }

    public void b(long j2) {
        this.f57356c.c(j2);
    }

    public void c() {
        e();
        this.f57356c.c("IDAT");
        this.f57356c.c("fdAT");
        if (this.f57356c.g()) {
            a();
        }
        d();
    }

    public void c(long j2) {
        this.f57356c.b(j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f57356c != null) {
                this.f57356c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f57357d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f57356c.g()) {
                a();
            }
            if (this.f57356c.h() != null && !this.f57356c.h().d()) {
                this.f57356c.h().g();
            }
            while (!this.f57356c.b() && this.f57357d.a(this.f57356c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f57356c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.a.toString() + " interlaced=" + this.f57355b;
    }
}
