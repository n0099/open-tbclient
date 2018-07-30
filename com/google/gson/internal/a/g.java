package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class g implements n {
    private final com.google.gson.internal.b hFz;
    private final com.google.gson.c hGT;
    private final com.google.gson.internal.c hGU;

    public g(com.google.gson.internal.b bVar, com.google.gson.c cVar, com.google.gson.internal.c cVar2) {
        this.hFz = bVar;
        this.hGT = cVar;
        this.hGU = cVar2;
    }

    public boolean a(Field field, boolean z) {
        return (this.hGU.a(field.getType(), z) || this.hGU.a(field, z)) ? false : true;
    }

    private String a(Field field) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        return bVar == null ? this.hGT.translateName(field) : bVar.value();
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Class<? super T> bKA = aVar.bKA();
        if (Object.class.isAssignableFrom(bKA)) {
            return new a(this.hFz.b(aVar), a(dVar, aVar, bKA));
        }
        return null;
    }

    private b a(final com.google.gson.d dVar, final Field field, String str, final com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        final boolean k = com.google.gson.internal.e.k(aVar.bKA());
        return new b(str, z, z2) { // from class: com.google.gson.internal.a.g.1
            final m<?> hGV;

            {
                this.hGV = dVar.a(aVar);
            }

            @Override // com.google.gson.internal.a.g.b
            void a(com.google.gson.stream.a aVar2, Object obj) throws IOException, IllegalAccessException {
                new j(dVar, this.hGV, aVar.bKB()).a(aVar2, (com.google.gson.stream.a) field.get(obj));
            }
        };
    }

    private Map<String, b> a(com.google.gson.d dVar, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        b bVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type bKB = aVar.bKB();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    b a4 = a(dVar, field, a(field), com.google.gson.b.a.l(C$Gson$Types.a(aVar.bKB(), cls, field.getGenericType())), a2, a3);
                    if (((b) linkedHashMap.put(a4.name, a4)) != null) {
                        throw new IllegalArgumentException(bKB + " declares multiple JSON fields named " + bVar.name);
                    }
                }
            }
            aVar = com.google.gson.b.a.l(C$Gson$Types.a(aVar.bKB(), cls, cls.getGenericSuperclass()));
            cls = aVar.bKA();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        final boolean hHc;
        final boolean hHd;
        final String name;

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.name = str;
            this.hHc = z;
            this.hHd = z2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> extends m<T> {
        private final com.google.gson.internal.d<T> hGG;
        private final Map<String, b> hHb;

        private a(com.google.gson.internal.d<T> dVar, Map<String, b> map) {
            this.hGG = dVar;
            this.hHb = map;
        }

        @Override // com.google.gson.m
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (t == null) {
                aVar.bKy();
                return;
            }
            aVar.bKw();
            try {
                for (b bVar : this.hHb.values()) {
                    if (bVar.hHc) {
                        aVar.wD(bVar.name);
                        bVar.a(aVar, t);
                    }
                }
                aVar.bKx();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }
}
