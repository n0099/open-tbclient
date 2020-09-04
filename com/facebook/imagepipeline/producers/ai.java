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
    private final com.facebook.imagepipeline.b.f nsO;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nyd;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.nyd = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nsO = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dVy = akVar.dVy();
        com.facebook.imagepipeline.request.b dWx = akVar.dVx().dWx();
        a aVar = new a(kVar, dVy, akVar.getId(), dWx, akVar);
        if (dWx instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dWx, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.nyd.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean PQ;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nzA;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nzB;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nzC;
        private final am nzy;
        private final com.facebook.imagepipeline.request.b nzz;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.nzA = null;
            this.mStatus = 0;
            this.nzB = false;
            this.nzC = false;
            this.nzy = amVar;
            this.mRequestId = str;
            this.nzz = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRP() {
                    a.this.dWh();
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
        protected void dUi() {
            dWh();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.PQ) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nzA;
                    this.nzA = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.nzB = true;
                    boolean dWg = dWg();
                    com.facebook.common.references.a.c(aVar2);
                    if (dWg) {
                        dWe();
                    }
                }
            }
        }

        private void dWe() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.nzA;
                        i = a.this.mStatus;
                        a.this.nzA = null;
                        a.this.nzB = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dWf();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dWf() {
            boolean dWg;
            synchronized (this) {
                this.nzC = false;
                dWg = dWg();
            }
            if (dWg) {
                dWe();
            }
        }

        private synchronized boolean dWg() {
            boolean z = true;
            synchronized (this) {
                if (this.PQ || !this.nzB || this.nzC || !com.facebook.common.references.a.a(this.nzA)) {
                    z = false;
                } else {
                    this.nzC = true;
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
            this.nzy.go(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.nzy.a(this.mRequestId, "PostprocessorProducer", a(this.nzy, this.mRequestId, this.nzz));
                e(aVar2, i);
            } catch (Exception e) {
                this.nzy.a(this.mRequestId, "PostprocessorProducer", e, a(this.nzy, this.mRequestId, this.nzz));
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
            com.facebook.common.references.a<Bitmap> a = this.nzz.a(dVar.dUs(), ai.this.nsO);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dUt(), dVar.dUw(), dVar.dUx()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Ml = Ml(i);
            if ((!Ml && !isClosed()) || (Ml && ahA())) {
                dVJ().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (ahA()) {
                dVJ().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dWh() {
            if (ahA()) {
                dVJ().dOD();
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nzA;
                    this.nzA = null;
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
                dVJ().h(aVar, i);
            }
        }
    }

    /* loaded from: classes8.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean PQ;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nzA;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.PQ = false;
            this.nzA = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRP() {
                    if (b.this.ahA()) {
                        b.this.dVJ().dOD();
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
                dWi();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (ahA()) {
                dVJ().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dUi() {
            if (ahA()) {
                dVJ().dOD();
            }
        }

        private void dWi() {
            synchronized (this) {
                if (!this.PQ) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.nzA);
                    try {
                        dVJ().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.PQ) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nzA;
                    this.nzA = com.facebook.common.references.a.b(aVar);
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nzA;
                    this.nzA = null;
                    this.PQ = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
