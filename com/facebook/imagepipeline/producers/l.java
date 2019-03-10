package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
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
    private final com.facebook.common.memory.a jAn;
    private final com.facebook.imagepipeline.decoder.b jHB;
    private final com.facebook.imagepipeline.decoder.d jHH;
    private final boolean jHW;
    private final boolean jHx;
    private final ai<com.facebook.imagepipeline.f.d> jJY;
    private final boolean jKl;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jAn = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jHB = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.jHH = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.jHx = z;
        this.jKl = z2;
        this.jJY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHW = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.s(ajVar.czE().cAr())) {
            bVar = new a(jVar, ajVar, this.jHW);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.jAn), this.jHH, this.jHW);
        }
        this.jJY.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a jFH;
        @GuardedBy("this")
        private boolean jJZ;
        private final al jKb;
        private final aj jKj;
        private final JobScheduler jKp;

        protected abstract com.facebook.imagepipeline.f.g cyI();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.jKj = ajVar;
            this.jKb = ajVar.czF();
            this.jFH = ajVar.czE().cAw();
            this.jJZ = false;
            this.jKp = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.jHx) {
                            ImageRequest czE = ajVar.czE();
                            if (l.this.jKl || !com.facebook.common.util.d.s(czE.cAr())) {
                                dVar.setSampleSize(p.b(czE, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.jFH.jGL);
            this.jKj.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czN() {
                    if (c.this.jKj.czJ()) {
                        c.this.jKp.czV();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czL() {
                    if (z) {
                        c.this.czQ();
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
                if (z || this.jKj.czJ()) {
                    this.jKp.czV();
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
        public void cyz() {
            czQ();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.jKp.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cAu;
            String str4;
            long czZ;
            com.facebook.imagepipeline.f.g cyI;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c cyN = dVar.cyN();
                if (cyN != null) {
                    str = cyN.getName();
                } else {
                    str = "unknown";
                }
                if (dVar != null) {
                    str2 = dVar.getWidth() + "x" + dVar.getHeight();
                    str3 = String.valueOf(dVar.getSampleSize());
                } else {
                    str2 = "unknown";
                    str3 = "unknown";
                }
                if (this.jKj.czE().cAu() != null) {
                    str4 = cAu.width + "x" + cAu.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    czZ = this.jKp.czZ();
                    int size = z ? dVar.getSize() : g(dVar);
                    cyI = z ? com.facebook.imagepipeline.f.f.jIZ : cyI();
                    this.jKb.em(this.jKj.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.jHB.a(dVar, size, cyI, this.jFH);
                    this.jKb.a(this.jKj.getId(), "DecodeProducer", a(a, czZ, cyI, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.jKb.a(this.jKj.getId(), "DecodeProducer", e, a(null, czZ, cyI, z, str, str2, str4, str3));
                    D(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.jKb.FK(this.jKj.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.cyS());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap cyH = ((com.facebook.imagepipeline.f.c) bVar).cyH();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", cyH.getWidth() + "x" + cyH.getHeight());
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
            return this.jJZ;
        }

        private void rx(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.jJZ) {
                        czR().aM(1.0f);
                        this.jJZ = true;
                        this.jKp.czU();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> d = com.facebook.common.references.a.d(bVar);
            try {
                rx(z);
                czR().e(d, z);
            } finally {
                com.facebook.common.references.a.c(d);
            }
        }

        private void D(Throwable th) {
            rx(true);
            czR().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void czQ() {
            rx(true);
            czR().ctF();
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
        protected com.facebook.imagepipeline.f.g cyI() {
            return com.facebook.imagepipeline.f.f.f(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d jHH;
        private final com.facebook.imagepipeline.decoder.e jKn;
        private int jKo;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.jKn = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.jHH = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.jKo = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int cyE;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.jKn.a(dVar) && (cyE = this.jKn.cyE()) > this.jKo && cyE >= this.jHH.Cn(this.jKo)) {
                        this.jKo = cyE;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.jKn.cyD();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g cyI() {
            return this.jHH.Co(this.jKn.cyE());
        }
    }
}
