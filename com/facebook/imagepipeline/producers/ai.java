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
    private final com.facebook.imagepipeline.b.f muv;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mzI;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.mzI = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.muv = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> cVar;
        am dBx = akVar.dBx();
        com.facebook.imagepipeline.request.b dCw = akVar.dBw().dCw();
        a aVar = new a(kVar, dBx, akVar.getId(), dCw, akVar);
        if (dCw instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) dCw, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.mzI.c(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean OE;
        private final am mBd;
        private final com.facebook.imagepipeline.request.b mBe;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mBf;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mBh;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mBi;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.mBf = null;
            this.mStatus = 0;
            this.mBh = false;
            this.mBi = false;
            this.mBd = amVar;
            this.mRequestId = str;
            this.mBe = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxO() {
                    a.this.dCg();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (If(i)) {
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
        protected void dAh() {
            dCg();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            synchronized (this) {
                if (!this.OE) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mBf;
                    this.mBf = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.mBh = true;
                    boolean dCf = dCf();
                    com.facebook.common.references.a.c(aVar2);
                    if (dCf) {
                        dCd();
                    }
                }
            }
        }

        private void dCd() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.mBf;
                        i = a.this.mStatus;
                        a.this.mBf = null;
                        a.this.mBh = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.dCe();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dCe() {
            boolean dCf;
            synchronized (this) {
                this.mBi = false;
                dCf = dCf();
            }
            if (dCf) {
                dCd();
            }
        }

        private synchronized boolean dCf() {
            boolean z = true;
            synchronized (this) {
                if (this.OE || !this.mBh || this.mBi || !com.facebook.common.references.a.a(this.mBf)) {
                    z = false;
                } else {
                    this.mBi = true;
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
            this.mBd.fK(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.mBd.a(this.mRequestId, "PostprocessorProducer", a(this.mBd, this.mRequestId, this.mBe));
                e(aVar2, i);
            } catch (Exception e) {
                this.mBd.a(this.mRequestId, "PostprocessorProducer", e, a(this.mBd, this.mRequestId, this.mBe));
                I(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Qd(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.g.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.g.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.imagepipeline.g.c cVar) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            com.facebook.common.references.a<Bitmap> a = this.mBe.a(dVar.dAr(), ai.this.muv);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.g.d(a, cVar.dAs(), dVar.dAv(), dVar.dAw()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            boolean If = If(i);
            if ((!If && !isClosed()) || (If && Zg())) {
                dBI().h(aVar, i);
            }
        }

        private void I(Throwable th) {
            if (Zg()) {
                dBI().G(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dCg() {
            if (Zg()) {
                dBI().duA();
            }
        }

        private synchronized boolean isClosed() {
            return this.OE;
        }

        private boolean Zg() {
            boolean z = true;
            synchronized (this) {
                if (this.OE) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mBf;
                    this.mBf = null;
                    this.OE = true;
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
            if (!Ig(i)) {
                dBI().h(aVar, i);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean OE;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.g.c> mBf;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.OE = false;
            this.mBf = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxO() {
                    if (b.this.Zg()) {
                        b.this.dBI().duA();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (!Ig(i)) {
                p(aVar);
                dCh();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (Zg()) {
                dBI().G(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void dAh() {
            if (Zg()) {
                dBI().duA();
            }
        }

        private void dCh() {
            synchronized (this) {
                if (!this.OE) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(this.mBf);
                    try {
                        dBI().h(b, 0);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            synchronized (this) {
                if (!this.OE) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar2 = this.mBf;
                    this.mBf = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Zg() {
            boolean z = true;
            synchronized (this) {
                if (this.OE) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar = this.mBf;
                    this.mBf = null;
                    this.OE = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
