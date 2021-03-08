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
/* loaded from: classes4.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder pTp = new Excluder();
    private boolean pTt;
    private double pTq = -1.0d;
    private int pTr = 136;
    private boolean pTs = true;
    private List<ExclusionStrategy> pTu = Collections.emptyList();
    private List<ExclusionStrategy> pTv = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: eBl */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder J(double d) {
        Excluder clone = clone();
        clone.pTq = d;
        return clone;
    }

    public Excluder v(int... iArr) {
        Excluder clone = clone();
        clone.pTr = 0;
        for (int i : iArr) {
            clone.pTr = i | clone.pTr;
        }
        return clone;
    }

    public Excluder eBm() {
        Excluder clone = clone();
        clone.pTs = false;
        return clone;
    }

    public Excluder eBn() {
        Excluder clone = clone();
        clone.pTt = true;
        return clone;
    }

    public Excluder a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.pTu = new ArrayList(this.pTu);
            clone.pTu.add(exclusionStrategy);
        }
        if (z2) {
            clone.pTv = new ArrayList(this.pTv);
            clone.pTv.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> eCa = aVar.eCa();
        boolean v = v(eCa);
        final boolean z2 = v || d(eCa, true);
        if (v || d(eCa, false)) {
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
                    aVar2.eBN();
                    return null;
                }
                return eBo().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.eBW();
                } else {
                    eBo().write(bVar, t);
                }
            }

            private TypeAdapter<T> eBo() {
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
        if ((this.pTr & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.pTq == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.pTt || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.pTs || !x(field.getType())) && !w(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.pTu : this.pTv;
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
        if (this.pTq == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.pTs && x(cls)) || w(cls);
        }
        return true;
    }

    public boolean c(Class<?> cls, boolean z) {
        return v(cls) || d(cls, z);
    }

    private boolean d(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.pTu : this.pTv) {
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
        return dVar == null || dVar.eBj() <= this.pTq;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.eBj() > this.pTq;
    }
}
