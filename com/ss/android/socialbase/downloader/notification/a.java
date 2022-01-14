package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public abstract class a {
    public Notification a;

    /* renamed from: b  reason: collision with root package name */
    public int f60301b;

    /* renamed from: c  reason: collision with root package name */
    public long f60302c;

    /* renamed from: d  reason: collision with root package name */
    public long f60303d;

    /* renamed from: e  reason: collision with root package name */
    public String f60304e;

    /* renamed from: f  reason: collision with root package name */
    public int f60305f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f60306g;

    /* renamed from: h  reason: collision with root package name */
    public int f60307h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60308i;

    public a(int i2, String str) {
        this.f60301b = i2;
        this.f60304e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f60301b = downloadInfo.getId();
        this.f60304e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f60302c;
    }

    public long c() {
        return this.f60303d;
    }

    public String d() {
        return this.f60304e;
    }

    public int e() {
        return this.f60305f;
    }

    public long f() {
        if (this.f60306g == 0) {
            this.f60306g = System.currentTimeMillis();
        }
        return this.f60306g;
    }

    public synchronized void g() {
        this.f60307h++;
    }

    public int h() {
        return this.f60307h;
    }

    public boolean i() {
        return this.f60308i;
    }

    public void b(long j2) {
        this.f60303d = j2;
    }

    public int a() {
        return this.f60301b;
    }

    public void a(long j2) {
        this.f60302c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f60305f != i2) {
            this.f60305f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f60302c = j2;
        this.f60303d = j3;
        this.f60305f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f60301b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f60301b, this.f60305f, notification);
    }

    public void a(boolean z) {
        this.f60308i = z;
    }
}
