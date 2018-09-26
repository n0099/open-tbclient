package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class b implements n {
    private final com.google.gson.internal.b hNA;

    public b(com.google.gson.internal.b bVar) {
        this.hNA = bVar;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bNj = aVar.bNj();
        Class<? super T> bNi = aVar.bNi();
        if (!Collection.class.isAssignableFrom(bNi)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(bNj, (Class<?>) bNi);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.hNA.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends m<Collection<E>> {
        private final m<E> hOG;
        private final com.google.gson.internal.d<? extends Collection<E>> hOH;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<E> mVar, com.google.gson.internal.d<? extends Collection<E>> dVar2) {
            this.hOG = new j(dVar, mVar, type);
            this.hOH = dVar2;
        }

        public void a(com.google.gson.stream.a aVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                aVar.bNg();
                return;
            }
            aVar.bNc();
            for (E e : collection) {
                this.hOG.a(aVar, e);
            }
            aVar.bNd();
        }
    }
}
