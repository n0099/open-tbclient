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
/* loaded from: classes25.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final boolean nFF;
    private final boolean nFj;
    private final com.facebook.imagepipeline.decoder.b nFm;
    private final com.facebook.imagepipeline.decoder.d nFs;
    private final aj<com.facebook.imagepipeline.g.e> nIa;
    private final boolean nIp;
    private final com.facebook.common.memory.a nvq;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nvq = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nFm = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.nFs = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.nFj = z;
        this.nIp = z2;
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nFF = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.dZv().ean())) {
            bVar = new a(kVar, akVar, this.nFF);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.nvq), this.nFs, this.nFF);
        }
        this.nIa.c(bVar, akVar);
    }

    /* loaded from: classes25.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b nDB;
        @GuardedBy("this")
        private boolean nIb;
        private final am nIc;
        private final ak nIn;
        private final JobScheduler nIt;

        protected abstract com.facebook.imagepipeline.g.h dYr();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.nIn = akVar;
            this.nIc = akVar.dZw();
            this.nDB = akVar.dZv().ear();
            this.nIb = false;
            this.nIt = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.nFj || !com.facebook.imagepipeline.producers.b.dN(i, 16)) {
                            ImageRequest dZv = akVar.dZv();
                            if (m.this.nIp || !com.facebook.common.util.d.K(dZv.ean())) {
                                eVar.setSampleSize(q.a(dZv, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.nDB.nEt);
            this.nIn.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZD() {
                    if (c.this.nIn.dZA()) {
                        c.this.nIt.dZO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVN() {
                    if (z) {
                        c.this.dZG();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean MQ = MQ(i);
            if (MQ && !com.facebook.imagepipeline.g.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dN = dN(i, 4);
                if (MQ || dN || this.nIn.dZA()) {
                    this.nIt.dZO();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aS(float f) {
            super.aS(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void D(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dYg() {
            dZG();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.nIt.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d eap;
            String str2;
            long dZS;
            int size;
            com.facebook.imagepipeline.g.h dYr;
            if ((eVar.dYy() == com.facebook.c.b.nCm || !MR(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dYy = eVar.dYy();
                if (dYy != null) {
                    str = dYy.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean MQ = MQ(i);
                boolean z = MQ && !dN(i, 8);
                boolean dN = dN(i, 4);
                if (this.nIn.dZv().eap() != null) {
                    str2 = eap.width + "x" + eap.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dZS = this.nIt.dZS();
                    String valueOf2 = String.valueOf(this.nIn.dZv().ean());
                    if (z || dN) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dYr = (z || dN) ? com.facebook.imagepipeline.g.g.nGV : dYr();
                    this.nIc.gA(this.nIn.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.nFm.a(eVar, size, dYr, this.nDB);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.nIc.a(this.nIn.getId(), "DecodeProducer", a(a, dZS, dYr, MQ, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Mv(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dZS, dYr, MQ, str, str3, str2, valueOf);
                    this.nIc.a(this.nIn.getId(), "DecodeProducer", e2, a2);
                    this.nIc.a(this.nIn.dZv(), eVar, e2, a2);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.nIc.Vh(this.nIn.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dYE());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dYq = ((com.facebook.imagepipeline.g.d) cVar).dYq();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dYq.getWidth() + "x" + dYq.getHeight());
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
            return this.nIb;
        }

        private void yr(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.nIb) {
                        dZH().aD(1.0f);
                        this.nIb = true;
                        this.nIt.dZN();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                yr(MQ(i));
                dZH().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            yr(true);
            dZH().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dZG() {
            yr(true);
            dZH().dSB();
        }
    }

    /* loaded from: classes25.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return MR(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dYr() {
            return com.facebook.imagepipeline.g.g.j(0, false, false);
        }
    }

    /* loaded from: classes25.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d nFs;
        private final com.facebook.imagepipeline.decoder.e nIr;
        private int nIs;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.nIr = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.nFs = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.nIs = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((MR(i) || dN(i, 8)) && !dN(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dYy() == com.facebook.c.b.nCm) {
                if (this.nIr.a(eVar)) {
                    int dYl = this.nIr.dYl();
                    if (dYl <= this.nIs) {
                        b = false;
                    } else if (dYl >= this.nFs.Mo(this.nIs) || this.nIr.dYm()) {
                        this.nIs = dYl;
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
            return this.nIr.dYk();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dYr() {
            return this.nFs.Mp(this.nIr.dYl());
        }
    }
}
