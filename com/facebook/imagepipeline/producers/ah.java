package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ah implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ipF;
    private final com.facebook.imagepipeline.b.f iqY;
    private final Executor mExecutor;

    public ah(ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar, com.facebook.imagepipeline.b.f fVar, Executor executor) {
        this.ipF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.iqY = fVar;
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cVar;
        al bYS = ajVar.bYS();
        com.facebook.imagepipeline.request.b bZO = ajVar.bYR().bZO();
        a aVar = new a(jVar, bYS, ajVar.getId(), bZO, ajVar);
        if (bZO instanceof com.facebook.imagepipeline.request.c) {
            cVar = new b(aVar, (com.facebook.imagepipeline.request.c) bZO, ajVar);
        } else {
            cVar = new c(aVar);
        }
        this.ipF.a(cVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean HL;
        private final String ZM;
        private final al iqZ;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean iqt;
        private final com.facebook.imagepipeline.request.b ira;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> irb;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean irc;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean ird;

        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, al alVar, String str, com.facebook.imagepipeline.request.b bVar, aj ajVar) {
            super(jVar);
            this.irb = null;
            this.iqt = false;
            this.irc = false;
            this.ird = false;
            this.iqZ = alVar;
            this.ZM = str;
            this.ira = bVar;
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.a.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bYY() {
                    a.this.bZz();
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
        protected void bXM() {
            bZz();
        }

        private void b(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.irb;
                    this.irb = com.facebook.common.references.a.b(aVar);
                    this.iqt = z;
                    this.irc = true;
                    boolean bZy = bZy();
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                    if (bZy) {
                        bZw();
                    }
                }
            }
        }

        private void bZw() {
            ah.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ah.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.a aVar;
                    boolean z;
                    synchronized (a.this) {
                        aVar = a.this.irb;
                        z = a.this.iqt;
                        a.this.irb = null;
                        a.this.irc = false;
                    }
                    if (com.facebook.common.references.a.a(aVar)) {
                        try {
                            a.this.c(aVar, z);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                        }
                    }
                    a.this.bZx();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bZx() {
            boolean bZy;
            synchronized (this) {
                this.ird = false;
                bZy = bZy();
            }
            if (bZy) {
                bZw();
            }
        }

        private synchronized boolean bZy() {
            boolean z = true;
            synchronized (this) {
                if (this.HL || !this.irc || this.ird || !com.facebook.common.references.a.a(this.irb)) {
                    z = false;
                } else {
                    this.ird = true;
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
            this.iqZ.db(this.ZM, "PostprocessorProducer");
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = null;
            try {
                aVar2 = g(aVar.get());
                this.iqZ.a(this.ZM, "PostprocessorProducer", a(this.iqZ, this.ZM, this.ira));
                d(aVar2, z);
            } catch (Exception e) {
                this.iqZ.a(this.ZM, "PostprocessorProducer", e, a(this.iqZ, this.ZM, this.ira));
                D(e);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
            }
        }

        private Map<String, String> a(al alVar, String str, com.facebook.imagepipeline.request.b bVar) {
            if (alVar.zl(str)) {
                return ImmutableMap.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        private boolean f(com.facebook.imagepipeline.f.b bVar) {
            return bVar instanceof com.facebook.imagepipeline.f.c;
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> g(com.facebook.imagepipeline.f.b bVar) {
            com.facebook.imagepipeline.f.c cVar = (com.facebook.imagepipeline.f.c) bVar;
            com.facebook.common.references.a<Bitmap> a = this.ira.a(cVar.bXU(), ah.this.iqY);
            try {
                return com.facebook.common.references.a.c(new com.facebook.imagepipeline.f.c(a, bVar.bXV(), cVar.bXX()));
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
            }
        }

        private void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
            if ((!z && !isClosed()) || (z && bTI())) {
                bZe().e(aVar, z);
            }
        }

        private void D(Throwable th) {
            if (bTI()) {
                bZe().B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bZz() {
            if (bTI()) {
                bZe().bSZ();
            }
        }

        private synchronized boolean isClosed() {
            return this.HL;
        }

        private boolean bTI() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.irb;
                    this.irb = null;
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
                bZe().e(aVar, z);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> implements com.facebook.imagepipeline.request.d {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean HL;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private com.facebook.common.references.a<com.facebook.imagepipeline.f.b> irb;

        private b(a aVar, com.facebook.imagepipeline.request.c cVar, aj ajVar) {
            super(aVar);
            this.HL = false;
            this.irb = null;
            cVar.a(this);
            ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ah.b.1
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bYY() {
                    if (b.this.bTI()) {
                        b.this.bZe().bSZ();
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
                bZA();
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (bTI()) {
                bZe().B(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void bXM() {
            if (bTI()) {
                bZe().bSZ();
            }
        }

        private void bZA() {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> b = com.facebook.common.references.a.b(this.irb);
                    try {
                        bZe().e(b, false);
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                    }
                }
            }
        }

        private void k(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
            synchronized (this) {
                if (!this.HL) {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar2 = this.irb;
                    this.irb = com.facebook.common.references.a.b(aVar);
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean bTI() {
            boolean z = true;
            synchronized (this) {
                if (this.HL) {
                    z = false;
                } else {
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar = this.irb;
                    this.irb = null;
                    this.HL = true;
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
                }
            }
            return z;
        }
    }
}
