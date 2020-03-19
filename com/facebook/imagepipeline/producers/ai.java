package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lRF;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lWS;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lWS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lRF = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am drW = akVar.drW();
        com.facebook.imagepipeline.request.b dsX = akVar.drV().dsX();
        a aVar = new a(kVar, drW, akVar.getId(), dsX, akVar);
        if (dsX instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dsX, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lWS.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final am lYn;
        private final com.facebook.imagepipeline.request.b lYo;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lYp;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lYq;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lYr;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vA;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.lYp = null;
            this.mStatus = 0;
            this.lYq = false;
            this.lYr = false;
            this.lYn = amVar;
            this.mRequestId = str;
            this.lYo = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void don() {
                    a.this.dsF();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (IP(i)) {
                    e(null, i);
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
        protected void dqF() {
            dsF();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lYp;
                    this.lYp = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lYq = true;
                    boolean dsE = dsE();
                    com.facebook.common.references.a.c(aVar2);
                    if (dsE) {
                        dsC();
                    }
                }
            }
        }

        private void dsC() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lYp;
                        i = a.this.mStatus;
                        a.this.lYp = null;
                        a.this.lYq = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dsD();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsD() {
            boolean dsE;
            synchronized (this) {
                this.lYr = false;
                dsE = dsE();
            }
            if (dsE) {
                dsC();
            }
        }

        private synchronized boolean dsE() {
            boolean z = true;
            synchronized (this) {
                if (this.vA || !this.lYq || this.lYr || !com.facebook.common.references.a.a(this.lYp)) {
                    z = false;
                } else {
                    this.lYr = true;
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
            this.lYn.fk(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lYn.a(this.mRequestId, "PostprocessorProducer", a(this.lYn, this.mRequestId, this.lYo));
                e(aVar2, i);
            } catch (Exception e) {
                this.lYn.a(this.mRequestId, "PostprocessorProducer", e, a(this.lYn, this.mRequestId, this.lYo));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Pe(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.lYo.a(dVar.dqP(), ai.this.lRF);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dqQ(), dVar.dqT(), dVar.dqU()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean IP = IP(i);
            if ((!IP && !isClosed()) || (IP && OG())) {
                dsh().g(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (OG()) {
                dsh().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsF() {
            if (OG()) {
                dsh().dlc();
            }
        }

        private synchronized boolean isClosed() {
            return this.vA;
        }

        private boolean OG() {
            boolean z = true;
            synchronized (this) {
                if (this.vA) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lYp;
                    this.lYp = null;
                    this.vA = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes12.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IQ(i)) {
                dsh().g(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lYp;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vA;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.vA = false;
            this.lYp = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void don() {
                    if (b.this.OG()) {
                        b.this.dsh().dlc();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IQ(i)) {
                p(aVar);
                dsG();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (OG()) {
                dsh().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqF() {
            if (OG()) {
                dsh().dlc();
            }
        }

        private void dsG() {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lYp);
                    try {
                        dsh().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lYp;
                    this.lYp = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean OG() {
            boolean z = true;
            synchronized (this) {
                if (this.vA) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lYp;
                    this.lYp = null;
                    this.vA = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
