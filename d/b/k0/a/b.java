package d.b.k0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f64784e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f64785f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f64786g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64787h = false;

    /* renamed from: d.b.k0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1761b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f64788e;

        /* renamed from: f  reason: collision with root package name */
        public int f64789f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f64790g;

        public final void a() {
            if (this.f64790g) {
                return;
            }
            this.f64790g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i = this.f64789f;
            while (i < this.f64788e && b.this.i(i) == null) {
                i++;
            }
            if (i < this.f64788e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i = this.f64789f;
                if (i >= this.f64788e || b.this.i(i) != null) {
                    break;
                }
                this.f64789f++;
            }
            int i2 = this.f64789f;
            if (i2 < this.f64788e) {
                b bVar = b.this;
                this.f64789f = i2 + 1;
                return (E) bVar.i(i2);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1761b() {
            this.f64789f = 0;
            this.f64790g = false;
            b.this.j();
            this.f64788e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f64784e.contains(e2)) {
            return false;
        }
        this.f64784e.add(e2);
        this.f64786g++;
        return true;
    }

    public final int f() {
        return this.f64784e.size();
    }

    public final void g() {
        for (int size = this.f64784e.size() - 1; size >= 0; size--) {
            if (this.f64784e.get(size) == null) {
                this.f64784e.remove(size);
            }
        }
    }

    public final void h() {
        int i = this.f64785f - 1;
        this.f64785f = i;
        if (i <= 0 && this.f64787h) {
            this.f64787h = false;
            g();
        }
    }

    public final E i(int i) {
        return this.f64784e.get(i);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1761b();
    }

    public final void j() {
        this.f64785f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f64784e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f64785f == 0) {
            this.f64784e.remove(indexOf);
        } else {
            this.f64787h = true;
            this.f64784e.set(indexOf, null);
        }
        this.f64786g--;
        return true;
    }
}
