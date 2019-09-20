package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kmM;
    private final com.facebook.imagepipeline.b.f kof;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.kmM = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kof = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al cLL = ajVar.cLL();
        com.facebook.imagepipeline.request.b cMH = ajVar.cLK().cMH();
        a aVar = new a(jVar, cLL, ajVar.getId(), cMH, ajVar);
        if (cMH instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cMH, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.kmM.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean FD;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean knA;
        private final al kog;
        private final String koh;
        private final com.facebook.imagepipeline.request.b koi;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> koj;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kok;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kol;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.koj = null;
            this.knA = false;
            this.kok = false;
            this.kol = false;
            this.kog = alVar;
            this.koh = str;
            this.koi = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLR() {
                    a.this.cMs();
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
        protected void cKE() {
            cMs();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.FD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.koj;
                    this.koj = com.facebook.common.references.a.b(aVar);
                    this.knA = z;
                    this.kok = true;
                    boolean cMr = cMr();
                    com.facebook.common.references.a.c(aVar2);
                    if (cMr) {
                        cMp();
                    }
                }
            }
        }

        private void cMp() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.koj;
                        z = a.this.knA;
                        a.this.koj = null;
                        a.this.kok = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.cMq();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cMq() {
            boolean cMr;
            synchronized (this) {
                this.kol = false;
                cMr = cMr();
            }
            if (cMr) {
                cMp();
            }
        }

        private synchronized boolean cMr() {
            boolean z = true;
            synchronized (this) {
                if (this.FD || !this.kok || this.kol || !com.facebook.common.references.a.a(this.koj)) {
                    z = false;
                } else {
                    this.kol = true;
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
            this.kog.eB(this.koh, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.kog.a(this.koh, "PostprocessorProducer", a(this.kog, this.koh, this.koi));
                d(aVar2, z);
            } catch (Exception e) {
                this.kog.a(this.koh, "PostprocessorProducer", e, a(this.kog, this.koh, this.koi));
                D(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.Iq(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.koi.a(cVar.cKM(), ah.this.kof);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.c(a, bVar.cKN(), cVar.cKP()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && AM())) {
                cLX().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (AM()) {
                cLX().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cMs() {
            if (AM()) {
                cLX().cFJ();
            }
        }

        private synchronized boolean isClosed() {
            return this.FD;
        }

        private boolean AM() {
            boolean z = true;
            synchronized (this) {
                if (this.FD) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.koj;
                    this.koj = null;
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
                cLX().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean FD;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> koj;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.FD = false;
            this.koj = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLR() {
                    if (b.this.AM()) {
                        b.this.cLX().cFJ();
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
                cMt();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (AM()) {
                cLX().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cKE() {
            if (AM()) {
                cLX().cFJ();
            }
        }

        private void cMt() {
            synchronized (this) {
                if (!this.FD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.koj);
                    try {
                        cLX().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.FD) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.koj;
                    this.koj = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean AM() {
            boolean z = true;
            synchronized (this) {
                if (this.FD) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.koj;
                    this.koj = null;
                    this.FD = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
