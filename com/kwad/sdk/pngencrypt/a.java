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
        this.c = new byte[16384];
    }

    private void a() {
        if (this.d > 0 || this.f) {
            return;
        }
        try {
            this.e = 0;
            int read = this.b.read(this.c);
            this.d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.b.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.h += read;
            }
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.a(new PngjException(e));
        }
    }

    private int b(f fVar, int i) {
        a();
        if (i <= 0 || i >= this.d) {
            i = this.d;
        }
        if (i <= 0) {
            if (!this.f) {
                com.kwad.sdk.core.d.b.a(new PngjException("This should not happen"));
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
            com.kwad.sdk.core.d.b.a(new PngjException("This should not happen!"));
        }
        return -1;
    }

    public final int a(f fVar) {
        return b(fVar, Integer.MAX_VALUE);
    }

    public final int a(f fVar, int i) {
        int i2 = 36;
        while (i2 > 0) {
            int b = b(fVar, i2);
            if (b <= 0) {
                return b;
            }
            i2 -= b;
        }
        if (a || i2 == 0) {
            return 36;
        }
        throw new AssertionError();
    }

    public final void a(boolean z) {
        this.g = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f = true;
        this.c = null;
        this.d = 0;
        this.e = 0;
        InputStream inputStream = this.b;
        if (inputStream != null && this.g) {
            com.kwad.sdk.crash.utils.b.a(inputStream);
        }
        this.b = null;
    }
}
