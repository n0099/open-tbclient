package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDZ;
    private final com.facebook.imagepipeline.a.f pFv;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.pDZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pFv = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am eAe = akVar.eAe();
        com.facebook.imagepipeline.request.b eBb = akVar.eAd().eBb();
        a aVar = new a(kVar, eAe, akVar.getId(), eBb, akVar);
        if (eBb instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eBb, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.pDZ.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Rz;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pFA;
        private final am pFw;
        private final com.facebook.imagepipeline.request.b pFx;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pFy;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pFz;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pFy = null;
            this.mStatus = 0;
            this.pFz = false;
            this.pFA = false;
            this.pFw = amVar;
            this.mRequestId = str;
            this.pFx = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAk() {
                    a.this.eAN();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Rf(i)) {
                    e(null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eyT() {
            eAN();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pFy;
                    this.pFy = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pFz = true;
                    boolean eAM = eAM();
                    com.facebook.common.references.a.c(aVar2);
                    if (eAM) {
                        eAK();
                    }
                }
            }
        }

        private void eAK() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pFy;
                        i = a.this.mStatus;
                        a.this.pFy = null;
                        a.this.pFz = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.eAL();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAL() {
            boolean eAM;
            synchronized (this) {
                this.pFA = false;
                eAM = eAM();
            }
            if (eAM) {
                eAK();
            }
        }

        private synchronized boolean eAM() {
            boolean z = true;
            synchronized (this) {
                if (this.Rz || !this.pFz || this.pFA || !com.facebook.common.references.a.a(this.pFy)) {
                    z = false;
                } else {
                    this.pFA = true;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
            if (!e(aVar.get())) {
                e(aVar, i);
                return;
            }
            this.pFw.hm(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = f(aVar.get());
                this.pFw.b(this.mRequestId, "PostprocessorProducer", a(this.pFw, this.mRequestId, this.pFx));
                e(aVar2, i);
            } catch (Exception e) {
                this.pFw.a(this.mRequestId, "PostprocessorProducer", e, a(this.pFw, this.mRequestId, this.pFx));
                F(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.ZA(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean e(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> f(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pFx.a(dVar.ezc(), ai.this.pFv);
            try {
                return com.facebook.common.references.a.f(new com.facebook.imagepipeline.f.d(a2, cVar.ezd(), dVar.ezf(), dVar.ezg()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean Rf = Rf(i);
            if ((!Rf && !isClosed()) || (Rf && ath())) {
                eAq().g(aVar, i);
            }
        }

        private void F(Throwable th) {
            if (ath()) {
                eAq().D(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAN() {
            if (ath()) {
                eAq().etQ();
            }
        }

        private synchronized boolean isClosed() {
            return this.Rz;
        }

        private boolean ath() {
            boolean z = true;
            synchronized (this) {
                if (this.Rz) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pFy;
                    this.pFy = null;
                    this.Rz = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes5.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Rg(i)) {
                eAq().g(aVar, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Rz;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pFy;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Rz = false;
            this.pFy = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAk() {
                    if (b.this.ath()) {
                        b.this.eAq().etQ();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Rg(i)) {
                m(aVar);
                eAO();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (ath()) {
                eAq().D(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eyT() {
            if (ath()) {
                eAq().etQ();
            }
        }

        private void eAO() {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = com.facebook.common.references.a.b(this.pFy);
                    try {
                        eAq().g(b2, 0);
                    } finally {
                        com.facebook.common.references.a.c(b2);
                    }
                }
            }
        }

        private void m(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pFy;
                    this.pFy = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ath() {
            boolean z = true;
            synchronized (this) {
                if (this.Rz) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pFy;
                    this.pFy = null;
                    this.Rz = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
