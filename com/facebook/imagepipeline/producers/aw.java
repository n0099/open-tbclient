package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class aw implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jXB;
    private final ai<com.facebook.imagepipeline.f.d> kcc;
    private final Executor mExecutor;

    public aw(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jXB = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kcc = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kcc.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj kcF;
        private TriState ked;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.kcF = ajVar;
            this.ked = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.ked == TriState.UNSET && dVar != null) {
                this.ked = aw.l(dVar);
            }
            if (this.ked == TriState.NO) {
                cHK().e(dVar, z);
            } else if (z) {
                if (this.ked == TriState.YES && dVar != null) {
                    aw.this.a(dVar, cHK(), this.kcF);
                } else {
                    cHK().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.cHy(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.aw.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cHU */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i cBI = aw.this.jXB.cBI();
                try {
                    aw.a(b, cBI);
                    com.facebook.common.references.a d = com.facebook.common.references.a.d(cBI.cBJ());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                    dVar2.c(b);
                    com.facebook.common.references.a.c(d);
                    return dVar2;
                } finally {
                    cBI.close();
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
            public void cBz() {
                com.facebook.imagepipeline.f.d.e(b);
                super.cBz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c u = com.facebook.c.d.u(dVar.getInputStream());
        if (com.facebook.c.b.b(u)) {
            com.facebook.imagepipeline.nativecode.b cHv = com.facebook.imagepipeline.nativecode.c.cHv();
            if (cHv == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!cHv.d(u));
        } else if (u == com.facebook.c.c.jXq) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c u = com.facebook.c.d.u(inputStream);
        if (u == com.facebook.c.b.jXl || u == com.facebook.c.b.jXn) {
            com.facebook.imagepipeline.nativecode.c.cHv().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.jXh);
        } else if (u == com.facebook.c.b.jXm || u == com.facebook.c.b.jXo) {
            com.facebook.imagepipeline.nativecode.c.cHv().h(inputStream, iVar);
            dVar.c(com.facebook.c.b.jXi);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
