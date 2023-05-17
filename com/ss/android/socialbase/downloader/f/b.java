package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ExceptionCode;
/* loaded from: classes10.dex */
public class b implements c, d, e {
    public final int a;
    public final int b;
    public final Object c = new Object();
    public final Object d = new Object();
    public a e;
    public a f;
    public a g;
    public a h;
    public a i;
    public volatile boolean j;
    public int k;

    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.a = i;
        this.b = i2;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.d;
            aVar2.d = null;
            return aVar2;
        }
        synchronized (this.d) {
            aVar = this.g;
            while (aVar == null) {
                if (!this.j) {
                    this.d.wait();
                    aVar = this.g;
                } else {
                    throw new p(ExceptionCode.READ);
                }
            }
            this.i = aVar.d;
            this.h = null;
            this.g = null;
            aVar.d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.c) {
            a aVar2 = this.f;
            if (aVar2 == null) {
                this.f = aVar;
                this.e = aVar;
            } else {
                aVar2.d = aVar;
                this.f = aVar;
            }
            this.c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.d) {
            a aVar2 = this.h;
            if (aVar2 == null) {
                this.h = aVar;
                this.g = aVar;
                this.d.notify();
            } else {
                aVar2.d = aVar;
                this.h = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.c) {
            if (!this.j) {
                a aVar = this.e;
                if (aVar == null) {
                    if (this.k < this.a) {
                        this.k++;
                        return new a(this.b);
                    }
                    do {
                        this.c.wait();
                        if (!this.j) {
                            aVar = this.e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.e = aVar.d;
                if (aVar == this.f) {
                    this.f = null;
                }
                aVar.d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.c) {
            this.c.notifyAll();
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }
}
