package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class n implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> ipF;
    private final com.facebook.imagepipeline.c.l iqc;

    public n(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.ipF = aiVar;
        this.iqc = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ImageRequest bYR = ajVar.bYR();
        if (!bYR.bZM()) {
            c(jVar, ajVar);
            return;
        }
        ajVar.bYS().db(ajVar.getId(), "DiskCacheProducer");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.iqc.a(bYR, ajVar.bUu(), atomicBoolean).a(b(jVar, ajVar));
        a(atomicBoolean, ajVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.d, Void> b(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar) {
        final String id = ajVar.getId();
        final al bYS = ajVar.bYS();
        return new bolts.f<com.facebook.imagepipeline.f.d, Void>() { // from class: com.facebook.imagepipeline.producers.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                if (n.c(gVar)) {
                    bYS.b(id, "DiskCacheProducer", null);
                    jVar.bSZ();
                } else if (gVar.bf()) {
                    bYS.a(id, "DiskCacheProducer", gVar.bg(), null);
                    n.this.ipF.a(jVar, ajVar);
                } else {
                    com.facebook.imagepipeline.f.d result = gVar.getResult();
                    if (result != null) {
                        bYS.a(id, "DiskCacheProducer", n.a(bYS, id, true, result.getSize()));
                        jVar.az(1.0f);
                        jVar.e(result, true);
                        result.close();
                    } else {
                        bYS.a(id, "DiskCacheProducer", n.a(bYS, id, false, 0));
                        n.this.ipF.a(jVar, ajVar);
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
        if (ajVar.bYT().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
        } else {
            this.ipF.a(jVar, ajVar);
        }
    }

    static Map<String, String> a(al alVar, String str, boolean z, int i) {
        if (!alVar.zl(str)) {
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
            public void bYY() {
                atomicBoolean.set(true);
            }
        });
    }
}
