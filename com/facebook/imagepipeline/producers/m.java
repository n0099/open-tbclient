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
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a pch;
    private final boolean plF;
    private final com.facebook.imagepipeline.decoder.b plI;
    private final com.facebook.imagepipeline.decoder.d plO;
    private final boolean pmb;
    private final boolean poM;
    private final aj<com.facebook.imagepipeline.f.e> pox;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pch = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.plI = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.plO = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.plF = z;
        this.poM = z2;
        this.pox = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pmb = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.f.e> bVar;
        if (!com.facebook.common.util.d.M(akVar.ewv().exl())) {
            bVar = new a(kVar, akVar, this.pmb);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.pch), this.plO, this.pmb);
        }
        this.pox.a(bVar, akVar);
    }

    /* loaded from: classes15.dex */
    private abstract class c extends n<com.facebook.imagepipeline.f.e, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b pjY;
        private final ak poK;
        private final JobScheduler poQ;
        @GuardedBy("this")
        private boolean poy;
        private final am poz;

        protected abstract com.facebook.imagepipeline.f.h evu();

        protected abstract int g(com.facebook.imagepipeline.f.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.poK = akVar;
            this.poz = akVar.eww();
            this.pjY = akVar.ewv().exp();
            this.poy = false;
            this.poQ = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.plF || !com.facebook.imagepipeline.producers.b.ef(i, 16)) {
                            ImageRequest ewv = akVar.ewv();
                            if (m.this.poM || !com.facebook.common.util.d.M(ewv.exl())) {
                                eVar.setSampleSize(q.a(ewv, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.pjY.pkP);
            this.poK.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewE() {
                    if (c.this.poK.ewA()) {
                        c.this.poQ.ewO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewC() {
                    if (z) {
                        c.this.ewH();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean Rh = Rh(i);
            if (Rh && !com.facebook.imagepipeline.f.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean ef = ef(i, 4);
                if (Rh || ef || this.poK.ewA()) {
                    this.poQ.ewO();
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
        public void evj() {
            ewH();
        }

        protected boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return this.poQ.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.f.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d exn;
            String str2;
            long ewS;
            int size;
            com.facebook.imagepipeline.f.h evu;
            if ((eVar.evB() == com.facebook.c.b.piS || !Ri(i)) && !isFinished() && com.facebook.imagepipeline.f.e.f(eVar)) {
                com.facebook.c.c evB = eVar.evB();
                if (evB != null) {
                    str = evB.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Rh = Rh(i);
                boolean z = Rh && !ef(i, 8);
                boolean ef = ef(i, 4);
                if (this.poK.ewv().exn() != null) {
                    str2 = exn.width + "x" + exn.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    ewS = this.poQ.ewS();
                    String valueOf2 = String.valueOf(this.poK.ewv().exl());
                    if (z || ef) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    evu = (z || ef) ? com.facebook.imagepipeline.f.g.pnp : evu();
                    this.poz.hh(this.poK.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.f.c a2 = m.this.plI.a(eVar, size, evu, this.pjY);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.poz.a(this.poK.getId(), "DecodeProducer", a(a2, ewS, evu, Rh, str, str3, str2, valueOf));
                        a(a2, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.f.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.QM(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a3 = a(null, ewS, evu, Rh, str, str3, str2, valueOf);
                    this.poz.a(this.poK.getId(), "DecodeProducer", e2, a3);
                    this.poz.a(this.poK.ewv(), eVar, e2, a3);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.f.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.f.c cVar, long j, com.facebook.imagepipeline.f.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.poz.Zq(this.poK.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.evH());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.f.d) {
                Bitmap evt = ((com.facebook.imagepipeline.f.d) cVar).evt();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", evt.getWidth() + "x" + evt.getHeight());
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
            return this.poy;
        }

        private void AZ(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.poy) {
                        ewI().aV(1.0f);
                        this.poy = true;
                        this.poQ.ewN();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.f.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.f.c> e = com.facebook.common.references.a.e(cVar);
            try {
                AZ(Rh(i));
                ewI().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            AZ(true);
            ewI().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ewH() {
            AZ(true);
            ewI().epM();
        }
    }

    /* loaded from: classes15.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            return Ri(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evu() {
            return com.facebook.imagepipeline.f.g.k(0, false, false);
        }
    }

    /* loaded from: classes15.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d plO;
        private final com.facebook.imagepipeline.decoder.e poO;
        private int poP;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.poO = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.plO = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.poP = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.f.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Ri(i) || ef(i, 8)) && !ef(i, 4) && com.facebook.imagepipeline.f.e.f(eVar) && eVar.evB() == com.facebook.c.b.piS) {
                if (this.poO.a(eVar)) {
                    int evo = this.poO.evo();
                    if (evo <= this.poP) {
                        b = false;
                    } else if (evo >= this.plO.QF(this.poP) || this.poO.evp()) {
                        this.poP = evo;
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
        protected int g(com.facebook.imagepipeline.f.e eVar) {
            return this.poO.evn();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.f.h evu() {
            return this.plO.QG(this.poO.evo());
        }
    }
}
