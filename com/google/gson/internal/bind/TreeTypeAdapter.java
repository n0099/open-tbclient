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
    private final JsonSerializer<T> odJ;
    private final JsonDeserializer<T> odK;
    private final com.google.gson.b.a<T> odL;
    private final TypeAdapterFactory odM;
    private final TreeTypeAdapter<T>.a odN = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.odJ = jsonSerializer;
        this.odK = jsonDeserializer;
        this.gson = gson;
        this.odL = aVar;
        this.odM = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.odK == null) {
            return eeS().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.odK.deserialize(parse, this.odL.getType(), this.odN);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.odJ == null) {
            eeS().write(bVar, t);
        } else if (t == null) {
            bVar.efw();
        } else {
            h.a(this.odJ.serialize(t, this.odL.getType(), this.odN), bVar);
        }
    }

    private TypeAdapter<T> eeS() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.odM, this.odL);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.efA(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> odJ;
        private final JsonDeserializer<?> odK;
        private final com.google.gson.b.a<?> odP;
        private final boolean odQ;
        private final Class<?> odR;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.odJ = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.odK = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.odJ == null && this.odK == null) ? false : true);
            this.odP = aVar;
            this.odQ = z;
            this.odR = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.odP != null) {
                isAssignableFrom = this.odP.equals(aVar) || (this.odQ && this.odP.getType() == aVar.efA());
            } else {
                isAssignableFrom = this.odR.isAssignableFrom(aVar.efA());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.odJ, this.odK, gson, aVar, this);
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
