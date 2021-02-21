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
    private final com.facebook.imagepipeline.a.f pGO;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLO;

    public ai(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, com.facebook.imagepipeline.a.f fVar, Executor executor) {
        this.pLO = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pGO = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> cVar;
        am ezq = akVar.ezq();
        com.facebook.imagepipeline.request.b eAn = akVar.ezp().eAn();
        a aVar = new a(kVar, ezq, akVar.getId(), eAn, akVar);
        if (eAn instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) eAn, akVar);
        } else {
            cVar = new c(aVar);
        }
        this.pLO.a(cVar, akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Rv;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;
        private final am pNk;
        private final com.facebook.imagepipeline.request.b pNl;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pNm;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pNn;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean pNo;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, am amVar, String str, com.facebook.imagepipeline.request.b bVar, ak akVar) {
            super(kVar);
            this.pNm = null;
            this.mStatus = 0;
            this.pNn = false;
            this.pNo = false;
            this.pNk = amVar;
            this.mRequestId = str;
            this.pNl = bVar;
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezw() {
                    a.this.ezZ();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (Qk(i)) {
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
        protected void eye() {
            ezZ();
        }

        private void c(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            synchronized (this) {
                if (!this.Rv) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pNm;
                    this.pNm = com.facebook.common.references.a.b(aVar);
                    this.mStatus = i;
                    this.pNn = true;
                    boolean ezY = ezY();
                    com.facebook.common.references.a.c(aVar2);
                    if (ezY) {
                        ezW();
                    }
                }
            }
        }

        private void ezW() {
            ai.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ai.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    int i;
                    synchronized (a.this) {
                        aVar = a.this.pNm;
                        i = a.this.mStatus;
                        a.this.pNm = null;
                        a.this.pNn = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.d(aVar, i);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.ezX();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezX() {
            boolean ezY;
            synchronized (this) {
                this.pNo = false;
                ezY = ezY();
            }
            if (ezY) {
                ezW();
            }
        }

        private synchronized boolean ezY() {
            boolean z = true;
            synchronized (this) {
                if (this.Rv || !this.pNn || this.pNo || !com.facebook.common.references.a.a(this.pNm)) {
                    z = false;
                } else {
                    this.pNo = true;
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
            this.pNk.hv(this.mRequestId, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.pNk.b(this.mRequestId, "PostprocessorProducer", a(this.pNk, this.mRequestId, this.pNl));
                e(aVar2, i);
            } catch (Exception e) {
                this.pNk.a(this.mRequestId, "PostprocessorProducer", e, a(this.pNk, this.mRequestId, this.pNl));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(am amVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (amVar.ZG(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.f.d;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.imagepipeline.f.c cVar) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            com.facebook.common.references.a<Bitmap> a2 = this.pNl.a(dVar.eyo(), ai.this.pGO);
            try {
                return com.facebook.common.references.a.e(new com.facebook.imagepipeline.f.d(a2, cVar.eyp(), dVar.eys(), dVar.eyt()));
            } finally {
                com.facebook.common.references.a.c(a2);
            }
        }

        private void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            boolean Qk = Qk(i);
            if ((!Qk && !isClosed()) || (Qk && apL())) {
                ezC().g(aVar, i);
            }
        }

        private void E(Throwable th) {
            if (apL()) {
                ezC().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezZ() {
            if (apL()) {
                ezC().esD();
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pNm;
                    this.pNm = null;
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
            if (!Ql(i)) {
                ezC().g(aVar, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Rv;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.c> pNm;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, ak akVar) {
            super(aVar);
            this.Rv = false;
            this.pNm = null;
            cVar.a(this);
            akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ai.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezw() {
                    if (b.this.apL()) {
                        b.this.ezC().esD();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (!Ql(i)) {
                p(aVar);
                eAa();
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (apL()) {
                ezC().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void eye() {
            if (apL()) {
                ezC().esD();
            }
        }

        private void eAa() {
            synchronized (this) {
                if (!this.Rv) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> b2 = com.facebook.common.references.a.b(this.pNm);
                    try {
                        ezC().g(b2, 0);
                    } finally {
                        com.facebook.common.references.a.c(b2);
                    }
                }
            }
        }

        private void p(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            synchronized (this) {
                if (!this.Rv) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar2 = this.pNm;
                    this.pNm = com.facebook.common.references.a.b(aVar);
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar = this.pNm;
                    this.pNm = null;
                    this.Rv = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
