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
    private final com.facebook.common.memory.a kaE;
    private final boolean khN;
    private final com.facebook.imagepipeline.decoder.b khR;
    private final com.facebook.imagepipeline.decoder.d khX;
    private final boolean kin;
    private final boolean kkC;
    private final ai<com.facebook.imagepipeline.f.d> kkp;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.kaE = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.khR = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.khX = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.khN = z;
        this.kkC = z2;
        this.kkp = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kin = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.y(ajVar.cKW().cLJ())) {
            bVar = new a(jVar, ajVar, this.kin);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.kaE), this.khX, this.kin);
        }
        this.kkp.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a kfW;
        private final aj kkA;
        private final JobScheduler kkG;
        @GuardedBy("this")
        private boolean kkq;
        private final al kks;

        protected abstract com.facebook.imagepipeline.f.g cJZ();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.kkA = ajVar;
            this.kks = ajVar.cKX();
            this.kfW = ajVar.cKW().cLO();
            this.kkq = false;
            this.kkG = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.khN) {
                            ImageRequest cKW = ajVar.cKW();
                            if (l.this.kkC || !com.facebook.common.util.d.y(cKW.cLJ())) {
                                dVar.setSampleSize(p.b(cKW, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.kfW.khb);
            this.kkA.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLf() {
                    if (c.this.kkA.cLb()) {
                        c.this.kkG.cLn();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLd() {
                    if (z) {
                        c.this.cLi();
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
                if (z || this.kkA.cLb()) {
                    this.kkG.cLn();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void bf(float f) {
            super.bf(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void cJQ() {
            cLi();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.kkG.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cLM;
            String str4;
            long cLr;
            com.facebook.imagepipeline.f.g cJZ;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cKe = dVar.cKe();
                if (cKe != null) {
                    str = cKe.getName();
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
                if (this.kkA.cKW().cLM() != null) {
                    str4 = cLM.width + Config.EVENT_HEAT_X + cLM.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cLr = this.kkG.cLr();
                    int size = z ? dVar.getSize() : g(dVar);
                    cJZ = z ? com.facebook.imagepipeline.f.f.kjq : cJZ();
                    this.kks.eA(this.kkA.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.khR.a(dVar, size, cJZ, this.kfW);
                    this.kks.a(this.kkA.getId(), "DecodeProducer", a(a, cLr, cJZ, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.kks.a(this.kkA.getId(), "DecodeProducer", e, a(null, cLr, cJZ, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.kks.HQ(this.kkA.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cKk());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cJY = ((com.facebook.imagepipeline.f.c) bVar).cJY();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cJY.getWidth() + Config.EVENT_HEAT_X + cJY.getHeight());
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
            return this.kkq;
        }

        private void sD(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.kkq) {
                        cLj().aR(1.0f);
                        this.kkq = true;
                        this.kkG.cLm();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                sD(z);
                cLj().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void C(Throwable th) {
            sD(true);
            cLj().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cLi() {
            sD(true);
            cLj().cEV();
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
        protected com.facebook.imagepipeline.f.g cJZ() {
            return com.facebook.imagepipeline.f.f.g(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d khX;
        private final com.facebook.imagepipeline.decoder.e kkE;
        private int kkF;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.kkE = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.khX = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.kkF = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cJV;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.kkE.a(dVar) && (cJV = this.kkE.cJV()) > this.kkF && cJV >= this.khX.DQ(this.kkF)) {
                        this.kkF = cJV;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.kkE.cJU();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cJZ() {
            return this.khX.DR(this.kkE.cJV());
        }
    }
}
