package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class s implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> oDr;
    private final com.facebook.imagepipeline.c.f oLK;
    private final aj<com.facebook.imagepipeline.g.e> oOJ;

    public s(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oDr = pVar;
        this.oLK = fVar;
        this.oOJ = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        String id = akVar.getId();
        am eng = akVar.eng();
        eng.gX(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.oLK.c(akVar.enf(), akVar.ehK());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.oDr.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(bu);
                eng.a(id, "EncodedMemoryCacheProducer", eng.XI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eng.G(id, "EncodedMemoryCacheProducer", true);
                kVar.aL(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else if (akVar.enh().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                eng.a(id, "EncodedMemoryCacheProducer", eng.XI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                eng.G(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.oDr, c, akVar.enf().eoe());
                eng.a(id, "EncodedMemoryCacheProducer", eng.XI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.oOJ.c(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes18.dex */
    private static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> oDr;
        private final com.facebook.cache.common.b oPm;
        private final boolean oPn;

        public a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.oDr = pVar;
            this.oPm = bVar;
            this.oPn = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Po(i) || eVar == null || dX(i, 10)) {
                enr().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> emg = eVar.emg();
            if (emg != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.oPn) {
                        aVar = this.oDr.a(this.oPm, emg);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(aVar);
                            eVar2.c(eVar);
                            try {
                                enr().aL(1.0f);
                                enr().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.g.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(emg);
                }
            }
            enr().h(eVar, i);
        }
    }
}
