package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.mobstat.Config;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class l implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.common.memory.a jSr;
    private final com.facebook.imagepipeline.decoder.b jZC;
    private final com.facebook.imagepipeline.decoder.d jZI;
    private final boolean jZX;
    private final boolean jZy;
    private final ai<com.facebook.imagepipeline.f.d> kbZ;
    private final boolean kcm;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jSr = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jZC = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.jZI = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.jZy = z;
        this.kcm = z2;
        this.kbZ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jZX = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.y(ajVar.cHy().cIl())) {
            bVar = new a(jVar, ajVar, this.jZX);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jSr), this.jZI, this.jZX);
        }
        this.kbZ.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a jXI;
        @GuardedBy("this")
        private boolean kca;
        private final al kcc;
        private final aj kck;
        private final JobScheduler kcq;

        protected abstract com.facebook.imagepipeline.f.g cGC();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.kck = ajVar;
            this.kcc = ajVar.cHz();
            this.jXI = ajVar.cHy().cIq();
            this.kca = false;
            this.kcq = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.jZy) {
                            ImageRequest cHy = ajVar.cHy();
                            if (l.this.kcm || !com.facebook.common.util.d.y(cHy.cIl())) {
                                dVar.setSampleSize(p.b(cHy, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.jXI.jYM);
            this.kck.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHH() {
                    if (c.this.kck.cHD()) {
                        c.this.kcq.cHP();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHF() {
                    if (z) {
                        c.this.cHK();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (z && !com.facebook.imagepipeline.f.d.f(dVar)) {
                C(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(dVar, z)) {
                if (z || this.kck.cHD()) {
                    this.kcq.cHP();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void be(float f) {
            super.be(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void cGt() {
            cHK();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.kcq.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cIo;
            String str4;
            long cHT;
            com.facebook.imagepipeline.f.g cGC;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cGH = dVar.cGH();
                if (cGH != null) {
                    str = cGH.getName();
                } else {
                    str = "unknown";
                }
                if (dVar != null) {
                    str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
                    str3 = String.valueOf(dVar.getSampleSize());
                } else {
                    str2 = "unknown";
                    str3 = "unknown";
                }
                if (this.kck.cHy().cIo() != null) {
                    str4 = cIo.width + Config.EVENT_HEAT_X + cIo.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cHT = this.kcq.cHT();
                    int size = z ? dVar.getSize() : g(dVar);
                    cGC = z ? com.facebook.imagepipeline.f.f.kba : cGC();
                    this.kcc.ez(this.kck.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.jZC.a(dVar, size, cGC, this.jXI);
                    this.kcc.a(this.kck.getId(), "DecodeProducer", a(a, cHT, cGC, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.kcc.a(this.kck.getId(), "DecodeProducer", e, a(null, cHT, cGC, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.kcc.GT(this.kck.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cGM());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cGB = ((com.facebook.imagepipeline.f.c) bVar).cGB();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cGB.getWidth() + Config.EVENT_HEAT_X + cGB.getHeight());
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
            return this.kca;
        }

        private void sm(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.kca) {
                        cHL().aQ(1.0f);
                        this.kca = true;
                        this.kcq.cHO();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                sm(z);
                cHL().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void C(Throwable th) {
            sm(true);
            cHL().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cHK() {
            sm(true);
            cHL().cBA();
        }
    }

    /* loaded from: classes2.dex */
    private class a extends c {
        public a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, boolean z) {
            super(jVar, ajVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return !z ? false : super.b(dVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return dVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cGC() {
            return com.facebook.imagepipeline.f.f.f(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d jZI;
        private final com.facebook.imagepipeline.decoder.e kco;
        private int kcp;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.kco = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.jZI = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.kcp = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cGy;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.kco.a(dVar) && (cGy = this.kco.cGy()) > this.kcp && cGy >= this.jZI.Dh(this.kcp)) {
                        this.kcp = cGy;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.kco.cGx();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cGC() {
            return this.jZI.Di(this.kco.cGy());
        }
    }
}
