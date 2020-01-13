package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g lPE;
    private final aj<com.facebook.imagepipeline.g.e> lUn;
    private final Executor mExecutor;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lPE = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUn.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes10.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak lUS;
        private TriState lWp;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lUS = akVar;
            this.lWp = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.lWp == TriState.UNSET && eVar != null) {
                this.lWp = ay.l(eVar);
            }
            if (this.lWp == TriState.NO) {
                dqt().g(eVar, i);
            } else if (IE(i)) {
                if (this.lWp == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dqt(), this.lUS);
                } else {
                    dqt().g(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dqi(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dqG */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i djz = ay.this.lPE.djz();
                try {
                    ay.a(b, djz);
                    com.facebook.common.references.a b2 = com.facebook.common.references.a.b(djz.djA());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b2);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(b2);
                    return eVar2;
                } finally {
                    djz.close();
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
            public void djn() {
                com.facebook.imagepipeline.g.e.e(b);
                super.djn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c dqe = com.facebook.imagepipeline.nativecode.d.dqe();
            if (dqe == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dqe.d(v));
        } else if (v == com.facebook.c.c.lOM) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.lOG || v == com.facebook.c.b.lOI) {
            com.facebook.imagepipeline.nativecode.d.dqe().a(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.lOC);
        } else if (v == com.facebook.c.b.lOH || v == com.facebook.c.b.lOJ) {
            com.facebook.imagepipeline.nativecode.d.dqe().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.lOD);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
