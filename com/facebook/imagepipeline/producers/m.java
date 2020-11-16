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
/* loaded from: classes15.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a oMZ;
    private final boolean oWQ;
    private final com.facebook.imagepipeline.decoder.b oWT;
    private final com.facebook.imagepipeline.decoder.d oWZ;
    private final boolean oXm;
    private final aj<com.facebook.imagepipeline.g.e> oZF;
    private final boolean oZU;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oMZ = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oWT = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.oWZ = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.oWQ = z;
        this.oZU = z2;
        this.oZF = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oXm = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.L(akVar.eqT().erL())) {
            bVar = new a(kVar, akVar, this.oXm);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.oMZ), this.oWZ, this.oXm);
        }
        this.oZF.c(bVar, akVar);
    }

    /* loaded from: classes15.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b oVi;
        @GuardedBy("this")
        private boolean oZG;
        private final am oZH;
        private final ak oZS;
        private final JobScheduler oZY;

        protected abstract com.facebook.imagepipeline.g.h epP();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.oZS = akVar;
            this.oZH = akVar.eqU();
            this.oVi = akVar.eqT().erP();
            this.oZG = false;
            this.oZY = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.oWQ || !com.facebook.imagepipeline.producers.b.ea(i, 16)) {
                            ImageRequest eqT = akVar.eqT();
                            if (m.this.oZU || !com.facebook.common.util.d.L(eqT.erL())) {
                                eVar.setSampleSize(q.a(eqT, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.oVi.oWa);
            this.oZS.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erb() {
                    if (c.this.oZS.eqY()) {
                        c.this.oZY.erm();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enk() {
                    if (z) {
                        c.this.ere();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Ql = Ql(i);
            if (Ql && !com.facebook.imagepipeline.g.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ea = ea(i, 4);
                if (Ql || ea || this.oZS.eqY()) {
                    this.oZY.erm();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void by(float f) {
            super.by(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void D(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void epE() {
            ere();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.oZY.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d erN;
            String str2;
            long erq;
            int size;
            com.facebook.imagepipeline.g.h epP;
            if ((eVar.epW() == com.facebook.c.b.oTT || !Qm(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c epW = eVar.epW();
                if (epW != null) {
                    str = epW.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Ql = Ql(i);
                boolean z = Ql && !ea(i, 8);
                boolean ea = ea(i, 4);
                if (this.oZS.eqT().erN() != null) {
                    str2 = erN.width + "x" + erN.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    erq = this.oZY.erq();
                    String valueOf2 = String.valueOf(this.oZS.eqT().erL());
                    if (z || ea) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    epP = (z || ea) ? com.facebook.imagepipeline.g.g.oYA : epP();
                    this.oZH.gZ(this.oZS.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a2 = m.this.oWT.a(eVar, size, epP, this.oVi);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.oZH.a(this.oZS.getId(), "DecodeProducer", a(a2, erq, epP, Ql, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.PQ(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, erq, epP, Ql, str, str3, str2, valueOf);
                    this.oZH.a(this.oZS.getId(), "DecodeProducer", e2, a3);
                    this.oZH.a(this.oZS.eqT(), eVar, e2, a3);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.oZH.XX(this.oZS.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.eqc());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap epO = ((com.facebook.imagepipeline.g.d) cVar).epO();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", epO.getWidth() + "x" + epO.getHeight());
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
            return this.oZG;
        }

        private void Ay(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.oZG) {
                        erf().aU(1.0f);
                        this.oZG = true;
                        this.oZY.erl();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                Ay(Ql(i));
                erf().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            Ay(true);
            erf().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ere() {
            Ay(true);
            erf().ejX();
        }
    }

    /* loaded from: classes15.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Qm(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h epP() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes15.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d oWZ;
        private final com.facebook.imagepipeline.decoder.e oZW;
        private int oZX;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.oZW = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.oWZ = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.oZX = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Qm(i) || ea(i, 8)) && !ea(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.epW() == com.facebook.c.b.oTT) {
                if (this.oZW.a(eVar)) {
                    int epJ = this.oZW.epJ();
                    if (epJ <= this.oZX) {
                        b = false;
                    } else if (epJ >= this.oWZ.PJ(this.oZX) || this.oZW.epK()) {
                        this.oZX = epJ;
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
            return this.oZW.epI();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h epP() {
            return this.oWZ.PK(this.oZW.epJ());
        }
    }
}
