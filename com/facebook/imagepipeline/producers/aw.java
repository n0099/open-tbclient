package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class aw implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g kik;
    private final ai<com.facebook.imagepipeline.f.d> kmM;
    private final Executor mExecutor;

    public aw(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kik = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kmM = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kmM.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj knp;
        private TriState koN;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.knp = ajVar;
            this.koN = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.koN == TriState.UNSET && dVar != null) {
                this.koN = aw.l(dVar);
            }
            if (this.koN == TriState.NO) {
                cLX().e(dVar, z);
            } else if (z) {
                if (this.koN == TriState.YES && dVar != null) {
                    aw.this.a(dVar, cLX(), this.knp);
                } else {
                    cLX().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.cLL(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.aw.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cMh */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i cFS = aw.this.kik.cFS();
                try {
                    aw.a(b, cFS);
                    com.facebook.common.references.a d = com.facebook.common.references.a.d(cFS.cFT());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                    dVar2.c(b);
                    com.facebook.common.references.a.c(d);
                    return dVar2;
                } finally {
                    cFS.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aB(com.facebook.imagepipeline.f.d dVar2) {
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
            public void cFJ() {
                com.facebook.imagepipeline.f.d.e(b);
                super.cFJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c u = com.facebook.c.d.u(dVar.getInputStream());
        if (com.facebook.c.b.b(u)) {
            com.facebook.imagepipeline.nativecode.b cLI = com.facebook.imagepipeline.nativecode.c.cLI();
            if (cLI == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!cLI.d(u));
        } else if (u == com.facebook.c.c.khY) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c u = com.facebook.c.d.u(inputStream);
        if (u == com.facebook.c.b.khT || u == com.facebook.c.b.khV) {
            com.facebook.imagepipeline.nativecode.c.cLI().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.khP);
        } else if (u == com.facebook.c.b.khU || u == com.facebook.c.b.khW) {
            com.facebook.imagepipeline.nativecode.c.cLI().h(inputStream, iVar);
            dVar.c(com.facebook.c.b.khQ);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
