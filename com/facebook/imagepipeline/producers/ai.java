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
    private final com.facebook.imagepipeline.b.f mYH;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndV;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.ndV = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mYH = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dJq = akVar.dJq();
        com.facebook.imagepipeline.request.b dKp = akVar.dJp().dKp();
        a aVar = new a(kVar, dJq, akVar.getId(), dKp, akVar);
        if (dKp instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dKp, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.ndV.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Pi;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am nfr;
        private final com.facebook.imagepipeline.request.b nfs;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nft;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nfu;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nfv;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.nft = null;
            this.mStatus = 0;
            this.nfu = false;
            this.nfv = false;
            this.nfr = amVar;
            this.mRequestId = str;
            this.nfs = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFH() {
                    a.this.dJZ();
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
        protected void dIa() {
            dJZ();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nft;
                    this.nft = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.nfu = true;
                    boolean dJY = dJY();
                    com.facebook.common.references.a.c(aVar2);
                    if (dJY) {
                        dJW();
                    }
                }
            }
        }

        private void dJW() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.nft;
                        i = a.this.mStatus;
                        a.this.nft = null;
                        a.this.nfu = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dJX();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJX() {
            boolean dJY;
            synchronized (this) {
                this.nfv = false;
                dJY = dJY();
            }
            if (dJY) {
                dJW();
            }
        }

        private synchronized boolean dJY() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi || !this.nfu || this.nfv || !com.facebook.common.references.a.a(this.nft)) {
                    z = false;
                } else {
                    this.nfv = true;
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
            this.nfr.fW(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.nfr.a(this.mRequestId, "PostprocessorProducer", a(this.nfr, this.mRequestId, this.nfs));
                e(aVar2, i);
            } catch (Exception e) {
                this.nfr.a(this.mRequestId, "PostprocessorProducer", e, a(this.nfr, this.mRequestId, this.nfs));
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
            com.facebook.common.references.a<Bitmap> a = this.nfs.a(dVar.dIk(), ai.this.mYH);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dIl(), dVar.dIo(), dVar.dIp()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean JH = JH(i);
            if ((!JH && !isClosed()) || (JH && abo())) {
                dJB().h(aVar, i);
            }
        }

        private void H(Throwable th) {
            if (abo()) {
                dJB().F(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJZ() {
            if (abo()) {
                dJB().dCu();
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nft;
                    this.nft = null;
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
                dJB().h(aVar, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Pi;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nft;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Pi = false;
            this.nft = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFH() {
                    if (b.this.abo()) {
                        b.this.dJB().dCu();
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
                dKa();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            if (abo()) {
                dJB().F(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dIa() {
            if (abo()) {
                dJB().dCu();
            }
        }

        private void dKa() {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.nft);
                    try {
                        dJB().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nft;
                    this.nft = com.facebook.common.references.a.b(aVar);
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nft;
                    this.nft = null;
                    this.Pi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
