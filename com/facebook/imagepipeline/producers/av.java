package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class av implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g icg;
    private final ai<com.facebook.imagepipeline.f.d> igI;
    private final Executor mExecutor;

    public av(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.icg = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.igI = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.igI.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj ihl;
        private TriState iiH;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.ihl = ajVar;
            this.iiH = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.iiH == TriState.UNSET && dVar != null) {
                this.iiH = av.l(dVar);
            }
            if (this.iiH == TriState.NO) {
                bXD().e(dVar, z);
            } else if (z) {
                if (this.iiH == TriState.YES && dVar != null) {
                    av.this.a(dVar, bXD(), this.ihl);
                } else {
                    bXD().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.bXr(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.av.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: bXN */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i bRH = av.this.icg.bRH();
                try {
                    av.a(b, bRH);
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(bRH.bRI());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                    dVar2.c(b);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    return dVar2;
                } finally {
                    bRH.close();
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
            public void j(Exception exc) {
                com.facebook.imagepipeline.f.d.e(b);
                super.j(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void bRy() {
                com.facebook.imagepipeline.f.d.e(b);
                super.bRy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c r = com.facebook.c.d.r(dVar.getInputStream());
        if (com.facebook.c.b.b(r)) {
            com.facebook.imagepipeline.nativecode.b bXo = com.facebook.imagepipeline.nativecode.c.bXo();
            if (bXo == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!bXo.d(r));
        } else if (r == com.facebook.c.c.ibV) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c r = com.facebook.c.d.r(inputStream);
        if (r == com.facebook.c.b.ibQ || r == com.facebook.c.b.ibS) {
            com.facebook.imagepipeline.nativecode.c.bXo().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.ibM);
        } else if (r == com.facebook.c.b.ibR || r == com.facebook.c.b.ibT) {
            com.facebook.imagepipeline.nativecode.c.bXo().g(inputStream, iVar);
            dVar.c(com.facebook.c.b.ibN);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
