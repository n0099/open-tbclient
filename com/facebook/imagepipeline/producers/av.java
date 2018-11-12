package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class av implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g idU;
    private final ai<com.facebook.imagepipeline.f.d> iit;
    private final Executor mExecutor;

    public av(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.idU = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.iit = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.iit.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj iiW;
        private TriState iks;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.iiW = ajVar;
            this.iks = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.iks == TriState.UNSET && dVar != null) {
                this.iks = av.l(dVar);
            }
            if (this.iks == TriState.NO) {
                bWY().e(dVar, z);
            } else if (z) {
                if (this.iks == TriState.YES && dVar != null) {
                    av.this.a(dVar, bWY(), this.iiW);
                } else {
                    bWY().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.bWM(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.av.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: bXi */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i bRc = av.this.idU.bRc();
                try {
                    av.a(b, bRc);
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(bRc.bRd());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                    dVar2.c(b);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    return dVar2;
                } finally {
                    bRc.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void am(com.facebook.imagepipeline.f.d dVar2) {
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
            public void j(Exception exc) {
                com.facebook.imagepipeline.f.d.e(b);
                super.j(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void bQT() {
                com.facebook.imagepipeline.f.d.e(b);
                super.bQT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c r = com.facebook.c.d.r(dVar.getInputStream());
        if (com.facebook.c.b.b(r)) {
            com.facebook.imagepipeline.nativecode.b bWJ = com.facebook.imagepipeline.nativecode.c.bWJ();
            if (bWJ == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!bWJ.d(r));
        } else if (r == com.facebook.c.c.idJ) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c r = com.facebook.c.d.r(inputStream);
        if (r == com.facebook.c.b.idE || r == com.facebook.c.b.idG) {
            com.facebook.imagepipeline.nativecode.c.bWJ().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.idA);
        } else if (r == com.facebook.c.b.idF || r == com.facebook.c.b.idH) {
            com.facebook.imagepipeline.nativecode.c.bWJ().g(inputStream, iVar);
            dVar.c(com.facebook.c.b.idB);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
