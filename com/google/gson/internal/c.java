package com.google.gson.internal;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements o, Cloneable {
    public static final c knZ = new c();
    private boolean kod;
    private double koa = -1.0d;
    private int kob = 136;
    private boolean koc = true;
    private List<com.google.gson.a> koe = Collections.emptyList();
    private List<com.google.gson.a> kof = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: cMB */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.o
    public <T> n<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> cMT = aVar.cMT();
        final boolean b = b(cMT, true);
        final boolean b2 = b(cMT, false);
        if (b || b2) {
            return new n<T>() { // from class: com.google.gson.internal.c.1
                private n<T> knK;

                @Override // com.google.gson.n
                public void a(com.google.gson.stream.a aVar2, T t) throws IOException {
                    if (b) {
                        aVar2.cMS();
                    } else {
                        cMC().a(aVar2, t);
                    }
                }

                private n<T> cMC() {
                    n<T> nVar = this.knK;
                    if (nVar != 0) {
                        return nVar;
                    }
                    n<T> a = dVar.a(c.this, aVar);
                    this.knK = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.kob & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.koa == -1.0d || a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) && !field.isSynthetic()) {
            if (!this.kod || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.cMw() : !aVar.cMv()))) {
                if ((this.koc || !A(field.getType())) && !z(field.getType())) {
                    List<com.google.gson.a> list = z ? this.koe : this.kof;
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
        if (this.koa == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            if ((this.koc || !A(cls)) && !z(cls)) {
                for (com.google.gson.a aVar : z ? this.koe : this.kof) {
                    if (aVar.w(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean z(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean A(Class<?> cls) {
        return cls.isMemberClass() && !B(cls);
    }

    private boolean B(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.cMz() <= this.koa;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.cMz() > this.koa;
    }
}
