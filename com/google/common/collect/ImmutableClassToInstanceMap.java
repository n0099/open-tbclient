package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import d.g.c.a.n;
import d.g.c.c.u;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes6.dex */
public final class ImmutableClassToInstanceMap<B> extends u<Class<? extends B>, B> implements Object<B>, Serializable {
    public static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    public final ImmutableMap<Class<? extends B>, B> delegate;

    /* loaded from: classes6.dex */
    public static final class b<B> {

        /* renamed from: a  reason: collision with root package name */
        public final ImmutableMap.b<Class<? extends B>, B> f31011a = ImmutableMap.builder();

        public static <B, T extends B> T b(Class<T> cls, B b2) {
            return (T) d.g.c.g.a.d(cls).cast(b2);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> a2 = this.f31011a.a();
            if (a2.isEmpty()) {
                return ImmutableClassToInstanceMap.of();
            }
            return new ImmutableClassToInstanceMap<>(a2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableMap$b<java.lang.Class<? extends B>, B> */
        /* JADX WARN: Multi-variable type inference failed */
        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class<? extends T> key = entry.getKey();
                this.f31011a.c(key, b(key, entry.getValue()));
            }
            return this;
        }
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        b bVar = new b();
        bVar.c(map);
        return bVar.a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T extends B, java.lang.Object] */
    public <T extends B> T getInstance(Class<T> cls) {
        ImmutableMap<Class<? extends B>, B> immutableMap = this.delegate;
        n.p(cls);
        return immutableMap.get(cls);
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }

    public ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.u, d.g.c.c.y
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
