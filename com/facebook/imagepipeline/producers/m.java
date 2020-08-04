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
    private final com.facebook.common.memory.a mRe;
    private final boolean nbA;
    private final boolean nbe;
    private final com.facebook.imagepipeline.decoder.b nbh;
    private final com.facebook.imagepipeline.decoder.d nbn;
    private final aj<com.facebook.imagepipeline.g.e> ndV;
    private final boolean nek;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mRe = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nbh = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.nbn = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.nbe = z;
        this.nek = z2;
        this.ndV = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nbA = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.I(akVar.dJp().dKh())) {
            bVar = new a(kVar, akVar, this.nbA);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.mRe), this.nbn, this.nbA);
        }
        this.ndV.c(bVar, akVar);
    }

    /* loaded from: classes4.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mZw;
        @GuardedBy("this")
        private boolean ndW;
        private final am ndX;
        private final ak nei;
        private final JobScheduler neo;

        protected abstract com.facebook.imagepipeline.g.h dIl();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.nei = akVar;
            this.ndX = akVar.dJq();
            this.mZw = akVar.dJp().dKl();
            this.ndW = false;
            this.neo = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.nbe || !com.facebook.imagepipeline.producers.b.dB(i, 16)) {
                            ImageRequest dJp = akVar.dJp();
                            if (m.this.nek || !com.facebook.common.util.d.I(dJp.dKh())) {
                                eVar.setSampleSize(q.a(dJp, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mZw.nao);
            this.nei.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJx() {
                    if (c.this.nei.dJu()) {
                        c.this.neo.dJI();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFH() {
                    if (z) {
                        c.this.dJA();
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
                if (JH || dB || this.nei.dJu()) {
                    this.neo.dJI();
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
        public void dIa() {
            dJA();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.neo.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dKj;
            String str2;
            long dJM;
            int size;
            com.facebook.imagepipeline.g.h dIl;
            if ((eVar.dIs() == com.facebook.c.b.mYh || !JI(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dIs = eVar.dIs();
                if (dIs != null) {
                    str = dIs.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean JH = JH(i);
                boolean z = JH && !dB(i, 8);
                boolean dB = dB(i, 4);
                if (this.nei.dJp().dKj() != null) {
                    str2 = dKj.width + Config.EVENT_HEAT_X + dKj.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dJM = this.neo.dJM();
                    String valueOf2 = String.valueOf(this.nei.dJp().dKh());
                    if (z || dB) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dIl = (z || dB) ? com.facebook.imagepipeline.g.g.ncQ : dIl();
                    this.ndX.fW(this.nei.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.nbh.a(eVar, size, dIl, this.mZw);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.ndX.a(this.nei.getId(), "DecodeProducer", a(a, dJM, dIl, JH, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Jm(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dJM, dIl, JH, str, str3, str2, valueOf);
                    this.ndX.a(this.nei.getId(), "DecodeProducer", e2, a2);
                    this.ndX.a(this.nei.dJp(), eVar, e2, a2);
                    G(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.ndX.RB(this.nei.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dIy());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dIk = ((com.facebook.imagepipeline.g.d) cVar).dIk();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dIk.getWidth() + Config.EVENT_HEAT_X + dIk.getHeight());
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
            return this.ndW;
        }

        private void xp(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.ndW) {
                        dJB().ax(1.0f);
                        this.ndW = true;
                        this.neo.dJH();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                xp(JH(i));
                dJB().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void G(Throwable th) {
            xp(true);
            dJB().F(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dJA() {
            xp(true);
            dJB().dCu();
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
        protected com.facebook.imagepipeline.g.h dIl() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes4.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d nbn;
        private final com.facebook.imagepipeline.decoder.e nem;
        private int nen;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.nem = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.nbn = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.nen = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((JI(i) || dB(i, 8)) && !dB(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dIs() == com.facebook.c.b.mYh) {
                if (this.nem.a(eVar)) {
                    int dIf = this.nem.dIf();
                    if (dIf <= this.nen) {
                        b = false;
                    } else if (dIf >= this.nbn.Jf(this.nen) || this.nem.dIg()) {
                        this.nen = dIf;
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
            return this.nem.dIe();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dIl() {
            return this.nbn.Jg(this.nem.dIf());
        }
    }
}
