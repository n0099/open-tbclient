package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes6.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f68019a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68020b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f68021c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f68022d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f68023e;

    /* renamed from: f  reason: collision with root package name */
    public a f68024f;

    /* renamed from: g  reason: collision with root package name */
    public a f68025g;

    /* renamed from: h  reason: collision with root package name */
    public a f68026h;
    public a i;
    public volatile boolean j;
    public int k;

    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.f68019a = i;
        this.f68020b = i2;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.f68018d;
            aVar2.f68018d = null;
            return aVar2;
        }
        synchronized (this.f68022d) {
            aVar = this.f68025g;
            while (aVar == null) {
                if (!this.j) {
                    this.f68022d.wait();
                    aVar = this.f68025g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.f68018d;
            this.f68026h = null;
            this.f68025g = null;
            aVar.f68018d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f68021c) {
            if (!this.j) {
                a aVar = this.f68023e;
                if (aVar == null) {
                    if (this.k < this.f68019a) {
                        this.k++;
                        return new a(this.f68020b);
                    }
                    do {
                        this.f68021c.wait();
                        if (!this.j) {
                            aVar = this.f68023e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f68023e = aVar.f68018d;
                if (aVar == this.f68024f) {
                    this.f68024f = null;
                }
                aVar.f68018d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f68021c) {
            this.f68021c.notifyAll();
        }
        synchronized (this.f68022d) {
            this.f68022d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f68021c) {
            a aVar2 = this.f68024f;
            if (aVar2 == null) {
                this.f68024f = aVar;
                this.f68023e = aVar;
            } else {
                aVar2.f68018d = aVar;
                this.f68024f = aVar;
            }
            this.f68021c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f68022d) {
            a aVar2 = this.f68026h;
            if (aVar2 == null) {
                this.f68026h = aVar;
                this.f68025g = aVar;
                this.f68022d.notify();
            } else {
                aVar2.f68018d = aVar;
                this.f68026h = aVar;
            }
        }
    }
}
