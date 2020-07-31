package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mZk;
    private final aj<com.facebook.imagepipeline.g.e> ndT;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mZk = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.ndT.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes4.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak nez;
        private TriState nfW;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nez = akVar;
            this.nfW = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.nfW == TriState.UNSET && eVar != null) {
                this.nfW = ay.l(eVar);
            }
            if (this.nfW == TriState.NO) {
                dJA().h(eVar, i);
            } else if (JH(i)) {
                if (this.nfW == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dJA(), this.nez);
                } else {
                    dJA().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dJp(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dJN */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i dCF = ay.this.mZk.dCF();
                try {
                    ay.a(b, dCF);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dCF.dCG());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    dCF.close();
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
            public void dCt() {
                com.facebook.imagepipeline.g.e.e(b);
                super.dCt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c s = com.facebook.c.d.s(eVar.getInputStream());
        if (com.facebook.c.b.b(s)) {
            com.facebook.imagepipeline.nativecode.c dJl = com.facebook.imagepipeline.nativecode.d.dJl();
            if (dJl == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dJl.d(s));
        } else if (s == com.facebook.c.c.mYp) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c s = com.facebook.c.d.s(inputStream);
        if (s == com.facebook.c.b.mYj || s == com.facebook.c.b.mYl) {
            com.facebook.imagepipeline.nativecode.d.dJl().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.mYf);
        } else if (s == com.facebook.c.b.mYk || s == com.facebook.c.b.mYm) {
            com.facebook.imagepipeline.nativecode.d.dJl().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.mYg);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
