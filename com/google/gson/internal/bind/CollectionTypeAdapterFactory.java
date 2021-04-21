package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import d.h.d.b.b;
import d.h.d.b.e;
import d.h.d.d.a;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: e  reason: collision with root package name */
    public final b f31329e;

    /* loaded from: classes6.dex */
    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        public final TypeAdapter<E> f31330a;

        /* renamed from: b  reason: collision with root package name */
        public final e<? extends Collection<E>> f31331b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, e<? extends Collection<E>> eVar) {
            this.f31330a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f31331b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Collection<E> read(a aVar) throws IOException {
            if (aVar.M() == JsonToken.NULL) {
                aVar.I();
                return null;
            }
            Collection<E> a2 = this.f31331b.a();
            aVar.n();
            while (aVar.y()) {
                a2.add(this.f31330a.read(aVar));
            }
            aVar.t();
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(d.h.d.d.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.B();
                return;
            }
            bVar.q();
            for (E e2 : collection) {
                this.f31330a.write(bVar, e2);
            }
            bVar.t();
        }
    }

    public CollectionTypeAdapterFactory(b bVar) {
        this.f31329e = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, d.h.d.c.a<T> aVar) {
        Type e2 = aVar.e();
        Class<? super T> c2 = aVar.c();
        if (Collection.class.isAssignableFrom(c2)) {
            Type h2 = C$Gson$Types.h(e2, c2);
            return new Adapter(gson, h2, gson.getAdapter(d.h.d.c.a.b(h2)), this.f31329e.a(aVar));
        }
        return null;
    }
}
