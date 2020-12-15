package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes15.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.a.f pju;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> poz;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.poz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pju = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am ewx = akVar.ewx();
        com.facebook.imagepipeline.request.b exu = akVar.eww().exu();
        a aVar = new a(kVar, ewx, akVar.getId(), exu, akVar);
        if (exu instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) exu, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.poz.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Rw;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am ppW;
        private final com.facebook.imagepipeline.request.b ppX;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> ppY;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ppZ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pqa;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.ppY = null;
            this.mStatus = 0;
            this.ppZ = false;
            this.pqa = false;
            this.ppW = amVar;
            this.mRequestId = str;
            this.ppX = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewD() {
                    a.this.exg();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Rh(i)) {
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
        protected void evk() {
            exg();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.Rw) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.ppY;
                    this.ppY = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.ppZ = true;
                    boolean exf = exf();
                    com.facebook.common.references.a.c(aVar2);
                    if (exf) {
                        exd();
                    }
                }
            }
        }

        private void exd() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.ppY;
                        i = a.this.mStatus;
                        a.this.ppY = null;
                        a.this.ppZ = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.exe();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exe() {
            boolean exf;
            synchronized (this) {
                this.pqa = false;
                exf = exf();
            }
            if (exf) {
                exd();
            }
        }

        private synchronized boolean exf() {
            boolean z = true;
            synchronized (this) {
                if (this.Rw || !this.ppZ || this.pqa || !com.facebook.common.references.a.a(this.ppY)) {
                    z = false;
                } else {
                    this.pqa = true;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
            if (!f(aVar.get())) {
                e(aVar, i);
                return;
            }
            this.ppW.hh(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.ppW.a(this.mRequestId, "PostprocessorProducer", a(this.ppW, this.mRequestId, this.ppX));
                e(aVar2, i);
            } catch (Exception e) {
                this.ppW.a(this.mRequestId, "PostprocessorProducer", e, a(this.ppW, this.mRequestId, this.ppX));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Zq(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.ppX.a(dVar.evu(), ai.this.pju);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.f.d(a2, cVar.evv(), dVar.evy(), dVar.evz()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean Rh = Rh(i);
            if ((!Rh && !isClosed()) || (Rh && arP())) {
                ewJ().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (arP()) {
                ewJ().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exg() {
            if (arP()) {
                ewJ().epN();
            }
        }

        private synchronized boolean isClosed() {
            return this.Rw;
        }

        private boolean arP() {
            boolean z = true;
            synchronized (this) {
                if (this.Rw) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.ppY;
                    this.ppY = null;
                    this.Rw = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes15.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Ri(i)) {
                ewJ().h(aVar, i);
            }
        }
    }

    /* loaded from: classes15.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Rw;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> ppY;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Rw = false;
            this.ppY = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewD() {
                    if (b.this.arP()) {
                        b.this.ewJ().epN();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Ri(i)) {
                p(aVar);
                exh();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (arP()) {
                ewJ().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void evk() {
            if (arP()) {
                ewJ().epN();
            }
        }

        private void exh() {
            synchronized (this) {
                if (!this.Rw) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b = com.facebook.common.references.a.b(this.ppY);
                    try {
                        ewJ().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.Rw) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.ppY;
                    this.ppY = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean arP() {
            boolean z = true;
            synchronized (this) {
                if (this.Rw) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.ppY;
                    this.ppY = null;
                    this.Rw = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
