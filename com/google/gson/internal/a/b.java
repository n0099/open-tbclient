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
    private final com.google.gson.internal.b ixh;

    public b(com.google.gson.internal.b bVar) {
        this.ixh = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type ccs = aVar.ccs();
        Class<? super T> ccr = aVar.ccr();
        if (!Collection.class.isAssignableFrom(ccr)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(ccs, (Class<?>) ccr);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.ixh.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> iyD;
        private final com.google.gson.internal.e<? extends Collection<E>> iyE;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.iyD = new m(dVar, oVar, type);
            this.iyE = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.ccf() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> cbT = this.iyE.cbT();
            aVar.beginArray();
            while (aVar.hasNext()) {
                cbT.add(this.iyD.b(aVar));
            }
            aVar.endArray();
            return cbT;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.ccq();
                return;
            }
            bVar.ccm();
            for (E e : collection) {
                this.iyD.a(bVar, e);
            }
            bVar.ccn();
        }
    }
}
