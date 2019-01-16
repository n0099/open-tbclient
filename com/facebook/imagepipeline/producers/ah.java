package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> itW;
    private final com.facebook.imagepipeline.b.f ivp;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.itW = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.ivp = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al caq = ajVar.caq();
        com.facebook.imagepipeline.request.b cbm = ajVar.cap().cbm();
        a aVar = new a(jVar, caq, ajVar.getId(), cbm, ajVar);
        if (cbm instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cbm, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.itW.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HL;
        private final String ZV;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean iuK;
        private final al ivq;
        private final com.facebook.imagepipeline.request.b ivr;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> ivs;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ivt;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ivu;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.ivs = null;
            this.iuK = false;
            this.ivt = false;
            this.ivu = false;
            this.ivq = alVar;
            this.ZV = str;
            this.ivr = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void caw() {
                    a.this.caX();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (!com.facebook.common.references.a.a(aVar)) {
                if (z) {
                    d((com.facebook.common.references.a<com.facebook.imagepipeline.f.b>) null, true);
                    return;
                }
                return;
            }
            b(aVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bZk() {
            caX();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.ivs;
                    this.ivs = com.facebook.common.references.a.b(aVar);
                    this.iuK = z;
                    this.ivt = true;
                    boolean caW = caW();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (caW) {
                        caU();
                    }
                }
            }
        }

        private void caU() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.ivs;
                        z = a.this.iuK;
                        a.this.ivs = null;
                        a.this.ivt = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.caV();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void caV() {
            boolean caW;
            synchronized (this) {
                this.ivu = false;
                caW = caW();
            }
            if (caW) {
                caU();
            }
        }

        private synchronized boolean caW() {
            boolean z = true;
            synchronized (this) {
                if (this.HL || !this.ivt || this.ivu || !com.facebook.common.references.a.a(this.ivs)) {
                    z = false;
                } else {
                    this.ivu = true;
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
            if (!f(aVar.get())) {
                d(aVar, z);
                return;
            }
            this.ivq.de(this.ZV, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.ivq.a(this.ZV, "PostprocessorProducer", a(this.ivq, this.ZV, this.ivr));
                d(aVar2, z);
            } catch (Exception e) {
                this.ivq.a(this.ZV, "PostprocessorProducer", e, a(this.ivq, this.ZV, this.ivr));
                D(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.zE(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.ivr.a(cVar.bZs(), ah.this.ivp);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.f.c(a, bVar.bZt(), cVar.bZv()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && bVg())) {
                caC().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (bVg()) {
                caC().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void caX() {
            if (bVg()) {
                caC().bUx();
            }
        }

        private synchronized boolean isClosed() {
            return this.HL;
        }

        private boolean bVg() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.ivs;
                    this.ivs = null;
                    this.HL = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }

    /* loaded from: classes2.dex */
    class c extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private c(a aVar) {
            super(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (z) {
                caC().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HL;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> ivs;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HL = false;
            this.ivs = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void caw() {
                    if (b.this.bVg()) {
                        b.this.caC().bUx();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if (z) {
                k(aVar);
                caY();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (bVg()) {
                caC().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bZk() {
            if (bVg()) {
                caC().bUx();
            }
        }

        private void caY() {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.ivs);
                    try {
                        caC().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.ivs;
                    this.ivs = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean bVg() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.ivs;
                    this.ivs = null;
                    this.HL = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
