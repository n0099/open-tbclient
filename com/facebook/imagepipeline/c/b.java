package com.facebook.imagepipeline.c;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class b implements f {
    private c pAR;

    public b(c cVar) {
        this.pAR = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.ety(), new d.b(bVar.etx(), bVar.etw(), bVar.etv()), bVar.etA(), bVar.etz(), bVar.etB(), bVar.getContext(), executor, bVar.etC());
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.pAR.b(bVar));
    }
}
