package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ah;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class o implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final k f10818a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10819b;
    protected final c c;
    protected final a d;
    protected final ah e;
    protected int f;
    protected ErrorBehaviour g = ErrorBehaviour.STRICT;
    private i<? extends Object> h;

    public o(InputStream inputStream, boolean z) {
        this.f = -1;
        this.d = new a(inputStream);
        this.d.a(z);
        this.c = f();
        try {
            if (this.d.b(this.c, 36) != 36) {
                com.kwad.sdk.core.d.a.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.f10818a = this.c.j();
            this.f10819b = this.c.k() != null;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.c.c("fdAT");
            this.c.c("fcTL");
            this.e = new ah(this.c.i);
            a(m.a());
            this.f = -1;
        } catch (RuntimeException e) {
            this.d.close();
            this.c.close();
            throw e;
        }
    }

    protected void a() {
        while (this.c.h < 4) {
            if (this.d.a(this.c) <= 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    public void a(long j) {
        this.c.a(j);
    }

    public void a(i<? extends Object> iVar) {
        this.h = iVar;
    }

    public ah b() {
        if (this.c.g()) {
            a();
        }
        return this.e;
    }

    public void b(long j) {
        this.c.c(j);
    }

    public void c() {
        e();
        this.c.c("IDAT");
        this.c.c("fdAT");
        if (this.c.g()) {
            a();
        }
        d();
    }

    public void c(long j) {
        this.c.b(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.c != null) {
                this.c.close();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.d("PNG_ENCRYPT", "error closing chunk sequence:" + e.getMessage());
        }
        if (this.d != null) {
            this.d.close();
        }
    }

    public void d() {
        try {
            if (this.c.g()) {
                a();
            }
            if (this.c.h() != null && !this.c.h().d()) {
                this.c.h().g();
            }
            while (!this.c.b() && this.d.a(this.c) > 0) {
            }
        } finally {
            close();
        }
    }

    public void e() {
        this.c.a(false);
    }

    protected c f() {
        return new c(false);
    }

    public String toString() {
        return this.f10818a.toString() + " interlaced=" + this.f10819b;
    }
}
