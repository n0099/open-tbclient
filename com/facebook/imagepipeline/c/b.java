package com.facebook.imagepipeline.c;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class b implements f {
    private c pIg;

    public b(c cVar) {
        this.pIg = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.esb(), new d.b(bVar.esa(), bVar.erZ(), bVar.erY()), bVar.esd(), bVar.esc(), bVar.ese(), bVar.getContext(), executor, bVar.esf());
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.pIg.b(bVar));
    }
}
