package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mnb;
    private final com.facebook.imagepipeline.c.f mvz;
    private final aj<com.facebook.imagepipeline.g.e> myy;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mnb = pVar;
        this.mvz = fVar;
        this.myy = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dBj = akVar.dBj();
        dBj.fK(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.mvz.c(akVar.dBi(), akVar.dvM());
        com.facebook.common.references.a<PooledByteBuffer> bi = this.mnb.bi(c);
        try {
            if (bi != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bi);
                dBj.a(id, "EncodedMemoryCacheProducer", dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dBj.F(id, "EncodedMemoryCacheProducer", true);
                kVar.at(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dBk().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dBj.a(id, "EncodedMemoryCacheProducer", dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dBj.F(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.mnb, c, akVar.dBi().dCh());
                dBj.a(id, "EncodedMemoryCacheProducer", dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.myy.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bi);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mnb;
        private final com.facebook.cache.common.b mzb;
        private final boolean mzc;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.mnb = pVar;
            this.mzb = bVar;
            this.mzc = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Ie(i) || eVar == null || dr(i, 10)) {
                dBu().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dAk = eVar.dAk();
            if (dAk != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.mzc) {
                        aVar = this.mnb.a(this.mzb, dAk);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dBu().at(1.0f);
                                dBu().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dAk);
                }
            }
            dBu().h(eVar, i);
        }
    }
}
