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
import d.g.d.b.h;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final JsonSerializer<T> f31267a;

    /* renamed from: b  reason: collision with root package name */
    public final JsonDeserializer<T> f31268b;

    /* renamed from: c  reason: collision with root package name */
    public final Gson f31269c;

    /* renamed from: d  reason: collision with root package name */
    public final d.g.d.c.a<T> f31270d;

    /* renamed from: e  reason: collision with root package name */
    public final TypeAdapterFactory f31271e;

    /* renamed from: f  reason: collision with root package name */
    public final TreeTypeAdapter<T>.b f31272f = new b();

    /* renamed from: g  reason: collision with root package name */
    public TypeAdapter<T> f31273g;

    /* loaded from: classes6.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: e  reason: collision with root package name */
        public final d.g.d.c.a<?> f31274e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f31275f;

        /* renamed from: g  reason: collision with root package name */
        public final Class<?> f31276g;

        /* renamed from: h  reason: collision with root package name */
        public final JsonSerializer<?> f31277h;
        public final JsonDeserializer<?> i;

        public SingleTypeFactory(Object obj, d.g.d.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f31277h = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.i = jsonDeserializer;
            d.g.d.b.a.a((this.f31277h == null && jsonDeserializer == null) ? false : true);
            this.f31274e = aVar;
            this.f31275f = z;
            this.f31276g = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, d.g.d.c.a<T> aVar) {
            boolean isAssignableFrom;
            d.g.d.c.a<?> aVar2 = this.f31274e;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f31275f && this.f31274e.e() == aVar.c());
            } else {
                isAssignableFrom = this.f31276g.isAssignableFrom(aVar.c());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f31277h, this.i, gson, aVar, this);
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
            return (R) TreeTypeAdapter.this.f31269c.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.f31269c.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f31269c.toJsonTree(obj, type);
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, d.g.d.c.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.f31267a = jsonSerializer;
        this.f31268b = jsonDeserializer;
        this.f31269c = gson;
        this.f31270d = aVar;
        this.f31271e = typeAdapterFactory;
    }

    public static TypeAdapterFactory b(d.g.d.c.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.e() == aVar.c(), null);
    }

    public static TypeAdapterFactory c(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    public final TypeAdapter<T> a() {
        TypeAdapter<T> typeAdapter = this.f31273g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.f31269c.getDelegateAdapter(this.f31271e, this.f31270d);
        this.f31273g = delegateAdapter;
        return delegateAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(d.g.d.d.a aVar) throws IOException {
        if (this.f31268b == null) {
            return a().read(aVar);
        }
        JsonElement a2 = h.a(aVar);
        if (a2.isJsonNull()) {
            return null;
        }
        return this.f31268b.deserialize(a2, this.f31270d.e(), this.f31272f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(d.g.d.d.b bVar, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.f31267a;
        if (jsonSerializer == null) {
            a().write(bVar, t);
        } else if (t == null) {
            bVar.B();
        } else {
            h.b(jsonSerializer.serialize(t, this.f31270d.e(), this.f31272f), bVar);
        }
    }
}
