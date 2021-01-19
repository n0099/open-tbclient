package com.facebook.imagepipeline.c;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class b implements f {
    private c pxY;

    public b(c cVar) {
        this.pxY = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.epI(), new d.b(bVar.epH(), bVar.epG(), bVar.epF()), bVar.epK(), bVar.epJ(), bVar.epL(), bVar.getContext(), executor, bVar.epM());
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.pxY.b(bVar));
    }
}
