package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f oJx;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oOJ;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.oOJ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oJx = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am eng = akVar.eng();
        com.facebook.imagepipeline.request.b eog = akVar.enf().eog();
        a aVar = new a(kVar, eng, akVar.getId(), eog, akVar);
        if (eog instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eog, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.oOJ.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean QC;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am oQe;
        private final com.facebook.imagepipeline.request.b oQf;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oQg;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean oQh;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean oQi;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.oQg = null;
            this.mStatus = 0;
            this.oQh = false;
            this.oQi = false;
            this.oQe = amVar;
            this.mRequestId = str;
            this.oQf = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ejw() {
                    a.this.enP();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Pn(i)) {
                    e(null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            G(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void elP() {
            enP();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.QC) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.oQg;
                    this.oQg = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.oQh = true;
                    boolean enO = enO();
                    com.facebook.common.references.a.c(aVar2);
                    if (enO) {
                        enM();
                    }
                }
            }
        }

        private void enM() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.oQg;
                        i = a.this.mStatus;
                        a.this.oQg = null;
                        a.this.oQh = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.enN();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void enN() {
            boolean enO;
            synchronized (this) {
                this.oQi = false;
                enO = enO();
            }
            if (enO) {
                enM();
            }
        }

        private synchronized boolean enO() {
            boolean z = true;
            synchronized (this) {
                if (this.QC || !this.oQh || this.oQi || !com.facebook.common.references.a.a(this.oQg)) {
                    z = false;
                } else {
                    this.oQi = true;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
            if (!f(aVar.get())) {
                e(aVar, i);
                return;
            }
            this.oQe.gX(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.oQe.a(this.mRequestId, "PostprocessorProducer", a(this.oQe, this.mRequestId, this.oQf));
                e(aVar2, i);
            } catch (Exception e) {
                this.oQe.a(this.mRequestId, "PostprocessorProducer", e, a(this.oQe, this.mRequestId, this.oQf));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.XI(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.oQf.a(dVar.elZ(), ai.this.oJx);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a2, cVar.ema(), dVar.emd(), dVar.eme()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Pn = Pn(i);
            if ((!Pn && !isClosed()) || (Pn && amP())) {
                enr().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (amP()) {
                enr().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void enP() {
            if (amP()) {
                enr().egk();
            }
        }

        private synchronized boolean isClosed() {
            return this.QC;
        }

        private boolean amP() {
            boolean z = true;
            synchronized (this) {
                if (this.QC) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oQg;
                    this.oQg = null;
                    this.QC = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes18.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Po(i)) {
                enr().h(aVar, i);
            }
        }
    }

    /* loaded from: classes18.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean QC;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oQg;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.QC = false;
            this.oQg = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ejw() {
                    if (b.this.amP()) {
                        b.this.enr().egk();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Po(i)) {
                p(aVar);
                enQ();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (amP()) {
                enr().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void elP() {
            if (amP()) {
                enr().egk();
            }
        }

        private void enQ() {
            synchronized (this) {
                if (!this.QC) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.oQg);
                    try {
                        enr().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.QC) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.oQg;
                    this.oQg = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean amP() {
            boolean z = true;
            synchronized (this) {
                if (this.QC) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oQg;
                    this.oQg = null;
                    this.QC = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
