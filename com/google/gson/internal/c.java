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
    public static final c mKn = new c();
    private boolean mKr;
    private double mKo = -1.0d;
    private int mKp = 136;
    private boolean mKq = true;
    private List<ExclusionStrategy> mKs = Collections.emptyList();
    private List<ExclusionStrategy> mKt = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: dAz */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public c y(double d) {
        c clone = clone();
        clone.mKo = d;
        return clone;
    }

    public c o(int... iArr) {
        c clone = clone();
        clone.mKp = 0;
        for (int i : iArr) {
            clone.mKp = i | clone.mKp;
        }
        return clone;
    }

    public c dAA() {
        c clone = clone();
        clone.mKq = false;
        return clone;
    }

    public c dAB() {
        c clone = clone();
        clone.mKr = true;
        return clone;
    }

    public c a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        c clone = clone();
        if (z) {
            clone.mKs = new ArrayList(this.mKs);
            clone.mKs.add(exclusionStrategy);
        }
        if (z2) {
            clone.mKt = new ArrayList(this.mKt);
            clone.mKt.add(exclusionStrategy);
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
                    aVar2.dAX();
                    return null;
                }
                return dAC().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.dBg();
                } else {
                    dAC().write(bVar, t);
                }
            }

            private TypeAdapter<T> dAC() {
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
        if ((this.mKp & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.mKo == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.mKr || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.mKq || !G(field.getType())) && !F(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.mKs : this.mKt;
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
        if (this.mKo == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.mKq && G(cls)) || F(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return E(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.mKs : this.mKt) {
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
        return dVar == null || dVar.dAy() <= this.mKo;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.dAy() > this.mKo;
    }
}
