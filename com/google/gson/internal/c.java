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
/* loaded from: classes3.dex */
public final class c implements TypeAdapterFactory, Cloneable {
    public static final c nCI = new c();
    private boolean nCM;
    private double nCJ = -1.0d;
    private int nCK = 136;
    private boolean nCL = true;
    private List<ExclusionStrategy> nCN = Collections.emptyList();
    private List<ExclusionStrategy> nCO = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: dWX */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public c K(double d) {
        c clone = clone();
        clone.nCJ = d;
        return clone;
    }

    public c r(int... iArr) {
        c clone = clone();
        clone.nCK = 0;
        for (int i : iArr) {
            clone.nCK = i | clone.nCK;
        }
        return clone;
    }

    public c dWY() {
        c clone = clone();
        clone.nCL = false;
        return clone;
    }

    public c dWZ() {
        c clone = clone();
        clone.nCM = true;
        return clone;
    }

    public c a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        c clone = clone();
        if (z) {
            clone.nCN = new ArrayList(this.nCN);
            clone.nCN.add(exclusionStrategy);
        }
        if (z2) {
            clone.nCO = new ArrayList(this.nCO);
            clone.nCO.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> dXI = aVar.dXI();
        boolean C = C(dXI);
        final boolean z2 = C || c(dXI, true);
        if (C || c(dXI, false)) {
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
                    aVar2.dXv();
                    return null;
                }
                return dXa().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.dXE();
                } else {
                    dXa().write(bVar, t);
                }
            }

            private TypeAdapter<T> dXa() {
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
        if ((this.nCK & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.nCJ == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.nCM || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.nCL || !E(field.getType())) && !D(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.nCN : this.nCO;
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

    private boolean C(Class<?> cls) {
        if (this.nCJ == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.nCL && E(cls)) || D(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return C(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.nCN : this.nCO) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean D(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean E(Class<?> cls) {
        return cls.isMemberClass() && !F(cls);
    }

    private boolean F(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.dWW() <= this.nCJ;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.dWW() > this.nCJ;
    }
}
