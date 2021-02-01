package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class ai implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.a.f pGo;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLo;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.pLo = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pGo = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am ezi = akVar.ezi();
        com.facebook.imagepipeline.request.b eAf = akVar.ezh().eAf();
        a aVar = new a(kVar, ezi, akVar.getId(), eAf, akVar);
        if (eAf instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eAf, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.pLo.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Rv;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am pMK;
        private final com.facebook.imagepipeline.request.b pML;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pMM;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pMN;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pMO;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pMM = null;
            this.mStatus = 0;
            this.pMN = false;
            this.pMO = false;
            this.pMK = amVar;
            this.mRequestId = str;
            this.pML = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezo() {
                    a.this.ezR();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Qj(i)) {
                    e(null, i);
                    return;
                }
                return;
            }
            c(aVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            E(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void exW() {
            ezR();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.Rv) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pMM;
                    this.pMM = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pMN = true;
                    boolean ezQ = ezQ();
                    com.facebook.common.references.a.c(aVar2);
                    if (ezQ) {
                        ezO();
                    }
                }
            }
        }

        private void ezO() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pMM;
                        i = a.this.mStatus;
                        a.this.pMM = null;
                        a.this.pMN = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.ezP();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezP() {
            boolean ezQ;
            synchronized (this) {
                this.pMO = false;
                ezQ = ezQ();
            }
            if (ezQ) {
                ezO();
            }
        }

        private synchronized boolean ezQ() {
            boolean z = true;
            synchronized (this) {
                if (this.Rv || !this.pMN || this.pMO || !com.facebook.common.references.a.a(this.pMM)) {
                    z = false;
                } else {
                    this.pMO = true;
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
            this.pMK.ht(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.pMK.b(this.mRequestId, "PostprocessorProducer", a(this.pMK, this.mRequestId, this.pML));
                e(aVar2, i);
            } catch (Exception e) {
                this.pMK.a(this.mRequestId, "PostprocessorProducer", e, a(this.pMK, this.mRequestId, this.pML));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.Zu(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pML.a(dVar.eyg(), ai.this.pGo);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.f.d(a2, cVar.eyh(), dVar.eyk(), dVar.eyl()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean Qj = Qj(i);
            if ((!Qj && !isClosed()) || (Qj && apL())) {
                ezu().g(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (apL()) {
                ezu().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezR() {
            if (apL()) {
                ezu().esv();
            }
        }

        private synchronized boolean isClosed() {
            return this.Rv;
        }

        private boolean apL() {
            boolean z = true;
            synchronized (this) {
                if (this.Rv) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pMM;
                    this.pMM = null;
                    this.Rv = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes5.dex */
    class c extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Qk(i)) {
                ezu().g(aVar, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Rv;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pMM;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Rv = false;
            this.pMM = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezo() {
                    if (b.this.apL()) {
                        b.this.ezu().esv();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Qk(i)) {
                p(aVar);
                ezS();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (apL()) {
                ezu().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void exW() {
            if (apL()) {
                ezu().esv();
            }
        }

        private void ezS() {
            synchronized (this) {
                if (!this.Rv) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = com.facebook.common.references.a.b(this.pMM);
                    try {
                        ezu().g(b2, 0);
                    } finally {
                        com.facebook.common.references.a.c(b2);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.Rv) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pMM;
                    this.pMM = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean apL() {
            boolean z = true;
            synchronized (this) {
                if (this.Rv) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pMM;
                    this.pMM = null;
                    this.Rv = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
