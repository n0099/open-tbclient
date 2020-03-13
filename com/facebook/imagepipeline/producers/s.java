package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lKf;
    private final com.facebook.imagepipeline.c.f lSl;
    private final aj<com.facebook.imagepipeline.g.e> lVm;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lKf = pVar;
        this.lSl = fVar;
        this.lVm = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am drz = akVar.drz();
        drz.fm(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lSl.c(akVar.dry(), akVar.dmg());
        com.facebook.common.references.a<PooledByteBuffer> bn = this.lKf.bn(c);
        try {
            if (bn != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bn);
                drz.a(id, "EncodedMemoryCacheProducer", drz.Pe(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                drz.D(id, "EncodedMemoryCacheProducer", true);
                kVar.aK(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.drA().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                drz.a(id, "EncodedMemoryCacheProducer", drz.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                drz.D(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lKf, c, akVar.dry().dsy());
                drz.a(id, "EncodedMemoryCacheProducer", drz.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lVm.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bn);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lKf;
        private final com.facebook.cache.common.b lVP;
        private final boolean lVQ;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lKf = pVar;
            this.lVP = bVar;
            this.lVQ = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IK(i) || eVar == null || dB(i, 10)) {
                drK().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dqz = eVar.dqz();
            if (dqz != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lVQ) {
                        aVar = this.lKf.a(this.lVP, dqz);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                drK().aK(1.0f);
                                drK().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dqz);
                }
            }
            drK().g(eVar, i);
        }
    }
}
