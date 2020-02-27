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
    private final JsonSerializer<T> mLG;
    private final JsonDeserializer<T> mLH;
    private final com.google.gson.b.a<T> mLI;
    private final TypeAdapterFactory mLJ;
    private final l<T>.a mLK = new a();

    public l(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.mLG = jsonSerializer;
        this.mLH = jsonDeserializer;
        this.gson = gson;
        this.mLI = aVar;
        this.mLJ = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.mLH == null) {
            return dAC().read(aVar);
        }
        JsonElement parse = com.google.gson.internal.i.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.mLH.deserialize(parse, this.mLI.getType(), this.mLK);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.mLG == null) {
            dAC().write(bVar, t);
        } else if (t == null) {
            bVar.dBg();
        } else {
            com.google.gson.internal.i.a(this.mLG.serialize(t, this.mLI.getType(), this.mLK), bVar);
        }
    }

    private TypeAdapter<T> dAC() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.mLJ, this.mLI);
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
        private final JsonSerializer<?> mLG;
        private final JsonDeserializer<?> mLH;
        private final com.google.gson.b.a<?> mLM;
        private final boolean mLN;
        private final Class<?> mLO;

        b(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.mLG = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.mLH = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.mLG == null && this.mLH == null) ? false : true);
            this.mLM = aVar;
            this.mLN = z;
            this.mLO = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.mLM != null) {
                isAssignableFrom = this.mLM.equals(aVar) || (this.mLN && this.mLM.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.mLO.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.mLG, this.mLH, gson, aVar, this);
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
