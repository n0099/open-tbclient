package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes7.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f67214a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67215b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f67216c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f67217d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f67218e;

    /* renamed from: f  reason: collision with root package name */
    public a f67219f;

    /* renamed from: g  reason: collision with root package name */
    public a f67220g;

    /* renamed from: h  reason: collision with root package name */
    public a f67221h;

    /* renamed from: i  reason: collision with root package name */
    public a f67222i;
    public volatile boolean j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f67214a = i2;
        this.f67215b = i3;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f67222i;
        if (aVar2 != null) {
            this.f67222i = aVar2.f67213d;
            aVar2.f67213d = null;
            return aVar2;
        }
        synchronized (this.f67217d) {
            aVar = this.f67220g;
            while (aVar == null) {
                if (!this.j) {
                    this.f67217d.wait();
                    aVar = this.f67220g;
                } else {
                    throw new p("read");
                }
            }
            this.f67222i = aVar.f67213d;
            this.f67221h = null;
            this.f67220g = null;
            aVar.f67213d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f67216c) {
            if (!this.j) {
                a aVar = this.f67218e;
                if (aVar == null) {
                    if (this.k < this.f67214a) {
                        this.k++;
                        return new a(this.f67215b);
                    }
                    do {
                        this.f67216c.wait();
                        if (!this.j) {
                            aVar = this.f67218e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f67218e = aVar.f67213d;
                if (aVar == this.f67219f) {
                    this.f67219f = null;
                }
                aVar.f67213d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f67216c) {
            this.f67216c.notifyAll();
        }
        synchronized (this.f67217d) {
            this.f67217d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f67216c) {
            a aVar2 = this.f67219f;
            if (aVar2 == null) {
                this.f67219f = aVar;
                this.f67218e = aVar;
            } else {
                aVar2.f67213d = aVar;
                this.f67219f = aVar;
            }
            this.f67216c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f67217d) {
            a aVar2 = this.f67221h;
            if (aVar2 == null) {
                this.f67221h = aVar;
                this.f67220g = aVar;
                this.f67217d.notify();
            } else {
                aVar2.f67213d = aVar;
                this.f67221h = aVar;
            }
        }
    }
}
