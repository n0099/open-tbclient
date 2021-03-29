package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f36199a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36200b;

    /* renamed from: c  reason: collision with root package name */
    public final c f36201c;

    /* renamed from: d  reason: collision with root package name */
    public final a f36202d;

    /* renamed from: e  reason: collision with root package name */
    public final ah f36203e;

    /* renamed from: f  reason: collision with root package name */
    public int f36204f;

    /* renamed from: g  reason: collision with root package name */
    public ErrorBehaviour f36205g = ErrorBehaviour.STRICT;

    /* renamed from: h  reason: collision with root package name */
    public i<? extends Object> f36206h;

    public o(InputStream inputStream, boolean z) {
        this.f36204f = -1;
        a aVar = new a(inputStream);
        this.f36202d = aVar;
        aVar.a(z);
        c f2 = f();
        this.f36201c = f2;
        try {
            if (this.f36202d.b(f2, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f36199a = this.f36201c.j();
            this.f36200b = this.f36201c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f36201c.c("fdAT");
            this.f36201c.c("fcTL");
            this.f36203e = new ah(this.f36201c.i);
            a(m.a());
            this.f36204f = -1;
        } catch (RuntimeException e2) {
            this.f36202d.close();
            this.f36201c.close();
            throw e2;
        }
    }

    public void a() {
        while (true) {
            c cVar = this.f36201c;
            if (cVar.f36118h >= 4) {
                return;
            }
            if (this.f36202d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.f36201c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.f36206h = iVar;
    }

    public ah b() {
        if (this.f36201c.g()) {
            a();
        }
        return this.f36203e;
    }

    public void b(long j) {
        this.f36201c.c(j);
    }

    public void c() {
        e();
        this.f36201c.c("IDAT");
        this.f36201c.c("fdAT");
        if (this.f36201c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.f36201c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.f36201c != null) {
                this.f36201c.close();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.d("PNG_ENCRYPT", "error closing chunk sequence:" + e2.getMessage());
        }
        a aVar = this.f36202d;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void d() {
        try {
            if (this.f36201c.g()) {
                a();
            }
            if (this.f36201c.h() != null && !this.f36201c.h().d()) {
                this.f36201c.h().g();
            }
            while (!this.f36201c.b() && this.f36202d.a(this.f36201c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.f36201c.a(false);
    }

    public c f() {
        return new c(false);
    }

    public String toString() {
        return this.f36199a.toString() + " interlaced=" + this.f36200b;
    }
}
