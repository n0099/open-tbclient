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
/* loaded from: classes3.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final boolean pCR;
    private final com.facebook.imagepipeline.decoder.b pCU;
    private final com.facebook.imagepipeline.decoder.d pDa;
    private final boolean pDn;
    private final aj<com.facebook.imagepipeline.f.e> pFG;
    private final boolean pFV;
    private final com.facebook.common.memory.a ptw;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.ptw = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pCU = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pDa = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pCR = z;
        this.pFV = z2;
        this.pFG = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pDn = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.N(akVar.eAH().eBx())) {
            bVar = new a(kVar, akVar, this.pDn);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.ptw), this.pDa, this.pDn);
        }
        this.pFG.a(bVar, akVar);
    }

    /* loaded from: classes3.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b pBm;
        @GuardedBy("this")
        private boolean pFH;
        private final am pFI;
        private final ak pFT;
        private final JobScheduler pFZ;

        protected abstract com.facebook.imagepipeline.f.h ezG();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pFT = akVar;
            this.pFI = akVar.eAI();
            this.pBm = akVar.eAH().eBB();
            this.pFH = false;
            this.pFZ = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pCR || !com.facebook.imagepipeline.producers.b.ef(i, 16)) {
                            ImageRequest eAH = akVar.eAH();
                            if (m.this.pFV || !com.facebook.common.util.d.N(eAH.eBx())) {
                                eVar.setSampleSize(q.a(eAH, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pBm.pCc);
            this.pFT.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAQ() {
                    if (c.this.pFT.eAM()) {
                        c.this.pFZ.eBa();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAO() {
                    if (z) {
                        c.this.eAT();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Rv = Rv(i);
            if (Rv && !com.facebook.imagepipeline.f.e.f(eVar)) {
                E(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ef = ef(i, 4);
                if (Rv || ef || this.pFT.eAM()) {
                    this.pFZ.eBa();
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
        public void ezv() {
            eAT();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.pFZ.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d eBz;
            String str2;
            long eBe;
            int size;
            com.facebook.imagepipeline.f.h ezG;
            if ((eVar.ezN() == com.facebook.c.b.pAg || !Rw(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c ezN = eVar.ezN();
                if (ezN != null) {
                    str = ezN.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Rv = Rv(i);
                boolean z = Rv && !ef(i, 8);
                boolean ef = ef(i, 4);
                if (this.pFT.eAH().eBz() != null) {
                    str2 = eBz.width + "x" + eBz.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    eBe = this.pFZ.eBe();
                    String valueOf2 = String.valueOf(this.pFT.eAH().eBx());
                    if (z || ef) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    ezG = (z || ef) ? com.facebook.imagepipeline.f.g.pEB : ezG();
                    this.pFI.hn(this.pFT.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pCU.a(eVar, size, ezG, this.pBm);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pFI.b(this.pFT.getId(), "DecodeProducer", a(a2, eBe, ezG, Rv, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Ra(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, eBe, ezG, Rv, str, str3, str2, valueOf);
                    this.pFI.a(this.pFT.getId(), "DecodeProducer", e2, a3);
                    this.pFI.a(this.pFT.eAH(), eVar, e2, a3);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pFI.ZA(this.pFT.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.ezT());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap ezF = ((com.facebook.imagepipeline.f.d) cVar).ezF();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", ezF.getWidth() + "x" + ezF.getHeight());
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
            return this.pFH;
        }

        private void Bh(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pFH) {
                        eAU().aX(1.0f);
                        this.pFH = true;
                        this.pFZ.eAZ();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> f = com.facebook.common.references.a.f(cVar);
            try {
                Bh(Rv(i));
                eAU().g(f, i);
            } finally {
                com.facebook.common.references.a.c(f);
            }
        }

        private void E(Throwable th) {
            Bh(true);
            eAU().D(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eAT() {
            Bh(true);
            eAU().etW();
        }
    }

    /* loaded from: classes3.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Rw(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h ezG() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes3.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d pDa;
        private final com.facebook.imagepipeline.decoder.e pFX;
        private int pFY;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pFX = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pDa = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pFY = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b2;
            b2 = super.b(eVar, i);
            if ((Rw(i) || ef(i, 8)) && !ef(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.ezN() == com.facebook.c.b.pAg) {
                if (this.pFX.a(eVar)) {
                    int ezA = this.pFX.ezA();
                    if (ezA <= this.pFY) {
                        b2 = false;
                    } else if (ezA >= this.pDa.QT(this.pFY) || this.pFX.ezB()) {
                        this.pFY = ezA;
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
            return this.pFX.ezz();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h ezG() {
            return this.pDa.QU(this.pFX.ezA());
        }
    }
}
