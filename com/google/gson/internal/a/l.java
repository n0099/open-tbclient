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
/* loaded from: classes4.dex */
public final class l<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> mHg;
    private final JsonDeserializer<T> mHh;
    private final com.google.gson.b.a<T> mHi;
    private final TypeAdapterFactory mHj;
    private final l<T>.a mHk = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mHg = jsonSerializer;
        this.mHh = jsonDeserializer;
        this.gson = gson;
        this.mHi = aVar;
        this.mHj = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mHh == null) {
            return dyj().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mHh.deserialize(parse, this.mHi.getType(), this.mHk);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mHg == null) {
            dyj().write(bVar, t);
        } else if (t == null) {
            bVar.dyT();
        } else {
            com.google.gson.internal.i.a(this.mHg.serialize(t, this.mHi.getType(), this.mHk), bVar);
        }
    }

    private TypeAdapter<T> dyj() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mHj, this.mHi);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> mHg;
        private final JsonDeserializer<?> mHh;
        private final com.google.gson.b.a<?> mHm;
        private final boolean mHn;
        private final Class<?> mHo;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mHg = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mHh = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mHg == null && this.mHh == null) ? false : true);
            this.mHm = aVar;
            this.mHn = z;
            this.mHo = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mHm != null) {
                isAssignableFrom = this.mHm.equals(aVar) || (this.mHn && this.mHm.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.mHo.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.mHg, this.mHh, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
