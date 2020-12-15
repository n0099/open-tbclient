package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pjQ;
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pjQ = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.poz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.poz.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak ppe;
        private TriState pqD;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.ppe = akVar;
            this.pqD = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pqD == TriState.UNSET && eVar != null) {
                this.pqD = ay.l(eVar);
            }
            if (this.pqD == TriState.NO) {
                ewJ().h(eVar, i);
            } else if (Rh(i)) {
                if (this.pqD == TriState.YES && eVar != null) {
                    ay.this.a(eVar, ewJ(), this.ppe);
                } else {
                    ewJ().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.ewx(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ewV */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i epZ = ay.this.pjQ.epZ();
                try {
                    ay.a(b, epZ);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(epZ.eqa());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    epZ.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aZ(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(eVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.f.e eVar2) {
                com.facebook.imagepipeline.f.e.e(b);
                super.onSuccess(eVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.f.e.e(b);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void epN() {
                com.facebook.imagepipeline.f.e.e(b);
                super.epN();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c ewt = com.facebook.imagepipeline.nativecode.d.ewt();
            if (ewt == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!ewt.d(v));
        } else if (v == com.facebook.c.c.pje) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.piY || v == com.facebook.c.b.pja) {
            com.facebook.imagepipeline.nativecode.d.ewt().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.piU);
        } else if (v == com.facebook.c.b.piZ || v == com.facebook.c.b.pjb) {
            com.facebook.imagepipeline.nativecode.d.ewt().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.piV);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
