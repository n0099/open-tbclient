package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class b implements c, d, e {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60049b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f60050c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f60051d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f60052e;

    /* renamed from: f  reason: collision with root package name */
    public a f60053f;

    /* renamed from: g  reason: collision with root package name */
    public a f60054g;

    /* renamed from: h  reason: collision with root package name */
    public a f60055h;

    /* renamed from: i  reason: collision with root package name */
    public a f60056i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f60057j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f60049b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f60056i;
        if (aVar2 != null) {
            this.f60056i = aVar2.f60048d;
            aVar2.f60048d = null;
            return aVar2;
        }
        synchronized (this.f60051d) {
            aVar = this.f60054g;
            while (aVar == null) {
                if (!this.f60057j) {
                    this.f60051d.wait();
                    aVar = this.f60054g;
                } else {
                    throw new p("read");
                }
            }
            this.f60056i = aVar.f60048d;
            this.f60055h = null;
            this.f60054g = null;
            aVar.f60048d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f60050c) {
            if (!this.f60057j) {
                a aVar = this.f60052e;
                if (aVar == null) {
                    if (this.k < this.a) {
                        this.k++;
                        return new a(this.f60049b);
                    }
                    do {
                        this.f60050c.wait();
                        if (!this.f60057j) {
                            aVar = this.f60052e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f60052e = aVar.f60048d;
                if (aVar == this.f60053f) {
                    this.f60053f = null;
                }
                aVar.f60048d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.f60057j = true;
        synchronized (this.f60050c) {
            this.f60050c.notifyAll();
        }
        synchronized (this.f60051d) {
            this.f60051d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f60050c) {
            a aVar2 = this.f60053f;
            if (aVar2 == null) {
                this.f60053f = aVar;
                this.f60052e = aVar;
            } else {
                aVar2.f60048d = aVar;
                this.f60053f = aVar;
            }
            this.f60050c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f60051d) {
            a aVar2 = this.f60055h;
            if (aVar2 == null) {
                this.f60055h = aVar;
                this.f60054g = aVar;
                this.f60051d.notify();
            } else {
                aVar2.f60048d = aVar;
                this.f60055h = aVar;
            }
        }
    }
}
