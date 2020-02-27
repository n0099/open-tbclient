package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJS;
    private final com.facebook.imagepipeline.c.f lRY;
    private final aj<com.facebook.imagepipeline.g.e> lUZ;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lJS = pVar;
        this.lRY = fVar;
        this.lUZ = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am drw = akVar.drw();
        drw.fm(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.lRY.c(akVar.drv(), akVar.dmd());
        com.facebook.common.references.a<PooledByteBuffer> bn = this.lJS.bn(c);
        try {
            if (bn != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bn);
                drw.a(id, "EncodedMemoryCacheProducer", drw.Pd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                drw.D(id, "EncodedMemoryCacheProducer", true);
                kVar.aK(1.0f);
                kVar.g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.drx().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                drw.a(id, "EncodedMemoryCacheProducer", drw.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                drw.D(id, "EncodedMemoryCacheProducer", false);
                kVar.g(null, 1);
            } else {
                a aVar = new a(kVar, this.lJS, c, akVar.drv().dsv());
                drw.a(id, "EncodedMemoryCacheProducer", drw.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.lUZ.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bn);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> lJS;
        private final com.facebook.cache.common.b lVC;
        private final boolean lVD;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.lJS = pVar;
            this.lVC = bVar;
            this.lVD = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IK(i) || eVar == null || dB(i, 10)) {
                drH().g(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> dqw = eVar.dqw();
            if (dqw != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.lVD) {
                        aVar = this.lJS.a(this.lVC, dqw);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                drH().aK(1.0f);
                                drH().g(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(dqw);
                }
            }
            drH().g(eVar, i);
        }
    }
}
