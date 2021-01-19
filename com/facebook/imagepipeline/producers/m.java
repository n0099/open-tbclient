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
/* loaded from: classes3.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final aj<com.facebook.imagepipeline.f.e> pBg;
    private final boolean pBv;
    private final com.facebook.common.memory.a poU;
    private final com.facebook.imagepipeline.decoder.d pyA;
    private final boolean pyN;
    private final boolean pyr;
    private final com.facebook.imagepipeline.decoder.b pyu;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.poU = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pyu = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pyA = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pyr = z;
        this.pBv = z2;
        this.pBg = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pyN = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.ewP().exF())) {
            bVar = new a(kVar, akVar, this.pyN);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.poU), this.pyA, this.pyN);
        }
        this.pBg.a(bVar, akVar);
    }

    /* loaded from: classes3.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        @GuardedBy("this")
        private boolean pBh;
        private final am pBi;
        private final ak pBt;
        private final JobScheduler pBz;
        private final com.facebook.imagepipeline.common.b pwM;

        protected abstract com.facebook.imagepipeline.f.h evO();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pBt = akVar;
            this.pBi = akVar.ewQ();
            this.pwM = akVar.ewP().exJ();
            this.pBh = false;
            this.pBz = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pyr || !com.facebook.imagepipeline.producers.b.ef(i, 16)) {
                            ImageRequest ewP = akVar.ewP();
                            if (m.this.pBv || !com.facebook.common.util.d.K(ewP.exF())) {
                                eVar.setSampleSize(q.a(ewP, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pwM.pxC);
            this.pBt.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewY() {
                    if (c.this.pBt.ewU()) {
                        c.this.pBz.exi();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewW() {
                    if (z) {
                        c.this.exb();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean PO = PO(i);
            if (PO && !com.facebook.imagepipeline.f.e.f(eVar)) {
                E(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ef = ef(i, 4);
                if (PO || ef || this.pBt.ewU()) {
                    this.pBz.exi();
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
        public void evD() {
            exb();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.pBz.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d exH;
            String str2;
            long exm;
            int size;
            com.facebook.imagepipeline.f.h evO;
            if ((eVar.evV() == com.facebook.c.b.pvG || !PP(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c evV = eVar.evV();
                if (evV != null) {
                    str = evV.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean PO = PO(i);
                boolean z = PO && !ef(i, 8);
                boolean ef = ef(i, 4);
                if (this.pBt.ewP().exH() != null) {
                    str2 = exH.width + Config.EVENT_HEAT_X + exH.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    exm = this.pBz.exm();
                    String valueOf2 = String.valueOf(this.pBt.ewP().exF());
                    if (z || ef) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    evO = (z || ef) ? com.facebook.imagepipeline.f.g.pAb : evO();
                    this.pBi.hm(this.pBt.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pyu.a(eVar, size, evO, this.pwM);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pBi.b(this.pBt.getId(), "DecodeProducer", a(a2, exm, evO, PO, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Pt(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, exm, evO, PO, str, str3, str2, valueOf);
                    this.pBi.a(this.pBt.getId(), "DecodeProducer", e2, a3);
                    this.pBi.a(this.pBt.ewP(), eVar, e2, a3);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pBi.Yt(this.pBt.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.ewb());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap evN = ((com.facebook.imagepipeline.f.d) cVar).evN();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", evN.getWidth() + Config.EVENT_HEAT_X + evN.getHeight());
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
            return this.pBh;
        }

        private void Bd(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pBh) {
                        exc().aX(1.0f);
                        this.pBh = true;
                        this.pBz.exh();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> f = com.facebook.common.references.a.f(cVar);
            try {
                Bd(PO(i));
                exc().g(f, i);
            } finally {
                com.facebook.common.references.a.c(f);
            }
        }

        private void E(Throwable th) {
            Bd(true);
            exc().D(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void exb() {
            Bd(true);
            exc().eqc();
        }
    }

    /* loaded from: classes3.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return PP(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evO() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes3.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.e pBx;
        private int pBy;
        private final com.facebook.imagepipeline.decoder.d pyA;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pBx = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pyA = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pBy = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b2;
            b2 = super.b(eVar, i);
            if ((PP(i) || ef(i, 8)) && !ef(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.evV() == com.facebook.c.b.pvG) {
                if (this.pBx.a(eVar)) {
                    int evI = this.pBx.evI();
                    if (evI <= this.pBy) {
                        b2 = false;
                    } else if (evI >= this.pyA.Pm(this.pBy) || this.pBx.evJ()) {
                        this.pBy = evI;
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
            return this.pBx.evH();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evO() {
            return this.pyA.Pn(this.pBx.evI());
        }
    }
}
