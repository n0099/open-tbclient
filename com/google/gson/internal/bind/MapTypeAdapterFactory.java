package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.d;
import com.google.gson.internal.e;
import com.google.gson.internal.h;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final com.google.gson.internal.b constructorConstructor;

    public MapTypeAdapterFactory(com.google.gson.internal.b bVar, boolean z) {
        this.constructorConstructor = bVar;
        this.complexMapKeySerialization = z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.ezu())) {
            return null;
        }
        Type[] d = C$Gson$Types.d(type, C$Gson$Types.m(type));
        return new Adapter(gson, d[0], a(gson, d[0]), d[1], gson.getAdapter(com.google.gson.b.a.r(d[1])), this.constructorConstructor.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.pJE : gson.getAdapter(com.google.gson.b.a.r(type));
    }

    /* loaded from: classes4.dex */
    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final e<? extends Map<K, V>> pIP;
        private final TypeAdapter<K> pJa;
        private final TypeAdapter<V> pJb;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, e<? extends Map<K, V>> eVar) {
            this.pJa = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.pJb = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.pIP = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyX = aVar.eyX();
            if (eyX == JsonToken.NULL) {
                aVar.ezd();
                return null;
            }
            Map<K, V> eyE = this.pIP.eyE();
            if (eyX == JsonToken.BEGIN_ARRAY) {
                aVar.eyV();
                while (aVar.hasNext()) {
                    aVar.eyV();
                    K read = this.pJa.read(aVar);
                    if (eyE.put(read, this.pJb.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return eyE;
            }
            aVar.eyW();
            while (aVar.hasNext()) {
                d.pIi.a(aVar);
                K read2 = this.pJa.read(aVar);
                if (eyE.put(read2, this.pJb.read(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read2);
                }
            }
            aVar.endObject();
            return eyE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.google.gson.TypeAdapter<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.google.gson.TypeAdapter<V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                bVar.ezq();
            } else if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                bVar.ezo();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.YJ(String.valueOf(entry.getKey()));
                    this.pJb.write(bVar, entry.getValue());
                }
                bVar.ezp();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.pJa.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z = (jsonTree.isJsonArray() || jsonTree.isJsonObject()) | z;
                }
                if (z) {
                    bVar.ezm();
                    int size = arrayList.size();
                    while (i < size) {
                        bVar.ezm();
                        h.a((JsonElement) arrayList.get(i), bVar);
                        this.pJb.write(bVar, arrayList2.get(i));
                        bVar.ezn();
                        i++;
                    }
                    bVar.ezn();
                    return;
                }
                bVar.ezo();
                int size2 = arrayList.size();
                while (i < size2) {
                    bVar.YJ(b((JsonElement) arrayList.get(i)));
                    this.pJb.write(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.ezp();
            }
        }

        private String b(JsonElement jsonElement) {
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                throw new AssertionError();
            } else if (jsonElement.isJsonNull()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
