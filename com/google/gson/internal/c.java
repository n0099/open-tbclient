package com.google.gson.internal;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements o, Cloneable {
    public static final c kfK = new c();
    private boolean kfO;
    private double kfL = -1.0d;
    private int kfM = 136;
    private boolean kfN = true;
    private List<com.google.gson.a> kfP = Collections.emptyList();
    private List<com.google.gson.a> kfQ = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: cJb */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.o
    public <T> n<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> cJt = aVar.cJt();
        final boolean b = b(cJt, true);
        final boolean b2 = b(cJt, false);
        if (b || b2) {
            return new n<T>() { // from class: com.google.gson.internal.c.1
                private n<T> kfv;

                @Override // com.google.gson.n
                public void a(com.google.gson.stream.a aVar2, T t) throws IOException {
                    if (b) {
                        aVar2.cJs();
                    } else {
                        cJc().a(aVar2, t);
                    }
                }

                private n<T> cJc() {
                    n<T> nVar = this.kfv;
                    if (nVar != 0) {
                        return nVar;
                    }
                    n<T> a = dVar.a(c.this, aVar);
                    this.kfv = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.kfM & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.kfL == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.kfO || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.cIW() : !aVar.cIV()))) {
                if ((this.kfN || !y(field.getType())) && !x(field.getType())) {
                    List<com.google.gson.a> list = z ? this.kfP : this.kfQ;
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
        if (this.kfL == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            if ((this.kfN || !y(cls)) && !x(cls)) {
                for (com.google.gson.a aVar : z ? this.kfP : this.kfQ) {
                    if (aVar.u(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean x(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean y(Class<?> cls) {
        return cls.isMemberClass() && !z(cls);
    }

    private boolean z(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.cIZ() <= this.kfL;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.cIZ() > this.kfL;
    }
}
