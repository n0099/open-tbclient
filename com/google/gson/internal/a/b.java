package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes10.dex */
public final class b implements TypeAdapterFactory {
    private final com.google.gson.internal.b constructorConstructor;

    public b(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> dLG = aVar.dLG();
        if (!Collection.class.isAssignableFrom(dLG)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(type, (Class<?>) dLG);
        return new a(gson, a2, gson.getAdapter(com.google.gson.b.a.k(a2)), this.constructorConstructor.a(aVar));
    }

    /* loaded from: classes10.dex */
    private static final class a<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> njJ;
        private final com.google.gson.internal.f<? extends Collection<E>> njK;

        public a(Gson gson, Type type, TypeAdapter<E> typeAdapter, com.google.gson.internal.f<? extends Collection<E>> fVar) {
            this.njJ = new m(gson, typeAdapter, type);
            this.njK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.dLn() == JsonToken.NULL) {
                aVar.dLs();
                return null;
            }
            Collection<E> construct = this.njK.construct();
            aVar.dLl();
            while (aVar.hasNext()) {
                construct.add(this.njJ.read(aVar));
            }
            aVar.endArray();
            return construct;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public void write(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.dLC();
                return;
            }
            bVar.dLy();
            for (E e : collection) {
                this.njJ.write(bVar, e);
            }
            bVar.dLz();
        }
    }
}
