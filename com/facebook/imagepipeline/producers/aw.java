package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class aw implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jFe;
    private final ai<com.facebook.imagepipeline.f.d> jJF;
    private final Executor mExecutor;

    public aw(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jFe = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.jJF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJF.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj jKi;
        private TriState jLG;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.jKi = ajVar;
            this.jLG = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.jLG == TriState.UNSET && dVar != null) {
                this.jLG = aw.l(dVar);
            }
            if (this.jLG == TriState.NO) {
                czH().e(dVar, z);
            } else if (z) {
                if (this.jLG == TriState.YES && dVar != null) {
                    aw.this.a(dVar, czH(), this.jKi);
                } else {
                    czH().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.czv(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.aw.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: czR */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i ctE = aw.this.jFe.ctE();
                try {
                    aw.a(b, ctE);
                    com.facebook.common.references.a d = com.facebook.common.references.a.d(ctE.ctF());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                    dVar2.c(b);
                    com.facebook.common.references.a.c(d);
                    return dVar2;
                } finally {
                    ctE.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aC(com.facebook.imagepipeline.f.d dVar2) {
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
            public void ctv() {
                com.facebook.imagepipeline.f.d.e(b);
                super.ctv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c u = com.facebook.c.d.u(dVar.getInputStream());
        if (com.facebook.c.b.b(u)) {
            com.facebook.imagepipeline.nativecode.b czs = com.facebook.imagepipeline.nativecode.c.czs();
            if (czs == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!czs.d(u));
        } else if (u == com.facebook.c.c.jET) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c u = com.facebook.c.d.u(inputStream);
        if (u == com.facebook.c.b.jEO || u == com.facebook.c.b.jEQ) {
            com.facebook.imagepipeline.nativecode.c.czs().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.jEK);
        } else if (u == com.facebook.c.b.jEP || u == com.facebook.c.b.jER) {
            com.facebook.imagepipeline.nativecode.c.czs().h(inputStream, iVar);
            dVar.c(com.facebook.c.b.jEL);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
