package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes7.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f37710a;

    /* renamed from: b  reason: collision with root package name */
    public long f37711b;

    /* renamed from: c  reason: collision with root package name */
    public long f37712c;

    /* renamed from: d  reason: collision with root package name */
    public long f37713d;

    /* renamed from: e  reason: collision with root package name */
    public int f37714e;

    /* renamed from: f  reason: collision with root package name */
    public int f37715f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f37714e = 0;
        this.f37710a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f37713d = SystemClock.uptimeMillis();
        this.f37712c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f37714e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f37713d <= 0) {
            return;
        }
        long j2 = j - this.f37712c;
        this.f37710a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f37713d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f37714e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f37715f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f37710a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f37710a;
            if (uptimeMillis >= this.f37715f || (this.f37714e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f37711b) / uptimeMillis);
                this.f37714e = i2;
                this.f37714e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f37711b = j;
            this.f37710a = SystemClock.uptimeMillis();
        }
    }
}
