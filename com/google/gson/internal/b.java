package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map f1646a;

    public b(Map map) {
        this.f1646a = map;
    }

    public b() {
        this(Collections.emptyMap());
    }

    public n a(com.google.gson.b.a aVar) {
        Type b = aVar.b();
        Class a2 = aVar.a();
        com.google.gson.n nVar = (com.google.gson.n) this.f1646a.get(b);
        if (nVar != null) {
            return new c(this, nVar, b);
        }
        n a3 = a(a2);
        if (a3 == null) {
            n b2 = b(a2);
            return b2 == null ? a(b, a2) : b2;
        }
        return a3;
    }

    private n a(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new d(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private n b(Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new e(this);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new f(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new g(this);
            }
            return new h(this);
        } else if (Map.class.isAssignableFrom(cls)) {
            return new i(this);
        } else {
            return null;
        }
    }

    private n a(Type type, Class cls) {
        return new j(this, cls, type);
    }

    public String toString() {
        return this.f1646a.toString();
    }
}
