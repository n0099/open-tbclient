package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class b implements c, d, e {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43286b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f43287c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f43288d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f43289e;

    /* renamed from: f  reason: collision with root package name */
    public a f43290f;

    /* renamed from: g  reason: collision with root package name */
    public a f43291g;

    /* renamed from: h  reason: collision with root package name */
    public a f43292h;
    public a i;
    public volatile boolean j;
    public int k;

    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.a = i;
        this.f43286b = i2;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.f43285d;
            aVar2.f43285d = null;
            return aVar2;
        }
        synchronized (this.f43288d) {
            aVar = this.f43291g;
            while (aVar == null) {
                if (!this.j) {
                    this.f43288d.wait();
                    aVar = this.f43291g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.f43285d;
            this.f43292h = null;
            this.f43291g = null;
            aVar.f43285d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f43287c) {
            if (!this.j) {
                a aVar = this.f43289e;
                if (aVar == null) {
                    if (this.k < this.a) {
                        this.k++;
                        return new a(this.f43286b);
                    }
                    do {
                        this.f43287c.wait();
                        if (!this.j) {
                            aVar = this.f43289e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f43289e = aVar.f43285d;
                if (aVar == this.f43290f) {
                    this.f43290f = null;
                }
                aVar.f43285d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f43287c) {
            this.f43287c.notifyAll();
        }
        synchronized (this.f43288d) {
            this.f43288d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f43287c) {
            a aVar2 = this.f43290f;
            if (aVar2 == null) {
                this.f43290f = aVar;
                this.f43289e = aVar;
            } else {
                aVar2.f43285d = aVar;
                this.f43290f = aVar;
            }
            this.f43287c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f43288d) {
            a aVar2 = this.f43292h;
            if (aVar2 == null) {
                this.f43292h = aVar;
                this.f43291g = aVar;
                this.f43288d.notify();
            } else {
                aVar2.f43285d = aVar;
                this.f43292h = aVar;
            }
        }
    }
}
