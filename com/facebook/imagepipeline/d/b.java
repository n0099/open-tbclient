package com.facebook.imagepipeline.d;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public class b implements f {
    private c lRd;

    public b(c cVar) {
        this.lRd = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.diS(), new d.b(bVar.diR(), bVar.diQ(), bVar.diP()), bVar.diU(), bVar.diT(), bVar.diV(), bVar.getContext(), executor, bVar.diW());
    }

    @Override // com.facebook.imagepipeline.d.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.lRd.b(bVar));
    }
}
