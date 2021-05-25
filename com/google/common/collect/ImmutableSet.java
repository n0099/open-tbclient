package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.e0;
import d.g.c.c.j0;
import d.g.c.c.m;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    public static final int CUTOFF = 751619276;
    public static final double DESIRED_LOAD_FACTOR = 0.7d;
    public static final int MAX_TABLE_SIZE = 1073741824;
    public transient ImmutableList<E> asList;

    /* loaded from: classes6.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* loaded from: classes6.dex */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* renamed from: d  reason: collision with root package name */
        public Object[] f31059d;

        /* renamed from: e  reason: collision with root package name */
        public int f31060e;

        public a() {
            super(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: h */
        public a<E> a(E e2) {
            n.p(e2);
            if (this.f31059d != null && ImmutableSet.chooseTableSize(this.f31013b) <= this.f31059d.length) {
                k(e2);
                return this;
            }
            this.f31059d = null;
            super.f(e2);
            return this;
        }

        public a<E> i(E... eArr) {
            if (this.f31059d != null) {
                for (E e2 : eArr) {
                    a(e2);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        public a<E> j(Iterator<? extends E> it) {
            n.p(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public final void k(E e2) {
            int length = this.f31059d.length - 1;
            int hashCode = e2.hashCode();
            int c2 = e0.c(hashCode);
            while (true) {
                int i2 = c2 & length;
                Object[] objArr = this.f31059d;
                Object obj = objArr[i2];
                if (obj == null) {
                    objArr[i2] = e2;
                    this.f31060e += hashCode;
                    super.f(e2);
                    return;
                } else if (obj.equals(e2)) {
                    return;
                } else {
                    c2 = i2 + 1;
                }
            }
        }

        public ImmutableSet<E> l() {
            ImmutableSet<E> construct;
            int i2 = this.f31013b;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (this.f31059d == null || ImmutableSet.chooseTableSize(i2) != this.f31059d.length) {
                        construct = ImmutableSet.construct(this.f31013b, this.f31012a);
                        this.f31013b = construct.size();
                    } else {
                        Object[] copyOf = ImmutableSet.shouldTrim(this.f31013b, this.f31012a.length) ? Arrays.copyOf(this.f31012a, this.f31013b) : this.f31012a;
                        int i3 = this.f31060e;
                        Object[] objArr = this.f31059d;
                        construct = new RegularImmutableSet<>(copyOf, i3, objArr, objArr.length - 1, this.f31013b);
                    }
                    this.f31014c = true;
                    this.f31059d = null;
                    return construct;
                }
                return ImmutableSet.of(this.f31012a[0]);
            }
            return ImmutableSet.of();
        }

        public a(int i2) {
            super(i2);
            this.f31059d = new Object[ImmutableSet.chooseTableSize(i2)];
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i2) {
        m.b(i2, "expectedSize");
        return new a<>(i2);
    }

    public static int chooseTableSize(int i2) {
        int max = Math.max(i2, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        n.e(max < 1073741824, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> construct(int i2, Object... objArr) {
        if (i2 != 0) {
            if (i2 != 1) {
                int chooseTableSize = chooseTableSize(i2);
                Object[] objArr2 = new Object[chooseTableSize];
                int i3 = chooseTableSize - 1;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    Object obj = objArr[i6];
                    j0.a(obj, i6);
                    int hashCode = obj.hashCode();
                    int c2 = e0.c(hashCode);
                    while (true) {
                        int i7 = c2 & i3;
                        Object obj2 = objArr2[i7];
                        if (obj2 == null) {
                            objArr[i5] = obj;
                            objArr2[i7] = obj;
                            i4 += hashCode;
                            i5++;
                            break;
                        } else if (obj2.equals(obj)) {
                            break;
                        } else {
                            c2++;
                        }
                    }
                }
                Arrays.fill(objArr, i5, i2, (Object) null);
                if (i5 == 1) {
                    return new SingletonImmutableSet(objArr[0], i4);
                }
                if (chooseTableSize(i5) < chooseTableSize / 2) {
                    return construct(i5, objArr);
                }
                if (shouldTrim(i5, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i5);
                }
                return new RegularImmutableSet(objArr, i4, objArr2, i3, i5);
            }
            return of(objArr[0]);
        }
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static boolean shouldTrim(int i2, int i3) {
        return i2 < (i3 >> 1) + (i3 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> createAsList = createAsList();
            this.asList = createAsList;
            return createAsList;
        }
        return immutableList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract c1<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e2) {
        return new SingletonImmutableSet(e2);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3) {
        return construct(2, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4) {
        return construct(3, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5) {
        return construct(4, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6) {
        return construct(5, e2, e3, e4, e5, e6);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        n.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        a aVar = new a();
        aVar.a(next);
        aVar.j(it);
        return aVar.l();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            if (length != 1) {
                return construct(eArr.length, (Object[]) eArr.clone());
            }
            return of((Object) eArr[0]);
        }
        return of();
    }
}
