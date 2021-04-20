package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.a0;
import d.g.c.c.a1;
import d.g.c.c.u;
import d.g.c.c.v;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class MutableClassToInstanceMap<B> extends u<Class<? extends B>, B> implements Object<B>, Serializable {
    public final Map<Class<? extends B>, B> delegate;

    /* loaded from: classes6.dex */
    public static final class SerializedForm<B> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends v<Class<? extends B>, B> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map.Entry f30967e;

        public a(Map.Entry entry) {
            this.f30967e = entry;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.y
        /* renamed from: b */
        public Map.Entry<Class<? extends B>, B> delegate() {
            return this.f30967e;
        }

        @Override // d.g.c.c.v, java.util.Map.Entry
        public B setValue(B b2) {
            return (B) super.setValue(MutableClassToInstanceMap.cast(getKey(), b2));
        }
    }

    /* loaded from: classes6.dex */
    public class b extends a0<Map.Entry<Class<? extends B>, B>> {

        /* loaded from: classes6.dex */
        public class a extends a1<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public a(b bVar, Iterator it) {
                super(it);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a1
            /* renamed from: b */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        public b() {
        }

        @Override // d.g.c.c.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            return new a(this, delegate().iterator());
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // d.g.c.c.r, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.c.a0, d.g.c.c.r, d.g.c.c.y
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return MutableClassToInstanceMap.this.delegate().entrySet();
        }
    }

    public MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        n.p(map);
        this.delegate = map;
    }

    public static <B, T extends B> T cast(Class<T> cls, B b2) {
        return (T) d.g.c.g.a.d(cls).cast(b2);
    }

    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // d.g.c.c.u, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.u, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) obj, (Class<? extends B>) obj2);
    }

    @Override // d.g.c.c.u, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            cast((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<T extends B> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: T extends B */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) cast(cls, put((Class<? extends Class<T>>) cls, (Class<T>) t));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.u, d.g.c.c.y
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public B put(Class<? extends B> cls, B b2) {
        return (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) cast(cls, b2));
    }
}
