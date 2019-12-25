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
public final class c implements TypeAdapterFactory, Cloneable {
    public static final c mFL = new c();
    private boolean mFP;
    private double mFM = -1.0d;
    private int mFN = 136;
    private boolean mFO = true;
    private List<ExclusionStrategy> mFQ = Collections.emptyList();
    private List<ExclusionStrategy> mFR = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: dyg */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public c y(double d) {
        c clone = clone();
        clone.mFM = d;
        return clone;
    }

    public c p(int... iArr) {
        c clone = clone();
        clone.mFN = 0;
        for (int i : iArr) {
            clone.mFN = i | clone.mFN;
        }
        return clone;
    }

    public c dyh() {
        c clone = clone();
        clone.mFO = false;
        return clone;
    }

    public c dyi() {
        c clone = clone();
        clone.mFP = true;
        return clone;
    }

    public c a(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        c clone = clone();
        if (z) {
            clone.mFQ = new ArrayList(this.mFQ);
            clone.mFQ.add(exclusionStrategy);
        }
        if (z2) {
            clone.mFR = new ArrayList(this.mFR);
            clone.mFR.add(exclusionStrategy);
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
                    aVar2.dyK();
                    return null;
                }
                return dyj().read(aVar2);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(com.google.gson.stream.b bVar, T t) throws IOException {
                if (z2) {
                    bVar.dyT();
                } else {
                    dyj().write(bVar, t);
                }
            }

            private TypeAdapter<T> dyj() {
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
        if ((this.mFN & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.mFM == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.mFP || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.dyc() : !aVar.dyb()))) {
                if ((this.mFO || !G(field.getType())) && !F(field.getType())) {
                    List<ExclusionStrategy> list = z ? this.mFQ : this.mFR;
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
        if (this.mFM == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.mFO && G(cls)) || F(cls);
        }
        return true;
    }

    public boolean b(Class<?> cls, boolean z) {
        return E(cls) || c(cls, z);
    }

    private boolean c(Class<?> cls, boolean z) {
        for (ExclusionStrategy exclusionStrategy : z ? this.mFQ : this.mFR) {
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
        return dVar == null || dVar.dyf() <= this.mFM;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.dyf() > this.mFM;
    }
}
