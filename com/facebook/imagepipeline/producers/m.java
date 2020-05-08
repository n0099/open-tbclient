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
/* loaded from: classes12.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.common.memory.a lRU;
    private final Executor mExecutor;
    private final boolean mbS;
    private final com.facebook.imagepipeline.decoder.b mbV;
    private final com.facebook.imagepipeline.decoder.d mcb;
    private final boolean mco;
    private final aj<com.facebook.imagepipeline.g.e> meH;
    private final boolean meW;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lRU = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mbV = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.mcb = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.mbS = z;
        this.meW = z2;
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mco = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.G(akVar.dtQ().duI())) {
            bVar = new a(kVar, akVar, this.mco);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lRU), this.mcb, this.mco);
        }
        this.meH.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mah;
        @GuardedBy("this")
        private boolean meI;
        private final am meJ;
        private final ak meU;
        private final JobScheduler mfa;

        protected abstract com.facebook.imagepipeline.g.h dsL();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.meU = akVar;
            this.meJ = akVar.dtR();
            this.mah = akVar.dtQ().duM();
            this.meI = false;
            this.mfa = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.mbS || !com.facebook.imagepipeline.producers.b.dl(i, 16)) {
                            ImageRequest dtQ = akVar.dtQ();
                            if (m.this.meW || !com.facebook.common.util.d.G(dtQ.duI())) {
                                eVar.setSampleSize(q.a(dtQ, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mah.mbc);
            this.meU.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dtY() {
                    if (c.this.meU.dtV()) {
                        c.this.mfa.duj();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqh() {
                    if (z) {
                        c.this.dub();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Hr = Hr(i);
            if (Hr && !com.facebook.imagepipeline.g.e.f(eVar)) {
                H(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dl = dl(i, 4);
                if (Hr || dl || this.meU.dtV()) {
                    this.mfa.duj();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aI(float f) {
            super.aI(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void F(Throwable th) {
            H(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dsA() {
            dub();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.mfa.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d duK;
            String str2;
            long dun;
            int size;
            com.facebook.imagepipeline.g.h dsL;
            if ((eVar.dsS() == com.facebook.c.b.lYQ || !Hs(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dsS = eVar.dsS();
                if (dsS != null) {
                    str = dsS.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Hr = Hr(i);
                boolean z = Hr && !dl(i, 8);
                boolean dl = dl(i, 4);
                if (this.meU.dtQ().duK() != null) {
                    str2 = duK.width + Config.EVENT_HEAT_X + duK.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dun = this.mfa.dun();
                    String valueOf2 = String.valueOf(this.meU.dtQ().duI());
                    if (z || dl) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dsL = (z || dl) ? com.facebook.imagepipeline.g.g.mdC : dsL();
                    this.meJ.fi(this.meU.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.mbV.a(eVar, size, dsL, this.mah);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.meJ.a(this.meU.getId(), "DecodeProducer", a(a, dun, dsL, Hr, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.GW(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dun, dsL, Hr, str, str3, str2, valueOf);
                    this.meJ.a(this.meU.getId(), "DecodeProducer", e2, a2);
                    this.meJ.a(this.meU.dtQ(), eVar, e2, a2);
                    H(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.meJ.Oo(this.meU.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dsY());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dsK = ((com.facebook.imagepipeline.g.d) cVar).dsK();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dsK.getWidth() + Config.EVENT_HEAT_X + dsK.getHeight());
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
            return this.meI;
        }

        private void vO(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.meI) {
                        duc().au(1.0f);
                        this.meI = true;
                        this.mfa.dui();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> c = com.facebook.common.references.a.c(cVar);
            try {
                vO(Hr(i));
                duc().h(c, i);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            }
        }

        private void H(Throwable th) {
            vO(true);
            duc().G(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dub() {
            vO(true);
            duc().dmS();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Hs(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dsL() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d mcb;
        private final com.facebook.imagepipeline.decoder.e meY;
        private int meZ;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.meY = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.mcb = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.meZ = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Hs(i) || dl(i, 8)) && !dl(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dsS() == com.facebook.c.b.lYQ) {
                if (this.meY.a(eVar)) {
                    int dsF = this.meY.dsF();
                    if (dsF <= this.meZ) {
                        b = false;
                    } else if (dsF >= this.mcb.GP(this.meZ) || this.meY.dsG()) {
                        this.meZ = dsF;
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
            return this.meY.dsE();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dsL() {
            return this.mcb.GQ(this.meY.dsF());
        }
    }
}
