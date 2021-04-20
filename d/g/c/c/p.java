package d.g.c.c;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import d.g.c.c.i0;
import d.g.c.c.w0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class p<E> extends x<E> implements v0<E> {

    /* renamed from: e  reason: collision with root package name */
    public transient Comparator<? super E> f67005e;

    /* renamed from: f  reason: collision with root package name */
    public transient NavigableSet<E> f67006f;

    /* renamed from: g  reason: collision with root package name */
    public transient Set<i0.a<E>> f67007g;

    /* loaded from: classes6.dex */
    public class a extends Multisets.d<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.d
        public i0<E> b() {
            return p.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<i0.a<E>> iterator() {
            return p.this.c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.d().entrySet().size();
        }
    }

    public Set<i0.a<E>> b() {
        return new a();
    }

    public abstract Iterator<i0.a<E>> c();

    @Override // d.g.c.c.v0, d.g.c.c.t0
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f67005e;
        if (comparator == null) {
            Ordering reverse = Ordering.from(d().comparator()).reverse();
            this.f67005e = reverse;
            return reverse;
        }
        return comparator;
    }

    public abstract v0<E> d();

    @Override // d.g.c.c.v0
    public v0<E> descendingMultiset() {
        return d();
    }

    @Override // d.g.c.c.x, d.g.c.c.i0
    public Set<i0.a<E>> entrySet() {
        Set<i0.a<E>> set = this.f67007g;
        if (set == null) {
            Set<i0.a<E>> b2 = b();
            this.f67007g = b2;
            return b2;
        }
        return set;
    }

    @Override // d.g.c.c.v0
    public i0.a<E> firstEntry() {
        return d().lastEntry();
    }

    @Override // d.g.c.c.v0
    public v0<E> headMultiset(E e2, BoundType boundType) {
        return d().tailMultiset(e2, boundType).descendingMultiset();
    }

    @Override // d.g.c.c.v0
    public i0.a<E> lastEntry() {
        return d().firstEntry();
    }

    @Override // d.g.c.c.v0
    public i0.a<E> pollFirstEntry() {
        return d().pollLastEntry();
    }

    @Override // d.g.c.c.v0
    public i0.a<E> pollLastEntry() {
        return d().pollFirstEntry();
    }

    @Override // d.g.c.c.v0
    public v0<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        return d().subMultiset(e3, boundType2, e2, boundType).descendingMultiset();
    }

    @Override // d.g.c.c.v0
    public v0<E> tailMultiset(E e2, BoundType boundType) {
        return d().headMultiset(e2, boundType).descendingMultiset();
    }

    @Override // d.g.c.c.r, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // d.g.c.c.y
    public String toString() {
        return entrySet().toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.x, d.g.c.c.i0
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f67006f;
        if (navigableSet == null) {
            w0.b bVar = new w0.b(this);
            this.f67006f = bVar;
            return bVar;
        }
        return navigableSet;
    }

    @Override // d.g.c.c.r, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.x, d.g.c.c.r, d.g.c.c.y
    public i0<E> delegate() {
        return d();
    }
}
