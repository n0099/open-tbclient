package d.b.j0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f64484e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f64485f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f64486g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64487h = false;

    /* renamed from: d.b.j0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1741b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f64488e;

        /* renamed from: f  reason: collision with root package name */
        public int f64489f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f64490g;

        public final void a() {
            if (this.f64490g) {
                return;
            }
            this.f64490g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i = this.f64489f;
            while (i < this.f64488e && b.this.i(i) == null) {
                i++;
            }
            if (i < this.f64488e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i = this.f64489f;
                if (i >= this.f64488e || b.this.i(i) != null) {
                    break;
                }
                this.f64489f++;
            }
            int i2 = this.f64489f;
            if (i2 < this.f64488e) {
                b bVar = b.this;
                this.f64489f = i2 + 1;
                return (E) bVar.i(i2);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1741b() {
            this.f64489f = 0;
            this.f64490g = false;
            b.this.j();
            this.f64488e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f64484e.contains(e2)) {
            return false;
        }
        this.f64484e.add(e2);
        this.f64486g++;
        return true;
    }

    public final int f() {
        return this.f64484e.size();
    }

    public final void g() {
        for (int size = this.f64484e.size() - 1; size >= 0; size--) {
            if (this.f64484e.get(size) == null) {
                this.f64484e.remove(size);
            }
        }
    }

    public final void h() {
        int i = this.f64485f - 1;
        this.f64485f = i;
        if (i <= 0 && this.f64487h) {
            this.f64487h = false;
            g();
        }
    }

    public final E i(int i) {
        return this.f64484e.get(i);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1741b();
    }

    public final void j() {
        this.f64485f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f64484e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f64485f == 0) {
            this.f64484e.remove(indexOf);
        } else {
            this.f64487h = true;
            this.f64484e.set(indexOf, null);
        }
        this.f64486g--;
        return true;
    }
}
