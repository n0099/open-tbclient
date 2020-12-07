package com.facebook.imagepipeline.c;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class b implements f {
    private c plm;

    public b(c cVar) {
        this.plm = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.eps(), new d.b(bVar.epr(), bVar.epq(), bVar.epp()), bVar.epu(), bVar.ept(), bVar.epv(), bVar.getContext(), executor, bVar.epw());
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.plm.b(bVar));
    }
}
