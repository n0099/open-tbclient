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
/* loaded from: classes5.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> pTU;
    private final JsonDeserializer<T> pTV;
    private final com.google.gson.b.a<T> pTW;
    private final TypeAdapterFactory pTX;
    private final TreeTypeAdapter<T>.a pTY = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.pTU = jsonSerializer;
        this.pTV = jsonDeserializer;
        this.gson = gson;
        this.pTW = aVar;
        this.pTX = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pTV == null) {
            return eBi().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pTV.deserialize(parse, this.pTW.getType(), this.pTY);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.pTU == null) {
            eBi().write(bVar, t);
        } else if (t == null) {
            bVar.eBQ();
        } else {
            h.a(this.pTU.serialize(t, this.pTW.getType(), this.pTY), bVar);
        }
    }

    private TypeAdapter<T> eBi() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pTX, this.pTW);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.eBU(), null);
    }

    public static TypeAdapterFactory b(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> pTU;
        private final JsonDeserializer<?> pTV;
        private final com.google.gson.b.a<?> pUa;
        private final boolean pUb;
        private final Class<?> pUc;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.pTU = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pTV = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.pTU == null && this.pTV == null) ? false : true);
            this.pUa = aVar;
            this.pUb = z;
            this.pUc = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.pUa != null) {
                isAssignableFrom = this.pUa.equals(aVar) || (this.pUb && this.pUa.getType() == aVar.eBU());
            } else {
                isAssignableFrom = this.pUc.isAssignableFrom(aVar.eBU());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.pTU, this.pTV, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
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
