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
    private final com.facebook.common.memory.a ijk;
    private final com.facebook.imagepipeline.decoder.d iqA;
    private final boolean iqP;
    private final boolean iqq;
    private final com.facebook.imagepipeline.decoder.b iqu;
    private final ai<com.facebook.imagepipeline.f.d> isP;
    private final boolean itc;
    private final Executor mExecutor;

    public l(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.ijk = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.iqu = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.iqA = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.iqq = z;
        this.itc = z2;
        this.isP = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.iqP = z3;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        j<com.facebook.imagepipeline.f.d> bVar;
        if (!com.facebook.common.util.d.k(ajVar.bZH().cau())) {
            bVar = new a(jVar, ajVar, this.iqP);
        } else {
            bVar = new b(jVar, ajVar, new com.facebook.imagepipeline.decoder.e(this.ijk), this.iqA, this.iqP);
        }
        this.isP.a(bVar, ajVar);
    }

    /* loaded from: classes2.dex */
    private abstract class c extends m<com.facebook.imagepipeline.f.d, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
        private final com.facebook.imagepipeline.common.a ioA;
        @GuardedBy("this")
        private boolean isQ;
        private final al isS;
        private final aj ita;
        private final JobScheduler itg;

        protected abstract com.facebook.imagepipeline.f.g bYL();

        protected abstract int g(com.facebook.imagepipeline.f.d dVar);

        public c(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final aj ajVar, final boolean z) {
            super(jVar);
            this.ita = ajVar;
            this.isS = ajVar.bZI();
            this.ioA = ajVar.bZH().caz();
            this.isQ = false;
            this.itg = new JobScheduler(l.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.l.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z2) {
                    if (dVar != null) {
                        if (l.this.iqq) {
                            ImageRequest bZH = ajVar.bZH();
                            if (l.this.itc || !com.facebook.common.util.d.k(bZH.cau())) {
                                dVar.setSampleSize(p.b(bZH, dVar));
                            }
                        }
                        c.this.c(dVar, z2);
                    }
                }
            }, this.ioA.ipE);
            this.ita.a(new e() { // from class: com.facebook.imagepipeline.producers.l.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZQ() {
                    if (c.this.ita.bZM()) {
                        c.this.itg.bZY();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bZO() {
                    if (z) {
                        c.this.bZT();
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
                if (z || this.ita.bZM()) {
                    this.itg.bZY();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void aM(float f) {
            super.aM(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void A(Throwable th) {
            C(th);
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        public void bYC() {
            bZT();
        }

        protected boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            return this.itg.e(dVar, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.d dVar, boolean z) {
            String str;
            String str2;
            String str3;
            com.facebook.imagepipeline.common.c cax;
            String str4;
            long cac;
            com.facebook.imagepipeline.f.g bYL;
            if (!isFinished() && com.facebook.imagepipeline.f.d.f(dVar)) {
                com.facebook.c.c bYQ = dVar.bYQ();
                if (bYQ != null) {
                    str = bYQ.getName();
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
                if (this.ita.bZH().cax() != null) {
                    str4 = cax.width + Config.EVENT_HEAT_X + cax.height;
                } else {
                    str4 = "unknown";
                }
                try {
                    cac = this.itg.cac();
                    int size = z ? dVar.getSize() : g(dVar);
                    bYL = z ? com.facebook.imagepipeline.f.f.irP : bYL();
                    this.isS.db(this.ita.getId(), "DecodeProducer");
                    com.facebook.imagepipeline.f.b a = l.this.iqu.a(dVar, size, bYL, this.ioA);
                    this.isS.a(this.ita.getId(), "DecodeProducer", a(a, cac, bYL, z, str, str2, str4, str3));
                    a(a, z);
                } catch (Exception e) {
                    this.isS.a(this.ita.getId(), "DecodeProducer", e, a(null, cac, bYL, z, str, str2, str4, str3));
                    C(e);
                } finally {
                    com.facebook.imagepipeline.f.d.e(dVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.b bVar, long j, com.facebook.imagepipeline.f.g gVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.isS.zo(this.ita.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(gVar.bYV());
            String valueOf3 = String.valueOf(z);
            if (bVar instanceof com.facebook.imagepipeline.f.c) {
                Bitmap bYK = ((com.facebook.imagepipeline.f.c) bVar).bYK();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", bYK.getWidth() + Config.EVENT_HEAT_X + bYK.getHeight());
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
            return this.isQ;
        }

        private void pc(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.isQ) {
                        bZU().az(1.0f);
                        this.isQ = true;
                        this.itg.bZX();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.b bVar, boolean z) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.b> c = com.facebook.common.references.a.c(bVar);
            try {
                pc(z);
                bZU().e(c, z);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            }
        }

        private void C(Throwable th) {
            pc(true);
            bZU().B(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bZT() {
            pc(true);
            bZU().bTP();
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
        protected com.facebook.imagepipeline.f.g bYL() {
            return com.facebook.imagepipeline.f.f.e(0, false, false);
        }
    }

    /* loaded from: classes2.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d iqA;
        private final com.facebook.imagepipeline.decoder.e ite;
        private int itf;

        public b(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(jVar, ajVar, z);
            this.ite = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.iqA = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.itf = 0;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.d dVar, boolean z) {
            int bYH;
            boolean z2 = false;
            synchronized (this) {
                boolean b = super.b(dVar, z);
                if (!z && com.facebook.imagepipeline.f.d.f(dVar)) {
                    if (this.ite.a(dVar) && (bYH = this.ite.bYH()) > this.itf && bYH >= this.iqA.yy(this.itf)) {
                        this.itf = bYH;
                    }
                }
                z2 = b;
            }
            return z2;
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected int g(com.facebook.imagepipeline.f.d dVar) {
            return this.ite.bYG();
        }

        @Override // com.facebook.imagepipeline.producers.l.c
        protected com.facebook.imagepipeline.f.g bYL() {
            return this.iqA.yz(this.ite.bYH());
        }
    }
}
