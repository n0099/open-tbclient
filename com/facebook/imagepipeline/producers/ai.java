package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.b.f mQx;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mVS;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.mVS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mQx = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dGd = akVar.dGd();
        com.facebook.imagepipeline.request.b dHc = akVar.dGc().dHc();
        a aVar = new a(kVar, dGd, akVar.getId(), dHc, akVar);
        if (dHc instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dHc, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.mVS.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Pi;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am mXo;
        private final com.facebook.imagepipeline.request.b mXp;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mXq;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mXr;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mXs;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.mXq = null;
            this.mStatus = 0;
            this.mXr = false;
            this.mXs = false;
            this.mXo = amVar;
            this.mRequestId = str;
            this.mXp = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dCu() {
                    a.this.dGM();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Jm(i)) {
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
        protected void dEN() {
            dGM();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mXq;
                    this.mXq = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.mXr = true;
                    boolean dGL = dGL();
                    com.facebook.common.references.a.c(aVar2);
                    if (dGL) {
                        dGJ();
                    }
                }
            }
        }

        private void dGJ() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.mXq;
                        i = a.this.mStatus;
                        a.this.mXq = null;
                        a.this.mXr = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dGK();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGK() {
            boolean dGL;
            synchronized (this) {
                this.mXs = false;
                dGL = dGL();
            }
            if (dGL) {
                dGJ();
            }
        }

        private synchronized boolean dGL() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi || !this.mXr || this.mXs || !com.facebook.common.references.a.a(this.mXq)) {
                    z = false;
                } else {
                    this.mXs = true;
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
            this.mXo.fU(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.mXo.a(this.mRequestId, "PostprocessorProducer", a(this.mXo, this.mRequestId, this.mXp));
                e(aVar2, i);
            } catch (Exception e) {
                this.mXo.a(this.mRequestId, "PostprocessorProducer", e, a(this.mXo, this.mRequestId, this.mXp));
                I(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.QQ(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.mXp.a(dVar.dEX(), ai.this.mQx);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dEY(), dVar.dFb(), dVar.dFc()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean Jm = Jm(i);
            if ((!Jm && !isClosed()) || (Jm && aam())) {
                dGo().h(aVar, i);
            }
        }

        private void I(Throwable th) {
            if (aam()) {
                dGo().G(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGM() {
            if (aam()) {
                dGo().dzh();
            }
        }

        private synchronized boolean isClosed() {
            return this.Pi;
        }

        private boolean aam() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mXq;
                    this.mXq = null;
                    this.Pi = true;
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
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Jn(i)) {
                dGo().h(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Pi;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mXq;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Pi = false;
            this.mXq = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dCu() {
                    if (b.this.aam()) {
                        b.this.dGo().dzh();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Jn(i)) {
                p(aVar);
                dGN();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (aam()) {
                dGo().G(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dEN() {
            if (aam()) {
                dGo().dzh();
            }
        }

        private void dGN() {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.mXq);
                    try {
                        dGo().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.Pi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mXq;
                    this.mXq = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean aam() {
            boolean z = true;
            synchronized (this) {
                if (this.Pi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mXq;
                    this.mXq = null;
                    this.Pi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
