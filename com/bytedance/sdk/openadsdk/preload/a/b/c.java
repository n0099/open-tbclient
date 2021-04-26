package com.bytedance.sdk.openadsdk.preload.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Type, com.bytedance.sdk.openadsdk.preload.a.h<?>> f30607a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.b.b f30608b = com.bytedance.sdk.openadsdk.preload.a.b.b.b.a();

    public c(Map<Type, com.bytedance.sdk.openadsdk.preload.a.h<?>> map) {
        this.f30607a = map;
    }

    private <T> i<T> b(final Type type, final Class<? super T> cls) {
        return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.6

            /* renamed from: d  reason: collision with root package name */
            public final m f30625d = m.a();

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
            public T a() {
                try {
                    return this.f30625d.a(cls);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }

    public <T> i<T> a(com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        final Type b2 = aVar.b();
        Class<? super T> a2 = aVar.a();
        final com.bytedance.sdk.openadsdk.preload.a.h<?> hVar = this.f30607a.get(b2);
        if (hVar != null) {
            return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.1
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return hVar.a(b2);
                }
            };
        }
        final com.bytedance.sdk.openadsdk.preload.a.h<?> hVar2 = this.f30607a.get(a2);
        if (hVar2 != null) {
            return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.7
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return hVar2.a(b2);
                }
            };
        }
        i<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        i<T> a4 = a(b2, a2);
        return a4 != null ? a4 : b(b2, a2);
    }

    public String toString() {
        return this.f30607a.toString();
    }

    private <T> i<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f30608b.a(declaredConstructor);
            }
            return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.8
                /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    } catch (InstantiationException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3);
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e4.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> i<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.9
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.10
                    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        Type type2 = type;
                        if (type2 instanceof ParameterizedType) {
                            Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof Class) {
                                return EnumSet.noneOf((Class) type3);
                            }
                            throw new com.bytedance.sdk.openadsdk.preload.a.m("Invalid EnumSet type: " + type.toString());
                        }
                        throw new com.bytedance.sdk.openadsdk.preload.a.m("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.11
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.12
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new ArrayDeque();
                    }
                };
            }
            return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.13
                /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.14
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.2
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.3
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new TreeMap();
                    }
                };
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.bytedance.sdk.openadsdk.preload.a.c.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) {
                return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.4
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return new LinkedHashMap();
                    }
                };
            }
            return new i<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.5
                /* JADX WARN: Type inference failed for: r0v0, types: [T, com.bytedance.sdk.openadsdk.preload.a.b.h] */
                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return new h();
                }
            };
        } else {
            return null;
        }
    }
}
