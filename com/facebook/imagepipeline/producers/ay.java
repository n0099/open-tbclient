package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g ntb;
    private final aj<com.facebook.imagepipeline.g.e> nxL;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ntb = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.nxL = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nxL.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes8.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak nyq;
        private TriState nzN;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nyq = akVar;
            this.nzN = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.nzN == TriState.UNSET && eVar != null) {
                this.nzN = ay.l(eVar);
            }
            if (this.nzN == TriState.NO) {
                dVA().h(eVar, i);
            } else if (Ml(i)) {
                if (this.nzN == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dVA(), this.nyq);
                } else {
                    dVA().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dVp(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dVN */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i dOG = ay.this.ntb.dOG();
                try {
                    ay.a(b, dOG);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dOG.dOH());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    dOG.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aP(com.facebook.imagepipeline.g.e eVar2) {
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
            public void dOu() {
                com.facebook.imagepipeline.g.e.e(b);
                super.dOu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c t = com.facebook.c.d.t(eVar.getInputStream());
        if (com.facebook.c.b.b(t)) {
            com.facebook.imagepipeline.nativecode.c dVl = com.facebook.imagepipeline.nativecode.d.dVl();
            if (dVl == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dVl.d(t));
        } else if (t == com.facebook.c.c.nsg) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c t = com.facebook.c.d.t(inputStream);
        if (t == com.facebook.c.b.nsa || t == com.facebook.c.b.nsc) {
            com.facebook.imagepipeline.nativecode.d.dVl().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.nrW);
        } else if (t == com.facebook.c.b.nsb || t == com.facebook.c.b.nsd) {
            com.facebook.imagepipeline.nativecode.d.dVl().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.nrX);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
