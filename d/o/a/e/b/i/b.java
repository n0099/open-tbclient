package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes7.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f67026a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67027b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f67028c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f67029d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f67030e;

    /* renamed from: f  reason: collision with root package name */
    public a f67031f;

    /* renamed from: g  reason: collision with root package name */
    public a f67032g;

    /* renamed from: h  reason: collision with root package name */
    public a f67033h;
    public a i;
    public volatile boolean j;
    public int k;

    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.f67026a = i;
        this.f67027b = i2;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.f67025d;
            aVar2.f67025d = null;
            return aVar2;
        }
        synchronized (this.f67029d) {
            aVar = this.f67032g;
            while (aVar == null) {
                if (!this.j) {
                    this.f67029d.wait();
                    aVar = this.f67032g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.f67025d;
            this.f67033h = null;
            this.f67032g = null;
            aVar.f67025d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f67028c) {
            if (!this.j) {
                a aVar = this.f67030e;
                if (aVar == null) {
                    if (this.k < this.f67026a) {
                        this.k++;
                        return new a(this.f67027b);
                    }
                    do {
                        this.f67028c.wait();
                        if (!this.j) {
                            aVar = this.f67030e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f67030e = aVar.f67025d;
                if (aVar == this.f67031f) {
                    this.f67031f = null;
                }
                aVar.f67025d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f67028c) {
            this.f67028c.notifyAll();
        }
        synchronized (this.f67029d) {
            this.f67029d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f67028c) {
            a aVar2 = this.f67031f;
            if (aVar2 == null) {
                this.f67031f = aVar;
                this.f67030e = aVar;
            } else {
                aVar2.f67025d = aVar;
                this.f67031f = aVar;
            }
            this.f67028c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f67029d) {
            a aVar2 = this.f67033h;
            if (aVar2 == null) {
                this.f67033h = aVar;
                this.f67032g = aVar;
                this.f67029d.notify();
            } else {
                aVar2.f67025d = aVar;
                this.f67033h = aVar;
            }
        }
    }
}
