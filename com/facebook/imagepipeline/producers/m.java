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
    private final com.facebook.common.memory.a lRQ;
    private final Executor mExecutor;
    private final boolean mbO;
    private final com.facebook.imagepipeline.decoder.b mbR;
    private final com.facebook.imagepipeline.decoder.d mbX;
    private final boolean mck;
    private final aj<com.facebook.imagepipeline.g.e> meD;
    private final boolean meS;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lRQ = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mbR = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.mbX = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.mbO = z;
        this.meS = z2;
        this.meD = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mck = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.G(akVar.dtT().duL())) {
            bVar = new a(kVar, akVar, this.mck);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lRQ), this.mbX, this.mck);
        }
        this.meD.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mad;
        @GuardedBy("this")
        private boolean meE;
        private final am meF;
        private final ak meQ;
        private final JobScheduler meW;

        protected abstract com.facebook.imagepipeline.g.h dsO();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.meQ = akVar;
            this.meF = akVar.dtU();
            this.mad = akVar.dtT().duP();
            this.meE = false;
            this.meW = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.mbO || !com.facebook.imagepipeline.producers.b.dl(i, 16)) {
                            ImageRequest dtT = akVar.dtT();
                            if (m.this.meS || !com.facebook.common.util.d.G(dtT.duL())) {
                                eVar.setSampleSize(q.a(dtT, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mad.maY);
            this.meQ.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dub() {
                    if (c.this.meQ.dtY()) {
                        c.this.meW.dum();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqk() {
                    if (z) {
                        c.this.due();
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
                if (Hr || dl || this.meQ.dtY()) {
                    this.meW.dum();
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
        public void dsD() {
            due();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.meW.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d duN;
            String str2;
            long duq;
            int size;
            com.facebook.imagepipeline.g.h dsO;
            if ((eVar.dsV() == com.facebook.c.b.lYM || !Hs(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dsV = eVar.dsV();
                if (dsV != null) {
                    str = dsV.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Hr = Hr(i);
                boolean z = Hr && !dl(i, 8);
                boolean dl = dl(i, 4);
                if (this.meQ.dtT().duN() != null) {
                    str2 = duN.width + Config.EVENT_HEAT_X + duN.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    duq = this.meW.duq();
                    String valueOf2 = String.valueOf(this.meQ.dtT().duL());
                    if (z || dl) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dsO = (z || dl) ? com.facebook.imagepipeline.g.g.mdy : dsO();
                    this.meF.fi(this.meQ.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.mbR.a(eVar, size, dsO, this.mad);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.meF.a(this.meQ.getId(), "DecodeProducer", a(a, duq, dsO, Hr, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.GW(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, duq, dsO, Hr, str, str3, str2, valueOf);
                    this.meF.a(this.meQ.getId(), "DecodeProducer", e2, a2);
                    this.meF.a(this.meQ.dtT(), eVar, e2, a2);
                    H(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.meF.Ol(this.meQ.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dtb());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dsN = ((com.facebook.imagepipeline.g.d) cVar).dsN();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dsN.getWidth() + Config.EVENT_HEAT_X + dsN.getHeight());
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
            return this.meE;
        }

        private void vO(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.meE) {
                        duf().au(1.0f);
                        this.meE = true;
                        this.meW.dul();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> c = com.facebook.common.references.a.c(cVar);
            try {
                vO(Hr(i));
                duf().h(c, i);
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            }
        }

        private void H(Throwable th) {
            vO(true);
            duf().G(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void due() {
            vO(true);
            duf().dmV();
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
        protected com.facebook.imagepipeline.g.h dsO() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d mbX;
        private final com.facebook.imagepipeline.decoder.e meU;
        private int meV;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.meU = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.mbX = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.meV = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Hs(i) || dl(i, 8)) && !dl(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dsV() == com.facebook.c.b.lYM) {
                if (this.meU.a(eVar)) {
                    int dsI = this.meU.dsI();
                    if (dsI <= this.meV) {
                        b = false;
                    } else if (dsI >= this.mbX.GP(this.meV) || this.meU.dsJ()) {
                        this.meV = dsI;
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
            return this.meU.dsH();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dsO() {
            return this.mbX.GQ(this.meU.dsI());
        }
    }
}
