package com.google.gson.internal;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements n, Cloneable {
    public static final c hFV = new c();
    private boolean hFZ;
    private double hFW = -1.0d;
    private int hFX = 136;
    private boolean hFY = true;
    private List<com.google.gson.a> hGa = Collections.emptyList();
    private List<com.google.gson.a> hGb = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: bKl */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // com.google.gson.n
    public <T> m<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> bKA = aVar.bKA();
        final boolean a = a((Class<?>) bKA, true);
        final boolean a2 = a((Class<?>) bKA, false);
        if (a || a2) {
            return new m<T>() { // from class: com.google.gson.internal.c.1
                private m<T> hFH;

                @Override // com.google.gson.m
                public void a(com.google.gson.stream.a aVar2, T t) throws IOException {
                    if (a) {
                        aVar2.bKy();
                    } else {
                        bKm().a(aVar2, t);
                    }
                }

                private m<T> bKm() {
                    m<T> mVar = this.hFH;
                    if (mVar != 0) {
                        return mVar;
                    }
                    m<T> a3 = dVar.a(c.this, aVar);
                    this.hFH = a3;
                    return a3;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.hFX & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.hFW == -1.0d || a((com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class))) && !field.isSynthetic()) {
            if (!this.hFZ || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.bKj() : !aVar.bKi()))) {
                if ((this.hFY || !r(field.getType())) && !q(field.getType())) {
                    List<com.google.gson.a> list = z ? this.hGa : this.hGb;
                    if (!list.isEmpty()) {
                        com.google.gson.b bVar = new com.google.gson.b(field);
                        for (com.google.gson.a aVar2 : list) {
                            if (aVar2.a(bVar)) {
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

    public boolean a(Class<?> cls, boolean z) {
        if (this.hFW == -1.0d || a((com.google.gson.a.c) cls.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class))) {
            if ((this.hFY || !r(cls)) && !q(cls)) {
                for (com.google.gson.a aVar : z ? this.hGa : this.hGb) {
                    if (aVar.n(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean q(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean r(Class<?> cls) {
        return cls.isMemberClass() && !s(cls);
    }

    private boolean s(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.c cVar, com.google.gson.a.d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(com.google.gson.a.c cVar) {
        return cVar == null || cVar.bKk() <= this.hFW;
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.bKk() > this.hFW;
    }
}
