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
    private final com.google.gson.internal.b ijT;

    public b(com.google.gson.internal.b bVar) {
        this.ijT = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bZr = aVar.bZr();
        Class<? super T> bZq = aVar.bZq();
        if (!Collection.class.isAssignableFrom(bZq)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(bZr, (Class<?>) bZq);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.ijT.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> ilp;
        private final com.google.gson.internal.e<? extends Collection<E>> ilq;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.ilp = new m(dVar, oVar, type);
            this.ilq = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.bZe() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> bYS = this.ilq.bYS();
            aVar.beginArray();
            while (aVar.hasNext()) {
                bYS.add(this.ilp.b(aVar));
            }
            aVar.endArray();
            return bYS;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.bZp();
                return;
            }
            bVar.bZl();
            for (E e : collection) {
                this.ilp.a(bVar, e);
            }
            bVar.bZm();
        }
    }
}
