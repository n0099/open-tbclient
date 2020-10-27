package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.h;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes17.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> oUZ;
    private final JsonDeserializer<T> oVa;
    private final com.google.gson.b.a<T> oVb;
    private final TypeAdapterFactory oVc;
    private final TreeTypeAdapter<T>.a oVd = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.oUZ = jsonSerializer;
        this.oVa = jsonDeserializer;
        this.gson = gson;
        this.oVb = aVar;
        this.oVc = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.oVa == null) {
            return eoS().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.oVa.deserialize(parse, this.oVb.getType(), this.oVd);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.oUZ == null) {
            eoS().write(bVar, t);
        } else if (t == null) {
            bVar.epw();
        } else {
            h.a(this.oUZ.serialize(t, this.oVb.getType(), this.oVd), bVar);
        }
    }

    private TypeAdapter<T> eoS() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.oVc, this.oVb);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.epA(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> oUZ;
        private final JsonDeserializer<?> oVa;
        private final com.google.gson.b.a<?> oVf;
        private final boolean oVg;
        private final Class<?> oVh;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.oUZ = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.oVa = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.oUZ == null && this.oVa == null) ? false : true);
            this.oVf = aVar;
            this.oVg = z;
            this.oVh = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.oVf != null) {
                isAssignableFrom = this.oVf.equals(aVar) || (this.oVg && this.oVf.getType() == aVar.epA());
            } else {
                isAssignableFrom = this.oVh.isAssignableFrom(aVar.epA());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.oUZ, this.oVa, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes17.dex */
    private final class a implements JsonDeserializationContext, JsonSerializationContext {
        private a() {
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }
}
