package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes7.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public long f37570a;

    /* renamed from: b  reason: collision with root package name */
    public long f37571b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37572c;

    public aj() {
        g();
    }

    private void g() {
        this.f37570a = 0L;
        this.f37571b = -1L;
    }

    public void a() {
        g();
        this.f37572c = true;
        this.f37571b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f37572c && this.f37571b < 0) {
            this.f37571b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.f37572c && this.f37571b > 0) {
            this.f37570a += SystemClock.elapsedRealtime() - this.f37571b;
            this.f37571b = -1L;
        }
    }

    public long d() {
        if (this.f37572c) {
            this.f37572c = false;
            if (this.f37571b > 0) {
                this.f37570a += SystemClock.elapsedRealtime() - this.f37571b;
                this.f37571b = -1L;
            }
            return this.f37570a;
        }
        return 0L;
    }

    public boolean e() {
        return this.f37572c;
    }

    public long f() {
        return this.f37570a;
    }
}
