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
    private final com.facebook.common.memory.a kdb;
    private final boolean kkK;
    private final boolean kkl;
    private final com.facebook.imagepipeline.decoder.b kkp;
    private final com.facebook.imagepipeline.decoder.d kkv;
    private final ai<com.facebook.imagepipeline.f.d> kmM;
    private final boolean kmZ;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.kdb = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kkp = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.kkv = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.kkl = z;
        this.kmZ = z2;
        this.kmM = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kkK = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.y(ajVar.cLK().cMx())) {
            bVar = new a(jVar, ajVar, this.kkK);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.kdb), this.kkv, this.kkK);
        }
        this.kmM.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a kiu;
        @GuardedBy("this")
        private boolean kmN;
        private final al kmP;
        private final aj kmX;
        private final JobScheduler knd;

        protected abstract com.facebook.imagepipeline.f.g cKN();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.kmX = ajVar;
            this.kmP = ajVar.cLL();
            this.kiu = ajVar.cLK().cMC();
            this.kmN = false;
            this.knd = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.kkl) {
                            ImageRequest cLK = ajVar.cLK();
                            if (l.this.kmZ || !com.facebook.common.util.d.y(cLK.cMx())) {
                                dVar.setSampleSize(p.b(cLK, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.kiu.kjz);
            this.kmX.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLT() {
                    if (c.this.kmX.cLP()) {
                        c.this.knd.cMb();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLR() {
                    if (z) {
                        c.this.cLW();
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
                if (z || this.kmX.cLP()) {
                    this.knd.cMb();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void bg(float f) {
            super.bg(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void cKE() {
            cLW();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.knd.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cMA;
            String str4;
            long cMf;
            com.facebook.imagepipeline.f.g cKN;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cKS = dVar.cKS();
                if (cKS != null) {
                    str = cKS.getName();
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
                if (this.kmX.cLK().cMA() != null) {
                    str4 = cMA.width + Config.EVENT_HEAT_X + cMA.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cMf = this.knd.cMf();
                    int size = z ? dVar.getSize() : g(dVar);
                    cKN = z ? com.facebook.imagepipeline.f.f.klN : cKN();
                    this.kmP.eB(this.kmX.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.kkp.a(dVar, size, cKN, this.kiu);
                    this.kmP.a(this.kmX.getId(), "DecodeProducer", a(a, cMf, cKN, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.kmP.a(this.kmX.getId(), "DecodeProducer", e, a(null, cMf, cKN, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.kmP.Iq(this.kmX.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cKY());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cKM = ((com.facebook.imagepipeline.f.c) bVar).cKM();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cKM.getWidth() + Config.EVENT_HEAT_X + cKM.getHeight());
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
            return this.kmN;
        }

        private void sG(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.kmN) {
                        cLX().aS(1.0f);
                        this.kmN = true;
                        this.knd.cMa();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                sG(z);
                cLX().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void C(Throwable th) {
            sG(true);
            cLX().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cLW() {
            sG(true);
            cLX().cFJ();
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
        protected com.facebook.imagepipeline.f.g cKN() {
            return com.facebook.imagepipeline.f.f.g(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d kkv;
        private final com.facebook.imagepipeline.decoder.e knb;
        private int knc;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.knb = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.kkv = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.knc = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cKJ;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.knb.a(dVar) && (cKJ = this.knb.cKJ()) > this.knc && cKJ >= this.kkv.DU(this.knc)) {
                        this.knc = cKJ;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.knb.cKI();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cKN() {
            return this.kkv.DV(this.knb.cKJ());
        }
    }
}
