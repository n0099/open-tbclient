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
/* loaded from: classes5.dex */
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
        if (!Map.class.isAssignableFrom(aVar.eBM())) {
            return null;
        }
        Type[] d = C$Gson$Types.d(type, C$Gson$Types.m(type));
        return new Adapter(gson, d[0], a(gson, d[0]), d[1], gson.getAdapter(com.google.gson.b.a.r(d[1])), this.constructorConstructor.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.pTJ : gson.getAdapter(com.google.gson.b.a.r(type));
    }

    /* loaded from: classes5.dex */
    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final e<? extends Map<K, V>> pSU;
        private final TypeAdapter<K> pTf;
        private final TypeAdapter<V> pTg;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, e<? extends Map<K, V>> eVar) {
            this.pTf = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.pTg = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.pSU = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eBp = aVar.eBp();
            if (eBp == JsonToken.NULL) {
                aVar.eBv();
                return null;
            }
            Map<K, V> eAW = this.pSU.eAW();
            if (eBp == JsonToken.BEGIN_ARRAY) {
                aVar.eBn();
                while (aVar.hasNext()) {
                    aVar.eBn();
                    K read = this.pTf.read(aVar);
                    if (eAW.put(read, this.pTg.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return eAW;
            }
            aVar.eBo();
            while (aVar.hasNext()) {
                d.pSn.a(aVar);
                K read2 = this.pTf.read(aVar);
                if (eAW.put(read2, this.pTg.read(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read2);
                }
            }
            aVar.endObject();
            return eAW;
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
                bVar.eBI();
            } else if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                bVar.eBG();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.ZK(String.valueOf(entry.getKey()));
                    this.pTg.write(bVar, entry.getValue());
                }
                bVar.eBH();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.pTf.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z = (jsonTree.isJsonArray() || jsonTree.isJsonObject()) | z;
                }
                if (z) {
                    bVar.eBE();
                    int size = arrayList.size();
                    while (i < size) {
                        bVar.eBE();
                        h.a((JsonElement) arrayList.get(i), bVar);
                        this.pTg.write(bVar, arrayList2.get(i));
                        bVar.eBF();
                        i++;
                    }
                    bVar.eBF();
                    return;
                }
                bVar.eBG();
                int size2 = arrayList.size();
                while (i < size2) {
                    bVar.ZK(b((JsonElement) arrayList.get(i)));
                    this.pTg.write(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.eBH();
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
