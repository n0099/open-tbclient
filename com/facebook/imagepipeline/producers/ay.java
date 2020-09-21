package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g nDr;
    private final aj<com.facebook.imagepipeline.g.e> nIa;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nDr = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nIa.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes25.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak nIF;
        private TriState nKc;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nIF = akVar;
            this.nKc = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.nKc == TriState.UNSET && eVar != null) {
                this.nKc = ay.l(eVar);
            }
            if (this.nKc == TriState.NO) {
                dZH().h(eVar, i);
            } else if (MQ(i)) {
                if (this.nKc == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dZH(), this.nIF);
                } else {
                    dZH().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dZw(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dZU */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i dSN = ay.this.nDr.dSN();
                try {
                    ay.a(b, dSN);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dSN.dSO());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    dSN.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aR(com.facebook.imagepipeline.g.e eVar2) {
                com.facebook.imagepipeline.g.e.e(eVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.g.e eVar2) {
                com.facebook.imagepipeline.g.e.e(b);
                super.onSuccess(eVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.g.e.e(b);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void dSB() {
                com.facebook.imagepipeline.g.e.e(b);
                super.dSB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c t = com.facebook.c.d.t(eVar.getInputStream());
        if (com.facebook.c.b.b(t)) {
            com.facebook.imagepipeline.nativecode.c dZs = com.facebook.imagepipeline.nativecode.d.dZs();
            if (dZs == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dZs.d(t));
        } else if (t == com.facebook.c.c.nCw) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c t = com.facebook.c.d.t(inputStream);
        if (t == com.facebook.c.b.nCq || t == com.facebook.c.b.nCs) {
            com.facebook.imagepipeline.nativecode.d.dZs().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.nCm);
        } else if (t == com.facebook.c.b.nCr || t == com.facebook.c.b.nCt) {
            com.facebook.imagepipeline.nativecode.d.dZs().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.nCn);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
