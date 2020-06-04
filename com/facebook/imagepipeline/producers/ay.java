package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mvb;
    private final aj<com.facebook.imagepipeline.g.e> mzI;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mvb = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mzI = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mzI.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak mAn;
        private TriState mBL;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.mAn = akVar;
            this.mBL = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.mBL == TriState.UNSET && eVar != null) {
                this.mBL = ay.l(eVar);
            }
            if (this.mBL == TriState.NO) {
                dBI().h(eVar, i);
            } else if (If(i)) {
                if (this.mBL == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dBI(), this.mAn);
                } else {
                    dBI().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dBx(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dBV */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i duM = ay.this.mvb.duM();
                try {
                    ay.a(b, duM);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(duM.duN());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    duM.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aM(com.facebook.imagepipeline.g.e eVar2) {
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
            public void duA() {
                com.facebook.imagepipeline.g.e.e(b);
                super.duA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c t = com.facebook.c.d.t(eVar.getInputStream());
        if (com.facebook.c.b.b(t)) {
            com.facebook.imagepipeline.nativecode.c dBt = com.facebook.imagepipeline.nativecode.d.dBt();
            if (dBt == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dBt.d(t));
        } else if (t == com.facebook.c.c.muf) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c t = com.facebook.c.d.t(inputStream);
        if (t == com.facebook.c.b.mtZ || t == com.facebook.c.b.mub) {
            com.facebook.imagepipeline.nativecode.d.dBt().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.mtV);
        } else if (t == com.facebook.c.b.mua || t == com.facebook.c.b.muc) {
            com.facebook.imagepipeline.nativecode.d.dBt().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.mtW);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
