package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lPf;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUs;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lPf = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dqk = akVar.dqk();
        com.facebook.imagepipeline.request.b drl = akVar.dqj().drl();
        a aVar = new a(kVar, dqk, akVar.getId(), drl, akVar);
        if (drl instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) drl, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lUs.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final am lVN;
        private final com.facebook.imagepipeline.request.b lVO;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lVP;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lVQ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lVR;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vi;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.lVP = null;
            this.mStatus = 0;
            this.lVQ = false;
            this.lVR = false;
            this.lVN = amVar;
            this.mRequestId = str;
            this.lVO = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmA() {
                    a.this.dqT();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (IE(i)) {
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
        protected void doT() {
            dqT();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lVP;
                    this.lVP = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lVQ = true;
                    boolean dqS = dqS();
                    com.facebook.common.references.a.c(aVar2);
                    if (dqS) {
                        dqQ();
                    }
                }
            }
        }

        private void dqQ() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lVP;
                        i = a.this.mStatus;
                        a.this.lVP = null;
                        a.this.lVQ = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dqR();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqR() {
            boolean dqS;
            synchronized (this) {
                this.lVR = false;
                dqS = dqS();
            }
            if (dqS) {
                dqQ();
            }
        }

        private synchronized boolean dqS() {
            boolean z = true;
            synchronized (this) {
                if (this.vi || !this.lVQ || this.lVR || !com.facebook.common.references.a.a(this.lVP)) {
                    z = false;
                } else {
                    this.lVR = true;
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
            this.lVN.fe(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lVN.a(this.mRequestId, "PostprocessorProducer", a(this.lVN, this.mRequestId, this.lVO));
                e(aVar2, i);
            } catch (Exception e) {
                this.lVN.a(this.mRequestId, "PostprocessorProducer", e, a(this.lVN, this.mRequestId, this.lVO));
                F(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.OQ(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.lVO.a(dVar.dpd(), ai.this.lPf);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dpe(), dVar.dph(), dVar.dpi()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean IE = IE(i);
            if ((!IE && !isClosed()) || (IE && Mn())) {
                dqv().g(aVar, i);
            }
        }

        private void F(Throwable th) {
            if (Mn()) {
                dqv().D(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqT() {
            if (Mn()) {
                dqv().djp();
            }
        }

        private synchronized boolean isClosed() {
            return this.vi;
        }

        private boolean Mn() {
            boolean z = true;
            synchronized (this) {
                if (this.vi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lVP;
                    this.lVP = null;
                    this.vi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes10.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IF(i)) {
                dqv().g(aVar, i);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lVP;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vi;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.vi = false;
            this.lVP = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmA() {
                    if (b.this.Mn()) {
                        b.this.dqv().djp();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IF(i)) {
                p(aVar);
                dqU();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (Mn()) {
                dqv().D(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void doT() {
            if (Mn()) {
                dqv().djp();
            }
        }

        private void dqU() {
            synchronized (this) {
                if (!this.vi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lVP);
                    try {
                        dqv().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lVP;
                    this.lVP = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Mn() {
            boolean z = true;
            synchronized (this) {
                if (this.vi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lVP;
                    this.lVP = null;
                    this.vi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
