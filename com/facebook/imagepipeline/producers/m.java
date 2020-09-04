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
/* loaded from: classes8.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a nlq;
    private final boolean nvI;
    private final boolean nvm;
    private final com.facebook.imagepipeline.decoder.b nvp;
    private final com.facebook.imagepipeline.decoder.d nvv;
    private final aj<com.facebook.imagepipeline.g.e> nyd;
    private final boolean nys;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nlq = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nvp = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.nvv = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.nvm = z;
        this.nys = z2;
        this.nyd = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nvI = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.I(akVar.dVx().dWp())) {
            bVar = new a(kVar, akVar, this.nvI);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.nlq), this.nvv, this.nvI);
        }
        this.nyd.c(bVar, akVar);
    }

    /* loaded from: classes8.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b ntD;
        @GuardedBy("this")
        private boolean nye;
        private final am nyf;
        private final ak nyq;
        private final JobScheduler nyw;

        protected abstract com.facebook.imagepipeline.g.h dUt();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.nyq = akVar;
            this.nyf = akVar.dVy();
            this.ntD = akVar.dVx().dWt();
            this.nye = false;
            this.nyw = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.nvm || !com.facebook.imagepipeline.producers.b.dJ(i, 16)) {
                            ImageRequest dVx = akVar.dVx();
                            if (m.this.nys || !com.facebook.common.util.d.I(dVx.dWp())) {
                                eVar.setSampleSize(q.a(dVx, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.ntD.nuw);
            this.nyq.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVF() {
                    if (c.this.nyq.dVC()) {
                        c.this.nyw.dVQ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRP() {
                    if (z) {
                        c.this.dVI();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Ml = Ml(i);
            if (Ml && !com.facebook.imagepipeline.g.e.f(eVar)) {
                F(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dJ = dJ(i, 4);
                if (Ml || dJ || this.nyq.dVC()) {
                    this.nyw.dVQ();
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
        public void dUi() {
            dVI();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.nyw.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dWr;
            String str2;
            long dVU;
            int size;
            com.facebook.imagepipeline.g.h dUt;
            if ((eVar.dUA() == com.facebook.c.b.nso || !Mm(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dUA = eVar.dUA();
                if (dUA != null) {
                    str = dUA.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + "x" + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Ml = Ml(i);
                boolean z = Ml && !dJ(i, 8);
                boolean dJ = dJ(i, 4);
                if (this.nyq.dVx().dWr() != null) {
                    str2 = dWr.width + "x" + dWr.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dVU = this.nyw.dVU();
                    String valueOf2 = String.valueOf(this.nyq.dVx().dWp());
                    if (z || dJ) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dUt = (z || dJ) ? com.facebook.imagepipeline.g.g.nwY : dUt();
                    this.nyf.go(this.nyq.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.nvp.a(eVar, size, dUt, this.ntD);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.nyf.a(this.nyq.getId(), "DecodeProducer", a(a, dVU, dUt, Ml, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.j("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.LQ(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dVU, dUt, Ml, str, str3, str2, valueOf);
                    this.nyf.a(this.nyq.getId(), "DecodeProducer", e2, a2);
                    this.nyf.a(this.nyq.dVx(), eVar, e2, a2);
                    F(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.nyf.UF(this.nyq.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dUG());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dUs = ((com.facebook.imagepipeline.g.d) cVar).dUs();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dUs.getWidth() + "x" + dUs.getHeight());
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
            return this.nye;
        }

        private void yi(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.nye) {
                        dVJ().aD(1.0f);
                        this.nye = true;
                        this.nyw.dVP();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                yi(Ml(i));
                dVJ().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void F(Throwable th) {
            yi(true);
            dVJ().E(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dVI() {
            yi(true);
            dVJ().dOD();
        }
    }

    /* loaded from: classes8.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Mm(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dUt() {
            return com.facebook.imagepipeline.g.g.j(0, false, false);
        }
    }

    /* loaded from: classes8.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d nvv;
        private final com.facebook.imagepipeline.decoder.e nyu;
        private int nyv;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.nyu = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.nvv = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.nyv = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Mm(i) || dJ(i, 8)) && !dJ(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dUA() == com.facebook.c.b.nso) {
                if (this.nyu.a(eVar)) {
                    int dUn = this.nyu.dUn();
                    if (dUn <= this.nyv) {
                        b = false;
                    } else if (dUn >= this.nvv.LJ(this.nyv) || this.nyu.dUo()) {
                        this.nyv = dUn;
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
            return this.nyu.dUm();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dUt() {
            return this.nvv.LK(this.nyu.dUn());
        }
    }
}
