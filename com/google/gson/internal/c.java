package com.google.gson.internal;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements p, Cloneable {
    public static final c itq = new c();
    private boolean itu;
    private double itr = -1.0d;
    private int its = 136;
    private boolean itt = true;
    private List<com.google.gson.a> itv = Collections.emptyList();
    private List<com.google.gson.a> itw = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: cav */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.p
    public <T> o<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> caS = aVar.caS();
        final boolean b = b(caS, true);
        final boolean b2 = b(caS, false);
        if (b || b2) {
            return new o<T>() { // from class: com.google.gson.internal.c.1
                private o<T> itb;

                /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
                @Override // com.google.gson.o
                public T b(com.google.gson.stream.a aVar2) throws IOException {
                    if (b2) {
                        aVar2.skipValue();
                        return null;
                    }
                    return caw().b(aVar2);
                }

                @Override // com.google.gson.o
                public void a(com.google.gson.stream.b bVar, T t) throws IOException {
                    if (b) {
                        bVar.caR();
                    } else {
                        caw().a(bVar, t);
                    }
                }

                private o<T> caw() {
                    o<T> oVar = this.itb;
                    if (oVar != 0) {
                        return oVar;
                    }
                    o<T> a = dVar.a(c.this, aVar);
                    this.itb = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.its & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.itr == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.itu || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.caq() : !aVar.cap()))) {
                if ((this.itt || !w(field.getType())) && !v(field.getType())) {
                    List<com.google.gson.a> list = z ? this.itv : this.itw;
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
        if (this.itr == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            if ((this.itt || !w(cls)) && !v(cls)) {
                for (com.google.gson.a aVar : z ? this.itv : this.itw) {
                    if (aVar.s(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean v(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean w(Class<?> cls) {
        return cls.isMemberClass() && !x(cls);
    }

    private boolean x(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.cat() <= this.itr;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.cat() > this.itr;
    }
}
