package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes8.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f nsw;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nxL;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.nxL = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nsw = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dVp = akVar.dVp();
        com.facebook.imagepipeline.request.b dWo = akVar.dVo().dWo();
        a aVar = new a(kVar, dVp, akVar.getId(), dWo, akVar);
        if (dWo instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dWo, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.nxL.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean PQ;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am nzg;
        private final com.facebook.imagepipeline.request.b nzh;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nzi;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nzj;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nzk;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.nzi = null;
            this.mStatus = 0;
            this.nzj = false;
            this.nzk = false;
            this.nzg = amVar;
            this.mRequestId = str;
            this.nzh = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRG() {
                    a.this.dVY();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Ml(i)) {
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
        protected void dTZ() {
            dVY();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.PQ) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nzi;
                    this.nzi = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.nzj = true;
                    boolean dVX = dVX();
                    com.facebook.common.references.a.c(aVar2);
                    if (dVX) {
                        dVV();
                    }
                }
            }
        }

        private void dVV() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.nzi;
                        i = a.this.mStatus;
                        a.this.nzi = null;
                        a.this.nzj = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dVW();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVW() {
            boolean dVX;
            synchronized (this) {
                this.nzk = false;
                dVX = dVX();
            }
            if (dVX) {
                dVV();
            }
        }

        private synchronized boolean dVX() {
            boolean z = true;
            synchronized (this) {
                if (this.PQ || !this.nzj || this.nzk || !com.facebook.common.references.a.a(this.nzi)) {
                    z = false;
                } else {
                    this.nzk = true;
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
            this.nzg.gn(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.nzg.a(this.mRequestId, "PostprocessorProducer", a(this.nzg, this.mRequestId, this.nzh));
                e(aVar2, i);
            } catch (Exception e) {
                this.nzg.a(this.mRequestId, "PostprocessorProducer", e, a(this.nzg, this.mRequestId, this.nzh));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.UF(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.nzh.a(dVar.dUj(), ai.this.nsw);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dUk(), dVar.dUn(), dVar.dUo()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Ml = Ml(i);
            if ((!Ml && !isClosed()) || (Ml && ahA())) {
                dVA().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (ahA()) {
                dVA().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVY() {
            if (ahA()) {
                dVA().dOu();
            }
        }

        private synchronized boolean isClosed() {
            return this.PQ;
        }

        private boolean ahA() {
            boolean z = true;
            synchronized (this) {
                if (this.PQ) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nzi;
                    this.nzi = null;
                    this.PQ = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes8.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Mm(i)) {
                dVA().h(aVar, i);
            }
        }
    }

    /* loaded from: classes8.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean PQ;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nzi;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.PQ = false;
            this.nzi = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRG() {
                    if (b.this.ahA()) {
                        b.this.dVA().dOu();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Mm(i)) {
                p(aVar);
                dVZ();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (ahA()) {
                dVA().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dTZ() {
            if (ahA()) {
                dVA().dOu();
            }
        }

        private void dVZ() {
            synchronized (this) {
                if (!this.PQ) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.nzi);
                    try {
                        dVA().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.PQ) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nzi;
                    this.nzi = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ahA() {
            boolean z = true;
            synchronized (this) {
                if (this.PQ) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nzi;
                    this.nzi = null;
                    this.PQ = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
