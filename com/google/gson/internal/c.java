package com.google.gson.internal;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements p, Cloneable {
    public static final c jNt = new c();
    private boolean jNx;
    private double jNu = -1.0d;
    private int jNv = 136;
    private boolean jNw = true;
    private List<com.google.gson.a> jNy = Collections.emptyList();
    private List<com.google.gson.a> jNz = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: cAZ */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.p
    public <T> o<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> cBw = aVar.cBw();
        final boolean b = b(cBw, true);
        final boolean b2 = b(cBw, false);
        if (b || b2) {
            return new o<T>() { // from class: com.google.gson.internal.c.1
                private o<T> jNe;

                /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
                @Override // com.google.gson.o
                public T b(com.google.gson.stream.a aVar2) throws IOException {
                    if (b2) {
                        aVar2.skipValue();
                        return null;
                    }
                    return cBa().b(aVar2);
                }

                @Override // com.google.gson.o
                public void a(com.google.gson.stream.b bVar, T t) throws IOException {
                    if (b) {
                        bVar.cBv();
                    } else {
                        cBa().a(bVar, t);
                    }
                }

                private o<T> cBa() {
                    o<T> oVar = this.jNe;
                    if (oVar != 0) {
                        return oVar;
                    }
                    o<T> a = dVar.a(c.this, aVar);
                    this.jNe = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.jNv & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.jNu == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.jNx || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.cAU() : !aVar.cAT()))) {
                if ((this.jNw || !z(field.getType())) && !y(field.getType())) {
                    List<com.google.gson.a> list = z ? this.jNy : this.jNz;
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

    public boolean b(Class<?> cls, boolean z) {
        if (this.jNu == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            if ((this.jNw || !z(cls)) && !y(cls)) {
                for (com.google.gson.a aVar : z ? this.jNy : this.jNz) {
                    if (aVar.v(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean y(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean z(Class<?> cls) {
        return cls.isMemberClass() && !A(cls);
    }

    private boolean A(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.cAX() <= this.jNu;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.cAX() > this.jNu;
    }
}
