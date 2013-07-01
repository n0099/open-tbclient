package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class p implements com.google.gson.ab {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.b f1636a;
    private final com.google.gson.d b;
    private final com.google.gson.internal.k c;

    public p(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.internal.k kVar) {
        this.f1636a = bVar;
        this.b = dVar;
        this.c = kVar;
    }

    public boolean a(Field field, boolean z) {
        return (this.c.a(field.getType(), z) || this.c.a(field, z)) ? false : true;
    }

    private String a(Field field) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        return bVar == null ? this.b.translateName(field) : bVar.a();
    }

    @Override // com.google.gson.ab
    public com.google.gson.aa a(com.google.gson.e eVar, com.google.gson.b.a aVar) {
        Class a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new r(this, this.f1636a.a(aVar), a(eVar, aVar, a2), null);
        }
        return null;
    }

    private s a(com.google.gson.e eVar, Field field, String str, com.google.gson.b.a aVar, boolean z, boolean z2) {
        return new q(this, str, z, z2, eVar, aVar, field, com.google.gson.internal.o.a((Type) aVar.a()));
    }

    private Map a(com.google.gson.e eVar, com.google.gson.b.a aVar, Class cls) {
        Field[] declaredFields;
        s sVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b = aVar.b();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    s a4 = a(eVar, field, a(field), com.google.gson.b.a.a(C$Gson$Types.a(aVar.b(), cls, field.getGenericType())), a2, a3);
                    if (((s) linkedHashMap.put(a4.g, a4)) != null) {
                        throw new IllegalArgumentException(b + " declares multiple JSON fields named " + sVar.g);
                    }
                }
            }
            aVar = com.google.gson.b.a.a(C$Gson$Types.a(aVar.b(), cls, cls.getGenericSuperclass()));
            cls = aVar.a();
        }
        return linkedHashMap;
    }
}
