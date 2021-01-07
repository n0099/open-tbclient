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
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder pMv = new Excluder();
    private boolean pMz;
    private double pMw = -1.0d;
    private int pMx = 136;
    private boolean pMy = true;
    private List<ExclusionStrategy> pMA = Collections.emptyList();
    private List<ExclusionStrategy> pMB = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: eCx */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder P(double d) {
        Excluder clone = clone();
        clone.pMw = d;
        return clone;
    }

    public Excluder v(int... iArr) {
        Excluder clone = clone();
        clone.pMx = 0;
        for (int i : iArr) {
            clone.pMx = i | clone.pMx;
        }
        return clone;
    }

    public Excluder eCy() {
        Excluder clone = clone();
        clone.pMy = false;
        return clone;
    }

    public Excluder eCz() {
        Excluder clone = clone();
        clone.pMz = true;
        return clone;
    }

    public Excluder a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.pMA = new ArrayList(this.pMA);
            clone.pMA.add(exclusionStrategy);
        }
        if (z2) {
            clone.pMB = new ArrayList(this.pMB);
            clone.pMB.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> eDm = aVar.eDm();
        boolean v = v(eDm);
        final boolean z2 = v || d(eDm, true);
        if (v || d(eDm, false)) {
            z = true;
        }
        if (!z2 && !z) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            private TypeAdapter<T> delegate;

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            public T read(com.google.gson.stream.a aVar2) throws IOException {
                if (z) {
                    aVar2.eCZ();
                    return null;
                }
                return eCA().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.eDi();
                } else {
                    eCA().write(bVar, t);
                }
            }

            private TypeAdapter<T> eCA() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != 0) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, aVar);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }
        };
    }

    public boolean b(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.pMx & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.pMw == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.pMz || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.pMy || !x(field.getType())) && !w(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.pMA : this.pMB;
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

    private boolean v(Class<?> cls) {
        if (this.pMw == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.pMy && x(cls)) || w(cls);
        }
        return true;
    }

    public boolean c(Class<?> cls, boolean z) {
        return v(cls) || d(cls, z);
    }

    private boolean d(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.pMA : this.pMB) {
            if (exclusionStrategy.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean w(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean x(Class<?> cls) {
        return cls.isMemberClass() && !y(cls);
    }

    private boolean y(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.eCv() <= this.pMw;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.eCv() > this.pMw;
    }
}
