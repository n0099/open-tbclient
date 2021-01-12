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
    private final JsonSerializer<T> pJo;
    private final JsonDeserializer<T> pJp;
    private final com.google.gson.b.a<T> pJq;
    private final TypeAdapterFactory pJr;
    private final TreeTypeAdapter<T>.a pJs = new a();

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, com.google.gson.b.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.pJo = jsonSerializer;
        this.pJp = jsonDeserializer;
        this.gson = gson;
        this.pJq = aVar;
        this.pJr = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.pJp == null) {
            return eyI().read(aVar);
        }
        JsonElement parse = h.parse(aVar);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.pJp.deserialize(parse, this.pJq.getType(), this.pJs);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        if (this.pJo == null) {
            eyI().write(bVar, t);
        } else if (t == null) {
            bVar.ezq();
        } else {
            h.a(this.pJo.serialize(t, this.pJq.getType(), this.pJs), bVar);
        }
    }

    private TypeAdapter<T> eyI() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.pJr, this.pJq);
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
        private final JsonSerializer<?> pJo;
        private final JsonDeserializer<?> pJp;
        private final com.google.gson.b.a<?> pJu;
        private final boolean pJv;
        private final Class<?> pJw;

        SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z, Class<?> cls) {
            this.pJo = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.pJp = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            com.google.gson.internal.a.checkArgument((this.pJo == null && this.pJp == null) ? false : true);
            this.pJu = aVar;
            this.pJv = z;
            this.pJw = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.pJu != null) {
                isAssignableFrom = this.pJu.equals(aVar) || (this.pJv && this.pJu.getType() == aVar.ezu());
            } else {
                isAssignableFrom = this.pJw.isAssignableFrom(aVar.ezu());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.pJo, this.pJp, gson, aVar, this);
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
