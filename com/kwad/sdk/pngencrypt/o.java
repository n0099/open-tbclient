package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f33542a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f33543b;

    /* renamed from: c  reason: collision with root package name */
    public final c f33544c;

    /* renamed from: d  reason: collision with root package name */
    public final a f33545d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f33546e;

    /* renamed from: f  reason: collision with root package name */
    public int f33547f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f33548g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f33549h;

    public o(InputStream inputStream, boolean z) {
        this.f33547f = -1;
        a aVar = new a(inputStream);
        this.f33545d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f33544c = f2;
        try {
            if (this.f33545d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f33542a = this.f33544c.j();
            this.f33543b = this.f33544c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f33544c.c("fdAT");
            this.f33544c.c("fcTL");
            this.f33546e = new ah(this.f33544c.f33442i);
            a(m.a());
            this.f33547f = -1;
        } catch (RuntimeException e2) {
            this.f33545d.close();
            this.f33544c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f33544c;
            if (cVar.f33441h >= 4) {
                return;
            }
            if (this.f33545d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f33544c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f33549h = iVar;
    }

    public ah b() {
        if (this.f33544c.g()) {
            a();
        }
        return this.f33546e;
    }

    public void b(long j) {
        this.f33544c.c(j);
    }

    public void c() {
        e();
        this.f33544c.c("IDAT");
        this.f33544c.c("fdAT");
        if (this.f33544c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f33544c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f33544c != null) {
                this.f33544c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f33545d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f33544c.g()) {
                a();
            }
            if (this.f33544c.h() != null && !this.f33544c.h().d()) {
                this.f33544c.h().g();
            }
            while (!this.f33544c.b() && this.f33545d.a(this.f33544c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f33544c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f33542a.toString() + " interlaced=" + this.f33543b;
    }
}
