package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ac implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.e ifa;
    private final com.facebook.imagepipeline.c.e ifb;
    private final com.facebook.imagepipeline.c.f ifc;
    private final com.facebook.imagepipeline.c.r igG;
    @Nullable
    private com.facebook.imagepipeline.c.q igr;
    private final com.facebook.imagepipeline.c.l iiQ;
    private final ai<com.facebook.imagepipeline.f.d> iit;

    public ac(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.c.r rVar, @Nullable com.facebook.imagepipeline.c.q qVar, com.facebook.imagepipeline.c.l lVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ifa = eVar;
        this.ifb = eVar2;
        this.ifc = fVar;
        this.igG = rVar;
        this.igr = qVar;
        this.iiQ = lVar;
        this.iit = aiVar;
    }

    /* JADX DEBUG: Type inference failed for r9v0. Raw type applied. Possible types: bolts.f<com.facebook.imagepipeline.request.a, java.lang.Object>, bolts.f<com.facebook.imagepipeline.request.a, TContinuationResult> */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar) {
        final String mediaId;
        String str;
        final ImageRequest bWL = ajVar.bWL();
        final com.facebook.imagepipeline.common.c bXB = bWL.bXB();
        com.facebook.imagepipeline.request.a bXA = bWL.bXA();
        if (!bWL.bXG() || bXB == null || bXB.height <= 0 || bXB.width <= 0) {
            e(jVar, ajVar);
            return;
        }
        if (bXA == null) {
            if (this.igr == null) {
                mediaId = null;
                str = null;
            } else {
                mediaId = this.igr.v(bWL.bXy());
                str = "id_extractor";
            }
        } else {
            mediaId = bXA.getMediaId();
            str = "index_db";
        }
        if (bXA == null && mediaId == null) {
            e(jVar, ajVar);
            return;
        }
        ajVar.bWM().cW(ajVar.getId(), "MediaVariationsFallbackProducer");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (bXA != null && bXA.bXN() > 0) {
            a(jVar, ajVar, bWL, bXA, bXB, atomicBoolean);
        } else {
            this.igG.a(mediaId, com.facebook.imagepipeline.request.a.yN(mediaId).oY(bXA != null && bXA.bXO()).yO(str)).a(new bolts.f<com.facebook.imagepipeline.request.a, Object>() { // from class: com.facebook.imagepipeline.producers.ac.1
                @Override // bolts.f
                public Object a(bolts.g<com.facebook.imagepipeline.request.a> gVar) throws Exception {
                    bolts.g a2;
                    if (!gVar.isCancelled() && !gVar.bf()) {
                        try {
                            if (gVar.getResult() == null) {
                                ac.this.a(jVar, ajVar, mediaId);
                                a2 = null;
                            } else {
                                a2 = ac.this.a(jVar, ajVar, bWL, gVar.getResult(), bXB, atomicBoolean);
                            }
                            return a2;
                        } catch (Exception e) {
                            return null;
                        }
                    }
                    return gVar;
                }
            });
        }
        a(atomicBoolean, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bolts.g a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, ImageRequest imageRequest, com.facebook.imagepipeline.request.a aVar, com.facebook.imagepipeline.common.c cVar, AtomicBoolean atomicBoolean) {
        if (aVar.bXN() == 0) {
            return bolts.g.f((com.facebook.imagepipeline.f.d) null).a(b(jVar, ajVar, imageRequest, aVar, Collections.emptyList(), 0, atomicBoolean));
        }
        return a(jVar, ajVar, imageRequest, aVar, aVar.a(new b(cVar)), 0, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bolts.g a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, ImageRequest imageRequest, com.facebook.imagepipeline.request.a aVar, List<a.b> list, int i, AtomicBoolean atomicBoolean) {
        ImageRequest.CacheChoice bXx;
        a.b bVar = list.get(i);
        com.facebook.cache.common.b a2 = this.ifc.a(imageRequest, bVar.getUri(), ajVar.bSo());
        if (bVar.bXx() == null) {
            bXx = imageRequest.bXx();
        } else {
            bXx = bVar.bXx();
        }
        return (bXx == ImageRequest.CacheChoice.SMALL ? this.ifb : this.ifa).a(a2, atomicBoolean).a(b(jVar, ajVar, imageRequest, aVar, list, i, atomicBoolean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(a.b bVar, com.facebook.imagepipeline.common.c cVar) {
        return bVar.getWidth() >= cVar.width && bVar.getHeight() >= cVar.height;
    }

    private bolts.f<com.facebook.imagepipeline.f.d, Void> b(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar, final ImageRequest imageRequest, final com.facebook.imagepipeline.request.a aVar, final List<a.b> list, final int i, final AtomicBoolean atomicBoolean) {
        final String id = ajVar.getId();
        final al bWM = ajVar.bWM();
        return new bolts.f<com.facebook.imagepipeline.f.d, Void>() { // from class: com.facebook.imagepipeline.producers.ac.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                boolean z = true;
                if (ac.c(gVar)) {
                    bWM.b(id, "MediaVariationsFallbackProducer", null);
                    jVar.bQT();
                    z = false;
                } else if (gVar.bf()) {
                    bWM.a(id, "MediaVariationsFallbackProducer", gVar.bg(), null);
                    ac.this.a(jVar, ajVar, aVar.getMediaId());
                } else {
                    com.facebook.imagepipeline.f.d result = gVar.getResult();
                    if (result != null) {
                        boolean z2 = !aVar.bXO() && ac.a((a.b) list.get(i), imageRequest.bXB());
                        bWM.a(id, "MediaVariationsFallbackProducer", ac.a(bWM, id, true, list.size(), aVar.getSource(), z2));
                        if (z2) {
                            jVar.az(1.0f);
                        }
                        jVar.e(result, z2);
                        result.close();
                        if (z2) {
                            z = false;
                        }
                    } else if (i < list.size() - 1) {
                        ac.this.a(jVar, ajVar, imageRequest, aVar, list, i + 1, atomicBoolean);
                        z = false;
                    } else {
                        bWM.a(id, "MediaVariationsFallbackProducer", ac.a(bWM, id, false, list.size(), aVar.getSource(), false));
                    }
                }
                if (z) {
                    ac.this.a(jVar, ajVar, aVar.getMediaId());
                }
                return null;
            }
        };
    }

    private void e(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.iit.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, String str) {
        this.iit.a(new a(jVar, ajVar, str), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.bf() && (gVar.bg() instanceof CancellationException));
    }

    static Map<String, String> a(al alVar, String str, boolean z, int i, String str2, boolean z2) {
        if (!alVar.yI(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(true), "cached_value_used_as_last", String.valueOf(z2), "variants_count", String.valueOf(i), "variants_source", str2);
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(false), "variants_count", String.valueOf(i), "variants_source", str2);
    }

    private void a(final AtomicBoolean atomicBoolean, aj ajVar) {
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ac.3
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void bWS() {
                atomicBoolean.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj iiE;
        private final String mMediaId;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, String str) {
            super(jVar);
            this.iiE = ajVar;
            this.mMediaId = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (z && dVar != null) {
                j(dVar);
            }
            bWY().e(dVar, z);
        }

        private void j(com.facebook.imagepipeline.f.d dVar) {
            ImageRequest bWL = this.iiE.bWL();
            if (bWL.bXG() && this.mMediaId != null) {
                ac.this.igG.a(this.mMediaId, ac.this.iiQ.a(bWL, dVar), ac.this.ifc.c(bWL, this.iiE.bSo()), dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements Comparator<a.b> {
        private final com.facebook.imagepipeline.common.c iec;

        b(com.facebook.imagepipeline.common.c cVar) {
            this.iec = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a.b bVar, a.b bVar2) {
            boolean a = ac.a(bVar, this.iec);
            boolean a2 = ac.a(bVar2, this.iec);
            if (a && a2) {
                return bVar.getWidth() - bVar2.getWidth();
            }
            if (a) {
                return -1;
            }
            if (a2) {
                return 1;
            }
            return bVar2.getWidth() - bVar.getWidth();
        }
    }
}
