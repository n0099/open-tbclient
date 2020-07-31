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
    private final JsonSerializer<T> nkk;
    private final JsonDeserializer<T> nkl;
    private final com.google.gson.b.a<T> nkm;
    private final TypeAdapterFactory nkn;
    private final l<T>.a nko = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.nkk = jsonSerializer;
        this.nkl = jsonDeserializer;
        this.gson = gson;
        this.nkm = aVar;
        this.nkn = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.nkl == null) {
            return dKY().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.nkl.deserialize(parse, this.nkm.getType(), this.nko);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.nkk == null) {
            dKY().write(bVar, t);
        } else if (t == null) {
            bVar.dLC();
        } else {
            com.google.gson.internal.i.a(this.nkk.serialize(t, this.nkm.getType(), this.nko), bVar);
        }
    }

    private TypeAdapter<T> dKY() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.nkn, this.nkm);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dLG(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> nkk;
        private final JsonDeserializer<?> nkl;
        private final com.google.gson.b.a<?> nkq;
        private final boolean nkr;
        private final Class<?> nks;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.nkk = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.nkl = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.nkk == null && this.nkl == null) ? false : true);
            this.nkq = aVar;
            this.nkr = z;
            this.nks = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.nkq != null) {
                isAssignableFrom = this.nkq.equals(aVar) || (this.nkr && this.nkq.getType() == aVar.dLG());
            } else {
                isAssignableFrom = this.nks.isAssignableFrom(aVar.dLG());
            }
            if (isAssignableFrom) {
                return new l(this.nkk, this.nkl, gson, aVar, this);
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
