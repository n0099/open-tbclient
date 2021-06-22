package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes7.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f71147a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71148b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f71149c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f71150d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f71151e;

    /* renamed from: f  reason: collision with root package name */
    public a f71152f;

    /* renamed from: g  reason: collision with root package name */
    public a f71153g;

    /* renamed from: h  reason: collision with root package name */
    public a f71154h;

    /* renamed from: i  reason: collision with root package name */
    public a f71155i;
    public volatile boolean j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f71147a = i2;
        this.f71148b = i3;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f71155i;
        if (aVar2 != null) {
            this.f71155i = aVar2.f71146d;
            aVar2.f71146d = null;
            return aVar2;
        }
        synchronized (this.f71150d) {
            aVar = this.f71153g;
            while (aVar == null) {
                if (!this.j) {
                    this.f71150d.wait();
                    aVar = this.f71153g;
                } else {
                    throw new p("read");
                }
            }
            this.f71155i = aVar.f71146d;
            this.f71154h = null;
            this.f71153g = null;
            aVar.f71146d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f71149c) {
            if (!this.j) {
                a aVar = this.f71151e;
                if (aVar == null) {
                    if (this.k < this.f71147a) {
                        this.k++;
                        return new a(this.f71148b);
                    }
                    do {
                        this.f71149c.wait();
                        if (!this.j) {
                            aVar = this.f71151e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f71151e = aVar.f71146d;
                if (aVar == this.f71152f) {
                    this.f71152f = null;
                }
                aVar.f71146d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f71149c) {
            this.f71149c.notifyAll();
        }
        synchronized (this.f71150d) {
            this.f71150d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f71149c) {
            a aVar2 = this.f71152f;
            if (aVar2 == null) {
                this.f71152f = aVar;
                this.f71151e = aVar;
            } else {
                aVar2.f71146d = aVar;
                this.f71152f = aVar;
            }
            this.f71149c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f71150d) {
            a aVar2 = this.f71154h;
            if (aVar2 == null) {
                this.f71154h = aVar;
                this.f71153g = aVar;
                this.f71150d.notify();
            } else {
                aVar2.f71146d = aVar;
                this.f71154h = aVar;
            }
        }
    }
}
