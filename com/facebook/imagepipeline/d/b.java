package com.facebook.imagepipeline.d;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class b implements f {
    private c jHa;

    public b(c cVar) {
        this.jHa = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.ctp(), new d.b(bVar.cto(), bVar.ctn(), bVar.ctm()), bVar.ctr(), bVar.ctq(), bVar.cts(), bVar.getContext(), executor, bVar.ctt());
    }

    @Override // com.facebook.imagepipeline.d.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.jHa.b(bVar));
    }
}
