package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes4.dex */
public abstract class a {
    public Notification a;

    /* renamed from: b  reason: collision with root package name */
    public int f60346b;

    /* renamed from: c  reason: collision with root package name */
    public long f60347c;

    /* renamed from: d  reason: collision with root package name */
    public long f60348d;

    /* renamed from: e  reason: collision with root package name */
    public String f60349e;

    /* renamed from: f  reason: collision with root package name */
    public int f60350f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f60351g;

    /* renamed from: h  reason: collision with root package name */
    public int f60352h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60353i;

    public a(int i2, String str) {
        this.f60346b = i2;
        this.f60349e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f60346b = downloadInfo.getId();
        this.f60349e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f60347c;
    }

    public long c() {
        return this.f60348d;
    }

    public String d() {
        return this.f60349e;
    }

    public int e() {
        return this.f60350f;
    }

    public long f() {
        if (this.f60351g == 0) {
            this.f60351g = System.currentTimeMillis();
        }
        return this.f60351g;
    }

    public synchronized void g() {
        this.f60352h++;
    }

    public int h() {
        return this.f60352h;
    }

    public boolean i() {
        return this.f60353i;
    }

    public void b(long j2) {
        this.f60348d = j2;
    }

    public int a() {
        return this.f60346b;
    }

    public void a(long j2) {
        this.f60347c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f60350f != i2) {
            this.f60350f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f60347c = j2;
        this.f60348d = j3;
        this.f60350f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.f60346b == 0 || notification == null) {
            return;
        }
        b.a().a(this.f60346b, this.f60350f, notification);
    }

    public void a(boolean z) {
        this.f60353i = z;
    }
}
