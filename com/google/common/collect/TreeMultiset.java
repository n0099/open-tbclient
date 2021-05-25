package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import d.g.c.a.j;
import d.g.c.a.n;
import d.g.c.c.f0;
import d.g.c.c.h;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.r0;
import d.g.c.c.v0;
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
                return eVar.f31304b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f31306d;
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
                return eVar.f31305c;
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
        public final /* synthetic */ e f31294e;

        public a(e eVar) {
            this.f31294e = eVar;
        }

        @Override // d.g.c.c.i0.a
        public int getCount() {
            int x = this.f31294e.x();
            return x == 0 ? TreeMultiset.this.count(getElement()) : x;
        }

        @Override // d.g.c.c.i0.a
        public E getElement() {
            return (E) this.f31294e.y();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Iterator<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f31296e;

        /* renamed from: f  reason: collision with root package name */
        public i0.a<E> f31297f;

        public b() {
            this.f31296e = TreeMultiset.this.firstNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public i0.a<E> next() {
            if (hasNext()) {
                i0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f31296e);
                this.f31297f = wrapEntry;
                if (this.f31296e.f31311i != TreeMultiset.this.header) {
                    this.f31296e = this.f31296e.f31311i;
                } else {
                    this.f31296e = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31296e == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooHigh(this.f31296e.y())) {
                this.f31296e = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31297f != null);
            TreeMultiset.this.setCount(this.f31297f.getElement(), 0);
            this.f31297f = null;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Iterator<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f31299e;

        /* renamed from: f  reason: collision with root package name */
        public i0.a<E> f31300f = null;

        public c() {
            this.f31299e = TreeMultiset.this.lastNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public i0.a<E> next() {
            if (hasNext()) {
                i0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f31299e);
                this.f31300f = wrapEntry;
                if (this.f31299e.f31310h != TreeMultiset.this.header) {
                    this.f31299e = this.f31299e.f31310h;
                } else {
                    this.f31299e = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31299e == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooLow(this.f31299e.y())) {
                this.f31299e = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31300f != null);
            TreeMultiset.this.setCount(this.f31300f.getElement(), 0);
            this.f31300f = null;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31302a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f31302a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31302a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f31303a;

        /* renamed from: b  reason: collision with root package name */
        public int f31304b;

        /* renamed from: c  reason: collision with root package name */
        public int f31305c;

        /* renamed from: d  reason: collision with root package name */
        public long f31306d;

        /* renamed from: e  reason: collision with root package name */
        public int f31307e;

        /* renamed from: f  reason: collision with root package name */
        public e<E> f31308f;

        /* renamed from: g  reason: collision with root package name */
        public e<E> f31309g;

        /* renamed from: h  reason: collision with root package name */
        public e<E> f31310h;

        /* renamed from: i  reason: collision with root package name */
        public e<E> f31311i;

        public e(E e2, int i2) {
            n.d(i2 > 0);
            this.f31303a = e2;
            this.f31304b = i2;
            this.f31306d = i2;
            this.f31305c = 1;
            this.f31307e = 1;
            this.f31308f = null;
            this.f31309g = null;
        }

        public static long L(e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f31306d;
        }

        public static int z(e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f31307e;
        }

        public final e<E> A() {
            int s = s();
            if (s == -2) {
                if (this.f31309g.s() > 0) {
                    this.f31309g = this.f31309g.I();
                }
                return H();
            } else if (s != 2) {
                C();
                return this;
            } else {
                if (this.f31308f.s() < 0) {
                    this.f31308f = this.f31308f.H();
                }
                return I();
            }
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f31307e = Math.max(z(this.f31308f), z(this.f31309g)) + 1;
        }

        public final void D() {
            this.f31305c = TreeMultiset.distinctElements(this.f31308f) + 1 + TreeMultiset.distinctElements(this.f31309g);
            this.f31306d = this.f31304b + L(this.f31308f) + L(this.f31309g);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare < 0) {
                e<E> eVar = this.f31308f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f31308f = eVar.E(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.f31305c--;
                        this.f31306d -= iArr[0];
                    } else {
                        this.f31306d -= i2;
                    }
                }
                return iArr[0] == 0 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31309g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f31309g = eVar2.E(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.f31305c--;
                        this.f31306d -= iArr[0];
                    } else {
                        this.f31306d -= i2;
                    }
                }
                return A();
            } else {
                int i3 = this.f31304b;
                iArr[0] = i3;
                if (i2 >= i3) {
                    return v();
                }
                this.f31304b = i3 - i2;
                this.f31306d -= i2;
                return this;
            }
        }

        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f31309g;
            if (eVar2 == null) {
                return this.f31308f;
            }
            this.f31309g = eVar2.F(eVar);
            this.f31305c--;
            this.f31306d -= eVar.f31304b;
            return A();
        }

        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f31308f;
            if (eVar2 == null) {
                return this.f31309g;
            }
            this.f31308f = eVar2.G(eVar);
            this.f31305c--;
            this.f31306d -= eVar.f31304b;
            return A();
        }

        public final e<E> H() {
            n.w(this.f31309g != null);
            e<E> eVar = this.f31309g;
            this.f31309g = eVar.f31308f;
            eVar.f31308f = this;
            eVar.f31306d = this.f31306d;
            eVar.f31305c = this.f31305c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            n.w(this.f31308f != null);
            e<E> eVar = this.f31308f;
            this.f31308f = eVar.f31309g;
            eVar.f31309g = this;
            eVar.f31306d = this.f31306d;
            eVar.f31305c = this.f31305c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> J(Comparator<? super E> comparator, E e2, int i2, int i3, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare < 0) {
                e<E> eVar = this.f31308f;
                if (eVar == null) {
                    iArr[0] = 0;
                    if (i2 == 0 && i3 > 0) {
                        q(e2, i3);
                    }
                    return this;
                }
                this.f31308f = eVar.J(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.f31305c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.f31305c++;
                    }
                    this.f31306d += i3 - iArr[0];
                }
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31309g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    if (i2 == 0 && i3 > 0) {
                        r(e2, i3);
                    }
                    return this;
                }
                this.f31309g = eVar2.J(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.f31305c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.f31305c++;
                    }
                    this.f31306d += i3 - iArr[0];
                }
                return A();
            } else {
                int i4 = this.f31304b;
                iArr[0] = i4;
                if (i2 == i4) {
                    if (i3 == 0) {
                        return v();
                    }
                    this.f31306d += i3 - i4;
                    this.f31304b = i3;
                }
                return this;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            int i3;
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare < 0) {
                e<E> eVar = this.f31308f;
                if (eVar == null) {
                    iArr[0] = 0;
                    if (i2 > 0) {
                        q(e2, i2);
                    }
                    return this;
                }
                this.f31308f = eVar.K(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.f31305c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.f31305c++;
                }
                this.f31306d += i2 - iArr[0];
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31309g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    if (i2 > 0) {
                        r(e2, i2);
                    }
                    return this;
                }
                this.f31309g = eVar2.K(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.f31305c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.f31305c++;
                }
                this.f31306d += i2 - iArr[0];
                return A();
            } else {
                iArr[0] = this.f31304b;
                if (i2 == 0) {
                    return v();
                }
                this.f31306d += i2 - i3;
                this.f31304b = i2;
                return this;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> p(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare < 0) {
                e<E> eVar = this.f31308f;
                if (eVar == null) {
                    iArr[0] = 0;
                    q(e2, i2);
                    return this;
                }
                int i3 = eVar.f31307e;
                this.f31308f = eVar.p(comparator, e2, i2, iArr);
                if (iArr[0] == 0) {
                    this.f31305c++;
                }
                this.f31306d += i2;
                return this.f31308f.f31307e == i3 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31309g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    r(e2, i2);
                    return this;
                }
                int i4 = eVar2.f31307e;
                this.f31309g = eVar2.p(comparator, e2, i2, iArr);
                if (iArr[0] == 0) {
                    this.f31305c++;
                }
                this.f31306d += i2;
                return this.f31309g.f31307e == i4 ? this : A();
            } else {
                int i5 = this.f31304b;
                iArr[0] = i5;
                long j = i2;
                n.d(((long) i5) + j <= 2147483647L);
                this.f31304b += i2;
                this.f31306d += j;
                return this;
            }
        }

        public final e<E> q(E e2, int i2) {
            e<E> eVar = new e<>(e2, i2);
            this.f31308f = eVar;
            TreeMultiset.successor(this.f31310h, eVar, this);
            this.f31307e = Math.max(2, this.f31307e);
            this.f31305c++;
            this.f31306d += i2;
            return this;
        }

        public final e<E> r(E e2, int i2) {
            e<E> eVar = new e<>(e2, i2);
            this.f31309g = eVar;
            TreeMultiset.successor(this, eVar, this.f31311i);
            this.f31307e = Math.max(2, this.f31307e);
            this.f31305c++;
            this.f31306d += i2;
            return this;
        }

        public final int s() {
            return z(this.f31308f) - z(this.f31309g);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> t(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare < 0) {
                e<E> eVar = this.f31308f;
                return eVar == null ? this : (e) j.a(eVar.t(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f31309g;
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
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare < 0) {
                e<E> eVar = this.f31308f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.u(comparator, e2);
            } else if (compare > 0) {
                e<E> eVar2 = this.f31309g;
                if (eVar2 == null) {
                    return 0;
                }
                return eVar2.u(comparator, e2);
            } else {
                return this.f31304b;
            }
        }

        public final e<E> v() {
            int i2 = this.f31304b;
            this.f31304b = 0;
            TreeMultiset.successor(this.f31310h, this.f31311i);
            e<E> eVar = this.f31308f;
            if (eVar == null) {
                return this.f31309g;
            }
            e<E> eVar2 = this.f31309g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f31307e >= eVar2.f31307e) {
                e<E> eVar3 = this.f31310h;
                eVar3.f31308f = eVar.F(eVar3);
                eVar3.f31309g = this.f31309g;
                eVar3.f31305c = this.f31305c - 1;
                eVar3.f31306d = this.f31306d - i2;
                return eVar3.A();
            }
            e<E> eVar4 = this.f31311i;
            eVar4.f31309g = eVar2.G(eVar4);
            eVar4.f31308f = this.f31308f;
            eVar4.f31305c = this.f31305c - 1;
            eVar4.f31306d = this.f31306d - i2;
            return eVar4.A();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> w(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31303a);
            if (compare > 0) {
                e<E> eVar = this.f31309g;
                return eVar == null ? this : (e) j.a(eVar.w(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f31308f;
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.w(comparator, e2);
            }
        }

        public int x() {
            return this.f31304b;
        }

        public E y() {
            return this.f31303a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class f<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f31312a;

        public f() {
        }

        public void a(T t, T t2) {
            if (this.f31312a == t) {
                this.f31312a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        public void b() {
            this.f31312a = null;
        }

        public T c() {
            return this.f31312a;
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
        int compare = comparator().compare(this.range.getUpperEndpoint(), eVar.f31303a);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, eVar.f31309g);
        }
        if (compare == 0) {
            int i2 = d.f31302a[this.range.getUpperBoundType().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return aggregate.treeAggregate(eVar.f31309g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregate.treeAggregate(eVar.f31309g);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f31309g) + aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f31308f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), eVar.f31303a);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, eVar.f31308f);
        }
        if (compare == 0) {
            int i2 = d.f31302a[this.range.getLowerBoundType().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return aggregate.treeAggregate(eVar.f31308f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregate.treeAggregate(eVar.f31308f);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f31308f) + aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f31309g);
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
            eVar = this.header.f31311i;
        } else {
            E lowerEndpoint = this.range.getLowerEndpoint();
            eVar = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, eVar.y()) == 0) {
                eVar = eVar.f31311i;
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
            eVar = this.header.f31310h;
        } else {
            E upperEndpoint = this.range.getUpperEndpoint();
            eVar = this.rootReference.c().w(comparator(), upperEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, eVar.y()) == 0) {
                eVar = eVar.f31310h;
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
        eVar.f31311i = eVar2;
        eVar2.f31310h = eVar;
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

    @Override // d.g.c.c.d, d.g.c.c.i0
    public int add(E e2, int i2) {
        m.b(i2, "occurrences");
        if (i2 == 0) {
            return count(e2);
        }
        n.d(this.range.contains(e2));
        e<E> c2 = this.rootReference.c();
        if (c2 == null) {
            comparator().compare(e2, e2);
            e<E> eVar = new e<>(e2, i2);
            e<E> eVar2 = this.header;
            successor(eVar2, eVar, eVar2);
            this.rootReference.a(c2, eVar);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c2, c2.p(comparator(), e2, i2, iArr));
        return iArr[0];
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (!this.range.hasLowerBound() && !this.range.hasUpperBound()) {
            e<E> eVar = this.header.f31311i;
            while (true) {
                e<E> eVar2 = this.header;
                if (eVar != eVar2) {
                    e<E> eVar3 = eVar.f31311i;
                    eVar.f31304b = 0;
                    eVar.f31308f = null;
                    eVar.f31309g = null;
                    eVar.f31310h = null;
                    eVar.f31311i = null;
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

    @Override // d.g.c.c.h, d.g.c.c.v0, d.g.c.c.t0
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.g.c.c.i0
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

    @Override // d.g.c.c.h
    public Iterator<i0.a<E>> descendingEntryIterator() {
        return new c();
    }

    @Override // d.g.c.c.h, d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // d.g.c.c.d
    public int distinctElements() {
        return Ints.j(aggregateForEntries(Aggregate.DISTINCT));
    }

    @Override // d.g.c.c.d
    public Iterator<E> elementIterator() {
        return Multisets.e(entryIterator());
    }

    @Override // d.g.c.c.h, d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // d.g.c.c.d
    public Iterator<i0.a<E>> entryIterator() {
        return new b();
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // d.g.c.c.h, d.g.c.c.v0
    public /* bridge */ /* synthetic */ i0.a firstEntry() {
        return super.firstEntry();
    }

    @Override // d.g.c.c.v0
    public v0<E> headMultiset(E e2, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e2, boundType)), this.header);
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.g.c.c.i0
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // d.g.c.c.h, d.g.c.c.v0
    public /* bridge */ /* synthetic */ i0.a lastEntry() {
        return super.lastEntry();
    }

    @Override // d.g.c.c.h, d.g.c.c.v0
    public /* bridge */ /* synthetic */ i0.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // d.g.c.c.h, d.g.c.c.v0
    public /* bridge */ /* synthetic */ i0.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public int remove(Object obj, int i2) {
        m.b(i2, "occurrences");
        if (i2 == 0) {
            return count(obj);
        }
        e<E> c2 = this.rootReference.c();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj) && c2 != null) {
                this.rootReference.a(c2, c2.E(comparator(), obj, i2, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public int setCount(E e2, int i2) {
        m.b(i2, "count");
        if (!this.range.contains(e2)) {
            n.d(i2 == 0);
            return 0;
        }
        e<E> c2 = this.rootReference.c();
        if (c2 == null) {
            if (i2 > 0) {
                add(e2, i2);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.a(c2, c2.K(comparator(), e2, i2, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public int size() {
        return Ints.j(aggregateForEntries(Aggregate.SIZE));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.h, d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // d.g.c.c.v0
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
        return eVar.f31305c;
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

    @Override // d.g.c.c.d, d.g.c.c.i0
    public boolean setCount(E e2, int i2, int i3) {
        m.b(i3, "newCount");
        m.b(i2, "oldCount");
        n.d(this.range.contains(e2));
        e<E> c2 = this.rootReference.c();
        if (c2 != null) {
            int[] iArr = new int[1];
            this.rootReference.a(c2, c2.J(comparator(), e2, i2, i3, iArr));
            return iArr[0] == i2;
        } else if (i2 == 0) {
            if (i3 > 0) {
                add(e2, i3);
            }
            return true;
        } else {
            return false;
        }
    }
}
