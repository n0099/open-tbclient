package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes5.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private long f11076a;

    /* renamed from: b  reason: collision with root package name */
    private long f11077b;
    private boolean c;

    public aj() {
        g();
    }

    private void g() {
        this.f11076a = 0L;
        this.f11077b = -1L;
    }

    public void a() {
        g();
        this.c = true;
        this.f11077b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.c && this.f11077b < 0) {
            this.f11077b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.c && this.f11077b > 0) {
            this.f11076a += SystemClock.elapsedRealtime() - this.f11077b;
            this.f11077b = -1L;
        }
    }

    public long d() {
        if (this.c) {
            this.c = false;
            if (this.f11077b > 0) {
                this.f11076a += SystemClock.elapsedRealtime() - this.f11077b;
                this.f11077b = -1L;
            }
            return this.f11076a;
        }
        return 0L;
    }

    public boolean e() {
        return this.c;
    }

    public long f() {
        return this.f11076a;
    }
}
