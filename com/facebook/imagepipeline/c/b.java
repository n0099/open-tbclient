package com.facebook.imagepipeline.c;

import com.facebook.cache.disk.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class b implements f {
    private c pKL;

    public b(c cVar) {
        this.pKL = cVar;
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar) {
        return a(bVar, cVar, Executors.newSingleThreadExecutor());
    }

    public static com.facebook.cache.disk.d a(com.facebook.cache.disk.b bVar, com.facebook.cache.disk.c cVar, Executor executor) {
        return new com.facebook.cache.disk.d(cVar, bVar.ess(), new d.b(bVar.esr(), bVar.esq(), bVar.esp()), bVar.esu(), bVar.est(), bVar.esv(), bVar.getContext(), executor, bVar.esw());
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.disk.h a(com.facebook.cache.disk.b bVar) {
        return a(bVar, this.pKL.b(bVar));
    }
}
