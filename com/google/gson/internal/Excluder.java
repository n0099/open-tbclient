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
    public static final Excluder pKN = new Excluder();
    private boolean pKR;
    private double pKO = -1.0d;
    private int pKP = 136;
    private boolean pKQ = true;
    private List<ExclusionStrategy> pKS = Collections.emptyList();
    private List<ExclusionStrategy> pKT = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: eBT */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder P(double d) {
        Excluder clone = clone();
        clone.pKO = d;
        return clone;
    }

    public Excluder t(int... iArr) {
        Excluder clone = clone();
        clone.pKP = 0;
        for (int i : iArr) {
            clone.pKP = i | clone.pKP;
        }
        return clone;
    }

    public Excluder eBU() {
        Excluder clone = clone();
        clone.pKQ = false;
        return clone;
    }

    public Excluder eBV() {
        Excluder clone = clone();
        clone.pKR = true;
        return clone;
    }

    public Excluder a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.pKS = new ArrayList(this.pKS);
            clone.pKS.add(exclusionStrategy);
        }
        if (z2) {
            clone.pKT = new ArrayList(this.pKT);
            clone.pKT.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> eCI = aVar.eCI();
        boolean v = v(eCI);
        final boolean z2 = v || d(eCI, true);
        if (v || d(eCI, false)) {
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
                    aVar2.eCv();
                    return null;
                }
                return eBW().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.eCE();
                } else {
                    eBW().write(bVar, t);
                }
            }

            private TypeAdapter<T> eBW() {
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
        if ((this.pKP & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.pKO == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.pKR || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.pKQ || !x(field.getType())) && !w(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.pKS : this.pKT;
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
        if (this.pKO == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.pKQ && x(cls)) || w(cls);
        }
        return true;
    }

    public boolean c(Class<?> cls, boolean z) {
        return v(cls) || d(cls, z);
    }

    private boolean d(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.pKS : this.pKT) {
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
        return dVar == null || dVar.eBR() <= this.pKO;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.eBR() > this.pKO;
    }
}
