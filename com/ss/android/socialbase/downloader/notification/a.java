package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes8.dex */
public abstract class a {
    public Notification a;

    /* renamed from: b  reason: collision with root package name */
    public int f58863b;

    /* renamed from: c  reason: collision with root package name */
    public long f58864c;

    /* renamed from: d  reason: collision with root package name */
    public long f58865d;

    /* renamed from: e  reason: collision with root package name */
    public String f58866e;

    /* renamed from: f  reason: collision with root package name */
    public int f58867f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f58868g;

    /* renamed from: h  reason: collision with root package name */
    public int f58869h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58870i;

    public a(int i2, String str) {
        this.f58863b = i2;
        this.f58866e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f58863b = downloadInfo.getId();
        this.f58866e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f58864c;
    }

    public long c() {
        return this.f58865d;
    }

    public String d() {
        return this.f58866e;
    }

    public int e() {
        return this.f58867f;
    }

    public long f() {
        if (this.f58868g == 0) {
            this.f58868g = System.currentTimeMillis();
        }
        return this.f58868g;
    }

    public synchronized void g() {
        this.f58869h++;
    }

    public int h() {
        return this.f58869h;
    }

    public boolean i() {
        return this.f58870i;
    }

    public void b(long j2) {
        this.f58865d = j2;
    }

    public int a() {
        return this.f58863b;
    }

    public void a(long j2) {
        this.f58864c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f58867f != i2) {
            this.f58867f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f58864c = j2;
        this.f58865d = j3;
        this.f58867f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f58863b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f58863b, this.f58867f, notification);
    }

    public void a(boolean z) {
        this.f58870i = z;
    }
}
