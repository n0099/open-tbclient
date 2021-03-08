package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pJp;
    private final aj<com.facebook.imagepipeline.f.e> pNT;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pJp = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pNT.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pOy;
        private TriState pPW;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pOy = akVar;
            this.pPW = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pPW == TriState.UNSET && eVar != null) {
                this.pPW = ay.l(eVar);
            }
            if (this.pPW == TriState.NO) {
                ezL().f(eVar, i);
            } else if (Qo(i)) {
                if (this.pPW == TriState.YES && eVar != null) {
                    ay.this.a(eVar, ezL(), this.pOy);
                } else {
                    ezL().f(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.ezz(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ezX */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i esY = ay.this.pJp.esY();
                try {
                    ay.a(b, esY);
                    com.facebook.common.references.a d = com.facebook.common.references.a.d(esY.esZ());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(d);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(d);
                    return eVar2;
                } finally {
                    esY.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void bc(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(eVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(b);
                super.onSuccess(eVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.f.e.e(b);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void esM() {
                com.facebook.imagepipeline.f.e.e(b);
                super.esM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c ezv = com.facebook.imagepipeline.nativecode.d.ezv();
            if (ezv == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!ezv.d(v));
        } else if (v == com.facebook.c.c.pID) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.pIx || v == com.facebook.c.b.pIz) {
            com.facebook.imagepipeline.nativecode.d.ezv().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.pIt);
        } else if (v == com.facebook.c.b.pIy || v == com.facebook.c.b.pIA) {
            com.facebook.imagepipeline.nativecode.d.ezv().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.pIu);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
