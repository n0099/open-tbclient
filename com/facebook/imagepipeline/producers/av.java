package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class av implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g ipy;
    private final ai<com.facebook.imagepipeline.f.d> itX;
    private final Executor mExecutor;

    public av(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ipy = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.itX = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.itX.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj iuA;
        private TriState ivW;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.iuA = ajVar;
            this.ivW = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.ivW == TriState.UNSET && dVar != null) {
                this.ivW = av.l(dVar);
            }
            if (this.ivW == TriState.NO) {
                caC().e(dVar, z);
            } else if (z) {
                if (this.ivW == TriState.YES && dVar != null) {
                    av.this.a(dVar, caC(), this.iuA);
                } else {
                    caC().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.caq(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.av.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: caM */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i bUG = av.this.ipy.bUG();
                try {
                    av.a(b, bUG);
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(bUG.bUH());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                    dVar2.c(b);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    return dVar2;
                } finally {
                    bUG.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void an(com.facebook.imagepipeline.f.d dVar2) {
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
            public void bUx() {
                com.facebook.imagepipeline.f.d.e(b);
                super.bUx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c s = com.facebook.c.d.s(dVar.getInputStream());
        if (com.facebook.c.b.b(s)) {
            com.facebook.imagepipeline.nativecode.b can = com.facebook.imagepipeline.nativecode.c.can();
            if (can == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!can.d(s));
        } else if (s == com.facebook.c.c.ipn) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c s = com.facebook.c.d.s(inputStream);
        if (s == com.facebook.c.b.ipi || s == com.facebook.c.b.ipk) {
            com.facebook.imagepipeline.nativecode.c.can().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.ipe);
        } else if (s == com.facebook.c.b.ipj || s == com.facebook.c.b.ipl) {
            com.facebook.imagepipeline.nativecode.c.can().g(inputStream, iVar);
            dVar.c(com.facebook.c.b.ipf);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
