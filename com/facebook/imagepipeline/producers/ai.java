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
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pBf;
    private final com.facebook.imagepipeline.a.f pwf;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.pBf = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pwf = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am ewQ = akVar.ewQ();
        com.facebook.imagepipeline.request.b exN = akVar.ewP().exN();
        a aVar = new a(kVar, ewQ, akVar.getId(), exN, akVar);
        if (exN instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) exN, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.pBf.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Rx;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am pCB;
        private final com.facebook.imagepipeline.request.b pCC;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pCD;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pCE;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pCF;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pCD = null;
            this.mStatus = 0;
            this.pCE = false;
            this.pCF = false;
            this.pCB = amVar;
            this.mRequestId = str;
            this.pCC = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewW() {
                    a.this.exz();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (PO(i)) {
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
        protected void evD() {
            exz();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.Rx) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pCD;
                    this.pCD = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pCE = true;
                    boolean exy = exy();
                    com.facebook.common.references.a.c(aVar2);
                    if (exy) {
                        exw();
                    }
                }
            }
        }

        private void exw() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pCD;
                        i = a.this.mStatus;
                        a.this.pCD = null;
                        a.this.pCE = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.exx();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exx() {
            boolean exy;
            synchronized (this) {
                this.pCF = false;
                exy = exy();
            }
            if (exy) {
                exw();
            }
        }

        private synchronized boolean exy() {
            boolean z = true;
            synchronized (this) {
                if (this.Rx || !this.pCE || this.pCF || !com.facebook.common.references.a.a(this.pCD)) {
                    z = false;
                } else {
                    this.pCF = true;
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
            this.pCB.hm(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.pCB.b(this.mRequestId, "PostprocessorProducer", a(this.pCB, this.mRequestId, this.pCC));
                e(aVar2, i);
            } catch (Exception e) {
                this.pCB.a(this.mRequestId, "PostprocessorProducer", e, a(this.pCB, this.mRequestId, this.pCC));
                F(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Ys(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pCC.a(dVar.evN(), ai.this.pwf);
            try {
                return com.facebook.common.references.a.f(new com.facebook.imagepipeline.f.d(a2, cVar.evO(), dVar.evR(), dVar.evS()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean PO = PO(i);
            if ((!PO && !isClosed()) || (PO && apn())) {
                exc().g(aVar, i);
            }
        }

        private void F(Throwable th) {
            if (apn()) {
                exc().D(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exz() {
            if (apn()) {
                exc().eqc();
            }
        }

        private synchronized boolean isClosed() {
            return this.Rx;
        }

        private boolean apn() {
            boolean z = true;
            synchronized (this) {
                if (this.Rx) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pCD;
                    this.pCD = null;
                    this.Rx = true;
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
            if (!PP(i)) {
                exc().g(aVar, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Rx;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pCD;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Rx = false;
            this.pCD = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewW() {
                    if (b.this.apn()) {
                        b.this.exc().eqc();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!PP(i)) {
                p(aVar);
                exA();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (apn()) {
                exc().D(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void evD() {
            if (apn()) {
                exc().eqc();
            }
        }

        private void exA() {
            synchronized (this) {
                if (!this.Rx) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = com.facebook.common.references.a.b(this.pCD);
                    try {
                        exc().g(b2, 0);
                    } finally {
                        com.facebook.common.references.a.c(b2);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.Rx) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pCD;
                    this.pCD = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean apn() {
            boolean z = true;
            synchronized (this) {
                if (this.Rx) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pCD;
                    this.pCD = null;
                    this.Rx = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
