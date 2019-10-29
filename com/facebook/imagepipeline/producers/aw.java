package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class aw implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g kgu;
    private final ai<com.facebook.imagepipeline.f.d> kkY;
    private final Executor mExecutor;

    public aw(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kgu = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kkY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kkY.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj klB;
        private TriState kmZ;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.klB = ajVar;
            this.kmZ = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.kmZ == TriState.UNSET && dVar != null) {
                this.kmZ = aw.l(dVar);
            }
            if (this.kmZ == TriState.NO) {
                cIU().f(dVar, z);
            } else if (z) {
                if (this.kmZ == TriState.YES && dVar != null) {
                    aw.this.a(dVar, cIU(), this.klB);
                } else {
                    cIU().f(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.cII(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.aw.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cJe */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i cCQ = aw.this.kgu.cCQ();
                try {
                    aw.a(b, cCQ);
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(cCQ.cCR());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                    dVar2.c(b);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    return dVar2;
                } finally {
                    cCQ.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aw(com.facebook.imagepipeline.f.d dVar2) {
                com.facebook.imagepipeline.f.d.e(dVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.f.d dVar2) {
                com.facebook.imagepipeline.f.d.e(b);
                super.onSuccess(dVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.f.d.e(b);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void cCH() {
                com.facebook.imagepipeline.f.d.e(b);
                super.cCH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c r = com.facebook.c.d.r(dVar.getInputStream());
        if (com.facebook.c.b.b(r)) {
            com.facebook.imagepipeline.nativecode.b cIF = com.facebook.imagepipeline.nativecode.c.cIF();
            if (cIF == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!cIF.d(r));
        } else if (r == com.facebook.c.c.kgj) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c r = com.facebook.c.d.r(inputStream);
        if (r == com.facebook.c.b.kge || r == com.facebook.c.b.kgg) {
            com.facebook.imagepipeline.nativecode.c.cIF().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.kga);
        } else if (r == com.facebook.c.b.kgf || r == com.facebook.c.b.kgh) {
            com.facebook.imagepipeline.nativecode.c.cIF().f(inputStream, iVar);
            dVar.c(com.facebook.c.b.kgb);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
