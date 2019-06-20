package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kcc;
    private final com.facebook.imagepipeline.b.f kdv;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.kcc = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kdv = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al cHy = ajVar.cHy();
        com.facebook.imagepipeline.request.b cIu = ajVar.cHx().cIu();
        a aVar = new a(jVar, cHy, ajVar.getId(), cIu, ajVar);
        if (cIu instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) cIu, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.kcc.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean Fw;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kcQ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kdA;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean kdB;
        private final al kdw;
        private final String kdx;
        private final com.facebook.imagepipeline.request.b kdy;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> kdz;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.kdz = null;
            this.kcQ = false;
            this.kdA = false;
            this.kdB = false;
            this.kdw = alVar;
            this.kdx = str;
            this.kdy = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHE() {
                    a.this.cIf();
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
        protected void cGs() {
            cIf();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.Fw) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.kdz;
                    this.kdz = com.facebook.common.references.a.b(aVar);
                    this.kcQ = z;
                    this.kdA = true;
                    boolean cIe = cIe();
                    com.facebook.common.references.a.c(aVar2);
                    if (cIe) {
                        cIc();
                    }
                }
            }
        }

        private void cIc() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.kdz;
                        z = a.this.kcQ;
                        a.this.kdz = null;
                        a.this.kdA = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c(aVar);
                        }
                    }
                    a.this.cId();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cId() {
            boolean cIe;
            synchronized (this) {
                this.kdB = false;
                cIe = cIe();
            }
            if (cIe) {
                cIc();
            }
        }

        private synchronized boolean cIe() {
            boolean z = true;
            synchronized (this) {
                if (this.Fw || !this.kdA || this.kdB || !com.facebook.common.references.a.a(this.kdz)) {
                    z = false;
                } else {
                    this.kdB = true;
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
            this.kdw.ez(this.kdx, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.kdw.a(this.kdx, "PostprocessorProducer", a(this.kdw, this.kdx, this.kdy));
                d(aVar2, z);
            } catch (Exception e) {
                this.kdw.a(this.kdx, "PostprocessorProducer", e, a(this.kdw, this.kdx, this.kdy));
                D(e);
            } finally {
                com.facebook.common.references.a.c(aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.GV(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.kdy.a(cVar.cGA(), ah.this.kdv);
            try {
                return com.facebook.common.references.a.d(new com.facebook.imagepipeline.f.c(a, bVar.cGB(), cVar.cGD()));
            } finally {
                com.facebook.common.references.a.c(a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && Ab())) {
                cHK().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (Ab()) {
                cHK().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cIf() {
            if (Ab()) {
                cHK().cBz();
            }
        }

        private synchronized boolean isClosed() {
            return this.Fw;
        }

        private boolean Ab() {
            boolean z = true;
            synchronized (this) {
                if (this.Fw) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.kdz;
                    this.kdz = null;
                    this.Fw = true;
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
                cHK().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean Fw;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> kdz;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.Fw = false;
            this.kdz = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHE() {
                    if (b.this.Ab()) {
                        b.this.cHK().cBz();
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
                cIg();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (Ab()) {
                cHK().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void cGs() {
            if (Ab()) {
                cHK().cBz();
            }
        }

        private void cIg() {
            synchronized (this) {
                if (!this.Fw) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.kdz);
                    try {
                        cHK().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c(b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.Fw) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.kdz;
                    this.kdz = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c(aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean Ab() {
            boolean z = true;
            synchronized (this) {
                if (this.Fw) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.kdz;
                    this.kdz = null;
                    this.Fw = true;
                    com.facebook.common.references.a.c(aVar);
                }
            }
            return z;
        }
    }
}
