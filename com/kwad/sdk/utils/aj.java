package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes7.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public long f37472a;

    /* renamed from: b  reason: collision with root package name */
    public long f37473b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37474c;

    public aj() {
        g();
    }

    private void g() {
        this.f37472a = 0L;
        this.f37473b = -1L;
    }

    public void a() {
        g();
        this.f37474c = true;
        this.f37473b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f37474c && this.f37473b < 0) {
            this.f37473b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.f37474c && this.f37473b > 0) {
            this.f37472a += SystemClock.elapsedRealtime() - this.f37473b;
            this.f37473b = -1L;
        }
    }

    public long d() {
        if (this.f37474c) {
            this.f37474c = false;
            if (this.f37473b > 0) {
                this.f37472a += SystemClock.elapsedRealtime() - this.f37473b;
                this.f37473b = -1L;
            }
            return this.f37472a;
        }
        return 0L;
    }

    public boolean e() {
        return this.f37474c;
    }

    public long f() {
        return this.f37472a;
    }
}
