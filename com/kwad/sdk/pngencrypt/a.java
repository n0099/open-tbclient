package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f34174a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f34175b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f34176c;

    /* renamed from: d  reason: collision with root package name */
    public int f34177d;

    /* renamed from: e  reason: collision with root package name */
    public int f34178e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34179f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34180g;

    /* renamed from: h  reason: collision with root package name */
    public long f34181h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f34179f = false;
        this.f34180g = true;
        this.f34181h = 0L;
        this.f34175b = inputStream;
        this.f34176c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f34177d) {
            i2 = this.f34177d;
        }
        if (i2 <= 0) {
            if (!this.f34179f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f34176c, this.f34178e, i2);
        if (a2 > 0) {
            this.f34178e += a2;
            int i3 = this.f34177d - a2;
            this.f34177d = i3;
            if (!f34174a && i3 < 0) {
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
        if (this.f34177d > 0 || this.f34179f) {
            return;
        }
        try {
            this.f34178e = 0;
            int read = this.f34175b.read(this.f34176c);
            this.f34177d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f34181h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f34180g = z;
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
        if (f34174a || i3 == 0) {
            return i2;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f34179f = true;
        this.f34176c = null;
        this.f34177d = 0;
        this.f34178e = 0;
        InputStream inputStream = this.f34175b;
        if (inputStream != null && this.f34180g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f34175b = null;
    }
}
