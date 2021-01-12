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
    public static final Excluder pHU = new Excluder();
    private boolean pHY;
    private double pHV = -1.0d;
    private int pHW = 136;
    private boolean pHX = true;
    private List<ExclusionStrategy> pHZ = Collections.emptyList();
    private List<ExclusionStrategy> pIa = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: eyF */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder J(double d) {
        Excluder clone = clone();
        clone.pHV = d;
        return clone;
    }

    public Excluder v(int... iArr) {
        Excluder clone = clone();
        clone.pHW = 0;
        for (int i : iArr) {
            clone.pHW = i | clone.pHW;
        }
        return clone;
    }

    public Excluder eyG() {
        Excluder clone = clone();
        clone.pHX = false;
        return clone;
    }

    public Excluder eyH() {
        Excluder clone = clone();
        clone.pHY = true;
        return clone;
    }

    public Excluder a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.pHZ = new ArrayList(this.pHZ);
            clone.pHZ.add(exclusionStrategy);
        }
        if (z2) {
            clone.pIa = new ArrayList(this.pIa);
            clone.pIa.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> ezu = aVar.ezu();
        boolean v = v(ezu);
        final boolean z2 = v || d(ezu, true);
        if (v || d(ezu, false)) {
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
                    aVar2.ezh();
                    return null;
                }
                return eyI().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.ezq();
                } else {
                    eyI().write(bVar, t);
                }
            }

            private TypeAdapter<T> eyI() {
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
        if ((this.pHW & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.pHV == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.pHY || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.pHX || !x(field.getType())) && !w(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.pHZ : this.pIa;
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
        if (this.pHV == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.pHX && x(cls)) || w(cls);
        }
        return true;
    }

    public boolean c(Class<?> cls, boolean z) {
        return v(cls) || d(cls, z);
    }

    private boolean d(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.pHZ : this.pIa) {
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
        return dVar == null || dVar.eyD() <= this.pHV;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.eyD() > this.pHV;
    }
}
