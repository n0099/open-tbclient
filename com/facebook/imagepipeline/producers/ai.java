package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes25.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f nCM;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nIa;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nCM = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dZw = akVar.dZw();
        com.facebook.imagepipeline.request.b eav = akVar.dZv().eav();
        a aVar = new a(kVar, dZw, akVar.getId(), eav, akVar);
        if (eav instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eav, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.nIa.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Qk;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am nJv;
        private final com.facebook.imagepipeline.request.b nJw;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nJx;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nJy;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nJz;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.nJx = null;
            this.mStatus = 0;
            this.nJy = false;
            this.nJz = false;
            this.nJv = amVar;
            this.mRequestId = str;
            this.nJw = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVN() {
                    a.this.eaf();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (MQ(i)) {
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
        protected void dYg() {
            eaf();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.Qk) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nJx;
                    this.nJx = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.nJy = true;
                    boolean eae = eae();
                    com.facebook.common.references.a.c(aVar2);
                    if (eae) {
                        eac();
                    }
                }
            }
        }

        private void eac() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.nJx;
                        i = a.this.mStatus;
                        a.this.nJx = null;
                        a.this.nJy = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.ead();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ead() {
            boolean eae;
            synchronized (this) {
                this.nJz = false;
                eae = eae();
            }
            if (eae) {
                eac();
            }
        }

        private synchronized boolean eae() {
            boolean z = true;
            synchronized (this) {
                if (this.Qk || !this.nJy || this.nJz || !com.facebook.common.references.a.a(this.nJx)) {
                    z = false;
                } else {
                    this.nJz = true;
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
            this.nJv.gA(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.nJv.a(this.mRequestId, "PostprocessorProducer", a(this.nJv, this.mRequestId, this.nJw));
                e(aVar2, i);
            } catch (Exception e) {
                this.nJv.a(this.mRequestId, "PostprocessorProducer", e, a(this.nJv, this.mRequestId, this.nJw));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Vh(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.nJw.a(dVar.dYq(), ai.this.nCM);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dYr(), dVar.dYu(), dVar.dYv()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean MQ = MQ(i);
            if ((!MQ && !isClosed()) || (MQ && aik())) {
                dZH().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (aik()) {
                dZH().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eaf() {
            if (aik()) {
                dZH().dSB();
            }
        }

        private synchronized boolean isClosed() {
            return this.Qk;
        }

        private boolean aik() {
            boolean z = true;
            synchronized (this) {
                if (this.Qk) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nJx;
                    this.nJx = null;
                    this.Qk = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes25.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!MR(i)) {
                dZH().h(aVar, i);
            }
        }
    }

    /* loaded from: classes25.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Qk;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nJx;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Qk = false;
            this.nJx = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVN() {
                    if (b.this.aik()) {
                        b.this.dZH().dSB();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!MR(i)) {
                p(aVar);
                eag();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (aik()) {
                dZH().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dYg() {
            if (aik()) {
                dZH().dSB();
            }
        }

        private void eag() {
            synchronized (this) {
                if (!this.Qk) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.nJx);
                    try {
                        dZH().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.Qk) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nJx;
                    this.nJx = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean aik() {
            boolean z = true;
            synchronized (this) {
                if (this.Qk) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nJx;
                    this.nJx = null;
                    this.Qk = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
