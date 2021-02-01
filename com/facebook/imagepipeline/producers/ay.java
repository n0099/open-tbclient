package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pGK;
    private final aj<com.facebook.imagepipeline.f.e> pLo;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pGK = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pLo = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLo.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pLT;
        private TriState pNr;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pLT = akVar;
            this.pNr = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pNr == TriState.UNSET && eVar != null) {
                this.pNr = ay.l(eVar);
            }
            if (this.pNr == TriState.NO) {
                ezu().g(eVar, i);
            } else if (Qj(i)) {
                if (this.pNr == TriState.YES && eVar != null) {
                    ay.this.a(eVar, ezu(), this.pLT);
                } else {
                    ezu().g(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.ezi(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ezG */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i esH = ay.this.pGK.esH();
                try {
                    ay.a(b2, esH);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(esH.esI());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                    eVar2.c(b2);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    esH.close();
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
            public void esv() {
                com.facebook.imagepipeline.f.e.e(b2);
                super.esv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c eze = com.facebook.imagepipeline.nativecode.d.eze();
            if (eze == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!eze.d(v));
        } else if (v == com.facebook.c.c.pFY) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.pFS || v == com.facebook.c.b.pFU) {
            com.facebook.imagepipeline.nativecode.d.eze().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.pFO);
        } else if (v == com.facebook.c.b.pFT || v == com.facebook.c.b.pFV) {
            com.facebook.imagepipeline.nativecode.d.eze().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.pFP);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
