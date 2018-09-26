package com.google.gson.internal;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class c implements n, Cloneable {
    public static final c hNW = new c();
    private boolean hOa;
    private double hNX = -1.0d;
    private int hNY = 136;
    private boolean hNZ = true;
    private List<com.google.gson.a> hOb = Collections.emptyList();
    private List<com.google.gson.a> hOc = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: bMT */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // com.google.gson.n
    public <T> m<T> a(final com.google.gson.d dVar, final com.google.gson.b.a<T> aVar) {
        Class<? super T> bNi = aVar.bNi();
        final boolean b = b(bNi, true);
        final boolean b2 = b(bNi, false);
        if (b || b2) {
            return new m<T>() { // from class: com.google.gson.internal.c.1
                private m<T> hNI;

                @Override // com.google.gson.m
                public void a(com.google.gson.stream.a aVar2, T t) throws IOException {
                    if (b) {
                        aVar2.bNg();
                    } else {
                        bMU().a(aVar2, t);
                    }
                }

                private m<T> bMU() {
                    m<T> mVar = this.hNI;
                    if (mVar != 0) {
                        return mVar;
                    }
                    m<T> a = dVar.a(c.this, aVar);
                    this.hNI = a;
                    return a;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.hNY & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.hNX == -1.0d || a((com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class))) && !field.isSynthetic()) {
            if (!this.hOa || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.bMR() : !aVar.bMQ()))) {
                if ((this.hNZ || !u(field.getType())) && !t(field.getType())) {
                    List<com.google.gson.a> list = z ? this.hOb : this.hOc;
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
        if (this.hNX == -1.0d || a((com.google.gson.a.c) cls.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class))) {
            if ((this.hNZ || !u(cls)) && !t(cls)) {
                for (com.google.gson.a aVar : z ? this.hOb : this.hOc) {
                    if (aVar.q(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean t(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean u(Class<?> cls) {
        return cls.isMemberClass() && !v(cls);
    }

    private boolean v(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.c cVar, com.google.gson.a.d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(com.google.gson.a.c cVar) {
        return cVar == null || cVar.bMS() <= this.hNX;
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.bMS() > this.hNX;
    }
}
