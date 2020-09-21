package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.e;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes23.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;

    public CollectionTypeAdapterFactory(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> ebP = aVar.ebP();
        if (!Collection.class.isAssignableFrom(ebP)) {
            return null;
        }
        Type a = C$Gson$Types.a(type, (Class<?>) ebP);
        return new Adapter(gson, a, gson.getAdapter(com.google.gson.b.a.k(a)), this.constructorConstructor.a(aVar));
    }

    /* loaded from: classes23.dex */
    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> nNQ;
        private final e<? extends Collection<E>> nNR;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, e<? extends Collection<E>> eVar) {
            this.nNQ = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.nNR = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ebw() == JsonToken.NULL) {
                aVar.ebB();
                return null;
            }
            Collection<E> construct = this.nNR.construct();
            aVar.ebu();
            while (aVar.hasNext()) {
                construct.add(this.nNQ.read(aVar));
            }
            aVar.endArray();
            return construct;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.ebL();
                return;
            }
            bVar.ebH();
            for (E e : collection) {
                this.nNQ.write(bVar, e);
            }
            bVar.ebI();
        }
    }
}
