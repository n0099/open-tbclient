package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class l implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final boolean jHD;
    private final boolean jHe;
    private final com.facebook.imagepipeline.decoder.b jHi;
    private final com.facebook.imagepipeline.decoder.d jHo;
    private final ai<com.facebook.imagepipeline.f.d> jJF;
    private final boolean jJS;
    private final com.facebook.common.memory.a jzU;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jzU = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jHi = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.jHo = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.jHe = z;
        this.jJS = z2;
        this.jJF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHD = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.s(ajVar.czu().cAh())) {
            bVar = new a(jVar, ajVar, this.jHD);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jzU), this.jHo, this.jHD);
        }
        this.jJF.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a jFo;
        @GuardedBy("this")
        private boolean jJG;
        private final al jJI;
        private final aj jJQ;
        private final JobScheduler jJW;

        protected abstract com.facebook.imagepipeline.f.g cyy();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.jJQ = ajVar;
            this.jJI = ajVar.czv();
            this.jFo = ajVar.czu().cAm();
            this.jJG = false;
            this.jJW = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.jHe) {
                            ImageRequest czu = ajVar.czu();
                            if (l.this.jJS || !com.facebook.common.util.d.s(czu.cAh())) {
                                dVar.setSampleSize(p.b(czu, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.jFo.jGs);
            this.jJQ.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czD() {
                    if (c.this.jJQ.czz()) {
                        c.this.jJW.czL();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czB() {
                    if (z) {
                        c.this.czG();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (z && !com.facebook.imagepipeline.f.d.f(dVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(dVar, z)) {
                if (z || this.jJQ.czz()) {
                    this.jJW.czL();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void ba(float f) {
            super.ba(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void cyp() {
            czG();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.jJW.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cAk;
            String str4;
            long czP;
            com.facebook.imagepipeline.f.g cyy;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cyD = dVar.cyD();
                if (cyD != null) {
                    str = cyD.getName();
                } else {
                    str = "unknown";
                }
                if (dVar != null) {
                    str2 = dVar.getWidth() + "x" + dVar.getHeight();
                    str3 = String.valueOf(dVar.getSampleSize());
                } else {
                    str2 = "unknown";
                    str3 = "unknown";
                }
                if (this.jJQ.czu().cAk() != null) {
                    str4 = cAk.width + "x" + cAk.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    czP = this.jJW.czP();
                    int size = z ? dVar.getSize() : g(dVar);
                    cyy = z ? com.facebook.imagepipeline.f.f.jIG : cyy();
                    this.jJI.em(this.jJQ.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.jHi.a(dVar, size, cyy, this.jFo);
                    this.jJI.a(this.jJQ.getId(), "DecodeProducer", a(a, czP, cyy, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.jJI.a(this.jJQ.getId(), "DecodeProducer", e, a(null, czP, cyy, z, str, str2, str4, str3));
                    D(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.jJI.FH(this.jJQ.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cyI());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cyx = ((com.facebook.imagepipeline.f.c) bVar).cyx();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cyx.getWidth() + "x" + cyx.getHeight());
                hashMap.put("queueTime", valueOf);
                hashMap.put("hasGoodQuality", valueOf2);
                hashMap.put("isFinal", valueOf3);
                hashMap.put("encodedImageSize", str2);
                hashMap.put("imageFormat", str);
                hashMap.put("requestedImageSize", str3);
                hashMap.put("sampleSize", str4);
                return ImmutableMap.copyOf((Map) hashMap);
            }
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put("hasGoodQuality", valueOf2);
            hashMap2.put("isFinal", valueOf3);
            hashMap2.put("encodedImageSize", str2);
            hashMap2.put("imageFormat", str);
            hashMap2.put("requestedImageSize", str3);
            hashMap2.put("sampleSize", str4);
            return ImmutableMap.copyOf((Map) hashMap2);
        }

        private synchronized boolean isFinished() {
            return this.jJG;
        }

        private void rx(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.jJG) {
                        czH().aM(1.0f);
                        this.jJG = true;
                        this.jJW.czK();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                rx(z);
                czH().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void D(Throwable th) {
            rx(true);
            czH().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czG() {
            rx(true);
            czH().ctv();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends c {
        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, boolean z) {
            super(jVar, ajVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return !z ? false : super.b(dVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return dVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cyy() {
            return com.facebook.imagepipeline.f.f.f(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d jHo;
        private final com.facebook.imagepipeline.decoder.e jJU;
        private int jJV;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.jJU = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.jHo = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.jJV = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cyu;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.jJU.a(dVar) && (cyu = this.jJU.cyu()) > this.jJV && cyu >= this.jHo.Cm(this.jJV)) {
                        this.jJV = cyu;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.jJU.cyt();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cyy() {
            return this.jHo.Cn(this.jJU.cyu());
        }
    }
}
