package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.mobstat.Config;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.common.memory.a lID;
    private final boolean lSE;
    private final boolean lSi;
    private final com.facebook.imagepipeline.decoder.b lSl;
    private final com.facebook.imagepipeline.decoder.d lSr;
    private final aj<com.facebook.imagepipeline.g.e> lUZ;
    private final boolean lVo;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lID = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lSl = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lSr = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lSi = z;
        this.lVo = z2;
        this.lUZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lSE = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.C(akVar.drv().dso())) {
            bVar = new a(kVar, akVar, this.lSE);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lID), this.lSr, this.lSE);
        }
        this.lUZ.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lQA;
        @GuardedBy("this")
        private boolean lVa;
        private final am lVb;
        private final ak lVm;
        private final JobScheduler lVs;

        protected abstract com.facebook.imagepipeline.g.h dqq();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lVm = akVar;
            this.lVb = akVar.drw();
            this.lQA = akVar.drv().dss();
            this.lVa = false;
            this.lVs = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lSi || !com.facebook.imagepipeline.producers.b.dA(i, 16)) {
                            ImageRequest drv = akVar.drv();
                            if (m.this.lVo || !com.facebook.common.util.d.C(drv.dso())) {
                                eVar.setSampleSize(q.a(drv, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lQA.lRt);
            this.lVm.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drD() {
                    if (c.this.lVm.drA()) {
                        c.this.lVs.drO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnN() {
                    if (z) {
                        c.this.drG();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean IJ = IJ(i);
            if (IJ && !com.facebook.imagepipeline.g.e.f(eVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dA = dA(i, 4);
                if (IJ || dA || this.lVm.drA()) {
                    this.lVs.drO();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bs(float f) {
            super.bs(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dqf() {
            drG();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lVs.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dsq;
            String str2;
            long drS;
            int size;
            com.facebook.imagepipeline.g.h dqq;
            if ((eVar.dqx() == com.facebook.c.b.lPo || !IK(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dqx = eVar.dqx();
                if (dqx != null) {
                    str = dqx.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean IJ = IJ(i);
                boolean z = IJ && !dA(i, 8);
                boolean dA = dA(i, 4);
                if (this.lVm.drv().dsq() != null) {
                    str2 = dsq.width + Config.EVENT_HEAT_X + dsq.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    drS = this.lVs.drS();
                    String valueOf2 = String.valueOf(this.lVm.drv().dso());
                    if (z || dA) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dqq = (z || dA) ? com.facebook.imagepipeline.g.g.lTU : dqq();
                    this.lVb.fm(this.lVm.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lSl.a(eVar, size, dqq, this.lQA);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lVb.a(this.lVm.getId(), "DecodeProducer", a(a, drS, dqq, IJ, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Io(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, drS, dqq, IJ, str, str3, str2, valueOf);
                    this.lVb.a(this.lVm.getId(), "DecodeProducer", e2, a2);
                    this.lVb.a(this.lVm.drv(), eVar, e2, a2);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lVb.Pd(this.lVm.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dqD());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dqp = ((com.facebook.imagepipeline.g.d) cVar).dqp();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dqp.getWidth() + Config.EVENT_HEAT_X + dqp.getHeight());
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
            return this.lVa;
        }

        private void vu(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lVa) {
                        drH().aK(1.0f);
                        this.lVa = true;
                        this.lVs.drN();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                vu(IJ(i));
                drH().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void D(Throwable th) {
            vu(true);
            drH().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drG() {
            vu(true);
            drH().dkC();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return IK(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dqq() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lSr;
        private final com.facebook.imagepipeline.decoder.e lVq;
        private int lVr;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lVq = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lSr = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lVr = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((IK(i) || dA(i, 8)) && !dA(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dqx() == com.facebook.c.b.lPo) {
                if (this.lVq.a(eVar)) {
                    int dqk = this.lVq.dqk();
                    if (dqk <= this.lVr) {
                        b = false;
                    } else if (dqk >= this.lSr.Ih(this.lVr) || this.lVq.dql()) {
                        this.lVr = dqk;
                    } else {
                        b = false;
                    }
                } else {
                    b = false;
                }
            }
            return b;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return this.lVq.dqj();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dqq() {
            return this.lSr.Ii(this.lVq.dqk());
        }
    }
}
