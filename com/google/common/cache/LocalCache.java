package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static final Logger A = Logger.getLogger(LocalCache.class.getName());
    public static final s<Object, Object> B = new a();
    public static final Queue<?> C = new b();

    /* renamed from: e  reason: collision with root package name */
    public final int f30702e;

    /* renamed from: f  reason: collision with root package name */
    public final int f30703f;

    /* renamed from: g  reason: collision with root package name */
    public final Segment<K, V>[] f30704g;

    /* renamed from: h  reason: collision with root package name */
    public final int f30705h;
    public final Equivalence<Object> i;
    public final Equivalence<Object> j;
    public final Strength k;
    public final Strength l;
    public final long m;
    public final d.h.c.b.j<K, V> n;
    public final long o;
    public final long p;
    public final long q;
    public final Queue<RemovalNotification<K, V>> r;
    public final d.h.c.b.i<K, V> s;
    public final d.h.c.a.t t;
    public final EntryFactory u;
    public final d.h.c.b.b v;
    public final CacheLoader<? super K, V> w;
    public Set<K> x;
    public Collection<V> y;
    public Set<Map.Entry<K, V>> z;

    /* loaded from: classes6.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new o(k, i, hVar);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
                d.h.c.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new m(k, i, hVar);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
                d.h.c.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new q(k, i, hVar);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
                d.h.c.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new n(k, i, hVar);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new w(segment.keyReferenceQueue, k, i, hVar);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
                d.h.c.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new u(segment.keyReferenceQueue, k, i, hVar);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
                d.h.c.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new y(segment.keyReferenceQueue, k, i, hVar);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
                d.h.c.b.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar) {
                return new v(segment.keyReferenceQueue, k, i, hVar);
            }
        };
        
        public static final int ACCESS_MASK = 1;
        public static final int WEAK_MASK = 4;
        public static final int WRITE_MASK = 2;
        public static final EntryFactory[] factories;

        static {
            EntryFactory entryFactory = WEAK_ACCESS_WRITE;
            factories = new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, entryFactory};
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        public <K, V> void copyAccessEntry(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
            hVar2.setAccessTime(hVar.getAccessTime());
            LocalCache.c(hVar.getPreviousInAccessQueue(), hVar2);
            LocalCache.c(hVar2, hVar.getNextInAccessQueue());
            LocalCache.x(hVar);
        }

        public <K, V> d.h.c.b.h<K, V> copyEntry(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
            return newEntry(segment, hVar.getKey(), hVar.getHash(), hVar2);
        }

        public <K, V> void copyWriteEntry(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
            hVar2.setWriteTime(hVar.getWriteTime());
            LocalCache.d(hVar.getPreviousInWriteQueue(), hVar2);
            LocalCache.d(hVar2, hVar.getNextInWriteQueue());
            LocalCache.y(hVar);
        }

        public abstract <K, V> d.h.c.b.h<K, V> newEntry(Segment<K, V> segment, K k, int i, d.h.c.b.h<K, V> hVar);

        /* synthetic */ EntryFactory(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements d.h.c.b.f<K, V>, Serializable {
        public static final long serialVersionUID = 1;
        public transient d.h.c.b.f<K, V> autoDelegate;

        public LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.cache.CacheLoader<? super K, V>, com.google.common.cache.CacheLoader<? super K1 extends K, V1 extends V> */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (d.h.c.b.f<K, V>) recreateCacheBuilder().b((CacheLoader<? super K, V>) this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // d.h.c.b.f, d.h.c.a.g
        public final V apply(K k) {
            return this.autoDelegate.apply(k);
        }

        @Override // d.h.c.b.f
        public V get(K k) throws ExecutionException {
            return this.autoDelegate.get(k);
        }

        @Override // d.h.c.b.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // d.h.c.b.f
        public V getUnchecked(K k) {
            return this.autoDelegate.getUnchecked(k);
        }

        @Override // d.h.c.b.f
        public void refresh(K k) {
            this.autoDelegate.refresh(k);
        }
    }

    /* loaded from: classes6.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements d.h.c.b.f<K, V> {
        public static final long serialVersionUID = 1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, cacheLoader), null);
            d.h.c.a.n.p(cacheLoader);
        }

        @Override // d.h.c.b.f, d.h.c.a.g
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // d.h.c.b.f
        public V get(K k) throws ExecutionException {
            return this.localCache.p(k);
        }

        @Override // d.h.c.b.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.l(iterable);
        }

        @Override // d.h.c.b.f
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e2) {
                throw new UncheckedExecutionException(e2.getCause());
            }
        }

        @Override // d.h.c.b.f
        public void refresh(K k) {
            this.localCache.F(k);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* loaded from: classes6.dex */
    public static class LocalManualCache<K, V> implements d.h.c.b.c<K, V>, Serializable {
        public static final long serialVersionUID = 1;
        public final LocalCache<K, V> localCache;

        /* loaded from: classes6.dex */
        public class a extends CacheLoader<Object, V> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Callable f30706a;

            public a(LocalManualCache localManualCache, Callable callable) {
                this.f30706a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.f30706a.call();
            }
        }

        public /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // d.h.c.b.c
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // d.h.c.b.c
        public void cleanUp() {
            this.localCache.b();
        }

        @Override // d.h.c.b.c
        public V get(K k, Callable<? extends V> callable) throws ExecutionException {
            d.h.c.a.n.p(callable);
            return this.localCache.k(k, new a(this, callable));
        }

        @Override // d.h.c.b.c
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.m(iterable);
        }

        @Override // d.h.c.b.c
        public V getIfPresent(Object obj) {
            return this.localCache.n(obj);
        }

        @Override // d.h.c.b.c
        public void invalidate(Object obj) {
            d.h.c.a.n.p(obj);
            this.localCache.remove(obj);
        }

        @Override // d.h.c.b.c
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.r(iterable);
        }

        @Override // d.h.c.b.c
        public void put(K k, V v) {
            this.localCache.put(k, v);
        }

        @Override // d.h.c.b.c
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // d.h.c.b.c
        public long size() {
            return this.localCache.u();
        }

        @Override // d.h.c.b.c
        public d.h.c.b.d stats() {
            d.h.c.b.a aVar = new d.h.c.b.a();
            aVar.g(this.localCache.v);
            for (Segment<K, V> segment : this.localCache.f30704g) {
                aVar.g(segment.statsCounter);
            }
            return aVar.f();
        }

        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // d.h.c.b.c
        public void invalidateAll() {
            this.localCache.clear();
        }

        public LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    /* loaded from: classes6.dex */
    public static class ManualSerializationProxy<K, V> extends d.h.c.b.e<K, V> implements Serializable {
        public static final long serialVersionUID = 1;
        public final int concurrencyLevel;
        public transient d.h.c.b.c<K, V> delegate;
        public final long expireAfterAccessNanos;
        public final long expireAfterWriteNanos;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final CacheLoader<? super K, V> loader;
        public final long maxWeight;
        public final d.h.c.b.i<? super K, ? super V> removalListener;
        public final d.h.c.a.t ticker;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;
        public final d.h.c.b.j<K, V> weigher;

        public ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.k, localCache.l, localCache.i, localCache.j, localCache.p, localCache.o, localCache.m, localCache.n, localCache.f30705h, localCache.s, localCache.t, localCache.w);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (d.h.c.b.c<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: d.h.c.b.i<? super K, ? super V>, d.h.c.b.i<? super K1 extends K, ? super V1 extends V> */
        /* JADX DEBUG: Type inference failed for r1v9. Raw type applied. Possible types: d.h.c.b.j<K, V>, d.h.c.b.j<? super K1 extends K, ? super V1 extends V> */
        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.y();
            cacheBuilder.A(this.keyStrength);
            cacheBuilder.B(this.valueStrength);
            cacheBuilder.v(this.keyEquivalence);
            cacheBuilder.D(this.valueEquivalence);
            cacheBuilder.e(this.concurrencyLevel);
            cacheBuilder.z(this.removalListener);
            cacheBuilder.f30689a = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.g(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.f(j2, TimeUnit.NANOSECONDS);
            }
            d.h.c.b.j jVar = this.weigher;
            if (jVar != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.E(jVar);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.x(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.w(j4);
                }
            }
            d.h.c.a.t tVar = this.ticker;
            if (tVar != null) {
                cacheBuilder.C(tVar);
            }
            return cacheBuilder;
        }

        public ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, d.h.c.b.j<K, V> jVar, int i, d.h.c.b.i<? super K, ? super V> iVar, d.h.c.a.t tVar, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = jVar;
            this.concurrencyLevel = i;
            this.removalListener = iVar;
            this.ticker = (tVar == d.h.c.a.t.b() || tVar == CacheBuilder.s) ? null : null;
            this.loader = cacheLoader;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.b.e, d.h.c.c.y
        public d.h.c.b.c<K, V> delegate() {
            return this.delegate;
        }
    }

    /* loaded from: classes6.dex */
    public enum NullEntry implements d.h.c.b.h<Object, Object> {
        INSTANCE;

        @Override // d.h.c.b.h
        public long getAccessTime() {
            return 0L;
        }

        @Override // d.h.c.b.h
        public int getHash() {
            return 0;
        }

        @Override // d.h.c.b.h
        public Object getKey() {
            return null;
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<Object, Object> getNext() {
            return null;
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // d.h.c.b.h
        public s<Object, Object> getValueReference() {
            return null;
        }

        @Override // d.h.c.b.h
        public long getWriteTime() {
            return 0L;
        }

        @Override // d.h.c.b.h
        public void setAccessTime(long j) {
        }

        @Override // d.h.c.b.h
        public void setNextInAccessQueue(d.h.c.b.h<Object, Object> hVar) {
        }

        @Override // d.h.c.b.h
        public void setNextInWriteQueue(d.h.c.b.h<Object, Object> hVar) {
        }

        @Override // d.h.c.b.h
        public void setPreviousInAccessQueue(d.h.c.b.h<Object, Object> hVar) {
        }

        @Override // d.h.c.b.h
        public void setPreviousInWriteQueue(d.h.c.b.h<Object, Object> hVar) {
        }

        @Override // d.h.c.b.h
        public void setValueReference(s<Object, Object> sVar) {
        }

        @Override // d.h.c.b.h
        public void setWriteTime(long j) {
        }
    }

    /* loaded from: classes6.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, V v, int i) {
                return i == 1 ? new p(v) : new a0(v, i);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, V v, int i) {
                return i == 1 ? new l(segment.valueReferenceQueue, v, hVar) : new z(segment.valueReferenceQueue, v, hVar, i);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, V v, int i) {
                return i == 1 ? new x(segment.valueReferenceQueue, v, hVar) : new b0(segment.valueReferenceQueue, v, hVar, i);
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> s<K, V> referenceValue(Segment<K, V> segment, d.h.c.b.h<K, V> hVar, V v, int i);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements s<Object, Object> {
        @Override // com.google.common.cache.LocalCache.s
        public d.h.c.b.h<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean d() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<Object, Object> e(ReferenceQueue<Object> referenceQueue, Object obj, d.h.c.b.h<Object, Object> hVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object f() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a0<K, V> extends p<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public final int f30711f;

        public a0(V v, int i) {
            super(v);
            this.f30711f = i;
        }

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f30711f;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b0<K, V> extends x<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public final int f30712f;

        public b0(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar, int i) {
            super(referenceQueue, v, hVar);
            this.f30712f = i;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f30712f;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            return new b0(referenceQueue, v, hVar, this.f30712f);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> extends AbstractSet<T> {

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentMap<?, ?> f30713e;

        public c(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f30713e = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f30713e.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f30713e.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f30713e.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c0<K, V> extends AbstractQueue<d.h.c.b.h<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final d.h.c.b.h<K, V> f30714e = new a(this);

        /* loaded from: classes6.dex */
        public class a extends d<K, V> {

            /* renamed from: e  reason: collision with root package name */
            public d.h.c.b.h<K, V> f30715e = this;

            /* renamed from: f  reason: collision with root package name */
            public d.h.c.b.h<K, V> f30716f = this;

            public a(c0 c0Var) {
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public d.h.c.b.h<K, V> getNextInWriteQueue() {
                return this.f30715e;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
                return this.f30716f;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
                this.f30715e = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
                this.f30716f = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public void setWriteTime(long j) {
            }
        }

        /* loaded from: classes6.dex */
        public class b extends d.h.c.c.g<d.h.c.b.h<K, V>> {
            public b(d.h.c.b.h hVar) {
                super(hVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.h.c.c.g
            /* renamed from: b */
            public d.h.c.b.h<K, V> a(d.h.c.b.h<K, V> hVar) {
                d.h.c.b.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
                if (nextInWriteQueue == c0.this.f30714e) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(d.h.c.b.h<K, V> hVar) {
            LocalCache.d(hVar.getPreviousInWriteQueue(), hVar.getNextInWriteQueue());
            LocalCache.d(this.f30714e.getPreviousInWriteQueue(), hVar);
            LocalCache.d(hVar, this.f30714e);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: b */
        public d.h.c.b.h<K, V> peek() {
            d.h.c.b.h<K, V> nextInWriteQueue = this.f30714e.getNextInWriteQueue();
            if (nextInWriteQueue == this.f30714e) {
                return null;
            }
            return nextInWriteQueue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: c */
        public d.h.c.b.h<K, V> poll() {
            d.h.c.b.h<K, V> nextInWriteQueue = this.f30714e.getNextInWriteQueue();
            if (nextInWriteQueue == this.f30714e) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            d.h.c.b.h<K, V> nextInWriteQueue = this.f30714e.getNextInWriteQueue();
            while (true) {
                d.h.c.b.h<K, V> hVar = this.f30714e;
                if (nextInWriteQueue != hVar) {
                    d.h.c.b.h<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.y(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    hVar.setNextInWriteQueue(hVar);
                    d.h.c.b.h<K, V> hVar2 = this.f30714e;
                    hVar2.setPreviousInWriteQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((d.h.c.b.h) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f30714e.getNextInWriteQueue() == this.f30714e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<d.h.c.b.h<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            d.h.c.b.h hVar = (d.h.c.b.h) obj;
            d.h.c.b.h<K, V> previousInWriteQueue = hVar.getPreviousInWriteQueue();
            d.h.c.b.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
            LocalCache.d(previousInWriteQueue, nextInWriteQueue);
            LocalCache.y(hVar);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (d.h.c.b.h<K, V> nextInWriteQueue = this.f30714e.getNextInWriteQueue(); nextInWriteQueue != this.f30714e; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d<K, V> implements d.h.c.b.h<K, V> {
        @Override // d.h.c.b.h
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public s<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setValueReference(s<K, V> sVar) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    public final class d0 implements Map.Entry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f30718e;

        /* renamed from: f  reason: collision with root package name */
        public V f30719f;

        public d0(K k, V v) {
            this.f30718e = k;
            this.f30719f = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.f30718e.equals(entry.getKey()) && this.f30719f.equals(entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f30718e;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f30719f;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f30718e.hashCode() ^ this.f30719f.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.f30718e, v);
            this.f30719f = v;
            return v2;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes6.dex */
    public static final class e<K, V> extends AbstractQueue<d.h.c.b.h<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final d.h.c.b.h<K, V> f30721e = new a(this);

        /* loaded from: classes6.dex */
        public class a extends d<K, V> {

            /* renamed from: e  reason: collision with root package name */
            public d.h.c.b.h<K, V> f30722e = this;

            /* renamed from: f  reason: collision with root package name */
            public d.h.c.b.h<K, V> f30723f = this;

            public a(e eVar) {
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public d.h.c.b.h<K, V> getNextInAccessQueue() {
                return this.f30722e;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
                return this.f30723f;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
                this.f30722e = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
            public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
                this.f30723f = hVar;
            }
        }

        /* loaded from: classes6.dex */
        public class b extends d.h.c.c.g<d.h.c.b.h<K, V>> {
            public b(d.h.c.b.h hVar) {
                super(hVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.h.c.c.g
            /* renamed from: b */
            public d.h.c.b.h<K, V> a(d.h.c.b.h<K, V> hVar) {
                d.h.c.b.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.f30721e) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(d.h.c.b.h<K, V> hVar) {
            LocalCache.c(hVar.getPreviousInAccessQueue(), hVar.getNextInAccessQueue());
            LocalCache.c(this.f30721e.getPreviousInAccessQueue(), hVar);
            LocalCache.c(hVar, this.f30721e);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: b */
        public d.h.c.b.h<K, V> peek() {
            d.h.c.b.h<K, V> nextInAccessQueue = this.f30721e.getNextInAccessQueue();
            if (nextInAccessQueue == this.f30721e) {
                return null;
            }
            return nextInAccessQueue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Queue
        /* renamed from: c */
        public d.h.c.b.h<K, V> poll() {
            d.h.c.b.h<K, V> nextInAccessQueue = this.f30721e.getNextInAccessQueue();
            if (nextInAccessQueue == this.f30721e) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            d.h.c.b.h<K, V> nextInAccessQueue = this.f30721e.getNextInAccessQueue();
            while (true) {
                d.h.c.b.h<K, V> hVar = this.f30721e;
                if (nextInAccessQueue != hVar) {
                    d.h.c.b.h<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.x(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    hVar.setNextInAccessQueue(hVar);
                    d.h.c.b.h<K, V> hVar2 = this.f30721e;
                    hVar2.setPreviousInAccessQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((d.h.c.b.h) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f30721e.getNextInAccessQueue() == this.f30721e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<d.h.c.b.h<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            d.h.c.b.h hVar = (d.h.c.b.h) obj;
            d.h.c.b.h<K, V> previousInAccessQueue = hVar.getPreviousInAccessQueue();
            d.h.c.b.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
            LocalCache.c(previousInAccessQueue, nextInAccessQueue);
            LocalCache.x(hVar);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (d.h.c.b.h<K, V> nextInAccessQueue = this.f30721e.getNextInAccessQueue(); nextInAccessQueue != this.f30721e; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        public f(LocalCache localCache) {
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
    public final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        public g(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.j.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* loaded from: classes6.dex */
    public abstract class h<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f30726e;

        /* renamed from: f  reason: collision with root package name */
        public int f30727f = -1;

        /* renamed from: g  reason: collision with root package name */
        public Segment<K, V> f30728g;

        /* renamed from: h  reason: collision with root package name */
        public AtomicReferenceArray<d.h.c.b.h<K, V>> f30729h;
        public d.h.c.b.h<K, V> i;
        public LocalCache<K, V>.d0 j;
        public LocalCache<K, V>.d0 k;

        public h() {
            this.f30726e = LocalCache.this.f30704g.length - 1;
            a();
        }

        public final void a() {
            this.j = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.f30726e;
                if (i < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.f30704g;
                this.f30726e = i - 1;
                Segment<K, V> segment = segmentArr[i];
                this.f30728g = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.f30728g.table;
                    this.f30729h = atomicReferenceArray;
                    this.f30727f = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(d.h.c.b.h<K, V> hVar) {
            boolean z;
            try {
                long a2 = LocalCache.this.t.a();
                K key = hVar.getKey();
                Object o = LocalCache.this.o(hVar, a2);
                if (o != null) {
                    this.j = new d0(key, o);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.f30728g.postReadCleanup();
            }
        }

        public LocalCache<K, V>.d0 c() {
            LocalCache<K, V>.d0 d0Var = this.j;
            if (d0Var != null) {
                this.k = d0Var;
                a();
                return this.k;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            d.h.c.b.h<K, V> hVar = this.i;
            if (hVar == null) {
                return false;
            }
            while (true) {
                this.i = hVar.getNext();
                d.h.c.b.h<K, V> hVar2 = this.i;
                if (hVar2 == null) {
                    return false;
                }
                if (b(hVar2)) {
                    return true;
                }
                hVar = this.i;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.f30727f;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.f30729h;
                this.f30727f = i - 1;
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(i);
                this.i = hVar;
                if (hVar != null && (b(hVar) || d())) {
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
            d.h.c.a.n.w(this.k != null);
            LocalCache.this.remove(this.k.getKey());
            this.k = null;
        }
    }

    /* loaded from: classes6.dex */
    public final class i extends LocalCache<K, V>.h<K> {
        public i(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: classes6.dex */
    public final class j extends LocalCache<K, V>.c<K> {
        public j(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f30713e.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f30713e.remove(obj) != null;
        }
    }

    /* loaded from: classes6.dex */
    public static class k<K, V> implements s<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public volatile s<K, V> f30731e;

        /* renamed from: f  reason: collision with root package name */
        public final d.h.c.i.a.q<V> f30732f;

        /* renamed from: g  reason: collision with root package name */
        public final d.h.c.a.p f30733g;

        /* loaded from: classes6.dex */
        public class a implements d.h.c.a.g<V, V> {
            public a() {
            }

            @Override // d.h.c.a.g
            public V apply(V v) {
                k.this.k(v);
                return v;
            }
        }

        public k() {
            this(LocalCache.K());
        }

        @Override // com.google.common.cache.LocalCache.s
        public d.h.c.b.h<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
            if (v != null) {
                k(v);
            } else {
                this.f30731e = LocalCache.K();
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return this.f30731e.c();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean d() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V f() throws ExecutionException {
            return (V) d.h.c.i.a.t.a(this.f30732f);
        }

        public long g() {
            return this.f30733g.e(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f30731e.get();
        }

        public final d.h.c.i.a.l<V> h(Throwable th) {
            return d.h.c.i.a.g.c(th);
        }

        public s<K, V> i() {
            return this.f30731e;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return this.f30731e.isActive();
        }

        public d.h.c.i.a.l<V> j(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f30733g.g();
                V v = this.f30731e.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return k(load) ? this.f30732f : d.h.c.i.a.g.d(load);
                }
                d.h.c.i.a.l<V> reload = cacheLoader.reload(k, v);
                if (reload == null) {
                    return d.h.c.i.a.g.d(null);
                }
                return d.h.c.i.a.g.e(reload, new a(), d.h.c.i.a.n.a());
            } catch (Throwable th) {
                d.h.c.i.a.l<V> h2 = l(th) ? this.f30732f : h(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return h2;
            }
        }

        public boolean k(V v) {
            return this.f30732f.A(v);
        }

        public boolean l(Throwable th) {
            return this.f30732f.B(th);
        }

        public k(s<K, V> sVar) {
            this.f30732f = d.h.c.i.a.q.F();
            this.f30733g = d.h.c.a.p.d();
            this.f30731e = sVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class l<K, V> extends SoftReference<V> implements s<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final d.h.c.b.h<K, V> f30735e;

        public l(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            super(v, referenceQueue);
            this.f30735e = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public d.h.c.b.h<K, V> a() {
            return this.f30735e;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean d() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            return new l(referenceQueue, v, hVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V f() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static final class m<K, V> extends o<K, V> {
        public volatile long i;
        public d.h.c.b.h<K, V> j;
        public d.h.c.b.h<K, V> k;

        public m(K k, int i, d.h.c.b.h<K, V> hVar) {
            super(k, i, hVar);
            this.i = Long.MAX_VALUE;
            this.j = LocalCache.w();
            this.k = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public long getAccessTime() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInAccessQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
            return this.k;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setAccessTime(long j) {
            this.i = j;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.k = hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class n<K, V> extends o<K, V> {
        public volatile long i;
        public d.h.c.b.h<K, V> j;
        public d.h.c.b.h<K, V> k;
        public volatile long l;
        public d.h.c.b.h<K, V> m;
        public d.h.c.b.h<K, V> n;

        public n(K k, int i, d.h.c.b.h<K, V> hVar) {
            super(k, i, hVar);
            this.i = Long.MAX_VALUE;
            this.j = LocalCache.w();
            this.k = LocalCache.w();
            this.l = Long.MAX_VALUE;
            this.m = LocalCache.w();
            this.n = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public long getAccessTime() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInAccessQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInWriteQueue() {
            return this.m;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
            return this.k;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
            return this.n;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public long getWriteTime() {
            return this.l;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setAccessTime(long j) {
            this.i = j;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.k = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.n = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setWriteTime(long j) {
            this.l = j;
        }
    }

    /* loaded from: classes6.dex */
    public static class o<K, V> extends d<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f30736e;

        /* renamed from: f  reason: collision with root package name */
        public final int f30737f;

        /* renamed from: g  reason: collision with root package name */
        public final d.h.c.b.h<K, V> f30738g;

        /* renamed from: h  reason: collision with root package name */
        public volatile s<K, V> f30739h = LocalCache.K();

        public o(K k, int i, d.h.c.b.h<K, V> hVar) {
            this.f30736e = k;
            this.f30737f = i;
            this.f30738g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public int getHash() {
            return this.f30737f;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public K getKey() {
            return this.f30736e;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getNext() {
            return this.f30738g;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public s<K, V> getValueReference() {
            return this.f30739h;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setValueReference(s<K, V> sVar) {
            this.f30739h = sVar;
        }
    }

    /* loaded from: classes6.dex */
    public static class p<K, V> implements s<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final V f30740e;

        public p(V v) {
            this.f30740e = v;
        }

        @Override // com.google.common.cache.LocalCache.s
        public d.h.c.b.h<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean d() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V f() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f30740e;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static final class q<K, V> extends o<K, V> {
        public volatile long i;
        public d.h.c.b.h<K, V> j;
        public d.h.c.b.h<K, V> k;

        public q(K k, int i, d.h.c.b.h<K, V> hVar) {
            super(k, i, hVar);
            this.i = Long.MAX_VALUE;
            this.j = LocalCache.w();
            this.k = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInWriteQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
            return this.k;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public long getWriteTime() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.k = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, d.h.c.b.h
        public void setWriteTime(long j) {
            this.i = j;
        }
    }

    /* loaded from: classes6.dex */
    public final class r extends LocalCache<K, V>.h<V> {
        public r(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: classes6.dex */
    public interface s<K, V> {
        d.h.c.b.h<K, V> a();

        void b(V v);

        int c();

        boolean d();

        s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar);

        V f() throws ExecutionException;

        V get();

        boolean isActive();
    }

    /* loaded from: classes6.dex */
    public final class t extends AbstractCollection<V> {

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentMap<?, ?> f30741e;

        public t(ConcurrentMap<?, ?> concurrentMap) {
            this.f30741e = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f30741e.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f30741e.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f30741e.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f30741e.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* loaded from: classes6.dex */
    public static final class u<K, V> extends w<K, V> {

        /* renamed from: h  reason: collision with root package name */
        public volatile long f30743h;
        public d.h.c.b.h<K, V> i;
        public d.h.c.b.h<K, V> j;

        public u(ReferenceQueue<K> referenceQueue, K k, int i, d.h.c.b.h<K, V> hVar) {
            super(referenceQueue, k, i, hVar);
            this.f30743h = Long.MAX_VALUE;
            this.i = LocalCache.w();
            this.j = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public long getAccessTime() {
            return this.f30743h;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInAccessQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setAccessTime(long j) {
            this.f30743h = j;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.j = hVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class v<K, V> extends w<K, V> {

        /* renamed from: h  reason: collision with root package name */
        public volatile long f30744h;
        public d.h.c.b.h<K, V> i;
        public d.h.c.b.h<K, V> j;
        public volatile long k;
        public d.h.c.b.h<K, V> l;
        public d.h.c.b.h<K, V> m;

        public v(ReferenceQueue<K> referenceQueue, K k, int i, d.h.c.b.h<K, V> hVar) {
            super(referenceQueue, k, i, hVar);
            this.f30744h = Long.MAX_VALUE;
            this.i = LocalCache.w();
            this.j = LocalCache.w();
            this.k = Long.MAX_VALUE;
            this.l = LocalCache.w();
            this.m = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public long getAccessTime() {
            return this.f30744h;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInAccessQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInWriteQueue() {
            return this.l;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
            return this.m;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public long getWriteTime() {
            return this.k;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setAccessTime(long j) {
            this.f30744h = j;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.l = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
            this.j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.m = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setWriteTime(long j) {
            this.k = j;
        }
    }

    /* loaded from: classes6.dex */
    public static class w<K, V> extends WeakReference<K> implements d.h.c.b.h<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final int f30745e;

        /* renamed from: f  reason: collision with root package name */
        public final d.h.c.b.h<K, V> f30746f;

        /* renamed from: g  reason: collision with root package name */
        public volatile s<K, V> f30747g;

        public w(ReferenceQueue<K> referenceQueue, K k, int i, d.h.c.b.h<K, V> hVar) {
            super(k, referenceQueue);
            this.f30747g = LocalCache.K();
            this.f30745e = i;
            this.f30746f = hVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public int getHash() {
            return this.f30745e;
        }

        @Override // d.h.c.b.h
        public K getKey() {
            return get();
        }

        @Override // d.h.c.b.h
        public d.h.c.b.h<K, V> getNext() {
            return this.f30746f;
        }

        public d.h.c.b.h<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public d.h.c.b.h<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public d.h.c.b.h<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public s<K, V> getValueReference() {
            return this.f30747g;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // d.h.c.b.h
        public void setValueReference(s<K, V> sVar) {
            this.f30747g = sVar;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    public static class x<K, V> extends WeakReference<V> implements s<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final d.h.c.b.h<K, V> f30748e;

        public x(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            super(v, referenceQueue);
            this.f30748e = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public d.h.c.b.h<K, V> a() {
            return this.f30748e;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v) {
        }

        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean d() {
            return false;
        }

        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            return new x(referenceQueue, v, hVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V f() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public static final class y<K, V> extends w<K, V> {

        /* renamed from: h  reason: collision with root package name */
        public volatile long f30749h;
        public d.h.c.b.h<K, V> i;
        public d.h.c.b.h<K, V> j;

        public y(ReferenceQueue<K> referenceQueue, K k, int i, d.h.c.b.h<K, V> hVar) {
            super(referenceQueue, k, i, hVar);
            this.f30749h = Long.MAX_VALUE;
            this.i = LocalCache.w();
            this.j = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getNextInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public d.h.c.b.h<K, V> getPreviousInWriteQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public long getWriteTime() {
            return this.f30749h;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setNextInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setPreviousInWriteQueue(d.h.c.b.h<K, V> hVar) {
            this.j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, d.h.c.b.h
        public void setWriteTime(long j) {
            this.f30749h = j;
        }
    }

    /* loaded from: classes6.dex */
    public static final class z<K, V> extends l<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public final int f30750f;

        public z(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar, int i) {
            super(referenceQueue, v, hVar);
            this.f30750f = i;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f30750f;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public s<K, V> e(ReferenceQueue<V> referenceQueue, V v, d.h.c.b.h<K, V> hVar) {
            return new z(referenceQueue, v, hVar, this.f30750f);
        }
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        this.f30705h = Math.min(cacheBuilder.h(), 65536);
        this.k = cacheBuilder.m();
        this.l = cacheBuilder.t();
        this.i = cacheBuilder.l();
        this.j = cacheBuilder.s();
        this.m = cacheBuilder.n();
        this.n = (d.h.c.b.j<K, V>) cacheBuilder.u();
        this.o = cacheBuilder.i();
        this.p = cacheBuilder.j();
        this.q = cacheBuilder.o();
        d.h.c.b.i<K, V> iVar = (d.h.c.b.i<K, V>) cacheBuilder.p();
        this.s = iVar;
        this.r = iVar == CacheBuilder.NullListener.INSTANCE ? g() : new ConcurrentLinkedQueue<>();
        this.t = cacheBuilder.r(D());
        this.u = EntryFactory.getFactory(this.k, L(), P());
        this.v = cacheBuilder.q().get();
        this.w = cacheLoader;
        int min = Math.min(cacheBuilder.k(), 1073741824);
        if (h() && !f()) {
            min = (int) Math.min(min, this.m);
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.f30705h && (!h() || i4 * 20 <= this.m)) {
            i5++;
            i4 <<= 1;
        }
        this.f30703f = 32 - i5;
        this.f30702e = i4 - 1;
        this.f30704g = v(i4);
        int i6 = min / i4;
        while (i3 < (i6 * i4 < min ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        if (h()) {
            long j2 = this.m;
            long j3 = i4;
            long j4 = (j2 / j3) + 1;
            long j5 = j2 % j3;
            while (i2 < this.f30704g.length) {
                if (i2 == j5) {
                    j4--;
                }
                this.f30704g[i2] = e(i3, j4, cacheBuilder.q().get());
                i2++;
            }
            return;
        }
        while (true) {
            Segment<K, V>[] segmentArr = this.f30704g;
            if (i2 >= segmentArr.length) {
                return;
            }
            segmentArr[i2] = e(i3, -1L, cacheBuilder.q().get());
            i2++;
        }
    }

    public static int H(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    public static <E> ArrayList<E> J(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> s<K, V> K() {
        return (s<K, V>) B;
    }

    public static <K, V> void c(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
        hVar.setNextInAccessQueue(hVar2);
        hVar2.setPreviousInAccessQueue(hVar);
    }

    public static <K, V> void d(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
        hVar.setNextInWriteQueue(hVar2);
        hVar2.setPreviousInWriteQueue(hVar);
    }

    public static <E> Queue<E> g() {
        return (Queue<E>) C;
    }

    public static <K, V> d.h.c.b.h<K, V> w() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void x(d.h.c.b.h<K, V> hVar) {
        d.h.c.b.h<K, V> w2 = w();
        hVar.setNextInAccessQueue(w2);
        hVar.setPreviousInAccessQueue(w2);
    }

    public static <K, V> void y(d.h.c.b.h<K, V> hVar) {
        d.h.c.b.h<K, V> w2 = w();
        hVar.setNextInWriteQueue(w2);
        hVar.setPreviousInWriteQueue(w2);
    }

    public void A(d.h.c.b.h<K, V> hVar) {
        int hash = hVar.getHash();
        I(hash).reclaimKey(hVar, hash);
    }

    public void B(s<K, V> sVar) {
        d.h.c.b.h<K, V> a2 = sVar.a();
        int hash = a2.getHash();
        I(hash).reclaimValue(a2.getKey(), hash, sVar);
    }

    public boolean C() {
        return i();
    }

    public boolean D() {
        return E() || C();
    }

    public boolean E() {
        return j() || G();
    }

    public void F(K k2) {
        d.h.c.a.n.p(k2);
        int q2 = q(k2);
        I(q2).refresh(k2, q2, this.w, false);
    }

    public boolean G() {
        return this.q > 0;
    }

    public Segment<K, V> I(int i2) {
        return this.f30704g[(i2 >>> this.f30703f) & this.f30702e];
    }

    public boolean L() {
        return M() || C();
    }

    public boolean M() {
        return i() || h();
    }

    public boolean N() {
        return this.k != Strength.STRONG;
    }

    public boolean O() {
        return this.l != Strength.STRONG;
    }

    public boolean P() {
        return Q() || E();
    }

    public boolean Q() {
        return j();
    }

    public void b() {
        for (Segment<K, V> segment : this.f30704g) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f30704g) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int q2 = q(obj);
        return I(q2).containsKey(obj, q2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long a2 = this.t.a();
        Segment<K, V>[] segmentArr = this.f30704g;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = segmentArr.length;
            int i3 = 0;
            while (i3 < length) {
                Segment<K, V> segment = segmentArr[i3];
                int i4 = segment.count;
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = segment.table;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(i5);
                    while (hVar != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(hVar, a2);
                        long j4 = a2;
                        if (liveValue != null && this.j.equivalent(obj, liveValue)) {
                            return true;
                        }
                        hVar = hVar.getNext();
                        segmentArr = segmentArr2;
                        a2 = j4;
                    }
                }
                j3 += segment.modCount;
                i3++;
                a2 = a2;
            }
            long j5 = a2;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
            segmentArr = segmentArr3;
            a2 = j5;
        }
        return false;
    }

    public Segment<K, V> e(int i2, long j2, d.h.c.b.b bVar) {
        return new Segment<>(this, i2, j2, bVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.z;
        if (set != null) {
            return set;
        }
        g gVar = new g(this);
        this.z = gVar;
        return gVar;
    }

    public boolean f() {
        return this.n != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int q2 = q(obj);
        return I(q2).get(obj, q2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V getOrDefault(Object obj, V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    public boolean h() {
        return this.m >= 0;
    }

    public boolean i() {
        return this.o > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f30704g;
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

    public boolean j() {
        return this.p > 0;
    }

    public V k(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        d.h.c.a.n.p(k2);
        int q2 = q(k2);
        return I(q2).get(k2, q2, cacheLoader);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.x;
        if (set != null) {
            return set;
        }
        j jVar = new j(this);
        this.x = jVar;
        return jVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> l(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap s2 = Maps.s();
        LinkedHashSet f2 = Sets.f();
        int i2 = 0;
        int i3 = 0;
        for (K k2 : iterable) {
            Object obj = get(k2);
            if (!s2.containsKey(k2)) {
                s2.put(k2, obj);
                if (obj == null) {
                    i3++;
                    f2.add(k2);
                } else {
                    i2++;
                }
            }
        }
        try {
            if (!f2.isEmpty()) {
                try {
                    Map t2 = t(f2, this.w);
                    for (Object obj2 : f2) {
                        Object obj3 = t2.get(obj2);
                        if (obj3 != null) {
                            s2.put(obj2, obj3);
                        } else {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : f2) {
                        i3--;
                        s2.put(obj4, k(obj4, this.w));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) s2);
        } finally {
            this.v.a(i2);
            this.v.b(i3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> m(Iterable<?> iterable) {
        LinkedHashMap s2 = Maps.s();
        int i2 = 0;
        int i3 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i3++;
            } else {
                s2.put(obj, v2);
                i2++;
            }
        }
        this.v.a(i2);
        this.v.b(i3);
        return ImmutableMap.copyOf((Map) s2);
    }

    public V n(Object obj) {
        d.h.c.a.n.p(obj);
        int q2 = q(obj);
        V v2 = I(q2).get(obj, q2);
        if (v2 == null) {
            this.v.b(1);
        } else {
            this.v.a(1);
        }
        return v2;
    }

    public V o(d.h.c.b.h<K, V> hVar, long j2) {
        V v2;
        if (hVar.getKey() == null || (v2 = hVar.getValueReference().get()) == null || s(hVar, j2)) {
            return null;
        }
        return v2;
    }

    public V p(K k2) throws ExecutionException {
        return k(k2, this.w);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        d.h.c.a.n.p(k2);
        d.h.c.a.n.p(v2);
        int q2 = q(k2);
        return I(q2).put(k2, q2, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        d.h.c.a.n.p(k2);
        d.h.c.a.n.p(v2);
        int q2 = q(k2);
        return I(q2).put(k2, q2, v2, true);
    }

    public int q(Object obj) {
        return H(this.i.hash(obj));
    }

    public void r(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int q2 = q(obj);
        return I(q2).remove(obj, q2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, V v2, V v3) {
        d.h.c.a.n.p(k2);
        d.h.c.a.n.p(v3);
        if (v2 == null) {
            return false;
        }
        int q2 = q(k2);
        return I(q2).replace(k2, q2, v2, v3);
    }

    public boolean s(d.h.c.b.h<K, V> hVar, long j2) {
        d.h.c.a.n.p(hVar);
        if (!i() || j2 - hVar.getAccessTime() < this.o) {
            return j() && j2 - hVar.getWriteTime() >= this.p;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.j(u());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.cache.LocalCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<K, V> t(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        d.h.c.a.n.p(cacheLoader);
        d.h.c.a.n.p(set);
        d.h.c.a.p c2 = d.h.c.a.p.c();
        boolean z2 = true;
        boolean z3 = false;
        try {
            try {
                try {
                    Map map = (Map<? super K, V>) cacheLoader.loadAll(set);
                    if (map != null) {
                        c2.h();
                        for (Map.Entry<K, V> entry : map.entrySet()) {
                            K key = entry.getKey();
                            V value = entry.getValue();
                            if (key == null || value == null) {
                                z3 = true;
                            } else {
                                put(key, value);
                            }
                        }
                        if (!z3) {
                            this.v.e(c2.e(TimeUnit.NANOSECONDS));
                            return map;
                        }
                        this.v.d(c2.e(TimeUnit.NANOSECONDS));
                        throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
                    }
                    this.v.d(c2.e(TimeUnit.NANOSECONDS));
                    throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
                } catch (CacheLoader.UnsupportedLoadingOperationException e2) {
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        if (!z2) {
                            this.v.d(c2.e(TimeUnit.NANOSECONDS));
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    throw new ExecutionException(e3);
                }
            } catch (Error e4) {
                throw new ExecutionError(e4);
            } catch (InterruptedException e5) {
                Thread.currentThread().interrupt();
                throw new ExecutionException(e5);
            } catch (RuntimeException e6) {
                throw new UncheckedExecutionException(e6);
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            if (!z2) {
            }
            throw th;
        }
    }

    public long u() {
        long j2 = 0;
        for (Segment<K, V> segment : this.f30704g) {
            j2 += Math.max(0, segment.count);
        }
        return j2;
    }

    public final Segment<K, V>[] v(int i2) {
        return new Segment[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.y;
        if (collection != null) {
            return collection;
        }
        t tVar = new t(this);
        this.y = tVar;
        return tVar;
    }

    public void z() {
        while (true) {
            RemovalNotification<K, V> poll = this.r.poll();
            if (poll == null) {
                return;
            }
            try {
                this.s.onRemoval(poll);
            } catch (Throwable th) {
                A.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int q2 = q(obj);
        return I(q2).remove(obj, q2, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        d.h.c.a.n.p(k2);
        d.h.c.a.n.p(v2);
        int q2 = q(k2);
        return I(q2).replace(k2, q2, v2);
    }

    /* loaded from: classes6.dex */
    public static class Segment<K, V> extends ReentrantLock {
        public final Queue<d.h.c.b.h<K, V>> accessQueue;
        public volatile int count;
        public final ReferenceQueue<K> keyReferenceQueue;
        public final LocalCache<K, V> map;
        public final long maxSegmentWeight;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public final Queue<d.h.c.b.h<K, V>> recencyQueue;
        public final d.h.c.b.b statsCounter;
        public volatile AtomicReferenceArray<d.h.c.b.h<K, V>> table;
        public int threshold;
        public long totalWeight;
        public final ReferenceQueue<V> valueReferenceQueue;
        public final Queue<d.h.c.b.h<K, V>> writeQueue;

        /* loaded from: classes6.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f30707e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f30708f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f30709g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ d.h.c.i.a.l f30710h;

            public a(Object obj, int i, k kVar, d.h.c.i.a.l lVar) {
                this.f30707e = obj;
                this.f30708f = i;
                this.f30709g = kVar;
                this.f30710h = lVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.cache.LocalCache$Segment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Segment.this.getAndRecordStats(this.f30707e, this.f30708f, this.f30709g, this.f30710h);
                } catch (Throwable th) {
                    LocalCache.A.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.f30709g.l(th);
                }
            }
        }

        public Segment(LocalCache<K, V> localCache, int i, long j, d.h.c.b.b bVar) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            d.h.c.a.n.p(bVar);
            this.statsCounter = bVar;
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.N() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.O() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.M() ? new ConcurrentLinkedQueue<>() : LocalCache.g();
            this.writeQueue = localCache.Q() ? new c0<>() : LocalCache.g();
            this.accessQueue = localCache.M() ? new e<>() : LocalCache.g();
        }

        public void cleanUp() {
            runLockedCleanup(this.map.t.a());
            runUnlockedCleanup();
        }

        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.t.a());
                    AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(i); hVar != null; hVar = hVar.getNext()) {
                            if (hVar.getValueReference().isActive()) {
                                K key = hVar.getKey();
                                V v = hVar.getValueReference().get();
                                if (key != null && v != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, hVar.getHash(), v, hVar.getValueReference().c(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, hVar.getHash(), v, hVar.getValueReference().c(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        public void clearReferenceQueues() {
            if (this.map.N()) {
                clearKeyReferenceQueue();
            }
            if (this.map.O()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        public boolean containsKey(Object obj, int i) {
            try {
                if (this.count != 0) {
                    d.h.c.b.h<K, V> liveEntry = getLiveEntry(obj, i, this.map.t.a());
                    if (liveEntry == null) {
                        return false;
                    }
                    return liveEntry.getValueReference().get() != null;
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a2 = this.map.t.a();
                    AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(i); hVar != null; hVar = hVar.getNext()) {
                            V liveValue = getLiveValue(hVar, a2);
                            if (liveValue != null && this.map.j.equivalent(obj, liveValue)) {
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

        public d.h.c.b.h<K, V> copyEntry(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
            if (hVar.getKey() == null) {
                return null;
            }
            s<K, V> valueReference = hVar.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            d.h.c.b.h<K, V> copyEntry = this.map.u.copyEntry(this, hVar, hVar2);
            copyEntry.setValueReference(valueReference.e(this.valueReferenceQueue, v, copyEntry));
            return copyEntry;
        }

        public void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.A((d.h.c.b.h) poll);
                i++;
            } while (i != 16);
        }

        public void drainRecencyQueue() {
            while (true) {
                d.h.c.b.h<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        public void drainReferenceQueues() {
            if (this.map.N()) {
                drainKeyReferenceQueue();
            }
            if (this.map.O()) {
                drainValueReferenceQueue();
            }
        }

        public void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.B((s) poll);
                i++;
            } while (i != 16);
        }

        public void enqueueNotification(K k, int i, V v, int i2, RemovalCause removalCause) {
            this.totalWeight -= i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.c();
            }
            if (this.map.r != LocalCache.C) {
                this.map.r.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        public void evictEntries(d.h.c.b.h<K, V> hVar) {
            if (this.map.h()) {
                drainRecencyQueue();
                if (hVar.getValueReference().c() > this.maxSegmentWeight && !removeEntry(hVar, hVar.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    d.h.c.b.h<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        public void expand() {
            AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<d.h.c.b.h<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(i2);
                if (hVar != null) {
                    d.h.c.b.h<K, V> next = hVar.getNext();
                    int hash = hVar.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, hVar);
                    } else {
                        d.h.c.b.h<K, V> hVar2 = hVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, hVar2);
                        while (hVar != hVar2) {
                            int hash3 = hVar.getHash() & length2;
                            d.h.c.b.h<K, V> copyEntry = copyEntry(hVar, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(hVar);
                                i--;
                            }
                            hVar = hVar.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i;
        }

        public void expireEntries(long j) {
            d.h.c.b.h<K, V> peek;
            d.h.c.b.h<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.s(peek, j)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.s(peek2, j)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            d.h.c.b.h<K, V> entry;
            d.h.c.a.n.p(k);
            d.h.c.a.n.p(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k, i)) != null) {
                        long a2 = this.map.t.a();
                        V liveValue = getLiveValue(entry, a2);
                        if (liveValue != null) {
                            recordRead(entry, a2);
                            this.statsCounter.a(1);
                            return scheduleRefresh(entry, k, i, liveValue, a2, cacheLoader);
                        }
                        s<K, V> valueReference = entry.getValueReference();
                        if (valueReference.d()) {
                            return waitForLoadingValue(entry, k, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k, i, cacheLoader);
                } catch (ExecutionException e2) {
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof Error)) {
                        if (cause instanceof RuntimeException) {
                            throw new UncheckedExecutionException(cause);
                        }
                        throw e2;
                    }
                    throw new ExecutionError((Error) cause);
                }
            } finally {
                postReadCleanup();
            }
        }

        public V getAndRecordStats(K k, int i, k<K, V> kVar, d.h.c.i.a.l<V> lVar) throws ExecutionException {
            V v;
            try {
                v = (V) d.h.c.i.a.t.a(lVar);
                try {
                    if (v != null) {
                        this.statsCounter.e(kVar.g());
                        storeLoadedValue(k, i, kVar, v);
                        if (v == null) {
                            this.statsCounter.d(kVar.g());
                            removeLoadingValue(k, i, kVar);
                        }
                        return v;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } catch (Throwable th) {
                    th = th;
                    if (v == null) {
                        this.statsCounter.d(kVar.g());
                        removeLoadingValue(k, i, kVar);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v = null;
            }
        }

        public d.h.c.b.h<K, V> getEntry(Object obj, int i) {
            for (d.h.c.b.h<K, V> first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.i.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public d.h.c.b.h<K, V> getFirst(int i) {
            AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        public d.h.c.b.h<K, V> getLiveEntry(Object obj, int i, long j) {
            d.h.c.b.h<K, V> entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (this.map.s(entry, j)) {
                tryExpireEntries(j);
                return null;
            }
            return entry;
        }

        public V getLiveValue(d.h.c.b.h<K, V> hVar, long j) {
            if (hVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = hVar.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (this.map.s(hVar, j)) {
                tryExpireEntries(j);
                return null;
            } else {
                return v;
            }
        }

        public d.h.c.b.h<K, V> getNextEvictable() {
            for (d.h.c.b.h<K, V> hVar : this.accessQueue) {
                if (hVar.getValueReference().c() > 0) {
                    return hVar;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.f()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        public k<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                for (d.h.c.b.h<K, V> hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null && this.map.i.equivalent(k, key)) {
                        s<K, V> valueReference = hVar2.getValueReference();
                        if (!valueReference.d() && (!z || a2 - hVar2.getWriteTime() >= this.map.q)) {
                            this.modCount++;
                            k<K, V> kVar = new k<>(valueReference);
                            hVar2.setValueReference(kVar);
                            return kVar;
                        }
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar2 = new k<>();
                d.h.c.b.h<K, V> newEntry = newEntry(k, i, hVar);
                newEntry.setValueReference(kVar2);
                atomicReferenceArray.set(length, newEntry);
                return kVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public d.h.c.i.a.l<V> loadAsync(K k, int i, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            d.h.c.i.a.l<V> j = kVar.j(k, cacheLoader);
            j.a(new a(k, i, kVar, j), d.h.c.i.a.n.a());
            return j;
        }

        public V loadSync(K k, int i, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k, i, kVar, kVar.j(k, cacheLoader));
        }

        public V lockedGetOrLoad(K k, int i, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            s<K, V> sVar;
            boolean z;
            V loadSync;
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                int i2 = this.count - 1;
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    kVar = null;
                    if (hVar2 == null) {
                        sVar = null;
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null && this.map.i.equivalent(k, key)) {
                        s<K, V> valueReference = hVar2.getValueReference();
                        if (valueReference.d()) {
                            z = false;
                            sVar = valueReference;
                        } else {
                            V v = valueReference.get();
                            if (v == null) {
                                enqueueNotification(key, i, v, valueReference.c(), RemovalCause.COLLECTED);
                            } else if (this.map.s(hVar2, a2)) {
                                enqueueNotification(key, i, v, valueReference.c(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(hVar2, a2);
                                this.statsCounter.a(1);
                                return v;
                            }
                            this.writeQueue.remove(hVar2);
                            this.accessQueue.remove(hVar2);
                            this.count = i2;
                            sVar = valueReference;
                        }
                    } else {
                        hVar2 = hVar2.getNext();
                    }
                }
                z = true;
                if (z) {
                    kVar = new k<>();
                    if (hVar2 == null) {
                        hVar2 = newEntry(k, i, hVar);
                        hVar2.setValueReference(kVar);
                        atomicReferenceArray.set(length, hVar2);
                    } else {
                        hVar2.setValueReference(kVar);
                    }
                }
                if (z) {
                    try {
                        synchronized (hVar2) {
                            loadSync = loadSync(k, i, kVar, cacheLoader);
                        }
                        return loadSync;
                    } finally {
                        this.statsCounter.b(1);
                    }
                }
                return waitForLoadingValue(hVar2, k, sVar);
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public d.h.c.b.h<K, V> newEntry(K k, int i, d.h.c.b.h<K, V> hVar) {
            EntryFactory entryFactory = this.map.u;
            d.h.c.a.n.p(k);
            return entryFactory.newEntry(this, k, i, hVar);
        }

        public AtomicReferenceArray<d.h.c.b.h<K, V>> newEntryArray(int i) {
            return new AtomicReferenceArray<>(i);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        public void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        public V put(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i && key != null && this.map.i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 != null) {
                                if (z) {
                                    recordLockedRead(hVar2, a2);
                                } else {
                                    this.modCount++;
                                    enqueueNotification(k, i, v2, valueReference.c(), RemovalCause.REPLACED);
                                    setValue(hVar2, k, v, a2);
                                    evictEntries(hVar2);
                                }
                                return v2;
                            }
                            this.modCount++;
                            if (valueReference.isActive()) {
                                enqueueNotification(k, i, v2, valueReference.c(), RemovalCause.COLLECTED);
                                setValue(hVar2, k, v, a2);
                                i2 = this.count;
                            } else {
                                setValue(hVar2, k, v, a2);
                                i2 = this.count + 1;
                            }
                            this.count = i2;
                            evictEntries(hVar2);
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        d.h.c.b.h<K, V> newEntry = newEntry(k, i, hVar);
                        setValue(newEntry, k, v, a2);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(d.h.c.b.h<K, V> hVar, int i) {
            lock();
            try {
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                d.h.c.b.h<K, V> hVar2 = atomicReferenceArray.get(length);
                for (d.h.c.b.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                    if (hVar3 == hVar) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i, hVar3.getValueReference().get(), hVar3.getValueReference(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE]}, finally: {[INVOKE, INVOKE, INVOKE, IF] complete} */
        public boolean reclaimValue(K k, int i, s<K, V> sVar) {
            lock();
            try {
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                for (d.h.c.b.h<K, V> hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null && this.map.i.equivalent(k, key)) {
                        if (hVar2.getValueReference() == sVar) {
                            this.modCount++;
                            atomicReferenceArray.set(length, removeValueFromChain(hVar, hVar2, key, i, sVar.get(), sVar, RemovalCause.COLLECTED));
                            this.count--;
                            return true;
                        }
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        public void recordLockedRead(d.h.c.b.h<K, V> hVar, long j) {
            if (this.map.C()) {
                hVar.setAccessTime(j);
            }
            this.accessQueue.add(hVar);
        }

        public void recordRead(d.h.c.b.h<K, V> hVar, long j) {
            if (this.map.C()) {
                hVar.setAccessTime(j);
            }
            this.recencyQueue.add(hVar);
        }

        public void recordWrite(d.h.c.b.h<K, V> hVar, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.C()) {
                hVar.setAccessTime(j);
            }
            if (this.map.E()) {
                hVar.setWriteTime(j);
            }
            this.accessQueue.add(hVar);
            this.writeQueue.add(hVar);
        }

        public V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            k<K, V> insertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (insertLoadingValueReference == null) {
                return null;
            }
            d.h.c.i.a.l<V> loadAsync = loadAsync(k, i, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) d.h.c.i.a.t.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
            if (r12 == null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
            if (r9.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
            r11.modCount++;
            r0.set(r1, removeValueFromChain(r4, r5, r6, r13, r12, r9, r10));
            r11.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
            return r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup(this.map.t.a());
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null && this.map.i.equivalent(obj, key)) {
                        break;
                    }
                    hVar2 = hVar2.getNext();
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void removeCollectedEntry(d.h.c.b.h<K, V> hVar) {
            enqueueNotification(hVar.getKey(), hVar.getHash(), hVar.getValueReference().get(), hVar.getValueReference().c(), RemovalCause.COLLECTED);
            this.writeQueue.remove(hVar);
            this.accessQueue.remove(hVar);
        }

        public boolean removeEntry(d.h.c.b.h<K, V> hVar, int i, RemovalCause removalCause) {
            AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            d.h.c.b.h<K, V> hVar2 = atomicReferenceArray.get(length);
            for (d.h.c.b.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                if (hVar3 == hVar) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i, hVar3.getValueReference().get(), hVar3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        public d.h.c.b.h<K, V> removeEntryFromChain(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2) {
            int i = this.count;
            d.h.c.b.h<K, V> next = hVar2.getNext();
            while (hVar != hVar2) {
                d.h.c.b.h<K, V> copyEntry = copyEntry(hVar, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(hVar);
                    i--;
                }
                hVar = hVar.getNext();
            }
            this.count = i;
            return next;
        }

        public boolean removeLoadingValue(K k, int i, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null && this.map.i.equivalent(k, key)) {
                        if (hVar2.getValueReference() == kVar) {
                            if (kVar.isActive()) {
                                hVar2.setValueReference(kVar.i());
                            } else {
                                atomicReferenceArray.set(length, removeEntryFromChain(hVar, hVar2));
                            }
                            return true;
                        }
                    } else {
                        hVar2 = hVar2.getNext();
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public d.h.c.b.h<K, V> removeValueFromChain(d.h.c.b.h<K, V> hVar, d.h.c.b.h<K, V> hVar2, K k, int i, V v, s<K, V> sVar, RemovalCause removalCause) {
            enqueueNotification(k, i, v, sVar.c(), removalCause);
            this.writeQueue.remove(hVar2);
            this.accessQueue.remove(hVar2);
            if (sVar.d()) {
                sVar.b(null);
                return hVar;
            }
            return removeEntryFromChain(hVar, hVar2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null) {
                        if (this.map.i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v3 = valueReference.get();
                            if (v3 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    atomicReferenceArray.set(length, removeValueFromChain(hVar, hVar2, key, i, v3, valueReference, RemovalCause.COLLECTED));
                                    this.count--;
                                }
                            } else if (this.map.j.equivalent(v, v3)) {
                                this.modCount++;
                                enqueueNotification(k, i, v3, valueReference.c(), RemovalCause.REPLACED);
                                setValue(hVar2, k, v2, a2);
                                evictEntries(hVar2);
                                return true;
                            } else {
                                recordLockedRead(hVar2, a2);
                            }
                        }
                    }
                    hVar2 = hVar2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.z();
        }

        public V scheduleRefresh(d.h.c.b.h<K, V> hVar, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.G() || j - hVar.getWriteTime() <= this.map.q || hVar.getValueReference().d() || (refresh = refresh(k, i, cacheLoader, true)) == null) ? v : refresh;
        }

        public void setValue(d.h.c.b.h<K, V> hVar, K k, V v, long j) {
            s<K, V> valueReference = hVar.getValueReference();
            int weigh = this.map.n.weigh(k, v);
            d.h.c.a.n.x(weigh >= 0, "Weights must be non-negative");
            hVar.setValueReference(this.map.l.referenceValue(this, hVar, v, weigh));
            recordWrite(hVar, weigh, j);
            valueReference.b(v);
        }

        public boolean storeLoadedValue(K k, int i, k<K, V> kVar, V v) {
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i && key != null && this.map.i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v2 = valueReference.get();
                            if (kVar != valueReference && (v2 != null || valueReference == LocalCache.B)) {
                                enqueueNotification(k, i, v, 0, RemovalCause.REPLACED);
                                return false;
                            }
                            this.modCount++;
                            if (kVar.isActive()) {
                                enqueueNotification(k, i, v2, kVar.c(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i3--;
                            }
                            setValue(hVar2, k, v, a2);
                            this.count = i3;
                            evictEntries(hVar2);
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        d.h.c.b.h<K, V> newEntry = newEntry(k, i, hVar);
                        setValue(newEntry, k, v, a2);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i3;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(d.h.c.b.h<K, V> hVar, K k, s<K, V> sVar) throws ExecutionException {
            if (sVar.d()) {
                d.h.c.a.n.A(!Thread.holdsLock(hVar), "Recursive load of: %s", k);
                try {
                    V f2 = sVar.f();
                    if (f2 != null) {
                        recordRead(hVar, this.map.t.a());
                        return f2;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                } finally {
                    this.statsCounter.b(1);
                }
            }
            throw new AssertionError();
        }

        public V get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long a2 = this.map.t.a();
                    d.h.c.b.h<K, V> liveEntry = getLiveEntry(obj, i, a2);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, a2);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, v, a2, this.map.w);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
            if (r12.map.j.equivalent(r15, r9) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
            if (r9 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
            if (r10.isActive() == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
            r12.modCount++;
            r0.set(r1, removeValueFromChain(r5, r6, r7, r14, r9, r10, r13));
            r12.count--;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean remove(Object obj, int i, Object obj2) {
            lock();
            try {
                preWriteCleanup(this.map.t.a());
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i;
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null && this.map.i.equivalent(obj, key)) {
                        break;
                    }
                    hVar2 = hVar2.getNext();
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V replace(K k, int i, V v) {
            lock();
            try {
                long a2 = this.map.t.a();
                preWriteCleanup(a2);
                AtomicReferenceArray<d.h.c.b.h<K, V>> atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                d.h.c.b.h<K, V> hVar = atomicReferenceArray.get(length);
                d.h.c.b.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i && key != null) {
                        if (this.map.i.equivalent(k, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v2 = valueReference.get();
                            if (v2 == null) {
                                if (valueReference.isActive()) {
                                    this.modCount++;
                                    atomicReferenceArray.set(length, removeValueFromChain(hVar, hVar2, key, i, v2, valueReference, RemovalCause.COLLECTED));
                                    this.count--;
                                }
                            } else {
                                this.modCount++;
                                enqueueNotification(k, i, v2, valueReference.c(), RemovalCause.REPLACED);
                                setValue(hVar2, k, v, a2);
                                evictEntries(hVar2);
                                return v2;
                            }
                        }
                    }
                    hVar2 = hVar2.getNext();
                }
            } finally {
                unlock();
                postWriteCleanup();
            }
        }
    }
}
