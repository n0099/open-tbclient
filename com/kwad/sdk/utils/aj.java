package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public long f36716a;

    /* renamed from: b  reason: collision with root package name */
    public long f36717b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36718c;

    public aj() {
        g();
    }

    private void g() {
        this.f36716a = 0L;
        this.f36717b = -1L;
    }

    public void a() {
        g();
        this.f36718c = true;
        this.f36717b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f36718c && this.f36717b < 0) {
            this.f36717b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.f36718c && this.f36717b > 0) {
            this.f36716a += SystemClock.elapsedRealtime() - this.f36717b;
            this.f36717b = -1L;
        }
    }

    public long d() {
        if (this.f36718c) {
            this.f36718c = false;
            if (this.f36717b > 0) {
                this.f36716a += SystemClock.elapsedRealtime() - this.f36717b;
                this.f36717b = -1L;
            }
            return this.f36716a;
        }
        return 0L;
    }

    public boolean e() {
        return this.f36718c;
    }

    public long f() {
        return this.f36716a;
    }
}
