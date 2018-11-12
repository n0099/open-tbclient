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
    private final com.facebook.common.memory.a hYN;
    private final boolean ifU;
    private final com.facebook.imagepipeline.decoder.b ifY;
    private final com.facebook.imagepipeline.decoder.d ige;
    private final boolean igt;
    private final boolean iiG;
    private final ai<com.facebook.imagepipeline.f.d> iit;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.hYN = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ifY = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.ige = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.ifU = z;
        this.iiG = z2;
        this.iit = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.igt = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.j(ajVar.bWL().bXy())) {
            bVar = new a(jVar, ajVar, this.igt);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.hYN), this.ige, this.igt);
        }
        this.iit.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a iee;
        private final aj iiE;
        private final JobScheduler iiK;
        @GuardedBy("this")
        private boolean iiu;
        private final al iiw;

        protected abstract com.facebook.imagepipeline.f.g bVP();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.iiE = ajVar;
            this.iiw = ajVar.bWM();
            this.iee = ajVar.bWL().bXD();
            this.iiu = false;
            this.iiK = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.ifU) {
                            ImageRequest bWL = ajVar.bWL();
                            if (l.this.iiG || !com.facebook.common.util.d.j(bWL.bXy())) {
                                dVar.setSampleSize(p.b(bWL, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.iee.ifi);
            this.iiE.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWU() {
                    if (c.this.iiE.bWQ()) {
                        c.this.iiK.bXc();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWS() {
                    if (z) {
                        c.this.bWX();
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
                if (z || this.iiE.bWQ()) {
                    this.iiK.bXc();
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
        public void bVG() {
            bWX();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.iiK.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c bXB;
            String str4;
            long bXg;
            com.facebook.imagepipeline.f.g bVP;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c bVU = dVar.bVU();
                if (bVU != null) {
                    str = bVU.getName();
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
                if (this.iiE.bWL().bXB() != null) {
                    str4 = bXB.width + Config.EVENT_HEAT_X + bXB.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    bXg = this.iiK.bXg();
                    int size = z ? dVar.getSize() : g(dVar);
                    bVP = z ? com.facebook.imagepipeline.f.f.iht : bVP();
                    this.iiw.cW(this.iiE.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.ifY.a(dVar, size, bVP, this.iee);
                    this.iiw.a(this.iiE.getId(), "DecodeProducer", a(a, bXg, bVP, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.iiw.a(this.iiE.getId(), "DecodeProducer", e, a(null, bXg, bVP, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.iiw.yI(this.iiE.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.bVZ());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap bVO = ((com.facebook.imagepipeline.f.c) bVar).bVO();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", bVO.getWidth() + Config.EVENT_HEAT_X + bVO.getHeight());
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
            return this.iiu;
        }

        private void oX(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.iiu) {
                        bWY().az(1.0f);
                        this.iiu = true;
                        this.iiK.bXb();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> c = com.facebook.common.references.a.c(bVar);
            try {
                oX(z);
                bWY().e(c, z);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            }
        }

        private void C(Throwable th) {
            oX(true);
            bWY().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bWX() {
            oX(true);
            bWY().bQT();
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
        protected com.facebook.imagepipeline.f.g bVP() {
            return com.facebook.imagepipeline.f.f.e(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d ige;
        private final com.facebook.imagepipeline.decoder.e iiI;
        private int iiJ;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.iiI = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.ige = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.iiJ = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int bVL;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.iiI.a(dVar) && (bVL = this.iiI.bVL()) > this.iiJ && bVL >= this.ige.xO(this.iiJ)) {
                        this.iiJ = bVL;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.iiI.bVK();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g bVP() {
            return this.ige.xP(this.iiI.bVL());
        }
    }
}
