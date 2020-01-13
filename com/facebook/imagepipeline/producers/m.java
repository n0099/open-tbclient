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
/* loaded from: classes10.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.common.memory.a lHR;
    private final com.facebook.imagepipeline.decoder.d lRF;
    private final boolean lRS;
    private final boolean lRw;
    private final com.facebook.imagepipeline.decoder.b lRz;
    private final boolean lUC;
    private final aj<com.facebook.imagepipeline.g.e> lUn;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lHR = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lRz = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lRF = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lRw = z;
        this.lUC = z2;
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lRS = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.B(akVar.dqh().dra())) {
            bVar = new a(kVar, akVar, this.lRS);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lHR), this.lRF, this.lRS);
        }
        this.lUn.c(bVar, akVar);
    }

    /* loaded from: classes10.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lPO;
        private final ak lUA;
        private final JobScheduler lUG;
        @GuardedBy("this")
        private boolean lUo;
        private final am lUp;

        protected abstract com.facebook.imagepipeline.g.h dpc();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lUA = akVar;
            this.lUp = akVar.dqi();
            this.lPO = akVar.dqh().dre();
            this.lUo = false;
            this.lUG = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lRw || !com.facebook.imagepipeline.producers.b.dx(i, 16)) {
                            ImageRequest dqh = akVar.dqh();
                            if (m.this.lUC || !com.facebook.common.util.d.B(dqh.dra())) {
                                eVar.setSampleSize(q.a(dqh, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lPO.lQH);
            this.lUA.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqp() {
                    if (c.this.lUA.dqm()) {
                        c.this.lUG.dqA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmy() {
                    if (z) {
                        c.this.dqs();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean IE = IE(i);
            if (IE && !com.facebook.imagepipeline.g.e.f(eVar)) {
                E(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dx = dx(i, 4);
                if (IE || dx || this.lUA.dqm()) {
                    this.lUG.dqA();
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
        public void doR() {
            dqs();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lUG.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d drc;
            String str2;
            long dqE;
            int size;
            com.facebook.imagepipeline.g.h dpc;
            if ((eVar.dpj() == com.facebook.c.b.lOC || !IF(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dpj = eVar.dpj();
                if (dpj != null) {
                    str = dpj.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean IE = IE(i);
                boolean z = IE && !dx(i, 8);
                boolean dx = dx(i, 4);
                if (this.lUA.dqh().drc() != null) {
                    str2 = drc.width + Config.EVENT_HEAT_X + drc.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dqE = this.lUG.dqE();
                    String valueOf2 = String.valueOf(this.lUA.dqh().dra());
                    if (z || dx) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dpc = (z || dx) ? com.facebook.imagepipeline.g.g.lTi : dpc();
                    this.lUp.fe(this.lUA.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lRz.a(eVar, size, dpc, this.lPO);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lUp.a(this.lUA.getId(), "DecodeProducer", a(a, dqE, dpc, IE, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Ij(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dqE, dpc, IE, str, str3, str2, valueOf);
                    this.lUp.a(this.lUA.getId(), "DecodeProducer", e2, a2);
                    this.lUp.a(this.lUA.dqh(), eVar, e2, a2);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lUp.OQ(this.lUA.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dpp());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dpb = ((com.facebook.imagepipeline.g.d) cVar).dpb();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dpb.getWidth() + Config.EVENT_HEAT_X + dpb.getHeight());
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
            return this.lUo;
        }

        private void vq(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lUo) {
                        dqt().aL(1.0f);
                        this.lUo = true;
                        this.lUG.dqz();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                vq(IE(i));
                dqt().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void E(Throwable th) {
            vq(true);
            dqt().D(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqs() {
            vq(true);
            dqt().djn();
        }
    }

    /* loaded from: classes10.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return IF(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dpc() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes10.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lRF;
        private final com.facebook.imagepipeline.decoder.e lUE;
        private int lUF;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lUE = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lRF = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lUF = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((IF(i) || dx(i, 8)) && !dx(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dpj() == com.facebook.c.b.lOC) {
                if (this.lUE.a(eVar)) {
                    int doW = this.lUE.doW();
                    if (doW <= this.lUF) {
                        b = false;
                    } else if (doW >= this.lRF.Ic(this.lUF) || this.lUE.doX()) {
                        this.lUF = doW;
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
            return this.lUE.doV();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dpc() {
            return this.lRF.Id(this.lUE.doW());
        }
    }
}
