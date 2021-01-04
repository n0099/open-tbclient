package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.g.c;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Notification f13549a;

    /* renamed from: b  reason: collision with root package name */
    private int f13550b;
    private long c;
    private long d;
    private String e;
    private int f = 0;
    private long g;
    private int h;
    private boolean i;

    public abstract void a(com.ss.android.socialbase.downloader.e.a aVar, boolean z);

    public a(int i, String str) {
        this.f13550b = i;
        this.e = str;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.f13550b = cVar.g();
            this.e = cVar.i();
        }
    }

    public int a() {
        return this.f13550b;
    }

    public long b() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public long c() {
        return this.d;
    }

    public void b(long j) {
        this.d = j;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        a(i, aVar, z, false);
    }

    public void a(int i, com.ss.android.socialbase.downloader.e.a aVar, boolean z, boolean z2) {
        if (z2 || this.f != i) {
            this.f = i;
            a(aVar, z);
        }
    }

    public long f() {
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
        }
        return this.g;
    }

    public void a(long j, long j2) {
        this.c = j;
        this.d = j2;
        this.f = 4;
        a((com.ss.android.socialbase.downloader.e.a) null, false);
    }

    public void c(Notification notification) {
        if (this.f13550b != 0 && notification != null) {
            b.eJw().a(this.f13550b, this.f, notification);
        }
    }

    public synchronized void g() {
        this.h++;
    }

    public int h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.i = z;
    }

    public Notification eJv() {
        return this.f13549a;
    }
}
