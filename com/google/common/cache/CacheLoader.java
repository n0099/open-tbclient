package com.google.common.cache;

import d.h.c.a.g;
import d.h.c.a.n;
import d.h.c.a.r;
import d.h.c.i.a.l;
import d.h.c.i.a.m;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public abstract class CacheLoader<K, V> {

    /* loaded from: classes6.dex */
    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final g<K, V> computingFunction;

        public FunctionToCacheLoader(g<K, V> gVar) {
            n.p(gVar);
            this.computingFunction = gVar;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            g<K, V> gVar = this.computingFunction;
            n.p(k);
            return gVar.apply(k);
        }
    }

    /* loaded from: classes6.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final r<V> computingSupplier;

        public SupplierToCacheLoader(r<V> rVar) {
            n.p(rVar);
            this.computingSupplier = rVar;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            n.p(obj);
            return this.computingSupplier.get();
        }
    }

    /* loaded from: classes6.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    /* loaded from: classes6.dex */
    public static class a extends CacheLoader<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Executor f30698b;

        /* renamed from: com.google.common.cache.CacheLoader$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class CallableC0354a implements Callable<V> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f30699e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f30700f;

            public CallableC0354a(Object obj, Object obj2) {
                this.f30699e = obj;
                this.f30700f = obj2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.cache.CacheLoader */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return CacheLoader.this.reload(this.f30699e, this.f30700f).get();
            }
        }

        public a(Executor executor) {
            this.f30698b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws Exception {
            return (V) CacheLoader.this.load(k);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public l<V> reload(K k, V v) throws Exception {
            m b2 = m.b(new CallableC0354a(k, v));
            this.f30698b.execute(b2);
            return b2;
        }
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        n.p(cacheLoader);
        n.p(executor);
        return new a(executor);
    }

    public static <K, V> CacheLoader<K, V> from(g<K, V> gVar) {
        return new FunctionToCacheLoader(gVar);
    }

    public abstract V load(K k) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    public l<V> reload(K k, V v) throws Exception {
        n.p(k);
        n.p(v);
        return d.h.c.i.a.g.d(load(k));
    }

    public static <V> CacheLoader<Object, V> from(r<V> rVar) {
        return new SupplierToCacheLoader(rVar);
    }
}
