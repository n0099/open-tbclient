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
import d.h.d.b.h;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final JsonSerializer<T> f31362a;

    /* renamed from: b  reason: collision with root package name */
    public final JsonDeserializer<T> f31363b;

    /* renamed from: c  reason: collision with root package name */
    public final Gson f31364c;

    /* renamed from: d  reason: collision with root package name */
    public final d.h.d.c.a<T> f31365d;

    /* renamed from: e  reason: collision with root package name */
    public final TypeAdapterFactory f31366e;

    /* renamed from: f  reason: collision with root package name */
    public final TreeTypeAdapter<T>.b f31367f = new b();

    /* renamed from: g  reason: collision with root package name */
    public TypeAdapter<T> f31368g;

    /* loaded from: classes6.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: e  reason: collision with root package name */
        public final d.h.d.c.a<?> f31369e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f31370f;

        /* renamed from: g  reason: collision with root package name */
        public final Class<?> f31371g;

        /* renamed from: h  reason: collision with root package name */
        public final JsonSerializer<?> f31372h;
        public final JsonDeserializer<?> i;

        public SingleTypeFactory(Object obj, d.h.d.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f31372h = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.i = jsonDeserializer;
            d.h.d.b.a.a((this.f31372h == null && jsonDeserializer == null) ? false : true);
            this.f31369e = aVar;
            this.f31370f = z;
            this.f31371g = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, d.h.d.c.a<T> aVar) {
            boolean isAssignableFrom;
            d.h.d.c.a<?> aVar2 = this.f31369e;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f31370f && this.f31369e.e() == aVar.c());
            } else {
                isAssignableFrom = this.f31371g.isAssignableFrom(aVar.c());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f31372h, this.i, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements JsonSerializationContext, JsonDeserializationContext {
        public b() {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f31364c.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.f31364c.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f31364c.toJsonTree(obj, type);
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, d.h.d.c.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.f31362a = jsonSerializer;
        this.f31363b = jsonDeserializer;
        this.f31364c = gson;
        this.f31365d = aVar;
        this.f31366e = typeAdapterFactory;
    }

    public static TypeAdapterFactory b(d.h.d.c.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.e() == aVar.c(), null);
    }

    public static TypeAdapterFactory c(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    public final TypeAdapter<T> a() {
        TypeAdapter<T> typeAdapter = this.f31368g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.f31364c.getDelegateAdapter(this.f31366e, this.f31365d);
        this.f31368g = delegateAdapter;
        return delegateAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(d.h.d.d.a aVar) throws IOException {
        if (this.f31363b == null) {
            return a().read(aVar);
        }
        JsonElement a2 = h.a(aVar);
        if (a2.isJsonNull()) {
            return null;
        }
        return this.f31363b.deserialize(a2, this.f31365d.e(), this.f31367f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(d.h.d.d.b bVar, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.f31362a;
        if (jsonSerializer == null) {
            a().write(bVar, t);
        } else if (t == null) {
            bVar.B();
        } else {
            h.b(jsonSerializer.serialize(t, this.f31365d.e(), this.f31367f), bVar);
        }
    }
}
