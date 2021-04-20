package com.google.gson.internal.bind;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import d.g.d.b.b;
import d.g.d.b.d;
import d.g.d.b.e;
import d.g.d.b.h;
import d.g.d.d.a;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: e  reason: collision with root package name */
    public final b f31240e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f31241f;

    /* loaded from: classes6.dex */
    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        public final TypeAdapter<K> f31242a;

        /* renamed from: b  reason: collision with root package name */
        public final TypeAdapter<V> f31243b;

        /* renamed from: c  reason: collision with root package name */
        public final e<? extends Map<K, V>> f31244c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, e<? extends Map<K, V>> eVar) {
            this.f31242a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f31243b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f31244c = eVar;
        }

        public final String a(JsonElement jsonElement) {
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
                return StringUtil.NULL_STRING;
            } else {
                throw new AssertionError();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public Map<K, V> read(a aVar) throws IOException {
            JsonToken M = aVar.M();
            if (M == JsonToken.NULL) {
                aVar.I();
                return null;
            }
            Map<K, V> a2 = this.f31244c.a();
            if (M == JsonToken.BEGIN_ARRAY) {
                aVar.n();
                while (aVar.y()) {
                    aVar.n();
                    K read = this.f31242a.read(aVar);
                    if (a2.put(read, this.f31243b.read(aVar)) == null) {
                        aVar.t();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                aVar.t();
            } else {
                aVar.o();
                while (aVar.y()) {
                    d.f67095a.a(aVar);
                    K read2 = this.f31242a.read(aVar);
                    if (a2.put(read2, this.f31243b.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                aVar.v();
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.google.gson.TypeAdapter<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.google.gson.TypeAdapter<V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: c */
        public void write(d.g.d.d.b bVar, Map<K, V> map) throws IOException {
            if (map == null) {
                bVar.B();
            } else if (!MapTypeAdapterFactory.this.f31241f) {
                bVar.r();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.z(String.valueOf(entry.getKey()));
                    this.f31243b.write(bVar, entry.getValue());
                }
                bVar.v();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    JsonElement jsonTree = this.f31242a.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
                }
                if (z) {
                    bVar.q();
                    int size = arrayList.size();
                    while (i < size) {
                        bVar.q();
                        h.b((JsonElement) arrayList.get(i), bVar);
                        this.f31243b.write(bVar, arrayList2.get(i));
                        bVar.t();
                        i++;
                    }
                    bVar.t();
                    return;
                }
                bVar.r();
                int size2 = arrayList.size();
                while (i < size2) {
                    bVar.z(a((JsonElement) arrayList.get(i)));
                    this.f31243b.write(bVar, arrayList2.get(i));
                    i++;
                }
                bVar.v();
            }
        }
    }

    public MapTypeAdapterFactory(b bVar, boolean z) {
        this.f31240e = bVar;
        this.f31241f = z;
    }

    public final TypeAdapter<?> a(Gson gson, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return gson.getAdapter(d.g.d.c.a.b(type));
        }
        return TypeAdapters.f31287f;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, d.g.d.c.a<T> aVar) {
        Type e2 = aVar.e();
        if (Map.class.isAssignableFrom(aVar.c())) {
            Type[] j = C$Gson$Types.j(e2, C$Gson$Types.k(e2));
            return new Adapter(gson, j[0], a(gson, j[0]), j[1], gson.getAdapter(d.g.d.c.a.b(j[1])), this.f31240e.a(aVar));
        }
        return null;
    }
}
