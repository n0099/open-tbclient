package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes18.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f oSQ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oYc;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oSQ = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am eqW = akVar.eqW();
        com.facebook.imagepipeline.request.b erV = akVar.eqV().erV();
        a aVar = new a(kVar, eqW, akVar.getId(), erV, akVar);
        if (erV instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) erV, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.oYc.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean QC;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean oZA;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean oZB;
        private final am oZx;
        private final com.facebook.imagepipeline.request.b oZy;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oZz;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.oZz = null;
            this.mStatus = 0;
            this.oZA = false;
            this.oZB = false;
            this.oZx = amVar;
            this.mRequestId = str;
            this.oZy = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enm() {
                    a.this.erF();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (PI(i)) {
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
        protected void epG() {
            erF();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.QC) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.oZz;
                    this.oZz = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.oZA = true;
                    boolean erE = erE();
                    com.facebook.common.references.a.c(aVar2);
                    if (erE) {
                        erC();
                    }
                }
            }
        }

        private void erC() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.oZz;
                        i = a.this.mStatus;
                        a.this.oZz = null;
                        a.this.oZA = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.erD();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void erD() {
            boolean erE;
            synchronized (this) {
                this.oZB = false;
                erE = erE();
            }
            if (erE) {
                erC();
            }
        }

        private synchronized boolean erE() {
            boolean z = true;
            synchronized (this) {
                if (this.QC || !this.oZA || this.oZB || !com.facebook.common.references.a.a(this.oZz)) {
                    z = false;
                } else {
                    this.oZB = true;
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
            this.oZx.gZ(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.oZx.a(this.mRequestId, "PostprocessorProducer", a(this.oZx, this.mRequestId, this.oZy));
                e(aVar2, i);
            } catch (Exception e) {
                this.oZx.a(this.mRequestId, "PostprocessorProducer", e, a(this.oZx, this.mRequestId, this.oZy));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Ym(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.oZy.a(dVar.epQ(), ai.this.oSQ);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a2, cVar.epR(), dVar.epU(), dVar.epV()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean PI = PI(i);
            if ((!PI && !isClosed()) || (PI && apq())) {
                erh().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (apq()) {
                erh().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void erF() {
            if (apq()) {
                erh().ejZ();
            }
        }

        private synchronized boolean isClosed() {
            return this.QC;
        }

        private boolean apq() {
            boolean z = true;
            synchronized (this) {
                if (this.QC) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oZz;
                    this.oZz = null;
                    this.QC = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes18.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!PJ(i)) {
                erh().h(aVar, i);
            }
        }
    }

    /* loaded from: classes18.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean QC;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> oZz;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.QC = false;
            this.oZz = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enm() {
                    if (b.this.apq()) {
                        b.this.erh().ejZ();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!PJ(i)) {
                p(aVar);
                erG();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (apq()) {
                erh().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void epG() {
            if (apq()) {
                erh().ejZ();
            }
        }

        private void erG() {
            synchronized (this) {
                if (!this.QC) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.oZz);
                    try {
                        erh().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.QC) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.oZz;
                    this.oZz = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean apq() {
            boolean z = true;
            synchronized (this) {
                if (this.QC) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.oZz;
                    this.oZz = null;
                    this.QC = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
