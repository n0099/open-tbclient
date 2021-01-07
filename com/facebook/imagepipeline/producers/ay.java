package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pBc;
    private final aj<com.facebook.imagepipeline.f.e> pFG;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pBc = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pFG = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pFG.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes3.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pGl;
        private TriState pHJ;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pGl = akVar;
            this.pHJ = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pHJ == TriState.UNSET && eVar != null) {
                this.pHJ = ay.l(eVar);
            }
            if (this.pHJ == TriState.NO) {
                eAU().g(eVar, i);
            } else if (Rv(i)) {
                if (this.pHJ == TriState.YES && eVar != null) {
                    ay.this.a(eVar, eAU(), this.pGl);
                } else {
                    eAU().g(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.eAI(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: eBg */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i eui = ay.this.pBc.eui();
                try {
                    ay.a(b2, eui);
                    com.facebook.common.references.a f = com.facebook.common.references.a.f(eui.euj());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(f);
                    eVar2.c(b2);
                    com.facebook.common.references.a.c(f);
                    return eVar2;
                } finally {
                    eui.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void ba(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(eVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(b2);
                super.onSuccess(eVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.f.e.e(b2);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void etW() {
                com.facebook.imagepipeline.f.e.e(b2);
                super.etW();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c y = com.facebook.c.d.y(eVar.getInputStream());
        if (com.facebook.c.b.b(y)) {
            com.facebook.imagepipeline.nativecode.c eAE = com.facebook.imagepipeline.nativecode.d.eAE();
            if (eAE == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!eAE.d(y));
        } else if (y == com.facebook.c.c.pAq) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c y = com.facebook.c.d.y(inputStream);
        if (y == com.facebook.c.b.pAk || y == com.facebook.c.b.pAm) {
            com.facebook.imagepipeline.nativecode.d.eAE().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.pAg);
        } else if (y == com.facebook.c.b.pAl || y == com.facebook.c.b.pAn) {
            com.facebook.imagepipeline.nativecode.d.eAE().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.pAh);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
