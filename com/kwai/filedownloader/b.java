package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f34953a;

    /* renamed from: b  reason: collision with root package name */
    public long f34954b;

    /* renamed from: c  reason: collision with root package name */
    public long f34955c;

    /* renamed from: d  reason: collision with root package name */
    public long f34956d;

    /* renamed from: e  reason: collision with root package name */
    public int f34957e;

    /* renamed from: f  reason: collision with root package name */
    public int f34958f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f34957e = 0;
        this.f34953a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f34956d = SystemClock.uptimeMillis();
        this.f34955c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f34957e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f34956d <= 0) {
            return;
        }
        long j2 = j - this.f34955c;
        this.f34953a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f34956d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f34957e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f34958f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f34953a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f34953a;
            if (uptimeMillis >= this.f34958f || (this.f34957e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j - this.f34954b) / uptimeMillis);
                this.f34957e = i2;
                this.f34957e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f34954b = j;
            this.f34953a = SystemClock.uptimeMillis();
        }
    }
}
