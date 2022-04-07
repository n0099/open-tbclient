package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean a = !a.class.desiredAssertionStatus();
    public InputStream b;
    public byte[] c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public long h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i) {
        this.f = false;
        this.g = true;
        this.h = 0L;
        this.b = inputStream;
        this.c = new byte[i < 1 ? 16384 : i];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i) {
        a();
        if (i <= 0 || i >= this.d) {
            i = this.d;
        }
        if (i <= 0) {
            if (!this.f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.c, this.e, i);
        if (a2 > 0) {
            this.e += a2;
            int i2 = this.d - a2;
            this.d = i2;
            if (!a && i2 < 0) {
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
        if (this.d > 0 || this.f) {
            return;
        }
        try {
            this.e = 0;
            int read = this.b.read(this.c);
            this.d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.h += read;
            }
        } catch (IOException e) {
            com.kwad.sdk.core.d.a.a(new PngjException(e));
        }
    }

    public void a(boolean z) {
        this.g = z;
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
        if (a || i2 == 0) {
            return i;
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f = true;
        this.c = null;
        this.d = 0;
        this.e = 0;
        InputStream inputStream = this.b;
        if (inputStream != null && this.g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.b = null;
    }
}
