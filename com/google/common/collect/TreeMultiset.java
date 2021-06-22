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
                return eVar.f31493b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            public long treeAggregate(e<?> eVar) {
                if (eVar == null) {
                    return 0L;
                }
                return eVar.f31495d;
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
                return eVar.f31494c;
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
        public final /* synthetic */ e f31483e;

        public a(e eVar) {
            this.f31483e = eVar;
        }

        @Override // d.g.c.c.i0.a
        public int getCount() {
            int x = this.f31483e.x();
            return x == 0 ? TreeMultiset.this.count(getElement()) : x;
        }

        @Override // d.g.c.c.i0.a
        public E getElement() {
            return (E) this.f31483e.y();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Iterator<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f31485e;

        /* renamed from: f  reason: collision with root package name */
        public i0.a<E> f31486f;

        public b() {
            this.f31485e = TreeMultiset.this.firstNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public i0.a<E> next() {
            if (hasNext()) {
                i0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f31485e);
                this.f31486f = wrapEntry;
                if (this.f31485e.f31500i != TreeMultiset.this.header) {
                    this.f31485e = this.f31485e.f31500i;
                } else {
                    this.f31485e = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31485e == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooHigh(this.f31485e.y())) {
                this.f31485e = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31486f != null);
            TreeMultiset.this.setCount(this.f31486f.getElement(), 0);
            this.f31486f = null;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Iterator<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f31488e;

        /* renamed from: f  reason: collision with root package name */
        public i0.a<E> f31489f = null;

        public c() {
            this.f31488e = TreeMultiset.this.lastNode();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public i0.a<E> next() {
            if (hasNext()) {
                i0.a<E> wrapEntry = TreeMultiset.this.wrapEntry(this.f31488e);
                this.f31489f = wrapEntry;
                if (this.f31488e.f31499h != TreeMultiset.this.header) {
                    this.f31488e = this.f31488e.f31499h;
                } else {
                    this.f31488e = null;
                }
                return wrapEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31488e == null) {
                return false;
            }
            if (TreeMultiset.this.range.tooLow(this.f31488e.y())) {
                this.f31488e = null;
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31489f != null);
            TreeMultiset.this.setCount(this.f31489f.getElement(), 0);
            this.f31489f = null;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31491a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f31491a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31491a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f31492a;

        /* renamed from: b  reason: collision with root package name */
        public int f31493b;

        /* renamed from: c  reason: collision with root package name */
        public int f31494c;

        /* renamed from: d  reason: collision with root package name */
        public long f31495d;

        /* renamed from: e  reason: collision with root package name */
        public int f31496e;

        /* renamed from: f  reason: collision with root package name */
        public e<E> f31497f;

        /* renamed from: g  reason: collision with root package name */
        public e<E> f31498g;

        /* renamed from: h  reason: collision with root package name */
        public e<E> f31499h;

        /* renamed from: i  reason: collision with root package name */
        public e<E> f31500i;

        public e(E e2, int i2) {
            n.d(i2 > 0);
            this.f31492a = e2;
            this.f31493b = i2;
            this.f31495d = i2;
            this.f31494c = 1;
            this.f31496e = 1;
            this.f31497f = null;
            this.f31498g = null;
        }

        public static long L(e<?> eVar) {
            if (eVar == null) {
                return 0L;
            }
            return eVar.f31495d;
        }

        public static int z(e<?> eVar) {
            if (eVar == null) {
                return 0;
            }
            return eVar.f31496e;
        }

        public final e<E> A() {
            int s = s();
            if (s == -2) {
                if (this.f31498g.s() > 0) {
                    this.f31498g = this.f31498g.I();
                }
                return H();
            } else if (s != 2) {
                C();
                return this;
            } else {
                if (this.f31497f.s() < 0) {
                    this.f31497f = this.f31497f.H();
                }
                return I();
            }
        }

        public final void B() {
            D();
            C();
        }

        public final void C() {
            this.f31496e = Math.max(z(this.f31497f), z(this.f31498g)) + 1;
        }

        public final void D() {
            this.f31494c = TreeMultiset.distinctElements(this.f31497f) + 1 + TreeMultiset.distinctElements(this.f31498g);
            this.f31495d = this.f31493b + L(this.f31497f) + L(this.f31498g);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> E(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare < 0) {
                e<E> eVar = this.f31497f;
                if (eVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f31497f = eVar.E(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.f31494c--;
                        this.f31495d -= iArr[0];
                    } else {
                        this.f31495d -= i2;
                    }
                }
                return iArr[0] == 0 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31498g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f31498g = eVar2.E(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.f31494c--;
                        this.f31495d -= iArr[0];
                    } else {
                        this.f31495d -= i2;
                    }
                }
                return A();
            } else {
                int i3 = this.f31493b;
                iArr[0] = i3;
                if (i2 >= i3) {
                    return v();
                }
                this.f31493b = i3 - i2;
                this.f31495d -= i2;
                return this;
            }
        }

        public final e<E> F(e<E> eVar) {
            e<E> eVar2 = this.f31498g;
            if (eVar2 == null) {
                return this.f31497f;
            }
            this.f31498g = eVar2.F(eVar);
            this.f31494c--;
            this.f31495d -= eVar.f31493b;
            return A();
        }

        public final e<E> G(e<E> eVar) {
            e<E> eVar2 = this.f31497f;
            if (eVar2 == null) {
                return this.f31498g;
            }
            this.f31497f = eVar2.G(eVar);
            this.f31494c--;
            this.f31495d -= eVar.f31493b;
            return A();
        }

        public final e<E> H() {
            n.w(this.f31498g != null);
            e<E> eVar = this.f31498g;
            this.f31498g = eVar.f31497f;
            eVar.f31497f = this;
            eVar.f31495d = this.f31495d;
            eVar.f31494c = this.f31494c;
            B();
            eVar.C();
            return eVar;
        }

        public final e<E> I() {
            n.w(this.f31497f != null);
            e<E> eVar = this.f31497f;
            this.f31497f = eVar.f31498g;
            eVar.f31498g = this;
            eVar.f31495d = this.f31495d;
            eVar.f31494c = this.f31494c;
            B();
            eVar.C();
            return eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> J(Comparator<? super E> comparator, E e2, int i2, int i3, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare < 0) {
                e<E> eVar = this.f31497f;
                if (eVar == null) {
                    iArr[0] = 0;
                    if (i2 == 0 && i3 > 0) {
                        q(e2, i3);
                    }
                    return this;
                }
                this.f31497f = eVar.J(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.f31494c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.f31494c++;
                    }
                    this.f31495d += i3 - iArr[0];
                }
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31498g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    if (i2 == 0 && i3 > 0) {
                        r(e2, i3);
                    }
                    return this;
                }
                this.f31498g = eVar2.J(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.f31494c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.f31494c++;
                    }
                    this.f31495d += i3 - iArr[0];
                }
                return A();
            } else {
                int i4 = this.f31493b;
                iArr[0] = i4;
                if (i2 == i4) {
                    if (i3 == 0) {
                        return v();
                    }
                    this.f31495d += i3 - i4;
                    this.f31493b = i3;
                }
                return this;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> K(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            int i3;
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare < 0) {
                e<E> eVar = this.f31497f;
                if (eVar == null) {
                    iArr[0] = 0;
                    if (i2 > 0) {
                        q(e2, i2);
                    }
                    return this;
                }
                this.f31497f = eVar.K(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.f31494c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.f31494c++;
                }
                this.f31495d += i2 - iArr[0];
                return A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31498g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    if (i2 > 0) {
                        r(e2, i2);
                    }
                    return this;
                }
                this.f31498g = eVar2.K(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.f31494c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.f31494c++;
                }
                this.f31495d += i2 - iArr[0];
                return A();
            } else {
                iArr[0] = this.f31493b;
                if (i2 == 0) {
                    return v();
                }
                this.f31495d += i2 - i3;
                this.f31493b = i2;
                return this;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public e<E> p(Comparator<? super E> comparator, E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare < 0) {
                e<E> eVar = this.f31497f;
                if (eVar == null) {
                    iArr[0] = 0;
                    q(e2, i2);
                    return this;
                }
                int i3 = eVar.f31496e;
                this.f31497f = eVar.p(comparator, e2, i2, iArr);
                if (iArr[0] == 0) {
                    this.f31494c++;
                }
                this.f31495d += i2;
                return this.f31497f.f31496e == i3 ? this : A();
            } else if (compare > 0) {
                e<E> eVar2 = this.f31498g;
                if (eVar2 == null) {
                    iArr[0] = 0;
                    r(e2, i2);
                    return this;
                }
                int i4 = eVar2.f31496e;
                this.f31498g = eVar2.p(comparator, e2, i2, iArr);
                if (iArr[0] == 0) {
                    this.f31494c++;
                }
                this.f31495d += i2;
                return this.f31498g.f31496e == i4 ? this : A();
            } else {
                int i5 = this.f31493b;
                iArr[0] = i5;
                long j = i2;
                n.d(((long) i5) + j <= 2147483647L);
                this.f31493b += i2;
                this.f31495d += j;
                return this;
            }
        }

        public final e<E> q(E e2, int i2) {
            e<E> eVar = new e<>(e2, i2);
            this.f31497f = eVar;
            TreeMultiset.successor(this.f31499h, eVar, this);
            this.f31496e = Math.max(2, this.f31496e);
            this.f31494c++;
            this.f31495d += i2;
            return this;
        }

        public final e<E> r(E e2, int i2) {
            e<E> eVar = new e<>(e2, i2);
            this.f31498g = eVar;
            TreeMultiset.successor(this, eVar, this.f31500i);
            this.f31496e = Math.max(2, this.f31496e);
            this.f31494c++;
            this.f31495d += i2;
            return this;
        }

        public final int s() {
            return z(this.f31497f) - z(this.f31498g);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> t(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare < 0) {
                e<E> eVar = this.f31497f;
                return eVar == null ? this : (e) j.a(eVar.t(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f31498g;
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
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare < 0) {
                e<E> eVar = this.f31497f;
                if (eVar == null) {
                    return 0;
                }
                return eVar.u(comparator, e2);
            } else if (compare > 0) {
                e<E> eVar2 = this.f31498g;
                if (eVar2 == null) {
                    return 0;
                }
                return eVar2.u(comparator, e2);
            } else {
                return this.f31493b;
            }
        }

        public final e<E> v() {
            int i2 = this.f31493b;
            this.f31493b = 0;
            TreeMultiset.successor(this.f31499h, this.f31500i);
            e<E> eVar = this.f31497f;
            if (eVar == null) {
                return this.f31498g;
            }
            e<E> eVar2 = this.f31498g;
            if (eVar2 == null) {
                return eVar;
            }
            if (eVar.f31496e >= eVar2.f31496e) {
                e<E> eVar3 = this.f31499h;
                eVar3.f31497f = eVar.F(eVar3);
                eVar3.f31498g = this.f31498g;
                eVar3.f31494c = this.f31494c - 1;
                eVar3.f31495d = this.f31495d - i2;
                return eVar3.A();
            }
            e<E> eVar4 = this.f31500i;
            eVar4.f31498g = eVar2.G(eVar4);
            eVar4.f31497f = this.f31497f;
            eVar4.f31494c = this.f31494c - 1;
            eVar4.f31495d = this.f31495d - i2;
            return eVar4.A();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: E */
        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: E, ? super E */
        /* JADX WARN: Multi-variable type inference failed */
        public final e<E> w(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, (E) this.f31492a);
            if (compare > 0) {
                e<E> eVar = this.f31498g;
                return eVar == null ? this : (e) j.a(eVar.w(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                e<E> eVar2 = this.f31497f;
                if (eVar2 == null) {
                    return null;
                }
                return eVar2.w(comparator, e2);
            }
        }

        public int x() {
            return this.f31493b;
        }

        public E y() {
            return this.f31492a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class f<T> {

        /* renamed from: a  reason: collision with root package name */
        public T f31501a;

        public f() {
        }

        public void a(T t, T t2) {
            if (this.f31501a == t) {
                this.f31501a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        public void b() {
            this.f31501a = null;
        }

        public T c() {
            return this.f31501a;
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
        int compare = comparator().compare(this.range.getUpperEndpoint(), eVar.f31492a);
        if (compare > 0) {
            return aggregateAboveRange(aggregate, eVar.f31498g);
        }
        if (compare == 0) {
            int i2 = d.f31491a[this.range.getUpperBoundType().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return aggregate.treeAggregate(eVar.f31498g);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregate.treeAggregate(eVar.f31498g);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f31498g) + aggregate.nodeAggregate(eVar);
            aggregateAboveRange = aggregateAboveRange(aggregate, eVar.f31497f);
        }
        return treeAggregate + aggregateAboveRange;
    }

    private long aggregateBelowRange(Aggregate aggregate, e<E> eVar) {
        long treeAggregate;
        long aggregateBelowRange;
        if (eVar == null) {
            return 0L;
        }
        int compare = comparator().compare(this.range.getLowerEndpoint(), eVar.f31492a);
        if (compare < 0) {
            return aggregateBelowRange(aggregate, eVar.f31497f);
        }
        if (compare == 0) {
            int i2 = d.f31491a[this.range.getLowerBoundType().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return aggregate.treeAggregate(eVar.f31497f);
                }
                throw new AssertionError();
            }
            treeAggregate = aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregate.treeAggregate(eVar.f31497f);
        } else {
            treeAggregate = aggregate.treeAggregate(eVar.f31497f) + aggregate.nodeAggregate(eVar);
            aggregateBelowRange = aggregateBelowRange(aggregate, eVar.f31498g);
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
            eVar = this.header.f31500i;
        } else {
            E lowerEndpoint = this.range.getLowerEndpoint();
            eVar = this.rootReference.c().t(comparator(), lowerEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, eVar.y()) == 0) {
                eVar = eVar.f31500i;
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
            eVar = this.header.f31499h;
        } else {
            E upperEndpoint = this.range.getUpperEndpoint();
            eVar = this.rootReference.c().w(comparator(), upperEndpoint);
            if (eVar == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, eVar.y()) == 0) {
                eVar = eVar.f31499h;
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
        eVar.f31500i = eVar2;
        eVar2.f31499h = eVar;
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
            e<E> eVar = this.header.f31500i;
            while (true) {
                e<E> eVar2 = this.header;
                if (eVar != eVar2) {
                    e<E> eVar3 = eVar.f31500i;
                    eVar.f31493b = 0;
                    eVar.f31497f = null;
                    eVar.f31498g = null;
                    eVar.f31499h = null;
                    eVar.f31500i = null;
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
        return eVar.f31494c;
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
