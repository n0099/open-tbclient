package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lZq;
    private final Executor mExecutor;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meH;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lZq = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dtS = akVar.dtS();
        com.facebook.imagepipeline.request.b duR = akVar.dtR().duR();
        a aVar = new a(kVar, dtS, akVar.getId(), duR, akVar);
        if (duR instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) duR, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.meH.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Ox;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am mgc;
        private final com.facebook.imagepipeline.request.b mgd;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mge;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mgf;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mgg;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.mge = null;
            this.mStatus = 0;
            this.mgf = false;
            this.mgg = false;
            this.mgc = amVar;
            this.mRequestId = str;
            this.mgd = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqi() {
                    a.this.duB();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Hr(i)) {
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
        protected void dsB() {
            duB();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.Ox) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mge;
                    this.mge = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.mgf = true;
                    boolean duA = duA();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (duA) {
                        duy();
                    }
                }
            }
        }

        private void duy() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.mge;
                        i = a.this.mStatus;
                        a.this.mge = null;
                        a.this.mgf = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.duz();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void duz() {
            boolean duA;
            synchronized (this) {
                this.mgg = false;
                duA = duA();
            }
            if (duA) {
                duy();
            }
        }

        private synchronized boolean duA() {
            boolean z = true;
            synchronized (this) {
                if (this.Ox || !this.mgf || this.mgg || !com.facebook.common.references.a.a(this.mge)) {
                    z = false;
                } else {
                    this.mgg = true;
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
            this.mgc.fi(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.mgc.a(this.mRequestId, "PostprocessorProducer", a(this.mgc, this.mRequestId, this.mgd));
                e(aVar2, i);
            } catch (Exception e) {
                this.mgc.a(this.mRequestId, "PostprocessorProducer", e, a(this.mgc, this.mRequestId, this.mgd));
                I(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Oo(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.mgd.a(dVar.dsL(), ai.this.lZq);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.g.d(a, cVar.dsM(), dVar.dsP(), dVar.dsQ()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Hr = Hr(i);
            if ((!Hr && !isClosed()) || (Hr && Wu())) {
                dud().h(aVar, i);
            }
        }

        private void I(Throwable th) {
            if (Wu()) {
                dud().G(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void duB() {
            if (Wu()) {
                dud().dmT();
            }
        }

        private synchronized boolean isClosed() {
            return this.Ox;
        }

        private boolean Wu() {
            boolean z = true;
            synchronized (this) {
                if (this.Ox) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mge;
                    this.mge = null;
                    this.Ox = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
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
            if (!Hs(i)) {
                dud().h(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Ox;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mge;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Ox = false;
            this.mge = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqi() {
                    if (b.this.Wu()) {
                        b.this.dud().dmT();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Hs(i)) {
                p(aVar);
                duC();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (Wu()) {
                dud().G(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dsB() {
            if (Wu()) {
                dud().dmT();
            }
        }

        private void duC() {
            synchronized (this) {
                if (!this.Ox) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.mge);
                    try {
                        dud().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.Ox) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mge;
                    this.mge = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Wu() {
            boolean z = true;
            synchronized (this) {
                if (this.Ox) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mge;
                    this.mge = null;
                    this.Ox = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
