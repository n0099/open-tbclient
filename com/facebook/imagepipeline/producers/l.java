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
    private final boolean jGJ;
    private final com.facebook.imagepipeline.decoder.b jGN;
    private final com.facebook.imagepipeline.decoder.d jGT;
    private final boolean jHi;
    private final ai<com.facebook.imagepipeline.f.d> jJk;
    private final boolean jJx;
    private final com.facebook.common.memory.a jzz;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jzz = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jGN = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.jGT = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.jGJ = z;
        this.jJx = z2;
        this.jJk = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHi = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.s(ajVar.czA().cAn())) {
            bVar = new a(jVar, ajVar, this.jHi);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jzz), this.jGT, this.jHi);
        }
        this.jJk.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a jET;
        private final JobScheduler jJB;
        @GuardedBy("this")
        private boolean jJl;
        private final al jJn;
        private final aj jJv;

        protected abstract com.facebook.imagepipeline.f.g cyE();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.jJv = ajVar;
            this.jJn = ajVar.czB();
            this.jET = ajVar.czA().cAs();
            this.jJl = false;
            this.jJB = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.jGJ) {
                            ImageRequest czA = ajVar.czA();
                            if (l.this.jJx || !com.facebook.common.util.d.s(czA.cAn())) {
                                dVar.setSampleSize(p.b(czA, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.jET.jFX);
            this.jJv.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czJ() {
                    if (c.this.jJv.czF()) {
                        c.this.jJB.czR();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czH() {
                    if (z) {
                        c.this.czM();
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
                if (z || this.jJv.czF()) {
                    this.jJB.czR();
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
        public void cyv() {
            czM();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.jJB.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cAq;
            String str4;
            long czV;
            com.facebook.imagepipeline.f.g cyE;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cyJ = dVar.cyJ();
                if (cyJ != null) {
                    str = cyJ.getName();
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
                if (this.jJv.czA().cAq() != null) {
                    str4 = cAq.width + Config.EVENT_HEAT_X + cAq.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    czV = this.jJB.czV();
                    int size = z ? dVar.getSize() : g(dVar);
                    cyE = z ? com.facebook.imagepipeline.f.f.jIl : cyE();
                    this.jJn.em(this.jJv.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.jGN.a(dVar, size, cyE, this.jET);
                    this.jJn.a(this.jJv.getId(), "DecodeProducer", a(a, czV, cyE, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.jJn.a(this.jJv.getId(), "DecodeProducer", e, a(null, czV, cyE, z, str, str2, str4, str3));
                    D(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.jJn.Fy(this.jJv.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cyO());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cyD = ((com.facebook.imagepipeline.f.c) bVar).cyD();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cyD.getWidth() + Config.EVENT_HEAT_X + cyD.getHeight());
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
            return this.jJl;
        }

        private void rx(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.jJl) {
                        czN().aM(1.0f);
                        this.jJl = true;
                        this.jJB.czQ();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                rx(z);
                czN().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void D(Throwable th) {
            rx(true);
            czN().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czM() {
            rx(true);
            czN().ctB();
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
        protected com.facebook.imagepipeline.f.g cyE() {
            return com.facebook.imagepipeline.f.f.f(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d jGT;
        private int jJA;
        private final com.facebook.imagepipeline.decoder.e jJz;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.jJz = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.jGT = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.jJA = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cyA;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.jJz.a(dVar) && (cyA = this.jJz.cyA()) > this.jJA && cyA >= this.jGT.Cd(this.jJA)) {
                        this.jJA = cyA;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.jJz.cyz();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cyE() {
            return this.jGT.Ce(this.jJz.cyA());
        }
    }
}
