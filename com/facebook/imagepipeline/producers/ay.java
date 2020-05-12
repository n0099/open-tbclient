package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g lZW;
    private final Executor mExecutor;
    private final aj<com.facebook.imagepipeline.g.e> meH;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lZW = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.meH.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak mfm;
        private TriState mgJ;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.mfm = akVar;
            this.mgJ = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.mgJ == TriState.UNSET && eVar != null) {
                this.mgJ = ay.l(eVar);
            }
            if (this.mgJ == TriState.NO) {
                dud().h(eVar, i);
            } else if (Hr(i)) {
                if (this.mgJ == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dud(), this.mfm);
                } else {
                    dud().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dtS(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: duq */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i dnf = ay.this.lZW.dnf();
                try {
                    ay.a(b, dnf);
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(dnf.dng());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(c);
                    eVar2.c(b);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    return eVar2;
                } finally {
                    dnf.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aI(com.facebook.imagepipeline.g.e eVar2) {
                com.facebook.imagepipeline.g.e.e(eVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: n */
            public void onSuccess(com.facebook.imagepipeline.g.e eVar2) {
                com.facebook.imagepipeline.g.e.e(b);
                super.onSuccess(eVar2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onFailure(Exception exc) {
                com.facebook.imagepipeline.g.e.e(b);
                super.onFailure(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void dmT() {
                com.facebook.imagepipeline.g.e.e(b);
                super.dmT();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c s = com.facebook.c.d.s(eVar.getInputStream());
        if (com.facebook.c.b.b(s)) {
            com.facebook.imagepipeline.nativecode.c dtO = com.facebook.imagepipeline.nativecode.d.dtO();
            if (dtO == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dtO.d(s));
        } else if (s == com.facebook.c.c.lZa) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c s = com.facebook.c.d.s(inputStream);
        if (s == com.facebook.c.b.lYU || s == com.facebook.c.b.lYW) {
            com.facebook.imagepipeline.nativecode.d.dtO().a(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.lYQ);
        } else if (s == com.facebook.c.b.lYV || s == com.facebook.c.b.lYX) {
            com.facebook.imagepipeline.nativecode.d.dtO().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.lYR);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
