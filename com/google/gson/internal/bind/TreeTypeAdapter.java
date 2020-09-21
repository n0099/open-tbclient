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
/* loaded from: classes23.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> nOr;
    private final JsonDeserializer<T> nOs;
    private final com.google.gson.b.a<T> nOt;
    private final TypeAdapterFactory nOu;
    private final TreeTypeAdapter<T>.a nOv = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.nOr = jsonSerializer;
        this.nOs = jsonDeserializer;
        this.gson = gson;
        this.nOt = aVar;
        this.nOu = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.nOs == null) {
            return ebh().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.nOs.deserialize(parse, this.nOt.getType(), this.nOv);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.nOr == null) {
            ebh().write(bVar, t);
        } else if (t == null) {
            bVar.ebL();
        } else {
            h.a(this.nOr.serialize(t, this.nOt.getType(), this.nOv), bVar);
        }
    }

    private TypeAdapter<T> ebh() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.nOu, this.nOt);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.ebP(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> nOr;
        private final JsonDeserializer<?> nOs;
        private final com.google.gson.b.a<?> nOx;
        private final boolean nOy;
        private final Class<?> nOz;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.nOr = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.nOs = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.nOr == null && this.nOs == null) ? false : true);
            this.nOx = aVar;
            this.nOy = z;
            this.nOz = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.nOx != null) {
                isAssignableFrom = this.nOx.equals(aVar) || (this.nOy && this.nOx.getType() == aVar.ebP());
            } else {
                isAssignableFrom = this.nOz.isAssignableFrom(aVar.ebP());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.nOr, this.nOs, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes23.dex */
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
