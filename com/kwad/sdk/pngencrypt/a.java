package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f33348a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f33349b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33350c;

    /* renamed from: d  reason: collision with root package name */
    public int f33351d;

    /* renamed from: e  reason: collision with root package name */
    public int f33352e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33353f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33354g;

    /* renamed from: h  reason: collision with root package name */
    public long f33355h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f33353f = false;
        this.f33354g = true;
        this.f33355h = 0L;
        this.f33349b = inputStream;
        this.f33350c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f33351d) {
            i2 = this.f33351d;
        }
        if (i2 <= 0) {
            if (!this.f33353f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f33350c, this.f33352e, i2);
        if (a2 > 0) {
            this.f33352e += a2;
            int i3 = this.f33351d - a2;
            this.f33351d = i3;
            if (!f33348a && i3 < 0) {
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
        if (this.f33351d > 0 || this.f33353f) {
            return;
        }
        try {
            this.f33352e = 0;
            int read = this.f33349b.read(this.f33350c);
            this.f33351d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f33355h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f33354g = z;
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
        if (f33348a || i3 == 0) {
            return i2;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f33353f = true;
        this.f33350c = null;
        this.f33351d = 0;
        this.f33352e = 0;
        InputStream inputStream = this.f33349b;
        if (inputStream != null && this.f33354g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f33349b = null;
    }
}
