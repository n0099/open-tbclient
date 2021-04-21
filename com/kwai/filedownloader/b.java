package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f37238a;

    /* renamed from: b  reason: collision with root package name */
    public long f37239b;

    /* renamed from: c  reason: collision with root package name */
    public long f37240c;

    /* renamed from: d  reason: collision with root package name */
    public long f37241d;

    /* renamed from: e  reason: collision with root package name */
    public int f37242e;

    /* renamed from: f  reason: collision with root package name */
    public int f37243f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f37242e = 0;
        this.f37238a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f37241d = SystemClock.uptimeMillis();
        this.f37240c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f37242e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f37241d <= 0) {
            return;
        }
        long j2 = j - this.f37240c;
        this.f37238a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f37241d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f37242e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f37243f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f37238a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f37238a;
            if (uptimeMillis >= this.f37243f || (this.f37242e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.f37239b) / uptimeMillis);
                this.f37242e = i;
                this.f37242e = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f37239b = j;
            this.f37238a = SystemClock.uptimeMillis();
        }
    }
}
