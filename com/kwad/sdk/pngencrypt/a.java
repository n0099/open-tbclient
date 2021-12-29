package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f59252b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f59253c;

    /* renamed from: d  reason: collision with root package name */
    public int f59254d;

    /* renamed from: e  reason: collision with root package name */
    public int f59255e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59256f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59257g;

    /* renamed from: h  reason: collision with root package name */
    public long f59258h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f59256f = false;
        this.f59257g = true;
        this.f59258h = 0L;
        this.f59252b = inputStream;
        this.f59253c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f59254d) {
            i2 = this.f59254d;
        }
        if (i2 <= 0) {
            if (!this.f59256f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f59253c, this.f59255e, i2);
        if (a2 > 0) {
            this.f59255e += a2;
            int i3 = this.f59254d - a2;
            this.f59254d = i3;
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
        if (this.f59254d > 0 || this.f59256f) {
            return;
        }
        try {
            this.f59255e = 0;
            int read = this.f59252b.read(this.f59253c);
            this.f59254d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f59258h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f59257g = z;
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
        this.f59256f = true;
        this.f59253c = null;
        this.f59254d = 0;
        this.f59255e = 0;
        InputStream inputStream = this.f59252b;
        if (inputStream != null && this.f59257g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f59252b = null;
    }
}
