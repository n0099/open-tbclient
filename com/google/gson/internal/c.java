package com.google.gson.internal;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements p, Cloneable {
    public static final c iwA = new c();
    private boolean iwE;
    private double iwB = -1.0d;
    private int iwC = 136;
    private boolean iwD = true;
    private List<com.google.gson.a> iwF = Collections.emptyList();
    private List<com.google.gson.a> iwG = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: cbm */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.p
    public <T> o<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> cbJ = aVar.cbJ();
        final boolean b = b(cbJ, true);
        final boolean b2 = b(cbJ, false);
        if (b || b2) {
            return new o<T>() { // from class: com.google.gson.internal.c.1
                private o<T> iwl;

                /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
                @Override // com.google.gson.o
                public T b(com.google.gson.stream.a aVar2) throws IOException {
                    if (b2) {
                        aVar2.skipValue();
                        return null;
                    }
                    return cbn().b(aVar2);
                }

                @Override // com.google.gson.o
                public void a(com.google.gson.stream.b bVar, T t) throws IOException {
                    if (b) {
                        bVar.cbI();
                    } else {
                        cbn().a(bVar, t);
                    }
                }

                private o<T> cbn() {
                    o<T> oVar = this.iwl;
                    if (oVar != 0) {
                        return oVar;
                    }
                    o<T> a = dVar.a(c.this, aVar);
                    this.iwl = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.iwC & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.iwB == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.iwE || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.cbh() : !aVar.cbg()))) {
                if ((this.iwD || !w(field.getType())) && !v(field.getType())) {
                    List<com.google.gson.a> list = z ? this.iwF : this.iwG;
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
        if (this.iwB == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            if ((this.iwD || !w(cls)) && !v(cls)) {
                for (com.google.gson.a aVar : z ? this.iwF : this.iwG) {
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
        return dVar == null || dVar.cbk() <= this.iwB;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.cbk() > this.iwB;
    }
}
