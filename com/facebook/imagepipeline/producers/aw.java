package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class aw implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jEK;
    private final ai<com.facebook.imagepipeline.f.d> jJl;
    private final Executor mExecutor;

    public aw(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jEK = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.jJl = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJl.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj jJO;
        private TriState jLm;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.jJO = ajVar;
            this.jLm = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.jLm == TriState.UNSET && dVar != null) {
                this.jLm = aw.l(dVar);
            }
            if (this.jLm == TriState.NO) {
                czN().e(dVar, z);
            } else if (z) {
                if (this.jLm == TriState.YES && dVar != null) {
                    aw.this.a(dVar, czN(), this.jJO);
                } else {
                    czN().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.czB(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.aw.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: czX */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i ctK = aw.this.jEK.ctK();
                try {
                    aw.a(b, ctK);
                    com.facebook.common.references.a d = com.facebook.common.references.a.d(ctK.ctL());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                    dVar2.c(b);
                    com.facebook.common.references.a.c(d);
                    return dVar2;
                } finally {
                    ctK.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void az(com.facebook.imagepipeline.f.d dVar2) {
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
            public void ctB() {
                com.facebook.imagepipeline.f.d.e(b);
                super.ctB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c u = com.facebook.c.d.u(dVar.getInputStream());
        if (com.facebook.c.b.b(u)) {
            com.facebook.imagepipeline.nativecode.b czy = com.facebook.imagepipeline.nativecode.c.czy();
            if (czy == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!czy.d(u));
        } else if (u == com.facebook.c.c.jEz) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c u = com.facebook.c.d.u(inputStream);
        if (u == com.facebook.c.b.jEu || u == com.facebook.c.b.jEw) {
            com.facebook.imagepipeline.nativecode.c.czy().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.jEq);
        } else if (u == com.facebook.c.b.jEv || u == com.facebook.c.b.jEx) {
            com.facebook.imagepipeline.nativecode.c.czy().h(inputStream, iVar);
            dVar.c(com.facebook.c.b.jEr);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
