package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> igI;
    private final com.facebook.imagepipeline.b.f iib;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.igI = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.iib = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al bXr = ajVar.bXr();
        com.facebook.imagepipeline.request.b bYn = ajVar.bXq().bYn();
        a aVar = new a(jVar, bXr, ajVar.getId(), bYn, ajVar);
        if (bYn instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) bYn, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.igI.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HH;
        private final String ZM;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ihw;
        private final al iic;
        private final com.facebook.imagepipeline.request.b iid;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> iie;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean iif;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean iig;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.iie = null;
            this.ihw = false;
            this.iif = false;
            this.iig = false;
            this.iic = alVar;
            this.ZM = str;
            this.iid = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXx() {
                    a.this.bXY();
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
        protected void bWl() {
            bXY();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HH) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.iie;
                    this.iie = com.facebook.common.references.a.b(aVar);
                    this.ihw = z;
                    this.iif = true;
                    boolean bXX = bXX();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (bXX) {
                        bXV();
                    }
                }
            }
        }

        private void bXV() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.iie;
                        z = a.this.ihw;
                        a.this.iie = null;
                        a.this.iif = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.bXW();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXW() {
            boolean bXX;
            synchronized (this) {
                this.iig = false;
                bXX = bXX();
            }
            if (bXX) {
                bXV();
            }
        }

        private synchronized boolean bXX() {
            boolean z = true;
            synchronized (this) {
                if (this.HH || !this.iif || this.iig || !com.facebook.common.references.a.a(this.iie)) {
                    z = false;
                } else {
                    this.iig = true;
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
            this.iic.cX(this.ZM, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.iic.a(this.ZM, "PostprocessorProducer", a(this.iic, this.ZM, this.iid));
                d(aVar2, z);
            } catch (Exception e) {
                this.iic.a(this.ZM, "PostprocessorProducer", e, a(this.iic, this.ZM, this.iid));
                D(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.yD(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.iid.a(cVar.bWt(), ah.this.iib);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.f.c(a, bVar.bWu(), cVar.bWw()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && bSh())) {
                bXD().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (bSh()) {
                bXD().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXY() {
            if (bSh()) {
                bXD().bRy();
            }
        }

        private synchronized boolean isClosed() {
            return this.HH;
        }

        private boolean bSh() {
            boolean z = true;
            synchronized (this) {
                if (this.HH) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.iie;
                    this.iie = null;
                    this.HH = true;
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
                bXD().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HH;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> iie;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HH = false;
            this.iie = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXx() {
                    if (b.this.bSh()) {
                        b.this.bXD().bRy();
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
                bXZ();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (bSh()) {
                bXD().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bWl() {
            if (bSh()) {
                bXD().bRy();
            }
        }

        private void bXZ() {
            synchronized (this) {
                if (!this.HH) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.iie);
                    try {
                        bXD().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HH) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.iie;
                    this.iie = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean bSh() {
            boolean z = true;
            synchronized (this) {
                if (this.HH) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.iie;
                    this.iie = null;
                    this.HH = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
