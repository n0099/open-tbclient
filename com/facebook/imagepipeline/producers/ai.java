package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f mtl;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> myy;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.myy = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mtl = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dBj = akVar.dBj();
        com.facebook.imagepipeline.request.b dCi = akVar.dBi().dCi();
        a aVar = new a(kVar, dBj, akVar.getId(), dCi, akVar);
        if (dCi instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dCi, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.myy.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean OE;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am mzT;
        private final com.facebook.imagepipeline.request.b mzU;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mzV;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mzW;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mzX;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.mzV = null;
            this.mStatus = 0;
            this.mzW = false;
            this.mzX = false;
            this.mzT = amVar;
            this.mRequestId = str;
            this.mzU = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxA() {
                    a.this.dBS();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Id(i)) {
                    e(null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            I(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dzT() {
            dBS();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.OE) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mzV;
                    this.mzV = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.mzW = true;
                    boolean dBR = dBR();
                    com.facebook.common.references.a.c(aVar2);
                    if (dBR) {
                        dBP();
                    }
                }
            }
        }

        private void dBP() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.mzV;
                        i = a.this.mStatus;
                        a.this.mzV = null;
                        a.this.mzW = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dBQ();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dBQ() {
            boolean dBR;
            synchronized (this) {
                this.mzX = false;
                dBR = dBR();
            }
            if (dBR) {
                dBP();
            }
        }

        private synchronized boolean dBR() {
            boolean z = true;
            synchronized (this) {
                if (this.OE || !this.mzW || this.mzX || !com.facebook.common.references.a.a(this.mzV)) {
                    z = false;
                } else {
                    this.mzX = true;
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
            this.mzT.fK(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.mzT.a(this.mRequestId, "PostprocessorProducer", a(this.mzT, this.mRequestId, this.mzU));
                e(aVar2, i);
            } catch (Exception e) {
                this.mzT.a(this.mRequestId, "PostprocessorProducer", e, a(this.mzT, this.mRequestId, this.mzU));
                I(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Qc(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.mzU.a(dVar.dAd(), ai.this.mtl);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dAe(), dVar.dAh(), dVar.dAi()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Id = Id(i);
            if ((!Id && !isClosed()) || (Id && Zg())) {
                dBu().h(aVar, i);
            }
        }

        private void I(Throwable th) {
            if (Zg()) {
                dBu().G(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dBS() {
            if (Zg()) {
                dBu().dum();
            }
        }

        private synchronized boolean isClosed() {
            return this.OE;
        }

        private boolean Zg() {
            boolean z = true;
            synchronized (this) {
                if (this.OE) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mzV;
                    this.mzV = null;
                    this.OE = true;
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
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Ie(i)) {
                dBu().h(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean OE;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mzV;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.OE = false;
            this.mzV = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxA() {
                    if (b.this.Zg()) {
                        b.this.dBu().dum();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Ie(i)) {
                p(aVar);
                dBT();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (Zg()) {
                dBu().G(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dzT() {
            if (Zg()) {
                dBu().dum();
            }
        }

        private void dBT() {
            synchronized (this) {
                if (!this.OE) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.mzV);
                    try {
                        dBu().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.OE) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mzV;
                    this.mzV = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Zg() {
            boolean z = true;
            synchronized (this) {
                if (this.OE) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mzV;
                    this.mzV = null;
                    this.OE = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
