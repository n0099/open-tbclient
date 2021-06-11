package d.g.c.c;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class q<E> implements Iterable<E> {

    /* renamed from: e  reason: collision with root package name */
    public final Optional<Iterable<E>> f70032e;

    /* loaded from: classes6.dex */
    public static class a extends q<E> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f70033f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f70033f = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f70033f.iterator();
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends q<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable[] f70034f;

        /* loaded from: classes6.dex */
        public class a extends d.g.c.c.a<Iterator<? extends T>> {
            public a(int i2) {
                super(i2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a
            /* renamed from: b */
            public Iterator<? extends T> a(int i2) {
                return b.this.f70034f[i2].iterator();
            }
        }

        public b(Iterable[] iterableArr) {
            this.f70034f = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.e(new a(this.f70034f.length));
        }
    }

    public q() {
        this.f70032e = Optional.absent();
    }

    public static <T> q<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    public static <T> q<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            d.g.c.a.n.p(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> q<E> d(Iterable<E> iterable) {
        return iterable instanceof q ? (q) iterable : new a(iterable, iterable);
    }

    public final q<E> c(d.g.c.a.o<? super E> oVar) {
        return d(f0.d(e(), oVar));
    }

    public final Iterable<E> e() {
        return this.f70032e.or((Optional<Iterable<E>>) this);
    }

    public final ImmutableSet<E> f() {
        return ImmutableSet.copyOf(e());
    }

    public String toString() {
        return f0.m(e());
    }

    public q(Iterable<E> iterable) {
        d.g.c.a.n.p(iterable);
        this.f70032e = Optional.fromNullable(this == iterable ? null : iterable);
    }
}
