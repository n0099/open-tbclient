package com.google.gson.internal.a;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class i implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;
    private final com.google.gson.internal.c excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final d jsonAdapterFactory;
    private final com.google.gson.internal.b.b miO = com.google.gson.internal.b.b.dvX();

    public i(com.google.gson.internal.b bVar, FieldNamingStrategy fieldNamingStrategy, com.google.gson.internal.c cVar, d dVar) {
        this.constructorConstructor = bVar;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = cVar;
        this.jsonAdapterFactory = dVar;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.excluder);
    }

    static boolean a(Field field, boolean z, com.google.gson.internal.c cVar) {
        return (cVar.b(field.getType(), z) || cVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = cVar.value();
        String[] dvn = cVar.dvn();
        if (dvn.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(dvn.length + 1);
        arrayList.add(value);
        for (String str : dvn) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Class<? super T> dwa = aVar.dwa();
        if (!Object.class.isAssignableFrom(dwa)) {
            return null;
        }
        return new a(this.constructorConstructor.a(aVar), a(gson, (com.google.gson.b.a<?>) aVar, (Class<?>) dwa));
    }

    private b a(final Gson gson, final Field field, String str, final com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        final boolean j = com.google.gson.internal.h.j(aVar.dwa());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        final TypeAdapter<?> typeAdapter = null;
        if (bVar != null) {
            typeAdapter = this.jsonAdapterFactory.a(this.constructorConstructor, gson, aVar, bVar);
        }
        final boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(aVar);
        }
        return new b(str, z, z2) { // from class: com.google.gson.internal.a.i.1
            @Override // com.google.gson.internal.a.i.b
            void write(com.google.gson.stream.b bVar2, Object obj) throws IOException, IllegalAccessException {
                (z3 ? typeAdapter : new m(gson, typeAdapter, aVar.getType())).write(bVar2, field.get(obj));
            }

            @Override // com.google.gson.internal.a.i.b
            void a(com.google.gson.stream.a aVar2, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter.read(aVar2);
                if (read != null || !j) {
                    field.set(obj, read);
                }
            }

            @Override // com.google.gson.internal.a.i.b
            public boolean bo(Object obj) throws IOException, IllegalAccessException {
                return this.mkn && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(Gson gson, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    this.miO.b(field);
                    Type a4 = C$Gson$Types.a(aVar.getType(), cls, field.getGenericType());
                    List<String> a5 = a(field);
                    b bVar = null;
                    int size = a5.size();
                    int i = 0;
                    while (i < size) {
                        String str = a5.get(i);
                        if (i != 0) {
                            a2 = false;
                        }
                        b bVar2 = (b) linkedHashMap.put(str, a(gson, field, str, com.google.gson.b.a.k(a4), a2, a3));
                        if (bVar != null) {
                            bVar2 = bVar;
                        }
                        i++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.name);
                    }
                }
            }
            aVar = com.google.gson.b.a.k(C$Gson$Types.a(aVar.getType(), cls, cls.getGenericSuperclass()));
            cls = aVar.dwa();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class b {
        final boolean mkn;
        final boolean mko;
        final String name;

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean bo(Object obj) throws IOException, IllegalAccessException;

        abstract void write(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.name = str;
            this.mkn = z;
            this.mko = z2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a<T> extends TypeAdapter<T> {
        private final com.google.gson.internal.f<T> mjQ;
        private final Map<String, b> mkm;

        a(com.google.gson.internal.f<T> fVar, Map<String, b> map) {
            this.mjQ = fVar;
            this.mkm = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dvH() == JsonToken.NULL) {
                aVar.dvM();
                return null;
            }
            T construct = this.mjQ.construct();
            try {
                aVar.dvG();
                while (aVar.hasNext()) {
                    b bVar = this.mkm.get(aVar.dvK());
                    if (bVar == null || !bVar.mko) {
                        aVar.dvN();
                    } else {
                        bVar.a(aVar, construct);
                    }
                }
                aVar.endObject();
                return construct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.dvW();
                return;
            }
            bVar.dvU();
            try {
                for (b bVar2 : this.mkm.values()) {
                    if (bVar2.bo(t)) {
                        bVar.OA(bVar2.name);
                        bVar2.write(bVar, t);
                    }
                }
                bVar.dvV();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
