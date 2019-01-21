package com.google.gson.internal;

import com.google.gson.o;
import com.google.gson.p;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements p, Cloneable {
    public static final c ixI = new c();
    private boolean ixM;
    private double ixJ = -1.0d;
    private int ixK = 136;
    private boolean ixL = true;
    private List<com.google.gson.a> ixN = Collections.emptyList();
    private List<com.google.gson.a> ixO = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: cbU */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.p
    public <T> o<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> ccr = aVar.ccr();
        final boolean b = b(ccr, true);
        final boolean b2 = b(ccr, false);
        if (b || b2) {
            return new o<T>() { // from class: com.google.gson.internal.c.1
                private o<T> ixt;

                /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
                @Override // com.google.gson.o
                public T b(com.google.gson.stream.a aVar2) throws IOException {
                    if (b2) {
                        aVar2.skipValue();
                        return null;
                    }
                    return cbV().b(aVar2);
                }

                @Override // com.google.gson.o
                public void a(com.google.gson.stream.b bVar, T t) throws IOException {
                    if (b) {
                        bVar.ccq();
                    } else {
                        cbV().a(bVar, t);
                    }
                }

                private o<T> cbV() {
                    o<T> oVar = this.ixt;
                    if (oVar != 0) {
                        return oVar;
                    }
                    o<T> a = dVar.a(c.this, aVar);
                    this.ixt = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.ixK & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.ixJ == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.ixM || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.cbP() : !aVar.cbO()))) {
                if ((this.ixL || !w(field.getType())) && !v(field.getType())) {
                    List<com.google.gson.a> list = z ? this.ixN : this.ixO;
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
        if (this.ixJ == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            if ((this.ixL || !w(cls)) && !v(cls)) {
                for (com.google.gson.a aVar : z ? this.ixN : this.ixO) {
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
        return dVar == null || dVar.cbS() <= this.ixJ;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.cbS() > this.ixJ;
    }
}
