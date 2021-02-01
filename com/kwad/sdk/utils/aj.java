package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes3.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private long f10778a;

    /* renamed from: b  reason: collision with root package name */
    private long f10779b;
    private boolean c;

    public aj() {
        g();
    }

    private void g() {
        this.f10778a = 0L;
        this.f10779b = -1L;
    }

    public void a() {
        g();
        this.c = true;
        this.f10779b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.c && this.f10779b < 0) {
            this.f10779b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.c && this.f10779b > 0) {
            this.f10778a += SystemClock.elapsedRealtime() - this.f10779b;
            this.f10779b = -1L;
        }
    }

    public long d() {
        if (this.c) {
            this.c = false;
            if (this.f10779b > 0) {
                this.f10778a += SystemClock.elapsedRealtime() - this.f10779b;
                this.f10779b = -1L;
            }
            return this.f10778a;
        }
        return 0L;
    }

    public boolean e() {
        return this.c;
    }

    public long f() {
        return this.f10778a;
    }
}
