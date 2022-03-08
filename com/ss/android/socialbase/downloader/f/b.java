package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class b implements c, d, e {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58566b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f58567c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f58568d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f58569e;

    /* renamed from: f  reason: collision with root package name */
    public a f58570f;

    /* renamed from: g  reason: collision with root package name */
    public a f58571g;

    /* renamed from: h  reason: collision with root package name */
    public a f58572h;

    /* renamed from: i  reason: collision with root package name */
    public a f58573i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f58574j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f58566b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f58573i;
        if (aVar2 != null) {
            this.f58573i = aVar2.f58565d;
            aVar2.f58565d = null;
            return aVar2;
        }
        synchronized (this.f58568d) {
            aVar = this.f58571g;
            while (aVar == null) {
                if (!this.f58574j) {
                    this.f58568d.wait();
                    aVar = this.f58571g;
                } else {
                    throw new p("read");
                }
            }
            this.f58573i = aVar.f58565d;
            this.f58572h = null;
            this.f58571g = null;
            aVar.f58565d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f58567c) {
            if (!this.f58574j) {
                a aVar = this.f58569e;
                if (aVar == null) {
                    if (this.k < this.a) {
                        this.k++;
                        return new a(this.f58566b);
                    }
                    do {
                        this.f58567c.wait();
                        if (!this.f58574j) {
                            aVar = this.f58569e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f58569e = aVar.f58565d;
                if (aVar == this.f58570f) {
                    this.f58570f = null;
                }
                aVar.f58565d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.f58574j = true;
        synchronized (this.f58567c) {
            this.f58567c.notifyAll();
        }
        synchronized (this.f58568d) {
            this.f58568d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f58567c) {
            a aVar2 = this.f58570f;
            if (aVar2 == null) {
                this.f58570f = aVar;
                this.f58569e = aVar;
            } else {
                aVar2.f58565d = aVar;
                this.f58570f = aVar;
            }
            this.f58567c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f58568d) {
            a aVar2 = this.f58572h;
            if (aVar2 == null) {
                this.f58572h = aVar;
                this.f58571g = aVar;
                this.f58568d.notify();
            } else {
                aVar2.f58565d = aVar;
                this.f58572h = aVar;
            }
        }
    }
}
