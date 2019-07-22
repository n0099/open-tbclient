package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class aa implements l {
    private final e kfN;
    private final e kfO;
    private final f kfP;
    private final int kfQ;

    public aa(e eVar, e eVar2, f fVar, int i) {
        this.kfN = eVar;
        this.kfO = eVar2;
        this.kfP = fVar;
        this.kfQ = i;
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: bolts.g<TContinuationResult>, bolts.g<com.facebook.imagepipeline.f.d> */
    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<com.facebook.imagepipeline.f.d, bolts.g<com.facebook.imagepipeline.f.d>>, bolts.f<com.facebook.imagepipeline.f.d, bolts.g<TContinuationResult>> */
    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, final AtomicBoolean atomicBoolean) {
        e eVar;
        final e eVar2;
        final com.facebook.cache.common.b c = this.kfP.c(imageRequest, obj);
        boolean i = this.kfO.i(c);
        boolean i2 = this.kfN.i(c);
        if (i || !i2) {
            eVar = this.kfO;
            eVar2 = this.kfN;
        } else {
            eVar = this.kfN;
            eVar2 = this.kfO;
        }
        return eVar.a(c, atomicBoolean).b(new bolts.f<com.facebook.imagepipeline.f.d, bolts.g<com.facebook.imagepipeline.f.d>>() { // from class: com.facebook.imagepipeline.c.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<com.facebook.imagepipeline.f.d> a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                if (aa.c(gVar)) {
                    return gVar;
                }
                return (gVar.bi() || gVar.getResult() == null) ? eVar2.a(c, atomicBoolean) : gVar;
            }
        });
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.kfP.c(imageRequest, obj);
        switch (a(imageRequest, dVar)) {
            case DEFAULT:
                this.kfN.a(c, dVar);
                return;
            case SMALL:
                this.kfO.a(c, dVar);
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        int size = dVar.getSize();
        return (size < 0 || size >= this.kfQ) ? ImageRequest.CacheChoice.DEFAULT : ImageRequest.CacheChoice.SMALL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.bi() && (gVar.bj() instanceof CancellationException));
    }
}
