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
/* loaded from: classes17.dex */
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
        if (!Map.class.isAssignableFrom(aVar.etp())) {
            return null;
        }
        Type[] b = C$Gson$Types.b(type, C$Gson$Types.f(type));
        return new Adapter(gson, b[0], a(gson, b[0]), b[1], gson.getAdapter(com.google.gson.b.a.k(b[1])), this.constructorConstructor.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.peJ : gson.getAdapter(com.google.gson.b.a.k(type));
    }

    /* loaded from: classes17.dex */
    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final e<? extends Map<K, V>> pdU;
        private final TypeAdapter<K> pef;
        private final TypeAdapter<V> peg;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, e<? extends Map<K, V>> eVar) {
            this.pef = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.peg = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.pdU = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken esW = aVar.esW();
            if (esW == JsonToken.NULL) {
                aVar.etb();
                return null;
            }
            Map<K, V> construct = this.pdU.construct();
            if (esW == JsonToken.BEGIN_ARRAY) {
                aVar.esU();
                while (aVar.hasNext()) {
                    aVar.esU();
                    K read = this.pef.read(aVar);
                    if (construct.put(read, this.peg.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                    aVar.endArray();
                }
                aVar.endArray();
                return construct;
            }
            aVar.esV();
            while (aVar.hasNext()) {
                d.pdm.a(aVar);
                K read2 = this.pef.read(aVar);
                if (construct.put(read2, this.peg.read(aVar)) != null) {
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
                bVar.etl();
            } else if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                bVar.etj();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.Yz(String.valueOf(entry.getKey()));
                    this.peg.write(bVar, entry.getValue());
                }
                bVar.etk();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.pef.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z = (jsonTree.isJsonArray() || jsonTree.isJsonObject()) | z;
                }
                if (z) {
                    bVar.eth();
                    int size = arrayList.size();
                    while (i < size) {
                        bVar.eth();
                        h.a((JsonElement) arrayList.get(i), bVar);
                        this.peg.write(bVar, arrayList2.get(i));
                        bVar.eti();
                        i++;
                    }
                    bVar.eti();
                    return;
                }
                bVar.etj();
                int size2 = arrayList.size();
                while (i < size2) {
                    bVar.Yz(b((JsonElement) arrayList.get(i)));
                    this.peg.write(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.etk();
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
