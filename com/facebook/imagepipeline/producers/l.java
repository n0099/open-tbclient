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
    private final com.facebook.common.memory.a jZy;
    private final boolean kgH;
    private final com.facebook.imagepipeline.decoder.b kgL;
    private final com.facebook.imagepipeline.decoder.d kgR;
    private final boolean khg;
    private final ai<com.facebook.imagepipeline.f.d> kjj;
    private final boolean kjw;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jZy = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kgL = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.kgR = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.kgH = z;
        this.kjw = z2;
        this.kjj = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.khg = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.y(ajVar.cKB().cLo())) {
            bVar = new a(jVar, ajVar, this.khg);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jZy), this.kgR, this.khg);
        }
        this.kjj.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a keQ;
        private final JobScheduler kjA;
        @GuardedBy("this")
        private boolean kjk;
        private final al kjm;
        private final aj kju;

        protected abstract com.facebook.imagepipeline.f.g cJE();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.kju = ajVar;
            this.kjm = ajVar.cKC();
            this.keQ = ajVar.cKB().cLt();
            this.kjk = false;
            this.kjA = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.kgH) {
                            ImageRequest cKB = ajVar.cKB();
                            if (l.this.kjw || !com.facebook.common.util.d.y(cKB.cLo())) {
                                dVar.setSampleSize(p.b(cKB, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.keQ.kfV);
            this.kju.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKK() {
                    if (c.this.kju.cKG()) {
                        c.this.kjA.cKS();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKI() {
                    if (z) {
                        c.this.cKN();
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
                if (z || this.kju.cKG()) {
                    this.kjA.cKS();
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
        public void cJv() {
            cKN();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.kjA.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cLr;
            String str4;
            long cKW;
            com.facebook.imagepipeline.f.g cJE;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cJJ = dVar.cJJ();
                if (cJJ != null) {
                    str = cJJ.getName();
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
                if (this.kju.cKB().cLr() != null) {
                    str4 = cLr.width + Config.EVENT_HEAT_X + cLr.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cKW = this.kjA.cKW();
                    int size = z ? dVar.getSize() : g(dVar);
                    cJE = z ? com.facebook.imagepipeline.f.f.kik : cJE();
                    this.kjm.eA(this.kju.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.kgL.a(dVar, size, cJE, this.keQ);
                    this.kjm.a(this.kju.getId(), "DecodeProducer", a(a, cKW, cJE, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.kjm.a(this.kju.getId(), "DecodeProducer", e, a(null, cKW, cJE, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.kjm.HP(this.kju.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cJP());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cJD = ((com.facebook.imagepipeline.f.c) bVar).cJD();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cJD.getWidth() + Config.EVENT_HEAT_X + cJD.getHeight());
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
            return this.kjk;
        }

        private void sC(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.kjk) {
                        cKO().aR(1.0f);
                        this.kjk = true;
                        this.kjA.cKR();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                sC(z);
                cKO().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void C(Throwable th) {
            sC(true);
            cKO().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cKN() {
            sC(true);
            cKO().cEA();
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
        protected com.facebook.imagepipeline.f.g cJE() {
            return com.facebook.imagepipeline.f.f.g(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d kgR;
        private final com.facebook.imagepipeline.decoder.e kjy;
        private int kjz;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.kjy = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.kgR = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.kjz = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cJA;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.kjy.a(dVar) && (cJA = this.kjy.cJA()) > this.kjz && cJA >= this.kgR.DO(this.kjz)) {
                        this.kjz = cJA;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.kjy.cJz();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cJE() {
            return this.kgR.DP(this.kjy.cJA());
        }
    }
}
