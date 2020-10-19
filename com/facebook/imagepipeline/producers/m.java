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
    private final com.facebook.common.memory.a nKJ;
    private final boolean nUC;
    private final com.facebook.imagepipeline.decoder.b nUF;
    private final com.facebook.imagepipeline.decoder.d nUL;
    private final boolean nUY;
    private final boolean nXG;
    private final aj<com.facebook.imagepipeline.g.e> nXr;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nKJ = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nUF = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.nUL = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.nUC = z;
        this.nXG = z2;
        this.nXr = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nUY = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.edg().edY())) {
            bVar = new a(kVar, akVar, this.nUY);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.nKJ), this.nUL, this.nUY);
        }
        this.nXr.c(bVar, akVar);
    }

    /* loaded from: classes18.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b nSU;
        private final ak nXE;
        private final JobScheduler nXK;
        @GuardedBy("this")
        private boolean nXs;
        private final am nXt;

        protected abstract com.facebook.imagepipeline.g.h ecc();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.nXE = akVar;
            this.nXt = akVar.edh();
            this.nSU = akVar.edg().eec();
            this.nXs = false;
            this.nXK = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.nUC || !com.facebook.imagepipeline.producers.b.dN(i, 16)) {
                            ImageRequest edg = akVar.edg();
                            if (m.this.nXG || !com.facebook.common.util.d.K(edg.edY())) {
                                eVar.setSampleSize(q.a(edg, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.nSU.nTM);
            this.nXE.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void edo() {
                    if (c.this.nXE.edl()) {
                        c.this.nXK.edz();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZy() {
                    if (z) {
                        c.this.edr();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Nw = Nw(i);
            if (Nw && !com.facebook.imagepipeline.g.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dN = dN(i, 4);
                if (Nw || dN || this.nXE.edl()) {
                    this.nXK.edz();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aY(float f) {
            super.aY(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void D(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void ebR() {
            edr();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.nXK.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d eea;
            String str2;
            long edD;
            int size;
            com.facebook.imagepipeline.g.h ecc;
            if ((eVar.ecj() == com.facebook.c.b.nRF || !Nx(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c ecj = eVar.ecj();
                if (ecj != null) {
                    str = ecj.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Nw = Nw(i);
                boolean z = Nw && !dN(i, 8);
                boolean dN = dN(i, 4);
                if (this.nXE.edg().eea() != null) {
                    str2 = eea.width + "x" + eea.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    edD = this.nXK.edD();
                    String valueOf2 = String.valueOf(this.nXE.edg().edY());
                    if (z || dN) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    ecc = (z || dN) ? com.facebook.imagepipeline.g.g.nWm : ecc();
                    this.nXt.gH(this.nXE.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a2 = m.this.nUF.a(eVar, size, ecc, this.nSU);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.nXt.a(this.nXE.getId(), "DecodeProducer", a(a2, edD, ecc, Nw, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Nb(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, edD, ecc, Nw, str, str3, str2, valueOf);
                    this.nXt.a(this.nXE.getId(), "DecodeProducer", e2, a3);
                    this.nXt.a(this.nXE.edg(), eVar, e2, a3);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.nXt.VV(this.nXE.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.ecp());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap ecb = ((com.facebook.imagepipeline.g.d) cVar).ecb();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", ecb.getWidth() + "x" + ecb.getHeight());
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
            return this.nXs;
        }

        private void yY(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.nXs) {
                        eds().aJ(1.0f);
                        this.nXs = true;
                        this.nXK.edy();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                yY(Nw(i));
                eds().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            yY(true);
            eds().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void edr() {
            yY(true);
            eds().dWm();
        }
    }

    /* loaded from: classes18.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Nx(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h ecc() {
            return com.facebook.imagepipeline.g.g.j(0, false, false);
        }
    }

    /* loaded from: classes18.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d nUL;
        private final com.facebook.imagepipeline.decoder.e nXI;
        private int nXJ;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.nXI = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.nUL = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.nXJ = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Nx(i) || dN(i, 8)) && !dN(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.ecj() == com.facebook.c.b.nRF) {
                if (this.nXI.a(eVar)) {
                    int ebW = this.nXI.ebW();
                    if (ebW <= this.nXJ) {
                        b = false;
                    } else if (ebW >= this.nUL.MU(this.nXJ) || this.nXI.ebX()) {
                        this.nXJ = ebW;
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
            return this.nXI.ebV();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h ecc() {
            return this.nUL.MV(this.nXI.ebW());
        }
    }
}
