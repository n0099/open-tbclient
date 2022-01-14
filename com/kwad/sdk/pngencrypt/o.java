package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class o implements Closeable {
    public final k a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57143b;

    /* renamed from: c  reason: collision with root package name */
    public final c f57144c;

    /* renamed from: d  reason: collision with root package name */
    public final a f57145d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f57146e;

    /* renamed from: f  reason: collision with root package name */
    public int f57147f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f57148g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f57149h;

    public o(InputStream inputStream, boolean z) {
        this.f57147f = -1;
        a aVar = new a(inputStream);
        this.f57145d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f57144c = f2;
        try {
            if (this.f57145d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.f57144c.j();
            this.f57143b = this.f57144c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f57144c.c("fdAT");
            this.f57144c.c("fcTL");
            this.f57146e = new ah(this.f57144c.f57042i);
            a(m.a());
            this.f57147f = -1;
        } catch (RuntimeException e2) {
            this.f57145d.close();
            this.f57144c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f57144c;
            if (cVar.f57041h >= 4) {
                return;
            }
            if (this.f57145d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j2) {
        this.f57144c.a(j2);
    }

    public void a(i<? extends Object> iVar) {
        this.f57149h = iVar;
    }

    public ah b() {
        if (this.f57144c.g()) {
            a();
        }
        return this.f57146e;
    }

    public void b(long j2) {
        this.f57144c.c(j2);
    }

    public void c() {
        e();
        this.f57144c.c("IDAT");
        this.f57144c.c("fdAT");
        if (this.f57144c.g()) {
            a();
        }
        d();
    }

    public void c(long j2) {
        this.f57144c.b(j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f57144c != null) {
                this.f57144c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f57145d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f57144c.g()) {
                a();
            }
            if (this.f57144c.h() != null && !this.f57144c.h().d()) {
                this.f57144c.h().g();
            }
            while (!this.f57144c.b() && this.f57145d.a(this.f57144c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f57144c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.a.toString() + " interlaced=" + this.f57143b;
    }
}
