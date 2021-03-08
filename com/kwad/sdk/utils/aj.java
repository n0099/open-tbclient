package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes3.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private long f7116a;
    private long b;
    private boolean c;

    public aj() {
        g();
    }

    private void g() {
        this.f7116a = 0L;
        this.b = -1L;
    }

    public void a() {
        g();
        this.c = true;
        this.b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.c && this.b < 0) {
            this.b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.c && this.b > 0) {
            this.f7116a += SystemClock.elapsedRealtime() - this.b;
            this.b = -1L;
        }
    }

    public long d() {
        if (this.c) {
            this.c = false;
            if (this.b > 0) {
                this.f7116a += SystemClock.elapsedRealtime() - this.b;
                this.b = -1L;
            }
            return this.f7116a;
        }
        return 0L;
    }

    public boolean e() {
        return this.c;
    }

    public long f() {
        return this.f7116a;
    }
}
