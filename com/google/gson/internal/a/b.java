package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class b implements n {
    private final com.google.gson.internal.b hMC;

    public b(com.google.gson.internal.b bVar) {
        this.hMC = bVar;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bOI = aVar.bOI();
        Class<? super T> bOH = aVar.bOH();
        if (!Collection.class.isAssignableFrom(bOH)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(bOI, (Class<?>) bOH);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.hMC.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends m<Collection<E>> {
        private final m<E> hNH;
        private final com.google.gson.internal.d<? extends Collection<E>> hNI;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<E> mVar, com.google.gson.internal.d<? extends Collection<E>> dVar2) {
            this.hNH = new j(dVar, mVar, type);
            this.hNI = dVar2;
        }

        public void a(com.google.gson.stream.a aVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                aVar.bOF();
                return;
            }
            aVar.bOB();
            for (E e : collection) {
                this.hNH.a(aVar, e);
            }
            aVar.bOC();
        }
    }
}
