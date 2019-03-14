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
    private final com.facebook.common.memory.a jAf;
    private final boolean jHO;
    private final boolean jHp;
    private final com.facebook.imagepipeline.decoder.b jHt;
    private final com.facebook.imagepipeline.decoder.d jHz;
    private final ai<com.facebook.imagepipeline.f.d> jJQ;
    private final boolean jKd;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jAf = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jHt = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.jHz = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.jHp = z;
        this.jKd = z2;
        this.jJQ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHO = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.s(ajVar.czH().cAu())) {
            bVar = new a(jVar, ajVar, this.jHO);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jAf), this.jHz, this.jHO);
        }
        this.jJQ.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a jFz;
        @GuardedBy("this")
        private boolean jJR;
        private final al jJT;
        private final aj jKb;
        private final JobScheduler jKh;

        protected abstract com.facebook.imagepipeline.f.g cyL();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.jKb = ajVar;
            this.jJT = ajVar.czI();
            this.jFz = ajVar.czH().cAz();
            this.jJR = false;
            this.jKh = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.jHp) {
                            ImageRequest czH = ajVar.czH();
                            if (l.this.jKd || !com.facebook.common.util.d.s(czH.cAu())) {
                                dVar.setSampleSize(p.b(czH, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.jFz.jGD);
            this.jKb.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czQ() {
                    if (c.this.jKb.czM()) {
                        c.this.jKh.czY();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czO() {
                    if (z) {
                        c.this.czT();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (z && !com.facebook.imagepipeline.f.d.f(dVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(dVar, z)) {
                if (z || this.jKb.czM()) {
                    this.jKh.czY();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void ba(float f) {
            super.ba(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void cyC() {
            czT();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.jKh.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cAx;
            String str4;
            long cAc;
            com.facebook.imagepipeline.f.g cyL;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cyQ = dVar.cyQ();
                if (cyQ != null) {
                    str = cyQ.getName();
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
                if (this.jKb.czH().cAx() != null) {
                    str4 = cAx.width + Config.EVENT_HEAT_X + cAx.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cAc = this.jKh.cAc();
                    int size = z ? dVar.getSize() : g(dVar);
                    cyL = z ? com.facebook.imagepipeline.f.f.jIR : cyL();
                    this.jJT.el(this.jKb.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.jHt.a(dVar, size, cyL, this.jFz);
                    this.jJT.a(this.jKb.getId(), "DecodeProducer", a(a, cAc, cyL, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.jJT.a(this.jKb.getId(), "DecodeProducer", e, a(null, cAc, cyL, z, str, str2, str4, str3));
                    D(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.jJT.FI(this.jKb.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cyV());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cyK = ((com.facebook.imagepipeline.f.c) bVar).cyK();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cyK.getWidth() + Config.EVENT_HEAT_X + cyK.getHeight());
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
            return this.jJR;
        }

        private void rx(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.jJR) {
                        czU().aM(1.0f);
                        this.jJR = true;
                        this.jKh.czX();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                rx(z);
                czU().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void D(Throwable th) {
            rx(true);
            czU().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czT() {
            rx(true);
            czU().ctI();
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
        protected com.facebook.imagepipeline.f.g cyL() {
            return com.facebook.imagepipeline.f.f.f(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d jHz;
        private final com.facebook.imagepipeline.decoder.e jKf;
        private int jKg;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.jKf = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.jHz = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.jKg = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cyH;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.jKf.a(dVar) && (cyH = this.jKf.cyH()) > this.jKg && cyH >= this.jHz.Cn(this.jKg)) {
                        this.jKg = cyH;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.jKf.cyG();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cyL() {
            return this.jHz.Co(this.jKf.cyH());
        }
    }
}
