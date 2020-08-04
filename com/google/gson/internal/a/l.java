package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes10.dex */
public final class l<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> nkm;
    private final JsonDeserializer<T> nkn;
    private final com.google.gson.b.a<T> nko;
    private final TypeAdapterFactory nkp;
    private final l<T>.a nkq = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.nkm = jsonSerializer;
        this.nkn = jsonDeserializer;
        this.gson = gson;
        this.nko = aVar;
        this.nkp = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.nkn == null) {
            return dKZ().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.nkn.deserialize(parse, this.nko.getType(), this.nkq);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.nkm == null) {
            dKZ().write(bVar, t);
        } else if (t == null) {
            bVar.dLD();
        } else {
            com.google.gson.internal.i.a(this.nkm.serialize(t, this.nko.getType(), this.nkq), bVar);
        }
    }

    private TypeAdapter<T> dKZ() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.nkp, this.nko);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dLH(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> nkm;
        private final JsonDeserializer<?> nkn;
        private final com.google.gson.b.a<?> nks;
        private final boolean nkt;
        private final Class<?> nku;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.nkm = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.nkn = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.nkm == null && this.nkn == null) ? false : true);
            this.nks = aVar;
            this.nkt = z;
            this.nku = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.nks != null) {
                isAssignableFrom = this.nks.equals(aVar) || (this.nkt && this.nks.getType() == aVar.dLH());
            } else {
                isAssignableFrom = this.nku.isAssignableFrom(aVar.dLH());
            }
            if (isAssignableFrom) {
                return new l(this.nkm, this.nkn, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    private final class a implements JsonDeserializationContext, JsonSerializationContext {
        private a() {
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return l.this.gson.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return l.this.gson.toJsonTree(obj, type);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) l.this.gson.fromJson(jsonElement, type);
        }
    }
}
