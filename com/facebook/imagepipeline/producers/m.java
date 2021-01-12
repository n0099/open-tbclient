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
    private final aj<com.facebook.imagepipeline.f.e> pBf;
    private final boolean pBu;
    private final com.facebook.common.memory.a poT;
    private final boolean pyM;
    private final boolean pyq;
    private final com.facebook.imagepipeline.decoder.b pyt;
    private final com.facebook.imagepipeline.decoder.d pyz;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.poT = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pyt = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pyz = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pyq = z;
        this.pBu = z2;
        this.pBf = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pyM = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.ewP().exF())) {
            bVar = new a(kVar, akVar, this.pyM);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.poT), this.pyz, this.pyM);
        }
        this.pBf.a(bVar, akVar);
    }

    /* loaded from: classes3.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        @GuardedBy("this")
        private boolean pBg;
        private final am pBh;
        private final ak pBs;
        private final JobScheduler pBy;
        private final com.facebook.imagepipeline.common.b pwL;

        protected abstract com.facebook.imagepipeline.f.h evO();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pBs = akVar;
            this.pBh = akVar.ewQ();
            this.pwL = akVar.ewP().exJ();
            this.pBg = false;
            this.pBy = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pyq || !com.facebook.imagepipeline.producers.b.ef(i, 16)) {
                            ImageRequest ewP = akVar.ewP();
                            if (m.this.pBu || !com.facebook.common.util.d.K(ewP.exF())) {
                                eVar.setSampleSize(q.a(ewP, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pwL.pxB);
            this.pBs.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewY() {
                    if (c.this.pBs.ewU()) {
                        c.this.pBy.exi();
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
                if (PO || ef || this.pBs.ewU()) {
                    this.pBy.exi();
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
            return this.pBy.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d exH;
            String str2;
            long exm;
            int size;
            com.facebook.imagepipeline.f.h evO;
            if ((eVar.evV() == com.facebook.c.b.pvF || !PP(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
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
                if (this.pBs.ewP().exH() != null) {
                    str2 = exH.width + Config.EVENT_HEAT_X + exH.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    exm = this.pBy.exm();
                    String valueOf2 = String.valueOf(this.pBs.ewP().exF());
                    if (z || ef) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    evO = (z || ef) ? com.facebook.imagepipeline.f.g.pAa : evO();
                    this.pBh.hm(this.pBs.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pyt.a(eVar, size, evO, this.pwL);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pBh.b(this.pBs.getId(), "DecodeProducer", a(a2, exm, evO, PO, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Pt(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, exm, evO, PO, str, str3, str2, valueOf);
                    this.pBh.a(this.pBs.getId(), "DecodeProducer", e2, a3);
                    this.pBh.a(this.pBs.ewP(), eVar, e2, a3);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pBh.Ys(this.pBs.getId())) {
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
            return this.pBg;
        }

        private void Bd(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pBg) {
                        exc().aX(1.0f);
                        this.pBg = true;
                        this.pBy.exh();
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
        private final com.facebook.imagepipeline.decoder.e pBw;
        private int pBx;
        private final com.facebook.imagepipeline.decoder.d pyz;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pBw = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pyz = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pBx = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b2;
            b2 = super.b(eVar, i);
            if ((PP(i) || ef(i, 8)) && !ef(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.evV() == com.facebook.c.b.pvF) {
                if (this.pBw.a(eVar)) {
                    int evI = this.pBw.evI();
                    if (evI <= this.pBx) {
                        b2 = false;
                    } else if (evI >= this.pyz.Pm(this.pBx) || this.pBw.evJ()) {
                        this.pBx = evI;
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
            return this.pBw.evH();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evO() {
            return this.pyz.Pn(this.pBw.evI());
        }
    }
}
