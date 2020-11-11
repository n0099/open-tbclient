package com.facebook.imagepipeline.d;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes18.dex */
public class b implements f {
    private c oUU;

    public b(c cVar) {
        this.oUU = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.ejE(), new d.b(bVar.ejD(), bVar.ejC(), bVar.ejB()), bVar.ejG(), bVar.ejF(), bVar.ejH(), bVar.getContext(), executor, bVar.ejI());
    }

    @Override // com.facebook.imagepipeline.d.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.oUU.b(bVar));
    }
}
