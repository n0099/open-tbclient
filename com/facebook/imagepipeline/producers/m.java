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
/* loaded from: classes9.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.common.memory.a lEt;
    private final boolean lNK;
    private final com.facebook.imagepipeline.decoder.b lNN;
    private final com.facebook.imagepipeline.decoder.d lNT;
    private final boolean lOg;
    private final boolean lQO;
    private final aj<com.facebook.imagepipeline.g.e> lQz;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lEt = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lNN = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lNT = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lNK = z;
        this.lQO = z2;
        this.lQz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lOg = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.B(akVar.doX().dpN())) {
            bVar = new a(kVar, akVar, this.lOg);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lEt), this.lNT, this.lOg);
        }
        this.lQz.c(bVar, akVar);
    }

    /* loaded from: classes9.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lMd;
        @GuardedBy("this")
        private boolean lQA;
        private final am lQB;
        private final ak lQM;
        private final JobScheduler lQS;

        protected abstract com.facebook.imagepipeline.g.h dnW();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lQM = akVar;
            this.lQB = akVar.doY();
            this.lMd = akVar.doX().dpR();
            this.lQA = false;
            this.lQS = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lNK || !com.facebook.imagepipeline.producers.b.dz(i, 16)) {
                            ImageRequest doX = akVar.doX();
                            if (m.this.lQO || !com.facebook.common.util.d.B(doX.dpN())) {
                                eVar.setSampleSize(q.a(doX, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lMd.lMV);
            this.lQM.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dpf() {
                    if (c.this.lQM.dpc()) {
                        c.this.lQS.dpq();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dlt() {
                    if (z) {
                        c.this.dpi();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Iv = Iv(i);
            if (Iv && !com.facebook.imagepipeline.g.e.f(eVar)) {
                E(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dz = dz(i, 4);
                if (Iv || dz || this.lQM.dpc()) {
                    this.lQS.dpq();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bt(float f) {
            super.bt(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void C(Throwable th) {
            E(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dnL() {
            dpi();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lQS.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dpP;
            String str2;
            long dpu;
            int size;
            com.facebook.imagepipeline.g.h dnW;
            if ((eVar.dod() == com.facebook.c.b.lKR || !Iw(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dod = eVar.dod();
                if (dod != null) {
                    str = dod.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Iv = Iv(i);
                boolean z = Iv && !dz(i, 8);
                boolean dz = dz(i, 4);
                if (this.lQM.doX().dpP() != null) {
                    str2 = dpP.width + Config.EVENT_HEAT_X + dpP.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dpu = this.lQS.dpu();
                    String valueOf2 = String.valueOf(this.lQM.doX().dpN());
                    if (z || dz) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dnW = (z || dz) ? com.facebook.imagepipeline.g.g.lPw : dnW();
                    this.lQB.fc(this.lQM.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lNN.a(eVar, size, dnW, this.lMd);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lQB.a(this.lQM.getId(), "DecodeProducer", a(a, dpu, dnW, Iv, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Ia(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dpu, dnW, Iv, str, str3, str2, valueOf);
                    this.lQB.a(this.lQM.getId(), "DecodeProducer", e2, a2);
                    this.lQB.a(this.lQM.doX(), eVar, e2, a2);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lQB.OF(this.lQM.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.doj());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dnV = ((com.facebook.imagepipeline.g.d) cVar).dnV();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dnV.getWidth() + Config.EVENT_HEAT_X + dnV.getHeight());
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
            return this.lQA;
        }

        private void ve(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lQA) {
                        dpj().aM(1.0f);
                        this.lQA = true;
                        this.lQS.dpp();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                ve(Iv(i));
                dpj().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void E(Throwable th) {
            ve(true);
            dpj().D(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dpi() {
            ve(true);
            dpj().dim();
        }
    }

    /* loaded from: classes9.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Iw(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dnW() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes9.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lNT;
        private final com.facebook.imagepipeline.decoder.e lQQ;
        private int lQR;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lQQ = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lNT = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lQR = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Iw(i) || dz(i, 8)) && !dz(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dod() == com.facebook.c.b.lKR) {
                if (this.lQQ.a(eVar)) {
                    int dnQ = this.lQQ.dnQ();
                    if (dnQ <= this.lQR) {
                        b = false;
                    } else if (dnQ >= this.lNT.HT(this.lQR) || this.lQQ.dnR()) {
                        this.lQR = dnQ;
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
            return this.lQQ.dnP();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dnW() {
            return this.lNT.HU(this.lQQ.dnQ());
        }
    }
}
