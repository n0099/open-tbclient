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
    private final com.google.gson.internal.b jMT;

    public b(com.google.gson.internal.b bVar) {
        this.jMT = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBx = aVar.cBx();
        Class<? super T> cBw = aVar.cBw();
        if (!Collection.class.isAssignableFrom(cBw)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cBx, (Class<?>) cBw);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.jMT.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> jOp;
        private final com.google.gson.internal.e<? extends Collection<E>> jOq;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.jOp = new m(dVar, oVar, type);
            this.jOq = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBk() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> cAY = this.jOq.cAY();
            aVar.beginArray();
            while (aVar.hasNext()) {
                cAY.add(this.jOp.b(aVar));
            }
            aVar.endArray();
            return cAY;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.cBv();
                return;
            }
            bVar.cBr();
            for (E e : collection) {
                this.jOp.a(bVar, e);
            }
            bVar.cBs();
        }
    }
}
