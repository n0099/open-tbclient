package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
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
/* loaded from: classes5.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final boolean pBG;
    private final boolean pBk;
    private final com.facebook.imagepipeline.decoder.b pBn;
    private final com.facebook.imagepipeline.decoder.d pBt;
    private final aj<com.facebook.imagepipeline.f.e> pDZ;
    private final boolean pEo;
    private final com.facebook.common.memory.a pto;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pto = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pBn = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pBt = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pBk = z;
        this.pEo = z2;
        this.pDZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pBG = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.N(akVar.eAd().eAT())) {
            bVar = new a(kVar, akVar, this.pBG);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.pto), this.pBt, this.pBG);
        }
        this.pDZ.a(bVar, akVar);
    }

    /* loaded from: classes5.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        @GuardedBy("this")
        private boolean pEa;
        private final am pEb;
        private final ak pEm;
        private final JobScheduler pEs;
        private final com.facebook.imagepipeline.common.b pzF;

        protected abstract com.facebook.imagepipeline.f.h ezd();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pEm = akVar;
            this.pEb = akVar.eAe();
            this.pzF = akVar.eAd().eAX();
            this.pEa = false;
            this.pEs = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pBk || !com.facebook.imagepipeline.producers.b.ed(i, 16)) {
                            ImageRequest eAd = akVar.eAd();
                            if (m.this.pEo || !com.facebook.common.util.d.N(eAd.eAT())) {
                                eVar.setSampleSize(q.a(eAd, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pzF.pAv);
            this.pEm.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAm() {
                    if (c.this.pEm.eAi()) {
                        c.this.pEs.eAw();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAk() {
                    if (z) {
                        c.this.eAp();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Rf = Rf(i);
            if (Rf && !com.facebook.imagepipeline.f.e.f(eVar)) {
                E(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ed = ed(i, 4);
                if (Rf || ed || this.pEm.eAi()) {
                    this.pEs.eAw();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bK(float f) {
            super.bK(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void C(Throwable th) {
            E(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void eyT() {
            eAp();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.pEs.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d eAV;
            String str2;
            long eAA;
            int size;
            com.facebook.imagepipeline.f.h ezd;
            if ((eVar.ezj() == com.facebook.c.b.pyV || !Rg(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c ezj = eVar.ezj();
                if (ezj != null) {
                    str = ezj.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Rf = Rf(i);
                boolean z = Rf && !ed(i, 8);
                boolean ed = ed(i, 4);
                if (this.pEm.eAd().eAV() != null) {
                    str2 = eAV.width + "x" + eAV.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    eAA = this.pEs.eAA();
                    String valueOf2 = String.valueOf(this.pEm.eAd().eAT());
                    if (z || ed) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    ezd = (z || ed) ? com.facebook.imagepipeline.f.g.pCU : ezd();
                    this.pEb.hm(this.pEm.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pBn.a(eVar, size, ezd, this.pzF);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pEb.b(this.pEm.getId(), "DecodeProducer", a(a2, eAA, ezd, Rf, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.QJ(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, eAA, ezd, Rf, str, str3, str2, valueOf);
                    this.pEb.a(this.pEm.getId(), "DecodeProducer", e2, a3);
                    this.pEb.a(this.pEm.eAd(), eVar, e2, a3);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pEb.ZA(this.pEm.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.ezp());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap ezc = ((com.facebook.imagepipeline.f.d) cVar).ezc();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", ezc.getWidth() + "x" + ezc.getHeight());
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
            return this.pEa;
        }

        private void Bh(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pEa) {
                        eAq().aX(1.0f);
                        this.pEa = true;
                        this.pEs.eAv();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> f = com.facebook.common.references.a.f(cVar);
            try {
                Bh(Rf(i));
                eAq().g(f, i);
            } finally {
                com.facebook.common.references.a.c(f);
            }
        }

        private void E(Throwable th) {
            Bh(true);
            eAq().D(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAp() {
            Bh(true);
            eAq().etQ();
        }
    }

    /* loaded from: classes5.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Rg(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h ezd() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes5.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d pBt;
        private final com.facebook.imagepipeline.decoder.e pEq;
        private int pEr;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pEq = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pBt = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pEr = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b2;
            b2 = super.b(eVar, i);
            if ((Rg(i) || ed(i, 8)) && !ed(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.ezj() == com.facebook.c.b.pyV) {
                if (this.pEq.a(eVar)) {
                    int eyY = this.pEq.eyY();
                    if (eyY <= this.pEr) {
                        b2 = false;
                    } else if (eyY >= this.pBt.QC(this.pEr) || this.pEq.eyZ()) {
                        this.pEr = eyY;
                    } else {
                        b2 = false;
                    }
                } else {
                    b2 = false;
                }
            }
            return b2;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return this.pEq.eyX();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h ezd() {
            return this.pBt.QD(this.pEq.eyY());
        }
    }
}
