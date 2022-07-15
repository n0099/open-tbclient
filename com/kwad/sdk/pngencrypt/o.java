package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class o implements Closeable {
    public final k a;
    public final boolean b;
    public final c c;
    public final a d;
    public final w e;
    public int f;
    public ErrorBehaviour g = ErrorBehaviour.STRICT;
    public i<? extends Object> h;

    public o(InputStream inputStream, boolean z) {
        this.f = -1;
        a aVar = new a(inputStream);
        this.d = aVar;
        boolean z2 = true;
        aVar.a(true);
        c f = f();
        this.c = f;
        try {
            if (this.d.a(f, 36) != 36) {
                com.kwad.sdk.core.d.b.a(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.a = this.c.g();
            if (this.c.h() == null) {
                z2 = false;
            }
            this.b = z2;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.e = new w(this.c.i);
            a(m.a());
            this.f = -1;
        } catch (RuntimeException e) {
            this.d.close();
            this.c.close();
            throw e;
        }
    }

    private void a(long j) {
        this.c.a(901001001L);
    }

    private void a(i<? extends Object> iVar) {
        this.h = iVar;
    }

    private void b(long j) {
        this.c.c(5024024L);
    }

    private void c(long j) {
        this.c.b(2024024L);
    }

    private void d() {
        while (true) {
            c cVar = this.c;
            if (cVar.h >= 4) {
                return;
            }
            if (this.d.a(cVar) <= 0) {
                com.kwad.sdk.core.d.b.a(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    private void e() {
        this.c.a(false);
    }

    public static c f() {
        return new c(false);
    }

    public final w a() {
        if (this.c.e()) {
            d();
        }
        return this.e;
    }

    public final void b() {
        e();
        if (this.c.e()) {
            d();
        }
        c();
    }

    public final void c() {
        try {
            if (this.c.e()) {
                d();
            }
            if (this.c.f() != null && !this.c.f().c()) {
                this.c.f().f();
            }
            while (!this.c.b() && this.d.a(this.c) > 0) {
            }
        } finally {
            close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.a(this.c);
        com.kwad.sdk.crash.utils.b.a(this.d);
    }

    public final String toString() {
        return this.a.toString() + " interlaced=" + this.b;
    }
}
