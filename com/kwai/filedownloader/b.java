package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes7.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f37612a;

    /* renamed from: b  reason: collision with root package name */
    public long f37613b;

    /* renamed from: c  reason: collision with root package name */
    public long f37614c;

    /* renamed from: d  reason: collision with root package name */
    public long f37615d;

    /* renamed from: e  reason: collision with root package name */
    public int f37616e;

    /* renamed from: f  reason: collision with root package name */
    public int f37617f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f37616e = 0;
        this.f37612a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f37615d = SystemClock.uptimeMillis();
        this.f37614c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f37616e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f37615d <= 0) {
            return;
        }
        long j2 = j - this.f37614c;
        this.f37612a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f37615d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f37616e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f37617f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f37612a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f37612a;
            if (uptimeMillis >= this.f37617f || (this.f37616e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f37613b) / uptimeMillis);
                this.f37616e = i2;
                this.f37616e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f37613b = j;
            this.f37612a = SystemClock.uptimeMillis();
        }
    }
}
