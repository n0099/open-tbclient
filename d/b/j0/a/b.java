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
    public final List<E> f63784e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f63785f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63786g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63787h = false;

    /* renamed from: d.b.j0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1729b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f63788e;

        /* renamed from: f  reason: collision with root package name */
        public int f63789f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f63790g;

        public final void a() {
            if (this.f63790g) {
                return;
            }
            this.f63790g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i = this.f63789f;
            while (i < this.f63788e && b.this.i(i) == null) {
                i++;
            }
            if (i < this.f63788e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i = this.f63789f;
                if (i >= this.f63788e || b.this.i(i) != null) {
                    break;
                }
                this.f63789f++;
            }
            int i2 = this.f63789f;
            if (i2 < this.f63788e) {
                b bVar = b.this;
                this.f63789f = i2 + 1;
                return (E) bVar.i(i2);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1729b() {
            this.f63789f = 0;
            this.f63790g = false;
            b.this.j();
            this.f63788e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f63784e.contains(e2)) {
            return false;
        }
        this.f63784e.add(e2);
        this.f63786g++;
        return true;
    }

    public final int f() {
        return this.f63784e.size();
    }

    public final void g() {
        for (int size = this.f63784e.size() - 1; size >= 0; size--) {
            if (this.f63784e.get(size) == null) {
                this.f63784e.remove(size);
            }
        }
    }

    public final void h() {
        int i = this.f63785f - 1;
        this.f63785f = i;
        if (i <= 0 && this.f63787h) {
            this.f63787h = false;
            g();
        }
    }

    public final E i(int i) {
        return this.f63784e.get(i);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1729b();
    }

    public final void j() {
        this.f63785f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f63784e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f63785f == 0) {
            this.f63784e.remove(indexOf);
        } else {
            this.f63787h = true;
            this.f63784e.set(indexOf, null);
        }
        this.f63786g--;
        return true;
    }
}
