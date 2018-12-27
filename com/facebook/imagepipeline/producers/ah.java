package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isP;
    private final com.facebook.imagepipeline.b.f iui;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.isP = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.iui = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al bZI = ajVar.bZI();
        com.facebook.imagepipeline.request.b caE = ajVar.bZH().caE();
        a aVar = new a(jVar, bZI, ajVar.getId(), caE, ajVar);
        if (caE instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) caE, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.isP.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HL;
        private final String ZM;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean itD;
        private final al iuj;
        private final com.facebook.imagepipeline.request.b iuk;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> iul;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ium;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean iun;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.iul = null;
            this.itD = false;
            this.ium = false;
            this.iun = false;
            this.iuj = alVar;
            this.ZM = str;
            this.iuk = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZO() {
                    a.this.cap();
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
        protected void bYC() {
            cap();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.iul;
                    this.iul = com.facebook.common.references.a.b(aVar);
                    this.itD = z;
                    this.ium = true;
                    boolean cao = cao();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (cao) {
                        cam();
                    }
                }
            }
        }

        private void cam() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.iul;
                        z = a.this.itD;
                        a.this.iul = null;
                        a.this.ium = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.can();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void can() {
            boolean cao;
            synchronized (this) {
                this.iun = false;
                cao = cao();
            }
            if (cao) {
                cam();
            }
        }

        private synchronized boolean cao() {
            boolean z = true;
            synchronized (this) {
                if (this.HL || !this.ium || this.iun || !com.facebook.common.references.a.a(this.iul)) {
                    z = false;
                } else {
                    this.iun = true;
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
            this.iuj.db(this.ZM, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.iuj.a(this.ZM, "PostprocessorProducer", a(this.iuj, this.ZM, this.iuk));
                d(aVar2, z);
            } catch (Exception e) {
                this.iuj.a(this.ZM, "PostprocessorProducer", e, a(this.iuj, this.ZM, this.iuk));
                D(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.zo(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.iuk.a(cVar.bYK(), ah.this.iui);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.f.c(a, bVar.bYL(), cVar.bYN()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && bUy())) {
                bZU().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (bUy()) {
                bZU().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cap() {
            if (bUy()) {
                bZU().bTP();
            }
        }

        private synchronized boolean isClosed() {
            return this.HL;
        }

        private boolean bUy() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.iul;
                    this.iul = null;
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
                bZU().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HL;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> iul;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HL = false;
            this.iul = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZO() {
                    if (b.this.bUy()) {
                        b.this.bZU().bTP();
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
                caq();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (bUy()) {
                bZU().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bYC() {
            if (bUy()) {
                bZU().bTP();
            }
        }

        private void caq() {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.iul);
                    try {
                        bZU().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.iul;
                    this.iul = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean bUy() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.iul;
                    this.iul = null;
                    this.HL = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
