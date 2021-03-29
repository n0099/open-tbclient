package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f36854a;

    /* renamed from: b  reason: collision with root package name */
    public long f36855b;

    /* renamed from: c  reason: collision with root package name */
    public long f36856c;

    /* renamed from: d  reason: collision with root package name */
    public long f36857d;

    /* renamed from: e  reason: collision with root package name */
    public int f36858e;

    /* renamed from: f  reason: collision with root package name */
    public int f36859f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f36858e = 0;
        this.f36854a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f36857d = SystemClock.uptimeMillis();
        this.f36856c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f36858e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f36857d <= 0) {
            return;
        }
        long j2 = j - this.f36856c;
        this.f36854a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f36857d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f36858e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f36859f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f36854a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f36854a;
            if (uptimeMillis >= this.f36859f || (this.f36858e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.f36855b) / uptimeMillis);
                this.f36858e = i;
                this.f36858e = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f36855b = j;
            this.f36854a = SystemClock.uptimeMillis();
        }
    }
}
