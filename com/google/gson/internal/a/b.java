package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class b implements p {
    private final com.google.gson.internal.b jMy;

    public b(com.google.gson.internal.b bVar) {
        this.jMy = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBD = aVar.cBD();
        Class<? super T> cBC = aVar.cBC();
        if (!Collection.class.isAssignableFrom(cBC)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cBD, (Class<?>) cBC);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.jMy.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> jNU;
        private final com.google.gson.internal.e<? extends Collection<E>> jNV;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.jNU = new m(dVar, oVar, type);
            this.jNV = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBq() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> cBe = this.jNV.cBe();
            aVar.beginArray();
            while (aVar.hasNext()) {
                cBe.add(this.jNU.b(aVar));
            }
            aVar.endArray();
            return cBe;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.cBB();
                return;
            }
            bVar.cBx();
            for (E e : collection) {
                this.jNU.a(bVar, e);
            }
            bVar.cBy();
        }
    }
}
