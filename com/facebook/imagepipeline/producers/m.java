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
    private final com.facebook.common.memory.a oCc;
    private final boolean oLU;
    private final com.facebook.imagepipeline.decoder.b oLX;
    private final com.facebook.imagepipeline.decoder.d oMd;
    private final boolean oMq;
    private final aj<com.facebook.imagepipeline.g.e> oOJ;
    private final boolean oOY;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oCc = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oLX = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.oMd = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.oLU = z;
        this.oOY = z2;
        this.oOJ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oMq = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.enf().enX())) {
            bVar = new a(kVar, akVar, this.oMq);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.oCc), this.oMd, this.oMq);
        }
        this.oOJ.c(bVar, akVar);
    }

    /* loaded from: classes18.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b oKm;
        @GuardedBy("this")
        private boolean oOK;
        private final am oOL;
        private final ak oOW;
        private final JobScheduler oPc;

        protected abstract com.facebook.imagepipeline.g.h ema();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.oOW = akVar;
            this.oOL = akVar.eng();
            this.oKm = akVar.enf().eob();
            this.oOK = false;
            this.oPc = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.oLU || !com.facebook.imagepipeline.producers.b.dW(i, 16)) {
                            ImageRequest enf = akVar.enf();
                            if (m.this.oOY || !com.facebook.common.util.d.K(enf.enX())) {
                                eVar.setSampleSize(q.a(enf, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.oKm.oLe);
            this.oOW.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enn() {
                    if (c.this.oOW.enk()) {
                        c.this.oPc.eny();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ejw() {
                    if (z) {
                        c.this.enq();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Pn = Pn(i);
            if (Pn && !com.facebook.imagepipeline.g.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dW = dW(i, 4);
                if (Pn || dW || this.oOW.enk()) {
                    this.oPc.eny();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bp(float f) {
            super.bp(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void D(Throwable th) {
            F(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void elP() {
            enq();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.oPc.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d enZ;
            String str2;
            long enC;
            int size;
            com.facebook.imagepipeline.g.h ema;
            if ((eVar.emh() == com.facebook.c.b.oIX || !Po(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c emh = eVar.emh();
                if (emh != null) {
                    str = emh.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Pn = Pn(i);
                boolean z = Pn && !dW(i, 8);
                boolean dW = dW(i, 4);
                if (this.oOW.enf().enZ() != null) {
                    str2 = enZ.width + "x" + enZ.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    enC = this.oPc.enC();
                    String valueOf2 = String.valueOf(this.oOW.enf().enX());
                    if (z || dW) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    ema = (z || dW) ? com.facebook.imagepipeline.g.g.oNE : ema();
                    this.oOL.gX(this.oOW.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a2 = m.this.oLX.a(eVar, size, ema, this.oKm);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.oOL.a(this.oOW.getId(), "DecodeProducer", a(a2, enC, ema, Pn, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.OS(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, enC, ema, Pn, str, str3, str2, valueOf);
                    this.oOL.a(this.oOW.getId(), "DecodeProducer", e2, a3);
                    this.oOL.a(this.oOW.enf(), eVar, e2, a3);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.oOL.XI(this.oOW.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.emn());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap elZ = ((com.facebook.imagepipeline.g.d) cVar).elZ();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", elZ.getWidth() + "x" + elZ.getHeight());
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
            return this.oOK;
        }

        private void Ag(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.oOK) {
                        enr().aL(1.0f);
                        this.oOK = true;
                        this.oPc.enx();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                Ag(Pn(i));
                enr().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            Ag(true);
            enr().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void enq() {
            Ag(true);
            enr().egk();
        }
    }

    /* loaded from: classes18.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Po(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h ema() {
            return com.facebook.imagepipeline.g.g.j(0, false, false);
        }
    }

    /* loaded from: classes18.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d oMd;
        private final com.facebook.imagepipeline.decoder.e oPa;
        private int oPb;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.oPa = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.oMd = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.oPb = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Po(i) || dW(i, 8)) && !dW(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.emh() == com.facebook.c.b.oIX) {
                if (this.oPa.a(eVar)) {
                    int elU = this.oPa.elU();
                    if (elU <= this.oPb) {
                        b = false;
                    } else if (elU >= this.oMd.OL(this.oPb) || this.oPa.elV()) {
                        this.oPb = elU;
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
            return this.oPa.elT();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h ema() {
            return this.oMd.OM(this.oPa.elU());
        }
    }
}
