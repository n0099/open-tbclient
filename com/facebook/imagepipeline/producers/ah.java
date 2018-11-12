package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iit;
    private final com.facebook.imagepipeline.b.f ijM;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.iit = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.ijM = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al bWM = ajVar.bWM();
        com.facebook.imagepipeline.request.b bXI = ajVar.bWL().bXI();
        a aVar = new a(jVar, bWM, ajVar.getId(), bXI, ajVar);
        if (bXI instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) bXI, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.iit.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HL;
        private final String ZM;
        private final al ijN;
        private final com.facebook.imagepipeline.request.b ijO;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> ijP;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ijQ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ijR;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ijh;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.ijP = null;
            this.ijh = false;
            this.ijQ = false;
            this.ijR = false;
            this.ijN = alVar;
            this.ZM = str;
            this.ijO = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWS() {
                    a.this.bXt();
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
        protected void bVG() {
            bXt();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.ijP;
                    this.ijP = com.facebook.common.references.a.b(aVar);
                    this.ijh = z;
                    this.ijQ = true;
                    boolean bXs = bXs();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (bXs) {
                        bXq();
                    }
                }
            }
        }

        private void bXq() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.ijP;
                        z = a.this.ijh;
                        a.this.ijP = null;
                        a.this.ijQ = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.bXr();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXr() {
            boolean bXs;
            synchronized (this) {
                this.ijR = false;
                bXs = bXs();
            }
            if (bXs) {
                bXq();
            }
        }

        private synchronized boolean bXs() {
            boolean z = true;
            synchronized (this) {
                if (this.HL || !this.ijQ || this.ijR || !com.facebook.common.references.a.a(this.ijP)) {
                    z = false;
                } else {
                    this.ijR = true;
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
            this.ijN.cW(this.ZM, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.ijN.a(this.ZM, "PostprocessorProducer", a(this.ijN, this.ZM, this.ijO));
                d(aVar2, z);
            } catch (Exception e) {
                this.ijN.a(this.ZM, "PostprocessorProducer", e, a(this.ijN, this.ZM, this.ijO));
                D(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.yI(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.ijO.a(cVar.bVO(), ah.this.ijM);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.f.c(a, bVar.bVP(), cVar.bVR()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && bRC())) {
                bWY().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (bRC()) {
                bWY().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXt() {
            if (bRC()) {
                bWY().bQT();
            }
        }

        private synchronized boolean isClosed() {
            return this.HL;
        }

        private boolean bRC() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.ijP;
                    this.ijP = null;
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
                bWY().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HL;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> ijP;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HL = false;
            this.ijP = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWS() {
                    if (b.this.bRC()) {
                        b.this.bWY().bQT();
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
                bXu();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (bRC()) {
                bWY().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bVG() {
            if (bRC()) {
                bWY().bQT();
            }
        }

        private void bXu() {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.ijP);
                    try {
                        bWY().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.ijP;
                    this.ijP = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean bRC() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.ijP;
                    this.ijP = null;
                    this.HL = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
