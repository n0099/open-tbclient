package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes4.dex */
public abstract class a {
    public Notification a;

    /* renamed from: b  reason: collision with root package name */
    public int f60513b;

    /* renamed from: c  reason: collision with root package name */
    public long f60514c;

    /* renamed from: d  reason: collision with root package name */
    public long f60515d;

    /* renamed from: e  reason: collision with root package name */
    public String f60516e;

    /* renamed from: f  reason: collision with root package name */
    public int f60517f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f60518g;

    /* renamed from: h  reason: collision with root package name */
    public int f60519h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60520i;

    public a(int i2, String str) {
        this.f60513b = i2;
        this.f60516e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f60513b = downloadInfo.getId();
        this.f60516e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f60514c;
    }

    public long c() {
        return this.f60515d;
    }

    public String d() {
        return this.f60516e;
    }

    public int e() {
        return this.f60517f;
    }

    public long f() {
        if (this.f60518g == 0) {
            this.f60518g = System.currentTimeMillis();
        }
        return this.f60518g;
    }

    public synchronized void g() {
        this.f60519h++;
    }

    public int h() {
        return this.f60519h;
    }

    public boolean i() {
        return this.f60520i;
    }

    public void b(long j2) {
        this.f60515d = j2;
    }

    public int a() {
        return this.f60513b;
    }

    public void a(long j2) {
        this.f60514c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f60517f != i2) {
            this.f60517f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f60514c = j2;
        this.f60515d = j3;
        this.f60517f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f60513b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f60513b, this.f60517f, notification);
    }

    public void a(boolean z) {
        this.f60520i = z;
    }
}
