package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class i implements p {
    private final com.google.gson.internal.b ijT;
    private final com.google.gson.internal.c ijU;
    private final d ikb;
    private final com.google.gson.c ilJ;

    public i(com.google.gson.internal.b bVar, com.google.gson.c cVar, com.google.gson.internal.c cVar2, d dVar) {
        this.ijT = bVar;
        this.ilJ = cVar;
        this.ijU = cVar2;
        this.ikb = dVar;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.ijU);
    }

    static boolean a(Field field, boolean z, com.google.gson.internal.c cVar) {
        return (cVar.b(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.ilJ.translateName(field));
        }
        String value = cVar.value();
        String[] bYQ = cVar.bYQ();
        if (bYQ.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(bYQ.length + 1);
        arrayList.add(value);
        for (String str : bYQ) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Class<? super T> bZq = aVar.bZq();
        if (!Object.class.isAssignableFrom(bZq)) {
            return null;
        }
        return new a(this.ijT.b(aVar), a(dVar, (com.google.gson.b.a<?>) aVar, (Class<?>) bZq));
    }

    private b a(final com.google.gson.d dVar, final Field field, String str, final com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        final boolean k = com.google.gson.internal.f.k(aVar.bZq());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        final o<?> oVar = null;
        if (bVar != null) {
            oVar = this.ikb.a(this.ijT, dVar, aVar, bVar);
        }
        final boolean z3 = oVar != null;
        if (oVar == null) {
            oVar = dVar.a(aVar);
        }
        return new b(str, z, z2) { // from class: com.google.gson.internal.a.i.1
            @Override // com.google.gson.internal.a.i.b
            void a(com.google.gson.stream.b bVar2, Object obj) throws IOException, IllegalAccessException {
                (z3 ? oVar : new m(dVar, oVar, aVar.bZr())).a(bVar2, field.get(obj));
            }

            @Override // com.google.gson.internal.a.i.b
            void a(com.google.gson.stream.a aVar2, Object obj) throws IOException, IllegalAccessException {
                Object b2 = oVar.b(aVar2);
                if (b2 != null || !k) {
                    field.set(obj, b2);
                }
            }

            @Override // com.google.gson.internal.a.i.b
            public boolean aS(Object obj) throws IOException, IllegalAccessException {
                return this.ilS && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(com.google.gson.d dVar, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type bZr = aVar.bZr();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = C$Gson$Types.a(aVar.bZr(), cls, field.getGenericType());
                    List<String> a5 = a(field);
                    b bVar = null;
                    int i = 0;
                    while (i < a5.size()) {
                        String str = a5.get(i);
                        if (i != 0) {
                            a2 = false;
                        }
                        b bVar2 = (b) linkedHashMap.put(str, a(dVar, field, str, com.google.gson.b.a.l(a4), a2, a3));
                        if (bVar != null) {
                            bVar2 = bVar;
                        }
                        i++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(bZr + " declares multiple JSON fields named " + bVar.name);
                    }
                }
            }
            aVar = com.google.gson.b.a.l(C$Gson$Types.a(aVar.bZr(), cls, cls.getGenericSuperclass()));
            cls = aVar.bZq();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        final boolean ilS;
        final boolean ilT;
        final String name;

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean aS(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.name = str;
            this.ilS = z;
            this.ilT = z2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> extends o<T> {
        private final Map<String, b> ilR;
        private final com.google.gson.internal.e<T> ilq;

        a(com.google.gson.internal.e<T> eVar, Map<String, b> map) {
            this.ilq = eVar;
            this.ilR = map;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.bZe() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            T bYS = this.ilq.bYS();
            try {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    b bVar = this.ilR.get(aVar.nextName());
                    if (bVar == null || !bVar.ilT) {
                        aVar.skipValue();
                    } else {
                        bVar.a(aVar, bYS);
                    }
                }
                aVar.endObject();
                return bYS;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.bZp();
                return;
            }
            bVar.bZn();
            try {
                for (b bVar2 : this.ilR.values()) {
                    if (bVar2.aS(t)) {
                        bVar.yL(bVar2.name);
                        bVar2.a(bVar, t);
                    }
                }
                bVar.bZo();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
