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
    private final com.google.gson.internal.b isQ;
    private final com.google.gson.internal.c isR;
    private final d isY;
    private final com.google.gson.c iuG;

    public i(com.google.gson.internal.b bVar, com.google.gson.c cVar, com.google.gson.internal.c cVar2, d dVar) {
        this.isQ = bVar;
        this.iuG = cVar;
        this.isR = cVar2;
        this.isY = dVar;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.isR);
    }

    static boolean a(Field field, boolean z, com.google.gson.internal.c cVar) {
        return (cVar.b(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.iuG.translateName(field));
        }
        String value = cVar.value();
        String[] cat = cVar.cat();
        if (cat.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(cat.length + 1);
        arrayList.add(value);
        for (String str : cat) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Class<? super T> caT = aVar.caT();
        if (!Object.class.isAssignableFrom(caT)) {
            return null;
        }
        return new a(this.isQ.b(aVar), a(dVar, (com.google.gson.b.a<?>) aVar, (Class<?>) caT));
    }

    private b a(final com.google.gson.d dVar, final Field field, String str, final com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        final boolean k = com.google.gson.internal.f.k(aVar.caT());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        final o<?> oVar = null;
        if (bVar != null) {
            oVar = this.isY.a(this.isQ, dVar, aVar, bVar);
        }
        final boolean z3 = oVar != null;
        if (oVar == null) {
            oVar = dVar.a(aVar);
        }
        return new b(str, z, z2) { // from class: com.google.gson.internal.a.i.1
            @Override // com.google.gson.internal.a.i.b
            void a(com.google.gson.stream.b bVar2, Object obj) throws IOException, IllegalAccessException {
                (z3 ? oVar : new m(dVar, oVar, aVar.caU())).a(bVar2, field.get(obj));
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
                return this.iuP && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(com.google.gson.d dVar, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type caU = aVar.caU();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = C$Gson$Types.a(aVar.caU(), cls, field.getGenericType());
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
                        throw new IllegalArgumentException(caU + " declares multiple JSON fields named " + bVar.name);
                    }
                }
            }
            aVar = com.google.gson.b.a.l(C$Gson$Types.a(aVar.caU(), cls, cls.getGenericSuperclass()));
            cls = aVar.caT();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        final boolean iuP;
        final boolean iuQ;
        final String name;

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean aS(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.name = str;
            this.iuP = z;
            this.iuQ = z2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> extends o<T> {
        private final Map<String, b> iuO;
        private final com.google.gson.internal.e<T> iun;

        a(com.google.gson.internal.e<T> eVar, Map<String, b> map) {
            this.iun = eVar;
            this.iuO = map;
        }

        @Override // com.google.gson.o
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.caH() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            T cav = this.iun.cav();
            try {
                aVar.beginObject();
                while (aVar.hasNext()) {
                    b bVar = this.iuO.get(aVar.nextName());
                    if (bVar == null || !bVar.iuQ) {
                        aVar.skipValue();
                    } else {
                        bVar.a(aVar, cav);
                    }
                }
                aVar.endObject();
                return cav;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.o
        public void a(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.caS();
                return;
            }
            bVar.caQ();
            try {
                for (b bVar2 : this.iuO.values()) {
                    if (bVar2.aS(t)) {
                        bVar.zt(bVar2.name);
                        bVar2.a(bVar, t);
                    }
                }
                bVar.caR();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
