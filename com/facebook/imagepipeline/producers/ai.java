package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f oUt;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oZF;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.oZF = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oUt = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am eqU = akVar.eqU();
        com.facebook.imagepipeline.request.b erT = akVar.eqT().erT();
        a aVar = new a(kVar, eqU, akVar.getId(), erT, akVar);
        if (erT instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) erT, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.oZF.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean QD;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am pbc;
        private final com.facebook.imagepipeline.request.b pbd;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> pbe;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pbf;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pbg;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pbe = null;
            this.mStatus = 0;
            this.pbf = false;
            this.pbg = false;
            this.pbc = amVar;
            this.mRequestId = str;
            this.pbd = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enk() {
                    a.this.erD();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Ql(i)) {
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
        protected void epE() {
            erD();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.QD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.pbe;
                    this.pbe = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pbf = true;
                    boolean erC = erC();
                    com.facebook.common.references.a.c(aVar2);
                    if (erC) {
                        erA();
                    }
                }
            }
        }

        private void erA() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pbe;
                        i = a.this.mStatus;
                        a.this.pbe = null;
                        a.this.pbf = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.erB();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void erB() {
            boolean erC;
            synchronized (this) {
                this.pbg = false;
                erC = erC();
            }
            if (erC) {
                erA();
            }
        }

        private synchronized boolean erC() {
            boolean z = true;
            synchronized (this) {
                if (this.QD || !this.pbf || this.pbg || !com.facebook.common.references.a.a(this.pbe)) {
                    z = false;
                } else {
                    this.pbg = true;
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
            this.pbc.gZ(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.pbc.a(this.mRequestId, "PostprocessorProducer", a(this.pbc, this.mRequestId, this.pbd));
                e(aVar2, i);
            } catch (Exception e) {
                this.pbc.a(this.mRequestId, "PostprocessorProducer", e, a(this.pbc, this.mRequestId, this.pbd));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.XX(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pbd.a(dVar.epO(), ai.this.oUt);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a2, cVar.epP(), dVar.epS(), dVar.epT()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Ql = Ql(i);
            if ((!Ql && !isClosed()) || (Ql && aoH())) {
                erf().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (aoH()) {
                erf().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void erD() {
            if (aoH()) {
                erf().ejX();
            }
        }

        private synchronized boolean isClosed() {
            return this.QD;
        }

        private boolean aoH() {
            boolean z = true;
            synchronized (this) {
                if (this.QD) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.pbe;
                    this.pbe = null;
                    this.QD = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes15.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Qm(i)) {
                erf().h(aVar, i);
            }
        }
    }

    /* loaded from: classes15.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean QD;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> pbe;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.QD = false;
            this.pbe = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enk() {
                    if (b.this.aoH()) {
                        b.this.erf().ejX();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Qm(i)) {
                p(aVar);
                erE();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (aoH()) {
                erf().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void epE() {
            if (aoH()) {
                erf().ejX();
            }
        }

        private void erE() {
            synchronized (this) {
                if (!this.QD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.pbe);
                    try {
                        erf().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.QD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.pbe;
                    this.pbe = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean aoH() {
            boolean z = true;
            synchronized (this) {
                if (this.QD) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.pbe;
                    this.pbe = null;
                    this.QD = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
