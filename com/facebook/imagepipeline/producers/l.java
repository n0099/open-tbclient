package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.mobstat.Config;
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
    private final com.facebook.common.memory.a iga;
    private final boolean inF;
    private final boolean inf;
    private final com.facebook.imagepipeline.decoder.b inj;
    private final com.facebook.imagepipeline.decoder.d inp;
    private final ai<com.facebook.imagepipeline.f.d> ipF;
    private final boolean ipS;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.iga = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.inj = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.inp = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.inf = z;
        this.ipS = z2;
        this.ipF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.inF = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.k(ajVar.bYR().bZE())) {
            bVar = new a(jVar, ajVar, this.inF);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.iga), this.inp, this.inF);
        }
        this.ipF.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a ilo;
        @GuardedBy("this")
        private boolean ipG;
        private final al ipI;
        private final aj ipQ;
        private final JobScheduler ipW;

        protected abstract com.facebook.imagepipeline.f.g bXV();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.ipQ = ajVar;
            this.ipI = ajVar.bYS();
            this.ilo = ajVar.bYR().bZJ();
            this.ipG = false;
            this.ipW = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.inf) {
                            ImageRequest bYR = ajVar.bYR();
                            if (l.this.ipS || !com.facebook.common.util.d.k(bYR.bZE())) {
                                dVar.setSampleSize(p.b(bYR, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.ilo.imt);
            this.ipQ.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZa() {
                    if (c.this.ipQ.bYW()) {
                        c.this.ipW.bZi();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bYY() {
                    if (z) {
                        c.this.bZd();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (z && !com.facebook.imagepipeline.f.d.f(dVar)) {
                C(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(dVar, z)) {
                if (z || this.ipQ.bYW()) {
                    this.ipW.bZi();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void aM(float f) {
            super.aM(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void bXM() {
            bZd();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.ipW.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c bZH;
            String str4;
            long bZm;
            com.facebook.imagepipeline.f.g bXV;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c bYa = dVar.bYa();
                if (bYa != null) {
                    str = bYa.getName();
                } else {
                    str = "unknown";
                }
                if (dVar != null) {
                    str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
                    str3 = String.valueOf(dVar.getSampleSize());
                } else {
                    str2 = "unknown";
                    str3 = "unknown";
                }
                if (this.ipQ.bYR().bZH() != null) {
                    str4 = bZH.width + Config.EVENT_HEAT_X + bZH.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    bZm = this.ipW.bZm();
                    int size = z ? dVar.getSize() : g(dVar);
                    bXV = z ? com.facebook.imagepipeline.f.f.ioF : bXV();
                    this.ipI.db(this.ipQ.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.inj.a(dVar, size, bXV, this.ilo);
                    this.ipI.a(this.ipQ.getId(), "DecodeProducer", a(a, bZm, bXV, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.ipI.a(this.ipQ.getId(), "DecodeProducer", e, a(null, bZm, bXV, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.ipI.zl(this.ipQ.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.bYf());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap bXU = ((com.facebook.imagepipeline.f.c) bVar).bXU();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", bXU.getWidth() + Config.EVENT_HEAT_X + bXU.getHeight());
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
            return this.ipG;
        }

        private void oZ(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.ipG) {
                        bZe().az(1.0f);
                        this.ipG = true;
                        this.ipW.bZh();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> c = com.facebook.common.references.a.c(bVar);
            try {
                oZ(z);
                bZe().e(c, z);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            }
        }

        private void C(Throwable th) {
            oZ(true);
            bZe().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bZd() {
            oZ(true);
            bZe().bSZ();
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
        protected com.facebook.imagepipeline.f.g bXV() {
            return com.facebook.imagepipeline.f.f.e(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d inp;
        private final com.facebook.imagepipeline.decoder.e ipU;
        private int ipV;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.ipU = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.inp = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.ipV = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int bXR;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.ipU.a(dVar) && (bXR = this.ipU.bXR()) > this.ipV && bXR >= this.inp.yl(this.ipV)) {
                        this.ipV = bXR;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.ipU.bXQ();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g bXV() {
            return this.inp.ym(this.ipU.bXR());
        }
    }
}
