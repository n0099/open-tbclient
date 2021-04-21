package d.p.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes6.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f68166a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68167b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f68168c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f68169d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f68170e;

    /* renamed from: f  reason: collision with root package name */
    public a f68171f;

    /* renamed from: g  reason: collision with root package name */
    public a f68172g;

    /* renamed from: h  reason: collision with root package name */
    public a f68173h;
    public a i;
    public volatile boolean j;
    public int k;

    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.f68166a = i;
        this.f68167b = i2;
    }

    @Override // d.p.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.f68165d;
            aVar2.f68165d = null;
            return aVar2;
        }
        synchronized (this.f68169d) {
            aVar = this.f68172g;
            while (aVar == null) {
                if (!this.j) {
                    this.f68169d.wait();
                    aVar = this.f68172g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.f68165d;
            this.f68173h = null;
            this.f68172g = null;
            aVar.f68165d = null;
        }
        return aVar;
    }

    @Override // d.p.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f68168c) {
            if (!this.j) {
                a aVar = this.f68170e;
                if (aVar == null) {
                    if (this.k < this.f68166a) {
                        this.k++;
                        return new a(this.f68167b);
                    }
                    do {
                        this.f68168c.wait();
                        if (!this.j) {
                            aVar = this.f68170e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f68170e = aVar.f68165d;
                if (aVar == this.f68171f) {
                    this.f68171f = null;
                }
                aVar.f68165d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f68168c) {
            this.f68168c.notifyAll();
        }
        synchronized (this.f68169d) {
            this.f68169d.notifyAll();
        }
    }

    @Override // d.p.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f68168c) {
            a aVar2 = this.f68171f;
            if (aVar2 == null) {
                this.f68171f = aVar;
                this.f68170e = aVar;
            } else {
                aVar2.f68165d = aVar;
                this.f68171f = aVar;
            }
            this.f68168c.notify();
        }
    }

    @Override // d.p.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f68169d) {
            a aVar2 = this.f68173h;
            if (aVar2 == null) {
                this.f68173h = aVar;
                this.f68172g = aVar;
                this.f68169d.notify();
            } else {
                aVar2.f68165d = aVar;
                this.f68173h = aVar;
            }
        }
    }
}
