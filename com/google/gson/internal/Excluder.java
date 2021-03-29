package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import d.g.c.a.d;
import d.g.c.a.e;
import d.g.c.c.a;
import d.g.c.d.b;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder k = new Excluder();

    /* renamed from: h  reason: collision with root package name */
    public boolean f30910h;

    /* renamed from: e  reason: collision with root package name */
    public double f30907e = -1.0d;

    /* renamed from: f  reason: collision with root package name */
    public int f30908f = 136;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30909g = true;
    public List<ExclusionStrategy> i = Collections.emptyList();
    public List<ExclusionStrategy> j = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public Excluder c() {
        Excluder clone = clone();
        clone.f30909g = false;
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final a<T> aVar) {
        Class<? super T> c2 = aVar.c();
        boolean e2 = e(c2);
        final boolean z = e2 || f(c2, true);
        final boolean z2 = e2 || f(c2, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1

                /* renamed from: a  reason: collision with root package name */
                public TypeAdapter<T> f30911a;

                public final TypeAdapter<T> a() {
                    TypeAdapter<T> typeAdapter = this.f30911a;
                    if (typeAdapter != 0) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, aVar);
                    this.f30911a = delegateAdapter;
                    return delegateAdapter;
                }

                /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
                @Override // com.google.gson.TypeAdapter
                public T read(d.g.c.d.a aVar2) throws IOException {
                    if (z2) {
                        aVar2.W();
                        return null;
                    }
                    return a().read(aVar2);
                }

                @Override // com.google.gson.TypeAdapter
                public void write(b bVar, T t) throws IOException {
                    if (z) {
                        bVar.B();
                    } else {
                        a().write(bVar, t);
                    }
                }
            };
        }
        return null;
    }

    public boolean d(Class<?> cls, boolean z) {
        return e(cls) || f(cls, z);
    }

    public final boolean e(Class<?> cls) {
        if (this.f30907e == -1.0d || n((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return (!this.f30909g && j(cls)) || i(cls);
        }
        return true;
    }

    public final boolean f(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.i : this.j) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(Field field, boolean z) {
        d.g.c.a.a aVar;
        if ((this.f30908f & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f30907e == -1.0d || n((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) && !field.isSynthetic()) {
            if (!this.f30910h || ((aVar = (d.g.c.a.a) field.getAnnotation(d.g.c.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.f30909g || !j(field.getType())) && !i(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.i : this.j;
                    if (list.isEmpty()) {
                        return false;
                    }
                    FieldAttributes fieldAttributes = new FieldAttributes(field);
                    for (ExclusionStrategy exclusionStrategy : list) {
                        if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public Excluder h() {
        Excluder clone = clone();
        clone.f30910h = true;
        return clone;
    }

    public final boolean i(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public final boolean j(Class<?> cls) {
        return cls.isMemberClass() && !k(cls);
    }

    public final boolean k(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean l(d dVar) {
        return dVar == null || dVar.value() <= this.f30907e;
    }

    public final boolean m(e eVar) {
        return eVar == null || eVar.value() > this.f30907e;
    }

    public final boolean n(d dVar, e eVar) {
        return l(dVar) && m(eVar);
    }

    public Excluder o(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.i);
            clone.i = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.j);
            clone.j = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder p(int... iArr) {
        Excluder clone = clone();
        clone.f30908f = 0;
        for (int i : iArr) {
            clone.f30908f = i | clone.f30908f;
        }
        return clone;
    }

    public Excluder q(double d2) {
        Excluder clone = clone();
        clone.f30907e = d2;
        return clone;
    }
}
