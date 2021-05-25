package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f34127a;

    /* renamed from: b  reason: collision with root package name */
    public long f34128b;

    /* renamed from: c  reason: collision with root package name */
    public long f34129c;

    /* renamed from: d  reason: collision with root package name */
    public long f34130d;

    /* renamed from: e  reason: collision with root package name */
    public int f34131e;

    /* renamed from: f  reason: collision with root package name */
    public int f34132f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f34131e = 0;
        this.f34127a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f34130d = SystemClock.uptimeMillis();
        this.f34129c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f34131e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f34130d <= 0) {
            return;
        }
        long j2 = j - this.f34129c;
        this.f34127a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f34130d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f34131e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f34132f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f34127a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f34127a;
            if (uptimeMillis >= this.f34132f || (this.f34131e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f34128b) / uptimeMillis);
                this.f34131e = i2;
                this.f34131e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f34128b = j;
            this.f34127a = SystemClock.uptimeMillis();
        }
    }
}
