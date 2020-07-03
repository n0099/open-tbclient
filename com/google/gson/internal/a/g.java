package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public final class g implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final com.google.gson.internal.b constructorConstructor;

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.constructorConstructor = bVar;
        this.complexMapKeySerialization = z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.dIh())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(type, C$Gson$Types.f(type));
        return new a(gson, b[0], a(gson, b[0]), b[1], gson.getAdapter(com.google.gson.b.a.k(b[1])), this.constructorConstructor.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.nbM : gson.getAdapter(com.google.gson.b.a.k(type));
    }

    /* loaded from: classes7.dex */
    private final class a<K, V> extends TypeAdapter<Map<K, V>> {
        private final com.google.gson.internal.f<? extends Map<K, V>> naX;
        private final TypeAdapter<K> nbi;
        private final TypeAdapter<V> nbj;

        public a(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, com.google.gson.internal.f<? extends Map<K, V>> fVar) {
            this.nbi = new m(gson, typeAdapter, type);
            this.nbj = new m(gson, typeAdapter2, type2);
            this.naX = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken dHO = aVar.dHO();
            if (dHO == JsonToken.NULL) {
                aVar.dHT();
                return null;
            }
            Map<K, V> construct = this.naX.construct();
            if (dHO == JsonToken.BEGIN_ARRAY) {
                aVar.dHM();
                while (aVar.hasNext()) {
                    aVar.dHM();
                    K read = this.nbi.read(aVar);
                    if (construct.put(read, this.nbj.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return construct;
            }
            aVar.dHN();
            while (aVar.hasNext()) {
                com.google.gson.internal.e.nap.a(aVar);
                K read2 = this.nbi.read(aVar);
                if (construct.put(read2, this.nbj.read(aVar)) != null) {
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
                bVar.dId();
            } else if (!g.this.complexMapKeySerialization) {
                bVar.dIb();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.Rb(String.valueOf(entry.getKey()));
                    this.nbj.write(bVar, entry.getValue());
                }
                bVar.dIc();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.nbi.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z = (jsonTree.isJsonArray() || jsonTree.isJsonObject()) | z;
                }
                if (z) {
                    bVar.dHZ();
                    int size = arrayList.size();
                    while (i < size) {
                        bVar.dHZ();
                        com.google.gson.internal.i.a((JsonElement) arrayList.get(i), bVar);
                        this.nbj.write(bVar, arrayList2.get(i));
                        bVar.dIa();
                        i++;
                    }
                    bVar.dIa();
                    return;
                }
                bVar.dIb();
                int size2 = arrayList.size();
                while (i < size2) {
                    bVar.Rb(b((JsonElement) arrayList.get(i)));
                    this.nbj.write(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.dIc();
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
