package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g lPJ;
    private final aj<com.facebook.imagepipeline.g.e> lUs;
    private final Executor mExecutor;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lPJ = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUs.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes10.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak lUX;
        private TriState lWu;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lUX = akVar;
            this.lWu = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.lWu == TriState.UNSET && eVar != null) {
                this.lWu = ay.l(eVar);
            }
            if (this.lWu == TriState.NO) {
                dqv().g(eVar, i);
            } else if (IE(i)) {
                if (this.lWu == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dqv(), this.lUX);
                } else {
                    dqv().g(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dqk(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dqI */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i djB = ay.this.lPJ.djB();
                try {
                    ay.a(b, djB);
                    com.facebook.common.references.a b2 = com.facebook.common.references.a.b(djB.djC());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b2);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(b2);
                    return eVar2;
                } finally {
                    djB.close();
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
            public void djp() {
                com.facebook.imagepipeline.g.e.e(b);
                super.djp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c dqg = com.facebook.imagepipeline.nativecode.d.dqg();
            if (dqg == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dqg.d(v));
        } else if (v == com.facebook.c.c.lOR) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.lOL || v == com.facebook.c.b.lON) {
            com.facebook.imagepipeline.nativecode.d.dqg().a(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.lOH);
        } else if (v == com.facebook.c.b.lOM || v == com.facebook.c.b.lOO) {
            com.facebook.imagepipeline.nativecode.d.dqg().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.lOI);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
