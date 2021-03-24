package d.b.j0.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes.dex */
public class b<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final List<E> f63783e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f63784f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63785g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63786h = false;

    /* renamed from: d.b.j0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1728b implements Object<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f63787e;

        /* renamed from: f  reason: collision with root package name */
        public int f63788f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f63789g;

        public final void a() {
            if (this.f63789g) {
                return;
            }
            this.f63789g = true;
            b.this.h();
        }

        public boolean hasNext() {
            int i = this.f63788f;
            while (i < this.f63787e && b.this.i(i) == null) {
                i++;
            }
            if (i < this.f63787e) {
                return true;
            }
            a();
            return false;
        }

        public E next() {
            while (true) {
                int i = this.f63788f;
                if (i >= this.f63787e || b.this.i(i) != null) {
                    break;
                }
                this.f63788f++;
            }
            int i2 = this.f63788f;
            if (i2 < this.f63787e) {
                b bVar = b.this;
                this.f63788f = i2 + 1;
                return (E) bVar.i(i2);
            }
            a();
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public C1728b() {
            this.f63788f = 0;
            this.f63789g = false;
            b.this.j();
            this.f63787e = b.this.f();
        }
    }

    public boolean e(E e2) {
        if (e2 == null || this.f63783e.contains(e2)) {
            return false;
        }
        this.f63783e.add(e2);
        this.f63785g++;
        return true;
    }

    public final int f() {
        return this.f63783e.size();
    }

    public final void g() {
        for (int size = this.f63783e.size() - 1; size >= 0; size--) {
            if (this.f63783e.get(size) == null) {
                this.f63783e.remove(size);
            }
        }
    }

    public final void h() {
        int i = this.f63784f - 1;
        this.f63784f = i;
        if (i <= 0 && this.f63786h) {
            this.f63786h = false;
            g();
        }
    }

    public final E i(int i) {
        return this.f63783e.get(i);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new C1728b();
    }

    public final void j() {
        this.f63784f++;
    }

    public boolean k(E e2) {
        int indexOf;
        if (e2 == null || (indexOf = this.f63783e.indexOf(e2)) == -1) {
            return false;
        }
        if (this.f63784f == 0) {
            this.f63783e.remove(indexOf);
        } else {
            this.f63786h = true;
            this.f63783e.set(indexOf, null);
        }
        this.f63785g--;
        return true;
    }
}
