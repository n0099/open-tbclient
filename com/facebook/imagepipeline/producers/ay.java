package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mZm;
    private final aj<com.facebook.imagepipeline.g.e> ndV;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mZm = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.ndV = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.ndV.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes4.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak neB;
        private TriState nfY;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.neB = akVar;
            this.nfY = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.nfY == TriState.UNSET && eVar != null) {
                this.nfY = ay.l(eVar);
            }
            if (this.nfY == TriState.NO) {
                dJB().h(eVar, i);
            } else if (JH(i)) {
                if (this.nfY == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dJB(), this.neB);
                } else {
                    dJB().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dJq(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dJO */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i dCG = ay.this.mZm.dCG();
                try {
                    ay.a(b, dCG);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dCG.dCH());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    dCG.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aN(com.facebook.imagepipeline.g.e eVar2) {
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
            public void dCu() {
                com.facebook.imagepipeline.g.e.e(b);
                super.dCu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c s = com.facebook.c.d.s(eVar.getInputStream());
        if (com.facebook.c.b.b(s)) {
            com.facebook.imagepipeline.nativecode.c dJm = com.facebook.imagepipeline.nativecode.d.dJm();
            if (dJm == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dJm.d(s));
        } else if (s == com.facebook.c.c.mYr) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c s = com.facebook.c.d.s(inputStream);
        if (s == com.facebook.c.b.mYl || s == com.facebook.c.b.mYn) {
            com.facebook.imagepipeline.nativecode.d.dJm().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.mYh);
        } else if (s == com.facebook.c.b.mYm || s == com.facebook.c.b.mYo) {
            com.facebook.imagepipeline.nativecode.d.dJm().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.mYi);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
