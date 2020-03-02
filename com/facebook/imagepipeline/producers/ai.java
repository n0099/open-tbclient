package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lPO;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVb;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lVb = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lPO = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dry = akVar.dry();
        com.facebook.imagepipeline.request.b dsz = akVar.drx().dsz();
        a aVar = new a(kVar, dry, akVar.getId(), dsz, akVar);
        if (dsz instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dsz, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lVb.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lWA;
        private final am lWw;
        private final com.facebook.imagepipeline.request.b lWx;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lWy;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lWz;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vA;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.lWy = null;
            this.mStatus = 0;
            this.lWz = false;
            this.lWA = false;
            this.lWw = amVar;
            this.mRequestId = str;
            this.lWx = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnP() {
                    a.this.dsh();
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
        protected void dqh() {
            dsh();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lWy;
                    this.lWy = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lWz = true;
                    boolean dsg = dsg();
                    com.facebook.common.references.a.c(aVar2);
                    if (dsg) {
                        dse();
                    }
                }
            }
        }

        private void dse() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lWy;
                        i = a.this.mStatus;
                        a.this.lWy = null;
                        a.this.lWz = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dsf();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsf() {
            boolean dsg;
            synchronized (this) {
                this.lWA = false;
                dsg = dsg();
            }
            if (dsg) {
                dse();
            }
        }

        private synchronized boolean dsg() {
            boolean z = true;
            synchronized (this) {
                if (this.vA || !this.lWz || this.lWA || !com.facebook.common.references.a.a(this.lWy)) {
                    z = false;
                } else {
                    this.lWA = true;
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
            this.lWw.fm(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lWw.a(this.mRequestId, "PostprocessorProducer", a(this.lWw, this.mRequestId, this.lWx));
                e(aVar2, i);
            } catch (Exception e) {
                this.lWw.a(this.mRequestId, "PostprocessorProducer", e, a(this.lWw, this.mRequestId, this.lWx));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Pd(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.lWx.a(dVar.dqr(), ai.this.lPO);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dqs(), dVar.dqv(), dVar.dqw()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean IJ = IJ(i);
            if ((!IJ && !isClosed()) || (IJ && OD())) {
                drJ().g(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (OD()) {
                drJ().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsh() {
            if (OD()) {
                drJ().dkE();
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lWy;
                    this.lWy = null;
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
                drJ().g(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lWy;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vA;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.vA = false;
            this.lWy = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnP() {
                    if (b.this.OD()) {
                        b.this.drJ().dkE();
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
                dsi();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (OD()) {
                drJ().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqh() {
            if (OD()) {
                drJ().dkE();
            }
        }

        private void dsi() {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lWy);
                    try {
                        drJ().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lWy;
                    this.lWy = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lWy;
                    this.lWy = null;
                    this.vA = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
