package d.a.p0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f67651e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f67652f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f67653g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67654h = false;

    /* renamed from: d.a.p0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1832b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f67655e;

        /* renamed from: f  reason: collision with root package name */
        public int f67656f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67657g;

        public final void a() {
            if (this.f67657g) {
                return;
            }
            this.f67657g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i2 = this.f67656f;
            while (i2 < this.f67655e && b.this.i(i2) == null) {
                i2++;
            }
            if (i2 < this.f67655e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i2 = this.f67656f;
                if (i2 >= this.f67655e || b.this.i(i2) != null) {
                    break;
                }
                this.f67656f++;
            }
            int i3 = this.f67656f;
            if (i3 < this.f67655e) {
                b bVar = b.this;
                this.f67656f = i3 + 1;
                return (E) bVar.i(i3);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1832b() {
            this.f67656f = 0;
            this.f67657g = false;
            b.this.j();
            this.f67655e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f67651e.contains(e2)) {
            return false;
        }
        this.f67651e.add(e2);
        this.f67653g++;
        return true;
    }

    public final int f() {
        return this.f67651e.size();
    }

    public final void g() {
        for (int size = this.f67651e.size() - 1; size >= 0; size--) {
            if (this.f67651e.get(size) == null) {
                this.f67651e.remove(size);
            }
        }
    }

    public final void h() {
        int i2 = this.f67652f - 1;
        this.f67652f = i2;
        if (i2 <= 0 && this.f67654h) {
            this.f67654h = false;
            g();
        }
    }

    public final E i(int i2) {
        return this.f67651e.get(i2);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1832b();
    }

    public final void j() {
        this.f67652f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f67651e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f67652f == 0) {
            this.f67651e.remove(indexOf);
        } else {
            this.f67654h = true;
            this.f67651e.set(indexOf, null);
        }
        this.f67653g--;
        return true;
    }
}
