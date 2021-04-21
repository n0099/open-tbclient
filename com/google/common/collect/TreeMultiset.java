package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import d.h.c.a.j;
import d.h.c.a.n;
import d.h.c.c.f0;
import d.h.c.c.h;
import d.h.c.c.i0;
import d.h.c.c.m;
import d.h.c.c.r0;
import d.h.c.c.v0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class TreeMultiset<E> extends h<E> implements Serializable {
    public static final long serialVersionUID = 1;
    public final transient e<E> header;
    public final transient GeneralRange<E> range;
    public final transient f<e<E>> rootReference;

    /* loaded from: classes6.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return eVar.f31156b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f31158d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public int nodeAggregate(e<?> eVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f31157c;
            }
        };

        public abstract int nodeAggregate(e<?> eVar);

        public abstract long treeAggregate(e<?> eVar);

        /* synthetic */ Aggregate(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends Multisets.b<E> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f31146e;

        public a(e eVar) {
            this.f31146e = eVar;
        }

        @Override // d.h.c.c.i0.a
        public int getCount() {
            int x = this.f31146e.x();
            return x == 0 ? TreeMultiset.this.count(getElement()) : x;
        }

        @Override // d.h.c.c.i0.a
        public E getElement() {
            return (E) this.f31146e.y();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Iterator<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f31148e;

        /* renamed from: f  reason: collision with root package name */
        public i0.a<E> f31149f;

        public b() {
            this.f31148e = TreeMultiset.this.firstNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public i0.a<E> next() {
            if (hasNext()) {
                i0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f31148e);
                this.f31149f = wrapEntry;
                if (this.f31148e.i != TreeMultiset.this.header) {
                    this.f31148e = this.f31148e.i;
                } else {
                    this.f31148e = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31148e == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooHigh(this.f31148e.y())) {
                this.f31148e = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31149f != null);
            TreeMultiset.this.setCount(this.f31149f.getElement(), 0);
            this.f31149f = null;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Iterator<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f31151e;

        /* renamed from: f  reason: collision with root package name */
        public i0.a<E> f31152f = null;

        public c() {
            this.f31151e = TreeMultiset.this.lastNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public i0.a<E> next() {
            if (hasNext()) {
                i0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f31151e);
                this.f31152f = wrapEntry;
                if (this.f31151e.f31162h != TreeMultiset.this.header) {
                    this.f31151e = this.f31151e.f31162h;
                } else {
                    this.f31151e = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31151e == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooLow(this.f31151e.y())) {
                this.f31151e = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31152f != null);
            TreeMultiset.this.setCount(this.f31152f.getElement(), 0);
            this.f31152f = null;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31154a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f31154a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31154a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f31155a;

        /* renamed from: b  reason: collision with root package name */
        public int f31156b;

        /* renamed from: c  reason: collision with root package name */
        public int f31157c;

        /* renamed from: d  reason: collision with root package name */
        public long f31158d;

        /* renamed from: e  reason: collision with root package name */
        public int f31159e;

        /* renamed from: f  reason: collision with root package name */
        public e<E> f31160f;

        /* renamed from: g  reason: collision with root package name */
        public e<E> f31161g;

        /* renamed from: h  reason: collision with root package name */
        public e<E> f31162h;
        public e<E> i;

        public e(E e2, int i) {
            n.d(i > 0);
            this.f31155a = e2;
            this.f31156b = i;
            this.f31158d = i;
            this.f31157c = 1;
            this.f31159e = 1;
            this.f31160f = null;
            this.f31161g = null;
        }

        public static long L(e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f31158d;
        }

        public static int z(e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f31159e;
        }

        public final e<E> A() {
            int s = s();
            if (s == -2) {
                if (this.f31161g.s() > 0) {
                    this.f31161g = this.f31161g.I();
                }
                return H();
            } else if (s != 2) {
                C();
                return this;
            } else {
                if (this.f31160f.s() < 0) {
                    this.f31160f = this.f31160f.H();
                }
                return I();
            }
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f31159e = Math.max(z(this.f31160f), z(this.f31161g)) + 1;
        }

        public final void D() {
            this.f31157c = TreeMultiset.distinctElements(this.f31160f) + 1 + TreeMultiset.distinctElements(this.f31161g);
            this.f31158d = this.f31156b + L(this.f31160f) + L(this.f31161g);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e2, int i, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare < 0) {
                e<E> eVar = this.f31160f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f31160f = eVar.E(comparator, e2, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.f31157c--;
                        this.f31158d -= iArr[0];
                    } else {
                        this.f31158d -= i;
                    }
                }
                return iArr[0] == 0 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31161g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f31161g = eVar2.E(comparator, e2, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.f31157c--;
                        this.f31158d -= iArr[0];
                    } else {
                        this.f31158d -= i;
                    }
                }
                return A();
            } else {
                int i2 = this.f31156b;
                iArr[0] = i2;
                if (i >= i2) {
                    return v();
                }
                this.f31156b = i2 - i;
                this.f31158d -= i;
                return this;
            }
        }

        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f31161g;
            if (eVar2 == null) {
                return this.f31160f;
            }
            this.f31161g = eVar2.F(eVar);
            this.f31157c--;
            this.f31158d -= eVar.f31156b;
            return A();
        }

        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f31160f;
            if (eVar2 == null) {
                return this.f31161g;
            }
            this.f31160f = eVar2.G(eVar);
            this.f31157c--;
            this.f31158d -= eVar.f31156b;
            return A();
        }

        public final e<E> H() {
            n.w(this.f31161g != null);
            e<E> eVar = this.f31161g;
            this.f31161g = eVar.f31160f;
            eVar.f31160f = this;
            eVar.f31158d = this.f31158d;
            eVar.f31157c = this.f31157c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            n.w(this.f31160f != null);
            e<E> eVar = this.f31160f;
            this.f31160f = eVar.f31161g;
            eVar.f31161g = this;
            eVar.f31158d = this.f31158d;
            eVar.f31157c = this.f31157c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> J(Comparator<? super E> comparator, E e2, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare < 0) {
                e<E> eVar = this.f31160f;
                if (eVar == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        q(e2, i2);
                    }
                    return this;
                }
                this.f31160f = eVar.J(comparator, e2, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f31157c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f31157c++;
                    }
                    this.f31158d += i2 - iArr[0];
                }
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31161g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    if (i == 0 && i2 > 0) {
                        r(e2, i2);
                    }
                    return this;
                }
                this.f31161g = eVar2.J(comparator, e2, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.f31157c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.f31157c++;
                    }
                    this.f31158d += i2 - iArr[0];
                }
                return A();
            } else {
                int i3 = this.f31156b;
                iArr[0] = i3;
                if (i == i3) {
                    if (i2 == 0) {
                        return v();
                    }
                    this.f31158d += i2 - i3;
                    this.f31156b = i2;
                }
                return this;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e2, int i, int[] iArr) {
            int i2;
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare < 0) {
                e<E> eVar = this.f31160f;
                if (eVar == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        q(e2, i);
                    }
                    return this;
                }
                this.f31160f = eVar.K(comparator, e2, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.f31157c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.f31157c++;
                }
                this.f31158d += i - iArr[0];
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31161g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    if (i > 0) {
                        r(e2, i);
                    }
                    return this;
                }
                this.f31161g = eVar2.K(comparator, e2, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.f31157c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.f31157c++;
                }
                this.f31158d += i - iArr[0];
                return A();
            } else {
                iArr[0] = this.f31156b;
                if (i == 0) {
                    return v();
                }
                this.f31158d += i - i2;
                this.f31156b = i;
                return this;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> p(Comparator<? super E> comparator, E e2, int i, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare < 0) {
                e<E> eVar = this.f31160f;
                if (eVar == null) {
                    iArr[0] = 0;
                    q(e2, i);
                    return this;
                }
                int i2 = eVar.f31159e;
                this.f31160f = eVar.p(comparator, e2, i, iArr);
                if (iArr[0] == 0) {
                    this.f31157c++;
                }
                this.f31158d += i;
                return this.f31160f.f31159e == i2 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31161g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    r(e2, i);
                    return this;
                }
                int i3 = eVar2.f31159e;
                this.f31161g = eVar2.p(comparator, e2, i, iArr);
                if (iArr[0] == 0) {
                    this.f31157c++;
                }
                this.f31158d += i;
                return this.f31161g.f31159e == i3 ? this : A();
            } else {
                int i4 = this.f31156b;
                iArr[0] = i4;
                long j = i;
                n.d(((long) i4) + j <= 2147483647L);
                this.f31156b += i;
                this.f31158d += j;
                return this;
            }
        }

        public final e<E> q(E e2, int i) {
            e<E> eVar = new e<>(e2, i);
            this.f31160f = eVar;
            TreeMultiset.successor(this.f31162h, eVar, this);
            this.f31159e = Math.max(2, this.f31159e);
            this.f31157c++;
            this.f31158d += i;
            return this;
        }

        public final e<E> r(E e2, int i) {
            e<E> eVar = new e<>(e2, i);
            this.f31161g = eVar;
            TreeMultiset.successor(this, eVar, this.i);
            this.f31159e = Math.max(2, this.f31159e);
            this.f31157c++;
            this.f31158d += i;
            return this;
        }

        public final int s() {
            return z(this.f31160f) - z(this.f31161g);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> t(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare < 0) {
                e<E> eVar = this.f31160f;
                return eVar == null ? this : (e) j.a(eVar.t(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f31161g;
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.t(comparator, e2);
            }
        }

        public String toString() {
            return Multisets.g(y(), x()).toString();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public int u(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare < 0) {
                e<E> eVar = this.f31160f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.u(comparator, e2);
            } else if (compare > 0) {
                e<E> eVar2 = this.f31161g;
                if (eVar2 == null) {
                    return 0;
                }
                return eVar2.u(comparator, e2);
            } else {
                return this.f31156b;
            }
        }

        public final e<E> v() {
            int i = this.f31156b;
            this.f31156b = 0;
            TreeMultiset.successor(this.f31162h, this.i);
            e<E> eVar = this.f31160f;
            if (eVar == null) {
                return this.f31161g;
            }
            e<E> eVar2 = this.f31161g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f31159e >= eVar2.f31159e) {
                e<E> eVar3 = this.f31162h;
                eVar3.f31160f = eVar.F(eVar3);
                eVar3.f31161g = this.f31161g;
                eVar3.f31157c = this.f31157c - 1;
                eVar3.f31158d = this.f31158d - i;
                return eVar3.A();
            }
            e<E> eVar4 = this.i;
            eVar4.f31161g = eVar2.G(eVar4);
            eVar4.f31160f = this.f31160f;
            eVar4.f31157c = this.f31157c - 1;
            eVar4.f31158d = this.f31158d - i;
            return eVar4.A();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> w(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31155a);
            if (compare > 0) {
                e<E> eVar = this.f31161g;
                return eVar == null ? this : (e) j.a(eVar.w(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f31160f;
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.w(comparator, e2);
            }
        }

        public int x() {
            return this.f31156b;
        }

        public E y() {
            return this.f31155a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class f<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f31163a;

        public f() {
        }

        public void a(T t, T t2) {
            if (this.f31163a == t) {
                this.f31163a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        public void b() {
            this.f31163a = null;
        }

        public T c() {
            return this.f31163a;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public TreeMultiset(f<e<E>> fVar, GeneralRange<E> generalRange, e<E> eVar) {
        super(generalRange.comparator());
        this.rootReference = fVar;
        this.range = generalRange;
        this.header = eVar;
    }

    private long aggregateAboveRange(Aggregate aggregate, e<E> eVar) {
        long treeAggregate;
        long aggregateAboveRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getUpperEndpoint(), eVar.f31155a);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, eVar.f31161g);
        }
        if (compare == 0) {
            int i = d.f31154a[this.range.getUpperBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(eVar.f31161g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregate.treeAggregate(eVar.f31161g);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f31161g) + aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f31160f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), eVar.f31155a);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, eVar.f31160f);
        }
        if (compare == 0) {
            int i = d.f31154a[this.range.getLowerBoundType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return aggregate.treeAggregate(eVar.f31160f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregate.treeAggregate(eVar.f31160f);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f31160f) + aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f31161g);
        }
        return treeAggregate + aggregateBelowRange;
    }

    private long aggregateForEntries(Aggregate aggregate) {
        e<E> c2 = this.rootReference.c();
        long treeAggregate = aggregate.treeAggregate(c2);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, c2);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, c2) : treeAggregate;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> firstNode() {
        e<E> eVar;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (!this.range.hasLowerBound()) {
            eVar = this.header.i;
        } else {
            E lowerEndpoint = this.range.getLowerEndpoint();
            eVar = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, eVar.y()) == 0) {
                eVar = eVar.i;
            }
        }
        if (eVar == this.header || !this.range.contains(eVar.y())) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e<E> lastNode() {
        e<E> eVar;
        if (this.rootReference.c() == null) {
            return null;
        }
        if (!this.range.hasUpperBound()) {
            eVar = this.header.f31162h;
        } else {
            E upperEndpoint = this.range.getUpperEndpoint();
            eVar = this.rootReference.c().w(comparator(), upperEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, eVar.y()) == 0) {
                eVar = eVar.f31162h;
            }
        }
        if (eVar == this.header || !this.range.contains(eVar.y())) {
            return null;
        }
        return eVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        r0.a(h.class, "comparator").b(this, comparator);
        r0.a(TreeMultiset.class, "range").b(this, GeneralRange.all(comparator));
        r0.a(TreeMultiset.class, "rootReference").b(this, new f(null));
        e eVar = new e(null, 1);
        r0.a(TreeMultiset.class, "header").b(this, eVar);
        successor(eVar, eVar);
        r0.f(this, objectInputStream);
    }

    public static <T> void successor(e<T> eVar, e<T> eVar2) {
        eVar.i = eVar2;
        eVar2.f31162h = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i0.a<E> wrapEntry(e<E> eVar) {
        return new a(eVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        r0.k(this, objectOutputStream);
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public int add(E e2, int i) {
        m.b(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        n.d(this.range.contains(e2));
        e<E> c2 = this.rootReference.c();
        if (c2 == null) {
            comparator().compare(e2, e2);
            e<E> eVar = new e<>(e2, i);
            e<E> eVar2 = this.header;
            successor(eVar2, eVar, eVar2);
            this.rootReference.a(c2, eVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c2, c2.p(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (!this.range.hasLowerBound() && !this.range.hasUpperBound()) {
            e<E> eVar = this.header.i;
            while (true) {
                e<E> eVar2 = this.header;
                if (eVar != eVar2) {
                    e<E> eVar3 = eVar.i;
                    eVar.f31156b = 0;
                    eVar.f31160f = null;
                    eVar.f31161g = null;
                    eVar.f31162h = null;
                    eVar.i = null;
                    eVar = eVar3;
                } else {
                    successor(eVar2, eVar2);
                    this.rootReference.b();
                    return;
                }
            }
        } else {
            Iterators.d(entryIterator());
        }
    }

    @Override // d.h.c.c.h, d.h.c.c.v0, d.h.c.c.t0
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection, d.h.c.c.i0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.h.c.c.i0
    public int count(Object obj) {
        try {
            e<E> c2 = this.rootReference.c();
            if (this.range.contains(obj) && c2 != null) {
                return c2.u(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // d.h.c.c.h
    public Iterator<i0.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // d.h.c.c.h, d.h.c.c.v0
    public /* bridge */ /* synthetic */ v0 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // d.h.c.c.d
    public int distinctElements() {
        return Ints.j(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // d.h.c.c.d
    public Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // d.h.c.c.h, d.h.c.c.d, d.h.c.c.i0
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // d.h.c.c.d
    public Iterator<i0.a<E>> entryIterator() {
        return new b();
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // d.h.c.c.h, d.h.c.c.v0
    public /* bridge */ /* synthetic */ i0.a firstEntry() {
        return super.firstEntry();
    }

    @Override // d.h.c.c.v0
    public v0<E> headMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.header);
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.h.c.c.i0
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // d.h.c.c.h, d.h.c.c.v0
    public /* bridge */ /* synthetic */ i0.a lastEntry() {
        return super.lastEntry();
    }

    @Override // d.h.c.c.h, d.h.c.c.v0
    public /* bridge */ /* synthetic */ i0.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // d.h.c.c.h, d.h.c.c.v0
    public /* bridge */ /* synthetic */ i0.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public int remove(Object obj, int i) {
        m.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        e<E> c2 = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && c2 != null) {
                this.rootReference.a(c2, c2.E(comparator(), obj, i, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public int setCount(E e2, int i) {
        m.b(i, "count");
        if (!this.range.contains(e2)) {
            n.d(i == 0);
            return 0;
        }
        e<E> c2 = this.rootReference.c();
        if (c2 == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c2, c2.K(comparator(), e2, i, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.h.c.c.i0
    public int size() {
        return Ints.j(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.h, d.h.c.c.v0
    public /* bridge */ /* synthetic */ v0 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // d.h.c.c.v0
    public v0<E> tailMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e2, boundType)), this.header);
    }

    public static <E> TreeMultiset<E> create(Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static int distinctElements(e<?> eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f31157c;
    }

    public static <T> void successor(e<T> eVar, e<T> eVar2, e<T> eVar3) {
        successor(eVar, eVar2);
        successor(eVar2, eVar3);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        f0.a(create, iterable);
        return create;
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        e<E> eVar = new e<>(null, 1);
        this.header = eVar;
        successor(eVar, eVar);
        this.rootReference = new f<>(null);
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public boolean setCount(E e2, int i, int i2) {
        m.b(i2, "newCount");
        m.b(i, "oldCount");
        n.d(this.range.contains(e2));
        e<E> c2 = this.rootReference.c();
        if (c2 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c2, c2.J(comparator(), e2, i, i2, iArr));
            return iArr[0] == i;
        } else if (i == 0) {
            if (i2 > 0) {
                add(e2, i2);
            }
            return true;
        } else {
            return false;
        }
    }
}
