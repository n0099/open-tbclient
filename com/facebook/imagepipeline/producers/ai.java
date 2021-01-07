package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes3.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.a.f pAG;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pFG;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.pFG = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pAG = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am eAI = akVar.eAI();
        com.facebook.imagepipeline.request.b eBF = akVar.eAH().eBF();
        a aVar = new a(kVar, eAI, akVar.getId(), eBF, akVar);
        if (eBF instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eBF, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.pFG.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Rz;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am pHc;
        private final com.facebook.imagepipeline.request.b pHd;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pHe;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pHf;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pHg;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pHe = null;
            this.mStatus = 0;
            this.pHf = false;
            this.pHg = false;
            this.pHc = amVar;
            this.mRequestId = str;
            this.pHd = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAO() {
                    a.this.eBr();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Rv(i)) {
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
        protected void ezv() {
            eBr();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pHe;
                    this.pHe = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pHf = true;
                    boolean eBq = eBq();
                    com.facebook.common.references.a.c(aVar2);
                    if (eBq) {
                        eBo();
                    }
                }
            }
        }

        private void eBo() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pHe;
                        i = a.this.mStatus;
                        a.this.pHe = null;
                        a.this.pHf = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.eBp();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eBp() {
            boolean eBq;
            synchronized (this) {
                this.pHg = false;
                eBq = eBq();
            }
            if (eBq) {
                eBo();
            }
        }

        private synchronized boolean eBq() {
            boolean z = true;
            synchronized (this) {
                if (this.Rz || !this.pHf || this.pHg || !com.facebook.common.references.a.a(this.pHe)) {
                    z = false;
                } else {
                    this.pHg = true;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
            if (!f(aVar.get())) {
                e(aVar, i);
                return;
            }
            this.pHc.hn(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.pHc.b(this.mRequestId, "PostprocessorProducer", a(this.pHc, this.mRequestId, this.pHd));
                e(aVar2, i);
            } catch (Exception e) {
                this.pHc.a(this.mRequestId, "PostprocessorProducer", e, a(this.pHc, this.mRequestId, this.pHd));
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

        private boolean f(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pHd.a(dVar.ezF(), ai.this.pAG);
            try {
                return com.facebook.common.references.a.f(new com.facebook.imagepipeline.f.d(a2, cVar.ezG(), dVar.ezJ(), dVar.ezK()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean Rv = Rv(i);
            if ((!Rv && !isClosed()) || (Rv && ati())) {
                eAU().g(aVar, i);
            }
        }

        private void F(Throwable th) {
            if (ati()) {
                eAU().D(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eBr() {
            if (ati()) {
                eAU().etW();
            }
        }

        private synchronized boolean isClosed() {
            return this.Rz;
        }

        private boolean ati() {
            boolean z = true;
            synchronized (this) {
                if (this.Rz) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pHe;
                    this.pHe = null;
                    this.Rz = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes3.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Rw(i)) {
                eAU().g(aVar, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Rz;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pHe;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Rz = false;
            this.pHe = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAO() {
                    if (b.this.ati()) {
                        b.this.eAU().etW();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Rw(i)) {
                p(aVar);
                eBs();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (ati()) {
                eAU().D(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void ezv() {
            if (ati()) {
                eAU().etW();
            }
        }

        private void eBs() {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = com.facebook.common.references.a.b(this.pHe);
                    try {
                        eAU().g(b2, 0);
                    } finally {
                        com.facebook.common.references.a.c(b2);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.Rz) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pHe;
                    this.pHe = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ati() {
            boolean z = true;
            synchronized (this) {
                if (this.Rz) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pHe;
                    this.pHe = null;
                    this.Rz = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
