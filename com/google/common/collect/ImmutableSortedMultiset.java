package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import d.g.c.a.n;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.v0;
import d.g.c.f.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements v0<E> {
    public transient ImmutableSortedMultiset<E> descendingMultiset;

    /* loaded from: classes6.dex */
    public static final class SerializedForm<E> implements Serializable {
        public final Comparator<? super E> comparator;
        public final int[] counts;
        public final E[] elements;

        public SerializedForm(v0<E> v0Var) {
            this.comparator = v0Var.comparator();
            int size = v0Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (i0.a<E> aVar : v0Var.entrySet()) {
                this.elements[i] = aVar.getElement();
                this.counts[i] = aVar.getCount();
                i++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i = 0; i < length; i++) {
                aVar.q(this.elements[i], this.counts[i]);
            }
            return aVar.k();
        }
    }

    /* loaded from: classes6.dex */
    public static class a<E> extends ImmutableMultiset.b<E> {

        /* renamed from: d  reason: collision with root package name */
        public final Comparator<? super E> f30837d;

        /* renamed from: e  reason: collision with root package name */
        public E[] f30838e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f30839f;

        /* renamed from: g  reason: collision with root package name */
        public int f30840g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f30841h;

        public a(Comparator<? super E> comparator) {
            super(true);
            n.p(comparator);
            this.f30837d = comparator;
            this.f30838e = (E[]) new Object[4];
            this.f30839f = new int[4];
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b, com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableCollection.b a(Object obj) {
            m(obj);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b f(Object obj) {
            m(obj);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b g(Object[] objArr) {
            n(objArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b h(Iterable iterable) {
            o(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b i(Iterator it) {
            p(it);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.b
        public /* bridge */ /* synthetic */ ImmutableMultiset.b j(Object obj, int i) {
            q(obj, i);
            return this;
        }

        public a<E> m(E e2) {
            q(e2, 1);
            return this;
        }

        public a<E> n(E... eArr) {
            for (E e2 : eArr) {
                m(e2);
            }
            return this;
        }

        public a<E> o(Iterable<? extends E> iterable) {
            if (iterable instanceof i0) {
                for (i0.a<E> aVar : ((i0) iterable).entrySet()) {
                    q(aVar.getElement(), aVar.getCount());
                }
            } else {
                for (E e2 : iterable) {
                    m(e2);
                }
            }
            return this;
        }

        public a<E> p(Iterator<? extends E> it) {
            while (it.hasNext()) {
                m(it.next());
            }
            return this;
        }

        public a<E> q(E e2, int i) {
            n.p(e2);
            m.b(i, "occurrences");
            if (i == 0) {
                return this;
            }
            u();
            E[] eArr = this.f30838e;
            int i2 = this.f30840g;
            eArr[i2] = e2;
            this.f30839f[i2] = i;
            this.f30840g = i2 + 1;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMultiset.b
        /* renamed from: r */
        public ImmutableSortedMultiset<E> k() {
            t();
            int i = this.f30840g;
            if (i == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.f30837d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f30837d, i, this.f30838e);
            long[] jArr = new long[this.f30840g + 1];
            int i2 = 0;
            while (i2 < this.f30840g) {
                int i3 = i2 + 1;
                jArr[i3] = jArr[i2] + this.f30839f[i2];
                i2 = i3;
            }
            this.f30841h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f30840g);
        }

        public final void s(boolean z) {
            int i = this.f30840g;
            if (i == 0) {
                return;
            }
            E[] eArr = (E[]) Arrays.copyOf(this.f30838e, i);
            Arrays.sort(eArr, this.f30837d);
            int i2 = 1;
            for (int i3 = 1; i3 < eArr.length; i3++) {
                if (this.f30837d.compare((Object) eArr[i2 - 1], (Object) eArr[i3]) < 0) {
                    eArr[i2] = eArr[i3];
                    i2++;
                }
            }
            Arrays.fill(eArr, i2, this.f30840g, (Object) null);
            if (z) {
                int i4 = i2 * 4;
                int i5 = this.f30840g;
                if (i4 > i5 * 3) {
                    eArr = (E[]) Arrays.copyOf(eArr, c.e(i5, (i5 / 2) + 1));
                }
            }
            int[] iArr = new int[eArr.length];
            for (int i6 = 0; i6 < this.f30840g; i6++) {
                int binarySearch = Arrays.binarySearch(eArr, 0, i2, this.f30838e[i6], this.f30837d);
                int[] iArr2 = this.f30839f;
                if (iArr2[i6] >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + iArr2[i6];
                } else {
                    iArr[binarySearch] = ~iArr2[i6];
                }
            }
            this.f30838e = eArr;
            this.f30839f = iArr;
            this.f30840g = i2;
        }

        public final void t() {
            s(false);
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = this.f30840g;
                if (i < i3) {
                    int[] iArr = this.f30839f;
                    if (iArr[i] > 0) {
                        E[] eArr = this.f30838e;
                        eArr[i2] = eArr[i];
                        iArr[i2] = iArr[i];
                        i2++;
                    }
                    i++;
                } else {
                    Arrays.fill(this.f30838e, i2, i3, (Object) null);
                    Arrays.fill(this.f30839f, i2, this.f30840g, 0);
                    this.f30840g = i2;
                    return;
                }
            }
        }

        public final void u() {
            int i = this.f30840g;
            E[] eArr = this.f30838e;
            if (i == eArr.length) {
                s(true);
            } else if (this.f30841h) {
                this.f30838e = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.f30841h = false;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(v0<E> v0Var) {
        return copyOfSortedEntries(v0Var.comparator(), Lists.j(v0Var.entrySet()));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<i0.a<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i = 0;
        for (i0.a<E> aVar2 : collection) {
            aVar.h(aVar2.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + aVar2.getCount();
            i = i2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.j(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    @Override // d.g.c.c.v0, d.g.c.c.t0
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public abstract /* synthetic */ int count(Object obj);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract /* synthetic */ i0.a<E> firstEntry();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    public abstract /* synthetic */ i0.a<E> lastEntry();

    @Override // d.g.c.c.v0
    @Deprecated
    public final i0.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.v0
    @Deprecated
    public final i0.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.v0
    public ImmutableSortedMultiset<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        n.l(comparator().compare(e2, e3) <= 0, "Expected lowerBound <= upperBound but %s > %s", e2, e3);
        return tailMultiset((ImmutableSortedMultiset<E>) e2, boundType).headMultiset((ImmutableSortedMultiset<E>) e3, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        n.p(comparator);
        a aVar = new a(comparator);
        aVar.p(it);
        return aVar.k();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        a aVar = new a(comparator);
        aVar.o(iterable);
        return aVar.k();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList l = Lists.l(comparableArr.length + 6);
        Collections.addAll(l, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(l, comparableArr);
        return copyOf(Ordering.natural(), l);
    }
}
