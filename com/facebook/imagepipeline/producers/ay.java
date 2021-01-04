package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final aj<com.facebook.imagepipeline.f.e> pDZ;
    private final com.facebook.common.memory.g pzv;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pzv = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pDZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pDZ.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pEE;
        private TriState pGd;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pEE = akVar;
            this.pGd = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pGd == TriState.UNSET && eVar != null) {
                this.pGd = ay.l(eVar);
            }
            if (this.pGd == TriState.NO) {
                eAq().g(eVar, i);
            } else if (Rf(i)) {
                if (this.pGd == TriState.YES && eVar != null) {
                    ay.this.a(eVar, eAq(), this.pEE);
                } else {
                    eAq().g(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.eAe(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: eAC */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i eub = ay.this.pzv.eub();
                try {
                    ay.a(b2, eub);
                    com.facebook.common.references.a f = com.facebook.common.references.a.f(eub.euc());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(f);
                    eVar2.c(b2);
                    com.facebook.common.references.a.c(f);
                    return eVar2;
                } finally {
                    eub.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            /* renamed from: h */
            public void ba(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(eVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(b2);
                super.onSuccess(eVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.f.e.e(b2);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            public void etQ() {
                com.facebook.imagepipeline.f.e.e(b2);
                super.etQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c y = com.facebook.c.d.y(eVar.getInputStream());
        if (com.facebook.c.b.b(y)) {
            com.facebook.imagepipeline.nativecode.b eAa = com.facebook.imagepipeline.nativecode.c.eAa();
            if (eAa == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!eAa.d(y));
        } else if (y == com.facebook.c.c.pzf) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c y = com.facebook.c.d.y(inputStream);
        if (y == com.facebook.c.b.pyZ || y == com.facebook.c.b.pzb) {
            com.facebook.imagepipeline.nativecode.c.eAa().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.pyV);
        } else if (y == com.facebook.c.b.pza || y == com.facebook.c.b.pzc) {
            com.facebook.imagepipeline.nativecode.c.eAa().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.pyW);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
