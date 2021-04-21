package d.h.c.c;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class f0 {

    /* loaded from: classes6.dex */
    public static class a extends q<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f67124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.h.c.a.o f67125g;

        public a(Iterable iterable, d.h.c.a.o oVar) {
            this.f67124f = iterable;
            this.f67125g = oVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.k(this.f67124f.iterator(), this.f67125g);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends q<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f67126f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.h.c.a.g f67127g;

        public b(Iterable iterable, d.h.c.a.g gVar) {
            this.f67126f = iterable;
            this.f67127g = gVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.w(this.f67126f.iterator(), this.f67127g);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends q<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f67128f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f67129g;

        /* loaded from: classes6.dex */
        public class a implements Iterator<T> {

            /* renamed from: e  reason: collision with root package name */
            public boolean f67130e = true;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Iterator f67131f;

            public a(c cVar, Iterator it) {
                this.f67131f = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f67131f.hasNext();
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // java.util.Iterator
            public T next() {
                ?? next = this.f67131f.next();
                this.f67130e = false;
                return next;
            }

            @Override // java.util.Iterator
            public void remove() {
                m.e(!this.f67130e);
                this.f67131f.remove();
            }
        }

        public c(Iterable iterable, int i) {
            this.f67128f = iterable;
            this.f67129g = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f67128f;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f67129g), list.size()).iterator();
            }
            Iterator it = iterable.iterator();
            Iterators.b(it, this.f67129g);
            return new a(this, it);
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(n.a(iterable));
        }
        d.h.c.a.n.p(iterable);
        return Iterators.a(collection, iterable.iterator());
    }

    public static <E> Collection<E> b(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.k(iterable.iterator());
    }

    public static <T> Iterable<T> c(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return q.a(iterable, iterable2);
    }

    public static <T> Iterable<T> d(Iterable<T> iterable, d.h.c.a.o<? super T> oVar) {
        d.h.c.a.n.p(iterable);
        d.h.c.a.n.p(oVar);
        return new a(iterable, oVar);
    }

    public static <T> T e(Iterable<? extends T> iterable, T t) {
        return (T) Iterators.m(iterable.iterator(), t);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) g(list);
            }
            throw new NoSuchElementException();
        }
        return (T) Iterators.l(iterable.iterator());
    }

    public static <T> T g(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T h(Iterable<T> iterable) {
        return (T) Iterators.n(iterable.iterator());
    }

    public static boolean i(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> j(Iterable<T> iterable, int i) {
        d.h.c.a.n.p(iterable);
        d.h.c.a.n.e(i >= 0, "number to skip cannot be negative");
        return new c(iterable, i);
    }

    public static Object[] k(Iterable<?> iterable) {
        return b(iterable).toArray();
    }

    public static <T> T[] l(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) b(iterable).toArray(tArr);
    }

    public static String m(Iterable<?> iterable) {
        return Iterators.v(iterable.iterator());
    }

    public static <F, T> Iterable<T> n(Iterable<F> iterable, d.h.c.a.g<? super F, ? extends T> gVar) {
        d.h.c.a.n.p(iterable);
        d.h.c.a.n.p(gVar);
        return new b(iterable, gVar);
    }
}
