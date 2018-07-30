package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class b implements n {
    private final com.google.gson.internal.b hFz;

    public b(com.google.gson.internal.b bVar) {
        this.hFz = bVar;
    }

    @Override // com.google.gson.n
    public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type bKB = aVar.bKB();
        Class<? super T> bKA = aVar.bKA();
        if (!Collection.class.isAssignableFrom(bKA)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(bKB, (Class<?>) bKA);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.hFz.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends m<Collection<E>> {
        private final m<E> hGF;
        private final com.google.gson.internal.d<? extends Collection<E>> hGG;

        @Override // com.google.gson.m
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, m<E> mVar, com.google.gson.internal.d<? extends Collection<E>> dVar2) {
            this.hGF = new j(dVar, mVar, type);
            this.hGG = dVar2;
        }

        public void a(com.google.gson.stream.a aVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                aVar.bKy();
                return;
            }
            aVar.bKu();
            for (E e : collection) {
                this.hGF.a(aVar, e);
            }
            aVar.bKv();
        }
    }
}
