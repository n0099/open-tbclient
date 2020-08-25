package com.facebook.imagepipeline.d;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class b implements f {
    private c nuB;

    public b(c cVar) {
        this.nuB = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.dNZ(), new d.b(bVar.dNY(), bVar.dNX(), bVar.dNW()), bVar.dOb(), bVar.dOa(), bVar.dOc(), bVar.getContext(), executor, bVar.dOd());
    }

    @Override // com.facebook.imagepipeline.d.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.nuB.b(bVar));
    }
}
