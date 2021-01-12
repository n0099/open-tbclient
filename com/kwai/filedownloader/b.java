package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.r;
/* loaded from: classes4.dex */
public class b implements r.a, r.b {

    /* renamed from: a  reason: collision with root package name */
    private long f10864a;

    /* renamed from: b  reason: collision with root package name */
    private long f10865b;
    private long c;
    private long d;
    private int e;
    private int f = 1000;

    @Override // com.kwai.filedownloader.r.b
    public void a() {
        this.e = 0;
        this.f10864a = 0L;
    }

    @Override // com.kwai.filedownloader.r.b
    public void a(long j) {
        this.d = SystemClock.uptimeMillis();
        this.c = j;
    }

    @Override // com.kwai.filedownloader.r.a
    public int b() {
        return this.e;
    }

    @Override // com.kwai.filedownloader.r.b
    public void b(long j) {
        if (this.d <= 0) {
            return;
        }
        long j2 = j - this.c;
        this.f10864a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.d;
        if (uptimeMillis <= 0) {
            this.e = (int) j2;
        } else {
            this.e = (int) (j2 / uptimeMillis);
        }
    }

    @Override // com.kwai.filedownloader.r.b
    public void c(long j) {
        boolean z = true;
        if (this.f <= 0) {
            return;
        }
        if (this.f10864a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f10864a;
            if (uptimeMillis >= this.f || (this.e == 0 && uptimeMillis > 0)) {
                this.e = (int) ((j - this.f10865b) / uptimeMillis);
                this.e = Math.max(0, this.e);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f10865b = j;
            this.f10864a = SystemClock.uptimeMillis();
        }
    }
}
