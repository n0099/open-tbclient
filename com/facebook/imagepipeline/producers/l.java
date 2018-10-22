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
    private final com.facebook.common.memory.a hXd;
    private final boolean ieJ;
    private final boolean iek;
    private final com.facebook.imagepipeline.decoder.b ieo;
    private final com.facebook.imagepipeline.decoder.d ieu;
    private final ai<com.facebook.imagepipeline.f.d> igJ;
    private final boolean igW;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.hXd = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ieo = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.ieu = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.iek = z;
        this.igW = z2;
        this.igJ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.ieJ = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.j(ajVar.bXq().bYd())) {
            bVar = new a(jVar, ajVar, this.ieJ);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.hXd), this.ieu, this.ieJ);
        }
        this.igJ.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a icr;
        @GuardedBy("this")
        private boolean igK;
        private final al igM;
        private final aj igU;
        private final JobScheduler iha;

        protected abstract com.facebook.imagepipeline.f.g bWu();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.igU = ajVar;
            this.igM = ajVar.bXr();
            this.icr = ajVar.bXq().bYi();
            this.igK = false;
            this.iha = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.iek) {
                            ImageRequest bXq = ajVar.bXq();
                            if (l.this.igW || !com.facebook.common.util.d.j(bXq.bYd())) {
                                dVar.setSampleSize(p.b(bXq, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.icr.idy);
            this.igU.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXz() {
                    if (c.this.igU.bXv()) {
                        c.this.iha.bXH();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXx() {
                    if (z) {
                        c.this.bXC();
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
                if (z || this.igU.bXv()) {
                    this.iha.bXH();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void aK(float f) {
            super.aK(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void bWl() {
            bXC();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.iha.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c bYg;
            String str4;
            long bXL;
            com.facebook.imagepipeline.f.g bWu;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c bWz = dVar.bWz();
                if (bWz != null) {
                    str = bWz.getName();
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
                if (this.igU.bXq().bYg() != null) {
                    str4 = bYg.width + Config.EVENT_HEAT_X + bYg.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    bXL = this.iha.bXL();
                    int size = z ? dVar.getSize() : g(dVar);
                    bWu = z ? com.facebook.imagepipeline.f.f.ifJ : bWu();
                    this.igM.cX(this.igU.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.ieo.a(dVar, size, bWu, this.icr);
                    this.igM.a(this.igU.getId(), "DecodeProducer", a(a, bXL, bWu, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.igM.a(this.igU.getId(), "DecodeProducer", e, a(null, bXL, bWu, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.igM.yD(this.igU.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.bWE());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap bWt = ((com.facebook.imagepipeline.f.c) bVar).bWt();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", bWt.getWidth() + Config.EVENT_HEAT_X + bWt.getHeight());
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
            return this.igK;
        }

        private void oJ(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.igK) {
                        bXD().ax(1.0f);
                        this.igK = true;
                        this.iha.bXG();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> c = com.facebook.common.references.a.c(bVar);
            try {
                oJ(z);
                bXD().e(c, z);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            }
        }

        private void C(Throwable th) {
            oJ(true);
            bXD().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bXC() {
            oJ(true);
            bXD().bRy();
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
        protected com.facebook.imagepipeline.f.g bWu() {
            return com.facebook.imagepipeline.f.f.e(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d ieu;
        private final com.facebook.imagepipeline.decoder.e igY;
        private int igZ;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.igY = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.ieu = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.igZ = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int bWq;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.igY.a(dVar) && (bWq = this.igY.bWq()) > this.igZ && bWq >= this.ieu.xv(this.igZ)) {
                        this.igZ = bWq;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.igY.bWp();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g bWu() {
            return this.ieu.xw(this.igY.bWq());
        }
    }
}
