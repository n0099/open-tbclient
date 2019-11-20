package com.google.gson.internal.a;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes2.dex */
public final class b implements o {
    private final com.google.gson.internal.b knr;

    public b(com.google.gson.internal.b bVar) {
        this.knr = bVar;
    }

    @Override // com.google.gson.o
    public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
        Type cKD = aVar.cKD();
        Class<? super T> cKC = aVar.cKC();
        if (!Collection.class.isAssignableFrom(cKC)) {
            return null;
        }
        Type a2 = C$Gson$Types.a(cKD, (Class<?>) cKC);
        return new a(dVar, a2, dVar.a(com.google.gson.b.a.l(a2)), this.knr.b(aVar));
    }

    /* loaded from: classes2.dex */
    private static final class a<E> extends n<Collection<E>> {
        private final n<E> koL;
        private final com.google.gson.internal.d<? extends Collection<E>> koM;

        @Override // com.google.gson.n
        public /* bridge */ /* synthetic */ void a(com.google.gson.stream.a aVar, Object obj) throws IOException {
            a(aVar, (Collection) ((Collection) obj));
        }

        public a(com.google.gson.d dVar, Type type, n<E> nVar, com.google.gson.internal.d<? extends Collection<E>> dVar2) {
            this.koL = new l(dVar, nVar, type);
            this.koM = dVar2;
        }

        public void a(com.google.gson.stream.a aVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                aVar.cKB();
                return;
            }
            aVar.cKx();
            for (E e : collection) {
                this.koL.a(aVar, e);
            }
            aVar.cKy();
        }
    }
}
