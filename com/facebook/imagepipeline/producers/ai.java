package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes4.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f mYF;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndT;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mYF = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dJp = akVar.dJp();
        com.facebook.imagepipeline.request.b dKo = akVar.dJo().dKo();
        a aVar = new a(kVar, dJp, akVar.getId(), dKo, akVar);
        if (dKo instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dKo, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.ndT.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Pi;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am nfp;
        private final com.facebook.imagepipeline.request.b nfq;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nfr;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nfs;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nft;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.nfr = null;
            this.mStatus = 0;
            this.nfs = false;
            this.nft = false;
            this.nfp = amVar;
            this.mRequestId = str;
            this.nfq = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFG() {
                    a.this.dJY();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (JH(i)) {
                    e(null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            H(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dHZ() {
            dJY();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nfr;
                    this.nfr = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.nfs = true;
                    boolean dJX = dJX();
                    com.facebook.common.references.a.c(aVar2);
                    if (dJX) {
                        dJV();
                    }
                }
            }
        }

        private void dJV() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.nfr;
                        i = a.this.mStatus;
                        a.this.nfr = null;
                        a.this.nfs = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dJW();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJW() {
            boolean dJX;
            synchronized (this) {
                this.nft = false;
                dJX = dJX();
            }
            if (dJX) {
                dJV();
            }
        }

        private synchronized boolean dJX() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi || !this.nfs || this.nft || !com.facebook.common.references.a.a(this.nfr)) {
                    z = false;
                } else {
                    this.nft = true;
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
            this.nfp.fW(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.nfp.a(this.mRequestId, "PostprocessorProducer", a(this.nfp, this.mRequestId, this.nfq));
                e(aVar2, i);
            } catch (Exception e) {
                this.nfp.a(this.mRequestId, "PostprocessorProducer", e, a(this.nfp, this.mRequestId, this.nfq));
                H(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.RB(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.nfq.a(dVar.dIj(), ai.this.mYF);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dIk(), dVar.dIn(), dVar.dIo()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean JH = JH(i);
            if ((!JH && !isClosed()) || (JH && abo())) {
                dJA().h(aVar, i);
            }
        }

        private void H(Throwable th) {
            if (abo()) {
                dJA().F(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJY() {
            if (abo()) {
                dJA().dCt();
            }
        }

        private synchronized boolean isClosed() {
            return this.Pi;
        }

        private boolean abo() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nfr;
                    this.nfr = null;
                    this.Pi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes4.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!JI(i)) {
                dJA().h(aVar, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Pi;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nfr;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Pi = false;
            this.nfr = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFG() {
                    if (b.this.abo()) {
                        b.this.dJA().dCt();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!JI(i)) {
                p(aVar);
                dJZ();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            if (abo()) {
                dJA().F(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dHZ() {
            if (abo()) {
                dJA().dCt();
            }
        }

        private void dJZ() {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.nfr);
                    try {
                        dJA().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nfr;
                    this.nfr = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean abo() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nfr;
                    this.nfr = null;
                    this.Pi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
