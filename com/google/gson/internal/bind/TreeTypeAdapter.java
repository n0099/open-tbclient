package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.h;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes17.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> peu;
    private final JsonDeserializer<T> pev;
    private final com.google.gson.b.a<T> pew;
    private final TypeAdapterFactory pex;
    private final TreeTypeAdapter<T>.a pey = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.peu = jsonSerializer;
        this.pev = jsonDeserializer;
        this.gson = gson;
        this.pew = aVar;
        this.pex = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pev == null) {
            return esH().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pev.deserialize(parse, this.pew.getType(), this.pey);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.peu == null) {
            esH().write(bVar, t);
        } else if (t == null) {
            bVar.etl();
        } else {
            h.a(this.peu.serialize(t, this.pew.getType(), this.pey), bVar);
        }
    }

    private TypeAdapter<T> esH() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pex, this.pew);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.etp(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final com.google.gson.b.a<?> peA;
        private final boolean peB;
        private final Class<?> peC;
        private final JsonSerializer<?> peu;
        private final JsonDeserializer<?> pev;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.peu = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pev = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.peu == null && this.pev == null) ? false : true);
            this.peA = aVar;
            this.peB = z;
            this.peC = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.peA != null) {
                isAssignableFrom = this.peA.equals(aVar) || (this.peB && this.peA.getType() == aVar.etp());
            } else {
                isAssignableFrom = this.peC.isAssignableFrom(aVar.etp());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.peu, this.pev, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes17.dex */
    private final class a implements JsonDeserializationContext, JsonSerializationContext {
        private a() {
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.gson.toJsonTree(obj, type);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }
}
