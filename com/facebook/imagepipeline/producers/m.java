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
    private final com.facebook.common.memory.a lKw;
    private final boolean lUb;
    private final com.facebook.imagepipeline.decoder.b lUe;
    private final com.facebook.imagepipeline.decoder.d lUk;
    private final boolean lUx;
    private final aj<com.facebook.imagepipeline.g.e> lWS;
    private final boolean lXh;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lKw = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lUe = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lUk = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lUb = z;
        this.lXh = z2;
        this.lWS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lUx = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.C(akVar.drV().dsO())) {
            bVar = new a(kVar, akVar, this.lUx);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lKw), this.lUk, this.lUx);
        }
        this.lWS.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lSt;
        @GuardedBy("this")
        private boolean lWT;
        private final am lWU;
        private final ak lXf;
        private final JobScheduler lXl;

        protected abstract com.facebook.imagepipeline.g.h dqQ();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lXf = akVar;
            this.lWU = akVar.drW();
            this.lSt = akVar.drV().dsS();
            this.lWT = false;
            this.lXl = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lUb || !com.facebook.imagepipeline.producers.b.dB(i, 16)) {
                            ImageRequest drV = akVar.drV();
                            if (m.this.lXh || !com.facebook.common.util.d.C(drV.dsO())) {
                                eVar.setSampleSize(q.a(drV, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lSt.lTm);
            this.lXf.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dsd() {
                    if (c.this.lXf.dsa()) {
                        c.this.lXl.dso();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void don() {
                    if (z) {
                        c.this.dsg();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean IP = IP(i);
            if (IP && !com.facebook.imagepipeline.g.e.f(eVar)) {
                D(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dB = dB(i, 4);
                if (IP || dB || this.lXf.dsa()) {
                    this.lXl.dso();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bs(float f) {
            super.bs(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void B(Throwable th) {
            D(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dqF() {
            dsg();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lXl.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dsQ;
            String str2;
            long dss;
            int size;
            com.facebook.imagepipeline.g.h dqQ;
            if ((eVar.dqX() == com.facebook.c.b.lRh || !IQ(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dqX = eVar.dqX();
                if (dqX != null) {
                    str = dqX.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean IP = IP(i);
                boolean z = IP && !dB(i, 8);
                boolean dB = dB(i, 4);
                if (this.lXf.drV().dsQ() != null) {
                    str2 = dsQ.width + Config.EVENT_HEAT_X + dsQ.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dss = this.lXl.dss();
                    String valueOf2 = String.valueOf(this.lXf.drV().dsO());
                    if (z || dB) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dqQ = (z || dB) ? com.facebook.imagepipeline.g.g.lVN : dqQ();
                    this.lWU.fk(this.lXf.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lUe.a(eVar, size, dqQ, this.lSt);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lWU.a(this.lXf.getId(), "DecodeProducer", a(a, dss, dqQ, IP, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Iu(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dss, dqQ, IP, str, str3, str2, valueOf);
                    this.lWU.a(this.lXf.getId(), "DecodeProducer", e2, a2);
                    this.lWU.a(this.lXf.drV(), eVar, e2, a2);
                    D(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lWU.Pe(this.lXf.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.drd());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dqP = ((com.facebook.imagepipeline.g.d) cVar).dqP();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dqP.getWidth() + Config.EVENT_HEAT_X + dqP.getHeight());
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
            return this.lWT;
        }

        private void vB(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lWT) {
                        dsh().aK(1.0f);
                        this.lWT = true;
                        this.lXl.dsn();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                vB(IP(i));
                dsh().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void D(Throwable th) {
            vB(true);
            dsh().C(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dsg() {
            vB(true);
            dsh().dlc();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return IQ(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dqQ() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lUk;
        private final com.facebook.imagepipeline.decoder.e lXj;
        private int lXk;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lXj = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lUk = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lXk = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((IQ(i) || dB(i, 8)) && !dB(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dqX() == com.facebook.c.b.lRh) {
                if (this.lXj.a(eVar)) {
                    int dqK = this.lXj.dqK();
                    if (dqK <= this.lXk) {
                        b = false;
                    } else if (dqK >= this.lUk.In(this.lXk) || this.lXj.dqL()) {
                        this.lXk = dqK;
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
            return this.lXj.dqJ();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dqQ() {
            return this.lUk.Io(this.lXj.dqK());
        }
    }
}
