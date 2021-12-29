package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public abstract class a {
    public Notification a;

    /* renamed from: b  reason: collision with root package name */
    public int f62665b;

    /* renamed from: c  reason: collision with root package name */
    public long f62666c;

    /* renamed from: d  reason: collision with root package name */
    public long f62667d;

    /* renamed from: e  reason: collision with root package name */
    public String f62668e;

    /* renamed from: f  reason: collision with root package name */
    public int f62669f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f62670g;

    /* renamed from: h  reason: collision with root package name */
    public int f62671h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62672i;

    public a(int i2, String str) {
        this.f62665b = i2;
        this.f62668e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f62665b = downloadInfo.getId();
        this.f62668e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f62666c;
    }

    public long c() {
        return this.f62667d;
    }

    public String d() {
        return this.f62668e;
    }

    public int e() {
        return this.f62669f;
    }

    public long f() {
        if (this.f62670g == 0) {
            this.f62670g = System.currentTimeMillis();
        }
        return this.f62670g;
    }

    public synchronized void g() {
        this.f62671h++;
    }

    public int h() {
        return this.f62671h;
    }

    public boolean i() {
        return this.f62672i;
    }

    public void b(long j2) {
        this.f62667d = j2;
    }

    public int a() {
        return this.f62665b;
    }

    public void a(long j2) {
        this.f62666c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f62669f != i2) {
            this.f62669f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f62666c = j2;
        this.f62667d = j3;
        this.f62669f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f62665b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f62665b, this.f62669f, notification);
    }

    public void a(boolean z) {
        this.f62672i = z;
    }
}
