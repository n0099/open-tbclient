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
/* loaded from: classes5.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final com.facebook.imagepipeline.decoder.b pIC;
    private final com.facebook.imagepipeline.decoder.d pII;
    private final boolean pIV;
    private final boolean pIz;
    private final boolean pLD;
    private final aj<com.facebook.imagepipeline.f.e> pLo;
    private final com.facebook.common.memory.a pze;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pze = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pIC = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pII = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pIz = z;
        this.pLD = z2;
        this.pLo = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pIV = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.ezh().ezX())) {
            bVar = new a(kVar, akVar, this.pIV);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.pze), this.pII, this.pIV);
        }
        this.pLo.a(bVar, akVar);
    }

    /* loaded from: classes5.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b pGU;
        private final ak pLB;
        private final JobScheduler pLH;
        @GuardedBy("this")
        private boolean pLp;
        private final am pLq;

        protected abstract com.facebook.imagepipeline.f.h eyh();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pLB = akVar;
            this.pLq = akVar.ezi();
            this.pGU = akVar.ezh().eAb();
            this.pLp = false;
            this.pLH = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pIz || !com.facebook.imagepipeline.producers.b.ec(i, 16)) {
                            ImageRequest ezh = akVar.ezh();
                            if (m.this.pLD || !com.facebook.common.util.d.K(ezh.ezX())) {
                                eVar.setSampleSize(q.a(ezh, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pGU.pHK);
            this.pLB.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezq() {
                    if (c.this.pLB.ezm()) {
                        c.this.pLH.ezA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezo() {
                    if (z) {
                        c.this.ezt();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Qj = Qj(i);
            if (Qj && !com.facebook.imagepipeline.f.e.f(eVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ec = ec(i, 4);
                if (Qj || ec || this.pLB.ezm()) {
                    this.pLH.ezA();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bN(float f) {
            super.bN(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void exW() {
            ezt();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.pLH.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d ezZ;
            String str2;
            long ezE;
            int size;
            com.facebook.imagepipeline.f.h eyh;
            if ((eVar.eyo() == com.facebook.c.b.pFO || !Qk(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c eyo = eVar.eyo();
                if (eyo != null) {
                    str = eyo.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Qj = Qj(i);
                boolean z = Qj && !ec(i, 8);
                boolean ec = ec(i, 4);
                if (this.pLB.ezh().ezZ() != null) {
                    str2 = ezZ.width + Config.EVENT_HEAT_X + ezZ.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    ezE = this.pLH.ezE();
                    String valueOf2 = String.valueOf(this.pLB.ezh().ezX());
                    if (z || ec) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    eyh = (z || ec) ? com.facebook.imagepipeline.f.g.pKj : eyh();
                    this.pLq.ht(this.pLB.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pIC.a(eVar, size, eyh, this.pGU);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pLq.b(this.pLB.getId(), "DecodeProducer", a(a2, ezE, eyh, Qj, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.PO(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, ezE, eyh, Qj, str, str3, str2, valueOf);
                    this.pLq.a(this.pLB.getId(), "DecodeProducer", e2, a3);
                    this.pLq.a(this.pLB.ezh(), eVar, e2, a3);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pLq.Zu(this.pLB.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.eyt());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap eyg = ((com.facebook.imagepipeline.f.d) cVar).eyg();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", eyg.getWidth() + Config.EVENT_HEAT_X + eyg.getHeight());
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
            return this.pLp;
        }

        private void Bw(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pLp) {
                        ezu().ba(1.0f);
                        this.pLp = true;
                        this.pLH.ezz();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> e = com.facebook.common.references.a.e(cVar);
            try {
                Bw(Qj(i));
                ezu().g(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void D(Throwable th) {
            Bw(true);
            ezu().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezt() {
            Bw(true);
            ezu().esv();
        }
    }

    /* loaded from: classes5.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Qk(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h eyh() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes5.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d pII;
        private final com.facebook.imagepipeline.decoder.e pLF;
        private int pLG;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pLF = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pII = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pLG = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b2;
            b2 = super.b(eVar, i);
            if ((Qk(i) || ec(i, 8)) && !ec(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.eyo() == com.facebook.c.b.pFO) {
                if (this.pLF.a(eVar)) {
                    int eyb = this.pLF.eyb();
                    if (eyb <= this.pLG) {
                        b2 = false;
                    } else if (eyb >= this.pII.PH(this.pLG) || this.pLF.eyc()) {
                        this.pLG = eyb;
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
            return this.pLF.eya();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h eyh() {
            return this.pII.PI(this.pLF.eyb());
        }
    }
}
