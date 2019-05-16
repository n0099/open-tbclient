package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class b implements o {
    private final com.google.gson.internal.b kfj;

    public b(com.google.gson.internal.b bVar) {
        this.kfj = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cJs = aVar.cJs();
        Class<? super T> cJr = aVar.cJr();
        if (!Collection.class.isAssignableFrom(cJr)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cJs, (Class<?>) cJr);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.kfj.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends n<Collection<E>> {
        private final n<E> kgD;
        private final com.google.gson.internal.d<? extends Collection<E>> kgE;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<E> nVar, com.google.gson.internal.d<? extends Collection<E>> dVar2) {
            this.kgD = new l(dVar, nVar, type);
            this.kgE = dVar2;
        }

        public void a(com.google.gson.stream.a aVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                aVar.cJq();
                return;
            }
            aVar.cJm();
            for (E e : collection) {
                this.kgD.a(aVar, e);
            }
            aVar.cJn();
        }
    }
}
