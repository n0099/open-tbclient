package com.google.gson.internal;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class k implements com.google.gson.ab, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final k f1655a = new k();
    private boolean e;
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private List f = Collections.emptyList();
    private List g = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Class a2 = aVar.a();
        boolean a3 = a(a2, true);
        boolean a4 = a(a2, false);
        if (a3 || a4) {
            return new l(this, a4, a3, eVar, aVar);
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.b == -1.0d || a((com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class))) && !field.isSynthetic()) {
            if (!this.e || ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) != null && (!z ? !aVar.b() : !aVar.a()))) {
                if ((this.d || !b(field.getType())) && !a(field.getType())) {
                    List<com.google.gson.b> list = z ? this.f : this.g;
                    if (!list.isEmpty()) {
                        com.google.gson.c cVar = new com.google.gson.c(field);
                        for (com.google.gson.b bVar : list) {
                            if (bVar.a(cVar)) {
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

    public boolean a(Class cls, boolean z) {
        if (this.b == -1.0d || a((com.google.gson.a.c) cls.getAnnotation(com.google.gson.a.c.class), (com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class))) {
            if ((this.d || !b(cls)) && !a(cls)) {
                for (com.google.gson.b bVar : z ? this.f : this.g) {
                    if (bVar.a(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean a(Class cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean b(Class cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private boolean c(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.c cVar, com.google.gson.a.d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(com.google.gson.a.c cVar) {
        return cVar == null || cVar.a() <= this.b;
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.a() > this.b;
    }
}
