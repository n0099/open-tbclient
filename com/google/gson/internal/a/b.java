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
    private final com.google.gson.internal.b iwa;

    public b(com.google.gson.internal.b bVar) {
        this.iwa = bVar;
    }

    @Override // com.google.gson.p
    public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cbK = aVar.cbK();
        Class<? super T> cbJ = aVar.cbJ();
        if (!Collection.class.isAssignableFrom(cbJ)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cbK, (Class<?>) cbJ);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.iwa.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends o<Collection<E>> {
        private final o<E> ixw;
        private final com.google.gson.internal.e<? extends Collection<E>> ixx;

        @Override // com.google.gson.o
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, o<E> oVar, com.google.gson.internal.e<? extends Collection<E>> eVar) {
            this.ixw = new m(dVar, oVar, type);
            this.ixx = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.gson.o
        /* renamed from: i */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.cbx() == JsonToken.NULL) {
                aVar.nextNull();
                return null;
            }
            Collection<E> cbl = this.ixx.cbl();
            aVar.beginArray();
            while (aVar.hasNext()) {
                cbl.add(this.ixw.b(aVar));
            }
            aVar.endArray();
            return cbl;
        }

        public void a(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.cbI();
                return;
            }
            bVar.cbE();
            for (E e : collection) {
                this.ixw.a(bVar, e);
            }
            bVar.cbF();
        }
    }
}
