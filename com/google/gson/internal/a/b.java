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
    private final com.google.gson.internal.b jNm;

    public b(com.google.gson.internal.b bVar) {
        this.jNm = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cBH = aVar.cBH();
        Class<? super T> cBG = aVar.cBG();
        if (!Collection.class.isAssignableFrom(cBG)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cBH, (Class<?>) cBG);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.jNm.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> jOI;
        private final com.google.gson.internal.e<? extends Collection<E>> jOJ;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.jOI = new m(dVar, oVar, type);
            this.jOJ = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cBu() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> cBi = this.jOJ.cBi();
            aVar.beginArray();
            while (aVar.hasNext()) {
                cBi.add(this.jOI.b(aVar));
            }
            aVar.endArray();
            return cBi;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.cBF();
                return;
            }
            bVar.cBB();
            for (E e : collection) {
                this.jOI.a(bVar, e);
            }
            bVar.cBC();
        }
    }
}
