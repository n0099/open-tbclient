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
    private final JsonSerializer<T> mKY;
    private final JsonDeserializer<T> mKZ;
    private final com.google.gson.b.a<T> mLa;
    private final TypeAdapterFactory mLb;
    private final l<T>.a mLc = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mKY = jsonSerializer;
        this.mKZ = jsonDeserializer;
        this.gson = gson;
        this.mLa = aVar;
        this.mLb = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mKZ == null) {
            return dzs().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mKZ.deserialize(parse, this.mLa.getType(), this.mLc);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mKY == null) {
            dzs().write(bVar, t);
        } else if (t == null) {
            bVar.dzY();
        } else {
            com.google.gson.internal.i.a(this.mKY.serialize(t, this.mLa.getType(), this.mLc), bVar);
        }
    }

    private TypeAdapter<T> dzs() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mLb, this.mLa);
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
        private final JsonSerializer<?> mKY;
        private final JsonDeserializer<?> mKZ;
        private final com.google.gson.b.a<?> mLe;
        private final boolean mLf;
        private final Class<?> mLg;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mKY = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mKZ = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mKY == null && this.mKZ == null) ? false : true);
            this.mLe = aVar;
            this.mLf = z;
            this.mLg = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mLe != null) {
                isAssignableFrom = this.mLe.equals(aVar) || (this.mLf && this.mLe.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.mLg.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.mKY, this.mKZ, gson, aVar, this);
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
