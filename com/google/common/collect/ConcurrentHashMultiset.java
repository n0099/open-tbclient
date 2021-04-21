package com.google.common.collect;

import com.google.common.primitives.Ints;
import d.h.c.a.n;
import d.h.c.c.a0;
import d.h.c.c.f0;
import d.h.c.c.i0;
import d.h.c.c.m;
import d.h.c.c.r0;
import d.h.c.c.t;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class ConcurrentHashMultiset<E> extends d.h.c.c.d<E> implements Serializable {
    public static final long serialVersionUID = 1;
    public final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: classes6.dex */
    public class b extends AbstractIterator<i0.a<E>> {

        /* renamed from: g  reason: collision with root package name */
        public final Iterator<Map.Entry<E, AtomicInteger>> f30837g;

        public b() {
            this.f30837g = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d */
        public i0.a<E> a() {
            while (this.f30837g.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f30837g.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return Multisets.g(next.getKey(), i);
                }
            }
            return b();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends t<i0.a<E>> {

        /* renamed from: e  reason: collision with root package name */
        public i0.a<E> f30839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterator f30840f;

        public c(Iterator it) {
            this.f30840f = it;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.y
        /* renamed from: b */
        public Iterator<i0.a<E>> delegate() {
            return this.f30840f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.t, java.util.Iterator
        /* renamed from: c */
        public i0.a<E> next() {
            i0.a<E> aVar = (i0.a) super.next();
            this.f30839e = aVar;
            return aVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f30839e != null);
            ConcurrentHashMultiset.this.setCount(this.f30839e.getElement(), 0);
            this.f30839e = null;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends d.h.c.c.d<E>.b {
        public d() {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.d.b, com.google.common.collect.Multisets.d
        /* renamed from: c */
        public ConcurrentHashMultiset<E> b() {
            return ConcurrentHashMultiset.this;
        }

        public final List<i0.a<E>> d() {
            ArrayList m = Lists.m(size());
            Iterators.a(m, iterator());
            return m;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return d().toArray();
        }

        public /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) d().toArray(tArr);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final r0.b<ConcurrentHashMultiset> f30843a = r0.a(ConcurrentHashMultiset.class, "countMap");
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        n.k(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.f30843a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList m = Lists.m(size());
        for (i0.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                m.add(element);
            }
        }
        return m;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L31;
     */
    @Override // d.h.c.c.d, d.h.c.c.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int add(E e2, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        n.p(e2);
        if (i == 0) {
            return count(e2);
        }
        m.d(i, "occurences");
        do {
            atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
            if (atomicInteger != null || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i))) != null) {
                while (true) {
                    int i2 = atomicInteger.get();
                    if (i2 == 0) {
                        break;
                    }
                    try {
                        if (atomicInteger.compareAndSet(i2, d.h.c.f.c.a(i2, i))) {
                            return i2;
                        }
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                }
            } else {
                return 0;
            }
        } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection, d.h.c.c.i0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.h.c.c.i0
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // d.h.c.c.d
    public Set<E> createElementSet() {
        return new a(this, this.countMap.keySet());
    }

    @Override // d.h.c.c.d
    @Deprecated
    public Set<i0.a<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // d.h.c.c.d
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // d.h.c.c.d
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // d.h.c.c.d
    public Iterator<i0.a<E>> entryIterator() {
        return new c(new b());
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.h.c.c.i0
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public int remove(Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        m.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    public boolean removeExactly(Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        m.d(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r6 != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L29;
     */
    @Override // d.h.c.c.d, d.h.c.c.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setCount(E e2, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        n.p(e2);
        m.b(i, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
            if (atomicInteger == null && (i == 0 || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i))) == null)) {
                return 0;
            }
            while (true) {
                int i2 = atomicInteger.get();
                if (i2 == 0) {
                    break;
                } else if (atomicInteger.compareAndSet(i2, i)) {
                    if (i == 0) {
                        this.countMap.remove(e2, atomicInteger);
                    }
                    return i2;
                }
            }
        } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.h.c.c.i0
    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j += atomicInteger.get();
        }
        return Ints.j(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* loaded from: classes6.dex */
    public class a extends a0<E> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f30836e;

        public a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.f30836e = set;
        }

        @Override // d.h.c.c.r, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && d.h.c.c.n.d(this.f30836e, obj);
        }

        @Override // d.h.c.c.r, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // d.h.c.c.r, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && d.h.c.c.n.e(this.f30836e, obj);
        }

        @Override // d.h.c.c.r, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.a0, d.h.c.c.r, d.h.c.c.y
        public Set<E> delegate() {
            return this.f30836e;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        f0.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public boolean setCount(E e2, int i, int i2) {
        n.p(e2);
        m.b(i, "oldCount");
        m.b(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
        if (atomicInteger == null) {
            if (i != 0) {
                return false;
            }
            return i2 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i2)) == null;
        }
        int i3 = atomicInteger.get();
        if (i3 == i) {
            if (i3 == 0) {
                if (i2 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                return this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2);
            } else if (atomicInteger.compareAndSet(i3, i2)) {
                if (i2 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
