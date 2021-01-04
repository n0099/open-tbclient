package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private long f11075a;

    /* renamed from: b  reason: collision with root package name */
    private long f11076b;
    private boolean c;

    public aj() {
        g();
    }

    private void g() {
        this.f11075a = 0L;
        this.f11076b = -1L;
    }

    public void a() {
        g();
        this.c = true;
        this.f11076b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.c && this.f11076b < 0) {
            this.f11076b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.c && this.f11076b > 0) {
            this.f11075a += SystemClock.elapsedRealtime() - this.f11076b;
            this.f11076b = -1L;
        }
    }

    public long d() {
        if (this.c) {
            this.c = false;
            if (this.f11076b > 0) {
                this.f11075a += SystemClock.elapsedRealtime() - this.f11076b;
                this.f11076b = -1L;
            }
            return this.f11075a;
        }
        return 0L;
    }

    public boolean e() {
        return this.c;
    }

    public long f() {
        return this.f11075a;
    }
}
