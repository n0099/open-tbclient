package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes6.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    public long f37143a;

    /* renamed from: b  reason: collision with root package name */
    public long f37144b;

    /* renamed from: c  reason: collision with root package name */
    public long f37145c;

    /* renamed from: d  reason: collision with root package name */
    public long f37146d;

    /* renamed from: e  reason: collision with root package name */
    public int f37147e;

    /* renamed from: f  reason: collision with root package name */
    public int f37148f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.f37147e = 0;
        this.f37143a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.f37146d = SystemClock.uptimeMillis();
        this.f37145c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.f37147e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.f37146d <= 0) {
            return;
        }
        long j2 = j - this.f37145c;
        this.f37143a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f37146d;
        if (uptimeMillis > 0) {
            j2 /= uptimeMillis;
        }
        this.f37147e = (int) j2;
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        if (this.f37148f <= 0) {
            return;
        }
        boolean z = true;
        if (this.f37143a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f37143a;
            if (uptimeMillis >= this.f37148f || (this.f37147e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.f37144b) / uptimeMillis);
                this.f37147e = i;
                this.f37147e = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f37144b = j;
            this.f37143a = SystemClock.uptimeMillis();
        }
    }
}
