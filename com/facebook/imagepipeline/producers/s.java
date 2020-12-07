package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class s implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pdv;
    private final com.facebook.imagepipeline.b.f plv;
    private final aj<com.facebook.imagepipeline.f.e> pox;

    public s(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pdv = pVar;
        this.plv = fVar;
        this.pox = ajVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        String id = akVar.getId();
        am eww = akVar.eww();
        eww.hh(id, "EncodedMemoryCacheProducer");
        com.facebook.cache.common.b c = this.plv.c(akVar.ewv(), akVar.erm());
        com.facebook.common.references.a<PooledByteBuffer> bu = this.pdv.bu(c);
        try {
            if (bu != null) {
                com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(bu);
                eww.a(id, "EncodedMemoryCacheProducer", eww.Zq(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eww.J(id, "EncodedMemoryCacheProducer", true);
                kVar.aV(1.0f);
                kVar.h(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else if (akVar.ewx().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                eww.a(id, "EncodedMemoryCacheProducer", eww.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                eww.J(id, "EncodedMemoryCacheProducer", false);
                kVar.h(null, 1);
            } else {
                a aVar = new a(kVar, this.pdv, c, akVar.ewv().exs());
                eww.a(id, "EncodedMemoryCacheProducer", eww.Zq(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                this.pox.a(aVar, akVar);
            }
        } finally {
            com.facebook.common.references.a.c(bu);
        }
    }

    /* loaded from: classes15.dex */
    private static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pdv;
        private final com.facebook.cache.common.b ppa;
        private final boolean ppb;

        public a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, PooledByteBuffer> pVar, com.facebook.cache.common.b bVar, boolean z) {
            super(kVar);
            this.pdv = pVar;
            this.ppa = bVar;
            this.ppb = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Ri(i) || eVar == null || eg(i, 10)) {
                ewI().h(eVar, i);
                return;
            }
            com.facebook.common.references.a<PooledByteBuffer> evA = eVar.evA();
            if (evA != null) {
                com.facebook.common.references.a<PooledByteBuffer> aVar = null;
                try {
                    if (this.ppb) {
                        aVar = this.pdv.a(this.ppa, evA);
                    }
                    if (aVar != null) {
                        try {
                            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(aVar);
                            eVar2.c(eVar);
                            try {
                                ewI().aV(1.0f);
                                ewI().h(eVar2, i);
                                return;
                            } finally {
                                com.facebook.imagepipeline.f.e.e(eVar2);
                            }
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                } finally {
                    com.facebook.common.references.a.c(evA);
                }
            }
            ewI().h(eVar, i);
        }
    }
}
