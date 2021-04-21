package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f36481a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f36482b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f36483c;

    /* renamed from: d  reason: collision with root package name */
    public int f36484d;

    /* renamed from: e  reason: collision with root package name */
    public int f36485e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36486f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36487g;

    /* renamed from: h  reason: collision with root package name */
    public long f36488h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i) {
        this.f36486f = false;
        this.f36487g = true;
        this.f36488h = 0L;
        this.f36482b = inputStream;
        this.f36483c = new byte[i < 1 ? 16384 : i];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i) {
        a();
        if (i <= 0 || i >= this.f36484d) {
            i = this.f36484d;
        }
        if (i <= 0) {
            if (!this.f36486f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f36483c, this.f36485e, i);
        if (a2 > 0) {
            this.f36485e += a2;
            int i2 = this.f36484d - a2;
            this.f36484d = i2;
            if (!f36481a && i2 < 0) {
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
        if (this.f36484d > 0 || this.f36486f) {
            return;
        }
        try {
            this.f36485e = 0;
            int read = this.f36482b.read(this.f36483c);
            this.f36484d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f36488h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f36487g = z;
    }

    public int b(f fVar, int i) {
        int i2 = i;
        while (i2 > 0) {
            int a2 = a(fVar, i2);
            if (a2 <= 0) {
                return a2;
            }
            i2 -= a2;
        }
        if (f36481a || i2 == 0) {
            return i;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f36486f = true;
        this.f36483c = null;
        this.f36484d = 0;
        this.f36485e = 0;
        InputStream inputStream = this.f36482b;
        if (inputStream != null && this.f36487g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f36482b = null;
    }
}
