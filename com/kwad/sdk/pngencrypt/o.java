package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f37029a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f37030b;

    /* renamed from: c  reason: collision with root package name */
    public final c f37031c;

    /* renamed from: d  reason: collision with root package name */
    public final a f37032d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f37033e;

    /* renamed from: f  reason: collision with root package name */
    public int f37034f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f37035g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f37036h;

    public o(InputStream inputStream, boolean z) {
        this.f37034f = -1;
        a aVar = new a(inputStream);
        this.f37032d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f37031c = f2;
        try {
            if (this.f37032d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f37029a = this.f37031c.j();
            this.f37030b = this.f37031c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f37031c.c("fdAT");
            this.f37031c.c("fcTL");
            this.f37033e = new ah(this.f37031c.f36929i);
            a(m.a());
            this.f37034f = -1;
        } catch (RuntimeException e2) {
            this.f37032d.close();
            this.f37031c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f37031c;
            if (cVar.f36928h >= 4) {
                return;
            }
            if (this.f37032d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f37031c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f37036h = iVar;
    }

    public ah b() {
        if (this.f37031c.g()) {
            a();
        }
        return this.f37033e;
    }

    public void b(long j) {
        this.f37031c.c(j);
    }

    public void c() {
        e();
        this.f37031c.c("IDAT");
        this.f37031c.c("fdAT");
        if (this.f37031c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f37031c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f37031c != null) {
                this.f37031c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.d("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f37032d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f37031c.g()) {
                a();
            }
            if (this.f37031c.h() != null && !this.f37031c.h().d()) {
                this.f37031c.h().g();
            }
            while (!this.f37031c.b() && this.f37032d.a(this.f37031c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f37031c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f37029a.toString() + " interlaced=" + this.f37030b;
    }
}
