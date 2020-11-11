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
/* loaded from: classes17.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder pcZ = new Excluder();
    private boolean pdd;
    private double pda = -1.0d;
    private int pdb = 136;
    private boolean pdc = true;
    private List<ExclusionStrategy> pde = Collections.emptyList();
    private List<ExclusionStrategy> pdf = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: esE */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder O(double d) {
        Excluder clone = clone();
        clone.pda = d;
        return clone;
    }

    public Excluder s(int... iArr) {
        Excluder clone = clone();
        clone.pdb = 0;
        for (int i : iArr) {
            clone.pdb = i | clone.pdb;
        }
        return clone;
    }

    public Excluder esF() {
        Excluder clone = clone();
        clone.pdc = false;
        return clone;
    }

    public Excluder esG() {
        Excluder clone = clone();
        clone.pdd = true;
        return clone;
    }

    public Excluder a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.pde = new ArrayList(this.pde);
            clone.pde.add(exclusionStrategy);
        }
        if (z2) {
            clone.pdf = new ArrayList(this.pdf);
            clone.pdf.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final com.google.gson.b.a<T> aVar) {
        final boolean z = false;
        Class<? super T> etp = aVar.etp();
        boolean C = C(etp);
        final boolean z2 = C || c(etp, true);
        if (C || c(etp, false)) {
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
                    aVar2.etc();
                    return null;
                }
                return esH().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.etl();
                } else {
                    esH().write(bVar, t);
                }
            }

            private TypeAdapter<T> esH() {
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

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.pdb & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.pda == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.pdd || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.pdc || !E(field.getType())) && !D(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.pde : this.pdf;
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
        if (this.pda == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.pdc && E(cls)) || D(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return C(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.pde : this.pdf) {
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
        return dVar == null || dVar.esD() <= this.pda;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.esD() > this.pda;
    }
}
