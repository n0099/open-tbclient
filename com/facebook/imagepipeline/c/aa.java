package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class aa implements l {
    private final e ido;
    private final e idp;
    private final f idq;
    private final int idr;

    public aa(e eVar, e eVar2, f fVar, int i) {
        this.ido = eVar;
        this.idp = eVar2;
        this.idq = fVar;
        this.idr = i;
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: bolts.g<TContinuationResult>, bolts.g<com.facebook.imagepipeline.f.d> */
    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: bolts.f<com.facebook.imagepipeline.f.d, bolts.g<com.facebook.imagepipeline.f.d>>, bolts.f<com.facebook.imagepipeline.f.d, bolts.g<TContinuationResult>> */
    @Override // com.facebook.imagepipeline.c.l
    public bolts.g<com.facebook.imagepipeline.f.d> a(ImageRequest imageRequest, Object obj, final AtomicBoolean atomicBoolean) {
        e eVar;
        final e eVar2;
        final com.facebook.cache.common.b c = this.idq.c(imageRequest, obj);
        boolean i = this.idp.i(c);
        boolean i2 = this.ido.i(c);
        if (i || !i2) {
            eVar = this.idp;
            eVar2 = this.ido;
        } else {
            eVar = this.ido;
            eVar2 = this.idp;
        }
        return eVar.a(c, atomicBoolean).b(new bolts.f<com.facebook.imagepipeline.f.d, bolts.g<com.facebook.imagepipeline.f.d>>() { // from class: com.facebook.imagepipeline.c.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: e */
            public bolts.g<com.facebook.imagepipeline.f.d> a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                if (aa.c(gVar)) {
                    return gVar;
                }
                return (gVar.bf() || gVar.getResult() == null) ? eVar2.a(c, atomicBoolean) : gVar;
            }
        });
    }

    @Override // com.facebook.imagepipeline.c.l
    public void a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b c = this.idq.c(imageRequest, obj);
        switch (a(imageRequest, dVar)) {
            case DEFAULT:
                this.ido.a(c, dVar);
                return;
            case SMALL:
                this.idp.a(c, dVar);
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.imagepipeline.c.l
    public ImageRequest.CacheChoice a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        int size = dVar.getSize();
        return (size < 0 || size >= this.idr) ? ImageRequest.CacheChoice.DEFAULT : ImageRequest.CacheChoice.SMALL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.bf() && (gVar.bg() instanceof CancellationException));
    }
}
