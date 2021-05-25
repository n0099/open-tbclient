package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f33471a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f33472b;

    /* renamed from: c  reason: collision with root package name */
    public final c f33473c;

    /* renamed from: d  reason: collision with root package name */
    public final a f33474d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f33475e;

    /* renamed from: f  reason: collision with root package name */
    public int f33476f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f33477g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f33478h;

    public o(InputStream inputStream, boolean z) {
        this.f33476f = -1;
        a aVar = new a(inputStream);
        this.f33474d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f33473c = f2;
        try {
            if (this.f33474d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f33471a = this.f33473c.j();
            this.f33472b = this.f33473c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f33473c.c("fdAT");
            this.f33473c.c("fcTL");
            this.f33475e = new ah(this.f33473c.f33371i);
            a(m.a());
            this.f33476f = -1;
        } catch (RuntimeException e2) {
            this.f33474d.close();
            this.f33473c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f33473c;
            if (cVar.f33370h >= 4) {
                return;
            }
            if (this.f33474d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f33473c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f33478h = iVar;
    }

    public ah b() {
        if (this.f33473c.g()) {
            a();
        }
        return this.f33475e;
    }

    public void b(long j) {
        this.f33473c.c(j);
    }

    public void c() {
        e();
        this.f33473c.c("IDAT");
        this.f33473c.c("fdAT");
        if (this.f33473c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f33473c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f33473c != null) {
                this.f33473c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.e("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f33474d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f33473c.g()) {
                a();
            }
            if (this.f33473c.h() != null && !this.f33473c.h().d()) {
                this.f33473c.h().g();
            }
            while (!this.f33473c.b() && this.f33474d.a(this.f33473c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f33473c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f33471a.toString() + " interlaced=" + this.f33472b;
    }
}
