package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f36931a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36932b;

    /* renamed from: c  reason: collision with root package name */
    public final c f36933c;

    /* renamed from: d  reason: collision with root package name */
    public final a f36934d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f36935e;

    /* renamed from: f  reason: collision with root package name */
    public int f36936f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f36937g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f36938h;

    public o(InputStream inputStream, boolean z) {
        this.f36936f = -1;
        a aVar = new a(inputStream);
        this.f36934d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f36933c = f2;
        try {
            if (this.f36934d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f36931a = this.f36933c.j();
            this.f36932b = this.f36933c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f36933c.c("fdAT");
            this.f36933c.c("fcTL");
            this.f36935e = new ah(this.f36933c.f36831i);
            a(m.a());
            this.f36936f = -1;
        } catch (RuntimeException e2) {
            this.f36934d.close();
            this.f36933c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f36933c;
            if (cVar.f36830h >= 4) {
                return;
            }
            if (this.f36934d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f36933c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f36938h = iVar;
    }

    public ah b() {
        if (this.f36933c.g()) {
            a();
        }
        return this.f36935e;
    }

    public void b(long j) {
        this.f36933c.c(j);
    }

    public void c() {
        e();
        this.f36933c.c("IDAT");
        this.f36933c.c("fdAT");
        if (this.f36933c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f36933c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f36933c != null) {
                this.f36933c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.d("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f36934d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f36933c.g()) {
                a();
            }
            if (this.f36933c.h() != null && !this.f36933c.h().d()) {
                this.f36933c.h().g();
            }
            while (!this.f36933c.b() && this.f36934d.a(this.f36933c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f36933c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f36931a.toString() + " interlaced=" + this.f36932b;
    }
}
