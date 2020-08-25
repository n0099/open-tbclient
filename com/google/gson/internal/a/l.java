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
    private final JsonSerializer<T> nEd;
    private final JsonDeserializer<T> nEe;
    private final com.google.gson.b.a<T> nEf;
    private final TypeAdapterFactory nEg;
    private final l<T>.a nEh = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.nEd = jsonSerializer;
        this.nEe = jsonDeserializer;
        this.gson = gson;
        this.nEf = aVar;
        this.nEg = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.nEe == null) {
            return dXa().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.nEe.deserialize(parse, this.nEf.getType(), this.nEh);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.nEd == null) {
            dXa().write(bVar, t);
        } else if (t == null) {
            bVar.dXE();
        } else {
            com.google.gson.internal.i.a(this.nEd.serialize(t, this.nEf.getType(), this.nEh), bVar);
        }
    }

    private TypeAdapter<T> dXa() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.nEg, this.nEf);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dXI(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> nEd;
        private final JsonDeserializer<?> nEe;
        private final com.google.gson.b.a<?> nEj;
        private final boolean nEk;
        private final Class<?> nEl;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.nEd = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.nEe = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.nEd == null && this.nEe == null) ? false : true);
            this.nEj = aVar;
            this.nEk = z;
            this.nEl = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.nEj != null) {
                isAssignableFrom = this.nEj.equals(aVar) || (this.nEk && this.nEj.getType() == aVar.dXI());
            } else {
                isAssignableFrom = this.nEl.isAssignableFrom(aVar.dXI());
            }
            if (isAssignableFrom) {
                return new l(this.nEd, this.nEe, gson, aVar, this);
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
