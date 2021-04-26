package d.a.k0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f63075e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f63076f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63077g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63078h = false;

    /* renamed from: d.a.k0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1698b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f63079e;

        /* renamed from: f  reason: collision with root package name */
        public int f63080f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f63081g;

        public final void a() {
            if (this.f63081g) {
                return;
            }
            this.f63081g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i2 = this.f63080f;
            while (i2 < this.f63079e && b.this.i(i2) == null) {
                i2++;
            }
            if (i2 < this.f63079e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i2 = this.f63080f;
                if (i2 >= this.f63079e || b.this.i(i2) != null) {
                    break;
                }
                this.f63080f++;
            }
            int i3 = this.f63080f;
            if (i3 < this.f63079e) {
                b bVar = b.this;
                this.f63080f = i3 + 1;
                return (E) bVar.i(i3);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1698b() {
            this.f63080f = 0;
            this.f63081g = false;
            b.this.j();
            this.f63079e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f63075e.contains(e2)) {
            return false;
        }
        this.f63075e.add(e2);
        this.f63077g++;
        return true;
    }

    public final int f() {
        return this.f63075e.size();
    }

    public final void g() {
        for (int size = this.f63075e.size() - 1; size >= 0; size--) {
            if (this.f63075e.get(size) == null) {
                this.f63075e.remove(size);
            }
        }
    }

    public final void h() {
        int i2 = this.f63076f - 1;
        this.f63076f = i2;
        if (i2 <= 0 && this.f63078h) {
            this.f63078h = false;
            g();
        }
    }

    public final E i(int i2) {
        return this.f63075e.get(i2);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1698b();
    }

    public final void j() {
        this.f63076f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f63075e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f63076f == 0) {
            this.f63075e.remove(indexOf);
        } else {
            this.f63078h = true;
            this.f63075e.set(indexOf, null);
        }
        this.f63077g--;
        return true;
    }
}
