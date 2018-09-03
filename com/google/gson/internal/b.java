package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes2.dex */
public final class b {
    private final Map<Type, com.google.gson.e<?>> hFu;

    public b(Map<Type, com.google.gson.e<?>> map) {
        this.hFu = map;
    }

    public <T> d<T> b(com.google.gson.b.a<T> aVar) {
        final Type bKs = aVar.bKs();
        Class<? super T> bKr = aVar.bKr();
        final com.google.gson.e<?> eVar = this.hFu.get(bKs);
        if (eVar != null) {
            return new d<T>() { // from class: com.google.gson.internal.b.1
            };
        }
        final com.google.gson.e<?> eVar2 = this.hFu.get(bKr);
        if (eVar2 != null) {
            return new d<T>() { // from class: com.google.gson.internal.b.5
            };
        }
        d<T> p = p(bKr);
        if (p == null) {
            d<T> c = c(bKs, bKr);
            return c == null ? d(bKs, bKr) : c;
        }
        return p;
    }

    private <T> d<T> p(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new d<T>() { // from class: com.google.gson.internal.b.6
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> d<T> c(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new d<T>() { // from class: com.google.gson.internal.b.7
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new d<T>() { // from class: com.google.gson.internal.b.8
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new d<T>() { // from class: com.google.gson.internal.b.9
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new d<T>() { // from class: com.google.gson.internal.b.10
                };
            }
            return new d<T>() { // from class: com.google.gson.internal.b.11
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new d<T>() { // from class: com.google.gson.internal.b.12
                };
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.google.gson.b.a.l(((ParameterizedType) type).getActualTypeArguments()[0]).bKr())) {
                return new d<T>() { // from class: com.google.gson.internal.b.2
                };
            }
            return new d<T>() { // from class: com.google.gson.internal.b.3
            };
        } else {
            return null;
        }
    }

    private <T> d<T> d(final Type type, final Class<? super T> cls) {
        return new d<T>() { // from class: com.google.gson.internal.b.4
            private final g hFy = g.bKh();
        };
    }

    public String toString() {
        return this.hFu.toString();
    }
}
