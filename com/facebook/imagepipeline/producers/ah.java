package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kbZ;
    private final com.facebook.imagepipeline.b.f kds;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.kbZ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kds = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al cHz = ajVar.cHz();
        com.facebook.imagepipeline.request.b cIv = ajVar.cHy().cIv();
        a aVar = new a(jVar, cHz, ajVar.getId(), cIv, ajVar);
        if (cIv instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cIv, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.kbZ.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Fx;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kcN;
        private final al kdt;
        private final String kdu;
        private final com.facebook.imagepipeline.request.b kdv;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> kdw;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kdx;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kdy;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.kdw = null;
            this.kcN = false;
            this.kdx = false;
            this.kdy = false;
            this.kdt = alVar;
            this.kdu = str;
            this.kdv = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHF() {
                    a.this.cIg();
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
        protected void cGt() {
            cIg();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.Fx) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.kdw;
                    this.kdw = com.facebook.common.references.a.b(aVar);
                    this.kcN = z;
                    this.kdx = true;
                    boolean cIf = cIf();
                    com.facebook.common.references.a.c(aVar2);
                    if (cIf) {
                        cId();
                    }
                }
            }
        }

        private void cId() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.kdw;
                        z = a.this.kcN;
                        a.this.kdw = null;
                        a.this.kdx = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.cIe();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cIe() {
            boolean cIf;
            synchronized (this) {
                this.kdy = false;
                cIf = cIf();
            }
            if (cIf) {
                cId();
            }
        }

        private synchronized boolean cIf() {
            boolean z = true;
            synchronized (this) {
                if (this.Fx || !this.kdx || this.kdy || !com.facebook.common.references.a.a(this.kdw)) {
                    z = false;
                } else {
                    this.kdy = true;
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
            this.kdt.ez(this.kdu, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.kdt.a(this.kdu, "PostprocessorProducer", a(this.kdt, this.kdu, this.kdv));
                d(aVar2, z);
            } catch (Exception e) {
                this.kdt.a(this.kdu, "PostprocessorProducer", e, a(this.kdt, this.kdu, this.kdv));
                D(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.GT(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.kdv.a(cVar.cGB(), ah.this.kds);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.c(a, bVar.cGC(), cVar.cGE()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && Ab())) {
                cHL().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (Ab()) {
                cHL().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cIg() {
            if (Ab()) {
                cHL().cBA();
            }
        }

        private synchronized boolean isClosed() {
            return this.Fx;
        }

        private boolean Ab() {
            boolean z = true;
            synchronized (this) {
                if (this.Fx) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.kdw;
                    this.kdw = null;
                    this.Fx = true;
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
                cHL().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Fx;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> kdw;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.Fx = false;
            this.kdw = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHF() {
                    if (b.this.Ab()) {
                        b.this.cHL().cBA();
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
                cIh();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (Ab()) {
                cHL().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cGt() {
            if (Ab()) {
                cHL().cBA();
            }
        }

        private void cIh() {
            synchronized (this) {
                if (!this.Fx) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.kdw);
                    try {
                        cHL().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.Fx) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.kdw;
                    this.kdw = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Ab() {
            boolean z = true;
            synchronized (this) {
                if (this.Fx) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.kdw;
                    this.kdw = null;
                    this.Fx = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
