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
/* loaded from: classes5.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;

    public CollectionTypeAdapterFactory(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> eBM = aVar.eBM();
        if (!Collection.class.isAssignableFrom(eBM)) {
            return null;
        }
        Type c = C$Gson$Types.c(type, eBM);
        return new Adapter(gson, c, gson.getAdapter(com.google.gson.b.a.r(c)), this.constructorConstructor.a(aVar));
    }

    /* loaded from: classes5.dex */
    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> pST;
        private final e<? extends Collection<E>> pSU;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, e<? extends Collection<E>> eVar) {
            this.pST = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.pSU = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.eBp() == JsonToken.NULL) {
                aVar.eBv();
                return null;
            }
            Collection<E> eAW = this.pSU.eAW();
            aVar.eBn();
            while (aVar.hasNext()) {
                eAW.add(this.pST.read(aVar));
            }
            aVar.endArray();
            return eAW;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.eBI();
                return;
            }
            bVar.eBE();
            for (E e : collection) {
                this.pST.write(bVar, e);
            }
            bVar.eBF();
        }
    }
}
