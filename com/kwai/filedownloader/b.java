package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f34198a;

    /* renamed from: b  reason: collision with root package name */
    public long f34199b;

    /* renamed from: c  reason: collision with root package name */
    public long f34200c;

    /* renamed from: d  reason: collision with root package name */
    public long f34201d;

    /* renamed from: e  reason: collision with root package name */
    public int f34202e;

    /* renamed from: f  reason: collision with root package name */
    public int f34203f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f34202e = 0;
        this.f34198a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f34201d = SystemClock.uptimeMillis();
        this.f34200c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f34202e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f34201d <= 0) {
            return;
        }
        long j2 = j - this.f34200c;
        this.f34198a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f34201d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f34202e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f34203f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f34198a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f34198a;
            if (uptimeMillis >= this.f34203f || (this.f34202e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f34199b) / uptimeMillis);
                this.f34202e = i2;
                this.f34202e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f34199b = j;
            this.f34198a = SystemClock.uptimeMillis();
        }
    }
}
