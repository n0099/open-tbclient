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
    private final com.facebook.common.memory.a mmW;
    private final boolean mwT;
    private final com.facebook.imagepipeline.decoder.b mwW;
    private final com.facebook.imagepipeline.decoder.d mxc;
    private final boolean mxp;
    private final aj<com.facebook.imagepipeline.g.e> mzI;
    private final boolean mzX;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mmW = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mwW = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.mxc = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.mwT = z;
        this.mzX = z2;
        this.mzI = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mxp = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.I(akVar.dBw().dCo())) {
            bVar = new a(kVar, akVar, this.mxp);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.mmW), this.mxc, this.mxp);
        }
        this.mzI.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final JobScheduler mAb;
        private final com.facebook.imagepipeline.common.b mvl;
        @GuardedBy("this")
        private boolean mzJ;
        private final am mzK;
        private final ak mzV;

        protected abstract com.facebook.imagepipeline.g.h dAs();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.mzV = akVar;
            this.mzK = akVar.dBx();
            this.mvl = akVar.dBw().dCs();
            this.mzJ = false;
            this.mAb = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.mwT || !com.facebook.imagepipeline.producers.b.dq(i, 16)) {
                            ImageRequest dBw = akVar.dBw();
                            if (m.this.mzX || !com.facebook.common.util.d.I(dBw.dCo())) {
                                eVar.setSampleSize(q.a(dBw, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mvl.mwd);
            this.mzV.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBE() {
                    if (c.this.mzV.dBB()) {
                        c.this.mAb.dBP();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxO() {
                    if (z) {
                        c.this.dBH();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean If = If(i);
            if (If && !com.facebook.imagepipeline.g.e.f(eVar)) {
                H(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dq = dq(i, 4);
                if (If || dq || this.mzV.dBB()) {
                    this.mAb.dBP();
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
        public void dAh() {
            dBH();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.mAb.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dCq;
            String str2;
            long dBT;
            int size;
            com.facebook.imagepipeline.g.h dAs;
            if ((eVar.dAz() == com.facebook.c.b.mtV || !Ig(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dAz = eVar.dAz();
                if (dAz != null) {
                    str = dAz.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean If = If(i);
                boolean z = If && !dq(i, 8);
                boolean dq = dq(i, 4);
                if (this.mzV.dBw().dCq() != null) {
                    str2 = dCq.width + Config.EVENT_HEAT_X + dCq.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dBT = this.mAb.dBT();
                    String valueOf2 = String.valueOf(this.mzV.dBw().dCo());
                    if (z || dq) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dAs = (z || dq) ? com.facebook.imagepipeline.g.g.myD : dAs();
                    this.mzK.fK(this.mzV.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.mwW.a(eVar, size, dAs, this.mvl);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.mzK.a(this.mzV.getId(), "DecodeProducer", a(a, dBT, dAs, If, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.HK(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dBT, dAs, If, str, str3, str2, valueOf);
                    this.mzK.a(this.mzV.getId(), "DecodeProducer", e2, a2);
                    this.mzK.a(this.mzV.dBw(), eVar, e2, a2);
                    H(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.mzK.Qd(this.mzV.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dAF());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dAr = ((com.facebook.imagepipeline.g.d) cVar).dAr();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dAr.getWidth() + Config.EVENT_HEAT_X + dAr.getHeight());
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
            return this.mzJ;
        }

        private void wo(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mzJ) {
                        dBI().at(1.0f);
                        this.mzJ = true;
                        this.mAb.dBO();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                wo(If(i));
                dBI().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void H(Throwable th) {
            wo(true);
            dBI().G(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dBH() {
            wo(true);
            dBI().duA();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Ig(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dAs() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private int mAa;
        private final com.facebook.imagepipeline.decoder.d mxc;
        private final com.facebook.imagepipeline.decoder.e mzZ;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.mzZ = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.mxc = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.mAa = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Ig(i) || dq(i, 8)) && !dq(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dAz() == com.facebook.c.b.mtV) {
                if (this.mzZ.a(eVar)) {
                    int dAm = this.mzZ.dAm();
                    if (dAm <= this.mAa) {
                        b = false;
                    } else if (dAm >= this.mxc.HD(this.mAa) || this.mzZ.dAn()) {
                        this.mAa = dAm;
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
            return this.mzZ.dAl();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dAs() {
            return this.mxc.HE(this.mzZ.dAm());
        }
    }
}
