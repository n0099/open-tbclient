package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.mobstat.Config;
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
/* loaded from: classes4.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a mRb;
    private final boolean nbc;
    private final com.facebook.imagepipeline.decoder.b nbf;
    private final com.facebook.imagepipeline.decoder.d nbl;
    private final boolean nby;
    private final aj<com.facebook.imagepipeline.g.e> ndT;
    private final boolean nei;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mRb = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nbf = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.nbl = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.nbc = z;
        this.nei = z2;
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nby = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.I(akVar.dJo().dKg())) {
            bVar = new a(kVar, akVar, this.nby);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.mRb), this.nbl, this.nby);
        }
        this.ndT.c(bVar, akVar);
    }

    /* loaded from: classes4.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mZu;
        @GuardedBy("this")
        private boolean ndU;
        private final am ndV;
        private final ak neg;
        private final JobScheduler nem;

        protected abstract com.facebook.imagepipeline.g.h dIk();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.neg = akVar;
            this.ndV = akVar.dJp();
            this.mZu = akVar.dJo().dKk();
            this.ndU = false;
            this.nem = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.nbc || !com.facebook.imagepipeline.producers.b.dB(i, 16)) {
                            ImageRequest dJo = akVar.dJo();
                            if (m.this.nei || !com.facebook.common.util.d.I(dJo.dKg())) {
                                eVar.setSampleSize(q.a(dJo, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mZu.nam);
            this.neg.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJw() {
                    if (c.this.neg.dJt()) {
                        c.this.nem.dJH();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFG() {
                    if (z) {
                        c.this.dJz();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean JH = JH(i);
            if (JH && !com.facebook.imagepipeline.g.e.f(eVar)) {
                G(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dB = dB(i, 4);
                if (JH || dB || this.neg.dJt()) {
                    this.nem.dJH();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aM(float f) {
            super.aM(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void E(Throwable th) {
            G(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dHZ() {
            dJz();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.nem.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dKi;
            String str2;
            long dJL;
            int size;
            com.facebook.imagepipeline.g.h dIk;
            if ((eVar.dIr() == com.facebook.c.b.mYf || !JI(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dIr = eVar.dIr();
                if (dIr != null) {
                    str = dIr.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean JH = JH(i);
                boolean z = JH && !dB(i, 8);
                boolean dB = dB(i, 4);
                if (this.neg.dJo().dKi() != null) {
                    str2 = dKi.width + Config.EVENT_HEAT_X + dKi.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dJL = this.nem.dJL();
                    String valueOf2 = String.valueOf(this.neg.dJo().dKg());
                    if (z || dB) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dIk = (z || dB) ? com.facebook.imagepipeline.g.g.ncO : dIk();
                    this.ndV.fW(this.neg.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.nbf.a(eVar, size, dIk, this.mZu);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.ndV.a(this.neg.getId(), "DecodeProducer", a(a, dJL, dIk, JH, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Jm(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dJL, dIk, JH, str, str3, str2, valueOf);
                    this.ndV.a(this.neg.getId(), "DecodeProducer", e2, a2);
                    this.ndV.a(this.neg.dJo(), eVar, e2, a2);
                    G(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.ndV.RB(this.neg.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dIx());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dIj = ((com.facebook.imagepipeline.g.d) cVar).dIj();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dIj.getWidth() + Config.EVENT_HEAT_X + dIj.getHeight());
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
            return this.ndU;
        }

        private void xp(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.ndU) {
                        dJA().ax(1.0f);
                        this.ndU = true;
                        this.nem.dJG();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                xp(JH(i));
                dJA().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void G(Throwable th) {
            xp(true);
            dJA().F(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJz() {
            xp(true);
            dJA().dCt();
        }
    }

    /* loaded from: classes4.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return JI(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dIk() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d nbl;
        private final com.facebook.imagepipeline.decoder.e nek;
        private int nel;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.nek = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.nbl = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.nel = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((JI(i) || dB(i, 8)) && !dB(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dIr() == com.facebook.c.b.mYf) {
                if (this.nek.a(eVar)) {
                    int dIe = this.nek.dIe();
                    if (dIe <= this.nel) {
                        b = false;
                    } else if (dIe >= this.nbl.Jf(this.nel) || this.nek.dIf()) {
                        this.nel = dIe;
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
            return this.nek.dId();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dIk() {
            return this.nbl.Jg(this.nek.dIe());
        }
    }
}
