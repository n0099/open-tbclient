package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    public static final int CONTAINS_VALUE_RETRIES = 3;
    public static final int DRAIN_MAX = 16;
    public static final int DRAIN_THRESHOLD = 63;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int MAX_SEGMENTS = 65536;
    public static final v<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    public static final long serialVersionUID = 5;
    public final int concurrencyLevel;
    public final transient i<K, V, E, S> entryHelper;
    public transient Set<Map.Entry<K, V>> entrySet;
    public final Equivalence<Object> keyEquivalence;
    public transient Set<K> keySet;
    public final transient int segmentMask;
    public final transient int segmentShift;
    public final transient Segment<K, V, E, S>[] segments;
    public transient Collection<V> values;

    /* loaded from: classes6.dex */
    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        public static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i2, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i2, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* loaded from: classes6.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (m) hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(h<K, V, ?> hVar) {
            return (n) hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
        public final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<V>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<V>) this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v) {
            return new w(this.queueForValues, v, castForTesting((h) hVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            o<K, V> castForTesting = castForTesting((h) hVar);
            v vVar2 = castForTesting.f31984h;
            castForTesting.f31984h = vVar;
            vVar2.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(h<K, V, ?> hVar) {
            return (o) hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
        public final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (r) hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        public final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(h<K, V, ?> hVar) {
            return (s) hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        public final ReferenceQueue<K> queueForKeys;
        public final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
            super(mapMakerInternalMap, i2, i3);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.ref.ReferenceQueue<K>, java.lang.ref.ReferenceQueue<T> */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue((ReferenceQueue<K>) this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v) {
            return new w(this.queueForValues, v, castForTesting((h) hVar));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            t<K, V> castForTesting = castForTesting((h) hVar);
            v vVar2 = castForTesting.f31990g;
            castForTesting.f31990g = vVar;
            vVar2.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V> castForTesting(h<K, V, ?> hVar) {
            return (t) hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements v<Object, Object, d> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.ref.ReferenceQueue, com.google.common.collect.MapMakerInternalMap$h] */
        /* JADX DEBUG: Return type fixed from 'com.google.common.collect.MapMakerInternalMap$v' to match base method */
        @Override // com.google.common.collect.MapMakerInternalMap.v
        public /* bridge */ /* synthetic */ v<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            c(referenceQueue, dVar);
            return this;
        }

        public v<Object, Object, d> c(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public void clear() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* renamed from: d */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public Object get() {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* renamed from: e  reason: collision with root package name */
        public final K f31969e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31970f;

        /* renamed from: g  reason: collision with root package name */
        public final E f31971g;

        public b(K k, int i2, E e2) {
            this.f31969e = k;
            this.f31970f = i2;
            this.f31971g = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f31970f;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return this.f31969e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f31971g;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* renamed from: e  reason: collision with root package name */
        public final int f31972e;

        /* renamed from: f  reason: collision with root package name */
        public final E f31973f;

        public c(ReferenceQueue<K> referenceQueue, K k, int i2, E e2) {
            super(k, referenceQueue);
            this.f31972e = i2;
            this.f31973f = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f31972e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f31973f;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements h<Object, Object, d> {
        public d() {
            throw new AssertionError();
        }

        public d a() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            throw new AssertionError();
        }

        /* JADX DEBUG: Return type fixed from 'com.google.common.collect.MapMakerInternalMap$h' to match base method */
        @Override // com.google.common.collect.MapMakerInternalMap.h
        public /* bridge */ /* synthetic */ d getNext() {
            a();
            throw null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* loaded from: classes6.dex */
    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        public e(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: classes6.dex */
    public final class f extends l<Map.Entry<K, V>> {
        public f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes6.dex */
    public abstract class g<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f31975e;

        /* renamed from: f  reason: collision with root package name */
        public int f31976f = -1;

        /* renamed from: g  reason: collision with root package name */
        public Segment<K, V, E, S> f31977g;

        /* renamed from: h  reason: collision with root package name */
        public AtomicReferenceArray<E> f31978h;

        /* renamed from: i  reason: collision with root package name */
        public E f31979i;
        public MapMakerInternalMap<K, V, E, S>.x j;
        public MapMakerInternalMap<K, V, E, S>.x k;

        public g() {
            this.f31975e = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.j = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i2 = this.f31975e;
                if (i2 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f31975e = i2 - 1;
                Segment<K, V, E, S> segment = segmentArr[i2];
                this.f31977g = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.f31977g.table;
                    this.f31978h = atomicReferenceArray;
                    this.f31976f = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e2) {
            boolean z;
            try {
                Object key = e2.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e2);
                if (liveValue != null) {
                    this.j = new x(key, liveValue);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.f31977g.postReadCleanup();
            }
        }

        public MapMakerInternalMap<K, V, E, S>.x c() {
            MapMakerInternalMap<K, V, E, S>.x xVar = this.j;
            if (xVar != null) {
                this.k = xVar;
                a();
                return this.k;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            E e2 = this.f31979i;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.f31979i = (E) e2.getNext();
                E e3 = this.f31979i;
                if (e3 == null) {
                    return false;
                }
                if (b(e3)) {
                    return true;
                }
                e2 = this.f31979i;
            }
        }

        public boolean e() {
            while (true) {
                int i2 = this.f31976f;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f31978h;
                this.f31976f = i2 - 1;
                E e2 = atomicReferenceArray.get(i2);
                this.f31979i = e2;
                if (e2 != null && (b(e2) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            d.g.c.c.m.e(this.k != null);
            MapMakerInternalMap.this.remove(this.k.getKey());
            this.k = null;
        }
    }

    /* loaded from: classes6.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* loaded from: classes6.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        void a(S s, E e2, V v);

        Strength b();

        E c(S s, E e2, E e3);

        Strength d();

        E e(S s, K k, int i2, E e2);

        S f(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2, int i3);
    }

    /* loaded from: classes6.dex */
    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        public j(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes6.dex */
    public final class k extends l<K> {
        public k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new j(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class l<E> extends AbstractSet<E> {
        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        public /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    /* loaded from: classes6.dex */
    public static final class m<K> extends b<K, MapMaker.Dummy, m<K>> implements Object<K, MapMaker.Dummy, m<K>> {

        /* loaded from: classes6.dex */
        public static final class a<K> implements i<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a<?> f31981a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f31981a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public m<K> c(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, m<K> mVar2) {
                return mVar.a(mVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public m<K> e(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k, int i2, m<K> mVar) {
                return new m<>(k, i2, mVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public StrongKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i2, i3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, MapMaker.Dummy dummy) {
            }
        }

        public m(K k, int i2, m<K> mVar) {
            super(k, i2, mVar);
        }

        public m<K> a(m<K> mVar) {
            return new m<>(this.f31969e, this.f31970f, mVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class n<K, V> extends b<K, V, n<K, V>> implements Object<K, V, n<K, V>> {

        /* renamed from: h  reason: collision with root package name */
        public volatile V f31982h;

        /* loaded from: classes6.dex */
        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a<?, ?> f31983a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31983a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public n<K, V> c(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, n<K, V> nVar2) {
                return nVar.a(nVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public n<K, V> e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i2, n<K, V> nVar) {
                return new n<>(k, i2, nVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public StrongKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i2, i3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, V v) {
                nVar.b(v);
            }
        }

        public n(K k, int i2, n<K, V> nVar) {
            super(k, i2, nVar);
            this.f31982h = null;
        }

        public n<K, V> a(n<K, V> nVar) {
            n<K, V> nVar2 = new n<>(this.f31969e, this.f31970f, nVar);
            nVar2.f31982h = this.f31982h;
            return nVar2;
        }

        public void b(V v) {
            this.f31982h = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f31982h;
        }
    }

    /* loaded from: classes6.dex */
    public static final class o<K, V> extends b<K, V, o<K, V>> implements u<K, V, o<K, V>> {

        /* renamed from: h  reason: collision with root package name */
        public volatile v<K, V, o<K, V>> f31984h;

        /* loaded from: classes6.dex */
        public static final class a<K, V> implements i<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a<?, ?> f31985a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31985a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.WEAK;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public o<K, V> c(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, o<K, V> oVar2) {
                if (Segment.isCollected(oVar)) {
                    return null;
                }
                return oVar.c(strongKeyWeakValueSegment.queueForValues, oVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public o<K, V> e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i2, o<K, V> oVar) {
                return new o<>(k, i2, oVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public StrongKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i2, i3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, V v) {
                oVar.d(v, strongKeyWeakValueSegment.queueForValues);
            }
        }

        public o(K k, int i2, o<K, V> oVar) {
            super(k, i2, oVar);
            this.f31984h = MapMakerInternalMap.unsetWeakValueReference();
        }

        public o<K, V> c(ReferenceQueue<V> referenceQueue, o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(this.f31969e, this.f31970f, oVar);
            oVar2.f31984h = this.f31984h.b(referenceQueue, oVar2);
            return oVar2;
        }

        public void d(V v, ReferenceQueue<V> referenceQueue) {
            v<K, V, o<K, V>> vVar = this.f31984h;
            this.f31984h = new w(referenceQueue, v, this);
            vVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f31984h.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, o<K, V>> getValueReference() {
            return this.f31984h;
        }
    }

    /* loaded from: classes6.dex */
    public final class p extends MapMakerInternalMap<K, V, E, S>.g<V> {
        public p(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: classes6.dex */
    public final class q extends AbstractCollection<V> {
        public q() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new p(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    /* loaded from: classes6.dex */
    public static final class r<K> extends c<K, MapMaker.Dummy, r<K>> implements Object<K, MapMaker.Dummy, r<K>> {

        /* loaded from: classes6.dex */
        public static final class a<K> implements i<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a<?> f31987a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f31987a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public r<K> c(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, r<K> rVar2) {
                if (rVar.getKey() == null) {
                    return null;
                }
                return rVar.a(weakKeyDummyValueSegment.queueForKeys, rVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public r<K> e(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k, int i2, r<K> rVar) {
                return new r<>(weakKeyDummyValueSegment.queueForKeys, k, i2, rVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public WeakKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i2, int i3) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i2, i3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, MapMaker.Dummy dummy) {
            }
        }

        public r(ReferenceQueue<K> referenceQueue, K k, int i2, r<K> rVar) {
            super(referenceQueue, k, i2, rVar);
        }

        public r<K> a(ReferenceQueue<K> referenceQueue, r<K> rVar) {
            return new r<>(referenceQueue, getKey(), this.f31972e, rVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class s<K, V> extends c<K, V, s<K, V>> implements Object<K, V, s<K, V>> {

        /* renamed from: g  reason: collision with root package name */
        public volatile V f31988g;

        /* loaded from: classes6.dex */
        public static final class a<K, V> implements i<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a<?, ?> f31989a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31989a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public s<K, V> c(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, s<K, V> sVar2) {
                if (sVar.getKey() == null) {
                    return null;
                }
                return sVar.a(weakKeyStrongValueSegment.queueForKeys, sVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public s<K, V> e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i2, s<K, V> sVar) {
                return new s<>(weakKeyStrongValueSegment.queueForKeys, k, i2, sVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public WeakKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i2, i3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, V v) {
                sVar.b(v);
            }
        }

        public s(ReferenceQueue<K> referenceQueue, K k, int i2, s<K, V> sVar) {
            super(referenceQueue, k, i2, sVar);
            this.f31988g = null;
        }

        public s<K, V> a(ReferenceQueue<K> referenceQueue, s<K, V> sVar) {
            s<K, V> sVar2 = new s<>(referenceQueue, getKey(), this.f31972e, sVar);
            sVar2.b(this.f31988g);
            return sVar2;
        }

        public void b(V v) {
            this.f31988g = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f31988g;
        }
    }

    /* loaded from: classes6.dex */
    public static final class t<K, V> extends c<K, V, t<K, V>> implements u<K, V, t<K, V>> {

        /* renamed from: g  reason: collision with root package name */
        public volatile v<K, V, t<K, V>> f31990g;

        /* loaded from: classes6.dex */
        public static final class a<K, V> implements i<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            public static final a<?, ?> f31991a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f31991a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.WEAK;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g */
            public t<K, V> c(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, t<K, V> tVar2) {
                if (tVar.getKey() == null || Segment.isCollected(tVar)) {
                    return null;
                }
                return tVar.c(weakKeyWeakValueSegment.queueForKeys, weakKeyWeakValueSegment.queueForValues, tVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i */
            public t<K, V> e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i2, t<K, V> tVar) {
                return new t<>(weakKeyWeakValueSegment.queueForKeys, k, i2, tVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j */
            public WeakKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2, int i3) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i2, i3);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k */
            public void a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, V v) {
                tVar.d(v, weakKeyWeakValueSegment.queueForValues);
            }
        }

        public t(ReferenceQueue<K> referenceQueue, K k, int i2, t<K, V> tVar) {
            super(referenceQueue, k, i2, tVar);
            this.f31990g = MapMakerInternalMap.unsetWeakValueReference();
        }

        public t<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, t<K, V> tVar) {
            t<K, V> tVar2 = new t<>(referenceQueue, getKey(), this.f31972e, tVar);
            tVar2.f31990g = this.f31990g.b(referenceQueue2, tVar2);
            return tVar2;
        }

        public void d(V v, ReferenceQueue<V> referenceQueue) {
            v<K, V, t<K, V>> vVar = this.f31990g;
            this.f31990g = new w(referenceQueue, v, this);
            vVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f31990g.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, t<K, V>> getValueReference() {
            return this.f31990g;
        }
    }

    /* loaded from: classes6.dex */
    public interface u<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        v<K, V, E> getValueReference();
    }

    /* loaded from: classes6.dex */
    public interface v<K, V, E extends h<K, V, E>> {
        E a();

        v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        V get();
    }

    /* loaded from: classes6.dex */
    public static final class w<K, V, E extends h<K, V, E>> extends WeakReference<V> implements v<K, V, E> {

        /* renamed from: e  reason: collision with root package name */
        public final E f31992e;

        public w(ReferenceQueue<V> referenceQueue, V v, E e2) {
            super(v, referenceQueue);
            this.f31992e = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public E a() {
            return this.f31992e;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            return new w(referenceQueue, get(), e2);
        }
    }

    /* loaded from: classes6.dex */
    public final class x extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f31993e;

        /* renamed from: f  reason: collision with root package name */
        public V f31994f;

        public x(K k, V v) {
            this.f31993e = k;
            this.f31994f = v;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.f31993e.equals(entry.getKey()) && this.f31994f.equals(entry.getValue());
            }
            return false;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f31993e;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            return this.f31994f;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public int hashCode() {
            return this.f31993e.hashCode() ^ this.f31994f.hashCode();
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.f31993e, v);
            this.f31994f = v;
            return v2;
        }
    }

    public MapMakerInternalMap(MapMaker mapMaker, i<K, V, E, S> iVar) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = iVar;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.concurrencyLevel) {
            i5++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i5;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i6 = min / i4;
        while (i3 < (i4 * i6 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = createSegment(i3, -1);
            i2++;
        }
    }

    public static <E> ArrayList<E> a(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> create(MapMaker mapMaker) {
        if (mapMaker.e() == Strength.STRONG && mapMaker.f() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        if (mapMaker.e() == Strength.STRONG && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, o.a.h());
        }
        if (mapMaker.e() == Strength.WEAK && mapMaker.f() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, s.a.h());
        }
        if (mapMaker.e() == Strength.WEAK && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, t.a.h());
        }
        throw new AssertionError();
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        if (mapMaker.e() == Strength.STRONG && mapMaker.f() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, m.a.h());
        }
        if (mapMaker.e() == Strength.WEAK && mapMaker.f() == Strength.STRONG) {
            return new MapMakerInternalMap<>(mapMaker, r.a.h());
        }
        if (mapMaker.f() == Strength.WEAK) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    public static int rehash(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    public static <K, V, E extends h<K, V, E>> v<K, V, E> unsetWeakValueReference() {
        return (v<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.collect.MapMakerInternalMap$WeakKeyWeakValueSegment */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>>[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (WeakKeyWeakValueSegment weakKeyWeakValueSegment : segmentArr) {
                int i3 = weakKeyWeakValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = weakKeyWeakValueSegment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E e2 = atomicReferenceArray.get(i4); e2 != null; e2 = e2.getNext()) {
                        Object liveValue = weakKeyWeakValueSegment.getLiveValue(e2);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j3 += weakKeyWeakValueSegment.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    public E copyEntry(E e2, E e3) {
        return segmentFor(e2.getHash()).copyEntry(e2, e3);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>, com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
    public Segment<K, V, E, S> createSegment(int i2, int i3) {
        return (S) this.entryHelper.f(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    public E getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public V getLiveValue(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return (V) e2.getValue();
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j2 += segmentArr[i2].modCount;
        }
        if (j2 != 0) {
            for (int i3 = 0; i3 < segmentArr.length; i3++) {
                if (segmentArr[i3].count != 0) {
                    return false;
                }
                j2 -= segmentArr[i3].modCount;
            }
            return j2 == 0;
        }
        return true;
    }

    public boolean isLiveForTesting(h<K, V, ?> hVar) {
        return segmentFor(hVar.getHash()).getLiveValueForTesting(hVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.keySet = kVar;
        return kVar;
    }

    public Strength keyStrength() {
        return this.entryHelper.b();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        d.g.c.a.n.p(k2);
        d.g.c.a.n.p(v2);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        d.g.c.a.n.p(k2);
        d.g.c.a.n.p(v2);
        int hash = hash(k2);
        return segmentFor(hash).put(k2, hash, v2, true);
    }

    public void reclaimKey(E e2) {
        int hash = e2.getHash();
        segmentFor(hash).reclaimKey(e2, hash);
    }

    public void reclaimValue(v<K, V, E> vVar) {
        E a2 = vVar.a();
        int hash = a2.getHash();
        segmentFor(hash).reclaimValue((K) a2.getKey(), hash, vVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, V v2, V v3) {
        d.g.c.a.n.p(k2);
        d.g.c.a.n.p(v3);
        if (v2 == null) {
            return false;
        }
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v2, v3);
    }

    public Segment<K, V, E, S> segmentFor(int i2) {
        return this.segments[(i2 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (Segment<K, V, E, S> segment : this.segments) {
            j2 += segment.count;
        }
        return Ints.j(j2);
    }

    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.d().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        q qVar = new q();
        this.values = qVar;
        return qVar;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.b(), this.entryHelper.d(), this.keyEquivalence, this.entryHelper.d().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* loaded from: classes6.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends d.g.c.c.s<K, V> implements Serializable {
        public static final long serialVersionUID = 3;
        public final int concurrencyLevel;
        public transient ConcurrentMap<K, V> delegate;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i2, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i2;
            this.delegate = concurrentMap;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.concurrent.ConcurrentMap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            int readInt = objectInputStream.readInt();
            MapMaker mapMaker = new MapMaker();
            mapMaker.g(readInt);
            mapMaker.j(this.keyStrength);
            mapMaker.k(this.valueStrength);
            mapMaker.h(this.keyEquivalence);
            mapMaker.a(this.concurrencyLevel);
            return mapMaker;
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.s, d.g.c.c.u, d.g.c.c.y
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        d.g.c.a.n.p(k2);
        d.g.c.a.n.p(v2);
        int hash = hash(k2);
        return segmentFor(hash).replace(k2, hash, v2);
    }

    /* loaded from: classes6.dex */
    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        public volatile int count;
        public final MapMakerInternalMap<K, V, E, S> map;
        public final int maxSegmentSize;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2, int i3) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i3;
            initTable(newEntryArray(i2));
        }

        public static <K, V, E extends h<K, V, E>> boolean isCollected(E e2) {
            return e2.getValue() == null;
        }

        public abstract E castForTesting(h<K, V, ?> hVar);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean clearValueForTesting(K k, int i2, v<K, V, ? extends h<K, V, ?>> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((u) hVar).getValueReference() == vVar) {
                            atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i2) {
            try {
                boolean z = false;
                if (this.count != 0) {
                    E liveEntry = getLiveEntry(obj, i2);
                    if (liveEntry != null) {
                        if (liveEntry.getValue() != null) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        for (E e2 = atomicReferenceArray.get(i2); e2 != null; e2 = e2.getNext()) {
                            Object liveValue = getLiveValue(e2);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public E copyEntry(E e2, E e3) {
            return this.map.entryHelper.c(self(), e2, e3);
        }

        public E copyForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return this.map.entryHelper.c(self(), castForTesting(hVar), castForTesting(hVar2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((h) poll);
                i2++;
            } while (i2 != 16);
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((v) poll);
                i2++;
            } while (i2 != 16);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i2 = this.count;
            AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (atomicReferenceArray2.length() * 3) / 4;
            int length2 = atomicReferenceArray2.length() - 1;
            for (int i3 = 0; i3 < length; i3++) {
                E e2 = atomicReferenceArray.get(i3);
                if (e2 != null) {
                    h next = e2.getNext();
                    int hash = e2.getHash() & length2;
                    if (next == null) {
                        atomicReferenceArray2.set(hash, e2);
                    } else {
                        h hVar = e2;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        atomicReferenceArray2.set(hash, hVar);
                        while (e2 != hVar) {
                            int hash3 = e2.getHash() & length2;
                            h copyEntry = copyEntry(e2, (h) atomicReferenceArray2.get(hash3));
                            if (copyEntry != null) {
                                atomicReferenceArray2.set(hash3, copyEntry);
                            } else {
                                i2--;
                            }
                            e2 = e2.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArray2;
            this.count = i2;
        }

        public V get(Object obj, int i2) {
            try {
                E liveEntry = getLiveEntry(obj, i2);
                if (liveEntry == null) {
                    return null;
                }
                V v = (V) liveEntry.getValue();
                if (v == null) {
                    tryDrainReferenceQueues();
                }
                return v;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i2) {
            if (this.count != 0) {
                for (E first = getFirst(i2); first != null; first = (E) first.getNext()) {
                    if (first.getHash() == i2) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
                return null;
            }
            return null;
        }

        public E getFirst(int i2) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i2) {
            return getEntry(obj, i2);
        }

        public V getLiveValue(E e2) {
            if (e2.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = (V) e2.getValue();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            return v;
        }

        public V getLiveValueForTesting(h<K, V, ?> hVar) {
            return getLiveValue(castForTesting(hVar));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public v<K, V, E> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i2) {
            return new AtomicReferenceArray<>(i2);
        }

        public E newEntryForTesting(K k, int i2, h<K, V, ?> hVar) {
            return this.map.entryHelper.e(self(), k, i2, castForTesting(hVar));
        }

        public v<K, V, E> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k, int i2, V v, boolean z) {
            lock();
            try {
                preWriteCleanup();
                int i3 = this.count + 1;
                if (i3 > this.threshold) {
                    expand();
                    i3 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) hVar.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            setValue(hVar, v);
                            this.count = this.count;
                            return null;
                        } else if (z) {
                            return v2;
                        } else {
                            this.modCount++;
                            setValue(hVar, v);
                            return v2;
                        }
                    }
                }
                this.modCount++;
                E e3 = this.map.entryHelper.e(self(), k, i2, e2);
                setValue(e3, v);
                atomicReferenceArray.set(length, e3);
                this.count = i3;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimKey(E e2, int i2) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i2 & (atomicReferenceArray.length() - 1);
                E e3 = atomicReferenceArray.get(length);
                for (h hVar = e3; hVar != null; hVar = hVar.getNext()) {
                    if (hVar == e2) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e3, hVar));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimValue(K k, int i2, v<K, V, E> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        if (((u) hVar).getValueReference() == vVar) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                            this.count--;
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V remove(Object obj, int i2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v = (V) hVar.getValue();
                        if (v == null && !isCollected(hVar)) {
                            return null;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                        this.count--;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean removeEntryForTesting(E e2) {
            int hash = e2.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            E e3 = atomicReferenceArray.get(length);
            for (h hVar = e3; hVar != null; hVar = hVar.getNext()) {
                if (hVar == e2) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeFromChain(e3, hVar));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        public E removeFromChain(E e2, E e3) {
            int i2 = this.count;
            E e4 = (E) e3.getNext();
            while (e2 != e3) {
                E copyEntry = copyEntry(e2, e4);
                if (copyEntry != null) {
                    e4 = copyEntry;
                } else {
                    i2--;
                }
                e2 = (E) e2.getNext();
            }
            this.count = i2;
            return e4;
        }

        public E removeFromChainForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return removeFromChain(castForTesting(hVar), castForTesting(hVar2));
        }

        public boolean removeTableEntryForTesting(h<K, V, ?> hVar) {
            return removeEntryForTesting(castForTesting(hVar));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k, int i2, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        Object value = hVar.getValue();
                        if (value == null) {
                            if (isCollected(hVar)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                                this.count--;
                            }
                            return false;
                        } else if (this.map.valueEquivalence().equivalent(v, value)) {
                            this.modCount++;
                            setValue(hVar, v2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i2, h<K, V, ?> hVar) {
            this.table.set(i2, castForTesting(hVar));
        }

        public void setValue(E e2, V v) {
            this.map.entryHelper.a(self(), e2, v);
        }

        public void setValueForTesting(h<K, V, ?> hVar, V v) {
            this.map.entryHelper.a(self(), castForTesting(hVar), v);
        }

        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            if (isCollected(r4) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
            r8.modCount++;
            r0.set(r1, removeFromChain(r3, r4));
            r8.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(Object obj, int i2, Object obj2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                h hVar = e2;
                while (true) {
                    boolean z = false;
                    if (hVar == null) {
                        return false;
                    }
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        break;
                    }
                    hVar = hVar.getNext();
                }
            } finally {
                unlock();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> */
        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k, int i2, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i2;
                E e2 = atomicReferenceArray.get(length);
                for (h hVar = e2; hVar != null; hVar = hVar.getNext()) {
                    Object key = hVar.getKey();
                    if (hVar.getHash() == i2 && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V v2 = (V) hVar.getValue();
                        if (v2 == null) {
                            if (isCollected(hVar)) {
                                this.modCount++;
                                atomicReferenceArray.set(length, removeFromChain(e2, hVar));
                                this.count--;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(hVar, v);
                        return v2;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
