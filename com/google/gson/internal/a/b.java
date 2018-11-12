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
    private final com.google.gson.internal.b ilE;

    public b(com.google.gson.internal.b bVar) {
        this.ilE = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bYO = aVar.bYO();
        Class<? super T> bYN = aVar.bYN();
        if (!Collection.class.isAssignableFrom(bYN)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(bYO, (Class<?>) bYN);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.ilE.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> inb;
        private final com.google.gson.internal.e<? extends Collection<E>> inc;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.inb = new m(dVar, oVar, type);
            this.inc = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.bYB() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> bYp = this.inc.bYp();
            aVar.beginArray();
            while (aVar.hasNext()) {
                bYp.add(this.inb.b(aVar));
            }
            aVar.endArray();
            return bYp;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.bYM();
                return;
            }
            bVar.bYI();
            for (E e : collection) {
                this.inb.a(bVar, e);
            }
            bVar.bYJ();
        }
    }
}
