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
    private final Executor mExecutor;
    private final com.facebook.common.memory.a mIW;
    private final boolean mSV;
    private final com.facebook.imagepipeline.decoder.b mSY;
    private final com.facebook.imagepipeline.decoder.d mTe;
    private final boolean mTt;
    private final aj<com.facebook.imagepipeline.g.e> mVP;
    private final boolean mWe;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mIW = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mSY = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.mTe = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.mSV = z;
        this.mWe = z2;
        this.mVP = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mTt = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.J(akVar.dFY().dGQ())) {
            bVar = new a(kVar, akVar, this.mTt);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.mIW), this.mTe, this.mTt);
        }
        this.mVP.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mRk;
        @GuardedBy("this")
        private boolean mVQ;
        private final am mVR;
        private final ak mWc;
        private final JobScheduler mWi;

        protected abstract com.facebook.imagepipeline.g.h dEU();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.mWc = akVar;
            this.mVR = akVar.dFZ();
            this.mRk = akVar.dFY().dGU();
            this.mVQ = false;
            this.mWi = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.mSV || !com.facebook.imagepipeline.producers.b.dz(i, 16)) {
                            ImageRequest dFY = akVar.dFY();
                            if (m.this.mWe || !com.facebook.common.util.d.J(dFY.dGQ())) {
                                eVar.setSampleSize(q.a(dFY, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mRk.mSc);
            this.mWc.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGg() {
                    if (c.this.mWc.dGd()) {
                        c.this.mWi.dGr();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dCq() {
                    if (z) {
                        c.this.dGj();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Jm = Jm(i);
            if (Jm && !com.facebook.imagepipeline.g.e.f(eVar)) {
                H(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dz = dz(i, 4);
                if (Jm || dz || this.mWc.dGd()) {
                    this.mWi.dGr();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aN(float f) {
            super.aN(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void F(Throwable th) {
            H(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dEJ() {
            dGj();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.mWi.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dGS;
            String str2;
            long dGv;
            int size;
            com.facebook.imagepipeline.g.h dEU;
            if ((eVar.dFb() == com.facebook.c.b.mPU || !Jn(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dFb = eVar.dFb();
                if (dFb != null) {
                    str = dFb.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Jm = Jm(i);
                boolean z = Jm && !dz(i, 8);
                boolean dz = dz(i, 4);
                if (this.mWc.dFY().dGS() != null) {
                    str2 = dGS.width + Config.EVENT_HEAT_X + dGS.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dGv = this.mWi.dGv();
                    String valueOf2 = String.valueOf(this.mWc.dFY().dGQ());
                    if (z || dz) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dEU = (z || dz) ? com.facebook.imagepipeline.g.g.mUK : dEU();
                    this.mVR.fU(this.mWc.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.mSY.a(eVar, size, dEU, this.mRk);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.mVR.a(this.mWc.getId(), "DecodeProducer", a(a, dGv, dEU, Jm, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.IR(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dGv, dEU, Jm, str, str3, str2, valueOf);
                    this.mVR.a(this.mWc.getId(), "DecodeProducer", e2, a2);
                    this.mVR.a(this.mWc.dFY(), eVar, e2, a2);
                    H(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.mVR.QP(this.mWc.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dFh());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dET = ((com.facebook.imagepipeline.g.d) cVar).dET();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dET.getWidth() + Config.EVENT_HEAT_X + dET.getHeight());
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
            return this.mVQ;
        }

        private void wK(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mVQ) {
                        dGk().ay(1.0f);
                        this.mVQ = true;
                        this.mWi.dGq();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                wK(Jm(i));
                dGk().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void H(Throwable th) {
            wK(true);
            dGk().G(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGj() {
            wK(true);
            dGk().dzd();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Jn(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dEU() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d mTe;
        private final com.facebook.imagepipeline.decoder.e mWg;
        private int mWh;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.mWg = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.mTe = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.mWh = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Jn(i) || dz(i, 8)) && !dz(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dFb() == com.facebook.c.b.mPU) {
                if (this.mWg.a(eVar)) {
                    int dEO = this.mWg.dEO();
                    if (dEO <= this.mWh) {
                        b = false;
                    } else if (dEO >= this.mTe.IK(this.mWh) || this.mWg.dEP()) {
                        this.mWh = dEO;
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
            return this.mWg.dEN();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dEU() {
            return this.mTe.IL(this.mWg.dEO());
        }
    }
}
