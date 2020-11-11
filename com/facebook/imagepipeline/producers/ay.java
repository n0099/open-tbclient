package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g oTv;
    private final aj<com.facebook.imagepipeline.g.e> oYc;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oTv = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oYc.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes18.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak oYH;
        private TriState paf;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.oYH = akVar;
            this.paf = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.paf == TriState.UNSET && eVar != null) {
                this.paf = ay.l(eVar);
            }
            if (this.paf == TriState.NO) {
                erh().h(eVar, i);
            } else if (PI(i)) {
                if (this.paf == TriState.YES && eVar != null) {
                    ay.this.a(eVar, erh(), this.oYH);
                } else {
                    erh().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.eqW(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: eru */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i ekl = ay.this.oTv.ekl();
                try {
                    ay.a(b, ekl);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(ekl.ekm());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    ekl.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aY(com.facebook.imagepipeline.g.e eVar2) {
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
            public void ejZ() {
                com.facebook.imagepipeline.g.e.e(b);
                super.ejZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c u = com.facebook.c.d.u(eVar.getInputStream());
        if (com.facebook.c.b.b(u)) {
            com.facebook.imagepipeline.nativecode.c eqS = com.facebook.imagepipeline.nativecode.d.eqS();
            if (eqS == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!eqS.d(u));
        } else if (u == com.facebook.c.c.oSA) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c u = com.facebook.c.d.u(inputStream);
        if (u == com.facebook.c.b.oSu || u == com.facebook.c.b.oSw) {
            com.facebook.imagepipeline.nativecode.d.eqS().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.oSq);
        } else if (u == com.facebook.c.b.oSv || u == com.facebook.c.b.oSx) {
            com.facebook.imagepipeline.nativecode.d.eqS().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.oSr);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
