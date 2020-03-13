package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lPZ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVm;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lVm = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lPZ = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am drz = akVar.drz();
        com.facebook.imagepipeline.request.b dsA = akVar.dry().dsA();
        a aVar = new a(kVar, drz, akVar.getId(), dsA, akVar);
        if (dsA instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dsA, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lVm.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final am lWH;
        private final com.facebook.imagepipeline.request.b lWI;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lWJ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lWK;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lWL;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vA;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.lWJ = null;
            this.mStatus = 0;
            this.lWK = false;
            this.lWL = false;
            this.lWH = amVar;
            this.mRequestId = str;
            this.lWI = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnQ() {
                    a.this.dsi();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (IJ(i)) {
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
        protected void dqi() {
            dsi();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lWJ;
                    this.lWJ = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lWK = true;
                    boolean dsh = dsh();
                    com.facebook.common.references.a.c(aVar2);
                    if (dsh) {
                        dsf();
                    }
                }
            }
        }

        private void dsf() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lWJ;
                        i = a.this.mStatus;
                        a.this.lWJ = null;
                        a.this.lWK = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dsg();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsg() {
            boolean dsh;
            synchronized (this) {
                this.lWL = false;
                dsh = dsh();
            }
            if (dsh) {
                dsf();
            }
        }

        private synchronized boolean dsh() {
            boolean z = true;
            synchronized (this) {
                if (this.vA || !this.lWK || this.lWL || !com.facebook.common.references.a.a(this.lWJ)) {
                    z = false;
                } else {
                    this.lWL = true;
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
            this.lWH.fm(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lWH.a(this.mRequestId, "PostprocessorProducer", a(this.lWH, this.mRequestId, this.lWI));
                e(aVar2, i);
            } catch (Exception e) {
                this.lWH.a(this.mRequestId, "PostprocessorProducer", e, a(this.lWH, this.mRequestId, this.lWI));
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
            com.facebook.common.references.a<Bitmap> a = this.lWI.a(dVar.dqs(), ai.this.lPZ);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dqt(), dVar.dqw(), dVar.dqx()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean IJ = IJ(i);
            if ((!IJ && !isClosed()) || (IJ && OD())) {
                drK().g(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (OD()) {
                drK().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsi() {
            if (OD()) {
                drK().dkF();
            }
        }

        private synchronized boolean isClosed() {
            return this.vA;
        }

        private boolean OD() {
            boolean z = true;
            synchronized (this) {
                if (this.vA) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lWJ;
                    this.lWJ = null;
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
            if (!IK(i)) {
                drK().g(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lWJ;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vA;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.vA = false;
            this.lWJ = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnQ() {
                    if (b.this.OD()) {
                        b.this.drK().dkF();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IK(i)) {
                p(aVar);
                dsj();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (OD()) {
                drK().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqi() {
            if (OD()) {
                drK().dkF();
            }
        }

        private void dsj() {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lWJ);
                    try {
                        drK().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lWJ;
                    this.lWJ = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean OD() {
            boolean z = true;
            synchronized (this) {
                if (this.vA) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lWJ;
                    this.lWJ = null;
                    this.vA = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
