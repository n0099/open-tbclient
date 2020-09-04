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
/* loaded from: classes3.dex */
public final class l<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> nEv;
    private final JsonDeserializer<T> nEw;
    private final com.google.gson.b.a<T> nEx;
    private final TypeAdapterFactory nEy;
    private final l<T>.a nEz = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.nEv = jsonSerializer;
        this.nEw = jsonDeserializer;
        this.gson = gson;
        this.nEx = aVar;
        this.nEy = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.nEw == null) {
            return dXj().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.nEw.deserialize(parse, this.nEx.getType(), this.nEz);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.nEv == null) {
            dXj().write(bVar, t);
        } else if (t == null) {
            bVar.dXN();
        } else {
            com.google.gson.internal.i.a(this.nEv.serialize(t, this.nEx.getType(), this.nEz), bVar);
        }
    }

    private TypeAdapter<T> dXj() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.nEy, this.nEx);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dXR(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements TypeAdapterFactory {
        private final com.google.gson.b.a<?> nEB;
        private final boolean nEC;
        private final Class<?> nED;
        private final JsonSerializer<?> nEv;
        private final JsonDeserializer<?> nEw;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.nEv = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.nEw = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.nEv == null && this.nEw == null) ? false : true);
            this.nEB = aVar;
            this.nEC = z;
            this.nED = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.nEB != null) {
                isAssignableFrom = this.nEB.equals(aVar) || (this.nEC && this.nEB.getType() == aVar.dXR());
            } else {
                isAssignableFrom = this.nED.isAssignableFrom(aVar.dXR());
            }
            if (isAssignableFrom) {
                return new l(this.nEv, this.nEw, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
