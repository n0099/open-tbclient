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
    private final com.facebook.common.memory.a lIQ;
    private final com.facebook.imagepipeline.decoder.d lSE;
    private final boolean lSR;
    private final boolean lSv;
    private final com.facebook.imagepipeline.decoder.b lSy;
    private final boolean lVB;
    private final aj<com.facebook.imagepipeline.g.e> lVm;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lIQ = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lSy = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lSE = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lSv = z;
        this.lVB = z2;
        this.lVm = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lSR = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.C(akVar.dry().dsr())) {
            bVar = new a(kVar, akVar, this.lSR);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lIQ), this.lSE, this.lSR);
        }
        this.lVm.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lQN;
        private final JobScheduler lVF;
        @GuardedBy("this")
        private boolean lVn;
        private final am lVo;
        private final ak lVz;

        protected abstract com.facebook.imagepipeline.g.h dqt();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lVz = akVar;
            this.lVo = akVar.drz();
            this.lQN = akVar.dry().dsv();
            this.lVn = false;
            this.lVF = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lSv || !com.facebook.imagepipeline.producers.b.dA(i, 16)) {
                            ImageRequest dry = akVar.dry();
                            if (m.this.lVB || !com.facebook.common.util.d.C(dry.dsr())) {
                                eVar.setSampleSize(q.a(dry, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lQN.lRG);
            this.lVz.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drG() {
                    if (c.this.lVz.drD()) {
                        c.this.lVF.drR();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnQ() {
                    if (z) {
                        c.this.drJ();
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
                if (IJ || dA || this.lVz.drD()) {
                    this.lVF.drR();
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
        public void dqi() {
            drJ();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lVF.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dst;
            String str2;
            long drV;
            int size;
            com.facebook.imagepipeline.g.h dqt;
            if ((eVar.dqA() == com.facebook.c.b.lPB || !IK(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dqA = eVar.dqA();
                if (dqA != null) {
                    str = dqA.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean IJ = IJ(i);
                boolean z = IJ && !dA(i, 8);
                boolean dA = dA(i, 4);
                if (this.lVz.dry().dst() != null) {
                    str2 = dst.width + Config.EVENT_HEAT_X + dst.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    drV = this.lVF.drV();
                    String valueOf2 = String.valueOf(this.lVz.dry().dsr());
                    if (z || dA) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dqt = (z || dA) ? com.facebook.imagepipeline.g.g.lUh : dqt();
                    this.lVo.fm(this.lVz.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lSy.a(eVar, size, dqt, this.lQN);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lVo.a(this.lVz.getId(), "DecodeProducer", a(a, drV, dqt, IJ, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Io(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, drV, dqt, IJ, str, str3, str2, valueOf);
                    this.lVo.a(this.lVz.getId(), "DecodeProducer", e2, a2);
                    this.lVo.a(this.lVz.dry(), eVar, e2, a2);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lVo.Pe(this.lVz.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dqG());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dqs = ((com.facebook.imagepipeline.g.d) cVar).dqs();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dqs.getWidth() + Config.EVENT_HEAT_X + dqs.getHeight());
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
            return this.lVn;
        }

        private void vu(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lVn) {
                        drK().aK(1.0f);
                        this.lVn = true;
                        this.lVF.drQ();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                vu(IJ(i));
                drK().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void D(Throwable th) {
            vu(true);
            drK().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drJ() {
            vu(true);
            drK().dkF();
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
        protected com.facebook.imagepipeline.g.h dqt() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lSE;
        private final com.facebook.imagepipeline.decoder.e lVD;
        private int lVE;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lVD = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lSE = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lVE = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((IK(i) || dA(i, 8)) && !dA(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dqA() == com.facebook.c.b.lPB) {
                if (this.lVD.a(eVar)) {
                    int dqn = this.lVD.dqn();
                    if (dqn <= this.lVE) {
                        b = false;
                    } else if (dqn >= this.lSE.Ih(this.lVE) || this.lVD.dqo()) {
                        this.lVE = dqn;
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
            return this.lVD.dqm();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dqt() {
            return this.lSE.Ii(this.lVD.dqn());
        }
    }
}
