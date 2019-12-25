package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes9.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lLp;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lQz;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lQz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lLp = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am doY = akVar.doY();
        com.facebook.imagepipeline.request.a dpW = akVar.doX().dpW();
        a aVar = new a(kVar, doY, akVar.getId(), dpW, akVar);
        if (dpW instanceof com.facebook.imagepipeline.request.b) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.b) dpW, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lQz.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final am lRU;
        private final com.facebook.imagepipeline.request.a lRV;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lRW;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lRX;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lRY;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vf;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.a aVar, ak akVar) {
            super(kVar);
            this.lRW = null;
            this.mStatus = 0;
            this.lRX = false;
            this.lRY = false;
            this.lRU = amVar;
            this.mRequestId = str;
            this.lRV = aVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dlt() {
                    a.this.dpH();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Iv(i)) {
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
        protected void dnL() {
            dpH();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vf) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lRW;
                    this.lRW = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lRX = true;
                    boolean dpG = dpG();
                    com.facebook.common.references.a.c(aVar2);
                    if (dpG) {
                        dpE();
                    }
                }
            }
        }

        private void dpE() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lRW;
                        i = a.this.mStatus;
                        a.this.lRW = null;
                        a.this.lRX = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dpF();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dpF() {
            boolean dpG;
            synchronized (this) {
                this.lRY = false;
                dpG = dpG();
            }
            if (dpG) {
                dpE();
            }
        }

        private synchronized boolean dpG() {
            boolean z = true;
            synchronized (this) {
                if (this.vf || !this.lRX || this.lRY || !com.facebook.common.references.a.a(this.lRW)) {
                    z = false;
                } else {
                    this.lRY = true;
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
            this.lRU.fc(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lRU.a(this.mRequestId, "PostprocessorProducer", a(this.lRU, this.mRequestId, this.lRV));
                e(aVar2, i);
            } catch (Exception e) {
                this.lRU.a(this.mRequestId, "PostprocessorProducer", e, a(this.lRU, this.mRequestId, this.lRV));
                F(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.a aVar) {
            if (amVar.OF(str)) {
                return ImmutableMap.of("Postprocessor", aVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.lRV.a(dVar.dnV(), ai.this.lLp);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dnW(), dVar.dnZ(), dVar.doa()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Iv = Iv(i);
            if ((!Iv && !isClosed()) || (Iv && LR())) {
                dpj().g(aVar, i);
            }
        }

        private void F(Throwable th) {
            if (LR()) {
                dpj().D(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dpH() {
            if (LR()) {
                dpj().dim();
            }
        }

        private synchronized boolean isClosed() {
            return this.vf;
        }

        private boolean LR() {
            boolean z = true;
            synchronized (this) {
                if (this.vf) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lRW;
                    this.lRW = null;
                    this.vf = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes9.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Iw(i)) {
                dpj().g(aVar, i);
            }
        }
    }

    /* loaded from: classes9.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.c {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lRW;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vf;

        private b(a aVar, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(aVar);
            this.vf = false;
            this.lRW = null;
            bVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dlt() {
                    if (b.this.LR()) {
                        b.this.dpj().dim();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Iw(i)) {
                p(aVar);
                dpI();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (LR()) {
                dpj().D(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dnL() {
            if (LR()) {
                dpj().dim();
            }
        }

        private void dpI() {
            synchronized (this) {
                if (!this.vf) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lRW);
                    try {
                        dpj().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vf) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lRW;
                    this.lRW = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean LR() {
            boolean z = true;
            synchronized (this) {
                if (this.vf) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lRW;
                    this.lRW = null;
                    this.vf = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
