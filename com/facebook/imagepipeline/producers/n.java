package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class n implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.l iiQ;
    private final ai<com.facebook.imagepipeline.f.d> iit;

    public n(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.iit = aiVar;
        this.iiQ = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ImageRequest bWL = ajVar.bWL();
        if (!bWL.bXG()) {
            c(jVar, ajVar);
            return;
        }
        ajVar.bWM().cW(ajVar.getId(), "DiskCacheProducer");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.iiQ.a(bWL, ajVar.bSo(), atomicBoolean).a(b(jVar, ajVar));
        a(atomicBoolean, ajVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.d, Void> b(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar) {
        final String id = ajVar.getId();
        final al bWM = ajVar.bWM();
        return new bolts.f<com.facebook.imagepipeline.f.d, Void>() { // from class: com.facebook.imagepipeline.producers.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                if (n.c(gVar)) {
                    bWM.b(id, "DiskCacheProducer", null);
                    jVar.bQT();
                } else if (gVar.bf()) {
                    bWM.a(id, "DiskCacheProducer", gVar.bg(), null);
                    n.this.iit.a(jVar, ajVar);
                } else {
                    com.facebook.imagepipeline.f.d result = gVar.getResult();
                    if (result != null) {
                        bWM.a(id, "DiskCacheProducer", n.a(bWM, id, true, result.getSize()));
                        jVar.az(1.0f);
                        jVar.e(result, true);
                        result.close();
                    } else {
                        bWM.a(id, "DiskCacheProducer", n.a(bWM, id, false, 0));
                        n.this.iit.a(jVar, ajVar);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.bf() && (gVar.bg() instanceof CancellationException));
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.bWN().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
        } else {
            this.iit.a(jVar, ajVar);
        }
    }

    static Map<String, String> a(al alVar, String str, boolean z, int i) {
        if (!alVar.yI(str)) {
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
            public void bWS() {
                atomicBoolean.set(true);
            }
        });
    }
}
