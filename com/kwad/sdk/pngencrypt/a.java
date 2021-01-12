package com.kwad.sdk.pngencrypt;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f10489a;

    /* renamed from: b  reason: collision with root package name */
    private InputStream f10490b;
    private byte[] c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private long h;

    static {
        f10489a = !a.class.desiredAssertionStatus();
    }

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    public a(InputStream inputStream, int i) {
        this.f = false;
        this.g = true;
        this.h = 0L;
        this.f10490b = inputStream;
        this.c = new byte[i < 1 ? 16384 : i];
    }

    public int a(f fVar) {
        return a(fVar, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
            this.d -= a2;
            if (!f10489a && this.d < 0) {
                throw new AssertionError();
            }
        }
        if (a2 > 0) {
            return a2;
        }
        if (fVar.b()) {
            return -1;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("This should not happen!"));
        return -1;
    }

    protected void a() {
        if (this.d > 0 || this.f) {
            return;
        }
        try {
            this.e = 0;
            this.d = this.f10490b.read(this.c);
            if (this.d == 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (this.d < 0) {
                close();
            } else {
                this.h += this.d;
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
        if (f10489a || i2 == 0) {
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
        if (this.f10490b != null && this.g) {
            try {
                this.f10490b.close();
            } catch (Exception e) {
            }
        }
        this.f10490b = null;
    }
}
