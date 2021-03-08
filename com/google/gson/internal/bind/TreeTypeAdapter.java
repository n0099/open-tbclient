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
/* loaded from: classes4.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> pUJ;
    private final JsonDeserializer<T> pUK;
    private final com.google.gson.b.a<T> pUL;
    private final TypeAdapterFactory pUM;
    private final TreeTypeAdapter<T>.a pUN = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.pUJ = jsonSerializer;
        this.pUK = jsonDeserializer;
        this.gson = gson;
        this.pUL = aVar;
        this.pUM = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pUK == null) {
            return eBo().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pUK.deserialize(parse, this.pUL.getType(), this.pUN);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.pUJ == null) {
            eBo().write(bVar, t);
        } else if (t == null) {
            bVar.eBW();
        } else {
            h.a(this.pUJ.serialize(t, this.pUL.getType(), this.pUN), bVar);
        }
    }

    private TypeAdapter<T> eBo() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pUM, this.pUL);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.eCa(), null);
    }

    public static TypeAdapterFactory b(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> pUJ;
        private final JsonDeserializer<?> pUK;
        private final com.google.gson.b.a<?> pUP;
        private final boolean pUQ;
        private final Class<?> pUR;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.pUJ = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pUK = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.pUJ == null && this.pUK == null) ? false : true);
            this.pUP = aVar;
            this.pUQ = z;
            this.pUR = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.pUP != null) {
                isAssignableFrom = this.pUP.equals(aVar) || (this.pUQ && this.pUP.getType() == aVar.eCa());
            } else {
                isAssignableFrom = this.pUR.isAssignableFrom(aVar.eCa());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.pUJ, this.pUK, gson, aVar, this);
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
