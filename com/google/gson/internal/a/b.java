package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class b implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;

    public b(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(type, (Class<?>) rawType);
        return new a(gson, a2, gson.getAdapter(com.google.gson.b.a.get(a2)), this.constructorConstructor.a(aVar));
    }

    /* loaded from: classes5.dex */
    private static final class a<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> mKD;
        private final com.google.gson.internal.f<? extends Collection<E>> mKE;

        public a(Gson gson, Type type, TypeAdapter<E> typeAdapter, com.google.gson.internal.f<? extends Collection<E>> fVar) {
            this.mKD = new m(gson, typeAdapter, type);
            this.mKE = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dzL() == JsonToken.NULL) {
                aVar.dzQ();
                return null;
            }
            Collection<E> construct = this.mKE.construct();
            aVar.dzH();
            while (aVar.hasNext()) {
                construct.add(this.mKD.read(aVar));
            }
            aVar.dzI();
            return construct;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.dAa();
                return;
            }
            bVar.dzW();
            for (E e : collection) {
                this.mKD.write(bVar, e);
            }
            bVar.dzX();
        }
    }
}
