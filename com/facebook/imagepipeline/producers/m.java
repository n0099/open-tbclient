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
    private final com.facebook.common.memory.a lIF;
    private final boolean lSG;
    private final boolean lSk;
    private final com.facebook.imagepipeline.decoder.b lSn;
    private final com.facebook.imagepipeline.decoder.d lSt;
    private final aj<com.facebook.imagepipeline.g.e> lVb;
    private final boolean lVq;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lIF = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lSn = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lSt = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lSk = z;
        this.lVq = z2;
        this.lVb = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lSG = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.C(akVar.drx().dsq())) {
            bVar = new a(kVar, akVar, this.lSG);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lIF), this.lSt, this.lSG);
        }
        this.lVb.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lQC;
        @GuardedBy("this")
        private boolean lVc;
        private final am lVd;
        private final ak lVo;
        private final JobScheduler lVu;

        protected abstract com.facebook.imagepipeline.g.h dqs();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lVo = akVar;
            this.lVd = akVar.dry();
            this.lQC = akVar.drx().dsu();
            this.lVc = false;
            this.lVu = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lSk || !com.facebook.imagepipeline.producers.b.dA(i, 16)) {
                            ImageRequest drx = akVar.drx();
                            if (m.this.lVq || !com.facebook.common.util.d.C(drx.dsq())) {
                                eVar.setSampleSize(q.a(drx, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lQC.lRv);
            this.lVo.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drF() {
                    if (c.this.lVo.drC()) {
                        c.this.lVu.drQ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnP() {
                    if (z) {
                        c.this.drI();
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
                if (IJ || dA || this.lVo.drC()) {
                    this.lVu.drQ();
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
        public void dqh() {
            drI();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lVu.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dss;
            String str2;
            long drU;
            int size;
            com.facebook.imagepipeline.g.h dqs;
            if ((eVar.dqz() == com.facebook.c.b.lPq || !IK(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dqz = eVar.dqz();
                if (dqz != null) {
                    str = dqz.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean IJ = IJ(i);
                boolean z = IJ && !dA(i, 8);
                boolean dA = dA(i, 4);
                if (this.lVo.drx().dss() != null) {
                    str2 = dss.width + Config.EVENT_HEAT_X + dss.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    drU = this.lVu.drU();
                    String valueOf2 = String.valueOf(this.lVo.drx().dsq());
                    if (z || dA) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dqs = (z || dA) ? com.facebook.imagepipeline.g.g.lTW : dqs();
                    this.lVd.fm(this.lVo.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lSn.a(eVar, size, dqs, this.lQC);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lVd.a(this.lVo.getId(), "DecodeProducer", a(a, drU, dqs, IJ, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Io(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, drU, dqs, IJ, str, str3, str2, valueOf);
                    this.lVd.a(this.lVo.getId(), "DecodeProducer", e2, a2);
                    this.lVd.a(this.lVo.drx(), eVar, e2, a2);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lVd.Pd(this.lVo.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dqF());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dqr = ((com.facebook.imagepipeline.g.d) cVar).dqr();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dqr.getWidth() + Config.EVENT_HEAT_X + dqr.getHeight());
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
            return this.lVc;
        }

        private void vu(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lVc) {
                        drJ().aK(1.0f);
                        this.lVc = true;
                        this.lVu.drP();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                vu(IJ(i));
                drJ().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void D(Throwable th) {
            vu(true);
            drJ().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drI() {
            vu(true);
            drJ().dkE();
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
        protected com.facebook.imagepipeline.g.h dqs() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lSt;
        private final com.facebook.imagepipeline.decoder.e lVs;
        private int lVt;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lVs = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lSt = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lVt = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((IK(i) || dA(i, 8)) && !dA(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dqz() == com.facebook.c.b.lPq) {
                if (this.lVs.a(eVar)) {
                    int dqm = this.lVs.dqm();
                    if (dqm <= this.lVt) {
                        b = false;
                    } else if (dqm >= this.lSt.Ih(this.lVt) || this.lVs.dqn()) {
                        this.lVt = dqm;
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
            return this.lVs.dql();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dqs() {
            return this.lSt.Ii(this.lVs.dqm());
        }
    }
}
