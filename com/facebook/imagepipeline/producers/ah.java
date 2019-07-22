package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjj;
    private final com.facebook.imagepipeline.b.f kkC;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.kjj = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kkC = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al cKC = ajVar.cKC();
        com.facebook.imagepipeline.request.b cLy = ajVar.cKB().cLy();
        a aVar = new a(jVar, cKC, ajVar.getId(), cLy, ajVar);
        if (cLy instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cLy, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.kjj.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean FD;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kjX;
        private final al kkD;
        private final String kkE;
        private final com.facebook.imagepipeline.request.b kkF;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> kkG;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kkH;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kkI;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.kkG = null;
            this.kjX = false;
            this.kkH = false;
            this.kkI = false;
            this.kkD = alVar;
            this.kkE = str;
            this.kkF = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKI() {
                    a.this.cLj();
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
        protected void cJv() {
            cLj();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.FD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.kkG;
                    this.kkG = com.facebook.common.references.a.b(aVar);
                    this.kjX = z;
                    this.kkH = true;
                    boolean cLi = cLi();
                    com.facebook.common.references.a.c(aVar2);
                    if (cLi) {
                        cLg();
                    }
                }
            }
        }

        private void cLg() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.kkG;
                        z = a.this.kjX;
                        a.this.kkG = null;
                        a.this.kkH = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.cLh();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cLh() {
            boolean cLi;
            synchronized (this) {
                this.kkI = false;
                cLi = cLi();
            }
            if (cLi) {
                cLg();
            }
        }

        private synchronized boolean cLi() {
            boolean z = true;
            synchronized (this) {
                if (this.FD || !this.kkH || this.kkI || !com.facebook.common.references.a.a(this.kkG)) {
                    z = false;
                } else {
                    this.kkI = true;
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
            this.kkD.eA(this.kkE, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.kkD.a(this.kkE, "PostprocessorProducer", a(this.kkD, this.kkE, this.kkF));
                d(aVar2, z);
            } catch (Exception e) {
                this.kkD.a(this.kkE, "PostprocessorProducer", e, a(this.kkD, this.kkE, this.kkF));
                D(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.HP(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.kkF.a(cVar.cJD(), ah.this.kkC);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.c(a, bVar.cJE(), cVar.cJG()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && AI())) {
                cKO().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (AI()) {
                cKO().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cLj() {
            if (AI()) {
                cKO().cEA();
            }
        }

        private synchronized boolean isClosed() {
            return this.FD;
        }

        private boolean AI() {
            boolean z = true;
            synchronized (this) {
                if (this.FD) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.kkG;
                    this.kkG = null;
                    this.FD = true;
                    com.facebook.common.references.a.c(aVar);
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
                cKO().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean FD;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> kkG;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.FD = false;
            this.kkG = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKI() {
                    if (b.this.AI()) {
                        b.this.cKO().cEA();
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
                cLk();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (AI()) {
                cKO().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cJv() {
            if (AI()) {
                cKO().cEA();
            }
        }

        private void cLk() {
            synchronized (this) {
                if (!this.FD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.kkG);
                    try {
                        cKO().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.FD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.kkG;
                    this.kkG = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean AI() {
            boolean z = true;
            synchronized (this) {
                if (this.FD) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.kkG;
                    this.kkG = null;
                    this.FD = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
