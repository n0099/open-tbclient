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
    private final com.facebook.common.memory.a pBJ;
    private final boolean pLA;
    private final boolean pLe;
    private final com.facebook.imagepipeline.decoder.b pLh;
    private final com.facebook.imagepipeline.decoder.d pLn;
    private final aj<com.facebook.imagepipeline.f.e> pNT;
    private final boolean pOi;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pBJ = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pLh = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pLn = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pLe = z;
        this.pOi = z2;
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pLA = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.ezy().eAo())) {
            bVar = new a(kVar, akVar, this.pLA);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.pBJ), this.pLn, this.pLA);
        }
        this.pNT.a(bVar, akVar);
    }

    /* loaded from: classes5.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b pJz;
        @GuardedBy("this")
        private boolean pNU;
        private final am pNV;
        private final ak pOg;
        private final JobScheduler pOm;

        protected abstract com.facebook.imagepipeline.f.h eyy();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pOg = akVar;
            this.pNV = akVar.ezz();
            this.pJz = akVar.ezy().eAs();
            this.pNU = false;
            this.pOm = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pLe || !com.facebook.imagepipeline.producers.b.ed(i, 16)) {
                            ImageRequest ezy = akVar.ezy();
                            if (m.this.pOi || !com.facebook.common.util.d.K(ezy.eAo())) {
                                eVar.setSampleSize(q.a(ezy, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pJz.pKp);
            this.pOg.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezH() {
                    if (c.this.pOg.ezD()) {
                        c.this.pOm.ezR();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezF() {
                    if (z) {
                        c.this.ezK();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Qo = Qo(i);
            if (Qo && !com.facebook.imagepipeline.f.e.f(eVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ed = ed(i, 4);
                if (Qo || ed || this.pOg.ezD()) {
                    this.pOm.ezR();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bR(float f) {
            super.bR(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void eyn() {
            ezK();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.pOm.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d eAq;
            String str2;
            long ezV;
            int size;
            com.facebook.imagepipeline.f.h eyy;
            if ((eVar.eyF() == com.facebook.c.b.pIt || !Qp(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c eyF = eVar.eyF();
                if (eyF != null) {
                    str = eyF.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Qo = Qo(i);
                boolean z = Qo && !ed(i, 8);
                boolean ed = ed(i, 4);
                if (this.pOg.ezy().eAq() != null) {
                    str2 = eAq.width + Config.EVENT_HEAT_X + eAq.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    ezV = this.pOm.ezV();
                    String valueOf2 = String.valueOf(this.pOg.ezy().eAo());
                    if (z || ed) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    eyy = (z || ed) ? com.facebook.imagepipeline.f.g.pMO : eyy();
                    this.pNV.hv(this.pOg.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pLh.a(eVar, size, eyy, this.pJz);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pNV.b(this.pOg.getId(), "DecodeProducer", a(a2, ezV, eyy, Qo, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.PT(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, ezV, eyy, Qo, str, str3, str2, valueOf);
                    this.pNV.a(this.pOg.getId(), "DecodeProducer", e2, a3);
                    this.pNV.a(this.pOg.ezy(), eVar, e2, a3);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pNV.ZM(this.pOg.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.eyK());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap eyx = ((com.facebook.imagepipeline.f.d) cVar).eyx();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", eyx.getWidth() + Config.EVENT_HEAT_X + eyx.getHeight());
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
            return this.pNU;
        }

        private void Bu(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pNU) {
                        ezL().be(1.0f);
                        this.pNU = true;
                        this.pOm.ezQ();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> d = com.facebook.common.references.a.d(cVar);
            try {
                Bu(Qo(i));
                ezL().f(d, i);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void D(Throwable th) {
            Bu(true);
            ezL().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezK() {
            Bu(true);
            ezL().esM();
        }
    }

    /* loaded from: classes5.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Qp(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h eyy() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes5.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d pLn;
        private final com.facebook.imagepipeline.decoder.e pOk;
        private int pOl;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pOk = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pLn = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pOl = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Qp(i) || ed(i, 8)) && !ed(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.eyF() == com.facebook.c.b.pIt) {
                if (this.pOk.a(eVar)) {
                    int eys = this.pOk.eys();
                    if (eys <= this.pOl) {
                        b = false;
                    } else if (eys >= this.pLn.PM(this.pOl) || this.pOk.eyt()) {
                        this.pOl = eys;
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
            return this.pOk.eyr();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h eyy() {
            return this.pLn.PN(this.pOk.eys());
        }
    }
}
