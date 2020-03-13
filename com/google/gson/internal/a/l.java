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
    private final JsonSerializer<T> mLT;
    private final JsonDeserializer<T> mLU;
    private final com.google.gson.b.a<T> mLV;
    private final TypeAdapterFactory mLW;
    private final l<T>.a mLX = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mLT = jsonSerializer;
        this.mLU = jsonDeserializer;
        this.gson = gson;
        this.mLV = aVar;
        this.mLW = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mLU == null) {
            return dAF().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mLU.deserialize(parse, this.mLV.getType(), this.mLX);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mLT == null) {
            dAF().write(bVar, t);
        } else if (t == null) {
            bVar.dBj();
        } else {
            com.google.gson.internal.i.a(this.mLT.serialize(t, this.mLV.getType(), this.mLX), bVar);
        }
    }

    private TypeAdapter<T> dAF() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mLW, this.mLV);
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
    /* loaded from: classes7.dex */
    public static final class b implements TypeAdapterFactory {
        private final JsonSerializer<?> mLT;
        private final JsonDeserializer<?> mLU;
        private final com.google.gson.b.a<?> mLZ;
        private final boolean mMa;
        private final Class<?> mMb;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mLT = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mLU = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mLT == null && this.mLU == null) ? false : true);
            this.mLZ = aVar;
            this.mMa = z;
            this.mMb = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mLZ != null) {
                isAssignableFrom = this.mLZ.equals(aVar) || (this.mMa && this.mLZ.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.mMb.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.mLT, this.mLU, gson, aVar, this);
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
