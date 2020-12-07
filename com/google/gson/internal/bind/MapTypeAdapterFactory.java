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
        if (!Map.class.isAssignableFrom(aVar.eyV())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(type, C$Gson$Types.f(type));
        return new Adapter(gson, b[0], a(gson, b[0]), b[1], gson.getAdapter(com.google.gson.b.a.k(b[1])), this.constructorConstructor.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.pvv : gson.getAdapter(com.google.gson.b.a.k(type));
    }

    /* loaded from: classes5.dex */
    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final e<? extends Map<K, V>> puG;
        private final TypeAdapter<K> puR;
        private final TypeAdapter<V> puS;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, e<? extends Map<K, V>> eVar) {
            this.puR = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.puS = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.puG = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken eyy = aVar.eyy();
            if (eyy == JsonToken.NULL) {
                aVar.eyE();
                return null;
            }
            Map<K, V> construct = this.puG.construct();
            if (eyy == JsonToken.BEGIN_ARRAY) {
                aVar.eyw();
                while (aVar.hasNext()) {
                    aVar.eyw();
                    K read = this.puR.read(aVar);
                    if (construct.put(read, this.puS.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return construct;
            }
            aVar.eyx();
            while (aVar.hasNext()) {
                d.ptY.a(aVar);
                K read2 = this.puR.read(aVar);
                if (construct.put(read2, this.puS.read(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + read2);
                }
            }
            aVar.endObject();
            return construct;
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
                bVar.eyR();
            } else if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                bVar.eyP();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.ZF(String.valueOf(entry.getKey()));
                    this.puS.write(bVar, entry.getValue());
                }
                bVar.eyQ();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.puR.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z = (jsonTree.isJsonArray() || jsonTree.isJsonObject()) | z;
                }
                if (z) {
                    bVar.eyN();
                    int size = arrayList.size();
                    while (i < size) {
                        bVar.eyN();
                        h.a((JsonElement) arrayList.get(i), bVar);
                        this.puS.write(bVar, arrayList2.get(i));
                        bVar.eyO();
                        i++;
                    }
                    bVar.eyO();
                    return;
                }
                bVar.eyP();
                int size2 = arrayList.size();
                while (i < size2) {
                    bVar.ZF(b((JsonElement) arrayList.get(i)));
                    this.puS.write(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.eyQ();
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
