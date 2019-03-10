package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJY;
    private final com.facebook.imagepipeline.b.f jLr;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.jJY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jLr = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al czF = ajVar.czF();
        com.facebook.imagepipeline.request.b cAB = ajVar.czE().cAB();
        a aVar = new a(jVar, czF, ajVar.getId(), cAB, ajVar);
        if (cAB instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cAB, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.jJY.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HM;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean jKM;
        private final al jLs;
        private final String jLt;
        private final com.facebook.imagepipeline.request.b jLu;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> jLv;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean jLw;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean jLx;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.jLv = null;
            this.jKM = false;
            this.jLw = false;
            this.jLx = false;
            this.jLs = alVar;
            this.jLt = str;
            this.jLu = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czL() {
                    a.this.cAm();
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
        protected void cyz() {
            cAm();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HM) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.jLv;
                    this.jLv = com.facebook.common.references.a.b(aVar);
                    this.jKM = z;
                    this.jLw = true;
                    boolean cAl = cAl();
                    com.facebook.common.references.a.c(aVar2);
                    if (cAl) {
                        cAj();
                    }
                }
            }
        }

        private void cAj() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.jLv;
                        z = a.this.jKM;
                        a.this.jLv = null;
                        a.this.jLw = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.cAk();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cAk() {
            boolean cAl;
            synchronized (this) {
                this.jLx = false;
                cAl = cAl();
            }
            if (cAl) {
                cAj();
            }
        }

        private synchronized boolean cAl() {
            boolean z = true;
            synchronized (this) {
                if (this.HM || !this.jLw || this.jLx || !com.facebook.common.references.a.a(this.jLv)) {
                    z = false;
                } else {
                    this.jLx = true;
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
            this.jLs.em(this.jLt, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.jLs.a(this.jLt, "PostprocessorProducer", a(this.jLs, this.jLt, this.jLu));
                d(aVar2, z);
            } catch (Exception e) {
                this.jLs.a(this.jLt, "PostprocessorProducer", e, a(this.jLs, this.jLt, this.jLu));
                E(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.FK(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.jLu.a(cVar.cyH(), ah.this.jLr);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.c(a, bVar.cyI(), cVar.cyK()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && zf())) {
                czR().e(aVar, z);
            }
        }

        private void E(Throwable th) {
            if (zf()) {
                czR().C(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cAm() {
            if (zf()) {
                czR().ctF();
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.jLv;
                    this.jLv = null;
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
                czR().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HM;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> jLv;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HM = false;
            this.jLv = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czL() {
                    if (b.this.zf()) {
                        b.this.czR().ctF();
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
                cAn();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (zf()) {
                czR().C(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cyz() {
            if (zf()) {
                czR().ctF();
            }
        }

        private void cAn() {
            synchronized (this) {
                if (!this.HM) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.jLv);
                    try {
                        czR().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HM) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.jLv;
                    this.jLv = com.facebook.common.references.a.b(aVar);
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
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.jLv;
                    this.jLv = null;
                    this.HM = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
