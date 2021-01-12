package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes4.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private long f10776a;

    /* renamed from: b  reason: collision with root package name */
    private long f10777b;
    private boolean c;

    public aj() {
        g();
    }

    private void g() {
        this.f10776a = 0L;
        this.f10777b = -1L;
    }

    public void a() {
        g();
        this.c = true;
        this.f10777b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.c && this.f10777b < 0) {
            this.f10777b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.c && this.f10777b > 0) {
            this.f10776a += SystemClock.elapsedRealtime() - this.f10777b;
            this.f10777b = -1L;
        }
    }

    public long d() {
        if (this.c) {
            this.c = false;
            if (this.f10777b > 0) {
                this.f10776a += SystemClock.elapsedRealtime() - this.f10777b;
                this.f10777b = -1L;
            }
            return this.f10776a;
        }
        return 0L;
    }

    public boolean e() {
        return this.c;
    }

    public long f() {
        return this.f10776a;
    }
}
