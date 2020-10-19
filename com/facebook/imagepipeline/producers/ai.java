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
    private final com.facebook.imagepipeline.b.f nSf;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nXr;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.nXr = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nSf = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am edh = akVar.edh();
        com.facebook.imagepipeline.request.b eeg = akVar.edg().eeg();
        a aVar = new a(kVar, edh, akVar.getId(), eeg, akVar);
        if (eeg instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eeg, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.nXr.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean QB;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am nYM;
        private final com.facebook.imagepipeline.request.b nYN;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nYO;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nYP;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean nYQ;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.nYO = null;
            this.mStatus = 0;
            this.nYP = false;
            this.nYQ = false;
            this.nYM = amVar;
            this.mRequestId = str;
            this.nYN = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZy() {
                    a.this.edQ();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Nw(i)) {
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
        protected void ebR() {
            edQ();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.QB) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nYO;
                    this.nYO = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.nYP = true;
                    boolean edP = edP();
                    com.facebook.common.references.a.c(aVar2);
                    if (edP) {
                        edN();
                    }
                }
            }
        }

        private void edN() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.nYO;
                        i = a.this.mStatus;
                        a.this.nYO = null;
                        a.this.nYP = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.edO();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void edO() {
            boolean edP;
            synchronized (this) {
                this.nYQ = false;
                edP = edP();
            }
            if (edP) {
                edN();
            }
        }

        private synchronized boolean edP() {
            boolean z = true;
            synchronized (this) {
                if (this.QB || !this.nYP || this.nYQ || !com.facebook.common.references.a.a(this.nYO)) {
                    z = false;
                } else {
                    this.nYQ = true;
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
            this.nYM.gH(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.nYM.a(this.mRequestId, "PostprocessorProducer", a(this.nYM, this.mRequestId, this.nYN));
                e(aVar2, i);
            } catch (Exception e) {
                this.nYM.a(this.mRequestId, "PostprocessorProducer", e, a(this.nYM, this.mRequestId, this.nYN));
                G(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.VV(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.nYN.a(dVar.ecb(), ai.this.nSf);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a2, cVar.ecc(), dVar.ecf(), dVar.ecg()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Nw = Nw(i);
            if ((!Nw && !isClosed()) || (Nw && akV())) {
                eds().h(aVar, i);
            }
        }

        private void G(Throwable th) {
            if (akV()) {
                eds().E(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void edQ() {
            if (akV()) {
                eds().dWm();
            }
        }

        private synchronized boolean isClosed() {
            return this.QB;
        }

        private boolean akV() {
            boolean z = true;
            synchronized (this) {
                if (this.QB) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nYO;
                    this.nYO = null;
                    this.QB = true;
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
            if (!Nx(i)) {
                eds().h(aVar, i);
            }
        }
    }

    /* loaded from: classes18.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean QB;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> nYO;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.QB = false;
            this.nYO = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZy() {
                    if (b.this.akV()) {
                        b.this.eds().dWm();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Nx(i)) {
                p(aVar);
                edR();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (akV()) {
                eds().E(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void ebR() {
            if (akV()) {
                eds().dWm();
            }
        }

        private void edR() {
            synchronized (this) {
                if (!this.QB) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.nYO);
                    try {
                        eds().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.QB) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.nYO;
                    this.nYO = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean akV() {
            boolean z = true;
            synchronized (this) {
                if (this.QB) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.nYO;
                    this.nYO = null;
                    this.QB = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
