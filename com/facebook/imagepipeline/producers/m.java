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
/* loaded from: classes10.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.common.memory.a lHW;
    private final boolean lRB;
    private final com.facebook.imagepipeline.decoder.b lRE;
    private final com.facebook.imagepipeline.decoder.d lRK;
    private final boolean lRX;
    private final boolean lUH;
    private final aj<com.facebook.imagepipeline.g.e> lUs;
    private final Executor mExecutor;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lHW = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lRE = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.lRK = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.lRB = z;
        this.lUH = z2;
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lRX = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.B(akVar.dqj().drc())) {
            bVar = new a(kVar, akVar, this.lRX);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.lHW), this.lRK, this.lRX);
        }
        this.lUs.c(bVar, akVar);
    }

    /* loaded from: classes10.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b lPT;
        private final ak lUF;
        private final JobScheduler lUL;
        @GuardedBy("this")
        private boolean lUt;
        private final am lUu;

        protected abstract com.facebook.imagepipeline.g.h dpe();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.lUF = akVar;
            this.lUu = akVar.dqk();
            this.lPT = akVar.dqj().drg();
            this.lUt = false;
            this.lUL = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.lRB || !com.facebook.imagepipeline.producers.b.dx(i, 16)) {
                            ImageRequest dqj = akVar.dqj();
                            if (m.this.lUH || !com.facebook.common.util.d.B(dqj.drc())) {
                                eVar.setSampleSize(q.a(dqj, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.lPT.lQM);
            this.lUF.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqr() {
                    if (c.this.lUF.dqo()) {
                        c.this.lUL.dqC();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmA() {
                    if (z) {
                        c.this.dqu();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean IE = IE(i);
            if (IE && !com.facebook.imagepipeline.g.e.f(eVar)) {
                E(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dx = dx(i, 4);
                if (IE || dx || this.lUF.dqo()) {
                    this.lUL.dqC();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void bt(float f) {
            super.bt(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void C(Throwable th) {
            E(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void doT() {
            dqu();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.lUL.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dre;
            String str2;
            long dqG;
            int size;
            com.facebook.imagepipeline.g.h dpe;
            if ((eVar.dpl() == com.facebook.c.b.lOH || !IF(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dpl = eVar.dpl();
                if (dpl != null) {
                    str = dpl.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean IE = IE(i);
                boolean z = IE && !dx(i, 8);
                boolean dx = dx(i, 4);
                if (this.lUF.dqj().dre() != null) {
                    str2 = dre.width + Config.EVENT_HEAT_X + dre.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dqG = this.lUL.dqG();
                    String valueOf2 = String.valueOf(this.lUF.dqj().drc());
                    if (z || dx) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dpe = (z || dx) ? com.facebook.imagepipeline.g.g.lTn : dpe();
                    this.lUu.fe(this.lUF.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.lRE.a(eVar, size, dpe, this.lPT);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.lUu.a(this.lUF.getId(), "DecodeProducer", a(a, dqG, dpe, IE, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.g("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.Ij(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dqG, dpe, IE, str, str3, str2, valueOf);
                    this.lUu.a(this.lUF.getId(), "DecodeProducer", e2, a2);
                    this.lUu.a(this.lUF.dqj(), eVar, e2, a2);
                    E(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.lUu.OQ(this.lUF.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dpr());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dpd = ((com.facebook.imagepipeline.g.d) cVar).dpd();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dpd.getWidth() + Config.EVENT_HEAT_X + dpd.getHeight());
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
            return this.lUt;
        }

        private void vq(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.lUt) {
                        dqv().aL(1.0f);
                        this.lUt = true;
                        this.lUL.dqB();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> b = com.facebook.common.references.a.b(cVar);
            try {
                vq(IE(i));
                dqv().g(b, i);
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }

        private void E(Throwable th) {
            vq(true);
            dqv().D(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dqu() {
            vq(true);
            dqv().djp();
        }
    }

    /* loaded from: classes10.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return IF(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dpe() {
            return com.facebook.imagepipeline.g.g.k(0, false, false);
        }
    }

    /* loaded from: classes10.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d lRK;
        private final com.facebook.imagepipeline.decoder.e lUJ;
        private int lUK;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.lUJ = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.lRK = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.lUK = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((IF(i) || dx(i, 8)) && !dx(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dpl() == com.facebook.c.b.lOH) {
                if (this.lUJ.a(eVar)) {
                    int doY = this.lUJ.doY();
                    if (doY <= this.lUK) {
                        b = false;
                    } else if (doY >= this.lRK.Ic(this.lUK) || this.lUJ.doZ()) {
                        this.lUK = doY;
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
            return this.lUJ.doX();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dpe() {
            return this.lRK.Id(this.lUJ.doY());
        }
    }
}
