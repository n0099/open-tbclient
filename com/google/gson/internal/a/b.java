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
    private final com.google.gson.internal.b jNe;

    public b(com.google.gson.internal.b bVar) {
        this.jNe = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBK = aVar.cBK();
        Class<? super T> cBJ = aVar.cBJ();
        if (!Collection.class.isAssignableFrom(cBJ)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cBK, (Class<?>) cBJ);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.jNe.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> jOA;
        private final com.google.gson.internal.e<? extends Collection<E>> jOB;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.jOA = new m(dVar, oVar, type);
            this.jOB = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> cBl = this.jOB.cBl();
            aVar.beginArray();
            while (aVar.hasNext()) {
                cBl.add(this.jOA.b(aVar));
            }
            aVar.endArray();
            return cBl;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.cBI();
                return;
            }
            bVar.cBE();
            for (E e : collection) {
                this.jOA.a(bVar, e);
            }
            bVar.cBF();
        }
    }
}
