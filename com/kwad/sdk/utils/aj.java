package com.kwad.sdk.utils;

import android.os.SystemClock;
/* loaded from: classes6.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public long f37100a;

    /* renamed from: b  reason: collision with root package name */
    public long f37101b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37102c;

    public aj() {
        g();
    }

    private void g() {
        this.f37100a = 0L;
        this.f37101b = -1L;
    }

    public void a() {
        g();
        this.f37102c = true;
        this.f37101b = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f37102c && this.f37101b < 0) {
            this.f37101b = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        if (this.f37102c && this.f37101b > 0) {
            this.f37100a += SystemClock.elapsedRealtime() - this.f37101b;
            this.f37101b = -1L;
        }
    }

    public long d() {
        if (this.f37102c) {
            this.f37102c = false;
            if (this.f37101b > 0) {
                this.f37100a += SystemClock.elapsedRealtime() - this.f37101b;
                this.f37101b = -1L;
            }
            return this.f37100a;
        }
        return 0L;
    }

    public boolean e() {
        return this.f37102c;
    }

    public long f() {
        return this.f37100a;
    }
}
