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
/* loaded from: classes10.dex */
public final class c implements TypeAdapterFactory, Cloneable {
    public static final c niP = new c();
    private boolean niT;
    private double niQ = -1.0d;
    private int niR = 136;
    private boolean niS = true;
    private List<ExclusionStrategy> niU = Collections.emptyList();
    private List<ExclusionStrategy> niV = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: dKV */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public c E(double d) {
        c clone = clone();
        clone.niQ = d;
        return clone;
    }

    public c q(int... iArr) {
        c clone = clone();
        clone.niR = 0;
        for (int i : iArr) {
            clone.niR = i | clone.niR;
        }
        return clone;
    }

    public c dKW() {
        c clone = clone();
        clone.niS = false;
        return clone;
    }

    public c dKX() {
        c clone = clone();
        clone.niT = true;
        return clone;
    }

    public c a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        c clone = clone();
        if (z) {
            clone.niU = new ArrayList(this.niU);
            clone.niU.add(exclusionStrategy);
        }
        if (z2) {
            clone.niV = new ArrayList(this.niV);
            clone.niV.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> dLG = aVar.dLG();
        boolean C = C(dLG);
        final boolean z2 = C || c(dLG, true);
        if (C || c(dLG, false)) {
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
                    aVar2.dLt();
                    return null;
                }
                return dKY().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.dLC();
                } else {
                    dKY().write(bVar, t);
                }
            }

            private TypeAdapter<T> dKY() {
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
        if ((this.niR & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.niQ == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.niT || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.niS || !E(field.getType())) && !D(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.niU : this.niV;
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
        if (this.niQ == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.niS && E(cls)) || D(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return C(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.niU : this.niV) {
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
        return dVar == null || dVar.dKU() <= this.niQ;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.dKU() > this.niQ;
    }
}
