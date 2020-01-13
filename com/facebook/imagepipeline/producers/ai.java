package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.b.f lPa;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUn;
    private final Executor mExecutor;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lPa = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dqi = akVar.dqi();
        com.facebook.imagepipeline.request.b drj = akVar.dqh().drj();
        a aVar = new a(kVar, dqi, akVar.getId(), drj, akVar);
        if (drj instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) drj, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.lUn.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final am lVI;
        private final com.facebook.imagepipeline.request.b lVJ;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lVK;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lVL;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean lVM;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean vi;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.lVK = null;
            this.mStatus = 0;
            this.lVL = false;
            this.lVM = false;
            this.lVI = amVar;
            this.mRequestId = str;
            this.lVJ = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmy() {
                    a.this.dqR();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (IE(i)) {
                    e(null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void doR() {
            dqR();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.vi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lVK;
                    this.lVK = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    this.mStatus = i;
                    this.lVL = true;
                    boolean dqQ = dqQ();
                    com.facebook.common.references.a.c(aVar2);
                    if (dqQ) {
                        dqO();
                    }
                }
            }
        }

        private void dqO() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.lVK;
                        i = a.this.mStatus;
                        a.this.lVK = null;
                        a.this.lVL = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dqP();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqP() {
            boolean dqQ;
            synchronized (this) {
                this.lVM = false;
                dqQ = dqQ();
            }
            if (dqQ) {
                dqO();
            }
        }

        private synchronized boolean dqQ() {
            boolean z = true;
            synchronized (this) {
                if (this.vi || !this.lVL || this.lVM || !com.facebook.common.references.a.a(this.lVK)) {
                    z = false;
                } else {
                    this.lVM = true;
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
            this.lVI.fe(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.lVI.a(this.mRequestId, "PostprocessorProducer", a(this.lVI, this.mRequestId, this.lVJ));
                e(aVar2, i);
            } catch (Exception e) {
                this.lVI.a(this.mRequestId, "PostprocessorProducer", e, a(this.lVI, this.mRequestId, this.lVJ));
                F(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.OQ(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.lVJ.a(dVar.dpb(), ai.this.lPa);
            try {
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(a, cVar.dpc(), dVar.dpf(), dVar.dpg()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean IE = IE(i);
            if ((!IE && !isClosed()) || (IE && Mn())) {
                dqt().g(aVar, i);
            }
        }

        private void F(Throwable th) {
            if (Mn()) {
                dqt().D(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqR() {
            if (Mn()) {
                dqt().djn();
            }
        }

        private synchronized boolean isClosed() {
            return this.vi;
        }

        private boolean Mn() {
            boolean z = true;
            synchronized (this) {
                if (this.vi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lVK;
                    this.lVK = null;
                    this.vi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes10.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IF(i)) {
                dqt().g(aVar, i);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> lVK;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean vi;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.vi = false;
            this.lVK = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmy() {
                    if (b.this.Mn()) {
                        b.this.dqt().djn();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!IF(i)) {
                p(aVar);
                dqS();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (Mn()) {
                dqt().D(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void doR() {
            if (Mn()) {
                dqt().djn();
            }
        }

        private void dqS() {
            synchronized (this) {
                if (!this.vi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lVK);
                    try {
                        dqt().g(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.vi) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.lVK;
                    this.lVK = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Mn() {
            boolean z = true;
            synchronized (this) {
                if (this.vi) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.lVK;
                    this.lVK = null;
                    this.vi = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
