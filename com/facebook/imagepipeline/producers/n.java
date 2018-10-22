package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class n implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> igJ;
    private final com.facebook.imagepipeline.c.l ihg;

    public n(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.igJ = aiVar;
        this.ihg = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ImageRequest bXq = ajVar.bXq();
        if (!bXq.bYl()) {
            c(jVar, ajVar);
            return;
        }
        ajVar.bXr().cX(ajVar.getId(), "DiskCacheProducer");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.ihg.a(bXq, ajVar.bST(), atomicBoolean).a(b(jVar, ajVar));
        a(atomicBoolean, ajVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.d, Void> b(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar) {
        final String id = ajVar.getId();
        final al bXr = ajVar.bXr();
        return new bolts.f<com.facebook.imagepipeline.f.d, Void>() { // from class: com.facebook.imagepipeline.producers.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                if (n.c(gVar)) {
                    bXr.b(id, "DiskCacheProducer", null);
                    jVar.bRy();
                } else if (gVar.bf()) {
                    bXr.a(id, "DiskCacheProducer", gVar.bg(), null);
                    n.this.igJ.a(jVar, ajVar);
                } else {
                    com.facebook.imagepipeline.f.d result = gVar.getResult();
                    if (result != null) {
                        bXr.a(id, "DiskCacheProducer", n.a(bXr, id, true, result.getSize()));
                        jVar.ax(1.0f);
                        jVar.e(result, true);
                        result.close();
                    } else {
                        bXr.a(id, "DiskCacheProducer", n.a(bXr, id, false, 0));
                        n.this.igJ.a(jVar, ajVar);
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
        if (ajVar.bXs().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
        } else {
            this.igJ.a(jVar, ajVar);
        }
    }

    static Map<String, String> a(al alVar, String str, boolean z, int i) {
        if (!alVar.yD(str)) {
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
            public void bXx() {
                atomicBoolean.set(true);
            }
        });
    }
}
