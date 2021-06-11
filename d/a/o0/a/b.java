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
    public final List<E> f67547e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f67548f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f67549g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67550h = false;

    /* renamed from: d.a.o0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1829b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f67551e;

        /* renamed from: f  reason: collision with root package name */
        public int f67552f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67553g;

        public final void a() {
            if (this.f67553g) {
                return;
            }
            this.f67553g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i2 = this.f67552f;
            while (i2 < this.f67551e && b.this.i(i2) == null) {
                i2++;
            }
            if (i2 < this.f67551e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i2 = this.f67552f;
                if (i2 >= this.f67551e || b.this.i(i2) != null) {
                    break;
                }
                this.f67552f++;
            }
            int i3 = this.f67552f;
            if (i3 < this.f67551e) {
                b bVar = b.this;
                this.f67552f = i3 + 1;
                return (E) bVar.i(i3);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1829b() {
            this.f67552f = 0;
            this.f67553g = false;
            b.this.j();
            this.f67551e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f67547e.contains(e2)) {
            return false;
        }
        this.f67547e.add(e2);
        this.f67549g++;
        return true;
    }

    public final int f() {
        return this.f67547e.size();
    }

    public final void g() {
        for (int size = this.f67547e.size() - 1; size >= 0; size--) {
            if (this.f67547e.get(size) == null) {
                this.f67547e.remove(size);
            }
        }
    }

    public final void h() {
        int i2 = this.f67548f - 1;
        this.f67548f = i2;
        if (i2 <= 0 && this.f67550h) {
            this.f67550h = false;
            g();
        }
    }

    public final E i(int i2) {
        return this.f67547e.get(i2);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1829b();
    }

    public final void j() {
        this.f67548f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f67547e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f67548f == 0) {
            this.f67547e.remove(indexOf);
        } else {
            this.f67550h = true;
            this.f67547e.set(indexOf, null);
        }
        this.f67549g--;
        return true;
    }
}
