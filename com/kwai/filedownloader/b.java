package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f36853a;

    /* renamed from: b  reason: collision with root package name */
    public long f36854b;

    /* renamed from: c  reason: collision with root package name */
    public long f36855c;

    /* renamed from: d  reason: collision with root package name */
    public long f36856d;

    /* renamed from: e  reason: collision with root package name */
    public int f36857e;

    /* renamed from: f  reason: collision with root package name */
    public int f36858f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f36857e = 0;
        this.f36853a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f36856d = SystemClock.uptimeMillis();
        this.f36855c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f36857e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f36856d <= 0) {
            return;
        }
        long j2 = j - this.f36855c;
        this.f36853a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f36856d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f36857e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f36858f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f36853a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f36853a;
            if (uptimeMillis >= this.f36858f || (this.f36857e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.f36854b) / uptimeMillis);
                this.f36857e = i;
                this.f36857e = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f36854b = j;
            this.f36853a = SystemClock.uptimeMillis();
        }
    }
}
