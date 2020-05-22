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
    private final com.facebook.common.memory.a mlM;
    private final boolean mvJ;
    private final com.facebook.imagepipeline.decoder.b mvM;
    private final com.facebook.imagepipeline.decoder.d mvS;
    private final boolean mwf;
    private final boolean myN;
    private final aj<com.facebook.imagepipeline.g.e> myy;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mlM = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mvM = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.mvS = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.mvJ = z;
        this.myN = z2;
        this.myy = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mwf = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.I(akVar.dBi().dCa())) {
            bVar = new a(kVar, akVar, this.mwf);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.mlM), this.mvS, this.mwf);
        }
        this.myy.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mub;
        private final am myA;
        private final ak myL;
        private final JobScheduler myR;
        @GuardedBy("this")
        private boolean myz;

        protected abstract com.facebook.imagepipeline.g.h dAe();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.myL = akVar;
            this.myA = akVar.dBj();
            this.mub = akVar.dBi().dCe();
            this.myz = false;
            this.myR = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.mvJ || !com.facebook.imagepipeline.producers.b.dq(i, 16)) {
                            ImageRequest dBi = akVar.dBi();
                            if (m.this.myN || !com.facebook.common.util.d.I(dBi.dCa())) {
                                eVar.setSampleSize(q.a(dBi, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mub.muT);
            this.myL.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBq() {
                    if (c.this.myL.dBn()) {
                        c.this.myR.dBB();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxA() {
                    if (z) {
                        c.this.dBt();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Id = Id(i);
            if (Id && !com.facebook.imagepipeline.g.e.f(eVar)) {
                H(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dq = dq(i, 4);
                if (Id || dq || this.myL.dBn()) {
                    this.myR.dBB();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aH(float f) {
            super.aH(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void F(Throwable th) {
            H(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dzT() {
            dBt();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.myR.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dCc;
            String str2;
            long dBF;
            int size;
            com.facebook.imagepipeline.g.h dAe;
            if ((eVar.dAl() == com.facebook.c.b.msL || !Ie(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dAl = eVar.dAl();
                if (dAl != null) {
                    str = dAl.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Id = Id(i);
                boolean z = Id && !dq(i, 8);
                boolean dq = dq(i, 4);
                if (this.myL.dBi().dCc() != null) {
                    str2 = dCc.width + Config.EVENT_HEAT_X + dCc.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dBF = this.myR.dBF();
                    String valueOf2 = String.valueOf(this.myL.dBi().dCa());
                    if (z || dq) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dAe = (z || dq) ? com.facebook.imagepipeline.g.g.mxt : dAe();
                    this.myA.fK(this.myL.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.mvM.a(eVar, size, dAe, this.mub);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.myA.a(this.myL.getId(), "DecodeProducer", a(a, dBF, dAe, Id, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.HI(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dBF, dAe, Id, str, str3, str2, valueOf);
                    this.myA.a(this.myL.getId(), "DecodeProducer", e2, a2);
                    this.myA.a(this.myL.dBi(), eVar, e2, a2);
                    H(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.myA.Qc(this.myL.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dAr());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dAd = ((com.facebook.imagepipeline.g.d) cVar).dAd();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dAd.getWidth() + Config.EVENT_HEAT_X + dAd.getHeight());
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
            return this.myz;
        }

        private void wm(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.myz) {
                        dBu().at(1.0f);
                        this.myz = true;
                        this.myR.dBA();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                wm(Id(i));
                dBu().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void H(Throwable th) {
            wm(true);
            dBu().G(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dBt() {
            wm(true);
            dBu().dum();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Ie(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dAe() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d mvS;
        private final com.facebook.imagepipeline.decoder.e myP;
        private int myQ;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.myP = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.mvS = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.myQ = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Ie(i) || dq(i, 8)) && !dq(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dAl() == com.facebook.c.b.msL) {
                if (this.myP.a(eVar)) {
                    int dzY = this.myP.dzY();
                    if (dzY <= this.myQ) {
                        b = false;
                    } else if (dzY >= this.mvS.HB(this.myQ) || this.myP.dzZ()) {
                        this.myQ = dzY;
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
            return this.myP.dzX();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dAe() {
            return this.mvS.HC(this.myP.dzY());
        }
    }
}
