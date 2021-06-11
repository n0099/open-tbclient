package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f36808a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f36809b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f36810c;

    /* renamed from: d  reason: collision with root package name */
    public int f36811d;

    /* renamed from: e  reason: collision with root package name */
    public int f36812e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36813f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36814g;

    /* renamed from: h  reason: collision with root package name */
    public long f36815h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f36813f = false;
        this.f36814g = true;
        this.f36815h = 0L;
        this.f36809b = inputStream;
        this.f36810c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f36811d) {
            i2 = this.f36811d;
        }
        if (i2 <= 0) {
            if (!this.f36813f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f36810c, this.f36812e, i2);
        if (a2 > 0) {
            this.f36812e += a2;
            int i3 = this.f36811d - a2;
            this.f36811d = i3;
            if (!f36808a && i3 < 0) {
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
        if (this.f36811d > 0 || this.f36813f) {
            return;
        }
        try {
            this.f36812e = 0;
            int read = this.f36809b.read(this.f36810c);
            this.f36811d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f36815h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f36814g = z;
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
        if (f36808a || i3 == 0) {
            return i2;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f36813f = true;
        this.f36810c = null;
        this.f36811d = 0;
        this.f36812e = 0;
        InputStream inputStream = this.f36809b;
        if (inputStream != null && this.f36814g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f36809b = null;
    }
}
