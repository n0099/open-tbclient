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
    private final com.facebook.imagepipeline.c.e ido;
    private final com.facebook.imagepipeline.c.e idp;
    private final com.facebook.imagepipeline.c.f idq;
    @Nullable
    private com.facebook.imagepipeline.c.q ieH;
    private final com.facebook.imagepipeline.c.r ieW;
    private final ai<com.facebook.imagepipeline.f.d> igJ;
    private final com.facebook.imagepipeline.c.l ihg;

    public ac(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.c.r rVar, @Nullable com.facebook.imagepipeline.c.q qVar, com.facebook.imagepipeline.c.l lVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ido = eVar;
        this.idp = eVar2;
        this.idq = fVar;
        this.ieW = rVar;
        this.ieH = qVar;
        this.ihg = lVar;
        this.igJ = aiVar;
    }

    /* JADX DEBUG: Type inference failed for r9v0. Raw type applied. Possible types: bolts.f<com.facebook.imagepipeline.request.a, java.lang.Object>, bolts.f<com.facebook.imagepipeline.request.a, TContinuationResult> */
    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar) {
        final String mediaId;
        String str;
        final ImageRequest bXq = ajVar.bXq();
        final com.facebook.imagepipeline.common.c bYg = bXq.bYg();
        com.facebook.imagepipeline.request.a bYf = bXq.bYf();
        if (!bXq.bYl() || bYg == null || bYg.height <= 0 || bYg.width <= 0) {
            e(jVar, ajVar);
            return;
        }
        if (bYf == null) {
            if (this.ieH == null) {
                mediaId = null;
                str = null;
            } else {
                mediaId = this.ieH.v(bXq.bYd());
                str = "id_extractor";
            }
        } else {
            mediaId = bYf.getMediaId();
            str = "index_db";
        }
        if (bYf == null && mediaId == null) {
            e(jVar, ajVar);
            return;
        }
        ajVar.bXr().cX(ajVar.getId(), "MediaVariationsFallbackProducer");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (bYf != null && bYf.bYs() > 0) {
            a(jVar, ajVar, bXq, bYf, bYg, atomicBoolean);
        } else {
            this.ieW.a(mediaId, com.facebook.imagepipeline.request.a.yI(mediaId).oK(bYf != null && bYf.bYt()).yJ(str)).a(new bolts.f<com.facebook.imagepipeline.request.a, Object>() { // from class: com.facebook.imagepipeline.producers.ac.1
                @Override // bolts.f
                public Object a(bolts.g<com.facebook.imagepipeline.request.a> gVar) throws Exception {
                    bolts.g a2;
                    if (!gVar.isCancelled() && !gVar.bf()) {
                        try {
                            if (gVar.getResult() == null) {
                                ac.this.a(jVar, ajVar, mediaId);
                                a2 = null;
                            } else {
                                a2 = ac.this.a(jVar, ajVar, bXq, gVar.getResult(), bYg, atomicBoolean);
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
        if (aVar.bYs() == 0) {
            return bolts.g.f((com.facebook.imagepipeline.f.d) null).a(b(jVar, ajVar, imageRequest, aVar, Collections.emptyList(), 0, atomicBoolean));
        }
        return a(jVar, ajVar, imageRequest, aVar, aVar.a(new b(cVar)), 0, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bolts.g a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, ImageRequest imageRequest, com.facebook.imagepipeline.request.a aVar, List<a.b> list, int i, AtomicBoolean atomicBoolean) {
        ImageRequest.CacheChoice bYc;
        a.b bVar = list.get(i);
        com.facebook.cache.common.b a2 = this.idq.a(imageRequest, bVar.getUri(), ajVar.bST());
        if (bVar.bYc() == null) {
            bYc = imageRequest.bYc();
        } else {
            bYc = bVar.bYc();
        }
        return (bYc == ImageRequest.CacheChoice.SMALL ? this.idp : this.ido).a(a2, atomicBoolean).a(b(jVar, ajVar, imageRequest, aVar, list, i, atomicBoolean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(a.b bVar, com.facebook.imagepipeline.common.c cVar) {
        return bVar.getWidth() >= cVar.width && bVar.getHeight() >= cVar.height;
    }

    private bolts.f<com.facebook.imagepipeline.f.d, Void> b(final j<com.facebook.imagepipeline.f.d> jVar, final aj ajVar, final ImageRequest imageRequest, final com.facebook.imagepipeline.request.a aVar, final List<a.b> list, final int i, final AtomicBoolean atomicBoolean) {
        final String id = ajVar.getId();
        final al bXr = ajVar.bXr();
        return new bolts.f<com.facebook.imagepipeline.f.d, Void>() { // from class: com.facebook.imagepipeline.producers.ac.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.d> gVar) throws Exception {
                boolean z = true;
                if (ac.c(gVar)) {
                    bXr.b(id, "MediaVariationsFallbackProducer", null);
                    jVar.bRy();
                    z = false;
                } else if (gVar.bf()) {
                    bXr.a(id, "MediaVariationsFallbackProducer", gVar.bg(), null);
                    ac.this.a(jVar, ajVar, aVar.getMediaId());
                } else {
                    com.facebook.imagepipeline.f.d result = gVar.getResult();
                    if (result != null) {
                        boolean z2 = !aVar.bYt() && ac.a((a.b) list.get(i), imageRequest.bYg());
                        bXr.a(id, "MediaVariationsFallbackProducer", ac.a(bXr, id, true, list.size(), aVar.getSource(), z2));
                        if (z2) {
                            jVar.ax(1.0f);
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
                        bXr.a(id, "MediaVariationsFallbackProducer", ac.a(bXr, id, false, list.size(), aVar.getSource(), false));
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
        this.igJ.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, String str) {
        this.igJ.a(new a(jVar, ajVar, str), ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.bf() && (gVar.bg() instanceof CancellationException));
    }

    static Map<String, String> a(al alVar, String str, boolean z, int i, String str2, boolean z2) {
        if (!alVar.yD(str)) {
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
            public void bXx() {
                atomicBoolean.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj igU;
        private final String mMediaId;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, String str) {
            super(jVar);
            this.igU = ajVar;
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
            bXD().e(dVar, z);
        }

        private void j(com.facebook.imagepipeline.f.d dVar) {
            ImageRequest bXq = this.igU.bXq();
            if (bXq.bYl() && this.mMediaId != null) {
                ac.this.ieW.a(this.mMediaId, ac.this.ihg.a(bXq, dVar), ac.this.idq.c(bXq, this.igU.bST()), dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements Comparator<a.b> {
        private final com.facebook.imagepipeline.common.c icp;

        b(com.facebook.imagepipeline.common.c cVar) {
            this.icp = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a.b bVar, a.b bVar2) {
            boolean a = ac.a(bVar, this.icp);
            boolean a2 = ac.a(bVar2, this.icp);
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
