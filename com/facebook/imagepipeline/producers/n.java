package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class n implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.l kjG;
    private final ai<com.facebook.imagepipeline.f.d> kjj;

    public n(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.kjj = aiVar;
        this.kjG = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ImageRequest cKB = ajVar.cKB();
        if (!cKB.cLw()) {
            c(jVar, ajVar);
            return;
        }
        ajVar.cKC().eA(ajVar.getId(), "DiskCacheProducer");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.kjG.a(cKB, ajVar.cFU(), atomicBoolean).a(b(jVar, ajVar));
        a(atomicBoolean, ajVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.d, Void> b(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar) {
        final String id = ajVar.getId();
        final al cKC = ajVar.cKC();
        return new bolts.f<com.facebook.imagepipeline.f.d, Void>() { // from class: com.facebook.imagepipeline.producers.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                if (n.c(gVar)) {
                    cKC.b(id, "DiskCacheProducer", null);
                    jVar.cEA();
                } else if (gVar.bi()) {
                    cKC.a(id, "DiskCacheProducer", gVar.bj(), null);
                    n.this.kjj.a(jVar, ajVar);
                } else {
                    com.facebook.imagepipeline.f.d result = gVar.getResult();
                    if (result != null) {
                        cKC.a(id, "DiskCacheProducer", n.a(cKC, id, true, result.getSize()));
                        jVar.aR(1.0f);
                        jVar.e(result, true);
                        result.close();
                    } else {
                        cKC.a(id, "DiskCacheProducer", n.a(cKC, id, false, 0));
                        n.this.kjj.a(jVar, ajVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.bi() && (gVar.bj() instanceof CancellationException));
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cKD().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
        } else {
            this.kjj.a(jVar, ajVar);
        }
    }

    static Map<String, String> a(al alVar, String str, boolean z, int i) {
        if (!alVar.HP(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    private void a(final AtomicBoolean atomicBoolean, aj ajVar) {
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.n.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cKI() {
                atomicBoolean.set(true);
            }
        });
    }
}
