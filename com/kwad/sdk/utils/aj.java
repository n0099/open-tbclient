package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public long f37005a;

    /* renamed from: b  reason: collision with root package name */
    public long f37006b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37007c;

    public aj() {
        g();
    }

    private void g() {
        this.f37005a = 0L;
        this.f37006b = -1L;
    }

    public void a() {
        g();
        this.f37007c = true;
        this.f37006b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f37007c && this.f37006b < 0) {
            this.f37006b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.f37007c && this.f37006b > 0) {
            this.f37005a += SystemClock.elapsedRealtime() - this.f37006b;
            this.f37006b = -1L;
        }
    }

    public long d() {
        if (this.f37007c) {
            this.f37007c = false;
            if (this.f37006b > 0) {
                this.f37005a += SystemClock.elapsedRealtime() - this.f37006b;
                this.f37006b = -1L;
            }
            return this.f37005a;
        }
        return 0L;
    }

    public boolean e() {
        return this.f37007c;
    }

    public long f() {
        return this.f37005a;
    }
}
