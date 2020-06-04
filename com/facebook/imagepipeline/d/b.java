package com.facebook.imagepipeline.d;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class b implements f {
    private c mwA;

    public b(c cVar) {
        this.mwA = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.duf(), new d.b(bVar.due(), bVar.dud(), bVar.duc()), bVar.duh(), bVar.dug(), bVar.dui(), bVar.getContext(), executor, bVar.duj());
    }

    @Override // com.facebook.imagepipeline.d.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.mwA.b(bVar));
    }
}
