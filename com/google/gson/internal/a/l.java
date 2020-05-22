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
    private final JsonSerializer<T> mEk;
    private final JsonDeserializer<T> mEl;
    private final com.google.gson.b.a<T> mEm;
    private final TypeAdapterFactory mEn;
    private final l<T>.a mEo = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mEk = jsonSerializer;
        this.mEl = jsonDeserializer;
        this.gson = gson;
        this.mEm = aVar;
        this.mEn = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mEl == null) {
            return dCJ().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mEl.deserialize(parse, this.mEm.getType(), this.mEo);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mEk == null) {
            dCJ().write(bVar, t);
        } else if (t == null) {
            bVar.dDn();
        } else {
            com.google.gson.internal.i.a(this.mEk.serialize(t, this.mEm.getType(), this.mEo), bVar);
        }
    }

    private TypeAdapter<T> dCJ() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mEn, this.mEm);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dDr(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> mEk;
        private final JsonDeserializer<?> mEl;
        private final com.google.gson.b.a<?> mEq;
        private final boolean mEr;
        private final Class<?> mEs;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mEk = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mEl = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mEk == null && this.mEl == null) ? false : true);
            this.mEq = aVar;
            this.mEr = z;
            this.mEs = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mEq != null) {
                isAssignableFrom = this.mEq.equals(aVar) || (this.mEr && this.mEq.getType() == aVar.dDr());
            } else {
                isAssignableFrom = this.mEs.isAssignableFrom(aVar.dDr());
            }
            if (isAssignableFrom) {
                return new l(this.mEk, this.mEl, gson, aVar, this);
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
