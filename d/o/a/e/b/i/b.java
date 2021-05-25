package d.o.a.e.b.i;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes7.dex */
public class b implements c, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final int f67257a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67258b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f67259c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f67260d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public a f67261e;

    /* renamed from: f  reason: collision with root package name */
    public a f67262f;

    /* renamed from: g  reason: collision with root package name */
    public a f67263g;

    /* renamed from: h  reason: collision with root package name */
    public a f67264h;

    /* renamed from: i  reason: collision with root package name */
    public a f67265i;
    public volatile boolean j;
    public int k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f67257a = i2;
        this.f67258b = i3;
    }

    @Override // d.o.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f67265i;
        if (aVar2 != null) {
            this.f67265i = aVar2.f67256d;
            aVar2.f67256d = null;
            return aVar2;
        }
        synchronized (this.f67260d) {
            aVar = this.f67263g;
            while (aVar == null) {
                if (!this.j) {
                    this.f67260d.wait();
                    aVar = this.f67263g;
                } else {
                    throw new p("read");
                }
            }
            this.f67265i = aVar.f67256d;
            this.f67264h = null;
            this.f67263g = null;
            aVar.f67256d = null;
        }
        return aVar;
    }

    @Override // d.o.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f67259c) {
            if (!this.j) {
                a aVar = this.f67261e;
                if (aVar == null) {
                    if (this.k < this.f67257a) {
                        this.k++;
                        return new a(this.f67258b);
                    }
                    do {
                        this.f67259c.wait();
                        if (!this.j) {
                            aVar = this.f67261e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f67261e = aVar.f67256d;
                if (aVar == this.f67262f) {
                    this.f67262f = null;
                }
                aVar.f67256d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f67259c) {
            this.f67259c.notifyAll();
        }
        synchronized (this.f67260d) {
            this.f67260d.notifyAll();
        }
    }

    @Override // d.o.a.e.b.i.c
    public void a(@NonNull a aVar) {
        synchronized (this.f67259c) {
            a aVar2 = this.f67262f;
            if (aVar2 == null) {
                this.f67262f = aVar;
                this.f67261e = aVar;
            } else {
                aVar2.f67256d = aVar;
                this.f67262f = aVar;
            }
            this.f67259c.notify();
        }
    }

    @Override // d.o.a.e.b.i.e
    public void b(@NonNull a aVar) {
        synchronized (this.f67260d) {
            a aVar2 = this.f67264h;
            if (aVar2 == null) {
                this.f67264h = aVar;
                this.f67263g = aVar;
                this.f67260d.notify();
            } else {
                aVar2.f67256d = aVar;
                this.f67264h = aVar;
            }
        }
    }
}
