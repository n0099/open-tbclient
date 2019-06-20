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
    private final com.facebook.common.memory.a jSu;
    private final boolean jZB;
    private final com.facebook.imagepipeline.decoder.b jZF;
    private final com.facebook.imagepipeline.decoder.d jZL;
    private final boolean kaa;
    private final ai<com.facebook.imagepipeline.f.d> kcc;
    private final boolean kcp;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jSu = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jZF = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.jZL = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.jZB = z;
        this.kcp = z2;
        this.kcc = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kaa = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.y(ajVar.cHx().cIk())) {
            bVar = new a(jVar, ajVar, this.kaa);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jSu), this.jZL, this.kaa);
        }
        this.kcc.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a jXL;
        @GuardedBy("this")
        private boolean kcd;
        private final al kcf;
        private final aj kcn;
        private final JobScheduler kct;

        protected abstract com.facebook.imagepipeline.f.g cGB();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.kcn = ajVar;
            this.kcf = ajVar.cHy();
            this.jXL = ajVar.cHx().cIp();
            this.kcd = false;
            this.kct = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.jZB) {
                            ImageRequest cHx = ajVar.cHx();
                            if (l.this.kcp || !com.facebook.common.util.d.y(cHx.cIk())) {
                                dVar.setSampleSize(p.b(cHx, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.jXL.jYP);
            this.kcn.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHG() {
                    if (c.this.kcn.cHC()) {
                        c.this.kct.cHO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHE() {
                    if (z) {
                        c.this.cHJ();
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
                if (z || this.kcn.cHC()) {
                    this.kct.cHO();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void be(float f) {
            super.be(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void cGs() {
            cHJ();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.kct.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cIn;
            String str4;
            long cHS;
            com.facebook.imagepipeline.f.g cGB;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cGG = dVar.cGG();
                if (cGG != null) {
                    str = cGG.getName();
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
                if (this.kcn.cHx().cIn() != null) {
                    str4 = cIn.width + Config.EVENT_HEAT_X + cIn.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cHS = this.kct.cHS();
                    int size = z ? dVar.getSize() : g(dVar);
                    cGB = z ? com.facebook.imagepipeline.f.f.kbd : cGB();
                    this.kcf.ez(this.kcn.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.jZF.a(dVar, size, cGB, this.jXL);
                    this.kcf.a(this.kcn.getId(), "DecodeProducer", a(a, cHS, cGB, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.kcf.a(this.kcn.getId(), "DecodeProducer", e, a(null, cHS, cGB, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.kcf.GV(this.kcn.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cGL());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cGA = ((com.facebook.imagepipeline.f.c) bVar).cGA();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cGA.getWidth() + Config.EVENT_HEAT_X + cGA.getHeight());
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
            return this.kcd;
        }

        private void sn(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.kcd) {
                        cHK().aQ(1.0f);
                        this.kcd = true;
                        this.kct.cHN();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                sn(z);
                cHK().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void C(Throwable th) {
            sn(true);
            cHK().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cHJ() {
            sn(true);
            cHK().cBz();
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
        protected com.facebook.imagepipeline.f.g cGB() {
            return com.facebook.imagepipeline.f.f.f(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d jZL;
        private final com.facebook.imagepipeline.decoder.e kcr;
        private int kcs;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.kcr = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.jZL = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.kcs = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cGx;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.kcr.a(dVar) && (cGx = this.kcr.cGx()) > this.kcs && cGx >= this.jZL.Dh(this.kcs)) {
                        this.kcs = cGx;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.kcr.cGw();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cGB() {
            return this.jZL.Di(this.kcr.cGx());
        }
    }
}
