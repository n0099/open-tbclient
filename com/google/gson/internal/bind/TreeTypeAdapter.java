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
/* loaded from: classes5.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Gson gson;
    private final JsonSerializer<T> pvi;
    private final JsonDeserializer<T> pvj;
    private final com.google.gson.b.a<T> pvk;
    private final TypeAdapterFactory pvl;
    private final TreeTypeAdapter<T>.a pvm = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.pvi = jsonSerializer;
        this.pvj = jsonDeserializer;
        this.gson = gson;
        this.pvk = aVar;
        this.pvl = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pvj == null) {
            return eyk().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pvj.deserialize(parse, this.pvk.getType(), this.pvm);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.pvi == null) {
            eyk().write(bVar, t);
        } else if (t == null) {
            bVar.eyS();
        } else {
            h.a(this.pvi.serialize(t, this.pvk.getType(), this.pvm), bVar);
        }
    }

    private TypeAdapter<T> eyk() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pvl, this.pvk);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.eyW(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> pvi;
        private final JsonDeserializer<?> pvj;
        private final com.google.gson.b.a<?> pvo;
        private final boolean pvp;
        private final Class<?> pvq;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.pvi = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pvj = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.pvi == null && this.pvj == null) ? false : true);
            this.pvo = aVar;
            this.pvp = z;
            this.pvq = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.pvo != null) {
                isAssignableFrom = this.pvo.equals(aVar) || (this.pvp && this.pvo.getType() == aVar.eyW());
            } else {
                isAssignableFrom = this.pvq.isAssignableFrom(aVar.eyW());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.pvi, this.pvj, gson, aVar, this);
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
