package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class b implements c, d, e {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60216b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f60217c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f60218d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f60219e;

    /* renamed from: f  reason: collision with root package name */
    public a f60220f;

    /* renamed from: g  reason: collision with root package name */
    public a f60221g;

    /* renamed from: h  reason: collision with root package name */
    public a f60222h;

    /* renamed from: i  reason: collision with root package name */
    public a f60223i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f60224j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f60216b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f60223i;
        if (aVar2 != null) {
            this.f60223i = aVar2.f60215d;
            aVar2.f60215d = null;
            return aVar2;
        }
        synchronized (this.f60218d) {
            aVar = this.f60221g;
            while (aVar == null) {
                if (!this.f60224j) {
                    this.f60218d.wait();
                    aVar = this.f60221g;
                } else {
                    throw new p("read");
                }
            }
            this.f60223i = aVar.f60215d;
            this.f60222h = null;
            this.f60221g = null;
            aVar.f60215d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f60217c) {
            if (!this.f60224j) {
                a aVar = this.f60219e;
                if (aVar == null) {
                    if (this.k < this.a) {
                        this.k++;
                        return new a(this.f60216b);
                    }
                    do {
                        this.f60217c.wait();
                        if (!this.f60224j) {
                            aVar = this.f60219e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f60219e = aVar.f60215d;
                if (aVar == this.f60220f) {
                    this.f60220f = null;
                }
                aVar.f60215d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.f60224j = true;
        synchronized (this.f60217c) {
            this.f60217c.notifyAll();
        }
        synchronized (this.f60218d) {
            this.f60218d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f60217c) {
            a aVar2 = this.f60220f;
            if (aVar2 == null) {
                this.f60220f = aVar;
                this.f60219e = aVar;
            } else {
                aVar2.f60215d = aVar;
                this.f60220f = aVar;
            }
            this.f60217c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f60218d) {
            a aVar2 = this.f60222h;
            if (aVar2 == null) {
                this.f60222h = aVar;
                this.f60221g = aVar;
                this.f60218d.notify();
            } else {
                aVar2.f60215d = aVar;
                this.f60222h = aVar;
            }
        }
    }
}
