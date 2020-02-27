package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lPM;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUZ;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lUZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lPM = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am drw = akVar.drw();
        com.facebook.imagepipeline.request.b dsx = akVar.drv().dsx();
        a aVar = new a(kVar, drw, akVar.getId(), dsx, akVar);
        if (dsx instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dsx, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lUZ.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final am lWu;
        private final com.facebook.imagepipeline.request.b lWv;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lWw;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lWx;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lWy;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vA;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.lWw = null;
            this.mStatus = 0;
            this.lWx = false;
            this.lWy = false;
            this.lWu = amVar;
            this.mRequestId = str;
            this.lWv = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnN() {
                    a.this.dsf();
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
        protected void dqf() {
            dsf();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lWw;
                    this.lWw = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lWx = true;
                    boolean dse = dse();
                    com.facebook.common.references.a.c(aVar2);
                    if (dse) {
                        dsc();
                    }
                }
            }
        }

        private void dsc() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lWw;
                        i = a.this.mStatus;
                        a.this.lWw = null;
                        a.this.lWx = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dsd();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsd() {
            boolean dse;
            synchronized (this) {
                this.lWy = false;
                dse = dse();
            }
            if (dse) {
                dsc();
            }
        }

        private synchronized boolean dse() {
            boolean z = true;
            synchronized (this) {
                if (this.vA || !this.lWx || this.lWy || !com.facebook.common.references.a.a(this.lWw)) {
                    z = false;
                } else {
                    this.lWy = true;
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
            this.lWu.fm(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lWu.a(this.mRequestId, "PostprocessorProducer", a(this.lWu, this.mRequestId, this.lWv));
                e(aVar2, i);
            } catch (Exception e) {
                this.lWu.a(this.mRequestId, "PostprocessorProducer", e, a(this.lWu, this.mRequestId, this.lWv));
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
            com.facebook.common.references.a<Bitmap> a = this.lWv.a(dVar.dqp(), ai.this.lPM);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dqq(), dVar.dqt(), dVar.dqu()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean IJ = IJ(i);
            if ((!IJ && !isClosed()) || (IJ && OB())) {
                drH().g(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (OB()) {
                drH().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsf() {
            if (OB()) {
                drH().dkC();
            }
        }

        private synchronized boolean isClosed() {
            return this.vA;
        }

        private boolean OB() {
            boolean z = true;
            synchronized (this) {
                if (this.vA) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lWw;
                    this.lWw = null;
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
                drH().g(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lWw;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vA;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.vA = false;
            this.lWw = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnN() {
                    if (b.this.OB()) {
                        b.this.drH().dkC();
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
                dsg();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (OB()) {
                drH().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dqf() {
            if (OB()) {
                drH().dkC();
            }
        }

        private void dsg() {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lWw);
                    try {
                        drH().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vA) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lWw;
                    this.lWw = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean OB() {
            boolean z = true;
            synchronized (this) {
                if (this.vA) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lWw;
                    this.lWw = null;
                    this.vA = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
