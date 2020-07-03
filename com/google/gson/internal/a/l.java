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
/* loaded from: classes7.dex */
public final class l<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final TypeAdapterFactory nbA;
    private final l<T>.a nbB = new a();
    private final JsonSerializer<T> nbx;
    private final JsonDeserializer<T> nby;
    private final com.google.gson.b.a<T> nbz;

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.nbx = jsonSerializer;
        this.nby = jsonDeserializer;
        this.gson = gson;
        this.nbz = aVar;
        this.nbA = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.nby == null) {
            return dHz().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.nby.deserialize(parse, this.nbz.getType(), this.nbB);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.nbx == null) {
            dHz().write(bVar, t);
        } else if (t == null) {
            bVar.dId();
        } else {
            com.google.gson.internal.i.a(this.nbx.serialize(t, this.nbz.getType(), this.nbB), bVar);
        }
    }

    private TypeAdapter<T> dHz() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.nbA, this.nbz);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dIh(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements TypeAdapterFactory {
        private final com.google.gson.b.a<?> nbD;
        private final boolean nbE;
        private final Class<?> nbF;
        private final JsonSerializer<?> nbx;
        private final JsonDeserializer<?> nby;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.nbx = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.nby = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.nbx == null && this.nby == null) ? false : true);
            this.nbD = aVar;
            this.nbE = z;
            this.nbF = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.nbD != null) {
                isAssignableFrom = this.nbD.equals(aVar) || (this.nbE && this.nbD.getType() == aVar.dIh());
            } else {
                isAssignableFrom = this.nbF.isAssignableFrom(aVar.dIh());
            }
            if (isAssignableFrom) {
                return new l(this.nbx, this.nby, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
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
