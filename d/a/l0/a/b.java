package d.a.l0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f63779e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f63780f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63781g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63782h = false;

    /* renamed from: d.a.l0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1763b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f63783e;

        /* renamed from: f  reason: collision with root package name */
        public int f63784f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f63785g;

        public final void a() {
            if (this.f63785g) {
                return;
            }
            this.f63785g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i2 = this.f63784f;
            while (i2 < this.f63783e && b.this.i(i2) == null) {
                i2++;
            }
            if (i2 < this.f63783e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i2 = this.f63784f;
                if (i2 >= this.f63783e || b.this.i(i2) != null) {
                    break;
                }
                this.f63784f++;
            }
            int i3 = this.f63784f;
            if (i3 < this.f63783e) {
                b bVar = b.this;
                this.f63784f = i3 + 1;
                return (E) bVar.i(i3);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1763b() {
            this.f63784f = 0;
            this.f63785g = false;
            b.this.j();
            this.f63783e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f63779e.contains(e2)) {
            return false;
        }
        this.f63779e.add(e2);
        this.f63781g++;
        return true;
    }

    public final int f() {
        return this.f63779e.size();
    }

    public final void g() {
        for (int size = this.f63779e.size() - 1; size >= 0; size--) {
            if (this.f63779e.get(size) == null) {
                this.f63779e.remove(size);
            }
        }
    }

    public final void h() {
        int i2 = this.f63780f - 1;
        this.f63780f = i2;
        if (i2 <= 0 && this.f63782h) {
            this.f63782h = false;
            g();
        }
    }

    public final E i(int i2) {
        return this.f63779e.get(i2);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1763b();
    }

    public final void j() {
        this.f63780f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f63779e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f63780f == 0) {
            this.f63779e.remove(indexOf);
        } else {
            this.f63782h = true;
            this.f63779e.set(indexOf, null);
        }
        this.f63781g--;
        return true;
    }
}
