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
/* loaded from: classes7.dex */
public final class c implements TypeAdapterFactory, Cloneable {
    public static final c mKA = new c();
    private boolean mKE;
    private double mKB = -1.0d;
    private int mKC = 136;
    private boolean mKD = true;
    private List<ExclusionStrategy> mKF = Collections.emptyList();
    private List<ExclusionStrategy> mKG = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: dAC */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public c y(double d) {
        c clone = clone();
        clone.mKB = d;
        return clone;
    }

    public c o(int... iArr) {
        c clone = clone();
        clone.mKC = 0;
        for (int i : iArr) {
            clone.mKC = i | clone.mKC;
        }
        return clone;
    }

    public c dAD() {
        c clone = clone();
        clone.mKD = false;
        return clone;
    }

    public c dAE() {
        c clone = clone();
        clone.mKE = true;
        return clone;
    }

    public c a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        c clone = clone();
        if (z) {
            clone.mKF = new ArrayList(this.mKF);
            clone.mKF.add(exclusionStrategy);
        }
        if (z2) {
            clone.mKG = new ArrayList(this.mKG);
            clone.mKG.add(exclusionStrategy);
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
                    aVar2.dBa();
                    return null;
                }
                return dAF().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.dBj();
                } else {
                    dAF().write(bVar, t);
                }
            }

            private TypeAdapter<T> dAF() {
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
        if ((this.mKC & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.mKB == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.mKE || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.mKD || !G(field.getType())) && !F(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.mKF : this.mKG;
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
        if (this.mKB == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.mKD && G(cls)) || F(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return E(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.mKF : this.mKG) {
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
        return dVar == null || dVar.dAB() <= this.mKB;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.dAB() > this.mKB;
    }
}
