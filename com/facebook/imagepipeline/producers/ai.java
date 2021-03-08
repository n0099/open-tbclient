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
    private final com.facebook.imagepipeline.a.f pIT;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pNT;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pIT = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am ezz = akVar.ezz();
        com.facebook.imagepipeline.request.b eAw = akVar.ezy().eAw();
        a aVar = new a(kVar, ezz, akVar.getId(), eAw, akVar);
        if (eAw instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eAw, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.pNT.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean SU;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am pPp;
        private final com.facebook.imagepipeline.request.b pPq;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pPr;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pPs;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pPt;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pPr = null;
            this.mStatus = 0;
            this.pPs = false;
            this.pPt = false;
            this.pPp = amVar;
            this.mRequestId = str;
            this.pPq = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezF() {
                    a.this.eAi();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Qo(i)) {
                    e((com.facebook.common.references.a<com.facebook.imagepipeline.f.c>) null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            E(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eyn() {
            eAi();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.SU) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pPr;
                    this.pPr = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pPs = true;
                    boolean eAh = eAh();
                    com.facebook.common.references.a.c(aVar2);
                    if (eAh) {
                        eAf();
                    }
                }
            }
        }

        private void eAf() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pPr;
                        i = a.this.mStatus;
                        a.this.pPr = null;
                        a.this.pPs = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.eAg();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAg() {
            boolean eAh;
            synchronized (this) {
                this.pPt = false;
                eAh = eAh();
            }
            if (eAh) {
                eAf();
            }
        }

        private synchronized boolean eAh() {
            boolean z = true;
            synchronized (this) {
                if (this.SU || !this.pPs || this.pPt || !com.facebook.common.references.a.a(this.pPr)) {
                    z = false;
                } else {
                    this.pPt = true;
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
            this.pPp.hv(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.pPp.b(this.mRequestId, "PostprocessorProducer", a(this.pPp, this.mRequestId, this.pPq));
                e(aVar2, i);
            } catch (Exception e) {
                this.pPp.a(this.mRequestId, "PostprocessorProducer", e, a(this.pPp, this.mRequestId, this.pPq));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.ZM(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pPq.a(dVar.eyx(), ai.this.pIT);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.d(a2, cVar.eyy(), dVar.eyB(), dVar.eyC()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean Qo = Qo(i);
            if ((!Qo && !isClosed()) || (Qo && apO())) {
                ezL().f(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (apO()) {
                ezL().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAi() {
            if (apO()) {
                ezL().esM();
            }
        }

        private synchronized boolean isClosed() {
            return this.SU;
        }

        private boolean apO() {
            boolean z = true;
            synchronized (this) {
                if (this.SU) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pPr;
                    this.pPr = null;
                    this.SU = true;
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
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Qp(i)) {
                ezL().f(aVar, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean SU;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pPr;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.SU = false;
            this.pPr = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezF() {
                    if (b.this.apO()) {
                        b.this.ezL().esM();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Qp(i)) {
                p(aVar);
                eAj();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (apO()) {
                ezL().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eyn() {
            if (apO()) {
                ezL().esM();
            }
        }

        private void eAj() {
            synchronized (this) {
                if (!this.SU) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b = com.facebook.common.references.a.b(this.pPr);
                    try {
                        ezL().f(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.SU) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pPr;
                    this.pPr = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean apO() {
            boolean z = true;
            synchronized (this) {
                if (this.SU) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pPr;
                    this.pPr = null;
                    this.SU = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
