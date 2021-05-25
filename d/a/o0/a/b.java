package d.a.o0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f63829e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f63830f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63831g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63832h = false;

    /* renamed from: d.a.o0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1771b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f63833e;

        /* renamed from: f  reason: collision with root package name */
        public int f63834f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f63835g;

        public final void a() {
            if (this.f63835g) {
                return;
            }
            this.f63835g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i2 = this.f63834f;
            while (i2 < this.f63833e && b.this.i(i2) == null) {
                i2++;
            }
            if (i2 < this.f63833e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i2 = this.f63834f;
                if (i2 >= this.f63833e || b.this.i(i2) != null) {
                    break;
                }
                this.f63834f++;
            }
            int i3 = this.f63834f;
            if (i3 < this.f63833e) {
                b bVar = b.this;
                this.f63834f = i3 + 1;
                return (E) bVar.i(i3);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1771b() {
            this.f63834f = 0;
            this.f63835g = false;
            b.this.j();
            this.f63833e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f63829e.contains(e2)) {
            return false;
        }
        this.f63829e.add(e2);
        this.f63831g++;
        return true;
    }

    public final int f() {
        return this.f63829e.size();
    }

    public final void g() {
        for (int size = this.f63829e.size() - 1; size >= 0; size--) {
            if (this.f63829e.get(size) == null) {
                this.f63829e.remove(size);
            }
        }
    }

    public final void h() {
        int i2 = this.f63830f - 1;
        this.f63830f = i2;
        if (i2 <= 0 && this.f63832h) {
            this.f63832h = false;
            g();
        }
    }

    public final E i(int i2) {
        return this.f63829e.get(i2);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1771b();
    }

    public final void j() {
        this.f63830f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f63829e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f63830f == 0) {
            this.f63829e.remove(indexOf);
        } else {
            this.f63832h = true;
            this.f63829e.set(indexOf, null);
        }
        this.f63831g--;
        return true;
    }
}
