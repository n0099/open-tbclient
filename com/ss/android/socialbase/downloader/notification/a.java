package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public abstract class a {
    public Notification a;

    /* renamed from: b  reason: collision with root package name */
    public int f43552b;

    /* renamed from: c  reason: collision with root package name */
    public long f43553c;

    /* renamed from: d  reason: collision with root package name */
    public long f43554d;

    /* renamed from: e  reason: collision with root package name */
    public String f43555e;

    /* renamed from: f  reason: collision with root package name */
    public int f43556f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f43557g;

    /* renamed from: h  reason: collision with root package name */
    public int f43558h;
    public boolean i;

    public a(int i, String str) {
        this.f43552b = i;
        this.f43555e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f43552b = downloadInfo.getId();
        this.f43555e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f43553c;
    }

    public long c() {
        return this.f43554d;
    }

    public String d() {
        return this.f43555e;
    }

    public int e() {
        return this.f43556f;
    }

    public long f() {
        if (this.f43557g == 0) {
            this.f43557g = System.currentTimeMillis();
        }
        return this.f43557g;
    }

    public synchronized void g() {
        this.f43558h++;
    }

    public int h() {
        return this.f43558h;
    }

    public boolean i() {
        return this.i;
    }

    public void b(long j) {
        this.f43554d = j;
    }

    public int a() {
        return this.f43552b;
    }

    public void a(long j) {
        this.f43553c = j;
    }

    public void a(int i, BaseException baseException, boolean z) {
        a(i, baseException, z, false);
    }

    public void a(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f43556f != i) {
            this.f43556f = i;
            a(baseException, z);
        }
    }

    public void a(long j, long j2) {
        this.f43553c = j;
        this.f43554d = j2;
        this.f43556f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f43552b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f43552b, this.f43556f, notification);
    }

    public void a(boolean z) {
        this.i = z;
    }
}
