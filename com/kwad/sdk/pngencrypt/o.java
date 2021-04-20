package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f36488a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36489b;

    /* renamed from: c  reason: collision with root package name */
    public final c f36490c;

    /* renamed from: d  reason: collision with root package name */
    public final a f36491d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f36492e;

    /* renamed from: f  reason: collision with root package name */
    public int f36493f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f36494g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f36495h;

    public o(InputStream inputStream, boolean z) {
        this.f36493f = -1;
        a aVar = new a(inputStream);
        this.f36491d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f36490c = f2;
        try {
            if (this.f36491d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f36488a = this.f36490c.j();
            this.f36489b = this.f36490c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f36490c.c("fdAT");
            this.f36490c.c("fcTL");
            this.f36492e = new ah(this.f36490c.i);
            a(m.a());
            this.f36493f = -1;
        } catch (RuntimeException e2) {
            this.f36491d.close();
            this.f36490c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f36490c;
            if (cVar.f36407h >= 4) {
                return;
            }
            if (this.f36491d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f36490c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f36495h = iVar;
    }

    public ah b() {
        if (this.f36490c.g()) {
            a();
        }
        return this.f36492e;
    }

    public void b(long j) {
        this.f36490c.c(j);
    }

    public void c() {
        e();
        this.f36490c.c("IDAT");
        this.f36490c.c("fdAT");
        if (this.f36490c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f36490c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f36490c != null) {
                this.f36490c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.d("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f36491d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f36490c.g()) {
                a();
            }
            if (this.f36490c.h() != null && !this.f36490c.h().d()) {
                this.f36490c.h().g();
            }
            while (!this.f36490c.b() && this.f36491d.a(this.f36490c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f36490c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f36488a.toString() + " interlaced=" + this.f36489b;
    }
}
