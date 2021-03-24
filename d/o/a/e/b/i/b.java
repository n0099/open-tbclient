package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes7.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f67021a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67022b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f67023c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f67024d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f67025e;

    /* renamed from: f  reason: collision with root package name */
    public a f67026f;

    /* renamed from: g  reason: collision with root package name */
    public a f67027g;

    /* renamed from: h  reason: collision with root package name */
    public a f67028h;
    public a i;
    public volatile boolean j;
    public int k;

    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.f67021a = i;
        this.f67022b = i2;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.f67020d;
            aVar2.f67020d = null;
            return aVar2;
        }
        synchronized (this.f67024d) {
            aVar = this.f67027g;
            while (aVar == null) {
                if (!this.j) {
                    this.f67024d.wait();
                    aVar = this.f67027g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.f67020d;
            this.f67028h = null;
            this.f67027g = null;
            aVar.f67020d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f67023c) {
            if (!this.j) {
                a aVar = this.f67025e;
                if (aVar == null) {
                    if (this.k < this.f67021a) {
                        this.k++;
                        return new a(this.f67022b);
                    }
                    do {
                        this.f67023c.wait();
                        if (!this.j) {
                            aVar = this.f67025e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f67025e = aVar.f67020d;
                if (aVar == this.f67026f) {
                    this.f67026f = null;
                }
                aVar.f67020d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f67023c) {
            this.f67023c.notifyAll();
        }
        synchronized (this.f67024d) {
            this.f67024d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f67023c) {
            a aVar2 = this.f67026f;
            if (aVar2 == null) {
                this.f67026f = aVar;
                this.f67025e = aVar;
            } else {
                aVar2.f67020d = aVar;
                this.f67026f = aVar;
            }
            this.f67023c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f67024d) {
            a aVar2 = this.f67028h;
            if (aVar2 == null) {
                this.f67028h = aVar;
                this.f67027g = aVar;
                this.f67024d.notify();
            } else {
                aVar2.f67020d = aVar;
                this.f67028h = aVar;
            }
        }
    }
}
