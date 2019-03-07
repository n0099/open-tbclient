package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJF;
    private final com.facebook.imagepipeline.b.f jKY;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.jJF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jKY = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al czv = ajVar.czv();
        com.facebook.imagepipeline.request.b cAr = ajVar.czu().cAr();
        a aVar = new a(jVar, czv, ajVar.getId(), cAr, ajVar);
        if (cAr instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cAr, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.jJF.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HM;
        private final al jKZ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean jKt;
        private final String jLa;
        private final com.facebook.imagepipeline.request.b jLb;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> jLc;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean jLd;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean jLe;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.jLc = null;
            this.jKt = false;
            this.jLd = false;
            this.jLe = false;
            this.jKZ = alVar;
            this.jLa = str;
            this.jLb = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czB() {
                    a.this.cAc();
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
        protected void B(Throwable th) {
            E(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cyp() {
            cAc();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HM) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.jLc;
                    this.jLc = com.facebook.common.references.a.b(aVar);
                    this.jKt = z;
                    this.jLd = true;
                    boolean cAb = cAb();
                    com.facebook.common.references.a.c(aVar2);
                    if (cAb) {
                        czZ();
                    }
                }
            }
        }

        private void czZ() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.jLc;
                        z = a.this.jKt;
                        a.this.jLc = null;
                        a.this.jLd = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.cAa();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cAa() {
            boolean cAb;
            synchronized (this) {
                this.jLe = false;
                cAb = cAb();
            }
            if (cAb) {
                czZ();
            }
        }

        private synchronized boolean cAb() {
            boolean z = true;
            synchronized (this) {
                if (this.HM || !this.jLd || this.jLe || !com.facebook.common.references.a.a(this.jLc)) {
                    z = false;
                } else {
                    this.jLe = true;
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
            this.jKZ.em(this.jLa, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.jKZ.a(this.jLa, "PostprocessorProducer", a(this.jKZ, this.jLa, this.jLb));
                d(aVar2, z);
            } catch (Exception e) {
                this.jKZ.a(this.jLa, "PostprocessorProducer", e, a(this.jKZ, this.jLa, this.jLb));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.FH(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.jLb.a(cVar.cyx(), ah.this.jKY);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.c(a, bVar.cyy(), cVar.cyA()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && zf())) {
                czH().e(aVar, z);
            }
        }

        private void E(Throwable th) {
            if (zf()) {
                czH().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cAc() {
            if (zf()) {
                czH().ctv();
            }
        }

        private synchronized boolean isClosed() {
            return this.HM;
        }

        private boolean zf() {
            boolean z = true;
            synchronized (this) {
                if (this.HM) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.jLc;
                    this.jLc = null;
                    this.HM = true;
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
                czH().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HM;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> jLc;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HM = false;
            this.jLc = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czB() {
                    if (b.this.zf()) {
                        b.this.czH().ctv();
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
                cAd();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (zf()) {
                czH().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cyp() {
            if (zf()) {
                czH().ctv();
            }
        }

        private void cAd() {
            synchronized (this) {
                if (!this.HM) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.jLc);
                    try {
                        czH().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HM) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.jLc;
                    this.jLc = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean zf() {
            boolean z = true;
            synchronized (this) {
                if (this.HM) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.jLc;
                    this.jLc = null;
                    this.HM = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
