package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class b implements c, d, e {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60004b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f60005c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f60006d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f60007e;

    /* renamed from: f  reason: collision with root package name */
    public a f60008f;

    /* renamed from: g  reason: collision with root package name */
    public a f60009g;

    /* renamed from: h  reason: collision with root package name */
    public a f60010h;

    /* renamed from: i  reason: collision with root package name */
    public a f60011i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f60012j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f60004b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f60011i;
        if (aVar2 != null) {
            this.f60011i = aVar2.f60003d;
            aVar2.f60003d = null;
            return aVar2;
        }
        synchronized (this.f60006d) {
            aVar = this.f60009g;
            while (aVar == null) {
                if (!this.f60012j) {
                    this.f60006d.wait();
                    aVar = this.f60009g;
                } else {
                    throw new p("read");
                }
            }
            this.f60011i = aVar.f60003d;
            this.f60010h = null;
            this.f60009g = null;
            aVar.f60003d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f60005c) {
            if (!this.f60012j) {
                a aVar = this.f60007e;
                if (aVar == null) {
                    if (this.k < this.a) {
                        this.k++;
                        return new a(this.f60004b);
                    }
                    do {
                        this.f60005c.wait();
                        if (!this.f60012j) {
                            aVar = this.f60007e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f60007e = aVar.f60003d;
                if (aVar == this.f60008f) {
                    this.f60008f = null;
                }
                aVar.f60003d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.f60012j = true;
        synchronized (this.f60005c) {
            this.f60005c.notifyAll();
        }
        synchronized (this.f60006d) {
            this.f60006d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f60005c) {
            a aVar2 = this.f60008f;
            if (aVar2 == null) {
                this.f60008f = aVar;
                this.f60007e = aVar;
            } else {
                aVar2.f60003d = aVar;
                this.f60008f = aVar;
            }
            this.f60005c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f60006d) {
            a aVar2 = this.f60010h;
            if (aVar2 == null) {
                this.f60010h = aVar;
                this.f60009g = aVar;
                this.f60006d.notify();
            } else {
                aVar2.f60003d = aVar;
                this.f60010h = aVar;
            }
        }
    }
}
