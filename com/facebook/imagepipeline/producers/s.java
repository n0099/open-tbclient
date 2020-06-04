package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mol;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final aj<com.facebook.imagepipeline.g.e> mzI;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mol = pVar;
        this.mwJ = fVar;
        this.mzI = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dBx = akVar.dBx();
        dBx.fK(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.mwJ.c(akVar.dBw(), akVar.dwa());
        com.facebook.common.references.a<PooledByteBuffer> bi = this.mol.bi(c);
        try {
            if (bi != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bi);
                dBx.a(id, "EncodedMemoryCacheProducer", dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dBx.F(id, "EncodedMemoryCacheProducer", true);
                kVar.at(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dBy().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dBx.a(id, "EncodedMemoryCacheProducer", dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dBx.F(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.mol, c, akVar.dBw().dCv());
                dBx.a(id, "EncodedMemoryCacheProducer", dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.mzI.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bi);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.cache.common.b mAl;
        private final boolean mAm;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mol;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.mol = pVar;
            this.mAl = bVar;
            this.mAm = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Ig(i) || eVar == null || dr(i, 10)) {
                dBI().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dAy = eVar.dAy();
            if (dAy != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.mAm) {
                        aVar = this.mol.a(this.mAl, dAy);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dBI().at(1.0f);
                                dBI().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dAy);
                }
            }
            dBI().h(eVar, i);
        }
    }
}
