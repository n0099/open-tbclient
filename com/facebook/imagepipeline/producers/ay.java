package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pHk;
    private final aj<com.facebook.imagepipeline.f.e> pLO;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pHk = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pLO = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLO.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pMt;
        private TriState pNR;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pMt = akVar;
            this.pNR = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pNR == TriState.UNSET && eVar != null) {
                this.pNR = ay.l(eVar);
            }
            if (this.pNR == TriState.NO) {
                ezC().g(eVar, i);
            } else if (Qk(i)) {
                if (this.pNR == TriState.YES && eVar != null) {
                    ay.this.a(eVar, ezC(), this.pMt);
                } else {
                    ezC().g(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.ezq(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ezO */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i esP = ay.this.pHk.esP();
                try {
                    ay.a(b2, esP);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(esP.esQ());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                    eVar2.c(b2);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    esP.close();
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
            public void esD() {
                com.facebook.imagepipeline.f.e.e(b2);
                super.esD();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c ezm = com.facebook.imagepipeline.nativecode.d.ezm();
            if (ezm == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!ezm.d(v));
        } else if (v == com.facebook.c.c.pGy) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.pGs || v == com.facebook.c.b.pGu) {
            com.facebook.imagepipeline.nativecode.d.ezm().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.pGo);
        } else if (v == com.facebook.c.b.pGt || v == com.facebook.c.b.pGv) {
            com.facebook.imagepipeline.nativecode.d.ezm().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.pGp);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
