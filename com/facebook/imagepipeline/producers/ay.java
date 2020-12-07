package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ay implements aj<com.facebook.imagepipeline.f.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pjO;
    private final aj<com.facebook.imagepipeline.f.e> pox;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pjO = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pox = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pox.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak ppc;
        private TriState pqB;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.ppc = akVar;
            this.pqB = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (this.pqB == TriState.UNSET && eVar != null) {
                this.pqB = ay.l(eVar);
            }
            if (this.pqB == TriState.NO) {
                ewI().h(eVar, i);
            } else if (Rh(i)) {
                if (this.pqB == TriState.YES && eVar != null) {
                    ay.this.a(eVar, ewI(), this.ppc);
                } else {
                    ewI().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.f.e eVar, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.f.e>(kVar, akVar.eww(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ewU */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                com.facebook.common.memory.i epY = ay.this.pjO.epY();
                try {
                    ay.a(b, epY);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(epY.epZ());
                    com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    epY.close();
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
            public void epM() {
                com.facebook.imagepipeline.f.e.e(b);
                super.epM();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c v = com.facebook.c.d.v(eVar.getInputStream());
        if (com.facebook.c.b.b(v)) {
            com.facebook.imagepipeline.nativecode.c ews = com.facebook.imagepipeline.nativecode.d.ews();
            if (ews == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!ews.d(v));
        } else if (v == com.facebook.c.c.pjc) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.f.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c v = com.facebook.c.d.v(inputStream);
        if (v == com.facebook.c.b.piW || v == com.facebook.c.b.piY) {
            com.facebook.imagepipeline.nativecode.d.ews().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.piS);
        } else if (v == com.facebook.c.b.piX || v == com.facebook.c.b.piZ) {
            com.facebook.imagepipeline.nativecode.d.ews().e(inputStream, iVar);
            eVar.c(com.facebook.c.b.piT);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
