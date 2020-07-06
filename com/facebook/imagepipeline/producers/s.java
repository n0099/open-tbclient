package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mKo;
    private final com.facebook.imagepipeline.c.f mSN;
    private final aj<com.facebook.imagepipeline.g.e> mVS;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mKo = pVar;
        this.mSN = fVar;
        this.mVS = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am dGd = akVar.dGd();
        dGd.fU(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.mSN.c(akVar.dGc(), akVar.dAH());
        com.facebook.common.references.a<PooledByteBuffer> bj = this.mKo.bj(c);
        try {
            if (bj != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bj);
                dGd.a(id, "EncodedMemoryCacheProducer", dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dGd.G(id, "EncodedMemoryCacheProducer", true);
                kVar.ay(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.dGe().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                dGd.a(id, "EncodedMemoryCacheProducer", dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                dGd.G(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.mKo, c, akVar.dGc().dHb());
                dGd.a(id, "EncodedMemoryCacheProducer", dGd.QQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.mVS.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bj);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> mKo;
        private final com.facebook.cache.common.b mWv;
        private final boolean mWw;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.mKo = pVar;
            this.mWv = bVar;
            this.mWw = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Jn(i) || eVar == null || dA(i, 10)) {
                dGo().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dFe = eVar.dFe();
            if (dFe != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.mWw) {
                        aVar = this.mKo.a(this.mWv, dFe);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                dGo().ay(1.0f);
                                dGo().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dFe);
                }
            }
            dGo().h(eVar, i);
        }
    }
}
