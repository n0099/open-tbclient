package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f55582b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f55583c;

    /* renamed from: d  reason: collision with root package name */
    public int f55584d;

    /* renamed from: e  reason: collision with root package name */
    public int f55585e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55586f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55587g;

    /* renamed from: h  reason: collision with root package name */
    public long f55588h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f55586f = false;
        this.f55587g = true;
        this.f55588h = 0L;
        this.f55582b = inputStream;
        this.f55583c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f55584d) {
            i2 = this.f55584d;
        }
        if (i2 <= 0) {
            if (!this.f55586f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f55583c, this.f55585e, i2);
        if (a2 > 0) {
            this.f55585e += a2;
            int i3 = this.f55584d - a2;
            this.f55584d = i3;
            if (!a && i3 < 0) {
                throw new AssertionError();
            }
        }
        if (a2 > 0) {
            return a2;
        }
        if (!fVar.b()) {
            com.kwad.sdk.core.d.a.a(new PngjException("This should not happen!"));
        }
        return -1;
    }

    public void a() {
        if (this.f55584d > 0 || this.f55586f) {
            return;
        }
        try {
            this.f55585e = 0;
            int read = this.f55582b.read(this.f55583c);
            this.f55584d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f55588h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f55587g = z;
    }

    public int b(f fVar, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            int a2 = a(fVar, i3);
            if (a2 <= 0) {
                return a2;
            }
            i3 -= a2;
        }
        if (a || i3 == 0) {
            return i2;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f55586f = true;
        this.f55583c = null;
        this.f55584d = 0;
        this.f55585e = 0;
        InputStream inputStream = this.f55582b;
        if (inputStream != null && this.f55587g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f55582b = null;
    }
}
