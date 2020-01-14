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
/* loaded from: classes5.dex */
public final class l<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> mLd;
    private final JsonDeserializer<T> mLe;
    private final com.google.gson.b.a<T> mLf;
    private final TypeAdapterFactory mLg;
    private final l<T>.a mLh = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mLd = jsonSerializer;
        this.mLe = jsonDeserializer;
        this.gson = gson;
        this.mLf = aVar;
        this.mLg = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mLe == null) {
            return dzu().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mLe.deserialize(parse, this.mLf.getType(), this.mLh);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mLd == null) {
            dzu().write(bVar, t);
        } else if (t == null) {
            bVar.dAa();
        } else {
            com.google.gson.internal.i.a(this.mLd.serialize(t, this.mLf.getType(), this.mLh), bVar);
        }
    }

    private TypeAdapter<T> dzu() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mLg, this.mLf);
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
    /* loaded from: classes5.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> mLd;
        private final JsonDeserializer<?> mLe;
        private final com.google.gson.b.a<?> mLj;
        private final boolean mLk;
        private final Class<?> mLl;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mLd = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mLe = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mLd == null && this.mLe == null) ? false : true);
            this.mLj = aVar;
            this.mLk = z;
            this.mLl = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mLj != null) {
                isAssignableFrom = this.mLj.equals(aVar) || (this.mLk && this.mLj.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.mLl.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.mLd, this.mLe, gson, aVar, this);
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
