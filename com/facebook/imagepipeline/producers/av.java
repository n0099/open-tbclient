package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class av implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g ioq;
    private final ai<com.facebook.imagepipeline.f.d> isP;
    private final Executor mExecutor;

    public av(Executor executor, com.facebook.common.memory.g gVar, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ioq = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.isP = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.isP.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj its;
        private TriState iuO;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.its = ajVar;
            this.iuO = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (this.iuO == TriState.UNSET && dVar != null) {
                this.iuO = av.l(dVar);
            }
            if (this.iuO == TriState.NO) {
                bZU().e(dVar, z);
            } else if (z) {
                if (this.iuO == TriState.YES && dVar != null) {
                    av.this.a(dVar, bZU(), this.its);
                } else {
                    bZU().e(dVar, z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.d dVar, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        this.mExecutor.execute(new ao<com.facebook.imagepipeline.f.d>(jVar, ajVar.bZI(), "WebpTranscodeProducer", ajVar.getId()) { // from class: com.facebook.imagepipeline.producers.av.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cae */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                com.facebook.common.memory.i bTY = av.this.ioq.bTY();
                try {
                    av.a(b, bTY);
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(bTY.bTZ());
                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                    dVar2.c(b);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    return dVar2;
                } finally {
                    bTY.close();
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
            public void bTP() {
                com.facebook.imagepipeline.f.d.e(b);
                super.bTP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.c.c s = com.facebook.c.d.s(dVar.getInputStream());
        if (com.facebook.c.b.b(s)) {
            com.facebook.imagepipeline.nativecode.b bZF = com.facebook.imagepipeline.nativecode.c.bZF();
            if (bZF == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!bZF.d(s));
        } else if (s == com.facebook.c.c.iof) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.d dVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = dVar.getInputStream();
        com.facebook.c.c s = com.facebook.c.d.s(inputStream);
        if (s == com.facebook.c.b.ioa || s == com.facebook.c.b.ioc) {
            com.facebook.imagepipeline.nativecode.c.bZF().a(inputStream, iVar, 80);
            dVar.c(com.facebook.c.b.inW);
        } else if (s == com.facebook.c.b.iob || s == com.facebook.c.b.iod) {
            com.facebook.imagepipeline.nativecode.c.bZF().g(inputStream, iVar);
            dVar.c(com.facebook.c.b.inX);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
