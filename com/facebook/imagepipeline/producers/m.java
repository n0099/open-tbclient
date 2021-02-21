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
/* loaded from: classes5.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final boolean pIZ;
    private final com.facebook.imagepipeline.decoder.b pJc;
    private final com.facebook.imagepipeline.decoder.d pJi;
    private final boolean pJv;
    private final aj<com.facebook.imagepipeline.f.e> pLO;
    private final boolean pMd;
    private final com.facebook.common.memory.a pzE;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pzE = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pJc = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.pJi = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.pIZ = z;
        this.pMd = z2;
        this.pLO = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pJv = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.K(akVar.ezp().eAf())) {
            bVar = new a(kVar, akVar, this.pJv);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.pzE), this.pJi, this.pJv);
        }
        this.pLO.a(bVar, akVar);
    }

    /* loaded from: classes5.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b pHu;
        @GuardedBy("this")
        private boolean pLP;
        private final am pLQ;
        private final ak pMb;
        private final JobScheduler pMh;

        protected abstract com.facebook.imagepipeline.f.h eyp();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.pMb = akVar;
            this.pLQ = akVar.ezq();
            this.pHu = akVar.ezp().eAj();
            this.pLP = false;
            this.pMh = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.pIZ || !com.facebook.imagepipeline.producers.b.ed(i, 16)) {
                            ImageRequest ezp = akVar.ezp();
                            if (m.this.pMd || !com.facebook.common.util.d.K(ezp.eAf())) {
                                eVar.setSampleSize(q.a(ezp, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pHu.pIk);
            this.pMb.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezy() {
                    if (c.this.pMb.ezu()) {
                        c.this.pMh.ezI();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezw() {
                    if (z) {
                        c.this.ezB();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Qk = Qk(i);
            if (Qk && !com.facebook.imagepipeline.f.e.f(eVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ed = ed(i, 4);
                if (Qk || ed || this.pMb.ezu()) {
                    this.pMh.ezI();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bN(float f) {
            super.bN(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void eye() {
            ezB();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.pMh.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d eAh;
            String str2;
            long ezM;
            int size;
            com.facebook.imagepipeline.f.h eyp;
            if ((eVar.eyw() == com.facebook.c.b.pGo || !Ql(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c eyw = eVar.eyw();
                if (eyw != null) {
                    str = eyw.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Qk = Qk(i);
                boolean z = Qk && !ed(i, 8);
                boolean ed = ed(i, 4);
                if (this.pMb.ezp().eAh() != null) {
                    str2 = eAh.width + Config.EVENT_HEAT_X + eAh.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    ezM = this.pMh.ezM();
                    String valueOf2 = String.valueOf(this.pMb.ezp().eAf());
                    if (z || ed) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    eyp = (z || ed) ? com.facebook.imagepipeline.f.g.pKJ : eyp();
                    this.pLQ.hv(this.pMb.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.pJc.a(eVar, size, eyp, this.pHu);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.pLQ.b(this.pMb.getId(), "DecodeProducer", a(a2, ezM, eyp, Qk, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.PP(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, ezM, eyp, Qk, str, str3, str2, valueOf);
                    this.pLQ.a(this.pMb.getId(), "DecodeProducer", e2, a3);
                    this.pLQ.a(this.pMb.ezp(), eVar, e2, a3);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.pLQ.ZG(this.pMb.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.eyB());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap eyo = ((com.facebook.imagepipeline.f.d) cVar).eyo();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", eyo.getWidth() + Config.EVENT_HEAT_X + eyo.getHeight());
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
            return this.pLP;
        }

        private void Bw(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.pLP) {
                        ezC().ba(1.0f);
                        this.pLP = true;
                        this.pMh.ezH();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> e = com.facebook.common.references.a.e(cVar);
            try {
                Bw(Qk(i));
                ezC().g(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void D(Throwable th) {
            Bw(true);
            ezC().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ezB() {
            Bw(true);
            ezC().esD();
        }
    }

    /* loaded from: classes5.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Ql(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h eyp() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes5.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d pJi;
        private final com.facebook.imagepipeline.decoder.e pMf;
        private int pMg;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.pMf = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.pJi = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.pMg = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b2;
            b2 = super.b(eVar, i);
            if ((Ql(i) || ed(i, 8)) && !ed(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.eyw() == com.facebook.c.b.pGo) {
                if (this.pMf.a(eVar)) {
                    int eyj = this.pMf.eyj();
                    if (eyj <= this.pMg) {
                        b2 = false;
                    } else if (eyj >= this.pJi.PI(this.pMg) || this.pMf.eyk()) {
                        this.pMg = eyj;
                    } else {
                        b2 = false;
                    }
                } else {
                    b2 = false;
                }
            }
            return b2;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return this.pMf.eyi();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h eyp() {
            return this.pJi.PJ(this.pMf.eyj());
        }
    }
}
