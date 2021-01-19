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
    private final JsonSerializer<T> pJp;
    private final JsonDeserializer<T> pJq;
    private final com.google.gson.b.a<T> pJr;
    private final TypeAdapterFactory pJs;
    private final TreeTypeAdapter<T>.a pJt = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.pJp = jsonSerializer;
        this.pJq = jsonDeserializer;
        this.gson = gson;
        this.pJr = aVar;
        this.pJs = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pJq == null) {
            return eyI().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pJq.deserialize(parse, this.pJr.getType(), this.pJt);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.pJp == null) {
            eyI().write(bVar, t);
        } else if (t == null) {
            bVar.ezq();
        } else {
            h.a(this.pJp.serialize(t, this.pJr.getType(), this.pJt), bVar);
        }
    }

    private TypeAdapter<T> eyI() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pJs, this.pJr);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory a(com.google.gson.b.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.ezu(), null);
    }

    public static TypeAdapterFactory b(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonSerializer<?> pJp;
        private final JsonDeserializer<?> pJq;
        private final com.google.gson.b.a<?> pJv;
        private final boolean pJw;
        private final Class<?> pJx;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.pJp = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pJq = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.pJp == null && this.pJq == null) ? false : true);
            this.pJv = aVar;
            this.pJw = z;
            this.pJx = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.pJv != null) {
                isAssignableFrom = this.pJv.equals(aVar) || (this.pJw && this.pJv.getType() == aVar.ezu());
            } else {
                isAssignableFrom = this.pJx.isAssignableFrom(aVar.ezu());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.pJp, this.pJq, gson, aVar, this);
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
