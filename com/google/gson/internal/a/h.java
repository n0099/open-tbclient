package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class h implements o {
    private final com.google.gson.internal.b knr;
    private final com.google.gson.internal.c kns;
    private final d knz;
    private final com.google.gson.c koX;

    public h(com.google.gson.internal.b bVar, com.google.gson.c cVar, com.google.gson.internal.c cVar2, d dVar) {
        this.knr = bVar;
        this.koX = cVar;
        this.kns = cVar2;
        this.knz = dVar;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.kns);
    }

    static boolean a(Field field, boolean z, com.google.gson.internal.c cVar) {
        return (cVar.b(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.koX.translateName(field));
        }
        String value = cVar.value();
        String[] cKh = cVar.cKh();
        if (cKh.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(cKh.length + 1);
        arrayList.add(value);
        for (String str : cKh) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Class<? super T> cKC = aVar.cKC();
        if (!Object.class.isAssignableFrom(cKC)) {
            return null;
        }
        return new a(this.knr.b(aVar), a(dVar, (com.google.gson.b.a<?>) aVar, (Class<?>) cKC));
    }

    private b a(final com.google.gson.d dVar, final Field field, String str, final com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        final boolean k = com.google.gson.internal.e.k(aVar.cKC());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        final n<?> nVar = null;
        if (bVar != null) {
            nVar = this.knz.a(this.knr, dVar, aVar, bVar);
        }
        final boolean z3 = nVar != null;
        if (nVar == null) {
            nVar = dVar.a(aVar);
        }
        return new b(str, z, z2) { // from class: com.google.gson.internal.a.h.1
            @Override // com.google.gson.internal.a.h.b
            void a(com.google.gson.stream.a aVar2, Object obj) throws IOException, IllegalAccessException {
                (z3 ? nVar : new l(dVar, nVar, aVar.cKD())).a(aVar2, field.get(obj));
            }

            @Override // com.google.gson.internal.a.h.b
            public boolean bb(Object obj) throws IOException, IllegalAccessException {
                return this.kpg && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(com.google.gson.d dVar, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type cKD = aVar.cKD();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    Type a4 = C$Gson$Types.a(aVar.cKD(), cls, field.getGenericType());
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
                        throw new IllegalArgumentException(cKD + " declares multiple JSON fields named " + bVar.name);
                    }
                }
            }
            aVar = com.google.gson.b.a.l(C$Gson$Types.a(aVar.cKD(), cls, cls.getGenericSuperclass()));
            cls = aVar.cKC();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b {
        final boolean kpg;
        final boolean kph;
        final String name;

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean bb(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.name = str;
            this.kpg = z;
            this.kph = z2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> extends n<T> {
        private final com.google.gson.internal.d<T> koM;
        private final Map<String, b> kpf;

        a(com.google.gson.internal.d<T> dVar, Map<String, b> map) {
            this.koM = dVar;
            this.kpf = map;
        }

        @Override // com.google.gson.n
        public void a(com.google.gson.stream.a aVar, T t) throws IOException {
            if (t == null) {
                aVar.cKB();
                return;
            }
            aVar.cKz();
            try {
                for (b bVar : this.kpf.values()) {
                    if (bVar.bb(t)) {
                        aVar.GO(bVar.name);
                        bVar.a(aVar, t);
                    }
                }
                aVar.cKA();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
