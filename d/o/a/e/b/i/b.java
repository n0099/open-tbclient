package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes7.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f71043a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71044b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f71045c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f71046d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f71047e;

    /* renamed from: f  reason: collision with root package name */
    public a f71048f;

    /* renamed from: g  reason: collision with root package name */
    public a f71049g;

    /* renamed from: h  reason: collision with root package name */
    public a f71050h;

    /* renamed from: i  reason: collision with root package name */
    public a f71051i;
    public volatile boolean j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f71043a = i2;
        this.f71044b = i3;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f71051i;
        if (aVar2 != null) {
            this.f71051i = aVar2.f71042d;
            aVar2.f71042d = null;
            return aVar2;
        }
        synchronized (this.f71046d) {
            aVar = this.f71049g;
            while (aVar == null) {
                if (!this.j) {
                    this.f71046d.wait();
                    aVar = this.f71049g;
                } else {
                    throw new p("read");
                }
            }
            this.f71051i = aVar.f71042d;
            this.f71050h = null;
            this.f71049g = null;
            aVar.f71042d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f71045c) {
            if (!this.j) {
                a aVar = this.f71047e;
                if (aVar == null) {
                    if (this.k < this.f71043a) {
                        this.k++;
                        return new a(this.f71044b);
                    }
                    do {
                        this.f71045c.wait();
                        if (!this.j) {
                            aVar = this.f71047e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f71047e = aVar.f71042d;
                if (aVar == this.f71048f) {
                    this.f71048f = null;
                }
                aVar.f71042d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f71045c) {
            this.f71045c.notifyAll();
        }
        synchronized (this.f71046d) {
            this.f71046d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f71045c) {
            a aVar2 = this.f71048f;
            if (aVar2 == null) {
                this.f71048f = aVar;
                this.f71047e = aVar;
            } else {
                aVar2.f71042d = aVar;
                this.f71048f = aVar;
            }
            this.f71045c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f71046d) {
            a aVar2 = this.f71050h;
            if (aVar2 == null) {
                this.f71050h = aVar;
                this.f71049g = aVar;
                this.f71046d.notify();
            } else {
                aVar2.f71042d = aVar;
                this.f71050h = aVar;
            }
        }
    }
}
