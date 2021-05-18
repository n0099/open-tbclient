package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f33419a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f33420b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33421c;

    /* renamed from: d  reason: collision with root package name */
    public int f33422d;

    /* renamed from: e  reason: collision with root package name */
    public int f33423e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33424f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33425g;

    /* renamed from: h  reason: collision with root package name */
    public long f33426h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f33424f = false;
        this.f33425g = true;
        this.f33426h = 0L;
        this.f33420b = inputStream;
        this.f33421c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f33422d) {
            i2 = this.f33422d;
        }
        if (i2 <= 0) {
            if (!this.f33424f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f33421c, this.f33423e, i2);
        if (a2 > 0) {
            this.f33423e += a2;
            int i3 = this.f33422d - a2;
            this.f33422d = i3;
            if (!f33419a && i3 < 0) {
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
        if (this.f33422d > 0 || this.f33424f) {
            return;
        }
        try {
            this.f33423e = 0;
            int read = this.f33420b.read(this.f33421c);
            this.f33422d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f33426h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f33425g = z;
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
        if (f33419a || i3 == 0) {
            return i2;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f33424f = true;
        this.f33421c = null;
        this.f33422d = 0;
        this.f33423e = 0;
        InputStream inputStream = this.f33420b;
        if (inputStream != null && this.f33425g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f33420b = null;
    }
}
