package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKo;
    private final com.facebook.imagepipeline.c.f mSN;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mVS;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mKo = pVar;
        this.mSN = fVar;
        this.mVS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dGd = akVar.dGd();
        String id = akVar.getId();
        dGd.fU(id, dGm());
        com.facebook.cache.common.b a = this.mSN.a(akVar.dGc(), akVar.dAH());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mKo.bj(a);
        if (bj != null) {
            boolean dFm = bj.get().dEY().dFm();
            if (dFm) {
                dGd.a(id, dGm(), dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dGd.G(id, dGm(), true);
                kVar.ay(1.0f);
            }
            kVar.h(bj, b.wH(dFm));
            bj.close();
            if (dFm) {
                return;
            }
        }
        if (akVar.dGe().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dGd.a(id, dGm(), dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dGd.G(id, dGm(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dGc().dHb());
        dGd.a(id, dGm(), dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.mVS.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj;
                boolean Jm = Jm(i);
                if (aVar == null) {
                    if (Jm) {
                        dGo().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dz(i, 8)) {
                    dGo().h(aVar, i);
                } else {
                    if (!Jm && (bj = h.this.mKo.bj(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dEY = aVar.get().dEY();
                            com.facebook.imagepipeline.g.h dEY2 = bj.get().dEY();
                            if (dEY2.dFm() || dEY2.dFk() >= dEY.dFk()) {
                                dGo().h(bj, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bj);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.mKo.a(bVar, aVar) : null;
                    if (Jm) {
                        try {
                            dGo().ay(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dGo = dGo();
                    if (a != null) {
                        aVar = a;
                    }
                    dGo.h(aVar, i);
                }
            }
        };
    }

    protected String dGm() {
        return "BitmapMemoryCacheProducer";
    }
}
