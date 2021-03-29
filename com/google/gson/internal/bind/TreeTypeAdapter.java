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
import d.g.c.b.h;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    public final JsonSerializer<T> f30978a;

    /* renamed from: b  reason: collision with root package name */
    public final JsonDeserializer<T> f30979b;

    /* renamed from: c  reason: collision with root package name */
    public final Gson f30980c;

    /* renamed from: d  reason: collision with root package name */
    public final d.g.c.c.a<T> f30981d;

    /* renamed from: e  reason: collision with root package name */
    public final TypeAdapterFactory f30982e;

    /* renamed from: f  reason: collision with root package name */
    public final TreeTypeAdapter<T>.b f30983f = new b();

    /* renamed from: g  reason: collision with root package name */
    public TypeAdapter<T> f30984g;

    /* loaded from: classes6.dex */
    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: e  reason: collision with root package name */
        public final d.g.c.c.a<?> f30985e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f30986f;

        /* renamed from: g  reason: collision with root package name */
        public final Class<?> f30987g;

        /* renamed from: h  reason: collision with root package name */
        public final JsonSerializer<?> f30988h;
        public final JsonDeserializer<?> i;

        public SingleTypeFactory(Object obj, d.g.c.c.a<?> aVar, boolean z, Class<?> cls) {
            this.f30988h = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            JsonDeserializer<?> jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            this.i = jsonDeserializer;
            d.g.c.b.a.a((this.f30988h == null && jsonDeserializer == null) ? false : true);
            this.f30985e = aVar;
            this.f30986f = z;
            this.f30987g = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, d.g.c.c.a<T> aVar) {
            boolean isAssignableFrom;
            d.g.c.c.a<?> aVar2 = this.f30985e;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f30986f && this.f30985e.e() == aVar.c());
            } else {
                isAssignableFrom = this.f30987g.isAssignableFrom(aVar.c());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f30988h, this.i, gson, aVar, this);
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
            return (R) TreeTypeAdapter.this.f30980c.fromJson(jsonElement, type);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return TreeTypeAdapter.this.f30980c.toJsonTree(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return TreeTypeAdapter.this.f30980c.toJsonTree(obj, type);
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, d.g.c.c.a<T> aVar, TypeAdapterFactory typeAdapterFactory) {
        this.f30978a = jsonSerializer;
        this.f30979b = jsonDeserializer;
        this.f30980c = gson;
        this.f30981d = aVar;
        this.f30982e = typeAdapterFactory;
    }

    public static TypeAdapterFactory b(d.g.c.c.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.e() == aVar.c(), null);
    }

    public static TypeAdapterFactory c(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    public final TypeAdapter<T> a() {
        TypeAdapter<T> typeAdapter = this.f30984g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.f30980c.getDelegateAdapter(this.f30982e, this.f30981d);
        this.f30984g = delegateAdapter;
        return delegateAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(d.g.c.d.a aVar) throws IOException {
        if (this.f30979b == null) {
            return a().read(aVar);
        }
        JsonElement a2 = h.a(aVar);
        if (a2.isJsonNull()) {
            return null;
        }
        return this.f30979b.deserialize(a2, this.f30981d.e(), this.f30983f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(d.g.c.d.b bVar, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.f30978a;
        if (jsonSerializer == null) {
            a().write(bVar, t);
        } else if (t == null) {
            bVar.B();
        } else {
            h.b(jsonSerializer.serialize(t, this.f30981d.e(), this.f30983f), bVar);
        }
    }
}
