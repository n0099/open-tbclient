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
/* loaded from: classes15.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a pcj;
    private final boolean plH;
    private final com.facebook.imagepipeline.decoder.b plK;
    private final com.facebook.imagepipeline.decoder.d plQ;
    private final boolean pmd;
    private final boolean poO;
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pcj = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.plK = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.plQ = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.plH = z;
        this.poO = z2;
        this.poz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pmd = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.M(akVar.eww().exm())) {
            bVar = new a(kVar, akVar, this.pmd);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.pcj), this.plQ, this.pmd);
        }
        this.poz.a(bVar, akVar);
    }

    /* loaded from: classes15.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b pka;
        @GuardedBy("this")
        private boolean poA;
        private final am poB;
        private final ak poM;
        private final JobScheduler poS;

        protected abstract com.facebook.imagepipeline.f.h evv();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.poM = akVar;
            this.poB = akVar.ewx();
            this.pka = akVar.eww().exq();
            this.poA = false;
            this.poS = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.plH || !com.facebook.imagepipeline.producers.b.ef(i, 16)) {
                            ImageRequest eww = akVar.eww();
                            if (m.this.poO || !com.facebook.common.util.d.M(eww.exm())) {
                                eVar.setSampleSize(q.a(eww, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pka.pkR);
            this.poM.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewF() {
                    if (c.this.poM.ewB()) {
                        c.this.poS.ewP();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewD() {
                    if (z) {
                        c.this.ewI();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Rh = Rh(i);
            if (Rh && !com.facebook.imagepipeline.f.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ef = ef(i, 4);
                if (Rh || ef || this.poM.ewB()) {
                    this.poS.ewP();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void by(float f) {
            super.by(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void D(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void evk() {
            ewI();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.poS.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d exo;
            String str2;
            long ewT;
            int size;
            com.facebook.imagepipeline.f.h evv;
            if ((eVar.evC() == com.facebook.c.b.piU || !Ri(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c evC = eVar.evC();
                if (evC != null) {
                    str = evC.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Rh = Rh(i);
                boolean z = Rh && !ef(i, 8);
                boolean ef = ef(i, 4);
                if (this.poM.eww().exo() != null) {
                    str2 = exo.width + "x" + exo.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    ewT = this.poS.ewT();
                    String valueOf2 = String.valueOf(this.poM.eww().exm());
                    if (z || ef) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    evv = (z || ef) ? com.facebook.imagepipeline.f.g.pnr : evv();
                    this.poB.hh(this.poM.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.plK.a(eVar, size, evv, this.pka);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.poB.a(this.poM.getId(), "DecodeProducer", a(a2, ewT, evv, Rh, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.QM(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, ewT, evv, Rh, str, str3, str2, valueOf);
                    this.poB.a(this.poM.getId(), "DecodeProducer", e2, a3);
                    this.poB.a(this.poM.eww(), eVar, e2, a3);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.poB.Zq(this.poM.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.evI());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap evu = ((com.facebook.imagepipeline.f.d) cVar).evu();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", evu.getWidth() + "x" + evu.getHeight());
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
            return this.poA;
        }

        private void AZ(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.poA) {
                        ewJ().aV(1.0f);
                        this.poA = true;
                        this.poS.ewO();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> e = com.facebook.common.references.a.e(cVar);
            try {
                AZ(Rh(i));
                ewJ().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            AZ(true);
            ewJ().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ewI() {
            AZ(true);
            ewJ().epN();
        }
    }

    /* loaded from: classes15.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Ri(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evv() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes15.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d plQ;
        private final com.facebook.imagepipeline.decoder.e poQ;
        private int poR;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.poQ = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.plQ = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.poR = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Ri(i) || ef(i, 8)) && !ef(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.evC() == com.facebook.c.b.piU) {
                if (this.poQ.a(eVar)) {
                    int evp = this.poQ.evp();
                    if (evp <= this.poR) {
                        b = false;
                    } else if (evp >= this.plQ.QF(this.poR) || this.poQ.evq()) {
                        this.poR = evp;
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
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return this.poQ.evo();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evv() {
            return this.plQ.QG(this.poQ.evp());
        }
    }
}
