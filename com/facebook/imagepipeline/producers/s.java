package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mKl;
    private final com.facebook.imagepipeline.c.f mSK;
    private final aj<com.facebook.imagepipeline.g.e> mVP;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mKl = pVar;
        this.mSK = fVar;
        this.mVP = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dFZ = akVar.dFZ();
        dFZ.fU(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.mSK.c(akVar.dFY(), akVar.dAD());
        com.facebook.common.references.a<PooledByteBuffer> bj = this.mKl.bj(c);
        try {
            if (bj != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bj);
                dFZ.a(id, "EncodedMemoryCacheProducer", dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dFZ.G(id, "EncodedMemoryCacheProducer", true);
                kVar.ay(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dGa().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dFZ.a(id, "EncodedMemoryCacheProducer", dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dFZ.G(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.mKl, c, akVar.dFY().dGX());
                dFZ.a(id, "EncodedMemoryCacheProducer", dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.mVP.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bj);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mKl;
        private final com.facebook.cache.common.b mWs;
        private final boolean mWt;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.mKl = pVar;
            this.mWs = bVar;
            this.mWt = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Jn(i) || eVar == null || dA(i, 10)) {
                dGk().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dFa = eVar.dFa();
            if (dFa != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.mWt) {
                        aVar = this.mKl.a(this.mWs, dFa);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dGk().ay(1.0f);
                                dGk().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dFa);
                }
            }
            dGk().h(eVar, i);
        }
    }
}
