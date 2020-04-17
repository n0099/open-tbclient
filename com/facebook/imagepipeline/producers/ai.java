package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lZm;
    private final Executor mExecutor;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meD;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.meD = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lZm = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dtU = akVar.dtU();
        com.facebook.imagepipeline.request.b duT = akVar.dtT().duT();
        a aVar = new a(kVar, dtU, akVar.getId(), duT, akVar);
        if (duT instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) duT, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.meD.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Ot;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am mfY;
        private final com.facebook.imagepipeline.request.b mfZ;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mga;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mgb;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mgc;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.mga = null;
            this.mStatus = 0;
            this.mgb = false;
            this.mgc = false;
            this.mfY = amVar;
            this.mRequestId = str;
            this.mfZ = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqk() {
                    a.this.duD();
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
        protected void dsD() {
            duD();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.Ot) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mga;
                    this.mga = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.mgb = true;
                    boolean duC = duC();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (duC) {
                        duA();
                    }
                }
            }
        }

        private void duA() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.mga;
                        i = a.this.mStatus;
                        a.this.mga = null;
                        a.this.mgb = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.duB();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void duB() {
            boolean duC;
            synchronized (this) {
                this.mgc = false;
                duC = duC();
            }
            if (duC) {
                duA();
            }
        }

        private synchronized boolean duC() {
            boolean z = true;
            synchronized (this) {
                if (this.Ot || !this.mgb || this.mgc || !com.facebook.common.references.a.a(this.mga)) {
                    z = false;
                } else {
                    this.mgc = true;
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
            this.mfY.fi(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.mfY.a(this.mRequestId, "PostprocessorProducer", a(this.mfY, this.mRequestId, this.mfZ));
                e(aVar2, i);
            } catch (Exception e) {
                this.mfY.a(this.mRequestId, "PostprocessorProducer", e, a(this.mfY, this.mRequestId, this.mfZ));
                I(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Ol(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.mfZ.a(dVar.dsN(), ai.this.lZm);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.g.d(a, cVar.dsO(), dVar.dsR(), dVar.dsS()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Hr = Hr(i);
            if ((!Hr && !isClosed()) || (Hr && Wv())) {
                duf().h(aVar, i);
            }
        }

        private void I(Throwable th) {
            if (Wv()) {
                duf().G(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void duD() {
            if (Wv()) {
                duf().dmV();
            }
        }

        private synchronized boolean isClosed() {
            return this.Ot;
        }

        private boolean Wv() {
            boolean z = true;
            synchronized (this) {
                if (this.Ot) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mga;
                    this.mga = null;
                    this.Ot = true;
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
                duf().h(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Ot;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mga;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Ot = false;
            this.mga = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqk() {
                    if (b.this.Wv()) {
                        b.this.duf().dmV();
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
                duE();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (Wv()) {
                duf().G(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dsD() {
            if (Wv()) {
                duf().dmV();
            }
        }

        private void duE() {
            synchronized (this) {
                if (!this.Ot) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.mga);
                    try {
                        duf().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.Ot) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mga;
                    this.mga = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Wv() {
            boolean z = true;
            synchronized (this) {
                if (this.Ot) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mga;
                    this.mga = null;
                    this.Ot = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
