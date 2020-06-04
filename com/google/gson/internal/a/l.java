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
    private final JsonSerializer<T> mFv;
    private final JsonDeserializer<T> mFw;
    private final com.google.gson.b.a<T> mFx;
    private final TypeAdapterFactory mFy;
    private final l<T>.a mFz = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mFv = jsonSerializer;
        this.mFw = jsonDeserializer;
        this.gson = gson;
        this.mFx = aVar;
        this.mFy = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mFw == null) {
            return dCX().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mFw.deserialize(parse, this.mFx.getType(), this.mFz);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mFv == null) {
            dCX().write(bVar, t);
        } else if (t == null) {
            bVar.dDB();
        } else {
            com.google.gson.internal.i.a(this.mFv.serialize(t, this.mFx.getType(), this.mFz), bVar);
        }
    }

    private TypeAdapter<T> dCX() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mFy, this.mFx);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.getType() == aVar.dDF(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements TypeAdapterFactory {
        private final com.google.gson.b.a<?> mFB;
        private final boolean mFC;
        private final Class<?> mFD;
        private final JsonSerializer<?> mFv;
        private final JsonDeserializer<?> mFw;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mFv = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mFw = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mFv == null && this.mFw == null) ? false : true);
            this.mFB = aVar;
            this.mFC = z;
            this.mFD = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mFB != null) {
                isAssignableFrom = this.mFB.equals(aVar) || (this.mFC && this.mFB.getType() == aVar.dDF());
            } else {
                isAssignableFrom = this.mFD.isAssignableFrom(aVar.dDF());
            }
            if (isAssignableFrom) {
                return new l(this.mFv, this.mFw, gson, aVar, this);
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
