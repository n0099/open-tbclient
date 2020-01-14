package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class c implements TypeAdapterFactory, Cloneable {
    public static final c mJI = new c();
    private boolean mJM;
    private double mJJ = -1.0d;
    private int mJK = 136;
    private boolean mJL = true;
    private List<ExclusionStrategy> mJN = Collections.emptyList();
    private List<ExclusionStrategy> mJO = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: dzr */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public c y(double d) {
        c clone = clone();
        clone.mJJ = d;
        return clone;
    }

    public c p(int... iArr) {
        c clone = clone();
        clone.mJK = 0;
        for (int i : iArr) {
            clone.mJK = i | clone.mJK;
        }
        return clone;
    }

    public c dzs() {
        c clone = clone();
        clone.mJL = false;
        return clone;
    }

    public c dzt() {
        c clone = clone();
        clone.mJM = true;
        return clone;
    }

    public c a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        c clone = clone();
        if (z) {
            clone.mJN = new ArrayList(this.mJN);
            clone.mJN.add(exclusionStrategy);
        }
        if (z2) {
            clone.mJO = new ArrayList(this.mJO);
            clone.mJO.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> rawType = aVar.getRawType();
        boolean E = E(rawType);
        final boolean z2 = E || c(rawType, true);
        if (E || c(rawType, false)) {
            z = true;
        }
        if (!z2 && !z) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.c.1
            private TypeAdapter<T> delegate;

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            public T read(com.google.gson.stream.a aVar2) throws IOException {
                if (z) {
                    aVar2.dzR();
                    return null;
                }
                return dzu().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.dAa();
                } else {
                    dzu().write(bVar, t);
                }
            }

            private TypeAdapter<T> dzu() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != 0) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(c.this, aVar);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }
        };
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.mJK & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.mJJ == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.mJM || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.dzn() : !aVar.dzm()))) {
                if ((this.mJL || !G(field.getType())) && !F(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.mJN : this.mJO;
                    if (!list.isEmpty()) {
                        FieldAttributes fieldAttributes = new FieldAttributes(field);
                        for (ExclusionStrategy exclusionStrategy : list) {
                            if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                                return true;
                            }
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

    private boolean E(Class<?> cls) {
        if (this.mJJ == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.mJL && G(cls)) || F(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return E(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.mJN : this.mJO) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean F(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean G(Class<?> cls) {
        return cls.isMemberClass() && !H(cls);
    }

    private boolean H(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.dzq() <= this.mJJ;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.dzq() > this.mJJ;
    }
}
