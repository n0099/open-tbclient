package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public long f36715a;

    /* renamed from: b  reason: collision with root package name */
    public long f36716b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36717c;

    public aj() {
        g();
    }

    private void g() {
        this.f36715a = 0L;
        this.f36716b = -1L;
    }

    public void a() {
        g();
        this.f36717c = true;
        this.f36716b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f36717c && this.f36716b < 0) {
            this.f36716b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.f36717c && this.f36716b > 0) {
            this.f36715a += SystemClock.elapsedRealtime() - this.f36716b;
            this.f36716b = -1L;
        }
    }

    public long d() {
        if (this.f36717c) {
            this.f36717c = false;
            if (this.f36716b > 0) {
                this.f36715a += SystemClock.elapsedRealtime() - this.f36716b;
                this.f36716b = -1L;
            }
            return this.f36715a;
        }
        return 0L;
    }

    public boolean e() {
        return this.f36717c;
    }

    public long f() {
        return this.f36715a;
    }
}
