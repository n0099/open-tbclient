package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.a.c;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.e;
import com.google.gson.internal.g;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final com.google.gson.internal.a.b pTh = com.google.gson.internal.a.b.eBX();

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.b bVar, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = bVar;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean b(Field field, boolean z) {
        return a(field, z, this.excluder);
    }

    static boolean a(Field field, boolean z, Excluder excluder) {
        return (excluder.c(field.getType(), z) || excluder.b(field, z)) ? false : true;
    }

    private List<String> b(Field field) {
        c cVar = (c) field.getAnnotation(c.class);
        if (cVar == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = cVar.value();
        String[] eBi = cVar.eBi();
        if (eBi.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(eBi.length + 1);
        arrayList.add(value);
        for (String str : eBi) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Class<? super T> eCa = aVar.eCa();
        if (!Object.class.isAssignableFrom(eCa)) {
            return null;
        }
        return new Adapter(this.constructorConstructor.a(aVar), a(gson, (com.google.gson.b.a<?>) aVar, (Class<?>) eCa));
    }

    private a a(final Gson gson, final Field field, String str, final com.google.gson.b.a<?> aVar, boolean z, boolean z2) {
        final boolean q = g.q(aVar.eCa());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        final TypeAdapter<?> typeAdapter = null;
        if (bVar != null) {
            typeAdapter = this.jsonAdapterFactory.a(this.constructorConstructor, gson, aVar, bVar);
        }
        final boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(aVar);
        }
        return new a(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
            void write(com.google.gson.stream.b bVar2, Object obj) throws IOException, IllegalAccessException {
                (z3 ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, aVar.getType())).write(bVar2, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
            void a(com.google.gson.stream.a aVar2, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter.read(aVar2);
                if (read != null || !q) {
                    field.set(obj, read);
                }
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.a
            public boolean bG(Object obj) throws IOException, IllegalAccessException {
                return this.pUG && field.get(obj) != obj;
            }
        };
    }

    private Map<String, a> a(Gson gson, com.google.gson.b.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean b = b(field, true);
                boolean b2 = b(field, false);
                if (b || b2) {
                    this.pTh.c(field);
                    Type b3 = C$Gson$Types.b(aVar.getType(), cls, field.getGenericType());
                    List<String> b4 = b(field);
                    a aVar2 = null;
                    int size = b4.size();
                    int i = 0;
                    while (i < size) {
                        String str = b4.get(i);
                        if (i != 0) {
                            b = false;
                        }
                        a aVar3 = (a) linkedHashMap.put(str, a(gson, field, str, com.google.gson.b.a.r(b3), b, b2));
                        if (aVar2 != null) {
                            aVar3 = aVar2;
                        }
                        i++;
                        aVar2 = aVar3;
                    }
                    if (aVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + aVar2.name);
                    }
                }
            }
            aVar = com.google.gson.b.a.r(C$Gson$Types.b(aVar.getType(), cls, cls.getGenericSuperclass()));
            cls = aVar.eCa();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class a {
        final String name;
        final boolean pUG;
        final boolean pUH;

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean bG(Object obj) throws IOException, IllegalAccessException;

        abstract void write(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        protected a(String str, boolean z, boolean z2) {
            this.name = str;
            this.pUG = z;
            this.pUH = z2;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, a> pUF;
        private final e<T> pUj;

        Adapter(e<T> eVar, Map<String, a> map) {
            this.pUj = eVar;
            this.pUF = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBD() == JsonToken.NULL) {
                aVar.eBJ();
                return null;
            }
            T eBk = this.pUj.eBk();
            try {
                aVar.eBC();
                while (aVar.hasNext()) {
                    a aVar2 = this.pUF.get(aVar.eBG());
                    if (aVar2 == null || !aVar2.pUH) {
                        aVar.eBN();
                    } else {
                        aVar2.a(aVar, eBk);
                    }
                }
                aVar.endObject();
                return eBk;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.eBW();
                return;
            }
            bVar.eBU();
            try {
                for (a aVar : this.pUF.values()) {
                    if (aVar.bG(t)) {
                        bVar.aab(aVar.name);
                        aVar.write(bVar, t);
                    }
                }
                bVar.eBV();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
