package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ay implements aj<com.facebook.imagepipeline.g.e> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mRd;
    private final aj<com.facebook.imagepipeline.g.e> mVS;

    public ay(Executor executor, com.facebook.common.memory.g gVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mRd = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mVS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mVS.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final ak mWx;
        private TriState mXV;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.mWx = akVar;
            this.mXV = TriState.UNSET;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (this.mXV == TriState.UNSET && eVar != null) {
                this.mXV = ay.l(eVar);
            }
            if (this.mXV == TriState.NO) {
                dGo().h(eVar, i);
            } else if (Jm(i)) {
                if (this.mXV == TriState.YES && eVar != null) {
                    ay.this.a(eVar, dGo(), this.mWx);
                } else {
                    dGo().h(eVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.facebook.imagepipeline.g.e eVar, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        this.mExecutor.execute(new aq<com.facebook.imagepipeline.g.e>(kVar, akVar.dGd(), "WebpTranscodeProducer", akVar.getId()) { // from class: com.facebook.imagepipeline.producers.ay.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dGB */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                com.facebook.common.memory.i dzt = ay.this.mRd.dzt();
                try {
                    ay.a(b, dzt);
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dzt.dzu());
                    com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                    eVar2.c(b);
                    com.facebook.common.references.a.c(e);
                    return eVar2;
                } finally {
                    dzt.close();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aN(com.facebook.imagepipeline.g.e eVar2) {
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
            public void dzh() {
                com.facebook.imagepipeline.g.e.e(b);
                super.dzh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState l(com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.c.c t = com.facebook.c.d.t(eVar.getInputStream());
        if (com.facebook.c.b.b(t)) {
            com.facebook.imagepipeline.nativecode.c dFZ = com.facebook.imagepipeline.nativecode.d.dFZ();
            if (dFZ == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!dFZ.d(t));
        } else if (t == com.facebook.c.c.mQh) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.facebook.imagepipeline.g.e eVar, com.facebook.common.memory.i iVar) throws Exception {
        InputStream inputStream = eVar.getInputStream();
        com.facebook.c.c t = com.facebook.c.d.t(inputStream);
        if (t == com.facebook.c.b.mQb || t == com.facebook.c.b.mQd) {
            com.facebook.imagepipeline.nativecode.d.dFZ().b(inputStream, iVar, 80);
            eVar.c(com.facebook.c.b.mPX);
        } else if (t == com.facebook.c.b.mQc || t == com.facebook.c.b.mQe) {
            com.facebook.imagepipeline.nativecode.d.dFZ().f(inputStream, iVar);
            eVar.c(com.facebook.c.b.mPY);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }
}
