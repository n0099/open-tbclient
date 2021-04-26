package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes6.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f66528a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66529b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f66530c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f66531d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f66532e;

    /* renamed from: f  reason: collision with root package name */
    public a f66533f;

    /* renamed from: g  reason: collision with root package name */
    public a f66534g;

    /* renamed from: h  reason: collision with root package name */
    public a f66535h;

    /* renamed from: i  reason: collision with root package name */
    public a f66536i;
    public volatile boolean j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f66528a = i2;
        this.f66529b = i3;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f66536i;
        if (aVar2 != null) {
            this.f66536i = aVar2.f66527d;
            aVar2.f66527d = null;
            return aVar2;
        }
        synchronized (this.f66531d) {
            aVar = this.f66534g;
            while (aVar == null) {
                if (!this.j) {
                    this.f66531d.wait();
                    aVar = this.f66534g;
                } else {
                    throw new p("read");
                }
            }
            this.f66536i = aVar.f66527d;
            this.f66535h = null;
            this.f66534g = null;
            aVar.f66527d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f66530c) {
            if (!this.j) {
                a aVar = this.f66532e;
                if (aVar == null) {
                    if (this.k < this.f66528a) {
                        this.k++;
                        return new a(this.f66529b);
                    }
                    do {
                        this.f66530c.wait();
                        if (!this.j) {
                            aVar = this.f66532e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f66532e = aVar.f66527d;
                if (aVar == this.f66533f) {
                    this.f66533f = null;
                }
                aVar.f66527d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f66530c) {
            this.f66530c.notifyAll();
        }
        synchronized (this.f66531d) {
            this.f66531d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f66530c) {
            a aVar2 = this.f66533f;
            if (aVar2 == null) {
                this.f66533f = aVar;
                this.f66532e = aVar;
            } else {
                aVar2.f66527d = aVar;
                this.f66533f = aVar;
            }
            this.f66530c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f66531d) {
            a aVar2 = this.f66535h;
            if (aVar2 == null) {
                this.f66535h = aVar;
                this.f66534g = aVar;
                this.f66531d.notify();
            } else {
                aVar2.f66527d = aVar;
                this.f66535h = aVar;
            }
        }
    }
}
