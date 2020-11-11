package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
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
/* loaded from: classes18.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a oLv;
    private final boolean oVJ;
    private final boolean oVn;
    private final com.facebook.imagepipeline.decoder.b oVq;
    private final com.facebook.imagepipeline.decoder.d oVw;
    private final aj<com.facebook.imagepipeline.g.e> oYc;
    private final boolean oYr;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oLv = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oVq = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.oVw = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.oVn = z;
        this.oYr = z2;
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oVJ = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.eqV().erN())) {
            bVar = new a(kVar, akVar, this.oVJ);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.oLv), this.oVw, this.oVJ);
        }
        this.oYc.c(bVar, akVar);
    }

    /* loaded from: classes18.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b oTF;
        @GuardedBy("this")
        private boolean oYd;
        private final am oYe;
        private final ak oYp;
        private final JobScheduler oYv;

        protected abstract com.facebook.imagepipeline.g.h epR();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.oYp = akVar;
            this.oYe = akVar.eqW();
            this.oTF = akVar.eqV().erR();
            this.oYd = false;
            this.oYv = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.oVn || !com.facebook.imagepipeline.producers.b.dZ(i, 16)) {
                            ImageRequest eqV = akVar.eqV();
                            if (m.this.oYr || !com.facebook.common.util.d.K(eqV.erN())) {
                                eVar.setSampleSize(q.a(eqV, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.oTF.oUx);
            this.oYp.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erd() {
                    if (c.this.oYp.era()) {
                        c.this.oYv.ero();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enm() {
                    if (z) {
                        c.this.erg();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean PI = PI(i);
            if (PI && !com.facebook.imagepipeline.g.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dZ = dZ(i, 4);
                if (PI || dZ || this.oYp.era()) {
                    this.oYv.ero();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void br(float f) {
            super.br(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void D(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void epG() {
            erg();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.oYv.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d erP;
            String str2;
            long ers;
            int size;
            com.facebook.imagepipeline.g.h epR;
            if ((eVar.epY() == com.facebook.c.b.oSq || !PJ(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c epY = eVar.epY();
                if (epY != null) {
                    str = epY.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean PI = PI(i);
                boolean z = PI && !dZ(i, 8);
                boolean dZ = dZ(i, 4);
                if (this.oYp.eqV().erP() != null) {
                    str2 = erP.width + "x" + erP.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    ers = this.oYv.ers();
                    String valueOf2 = String.valueOf(this.oYp.eqV().erN());
                    if (z || dZ) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    epR = (z || dZ) ? com.facebook.imagepipeline.g.g.oWX : epR();
                    this.oYe.gZ(this.oYp.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a2 = m.this.oVq.a(eVar, size, epR, this.oTF);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.oYe.a(this.oYp.getId(), "DecodeProducer", a(a2, ers, epR, PI, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Pn(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, ers, epR, PI, str, str3, str2, valueOf);
                    this.oYe.a(this.oYp.getId(), "DecodeProducer", e2, a3);
                    this.oYe.a(this.oYp.eqV(), eVar, e2, a3);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.oYe.Ym(this.oYp.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.eqe());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap epQ = ((com.facebook.imagepipeline.g.d) cVar).epQ();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", epQ.getWidth() + "x" + epQ.getHeight());
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
            return this.oYd;
        }

        private void Ar(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.oYd) {
                        erh().aN(1.0f);
                        this.oYd = true;
                        this.oYv.ern();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                Ar(PI(i));
                erh().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            Ar(true);
            erh().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void erg() {
            Ar(true);
            erh().ejZ();
        }
    }

    /* loaded from: classes18.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return PJ(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h epR() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes18.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d oVw;
        private final com.facebook.imagepipeline.decoder.e oYt;
        private int oYu;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.oYt = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.oVw = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.oYu = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((PJ(i) || dZ(i, 8)) && !dZ(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.epY() == com.facebook.c.b.oSq) {
                if (this.oYt.a(eVar)) {
                    int epL = this.oYt.epL();
                    if (epL <= this.oYu) {
                        b = false;
                    } else if (epL >= this.oVw.Pg(this.oYu) || this.oYt.epM()) {
                        this.oYu = epL;
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
            return this.oYt.epK();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h epR() {
            return this.oVw.Ph(this.oYt.epL());
        }
    }
}
