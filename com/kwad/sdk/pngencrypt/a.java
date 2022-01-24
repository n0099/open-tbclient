package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class a implements Closeable {
    public static final /* synthetic */ boolean a = !a.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public InputStream f57065b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f57066c;

    /* renamed from: d  reason: collision with root package name */
    public int f57067d;

    /* renamed from: e  reason: collision with root package name */
    public int f57068e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57069f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57070g;

    /* renamed from: h  reason: collision with root package name */
    public long f57071h;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i2) {
        this.f57069f = false;
        this.f57070g = true;
        this.f57071h = 0L;
        this.f57065b = inputStream;
        this.f57066c = new byte[i2 < 1 ? 16384 : i2];
    }

    public int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public int a(f fVar, int i2) {
        a();
        if (i2 <= 0 || i2 >= this.f57067d) {
            i2 = this.f57067d;
        }
        if (i2 <= 0) {
            if (!this.f57069f) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen"));
            }
            return fVar.b() ? -1 : 0;
        }
        int a2 = fVar.a(this.f57066c, this.f57068e, i2);
        if (a2 > 0) {
            this.f57068e += a2;
            int i3 = this.f57067d - a2;
            this.f57067d = i3;
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
        if (this.f57067d > 0 || this.f57069f) {
            return;
        }
        try {
            this.f57068e = 0;
            int read = this.f57065b.read(this.f57066c);
            this.f57067d = read;
            if (read == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (read < 0) {
                close();
            } else {
                this.f57071h += read;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(new PngjException(e2));
        }
    }

    public void a(boolean z) {
        this.f57070g = z;
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
        this.f57069f = true;
        this.f57066c = null;
        this.f57067d = 0;
        this.f57068e = 0;
        InputStream inputStream = this.f57065b;
        if (inputStream != null && this.f57070g) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f57065b = null;
    }
}
