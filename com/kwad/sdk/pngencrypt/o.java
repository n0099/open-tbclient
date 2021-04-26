package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f34297a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f34298b;

    /* renamed from: c  reason: collision with root package name */
    public final c f34299c;

    /* renamed from: d  reason: collision with root package name */
    public final a f34300d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f34301e;

    /* renamed from: f  reason: collision with root package name */
    public int f34302f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f34303g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f34304h;

    public o(InputStream inputStream, boolean z) {
        this.f34302f = -1;
        a aVar = new a(inputStream);
        this.f34300d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f34299c = f2;
        try {
            if (this.f34300d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f34297a = this.f34299c.j();
            this.f34298b = this.f34299c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f34299c.c("fdAT");
            this.f34299c.c("fcTL");
            this.f34301e = new ah(this.f34299c.f34197i);
            a(m.a());
            this.f34302f = -1;
        } catch (RuntimeException e2) {
            this.f34300d.close();
            this.f34299c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f34299c;
            if (cVar.f34196h >= 4) {
                return;
            }
            if (this.f34300d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f34299c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f34304h = iVar;
    }

    public ah b() {
        if (this.f34299c.g()) {
            a();
        }
        return this.f34301e;
    }

    public void b(long j) {
        this.f34299c.c(j);
    }

    public void c() {
        e();
        this.f34299c.c("IDAT");
        this.f34299c.c("fdAT");
        if (this.f34299c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f34299c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f34299c != null) {
                this.f34299c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f34300d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f34299c.g()) {
                a();
            }
            if (this.f34299c.h() != null && !this.f34299c.h().d()) {
                this.f34299c.h().g();
            }
            while (!this.f34299c.b() && this.f34300d.a(this.f34299c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f34299c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f34297a.toString() + " interlaced=" + this.f34298b;
    }
}
