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
    private final JsonSerializer<T> pvg;
    private final JsonDeserializer<T> pvh;
    private final com.google.gson.b.a<T> pvi;
    private final TypeAdapterFactory pvj;
    private final TreeTypeAdapter<T>.a pvk = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.pvg = jsonSerializer;
        this.pvh = jsonDeserializer;
        this.gson = gson;
        this.pvi = aVar;
        this.pvj = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pvh == null) {
            return eyj().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pvh.deserialize(parse, this.pvi.getType(), this.pvk);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.pvg == null) {
            eyj().write(bVar, t);
        } else if (t == null) {
            bVar.eyR();
        } else {
            h.a(this.pvg.serialize(t, this.pvi.getType(), this.pvk), bVar);
        }
    }

    private TypeAdapter<T> eyj() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pvj, this.pvi);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.eyV(), null);
    }

    public static TypeAdapterFactory a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> pvg;
        private final JsonDeserializer<?> pvh;
        private final com.google.gson.b.a<?> pvm;
        private final boolean pvn;
        private final Class<?> pvo;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.pvg = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pvh = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.pvg == null && this.pvh == null) ? false : true);
            this.pvm = aVar;
            this.pvn = z;
            this.pvo = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.pvm != null) {
                isAssignableFrom = this.pvm.equals(aVar) || (this.pvn && this.pvm.getType() == aVar.eyV());
            } else {
                isAssignableFrom = this.pvo.isAssignableFrom(aVar.eyV());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.pvg, this.pvh, gson, aVar, this);
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
