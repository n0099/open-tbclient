package com.google.gson.internal;

import com.google.gson.JsonIOException;
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
/* loaded from: classes2.dex */
public final class b {
    private final Map<Type, com.google.gson.e<?>> ixz;

    public b(Map<Type, com.google.gson.e<?>> map) {
        this.ixz = map;
    }

    public <T> e<T> b(com.google.gson.b.a<T> aVar) {
        final Type ccs = aVar.ccs();
        Class<? super T> ccr = aVar.ccr();
        final com.google.gson.e<?> eVar = this.ixz.get(ccs);
        if (eVar != null) {
            return new e<T>() { // from class: com.google.gson.internal.b.1
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // com.google.gson.internal.e
                public T cbT() {
                    return eVar.b(ccs);
                }
            };
        }
        final com.google.gson.e<?> eVar2 = this.ixz.get(ccr);
        if (eVar2 != null) {
            return new e<T>() { // from class: com.google.gson.internal.b.7
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // com.google.gson.internal.e
                public T cbT() {
                    return eVar2.b(ccs);
                }
            };
        }
        e<T> u = u(ccr);
        if (u == null) {
            e<T> c = c(ccs, ccr);
            return c == null ? d(ccs, ccr) : c;
        }
        return u;
    }

    private <T> e<T> u(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new e<T>() { // from class: com.google.gson.internal.b.8
                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
                @Override // com.google.gson.internal.e
                public T cbT() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> e<T> c(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.9
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.10
                    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.util.EnumSet] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return EnumSet.noneOf((Class) type2);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.11
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.12
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new ArrayDeque();
                    }
                };
            }
            return new e<T>() { // from class: com.google.gson.internal.b.13
                /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
                @Override // com.google.gson.internal.e
                public T cbT() {
                    return new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.14
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.2
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new e<T>() { // from class: com.google.gson.internal.b.3
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new TreeMap();
                    }
                };
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.google.gson.b.a.l(((ParameterizedType) type).getActualTypeArguments()[0]).ccr())) {
                return new e<T>() { // from class: com.google.gson.internal.b.4
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
                    @Override // com.google.gson.internal.e
                    public T cbT() {
                        return new LinkedHashMap();
                    }
                };
            }
            return new e<T>() { // from class: com.google.gson.internal.b.5
                /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
                @Override // com.google.gson.internal.e
                public T cbT() {
                    return new LinkedTreeMap();
                }
            };
        } else {
            return null;
        }
    }

    private <T> e<T> d(final Type type, final Class<? super T> cls) {
        return new e<T>() { // from class: com.google.gson.internal.b.6
            private final h ixD = h.cce();

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.google.gson.internal.e
            public T cbT() {
                try {
                    return this.ixD.newInstance(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.ixz.toString();
    }
}
